package medibuddy;

import medibuddy.model.*;
import medibuddy.service.*;

import java.util.List;

public class Main {

    // Instanciamos los servicios (La capa de negocio)
    private static final AdultoMayorService adultoService = new AdultoMayorService();
    private static final FamiliarService familiarService = new FamiliarService();
    private static final FundacionService fundacionService = new FundacionService();
    private static final CentroDeAcopioService centroService = new CentroDeAcopioService();
    private static final MedicamentoService medicamentoService = new MedicamentoService();
    private static final ActividadService actividadService = new ActividadService();

    public static void main(String[] args) {
        System.out.println("=== INICIANDO SISTEMA MEDIBUDDY (V2.0) ===\n");

        try {
            // CASO 1: Registro de Usuarios (Validando relación 1 a 1)
            casoDeUso_RegistroUsuarios();

            // CASO 2: Gestión de Salud (Medicamentos N:M)
            casoDeUso_GestionSalud();

            // CASO 3: Organización de Eventos (Fundación crea actividad)
            casoDeUso_EventosFundacion();

            // CASO 4: Logística (Centro de Acopio crea actividad)
            casoDeUso_LogisticaCentro();

            // CASO 5: Inscripción (Adulto se inscribe a actividades)
            casoDeUso_Inscripcion();

            System.out.println("\n=== PRUEBAS FINALIZADAS CON ÉXITO ===");

        } catch (Exception e) {
            System.err.println("❌ Ocurrió un error en la ejecución:");
            e.printStackTrace();
        }
    }

    // -------------------------------------------------------------------
    // CASO 1: Registro de un Abuelo y su Familiar
    // -------------------------------------------------------------------
    private static void casoDeUso_RegistroUsuarios() {
        System.out.println("--- CASO 1: Registro de Usuarios ---");

        // 1. Crear Adulto Mayor
        AdultoMayor donPedro = new AdultoMayor(
            "Pedro Infante",
            "Adulto Mayor",
            "555-1010",
            "911"
        );
        // Agregamos los apellidos nuevos
        // (Asumiendo que tienes los setters generados en tu modelo)
        // donPedro.setApellidoPaterno("Infante"); 

        adultoService.crearAdultoMayor(donPedro);
        System.out.println("✅ Adulto Mayor creado: " + donPedro.obtenerDatos());

        // 2. Crear Familiar (Vinculado a Don Pedro)
        Familiar nietaLuisa = new Familiar(
            "Luisa Lane",
            "Familiar",
            "555-2020",
            "Nieta",
            donPedro // <--- Aquí pasamos el objeto del abuelo
        );

        familiarService.crearFamiliar(nietaLuisa);
        System.out.println("✅ Familiar creado: " + nietaLuisa.obtenerDatos() + 
                           " cuidando a -> " + nietaLuisa.getAdultoMayorAsociado().getNomUsuario());
    }

    // -------------------------------------------------------------------
    // CASO 2: Crear Medicamentos y Asignarlos
    // -------------------------------------------------------------------
    private static void casoDeUso_GestionSalud() {
        System.out.println("\n--- CASO 2: Gestión de Salud ---");

        // 1. Crear Medicamento en el catálogo
        Medicamento aspirina = new Medicamento(
            "Aspirina Protect",
            "100mg",
            "08:00 AM",
            "Oral"
        );
        // aspirina.setPresentacionMedicamento("Caja 30 tabletas"); // Campo nuevo
        
        medicamentoService.crearMedicamento(aspirina);
        System.out.println("✅ Medicamento registrado: " + aspirina.verInfoMedicamento());

        // 2. Asignar al Adulto Mayor (Usando el ID que tenga en BD, asumimos ID=1 si es base nueva)
        // Para el ejemplo buscamos al primer adulto de la lista
        List<AdultoMayor> lista = adultoService.listarAdultosMayores();
        if (!lista.isEmpty()) {
            AdultoMayor abuelo = lista.get(0);
            
            // Usamos el servicio para conectar
            adultoService.agregarMedicamentoAAdultoMayor(abuelo.getIdUsuario(), aspirina);
            System.out.println("✅ Medicina asignada a: " + abuelo.getNomUsuario());
        }
    }

    // -------------------------------------------------------------------
    // CASO 3: Fundación crea Actividad
    // -------------------------------------------------------------------
    private static void casoDeUso_EventosFundacion() {
        System.out.println("\n--- CASO 3: Eventos de Fundación ---");

        // 1. Crear Fundación
        Fundacion fundacionAlegría = new Fundacion(
            "Fundación Alegría",
            "Recreativa", // actividad (String)
            "Calle de la Felicidad 123"
        );
        fundacionService.crearFundacion(fundacionAlegría);

        // 2. Crear Actividad
        Actividad baile = new Actividad(
            "Baile de Salón",
            "Tarde de Danzón",
            "2023-12-01",
            "Salón Principal",
            50
        );

        // 3. La Fundación organiza la actividad (Usando el nuevo método del Service)
        fundacionService.crearActividadFundacion(fundacionAlegría.getId(), baile);
        System.out.println("✅ Fundación '" + fundacionAlegría.getNombre() + 
                           "' organizó: " + baile.getNomActividad());
    }

    // -------------------------------------------------------------------
    // CASO 4: Centro de Acopio crea Actividad (¡Nuevo poder!)
    // -------------------------------------------------------------------
    private static void casoDeUso_LogisticaCentro() {
        System.out.println("\n--- CASO 4: Centro de Acopio ---");

        // 1. Crear Centro
        CentroDeAcopio centroSur = new CentroDeAcopio(
            "Acopio Sur",
            "Av. Industrias",
            "Plástico",
            "Botellas PET",
            "500kg"
        );
        centroService.crearCentro(centroSur);

        // 2. Crear Actividad de Recolección
        Actividad reciclaton = new Actividad(
            "Reciclatón 2023",
            "Trae tus botellas",
            "2023-11-20",
            "Parque Central",
            1000
        );

        // 3. El Centro organiza la actividad
        centroService.crearActividadParaCentro(centroSur.getId(), reciclaton);
        System.out.println("✅ Centro '" + centroSur.getNombre() + 
                           "' organizó: " + reciclaton.getNomActividad());
    }

    // -------------------------------------------------------------------
    // CASO 5: Inscripción del Abuelo a Actividades
    // -------------------------------------------------------------------
    private static void casoDeUso_Inscripcion() {
        System.out.println("\n--- CASO 5: Inscripciones ---");

        List<AdultoMayor> adultos = adultoService.listarAdultosMayores();
        List<Actividad> actividades = actividadService.listarActividades();

        if (!adultos.isEmpty() && !actividades.isEmpty()) {
            AdultoMayor donPedro = adultos.get(0);
            Actividad actividad = actividades.get(0); // Por ejemplo, el Baile

            // Inscribimos usando el servicio
            adultoService.inscribirEnActividad(donPedro.getIdUsuario(), actividad.getIdActividad());
            
            System.out.println("✅ " + donPedro.getNomUsuario() + 
                               " se inscribió exitosamente en: " + actividad.getNomActividad());
        } else {
            System.out.println("⚠️ No hay suficientes datos para probar la inscripción.");
        }
    }
}