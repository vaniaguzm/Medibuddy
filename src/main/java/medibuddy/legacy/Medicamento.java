package medibuddy.legacy;

public class Medicamento {
    public int idMedicamento;
    public String nomMedicamento;
    public String dosis;
    public String horaRecordatorio;
    public String modoAdministracion;

    public Medicamento(int idMedicamento, String nomMedicamento, String dosis, String horaRecordatorio,String modoAdministracion) {
        this.idMedicamento = idMedicamento;
        this.nomMedicamento = nomMedicamento;
        this.dosis = dosis;
        this.horaRecordatorio = horaRecordatorio;
        this.modoAdministracion = modoAdministracion;
    }

    public void programar_recordatorio() {
        System.out.println("Recordatorio programado a las " + horaRecordatorio);
    }

    public void enviar_recordatorio_a_adulto_mayor(AdultoMayor adulto) {
        System.out.println("Enviando recordatorio a " + adulto.getNomUsuario());
    }

    public void confirmar_toma() {
        System.out.println("Toma confirmada de " + nomMedicamento);
    }
 
    public String ver_info_medicamento() {
        return nomMedicamento + " - " + dosis + " - " + horaRecordatorio;
    }

    public String getNomMedicamento() {
        return nomMedicamento;
    }
}



