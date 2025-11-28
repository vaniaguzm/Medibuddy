package medibuddy.service;

import medibuddy.model.Actividad; // Importar Actividad
import medibuddy.model.CentroDeAcopio;
import medibuddy.repository.CentroDeAcopioRepository;
import medibuddy.repository.ActividadRepository; // Necesario para guardar la actividad

import java.util.List;

public class CentroDeAcopioService {

    private final CentroDeAcopioRepository repository = new CentroDeAcopioRepository();
    // Agregamos repositorio de actividades para poder guardarlas
    private final ActividadRepository actividadRepository = new ActividadRepository();

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

    // --- NUEVO: Capacidad de crear actividades (Heredado de Organizador) ---
    public void crearActividadParaCentro(int idCentro, Actividad actividad) {
        CentroDeAcopio centro = buscarCentroPorId(idCentro);
        if (centro != null) {
            // Usamos el método de la entidad que conecta ambos objetos
            centro.crearActividad(actividad);
            // Guardamos la actividad (el centro se actualiza por cascada si está configurado, 
            // pero es mas seguro guardar la actividad directamente)
            actividadRepository.save(actividad);
        }
    }
}