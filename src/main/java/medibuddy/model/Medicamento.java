package medibuddy.model;

import jakarta.persistence.*;

@Entity
@Table(name = "medicamento")
public class Medicamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_medicamento")
    private int idMedicamento;

    @Column(name = "nom_medicamento")
    private String nomMedicamento;

    @Column(name = "dosis")
    private String dosis;

    @Column(name = "hora_recordatorio")
    private String horaRecordatorio;
    
    //Crear un modo de administracion para que sea la actividad
    @Column(name = "modo_administracion")
    private String modoAdministracion;

    // Constructores
    public Medicamento() {}

    public Medicamento(String nomMedicamento, String dosis, String horaRecordatorio,String modoAdministracion) {
        this.idMedicamento = 0;
        this.nomMedicamento = nomMedicamento;
        this.dosis = dosis;
        this.horaRecordatorio = horaRecordatorio;
        this.modoAdministracion = modoAdministracion;
    }

    // Getters y Setters
    
    public String getModoAministracion(){
        return modoAdministracion;
    }
    
    public void setModoAdministracion(String modoAdministracion){
        this.modoAdministracion = modoAdministracion;
    }
    public int getIdMedicamento() {
        return idMedicamento;
    }

    public void setIdMedicamento(int idMedicamento) {
        this.idMedicamento = idMedicamento;
    }

    public String getNomMedicamento() {
        return nomMedicamento;
    }

    public void setNomMedicamento(String nomMedicamento) {
        this.nomMedicamento = nomMedicamento;
    }

    public String getDosis() {
        return dosis;
    }

    public void setDosis(String dosis) {
        this.dosis = dosis;
    }

    public String getHoraRecordatorio() {
        return horaRecordatorio;
    }

    public void setHoraRecordatorio(String horaRecordatorio) {
        this.horaRecordatorio = horaRecordatorio;
    }

    // Métodos de negocio
    public void programarRecordatorio() {
        System.out.println("Recordatorio programado a las " + horaRecordatorio);
    }

    public void enviarRecordatorioAAdultoMayor(AdultoMayor adulto) {
        System.out.println("Enviando recordatorio a " + adulto.getNomUsuario());
    }

    public void confirmarToma() {
        System.out.println("Toma confirmada de " + nomMedicamento);
    }

    public String verInfoMedicamento() {
        return nomMedicamento + " - " + dosis + " - " + horaRecordatorio;
    }

    @Override
    public String toString() {
        return "Medicamento{" +
                "idMedicamento=" + idMedicamento +
                ", nomMedicamento='" + nomMedicamento + '\'' +
                ", dosis='" + dosis + '\'' +
                ", horaRecordatorio='" + horaRecordatorio + '\'' +
                '}';
    }
}
