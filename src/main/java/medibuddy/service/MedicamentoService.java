package medibuddy.service;

import medibuddy.entity.AdultoMayorEntity;
import medibuddy.entity.MedicamentoEntity;
import medibuddy.repository.MedicamentoRepository;
import medibuddy.repository.UsuarioRepository;

import java.util.List;

public class MedicamentoService {

    private final MedicamentoRepository medicamentoRepository;
    private final UsuarioRepository usuarioRepository; // Para asociar

    public MedicamentoService() {
        this.medicamentoRepository = new MedicamentoRepository();
        this.usuarioRepository = new UsuarioRepository();
    }

    public void saveMedicamento(MedicamentoEntity medicamento, Long adultoMayorId) {
        var usuario = usuarioRepository.findById(adultoMayorId);
        if (usuario instanceof AdultoMayorEntity) {
            medicamento.setAdultoMayor((AdultoMayorEntity) usuario);
            medicamentoRepository.save(medicamento);
        } else {
            System.err.println("No se encontró AdultoMayor con id: " + adultoMayorId);
        }
    }

    public MedicamentoEntity getMedicamento(Long id) {
        return medicamentoRepository.findById(id);
    }

    public List<MedicamentoEntity> getAllMedicamentos() {
        return medicamentoRepository.findAll();
    }

    public void updateMedicamento(MedicamentoEntity medicamento) {
        medicamentoRepository.update(medicamento);
    }

    public void deleteMedicamento(Long id) {
        MedicamentoEntity med = getMedicamento(id);
        if (med != null) {
            medicamentoRepository.delete(med);
        }
    }
}