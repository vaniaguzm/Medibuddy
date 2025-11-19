package medibuddy.legacy;

import java.util.ArrayList;

public class Fundacion {
    public int idFundacion;
    public String nomFundacion;
    public String direccion;
    public ArrayList<Actividad> actividades;

    public Fundacion(int idFundacion, String nomFundacion, String direccion) {
        this.idFundacion = idFundacion;
        this.nomFundacion = nomFundacion;
        this.direccion = direccion;
        this.actividades = new ArrayList<>();
    }

    public void agregar_actividad(Actividad actividad) {
        actividades.add(actividad);
    }

    public void listar_actividades() {
        for (Actividad a : actividades) {
            a.mostrarActividad();
        }
    }

    public String obtener_datos() {
        return "Fundación: " + nomFundacion + " - Dirección: " + direccion;
    }
}

