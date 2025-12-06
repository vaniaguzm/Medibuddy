package medibuddy.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

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

    // Relación ManyToOne con el Organizador (Padre)
    @ManyToOne
    @JoinColumn(name = "organizador_id", nullable = false)
    private Organizador organizador;

    // Relación ManyToMany con AdultoMayor
    @ManyToMany(mappedBy = "actividadesInscritas")
    private List<AdultoMayor> participantes = new ArrayList<>();

    public Actividad() {}

    public Actividad(String nomActividad, String descripcion, String fecha, String ubicacion, int cupoMaximo) {
        this.nomActividad = nomActividad;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.ubicacion = ubicacion;
        this.cupoMaximo = cupoMaximo;
    }

    // Getters y Setters
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
    public Organizador getOrganizador() { return organizador; }
    public void setOrganizador(Organizador organizador) { this.organizador = organizador; }
    public List<AdultoMayor> getParticipantes() { return participantes; }
    public void setParticipantes(List<AdultoMayor> participantes) { this.participantes = participantes; }
    
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Actividad that = (Actividad) o;
        return idActividad == that.idActividad;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(idActividad);
    }
    
    @Override
    public String toString() {
        return "Actividad{" + "idActividad=" + idActividad + ", nomActividad='" + nomActividad + '\'' + '}';
    }
}