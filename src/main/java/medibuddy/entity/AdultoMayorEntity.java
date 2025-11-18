package medibuddy.entity;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@DiscriminatorValue("ADULTO_MAYOR")
public class AdultoMayorEntity extends UsuarioEntity {

    @Column(name = "contacto_emergencia")
    private String contactoEmergencia;

    // Relación 1-a-N con Familiar (inversa)
    @OneToMany(mappedBy = "adultoMayorAsociado", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<FamiliarEntity> familiares = new HashSet<>();

    // Relación 1-a-N con Medicamento
    @OneToMany(mappedBy = "adultoMayor", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<MedicamentoEntity> medicamentos = new HashSet<>();

    // Relación N-a-N con Actividad
    @ManyToMany(mappedBy = "participantes")
    private Set<ActividadEntity> actividades = new HashSet<>();

    // Getters y Setters
    public String getContactoEmergencia() {
        return contactoEmergencia;
    }

    public void setContactoEmergencia(String contactoEmergencia) {
        this.contactoEmergencia = contactoEmergencia;
    }

    public Set<FamiliarEntity> getFamiliares() {
        return familiares;
    }

    public void setFamiliares(Set<FamiliarEntity> familiares) {
        this.familiares = familiares;
    }

    public Set<MedicamentoEntity> getMedicamentos() {
        return medicamentos;
    }

    public void setMedicamentos(Set<MedicamentoEntity> medicamentos) {
        this.medicamentos = medicamentos;
    }

    public Set<ActividadEntity> getActividades() {
        return actividades;
    }

    public void setActividades(Set<ActividadEntity> actividades) {
        this.actividades = actividades;
    }
}