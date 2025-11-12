 package medibuddy;

public class Actividad {
    public int idActividad;
    public String nomActividad;
    public String descripcion;
    public String fecha;
    public String ubicacion;
    int cupoMaximo;

    public Actividad(int idActividad, String nomActividad, String descripcion, String fecha, String ubicacion, int cupoMaximo) {
        this.idActividad = idActividad;
        this.nomActividad = nomActividad;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.ubicacion = ubicacion;
        this.cupoMaximo = cupoMaximo;
    }

    public void crear_actividad() {
        System.out.println("Actividad creada: " + nomActividad);
    }

    public void inscribir_usuario(Usuario usuario) {
        System.out.println(usuario.nomUsuario + " inscrito a " + nomActividad);
    }

    public void cancelar_inscripcion(Usuario usuario) {
        System.out.println(usuario.nomUsuario + " canceló su inscripción a " + nomActividad);
    }

    public void mostrarActividad() {
        System.out.println("Actividad: " + nomActividad + " - Fecha: " + fecha + " - Lugar: " + ubicacion + " - Cupo: " + cupoMaximo);
    }
}
