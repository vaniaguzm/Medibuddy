package medibuddy.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "medicamento")
public class Medicamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_medicamento")
    private int idMedicamento;

    @Column(name = "nom_medicamento")
    private String nomMedicamento;

    @Column(name = "presentacionMedicamento")
    private String presentacionMedicamento;

    @Column(name = "dosis")
    private String adminYdosis;

    @Column(name = "hora_recordatorio")
    private String horaRecordatorio;
    
    @Column(name = "modo_administracion")
    private String modoAdministracion;

    // Relación Inversa Muchos a Muchos con AdultoMayor
    @ManyToMany(mappedBy = "medicamentos")
    private List<AdultoMayor> pacientes = new ArrayList<>();

    public Medicamento() {}

    public Medicamento(String nom, String presentacion, String dosis, String hora, String modo) {
        this.nomMedicamento = nom;
        this.presentacionMedicamento = presentacion;
        this.adminYdosis = dosis;
        this.horaRecordatorio = hora;
        this.modoAdministracion = modo;
    }
    
    public Medicamento(String nomMedicamento, String dosis, String horaRecordatorio, String modoAdministracion) {
        this.nomMedicamento = nomMedicamento;
        this.adminYdosis = dosis;
        this.horaRecordatorio = horaRecordatorio;
        this.modoAdministracion = modoAdministracion;
    }

    public void programarRecordatorio() {
        System.out.println("Recordatorio programado a las " + horaRecordatorio);
    }
    
    public void confirmarToma() {
        System.out.println("Toma confirmada de " + nomMedicamento);
    }

    public String verInfoMedicamento() {
        return nomMedicamento + " - " + adminYdosis + " - " + horaRecordatorio;
    }

    // Getters y Setters
    public int getIdMedicamento() { return idMedicamento; }
    public void setIdMedicamento(int id) { this.idMedicamento = id; }
    public String getNomMedicamento() { return nomMedicamento; }
    public void setNomMedicamento(String nom) { this.nomMedicamento = nom; }
    public String getPresentacionMedicamento() { return presentacionMedicamento; }
    public void setPresentacionMedicamento(String p) { this.presentacionMedicamento = p; }
    public String getDosis() { return adminYdosis; }
    public void setDosis(String dosis) { this.adminYdosis = dosis; }
    public String getHoraRecordatorio() { return horaRecordatorio; }
    public void setHoraRecordatorio(String h) { this.horaRecordatorio = h; }
    public String getModoAdministracion() { return modoAdministracion; }
    public void setModoAdministracion(String m) { this.modoAdministracion = m; }
    public List<AdultoMayor> getPacientes() { return pacientes; }
    public void setPacientes(List<AdultoMayor> pacientes) { this.pacientes = pacientes; }
}