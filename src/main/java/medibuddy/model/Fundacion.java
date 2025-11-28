package medibuddy.model;

import jakarta.persistence.*;

@Entity
@Table(name = "fundacion")
@PrimaryKeyJoinColumn(name = "id_organizador")
public class Fundacion extends Organizador {

    // Este es el atributo original de tipo String que tenías en tu archivo
    @Column(name = "actividad")
    private String actividad;

    public Fundacion() {}

    public Fundacion(String nombre, String actividad, String direccion) {
        super(nombre, direccion);
        this.actividad = actividad;
    }

    // Getters y Setters
    public String getActividad() { return actividad; }
    public void setActividad(String actividad) { this.actividad = actividad; }
}