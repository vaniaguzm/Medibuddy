package medibuddy;

public class Usuario {
    public int idUsuario;
    public String nomUsuario;
    public String tipoUsuario;
    public String telefono;

    public Usuario(int idUsuario, String nomUsuario, String tipoUsuario, String telefono) {
        this.idUsuario = idUsuario;
        this.nomUsuario = nomUsuario;
        this.tipoUsuario = tipoUsuario;
        this.telefono = telefono;
    }

    public String getNomUsuario() {
        return nomUsuario;
    }

    public String obtener_datos() {
        return nomUsuario + " (" + tipoUsuario + ")";
    }

    public void actualizar_telefono(String nuevoTel) {
        this.telefono = nuevoTel;
    }

    public String recibir_notificacion(String mensaje) {
        return "Notificación para " + nomUsuario + ": " + mensaje;
    }
}


