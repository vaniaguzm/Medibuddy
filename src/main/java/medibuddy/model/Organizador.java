package medibuddy.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "organizador")
@Inheritance(strategy = InheritanceType.JOINED)
public class Organizador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_organizador")
    private int id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "direccion")
    private String direccion;

    // Relación: Un organizador crea muchas actividades
    @OneToMany(mappedBy = "organizador", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Actividad> actividadesPropias = new ArrayList<>();

    public Organizador() {}

    public Organizador(String nombre, String direccion) {
        this.nombre = nombre;
        this.direccion = direccion;
    }

    public void crearActividad(Actividad actividad) {
        actividad.setOrganizador(this);
        this.actividadesPropias.add(actividad);
    }

    // Getters y Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }
    public List<Actividad> getActividadesPropias() { return actividadesPropias; }
    public void setActividadesPropias(List<Actividad> actividadesPropias) { this.actividadesPropias = actividadesPropias; }
}