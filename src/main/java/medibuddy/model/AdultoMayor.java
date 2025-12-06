package medibuddy.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "adulto_mayor")
@PrimaryKeyJoinColumn(name = "id_usuario")
public class AdultoMayor extends Usuario {

    @Column(name = "contacto_emergencia")
    private String contactoEmergencia;

    @Column(name = "apellido_paterno")
    private String apellidoPaterno;

    @Column(name = "apellido_materno")
    private String apellidoMaterno;
    
    // Relación 1:1 Inversa con Familiar
    @OneToOne(mappedBy = "adultoMayorAsociado", cascade = CascadeType.ALL)
    private Familiar familiarResponsable;

    // Relación N:M con Medicamentos
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JoinTable(
        name = "adulto_medicamento",
        joinColumns = @JoinColumn(name = "adulto_id"),
        inverseJoinColumns = @JoinColumn(name = "medicamento_id")
    )
    private List<Medicamento> medicamentos = new ArrayList<>();

    // Relación N:M con Actividades (Solo el adulto participa)
    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(
        name = "inscripciones",
        joinColumns = @JoinColumn(name = "adulto_id"),
        inverseJoinColumns = @JoinColumn(name = "actividad_id")
    )
    private List<Actividad> actividadesInscritas = new ArrayList<>();

    public AdultoMayor() {}

    public AdultoMayor(String nombre, String apePa, String apeMa, String telefono, String emergencia) {
        // 1. Enviamos datos generales al Padre (Usuario)
        // El ID va en 0 porque es autoincremental
        super(0, nombre, "Adulto Mayor", telefono); 
        this.contactoEmergencia = emergencia;
        // 2. Inicializamos los atributos propios de AdultoMayor
        this.apellidoPaterno = apePa; // ¡CORREGIDO! Faltaba inicializar
        this.apellidoMaterno = apeMa; // ¡CORREGIDO! Faltaba inicializar
        this.contactoEmergencia = emergencia;
    }

    // Métodos de negocio
    public void agregarMedicamento(Medicamento nuevoMedicamento) {
        if (!medicamentos.contains(nuevoMedicamento)) {
            medicamentos.add(nuevoMedicamento);
            nuevoMedicamento.getPacientes().add(this); 
        }
    }

    public void inscribirse(Actividad actividad) {
        if (!actividadesInscritas.contains(actividad)) {
            actividadesInscritas.add(actividad);
            actividad.getParticipantes().add(this);
        }
    }

    public void aceptarRecordatorio(Medicamento medicamento) {
        System.out.println("Recordatorio aceptado para: " + medicamento.getNomMedicamento());
    }

    public void listarMedicamentos() {
        System.out.println("Medicamentos de " + getNomUsuario() + ":");
        for (Medicamento m : medicamentos) {
            System.out.println("- " + m.verInfoMedicamento());
        }
    }

    // Getters y Setters
    public String getApellidoPaterno() { return apellidoPaterno; }
    public void setApellidoPaterno(String apellidoPaterno) { this.apellidoPaterno = apellidoPaterno; }
    public String getApellidoMaterno() { return apellidoMaterno; }
    public void setApellidoMaterno(String apellidoMaterno) { this.apellidoMaterno = apellidoMaterno; }
    public String getContactoEmergencia() { return contactoEmergencia; }
    public void setContactoEmergencia(String contactoEmergencia) { this.contactoEmergencia = contactoEmergencia; }
    public Familiar getFamiliarResponsable() { return familiarResponsable; }
    public void setFamiliarResponsable(Familiar familiarResponsable) { this.familiarResponsable = familiarResponsable; }
    public List<Medicamento> getMedicamentos() { return medicamentos; }
    public void setMedicamentos(List<Medicamento> medicamentos) { this.medicamentos = medicamentos; }
    public List<Actividad> getActividadesInscritas() { return actividadesInscritas; }
    public void setActividadesInscritas(List<Actividad> actividadesInscritas) { this.actividadesInscritas = actividadesInscritas; }
}