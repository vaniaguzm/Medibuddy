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
    
    public void crearEnvio(CentroDeAcopio centro) {
        repository.save(centro);
    }
    
    public CentroDeAcopio buscarEnvioPorId(int id) {
        return repository.findById(id);
    }

    public void actualizarEnvio(CentroDeAcopio centro) {
        repository.update(centro);
    }

    public void eliminarEnvio(CentroDeAcopio centro) {
        repository.delete(centro);
    }

    public List<CentroDeAcopio> listarEnvios() {
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
        // CAMBIO AQUÍ: Usamos el método que trae las entregas listas
        CentroDeAcopio centro = repository.buscarPorIdConEntregas(idCentro);
        
        if (centro != null) {
            // Ahora esto NO fallará porque la lista 'entregas' ya vino cargada de la BD
            centro.registrarEntrega(entrega);
            
            actualizarCentro(centro);
            System.out.println("Entrega registrada exitosamente en " + centro.getNombre());
        } else {
            System.out.println("Error: No se encontró el centro de acopio con ID " + idCentro);
        }
    }
}