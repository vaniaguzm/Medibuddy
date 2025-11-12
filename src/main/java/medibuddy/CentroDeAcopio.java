package medibuddy;

public class CentroDeAcopio {
    public int idCentroDeAcopio;
    public String nomCentroDeAcopio;
    public String direccion;
    public String tipoMaterial;

    public CentroDeAcopio(int idCentroDeAcopio, String nomCentroDeAcopio, String direccion, String tipoMaterial) {
        this.idCentroDeAcopio = idCentroDeAcopio;
        this.nomCentroDeAcopio = nomCentroDeAcopio;
        this.direccion = direccion;
        this.tipoMaterial = tipoMaterial;
    }

    public void agregar_centro() {
        System.out.println("Centro agregado: " + nomCentroDeAcopio);
    }

    public void agregar_actividad(Actividad actividad) {
        System.out.println("Actividad añadida al centro: " + nomCentroDeAcopio + " -> " + actividad.nomActividad);
    }

    public void registrar_entrega(String material, float cantidadMaterial) {
        System.out.println("Entrega registrada: " + cantidadMaterial + "kg de " + material);
    }
}

