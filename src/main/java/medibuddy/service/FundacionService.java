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