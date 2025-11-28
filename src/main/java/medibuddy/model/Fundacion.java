package medibuddy.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "fundacion")
public class Fundacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nombre")
    private String nombre;
    
    @Column(name = "actividad")
    private String actividad;

    @Column(name = "direccion")
    private String direccion;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "fundacion_id")
    private List<Actividad> actividadesObj = new ArrayList<>();

    
    @ManyToMany(fetch = FetchType.EAGER) 
    @JoinTable(
        name = "inscripciones_fundacion", // Nombre de la tabla intermedia
        joinColumns = @JoinColumn(name = "fundacion_id"),
        inverseJoinColumns = @JoinColumn(name = "adulto_id")
    )
    private List<AdultoMayor> asistentes = new ArrayList<>();

    public Fundacion() {}

    public Fundacion(String nombre,String actividad ,String direccion) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.actividad = actividad;
    }
    
    
    public List<AdultoMayor> getAsistentes() {
        return asistentes;
    }

    public void setAsistentes(List<AdultoMayor> asistentes) {
        this.asistentes = asistentes;
    }
    
    public void agregarAsistente(AdultoMayor adulto) {
    if (!asistentes.contains(adulto)) {
        asistentes.add(adulto);
    }
    }

    public void removerAsistente(AdultoMayor adulto) {
        asistentes.remove(adulto);
    }
    public void agregarActividad(Actividad actividad) {
        actividadesObj.add(actividad);
    }

    // Getters y Setters estándar...
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getActividad(){return actividad;}
    public void setActividad(String actividad){this.actividad=actividad;}
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }
}