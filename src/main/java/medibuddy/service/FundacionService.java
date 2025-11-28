package medibuddy.service;

import medibuddy.model.Actividad;
import medibuddy.model.AdultoMayor;
import medibuddy.model.Fundacion;
import medibuddy.repository.FundacionRepository;
import java.util.List;

public class FundacionService {

    private final FundacionRepository repository = new FundacionRepository();

    public void crearFundacion(Fundacion fundacion) {
        repository.save(fundacion);
    }

    public List<Fundacion> listarFundaciones() {
        return repository.findAll();
    }

    public Fundacion buscarFundacionPorId(int id) {
        return repository.findById(id);
    }

    public void actualizarFundacion(Fundacion fundacion) {
        repository.update(fundacion);
    }

    public void eliminarFundacion(Fundacion fundacion) {
        repository.delete(fundacion);
    }

    public void inscribirAdultoEnActividad(AdultoMayor adulto, Fundacion fundacion) {
        //Buscamos la fundación fresca de la BD para asegurar que la lista de asistentes esté cargada
        Fundacion fRecuperada = repository.findById(fundacion.getId());
        
        if (fRecuperada != null) {
            //Si ya contiene al adulto, lanzamos un error y se detiene todo aquí.
            if (fRecuperada.getAsistentes().contains(adulto)) {
                throw new RuntimeException("⚠️ El adulto " + adulto.getNomUsuario() + " YA está inscrito en esta actividad.");
            }
            
            
            //Guardamos los cambios
            // e inserta el registro en la tabla intermedia automáticamente.
            fRecuperada.agregarAsistente(adulto);
            repository.update(fRecuperada);
            System.out.println("✅ Adulto " + adulto.getNomUsuario() + " inscrito en " + fRecuperada.getNombre());
        } else {
            System.err.println("❌ No se encontró la fundación para inscribir.");
        }
    }

   
    public void removerAdultoDeActividad(AdultoMayor adulto, Fundacion fundacion) {
        // 1. Buscamos la fundación
        Fundacion fRecuperada = repository.findById(fundacion.getId());
        
        if (fRecuperada != null) {
            if (!fRecuperada.getAsistentes().contains(adulto)) {
                throw new RuntimeException("⚠️ El adulto NO está inscrito en esta actividad, no se puede quitar.");
            }

            // Si pasa la validación, borramos
            fRecuperada.removerAsistente(adulto);
            
            // 3. Actualizamos en BD
            repository.update(fRecuperada);
            System.out.println("🗑️ Adulto removido de la actividad en " + fRecuperada.getNombre());
        }
    }
    
    // Método especial para manejar la relación OneToMany
    public void agregarActividadAFundacion(int idFundacion, Actividad actividad) {
        // CAMBIO AQUÍ: Usamos el método específico que trae la colección inicializada
        Fundacion fundacion = repository.buscarPorIdConActividades(idFundacion);
        
        if (fundacion != null) {
            // Ahora la lista está viva y podemos agregarle cosas sin error
            fundacion.agregarActividad(actividad);
            
            actualizarFundacion(fundacion); 
            System.out.println("Actividad agregada exitosamente a: " + fundacion.getNombre());
        } else {
            System.out.println("No se encontró la fundación con ID: " + idFundacion);
        }
    }
}