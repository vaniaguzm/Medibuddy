package medibuddy.service;

import medibuddy.model.Medicamento;
import medibuddy.repository.MedicamentoRepository;
import java.util.List;

public class MedicamentoService {

    private final MedicamentoRepository repository = new MedicamentoRepository();

    public void crearMedicamento(Medicamento medicamento) {
        repository.save(medicamento);
    }

    public List<Medicamento> listarMedicamentos() {
        return repository.findAll();
    }

    public Medicamento buscarMedicamentoPorId(int id) {
        return repository.findById(id);
    }

    public void actualizarMedicamento(Medicamento medicamento) {
        repository.update(medicamento);
    }

    public void eliminarMedicamento(Medicamento medicamento) {
        repository.delete(medicamento);
    }
}
