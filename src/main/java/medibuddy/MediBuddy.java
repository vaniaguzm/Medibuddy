package medibuddy;

import medibuddy.model.*;
import medibuddy.service.*;
import java.time.LocalDate;
public class MediBuddy {

    public static void main(String[] args) {
        System.out.println("=== INICIANDO SISTEMA MEDIBUDDY ===");

        // 1. Instanciar Servicios
        UsuarioService usuarioService = new UsuarioService(); // Para consultas generales
        AdultoMayorService adultoMayorService = new AdultoMayorService();
        FamiliarService familiarService = new FamiliarService();
        MedicamentoService medicamentoService = new MedicamentoService();
        CentroDeAcopioService centroService = new CentroDeAcopioService();
        FundacionService fundacionService = new FundacionService();

        try {
            // =================================================================
            // ESCENARIO 1: Herencia y Relación Familiar -> Adulto Mayor
            // =================================================================
            System.out.println("\n--- PRUEBA 1: CREACIÓN DE USUARIOS (HERENCIA) ---");

            // A. Crear un Adulto Mayor (Don Roberto)
            AdultoMayor abuelo = new AdultoMayor("Don Roberto", "Adulto Mayor", "555-1234", "Hijo Pedro");
            adultoMayorService.crearAdultoMayor(abuelo);
            System.out.println("Adulto Mayor creado con ID: " + abuelo.getIdUsuario());

            // B. Crear un Familiar (Nieto Juan) y asignarle el abuelo
            // Nota: Pasamos el objeto 'abuelo' que ya tiene ID porque fue guardado en el paso anterior
            Familiar nieto = new Familiar("Juan Pérez", "Familiar", "555-9876", "Nieto", abuelo);
            familiarService.crearFamiliar(nieto);
            System.out.println("Familiar creado: " + nieto.getNomUsuario() + 
                               ", cuidando a: " + nieto.getAdultoMayorAsociado().getNomUsuario());

            // =================================================================
            // ESCENARIO 2: Relación OneToMany EAGER (Adulto -> Medicamentos)
            // =================================================================
            System.out.println("\n--- PRUEBA 2: MEDICAMENTOS (EAGER LOADING) ---");

            // A. Crear Medicamento
            Medicamento paracetamol = new Medicamento("Paracetamol", "500mg", "08:00 AM");
            // No necesitamos guardar el medicamento explícitamente si usamos CascadeType.ALL en AdultoMayor,
            // pero tu lógica actual sugiere agregarlo a la lista y actualizar el adulto.
            
            // B. Usar el servicio para vincular (esto prueba tu método 'agregarMedicamentoAAdultoMayor')
            adultoMayorService.agregarMedicamentoAAdultoMayor(abuelo.getIdUsuario(), paracetamol);
            
            // C. Verificar recuperación (Gracias al FetchType.EAGER, esto no fallará aquí)
            AdultoMayor abueloRecuperado = adultoMayorService.buscarAdultoMayorPorId(abuelo.getIdUsuario());
            System.out.println("Medicamentos de " + abueloRecuperado.getNomUsuario() + ":");
            for (Medicamento m : abueloRecuperado.getMedicamentos()) {
                System.out.println(" - " + m.getNomMedicamento() + " (" + m.getDosis() + ")");
            }

            // =================================================================
            // ESCENARIO 3: Relación Bidireccional (Centro <-> Entrega)
            // =================================================================
            System.out.println("\n--- PRUEBA 3: CENTRO DE ACOPIO (BIDIRECCIONAL) ---");

            // A. Crear Centro
            CentroDeAcopio centro = new CentroDeAcopio("Centro Norte", "Av. Siempre Viva 123", "Plástico");
            centroService.crearCentro(centro);

            // B. Crear Entrega y registrarla usando el método de negocio
            Entrega entrega1 = new Entrega("Botellas PET", 50.5f, LocalDate.now());
            
            // Este método es clave: hace el 'setCentroDeAcopio' y el 'add' a la lista
            centroService.registrarEntregaEnCentro(centro.getId(), entrega1);

            // C. Verificación visual
            // Nota: Si CentroDeAcopio es LAZY (por defecto), acceder a getEntregas() aquí podría fallar 
            // si la sesión ya cerró. Pero como acabamos de ejecutar la lógica, vamos a confiar en el log del servicio.
            System.out.println("Entrega procesada en centro ID: " + centro.getId());

            // =================================================================
            // ESCENARIO 4: Relación Unidireccional (Fundacion -> Actividad)
            // =================================================================
            System.out.println("\n--- PRUEBA 4: FUNDACIÓN Y ACTIVIDADES ---");

            // A. Crear Fundación
            Fundacion fundacion = new Fundacion("Corazones Unidos", "Calle Falsa 123");
            fundacionService.crearFundacion(fundacion);

            // B. Crear Actividad
            Actividad bingo = new Actividad("Bingo Bailable", "Recreación", "2023-12-25", "Salón Comunal", 50);
            
            // C. Vincular (Hibernate creará la FK en la tabla actividad automáticamente)
            fundacionService.agregarActividadAFundacion(fundacion.getId(), bingo);
            
            System.out.println("Actividad agregada a fundación: " + fundacion.getNombre());

            // =================================================================
            // ESCENARIO 6: Actualización (Update)
            // =================================================================
            System.out.println("\n--- PRUEBA 6: ACTUALIZACIÓN DE DATOS ---");
            
            // Cambiamos el dato en memoria
            abuelo.setTelefono("999-0000"); 
            // Llamamos al servicio para actualizar
            adultoMayorService.actualizarAdultoMayor(abuelo);
            
            // Verificamos recuperando de nuevo
            AdultoMayor abueloActualizado = adultoMayorService.buscarAdultoMayorPorId(abuelo.getIdUsuario());
            System.out.println("Nuevo teléfono de Don Roberto: " + abueloActualizado.getTelefono());
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Hubo un error en la ejecución de la prueba.");
        } finally {
            // IMPORTANTE: Si tienes un método para cerrar el SessionFactory, llámalo aquí.
            // HibernateUtil.shutdown(); 
            System.out.println("\n=== PRUEBA FINALIZADA ===");
        }
    }
}