package medibuddy.service;

import medibuddy.entity.Actividad;
import medibuddy.repository.ActividadRepository;
import java.util.List;

public class ActividadService {

    private final ActividadRepository actividadRepository;

    public ActividadService() {
        this.actividadRepository = new ActividadRepository();
    }

    public void saveActividad(Actividad actividad) {
        actividadRepository.save(actividad);
    }

    public Actividad getActividad(Long id) {
        return actividadRepository.findById(id);
    }

    public List<Actividad> getAllActividades() {
        return actividadRepository.findAll();
    }

    public void updateActividad(Actividad actividad) {
        actividadRepository.update(actividad);
    }

    public void deleteActividad(Long id) {
        Actividad act = getActividad(id);
        if (act != null) {
            actividadRepository.delete(act);
        }
    }
}