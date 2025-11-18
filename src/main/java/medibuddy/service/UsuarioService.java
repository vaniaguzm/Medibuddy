package medibuddy.service;

import medibuddy.entity.Actividad;
import medibuddy.entity.AdultoMayor;
import medibuddy.entity.Familiar;
import medibuddy.entity.Usuario;
import medibuddy.repository.ActividadRepository;
import medibuddy.repository.UsuarioRepository;

import java.util.List;

public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final ActividadRepository actividadRepository; // Necesario para lógica de N-a-N

    public UsuarioService() {
        this.usuarioRepository = new UsuarioRepository();
        this.actividadRepository = new ActividadRepository();
    }

    public void saveUsuario(Usuario usuario) {
        usuarioRepository.save(usuario);
    }

    public Usuario getUsuario(Long id) {
        return usuarioRepository.findById(id);
    }

    public List<Usuario> getAllUsuarios() {
        return usuarioRepository.findAll();
    }

    public void updateUsuario(Usuario usuario) {
        usuarioRepository.update(usuario);
    }

    public void deleteUsuario(Long id) {
        Usuario usuario = getUsuario(id);
        if (usuario != null) {
            usuarioRepository.delete(usuario);
        }
    }

    // --- Lógica de Negocio Específica ---

    public void linkFamiliarToAdulto(Long familiarId, Long adultoMayorId) {
        Usuario famUsuario = getUsuario(familiarId);
        Usuario aduUsuario = getUsuario(adultoMayorId);

        if (famUsuario instanceof Familiar && aduUsuario instanceof AdultoMayor) {
            Familiar familiar = (Familiar) famUsuario;
            AdultoMayor adultoMayor = (AdultoMayor) aduUsuario;
            
            familiar.setAdultoMayorAsociado(adultoMayor);
            usuarioRepository.update(familiar);
            System.out.println("Familiar " + familiar.getNombre() + " vinculado a " + adultoMayor.getNombre());
        } else {
            System.err.println("Error: IDs no corresponden a Familiar y AdultoMayor");
        }
    }

    public void addParticipanteActividad(Long adultoMayorId, Long actividadId) {
        Usuario aduUsuario = getUsuario(adultoMayorId);
        Actividad actividad = actividadRepository.findById(actividadId);

        if (aduUsuario instanceof AdultoMayor && actividad != null) {
            AdultoMayor adultoMayor = (AdultoMayor) aduUsuario;

            if (actividad.getParticipantes().contains(adultoMayor)) {
                System.out.println("El usuario ya está inscrito en esta actividad.");
                return;
            }


            if (actividad.getCupoMaximo() != null && 
                actividad.getParticipantes().size() >= actividad.getCupoMaximo()) {
                System.err.println("Error: No se pudo inscribir. Cupo lleno para " + actividad.getNombre());
                return;
            }

            // 3. Inscribir
            actividad.getParticipantes().add(adultoMayor);
            actividadRepository.update(actividad);
            
            System.out.println("Éxito: " + adultoMayor.getNombre() + " inscrito en " + actividad.getNombre());
        } else {
            System.err.println("Error: IDs inválidos.");
        }
    }

    public void removeParticipanteActividad(Long adultoMayorId, Long actividadId) {
        Usuario aduUsuario = getUsuario(adultoMayorId);
        Actividad actividad = actividadRepository.findById(actividadId);

        if (aduUsuario instanceof AdultoMayor && actividad != null) {
            AdultoMayor adultoMayor = (AdultoMayor) aduUsuario;

            if (actividad.getParticipantes().contains(adultoMayor)) {
                actividad.getParticipantes().remove(adultoMayor);
                actividadRepository.update(actividad); // Actualizamos la tabla de unión
                System.out.println("Inscripción cancelada para: " + adultoMayor.getNombre());
            } else {
                System.out.println("El usuario no estaba inscrito en esa actividad.");
            }
        }
    }
}