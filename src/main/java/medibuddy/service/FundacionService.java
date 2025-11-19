package medibuddy.service;

import medibuddy.model.Actividad;
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

    // Método especial para manejar la relación OneToMany
    public void agregarActividadAFundacion(int idFundacion, Actividad actividad) {
        Fundacion fundacion = buscarFundacionPorId(idFundacion);
        if (fundacion != null) {
            // Agregamos la actividad a la lista de la fundación (en memoria)
            fundacion.agregarActividad(actividad);
            
            // Al actualizar la fundación, Hibernate detecta la nueva actividad 
            // y la inserta automáticamente en la base de datos.
            actualizarFundacion(fundacion); 
        } else {
            System.out.println("No se encontró la fundación con ID: " + idFundacion);
        }
    }
}