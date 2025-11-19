package medibuddy.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "adulto_mayor")
@PrimaryKeyJoinColumn(name = "id_usuario") // Hereda de Usuario
public class AdultoMayor extends Usuario {

    @Column(name = "contacto_emergencia")
    private String contactoEmergencia;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "adulto_mayor_id")
    private List<Medicamento> medicamentos;

    public AdultoMayor() {
        this.medicamentos = new ArrayList<>();
    }

    public AdultoMayor(int idUsuario, String nomUsuario, String tipoUsuario, String telefono, String contactoEmergencia) {
        super(idUsuario, nomUsuario, tipoUsuario, telefono);
        this.contactoEmergencia = contactoEmergencia;
        this.medicamentos = new ArrayList<>();
    }

    // Getters y Setters
    public String getContactoEmergencia() {
        return contactoEmergencia;
    }

    public void setContactoEmergencia(String contactoEmergencia) {
        this.contactoEmergencia = contactoEmergencia;
    }

    public List<Medicamento> getMedicamentos() {
        return medicamentos;
    }

    public void setMedicamentos(List<Medicamento> medicamentos) {
        this.medicamentos = medicamentos;
    }

    // Métodos de negocio
    public void agregarMedicamento(Medicamento nuevoMedicamento) {
        medicamentos.add(nuevoMedicamento);
    }

    public void aceptarRecordatorio(Medicamento medicamento) {
        System.out.println("Recordatorio aceptado para: " + medicamento.getNomMedicamento());
    }

    public void listarMedicamentos() {
        System.out.println("Medicamentos de " + getNomUsuario() + ":");
        for (Medicamento m : medicamentos) {
            System.out.println("- " + m.verInfoMedicamento());
        }
    }

    @Override
    public String toString() {
        return "AdultoMayor{" +
                "idUsuario=" + getIdUsuario() +
                ", nomUsuario='" + getNomUsuario() + '\'' +
                ", contactoEmergencia='" + contactoEmergencia + '\'' +
                ", medicamentos=" + medicamentos +
                '}';
    }
}
