package medibuddy.service;

import medibuddy.model.Entrega;
import medibuddy.repository.EntregaRepository;
import java.util.List;

public class EntregaService {
    
    private final EntregaRepository repository = new EntregaRepository();

    public void crearEntrega(Entrega entrega) {
        repository.save(entrega);
    }

    public List<Entrega> listarEntregas() {
        return repository.findAll();
    }

    public Entrega buscarEntregaPorId(int id) {
        return repository.findById(id);
    }
    
    public void actualizarEntrega(Entrega entrega) {
        repository.update(entrega);
    }

    public void eliminarEntrega(Entrega entrega) {
        repository.delete(entrega);
    }
}