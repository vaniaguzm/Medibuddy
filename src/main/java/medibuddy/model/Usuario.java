package medibuddy.model;

import jakarta.persistence.*;

@Entity
@Table(name = "usuario")
@Inheritance(strategy = InheritanceType.JOINED) // Para herencia con AdultoMayor
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private int idUsuario;

    @Column(name = "nom_usuario")
    private String nomUsuario;

    @Column(name = "apellidoPaterno")
    private String apellidoPaterno;

    @Column(name = "apellidoMaterno")
    private String apellidoMaterno;

    @Column(name = "tipo_usuario")
    private String tipoUsuario;

    @Column(name = "telefono")
    private String telefono;

    // Constructores
    public Usuario() {}

    public Usuario(int idUsuario, String nomUsuario, String tipoUsuario, String telefono) {
        this.idUsuario = idUsuario;
        this.nomUsuario = nomUsuario;
        this.tipoUsuario = tipoUsuario;
        this.telefono = telefono;
    }

    // Getters y Setters
    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNomUsuario() {
        return nomUsuario;
    }

    public void setNomUsuario(String nomUsuario) {
        this.nomUsuario = nomUsuario;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    // Métodos de negocio
    public String obtenerDatos() {
        return nomUsuario + " (" + tipoUsuario + ")";
    }

    public void actualizarTelefono(String nuevoTel) {
        this.telefono = nuevoTel;
    }

    public String recibirNotificacion(String mensaje) {
        return "Notificación para " + nomUsuario + ": " + mensaje;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "idUsuario=" + idUsuario +
                ", nomUsuario='" + nomUsuario + '\'' +
                ", tipoUsuario='" + tipoUsuario + '\'' +
                ", telefono='" + telefono + '\'' +
                '}';
    }
}
