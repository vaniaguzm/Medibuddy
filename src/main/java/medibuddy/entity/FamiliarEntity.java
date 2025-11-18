package medibuddy.entity;

import jakarta.persistence.*;

@Entity
@DiscriminatorValue("FAMILIAR")
public class FamiliarEntity extends UsuarioEntity {

    private String parentesco;

    // Relación N-a-1 con AdultoMayor
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "adulto_mayor_asociado_id")
    private AdultoMayorEntity adultoMayorAsociado;

    // Getters y Setters
    public String getParentesco() {
        return parentesco;
    }

    public void setParentesco(String parentesco) {
        this.parentesco = parentesco;
    }

    public AdultoMayorEntity getAdultoMayorAsociado() {
        return adultoMayorAsociado;
    }

    public void setAdultoMayorAsociado(AdultoMayorEntity adultoMayorAsociado) {
        this.adultoMayorAsociado = adultoMayorAsociado;
    }
}