package medibuddy.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "entrega")
public class Entrega {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String material;
    private float cantidad; // en kg o unidades
    private LocalDate fechaEntrega;

    @ManyToOne
    @JoinColumn(name = "centro_acopio_id")
    private CentroDeAcopio centroDeAcopio;

    public Entrega() {}

    public Entrega(String material, float cantidad, LocalDate fechaEntrega) {
        this.material = material;
        this.cantidad = cantidad;
        this.fechaEntrega = fechaEntrega;
    }
    
    // Getters y Setters...
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getMaterial() { return material; }
    public void setMaterial(String material) { this.material = material; }
    public float getCantidad() { return cantidad; }
    public void setCantidad(float cantidad) { this.cantidad = cantidad; }
    public LocalDate getFechaEntrega() { return fechaEntrega; }
    public void setFechaEntrega(LocalDate fechaEntrega) { this.fechaEntrega = fechaEntrega; }
    public CentroDeAcopio getCentroDeAcopio() { return centroDeAcopio; }
    public void setCentroDeAcopio(CentroDeAcopio centroDeAcopio) { this.centroDeAcopio = centroDeAcopio; }
}