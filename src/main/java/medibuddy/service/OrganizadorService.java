package medibuddy.service;

import medibuddy.model.Actividad;
import medibuddy.model.Organizador;
import medibuddy.repository.ActividadRepository;
import medibuddy.repository.OrganizadorRepository;
import java.util.List;

public class OrganizadorService {

    private final OrganizadorRepository repository = new OrganizadorRepository();
    private final ActividadRepository actividadRepository = new ActividadRepository();

    public void crearOrganizador(Organizador organizador) {
        repository.save(organizador);
    }

    public List<Organizador> listarTodosLosOrganizadores() {
        return repository.findAll();
    }

    public Organizador buscarOrganizadorPorId(int id) {
        return repository.findById(id);
    }

    public void actualizarOrganizador(Organizador organizador) {
        repository.update(organizador);
    }

    public void eliminarOrganizador(Organizador organizador) {
        repository.delete(organizador);
    }

    /**
     * Método genérico para crear una actividad desde cualquier Organizador.
     * Sirve tanto para Fundaciones como para Centros de Acopio.
     * IMPORTANTE: Asigna la relación manualmente para evitar tocar la lista lazy del padre.
     */
    public void crearActividad(int idOrganizador, Actividad actividad) {
        Organizador organizador = buscarOrganizadorPorId(idOrganizador);
        if (organizador != null) {
            // 1. Asignamos el organizador a la actividad (lado dueño de la relación)
            actividad.setOrganizador(organizador);
            
            // 2. Guardamos la actividad. Hibernate detectará el ID del organizador y creará la FK.
            // No agregamos a la lista del organizador para evitar LazyInitializationException fuera de sesión.
            actividadRepository.save(actividad);
        }
    }
}