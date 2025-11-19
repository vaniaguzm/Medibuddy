package medibuddy.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "medicamento")
public class Medicamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String dosis;
    
    private Boolean tomado = false;

    @Column(name = "hora_recordatorio")
    private String horaRecordatorio;

    // Relación N-a-1 con AdultoMayor
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "adulto_mayor_id", nullable = false)
    private AdultoMayor adultoMayor;

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getDosis() {
        return dosis;
    }

    public void setDosis(String dosis) {
        this.dosis = dosis;
    }

    public String getHoraRecordatorio() {
        return horaRecordatorio;
    }

    public void setHoraRecordatorio(String horaRecordatorio) {
        this.horaRecordatorio = horaRecordatorio;
    }

    public AdultoMayor getAdultoMayor() {
        return adultoMayor;
    }

    public void setAdultoMayor(AdultoMayor adultoMayor) {
        this.adultoMayor = adultoMayor;
    }

    public Boolean getTomado() { return tomado; }
    public void setTomado(Boolean tomado) { this.tomado = tomado; }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }
}