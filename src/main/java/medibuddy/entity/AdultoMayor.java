package medibuddy.entity;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@DiscriminatorValue("ADULTO_MAYOR")
public class AdultoMayor extends Usuario {

    @Column(name = "contacto_emergencia")
    private String contactoEmergencia;

    // Relación 1-a-N con Familiar (inversa)
    @OneToMany(mappedBy = "adultoMayorAsociado", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Familiar> familiares = new HashSet<>();

    // Relación 1-a-N con Medicamento
    @OneToMany(mappedBy = "adultoMayor", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Medicamento> medicamentos = new HashSet<>();

    // Relación N-a-N con Actividad
    @ManyToMany(mappedBy = "participantes")
    private Set<Actividad> actividades = new HashSet<>();

    // Getters y Setters
    public String getContactoEmergencia() {
        return contactoEmergencia;
    }

    public void setContactoEmergencia(String contactoEmergencia) {
        this.contactoEmergencia = contactoEmergencia;
    }

    public Set<Familiar> getFamiliares() {
        return familiares;
    }

    public void setFamiliares(Set<Familiar> familiares) {
        this.familiares = familiares;
    }

    public Set<Medicamento> getMedicamentos() {
        return medicamentos;
    }

    public void setMedicamentos(Set<Medicamento> medicamentos) {
        this.medicamentos = medicamentos;
    }

    public Set<Actividad> getActividades() {
        return actividades;
    }

    public void setActividades(Set<Actividad> actividades) {
        this.actividades = actividades;
    }
}