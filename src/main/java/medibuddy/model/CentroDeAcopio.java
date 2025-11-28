    package medibuddy.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "centro_de_acopio")
public class CentroDeAcopio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String pedido;
    private String cantidad;
    private String nombre;
    private String direccion;
    private String tipoMaterialPrincipal;


    @ManyToOne 
    @JoinColumn(name = "fundacion_id") 
    private Fundacion fundacionDestino;
    
    @OneToMany(mappedBy = "centroDeAcopio", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Entrega> entregas = new ArrayList<>();

    public CentroDeAcopio() {}

    public CentroDeAcopio(String pedido, String cantidad,Fundacion fundacionDestino){
        this.pedido = pedido;
        this.cantidad = cantidad;
       this.fundacionDestino = fundacionDestino;
    }
    
    public CentroDeAcopio(String nombre, String direccion, String tipoMaterialPrincipal) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.tipoMaterialPrincipal = tipoMaterialPrincipal;
    }

    public void registrarEntrega(Entrega entrega) {
        entrega.setCentroDeAcopio(this); // Mantiene la consistencia bidireccional
        this.entregas.add(entrega);
    }

    // Getters y Setters estándar...
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }
    public String getTipoMaterialPrincipal() { return tipoMaterialPrincipal; }
    public void setTipoMaterialPrincipal(String tipo) { this.tipoMaterialPrincipal = tipo; }
    public List<Entrega> getEntregas() { return entregas; }
    public void setEntregas(List<Entrega> entregas) { this.entregas = entregas; }
    public String getPedido() { return pedido; }
    public void setPedido(String pedido) { this.pedido = pedido; }
    public String getCantidad() { return cantidad; }
    public void setCantidad(String cantidad) { this.cantidad = cantidad; }
    public Fundacion getFundacionDestino() { return fundacionDestino; }
    public void setFundacionDestino(Fundacion fundacionDestino) { this.fundacionDestino = fundacionDestino; }
}