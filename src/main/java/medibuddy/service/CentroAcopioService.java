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
}