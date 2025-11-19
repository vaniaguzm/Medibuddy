package medibuddy.service;

import medibuddy.model.CentroDeAcopio;
import medibuddy.model.Entrega;
import medibuddy.repository.CentroDeAcopioRepository;
import java.util.List;

public class CentroDeAcopioService {

    private final CentroDeAcopioRepository repository = new CentroDeAcopioRepository();

    public void crearCentro(CentroDeAcopio centro) {
        repository.save(centro);
    }

    public List<CentroDeAcopio> listarCentros() {
        return repository.findAll();
    }

    public CentroDeAcopio buscarCentroPorId(int id) {
        return repository.findById(id);
    }

    public void actualizarCentro(CentroDeAcopio centro) {
        repository.update(centro);
    }

    public void eliminarCentro(CentroDeAcopio centro) {
        repository.delete(centro);
    }

    /**
     * Registra una nueva entrega en un centro de acopio específico.
     * Utiliza el método de utilidad de la entidad para mantener la consistencia 
     * bidireccional antes de guardar.
     */
    public void registrarEntregaEnCentro(int idCentro, Entrega entrega) {
        CentroDeAcopio centro = buscarCentroPorId(idCentro);
        if (centro != null) {
            // Lógica de negocio: Asignar y vincular
            // Nota: Asegúrate de que tu entidad CentroDeAcopio tenga el método 'registrarEntrega'
            // que hace: entrega.setCentroDeAcopio(this); y this.entregas.add(entrega);
            centro.registrarEntrega(entrega);
            
            // Al actualizar el centro, Hibernate detecta la nueva entrega y la guarda
            actualizarCentro(centro);
            System.out.println("Entrega registrada exitosamente en " + centro.getNombre());
        } else {
            System.out.println("Error: No se encontró el centro de acopio con ID " + idCentro);
        }
    }
}