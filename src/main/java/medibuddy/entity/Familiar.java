package medibuddy.entity;

import jakarta.persistence.*;

@Entity
@DiscriminatorValue("FAMILIAR")
public class Familiar extends Usuario {

    private String parentesco;

    // Relación N-a-1 con AdultoMayor
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "adulto_mayor_asociado_id")
    private AdultoMayor adultoMayorAsociado;

    // Getters y Setters
    public String getParentesco() {
        return parentesco;
    }

    public void setParentesco(String parentesco) {
        this.parentesco = parentesco;
    }

    public AdultoMayor getAdultoMayorAsociado() {
        return adultoMayorAsociado;
    }

    public void setAdultoMayorAsociado(AdultoMayor adultoMayorAsociado) {
        this.adultoMayorAsociado = adultoMayorAsociado;
    }
}