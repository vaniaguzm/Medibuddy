package medibuddy.service;

import medibuddy.model.Actividad;
import medibuddy.model.Fundacion;
import medibuddy.repository.ActividadRepository; // Nuevo
import medibuddy.repository.FundacionRepository;
import java.util.List;

public class FundacionService {

    private final FundacionRepository repository = new FundacionRepository();
    private final ActividadRepository actividadRepository = new ActividadRepository(); // Nuevo

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

    public void crearActividadFundacion(int idFundacion, Actividad actividad) {
        Fundacion fundacion = buscarFundacionPorId(idFundacion);
        if (fundacion != null) {
            fundacion.crearActividad(actividad);
            actividadRepository.save(actividad);
        }
    }
}