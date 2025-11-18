package medibuddy.service;

import medibuddy.entity.ActividadEntity;
import medibuddy.repository.ActividadRepository;
import java.util.List;

public class ActividadService {

    private final ActividadRepository actividadRepository;

    public ActividadService() {
        this.actividadRepository = new ActividadRepository();
    }

    public void saveActividad(ActividadEntity actividad) {
        actividadRepository.save(actividad);
    }

    public ActividadEntity getActividad(Long id) {
        return actividadRepository.findById(id);
    }

    public List<ActividadEntity> getAllActividades() {
        return actividadRepository.findAll();
    }

    public void updateActividad(ActividadEntity actividad) {
        actividadRepository.update(actividad);
    }

    public void deleteActividad(Long id) {
        ActividadEntity act = getActividad(id);
        if (act != null) {
            actividadRepository.delete(act);
        }
    }
}