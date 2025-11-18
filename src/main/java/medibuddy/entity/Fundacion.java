package medibuddy.entity;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "fundacion")
public class Fundacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String telefono;

    @ManyToMany(mappedBy = "fundaciones")
    private Set<Actividad> actividades = new HashSet<>();

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Set<Actividad> getActividades() {
        return actividades;
    }

    public void setActividades(Set<Actividad> actividades) {
        this.actividades = actividades;
    }
}