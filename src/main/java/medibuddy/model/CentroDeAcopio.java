package medibuddy.model;

import jakarta.persistence.*;

@Entity
@Table(name = "centro_de_acopio")
@PrimaryKeyJoinColumn(name = "id_organizador")
public class CentroDeAcopio extends Organizador {

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
    public String getTipoMaterialPrincipal() { return tipoMaterialPrincipal; }
    public void setTipoMaterialPrincipal(String tipo) { this.tipoMaterialPrincipal = tipo; }
    public String getPedido() { return pedido; }
    public void setPedido(String pedido) { this.pedido = pedido; }
    public String getCantidad() { return cantidad; }
    public void setCantidad(String cantidad) { this.cantidad = cantidad; }
}