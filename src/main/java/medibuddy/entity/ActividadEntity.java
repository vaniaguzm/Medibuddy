package medibuddy.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "actividad")
public class ActividadEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descripcion;
    
    @Temporal(TemporalType.DATE)
    private LocalDate fecha;
    
    private String direccion;

    @Column(name = "tipo_material")
    private String tipoMaterial; // Columna de la tabla 'actividad', no de 'centro_acopio'

    // Relación N-a-N con AdultoMayor (participantes)
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
        name = "participacion_actividad",
        joinColumns = @JoinColumn(name = "actividad_id"),
        inverseJoinColumns = @JoinColumn(name = "adulto_mayor_id")
    )
    private Set<AdultoMayorEntity> participantes = new HashSet<>();

    // Relación N-a-N con Fundacion
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
        name = "actividad_fundacion",
        joinColumns = @JoinColumn(name = "actividad_id"),
        inverseJoinColumns = @JoinColumn(name = "fundacion_id")
    )
    private Set<FundacionEntity> fundaciones = new HashSet<>();

    // Relación N-a-N con CentroAcopio
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
        name = "actividad_centro_acopio",
        joinColumns = @JoinColumn(name = "actividad_id"),
        inverseJoinColumns = @JoinColumn(name = "centro_acopio_id")
    )
    private Set<CentroAcopioEntity> centrosAcopio = new HashSet<>();

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
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

    public Set<AdultoMayorEntity> getParticipantes() {
        return participantes;
    }

    public void setParticipantes(Set<AdultoMayorEntity> participantes) {
        this.participantes = participantes;
    }

    public Set<FundacionEntity> getFundaciones() {
        return fundaciones;
    }

    public void setFundaciones(Set<FundacionEntity> fundaciones) {
        this.fundaciones = fundaciones;
    }

    public Set<CentroAcopioEntity> getCentrosAcopio() {
        return centrosAcopio;
    }

    public void setCentrosAcopio(Set<CentroAcopioEntity> centrosAcopio) {
        this.centrosAcopio = centrosAcopio;
    }
}