package medibuddy.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "centro_acopio")
public class CentroAcopio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String direccion;
    
    @Column(name = "tipo_material")
    private String tipoMaterial;

    @ManyToMany(mappedBy = "centrosAcopio")
    private Set<Actividad> actividades = new HashSet<>();

    @ElementCollection
    @CollectionTable(name = "centro_entregas", joinColumns = @JoinColumn(name = "centro_id"))
    @Column(name = "detalle_entrega")
    private List<String> historialEntregas = new ArrayList<>();

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

    public Set<Actividad> getActividades() {
        return actividades;
    }

    public void setActividades(Set<Actividad> actividades) {
        this.actividades = actividades;
    }

    public List<String> getHistorialEntregas() { return historialEntregas; }
    public void setHistorialEntregas(List<String> historialEntregas) { this.historialEntregas = historialEntregas; }
}