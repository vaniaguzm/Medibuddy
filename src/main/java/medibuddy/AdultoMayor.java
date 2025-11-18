package medibuddy;

import java.util.ArrayList;

public class AdultoMayor extends Usuario {
    public String contactoEmergencia;
    public ArrayList<Medicamento> medicamentos;

    public AdultoMayor(int idUsuario, String nomUsuario, String tipoUsuario, String telefono, String contactoEmergencia) {
        super(idUsuario, nomUsuario, tipoUsuario, telefono);
        this.contactoEmergencia = contactoEmergencia;
        this.medicamentos = new ArrayList<>();
    }

    public void agregarMedicamento(Medicamento nuevoMedicamento) {
        medicamentos.add(nuevoMedicamento);
    }

    public void aceptar_recordatorio(Medicamento medicamento) {
        System.out.println("Recordatorio aceptado para: " + medicamento.getNomMedicamento());
    }

    public void listarMedicamentos() {
        System.out.println("Medicamentos de " + nomUsuario + ":");
        for (Medicamento m : medicamentos) {
            System.out.println("- " + m.ver_info_medicamento());
        }
    }
    @Override
        public String getNomUsuario() {
        return nomUsuario;
    }
}
