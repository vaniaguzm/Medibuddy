package medibuddy.service;

import medibuddy.entity.Actividad;
import medibuddy.entity.Fundacion;
import medibuddy.repository.ActividadRepository;
import medibuddy.repository.FundacionRepository;
import java.util.List;

public class FundacionService {

    private final FundacionRepository fundacionRepository;
    private final ActividadRepository actividadRepository;
    public FundacionService() {
        this.fundacionRepository = new FundacionRepository();
        this.actividadRepository = new ActividadRepository(); 
    }

    public void saveFundacion(Fundacion fundacion) {
        fundacionRepository.save(fundacion);
    }

    public Fundacion getFundacion(Long id) {
        return fundacionRepository.findById(id);
    }

    public List<Fundacion> getAllFundaciones() {
        return fundacionRepository.findAll();
    }

    public void updateFundacion(Fundacion fundacion) {
        fundacionRepository.update(fundacion);
    }

    public void deleteFundacion(Long id) {
        Fundacion fun = getFundacion(id);
        if (fun != null) {
            fundacionRepository.delete(fun);
        }
    }

    public void vincularActividad(Long fundacionId, Long actividadId) {
        Fundacion fundacion = fundacionRepository.findById(fundacionId);
        Actividad actividad = actividadRepository.findById(actividadId);

        if (fundacion != null && actividad != null) {
            // En tu entidad Actividad, tienes la relación 'fundaciones'.
            // Como Actividad es usualmente el "dueño" de la relación en este diseño:
            actividad.getFundaciones().add(fundacion);
            actividadRepository.update(actividad);
            
            System.out.println("Actividad '" + actividad.getNombre() + "' vinculada a la fundación " + fundacion.getNombre());
        } else {
            System.err.println("No se encontró Fundación o Actividad.");
        }
    }
}