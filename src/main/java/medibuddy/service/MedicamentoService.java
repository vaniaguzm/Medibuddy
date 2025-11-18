package medibuddy.service;

import medibuddy.entity.AdultoMayor;
import medibuddy.entity.Medicamento;
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

    public void saveMedicamento(Medicamento medicamento, Long adultoMayorId) {
        var usuario = usuarioRepository.findById(adultoMayorId);
        if (usuario instanceof AdultoMayor) {
            medicamento.setAdultoMayor((AdultoMayor) usuario);
            medicamentoRepository.save(medicamento);
        } else {
            System.err.println("No se encontró AdultoMayor con id: " + adultoMayorId);
        }
    }

    public Medicamento getMedicamento(Long id) {
        return medicamentoRepository.findById(id);
    }

    public List<Medicamento> getAllMedicamentos() {
        return medicamentoRepository.findAll();
    }

    public void updateMedicamento(Medicamento medicamento) {
        medicamentoRepository.update(medicamento);
    }

    public void deleteMedicamento(Long id) {
        Medicamento med = getMedicamento(id);
        if (med != null) {
            medicamentoRepository.delete(med);
        }
    }

    public void confirmarTomaMedicamento(Long medicamentoId) {
        Medicamento med = medicamentoRepository.findById(medicamentoId);
        
        if (med != null) {
            if (!med.getTomado()) {
                med.setTomado(true); // Cambiamos el estado en memoria
                medicamentoRepository.update(med); // Guardamos el cambio en BD
                System.out.println("Toma confirmada para: " + med.getInfo());
            } else {
                System.out.println("Este medicamento ya había sido marcado como tomado.");
            }
        } else {
            System.err.println("Medicamento no encontrado.");
        }
    }

    public void enviarRecordatorio(Long medicamentoId) {
        Medicamento med = medicamentoRepository.findById(medicamentoId);
        if (med != null && med.getAdultoMayor() != null) {
            // Aquí iría la lógica real de envío (SMS, Email, Push Notification)
            // Por ahora simulamos lo que hacías en consola:
            System.out.println("ENVIANDO RECORDATORIO A: " + med.getAdultoMayor().getNombre());
            System.out.println("Hora: " + med.getHoraRecordatorio() + " - Tomar: " + med.getInfo() + " (" + med.getDosis() + ")");
        }
    }
}