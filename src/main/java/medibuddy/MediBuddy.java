package medibuddy;

import medibuddy.model.Actividad;
import medibuddy.service.ActividadService;

public class MediBuddy {
    public static void main(String[] args) {
        ActividadService service = new ActividadService();
        Actividad actividad = new Actividad("Yogav2", "Clase de yoga para adultos mayores", "2025-12-01", "Parque Central", 20);
        service.crearActividad(actividad);
        System.out.println("Actividades: " + service.listarActividades());
    }
}



