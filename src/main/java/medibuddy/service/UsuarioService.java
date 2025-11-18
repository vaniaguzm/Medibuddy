package medibuddy.service;

import medibuddy.entity.ActividadEntity;
import medibuddy.entity.AdultoMayorEntity;
import medibuddy.entity.FamiliarEntity;
import medibuddy.entity.UsuarioEntity;
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

    public void saveUsuario(UsuarioEntity usuario) {
        usuarioRepository.save(usuario);
    }

    public UsuarioEntity getUsuario(Long id) {
        return usuarioRepository.findById(id);
    }

    public List<UsuarioEntity> getAllUsuarios() {
        return usuarioRepository.findAll();
    }

    public void updateUsuario(UsuarioEntity usuario) {
        usuarioRepository.update(usuario);
    }

    public void deleteUsuario(Long id) {
        UsuarioEntity usuario = getUsuario(id);
        if (usuario != null) {
            usuarioRepository.delete(usuario);
        }
    }

    // --- Lógica de Negocio Específica ---

    public void linkFamiliarToAdulto(Long familiarId, Long adultoMayorId) {
        UsuarioEntity famUsuario = getUsuario(familiarId);
        UsuarioEntity aduUsuario = getUsuario(adultoMayorId);

        if (famUsuario instanceof FamiliarEntity && aduUsuario instanceof AdultoMayorEntity) {
            FamiliarEntity familiar = (FamiliarEntity) famUsuario;
            AdultoMayorEntity adultoMayor = (AdultoMayorEntity) aduUsuario;
            
            familiar.setAdultoMayorAsociado(adultoMayor);
            usuarioRepository.update(familiar);
            System.out.println("Familiar " + familiar.getNombre() + " vinculado a " + adultoMayor.getNombre());
        } else {
            System.err.println("Error: IDs no corresponden a Familiar y AdultoMayor");
        }
    }

    public void addParticipanteActividad(Long adultoMayorId, Long actividadId) {
        UsuarioEntity aduUsuario = getUsuario(adultoMayorId);
        ActividadEntity actividad = actividadRepository.findById(actividadId);

        if (aduUsuario instanceof AdultoMayorEntity && actividad != null) {
            AdultoMayorEntity adultoMayor = (AdultoMayorEntity) aduUsuario;

            // Es importante manejar la relación desde la entidad dueña (Actividad)
            actividad.getParticipantes().add(adultoMayor);
            actividadRepository.update(actividad);
            
            System.out.println("AdultoMayor " + adultoMayor.getNombre() + " inscrito en " + actividad.getDescripcion());
        } else {
            System.err.println("Error: IDs no corresponden a AdultoMayor y Actividad");
        }
    }
}