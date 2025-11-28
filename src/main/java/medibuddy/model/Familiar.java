package medibuddy.model;

import jakarta.persistence.*;

@Entity
@Table(name = "familiar")
@PrimaryKeyJoinColumn(name = "usuario_id")
public class Familiar extends Usuario {

    @Column(name = "relacion")
    private String relacion;

    @OneToOne
    @JoinColumn(name = "adulto_mayor_id", unique = true, nullable = false)
    private AdultoMayor adultoMayorAsociado;

    public Familiar() {}

    public Familiar(String nomUsuario, String tipoUsuario, String telefono, String relacion, AdultoMayor adultoMayor) {
        super(0, nomUsuario, tipoUsuario, telefono);
        this.relacion = relacion;
        this.adultoMayorAsociado = adultoMayor;
    }

    public String getRelacion() { return relacion; }
    public void setRelacion(String relacion) { this.relacion = relacion; }
    
    public AdultoMayor getAdultoMayorAsociado() { return adultoMayorAsociado; }
    public void setAdultoMayorAsociado(AdultoMayor adultoMayorAsociado) { this.adultoMayorAsociado = adultoMayorAsociado; }
}