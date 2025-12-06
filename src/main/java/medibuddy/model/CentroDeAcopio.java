package medibuddy.model;

import jakarta.persistence.*;

@Entity
@Table(name = "centro_de_acopio")
@PrimaryKeyJoinColumn(name = "id_organizador")
public class CentroDeAcopio extends Organizador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "direccion")
    private String direccion;
    
    @Column(name = "tipo_material_principal")
    private String tipoMaterialPrincipal;
    private String pedido;
    private String cantidad;

    public CentroDeAcopio() {}

    public CentroDeAcopio(String nombre, String direccion, String tipoMaterialPrincipal, String pedido, String cantidad) {
        super(nombre, direccion);
        this.tipoMaterialPrincipal = tipoMaterialPrincipal;
        this.pedido = pedido;
        this.cantidad = cantidad;
    }


    
    // Getters y Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }
    public String getTipoMaterial() { return tipoMaterialPrincipal; }
    public void setTipoMaterial(String tipoMaterial) { this.tipoMaterialPrincipal = tipoMaterial; }
    public String getPedido() { return pedido; }
    public void setPedido(String pedido) { this.pedido = pedido; }
    public String getCantidadMeta() { return cantidad; }
    public void setCantidadMeta(String cantidadMeta) { this.cantidad = cantidadMeta; }
}