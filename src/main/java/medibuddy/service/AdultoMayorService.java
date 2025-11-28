package medibuddy.service;

import medibuddy.model.Actividad;
import medibuddy.model.AdultoMayor;
import medibuddy.model.Medicamento;
import medibuddy.repository.AdultoMayorRepository;
import medibuddy.repository.ActividadRepository; // Necesitamos buscar la actividad
// Si tienes repositorio de medicamentos, impórtalo también

import java.util.List;

public class AdultoMayorService {

    private final AdultoMayorRepository repository = new AdultoMayorRepository();
    private final ActividadRepository actividadRepository = new ActividadRepository();

    public void crearAdultoMayor(AdultoMayor adultoMayor) {
        repository.save(adultoMayor);
    }

    public List<AdultoMayor> listarAdultosMayores() {
        return repository.findAll();
    }

    public AdultoMayor buscarAdultoMayorPorId(int id) {
        return repository.findById(id);
    }

    public void actualizarAdultoMayor(AdultoMayor adultoMayor) {
        repository.update(adultoMayor);
    }

    public void eliminarAdultoMayor(AdultoMayor adultoMayor) {
        repository.delete(adultoMayor);
    }

    // --- MODIFICADO: Relación Muchos a Muchos con Medicamentos ---
    public void agregarMedicamentoAAdultoMayor(int idAdultoMayor, Medicamento medicamento) {
        AdultoMayor adultoMayor = buscarAdultoMayorPorId(idAdultoMayor);
        if (adultoMayor != null) {
            adultoMayor.agregarMedicamento(medicamento);
            repository.update(adultoMayor); 
        }
    }

    public void inscribirEnActividad(int idAdultoMayor, int idActividad) {
        AdultoMayor adulto = repository.findById(idAdultoMayor);
        Actividad actividad = actividadRepository.findById(idActividad);

        if (adulto != null && actividad != null) {
            adulto.inscribirse(actividad); 
            repository.update(adulto);  
        }
    }
}