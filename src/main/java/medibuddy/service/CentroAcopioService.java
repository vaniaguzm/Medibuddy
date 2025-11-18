package medibuddy.service;

import medibuddy.entity.CentroAcopioEntity;
import medibuddy.repository.CentroAcopioRepository;
import java.util.List;

public class CentroAcopioService {

    private final CentroAcopioRepository centroAcopioRepository;

    public CentroAcopioService() {
        this.centroAcopioRepository = new CentroAcopioRepository();
    }

    public void saveCentroAcopio(CentroAcopioEntity centroAcopio) {
        centroAcopioRepository.save(centroAcopio);
    }

    public CentroAcopioEntity getCentroAcopio(Long id) {
        return centroAcopioRepository.findById(id);
    }

    public List<CentroAcopioEntity> getAllCentrosAcopio() {
        return centroAcopioRepository.findAll();
    }

    public void updateCentroAcopio(CentroAcopioEntity centroAcopio) {
        centroAcopioRepository.update(centroAcopio);
    }

    public void deleteCentroAcopio(Long id) {
        CentroAcopioEntity centro = getCentroAcopio(id);
        if (centro != null) {
            centroAcopioRepository.delete(centro);
        }
    }
}