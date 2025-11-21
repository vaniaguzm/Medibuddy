package medibuddy.model;

import jakarta.persistence.*;

@Entity
@Table(name = "actividad")
public class Actividad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idActividad;
    private String nomActividad;
    private String descripcion;
    private String fecha;
    private String ubicacion;
    private int cupoMaximo;

    // Constructores, getters y setters
    public Actividad() {}

    public Actividad(String nomActividad, String descripcion, String fecha, String ubicacion, int cupoMaximo) {
        this.nomActividad = nomActividad;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.ubicacion = ubicacion;
        this.cupoMaximo = cupoMaximo;
    }

    // Getters y setters
    public int getIdActividad() { return idActividad; }
    public void setIdActividad(int idActividad) { this.idActividad = idActividad; }
    public String getNomActividad() { return nomActividad; }
    public void setNomActividad(String nomActividad) { this.nomActividad = nomActividad; }
    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    public String getFecha() { return fecha; }
    public void setFecha(String fecha) { this.fecha = fecha; }
    public String getUbicacion() { return ubicacion; }
    public void setUbicacion(String ubicacion) { this.ubicacion = ubicacion; }
    public int getCupoMaximo() { return cupoMaximo; }
    public void setCupoMaximo(int cupoMaximo) { this.cupoMaximo = cupoMaximo; }

    @Override
    public String toString() {
        return "Actividad{" +
                "idActividad=" + idActividad +
                ", nomActividad='" + nomActividad + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", fecha='" + fecha + '\'' +
                ", ubicacion='" + ubicacion + '\'' +
                ", cupoMaximo=" + cupoMaximo +
                '}';
    }

}
