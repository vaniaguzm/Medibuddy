package medibuddy;

import medibuddy.model.*;
import medibuddy.service.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class MediBuddy {

    // 1. Instanciamos los Servicios (Capa de Negocio)
    // Son estáticos para acceder a ellos desde cualquier método del menú
    private static final AdultoMayorService adultoService = new AdultoMayorService();
    private static final FamiliarService familiarService = new FamiliarService();
    private static final CentroDeAcopioService centroService = new CentroDeAcopioService();
    private static final FundacionService fundacionService = new FundacionService();

    // Scanner para leer entrada del usuario
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean salir = false;

        while (!salir) {
            limpiarConsola();
            System.out.println("=========================================");
            System.out.println("       SISTEMA DE GESTIÓN MEDIBUDDY      ");
            System.out.println("=========================================");
            System.out.println("1. Gestión de Usuarios (Adultos y Familiares)");
            System.out.println("2. Gestión Médica (Medicamentos y Recordatorios)");
            System.out.println("3. Logística (Centros de Acopio y Entregas)");
            System.out.println("4. Responsabilidad Social (Fundaciones)");
            System.out.println("0. Salir");
            System.out.println("=========================================");
            System.out.print("Seleccione una opción: ");

            int opcion = leerEntero();

            switch (opcion) {
                case 1 -> moduloUsuarios();
                case 2 -> moduloMedica();
                case 3 -> moduloLogistica();
                case 4 -> moduloSocial();
                case 0 -> {
                    System.out.println("Cerrando sistema...");
                    salir = true;
                }
                default -> System.out.println("Opción no válida.");
            }
        }
        scanner.close();
    }

    // =======================================================
    // MÓDULO 1: USUARIOS (Adultos Mayores y Familiares)
    // =======================================================
    private static void moduloUsuarios() {
        System.out.println("\n--- GESTIÓN DE USUARIOS ---");
        System.out.println("1. Registrar Adulto Mayor");
        System.out.println("2. Registrar Familiar (y asignar a Adulto)");
        System.out.println("3. Listar todos los Adultos Mayores");
        System.out.print("Opción: ");
        
        int op = leerEntero();
        
        switch (op) {
            case 1 -> {
                System.out.print("Nombre: ");
                String nom = scanner.nextLine();
                System.out.print("Teléfono: ");
                String tel = scanner.nextLine();
                System.out.print("Contacto de Emergencia: ");
                String contacto = scanner.nextLine();

                AdultoMayor am = new AdultoMayor(nom, "Adulto Mayor", tel, contacto);
                adultoService.crearAdultoMayor(am);
                System.out.println("✅ Adulto Mayor registrado con ID: " + am.getIdUsuario());
            }
            case 2 -> {
                System.out.print("ID del Adulto Mayor a cuidar: ");
                int idAm = leerEntero();
                AdultoMayor am = adultoService.buscarAdultoMayorPorId(idAm);

                if (am != null) {
                    System.out.print("Nombre del Familiar: ");
                    String nom = scanner.nextLine();
                    System.out.print("Teléfono: ");
                    String tel = scanner.nextLine();
                    System.out.print("Parentesco (Hijo/Nieto/etc): ");
                    String rel = scanner.nextLine();

                    // Aquí se crea la relación ManyToOne
                    Familiar fam = new Familiar(nom, "Familiar", tel, rel, am);
                    familiarService.crearFamiliar(fam);
                    System.out.println("✅ Familiar registrado y vinculado a " + am.getNomUsuario());
                } else {
                    System.out.println("❌ Error: No existe ese Adulto Mayor.");
                }
            }
            case 3 -> {
                List<AdultoMayor> lista = adultoService.listarAdultosMayores();
                System.out.println("\n--- LISTA DE ADULTOS MAYORES ---");
                for (AdultoMayor a : lista) {
                    System.out.println("ID: " + a.getIdUsuario() + " | Nombre: " + a.getNomUsuario() + " | Emergencia: " + a.getContactoEmergencia());
                }
            }
        }
        esperarTecla();
    }

    // =======================================================
    // MÓDULO 2: MÉDICA (Medicamentos)
    // =======================================================
    private static void moduloMedica() {
        System.out.println("\n--- GESTIÓN MÉDICA ---");
        System.out.println("1. Agregar Medicamento a un Adulto Mayor");
        System.out.println("2. Ver Medicamentos de un Adulto Mayor");
        System.out.print("Opción: ");

        int op = leerEntero();

        if (op == 1) {
            System.out.print("ID del Adulto Mayor: ");
            int id = leerEntero();
            
            // Verificamos existencia simple primero
            if (adultoService.buscarAdultoMayorPorId(id) != null) {
                System.out.print("Nombre del Medicamento: ");
                String nom = scanner.nextLine();
                System.out.print("Dosis: ");
                String dosis = scanner.nextLine();
                System.out.print("Hora (Ej. 08:00): ");
                String hora = scanner.nextLine();

                Medicamento med = new Medicamento(nom, dosis, hora);
                
                // Lógica de negocio: El servicio maneja la transacción y actualización
                adultoService.agregarMedicamentoAAdultoMayor(id, med);
                System.out.println("✅ Medicamento recetado correctamente.");
            } else {
                System.out.println("❌ Usuario no encontrado.");
            }
        } else if (op == 2) {
            System.out.print("ID del Adulto Mayor: ");
            int id = leerEntero();
            AdultoMayor am = adultoService.buscarAdultoMayorPorId(id); // Esto funciona porque es EAGER
            if (am != null) {
                am.listarMedicamentos(); // Método interno de la entidad
            }
        }
        esperarTecla();
    }

    // =======================================================
    // MÓDULO 3: LOGÍSTICA (Centros y Entregas)
    // =======================================================
    private static void moduloLogistica() {
        System.out.println("\n--- LOGÍSTICA Y RECICLAJE ---");
        System.out.println("1. Crear Centro de Acopio");
        System.out.println("2. Registrar Entrega en Centro (Bidireccional)");
        System.out.print("Opción: ");

        int op = leerEntero();

        switch (op) {
            case 1 -> {
                System.out.print("Nombre Centro: ");
                String nom = scanner.nextLine();
                System.out.print("Dirección: ");
                String dir = scanner.nextLine();
                CentroDeAcopio centro = new CentroDeAcopio(nom, dir, "General");
                centroService.crearCentro(centro);
                System.out.println("✅ Centro creado con ID: " + centro.getId());
            }
            case 2 -> {
                System.out.print("ID del Centro de Acopio: ");
                int idCentro = leerEntero();
                
                System.out.print("Material: ");
                String mat = scanner.nextLine();
                System.out.print("Cantidad (kg): ");
                // Pequeño hack para leer float de forma segura
                float cant = Float.parseFloat(scanner.nextLine()); 

                Entrega entrega = new Entrega(mat, cant, LocalDate.now());

                // IMPORTANTE: Aquí llamamos al método que usa JOIN FETCH para evitar LazyInitializationException
                centroService.registrarEntregaEnCentro(idCentro, entrega);
            }
        }
        esperarTecla();
    }

    // =======================================================
    // MÓDULO 4: SOCIAL (Fundaciones)
    // =======================================================
    private static void moduloSocial() {
        System.out.println("\n--- FUNDACIONES Y ACTIVIDADES ---");
        System.out.println("1. Registrar Fundación");
        System.out.println("2. Agregar Actividad a Fundación");
        System.out.println("3. Eliminar Fundación (Prueba de Cascade Delete)");
        System.out.print("Opción: ");

        int op = leerEntero();

        switch (op) {
            case 1 -> {
                System.out.print("Nombre Fundación: ");
                String nom = scanner.nextLine();
                System.out.print("Dirección: ");
                String dir = scanner.nextLine();
                Fundacion fun = new Fundacion(nom, dir);
                fundacionService.crearFundacion(fun);
                System.out.println("✅ Fundación creada con ID: " + fun.getId());
            }
            case 2 -> {
                System.out.print("ID de la Fundación: ");
                int idFun = leerEntero();
                
                System.out.print("Nombre Actividad: ");
                String actNom = scanner.nextLine();
                System.out.print("Descripción: ");
                String desc = scanner.nextLine();
                
                Actividad actividad = new Actividad(actNom, desc, "2023-12-01", "Sede", 20);
                
                // Usamos el servicio que gestiona la relación Unidireccional con seguridad
                fundacionService.agregarActividadAFundacion(idFun, actividad);
            }
            case 3 -> {
                System.out.print("ID de Fundación a eliminar: ");
                int idDel = leerEntero();
                Fundacion f = fundacionService.buscarFundacionPorId(idDel);
                if (f != null) {
                    fundacionService.eliminarFundacion(f);
                    System.out.println("🗑️ Fundación eliminada (y sus actividades también, por Cascada).");
                } else {
                    System.out.println("❌ ID no encontrado.");
                }
            }
        }
        esperarTecla();
    }

    // =======================================================
    // UTILIDADES
    // =======================================================

    // Método seguro para leer enteros y consumir el salto de línea
    private static int leerEntero() {
        try {
            String entrada = scanner.nextLine();
            return Integer.parseInt(entrada);
        } catch (NumberFormatException e) {
            System.out.println("⚠️ Entrada inválida. Se asumirá 0.");
            return -1;
        }
    }

    private static void esperarTecla() {
        System.out.println("\n[Presione Enter para continuar...]");
        scanner.nextLine();
    }
    
    private static void limpiarConsola() {
        // Simulación de limpieza imprimiendo líneas vacías
        for(int i = 0; i < 2; i++) System.out.println();
    }
}