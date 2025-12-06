package medibuddy.service;

import medibuddy.model.Actividad;
import medibuddy.repository.ActividadRepository;
import java.util.List;

public class ActividadService {
    private final ActividadRepository repository = new ActividadRepository();

    public void crearActividad(Actividad actividad) {
        repository.save(actividad);
    }

    public List<Actividad> listarActividades() {
        return repository.findAll();
    }
    
    public void actualizarActividad(Actividad actividad) {
        repository.update(actividad);
    }

    public Actividad buscarActividadPorId(int id) {
        return repository.findById(id);
    }

    public void eliminarActividad(Actividad actividad) {
        repository.delete(actividad);
    }
}
