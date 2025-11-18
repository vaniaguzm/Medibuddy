package medibuddy.entity;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "centro_acopio")
public class CentroAcopioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String direccion;
    
    @Column(name = "tipo_material")
    private String tipoMaterial;

    @ManyToMany(mappedBy = "centrosAcopio")
    private Set<ActividadEntity> actividades = new HashSet<>();

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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTipoMaterial() {
        return tipoMaterial;
    }

    public void setTipoMaterial(String tipoMaterial) {
        this.tipoMaterial = tipoMaterial;
    }

    public Set<ActividadEntity> getActividades() {
        return actividades;
    }

    public void setActividades(Set<ActividadEntity> actividades) {
        this.actividades = actividades;
    }
}