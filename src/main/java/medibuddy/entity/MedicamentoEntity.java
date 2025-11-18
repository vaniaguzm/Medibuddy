package medibuddy.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "medicamento")
public class MedicamentoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String info;
    private String dosis;
    
    @Column(name = "hora_recordatorio")
    private String horaRecordatorio;

    // Relación N-a-1 con AdultoMayor
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "adulto_mayor_id", nullable = false)
    private AdultoMayorEntity adultoMayor;

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
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

    public AdultoMayorEntity getAdultoMayor() {
        return adultoMayor;
    }

    public void setAdultoMayor(AdultoMayorEntity adultoMayor) {
        this.adultoMayor = adultoMayor;
    }
}