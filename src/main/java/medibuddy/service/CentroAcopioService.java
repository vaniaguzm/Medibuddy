package medibuddy.service;

import medibuddy.entity.CentroAcopio;
import medibuddy.repository.CentroAcopioRepository;
import java.util.List;

public class CentroAcopioService {

    private final CentroAcopioRepository centroAcopioRepository;

    public CentroAcopioService() {
        this.centroAcopioRepository = new CentroAcopioRepository();
    }

    public void saveCentroAcopio(CentroAcopio centroAcopio) {
        centroAcopioRepository.save(centroAcopio);
    }

    public CentroAcopio getCentroAcopio(Long id) {
        return centroAcopioRepository.findById(id);
    }

    public List<CentroAcopio> getAllCentrosAcopio() {
        return centroAcopioRepository.findAll();
    }

    public void updateCentroAcopio(CentroAcopio centroAcopio) {
        centroAcopioRepository.update(centroAcopio);
    }

    public void deleteCentroAcopio(Long id) {
        CentroAcopio centro = getCentroAcopio(id);
        if (centro != null) {
            centroAcopioRepository.delete(centro);
        }
    }

    // --- ESTE ERA EL MÉTODO QUE TE FALTABA ---
    public void registrarEntrega(Long centroId, String material, float cantidad) {
        CentroAcopio centro = getCentroAcopio(centroId);

        if (centro != null) {
            // Creamos el string con el detalle
            String detalle = "Entrega registrada: " + cantidad + "kg de " + material;
            
            // Agregamos al historial (La lista que creamos en la Entity)
            centro.getHistorialEntregas().add(detalle);
            
            // Guardamos los cambios en la base de datos
            centroAcopioRepository.update(centro);
            
            System.out.println("Éxito: " + detalle + " en " + centro.getNombre());
        } else {
            System.err.println("Error: No se encontró el Centro de Acopio con ID " + centroId);
        }
    }
}