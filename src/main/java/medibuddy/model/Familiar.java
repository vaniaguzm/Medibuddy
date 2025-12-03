package medibuddy.model;

import jakarta.persistence.*;

@Entity
@Table(name = "familiar")
@PrimaryKeyJoinColumn(name = "usuario_id")
public class Familiar extends Usuario {

    @Column(name = "relacion")
    private String relacion;

    @Column(name = "apellido_paterno")
    private String apellidoPaterno;

    @Column(name = "apellido_materno")
    private String apellidoMaterno;
    
    @Column(name = "direccion")
    private String direccion;
    
    @OneToOne
    @JoinColumn(name = "adulto_mayor_id", unique = true, nullable = false)
    private AdultoMayor adultoMayorAsociado;

    public Familiar() {}

    public Familiar(String nom, String apePa, String apeMa, String tel, String relacion, String dir, AdultoMayor adulto) {
        super(0, nom, "Familiar", tel);
        this.apellidoPaterno = apePa;
        this.apellidoMaterno = apeMa;
        this.relacion = relacion;
        this.direccion = dir;
        this.adultoMayorAsociado = adulto;
    }
    
    public Familiar(String nombreCompleto, String telefono, String relacion, String direccion, AdultoMayor adultoMayor) {
        // Pasamos "Familiar" fijo como tipoUsuario para que no se revuelvan los datos
        super(0, nombreCompleto, "Familiar", telefono); 
        this.relacion = relacion;
        this.direccion = direccion;
        this.adultoMayorAsociado = adultoMayor;
    }
    

    
    

    public String getRelacion() { return relacion; }
    public void setRelacion(String relacion) { this.relacion = relacion; }
    public String getApellidoPaterno() { return apellidoPaterno; }
    public void setApellidoPaterno(String apellidoPaterno) { this.apellidoPaterno = apellidoPaterno; }
    public String getApellidoMaterno() { return apellidoMaterno; }
    public void setApellidoMaterno(String apellidoMaterno) { this.apellidoMaterno = apellidoMaterno; }
    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }
    public AdultoMayor getAdultoMayorAsociado() { return adultoMayorAsociado; }
    public void setAdultoMayorAsociado(AdultoMayor adultoMayorAsociado) { this.adultoMayorAsociado = adultoMayorAsociado; }
}