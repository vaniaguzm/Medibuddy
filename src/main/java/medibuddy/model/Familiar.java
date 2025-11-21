package medibuddy.model;

import jakarta.persistence.*;

@Entity
@Table(name = "familiar")
@PrimaryKeyJoinColumn(name = "usuario_id") // Une con la tabla usuario
public class Familiar extends Usuario {

    @Column(name = "relacion")
    private String relacion;

    // Relación ManyToOne: Un familiar cuida a un adulto mayor (en este modelo simple)
    @ManyToOne
    @JoinColumn(name = "adulto_mayor_id")
    private AdultoMayor adultoMayorAsociado;

    public Familiar() {}

    public Familiar(String nomUsuario, String tipoUsuario, String telefono, String relacion, AdultoMayor adultoMayor) {
        super(0,nomUsuario, tipoUsuario, telefono);
        this.relacion = relacion;
        this.adultoMayorAsociado = adultoMayor;
    }

    // Getters y Setters
    public String getRelacion() { return relacion; }
    public void setRelacion(String relacion) { this.relacion = relacion; }

    public AdultoMayor getAdultoMayorAsociado() { return adultoMayorAsociado; }
    public void setAdultoMayorAsociado(AdultoMayor adultoMayorAsociado) { this.adultoMayorAsociado = adultoMayorAsociado; }
}