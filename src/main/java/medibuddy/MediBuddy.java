package medibuddy;

import medibuddy.model.*;
import medibuddy.service.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class MediBuddy {

    // ==========================================
    // 1. SERVICIOS (SINGLETONS / ESTÁTICOS)
    // ==========================================
    private static final UsuarioService usuarioService = new UsuarioService();
    private static final AdultoMayorService adultoService = new AdultoMayorService();
    private static final FamiliarService familiarService = new FamiliarService();
    private static final MedicamentoService medicamentoService = new MedicamentoService();
    private static final CentroDeAcopioService centroService = new CentroDeAcopioService();
    private static final FundacionService fundacionService = new FundacionService();
    
    // Scanner global
    private static final Scanner scanner = new Scanner(System.in);

    // ==========================================
    // 2. PUNTO DE ENTRADA
    // ==========================================
    public static void main(String[] args) {
        boolean salir = false;

        while (!salir) {
            limpiarPantalla();
            imprimirEncabezado("PANEL DE CONTROL PRINCIPAL");
            
            System.out.println("  1. 👥  MÓDULO DE USUARIOS");
            System.out.println("      [Registrar Adultos, Familiares, Actualizar Datos]");
            
            System.out.println("  2. 💊  MÓDULO MÉDICO");
            System.out.println("      [Recetar, Ver Historial, Simular Tomas]");
            
            System.out.println("  3. ♻️  LOGÍSTICA Y ACOPIO");
            System.out.println("      [Centros de Acopio, Registrar Entregas]");
            
            System.out.println("  4. 🤝  RESPONSABILIDAD SOCIAL");
            System.out.println("      [Fundaciones, Actividades, Voluntariado]");
            
            System.out.println("  0. 🚪  SALIR");
            System.out.println("=================================================");
            System.out.print("  >> Seleccione una opción: ");

            int opcion = leerEntero();

            try {
                switch (opcion) {
                    case 1 -> menuUsuarios();
                    case 2 -> menuMedica();
                    case 3 -> menuLogistica();
                    case 4 -> menuSocial();
                    case 0 -> {
                        System.out.println("\n👋 ¡Hasta luego! Cerrando MediBuddy...");
                        salir = true;
                    }
                    default -> System.out.println("❌ Opción no válida.");
                }
            } catch (Exception e) {
                System.out.println("❌ Error inesperado: " + e.getMessage());
                e.printStackTrace();
                esperarEnter();
            }
        }
        scanner.close();
    }

    // ==========================================
    // 3. MÓDULO DE USUARIOS (Detallado)
    // ==========================================
    private static void menuUsuarios() {
        boolean regresar = false;
        while (!regresar) {
            limpiarPantalla();
            imprimirEncabezado("GESTIÓN DE USUARIOS");
            
            System.out.println("--- 📝 REGISTROS ---");
            System.out.println("  1. Nuevo Adulto Mayor");
            System.out.println("  2. Nuevo Familiar (y asignar a Adulto)");
            
            System.out.println("\n--- ⚙️  OPERACIONES ---");
            System.out.println("  3. Actualizar Teléfono de Usuario");
            System.out.println("  4. Enviar Notificación de Prueba");
            
            System.out.println("\n--- 🔍 CONSULTAS ---");
            System.out.println("  5. Ver Directorio de Adultos Mayores");
            
            System.out.println("\n  0. Volver al Menú Principal");
            System.out.println("=================================================");
            System.out.print("  >> Opción: ");
            
            int op = leerEntero();

            switch (op) {
                case 1 -> registrarAdulto();
                case 2 -> registrarFamiliar();
                case 3 -> actualizarTelefonoUsuario();
                case 4 -> probarNotificacion();
                case 5 -> listarAdultos();
                case 0 -> regresar = true;
                default -> System.out.println("Opción no válida.");
            }
            if (!regresar) esperarEnter();
        }
    }

    // Métodos auxiliares de Usuarios
    private static void registrarAdulto() {
        System.out.println("\n--- REGISTRAR ADULTO MAYOR ---");
        System.out.print("Nombre Completo: "); String nom = scanner.nextLine();
        System.out.print("Teléfono Personal: "); String tel = scanner.nextLine();
        System.out.print("Contacto Emergencia: "); String cont = scanner.nextLine();
        
        AdultoMayor am = new AdultoMayor(nom, "Adulto Mayor", tel, cont);
        adultoService.crearAdultoMayor(am);
        System.out.println("✅ Éxito. ID Generado: " + am.getIdUsuario());
    }

    private static void registrarFamiliar() {
        System.out.println("\n--- REGISTRAR FAMILIAR ---");
        System.out.print("ID del Adulto a cuidar: "); int idAm = leerEntero();
        AdultoMayor am = adultoService.buscarAdultoMayorPorId(idAm);
        
        if (am != null) {
            System.out.print("Nombre Familiar: "); String nom = scanner.nextLine();
            System.out.print("Teléfono: "); String tel = scanner.nextLine();
            System.out.print("Parentesco (Hijo, Nieto, etc): "); String rel = scanner.nextLine();
            
            Familiar fam = new Familiar(nom, "Familiar", tel, rel, am);
            familiarService.crearFamiliar(fam);
            System.out.println("✅ Familiar registrado y vinculado a: " + am.getNomUsuario());
        } else {
            System.out.println("❌ Adulto Mayor no encontrado.");
        }
    }

    private static void actualizarTelefonoUsuario() {
        System.out.println("\n--- ACTUALIZAR TELÉFONO ---");
        System.out.print("ID Usuario (Adulto o Familiar): "); int id = leerEntero();
        Usuario u = usuarioService.buscarUsuarioPorId(id);
        
        if (u != null) {
            System.out.println("Teléfono actual: " + u.getTelefono());
            System.out.print("Nuevo teléfono: "); String nuevo = scanner.nextLine();
            u.actualizarTelefono(nuevo); // Lógica de negocio
            usuarioService.actualizarUsuario(u); // Persistencia
            System.out.println("✅ Teléfono actualizado correctamente.");
        } else {
            System.out.println("❌ Usuario no encontrado.");
        }
    }

    private static void probarNotificacion() {
        System.out.print("ID Usuario a notificar: "); int id = leerEntero();
        Usuario u = usuarioService.buscarUsuarioPorId(id);
        if (u != null) {
            System.out.println(">> " + u.recibirNotificacion("¡Bienvenido al sistema MediBuddy!"));
        } else {
            System.out.println("❌ Usuario no encontrado.");
        }
    }

    private static void listarAdultos() {
        List<AdultoMayor> lista = adultoService.listarAdultosMayores();
        System.out.println("\n--- DIRECTORIO ADULTOS MAYORES ---");
        System.out.printf("%-5s %-25s %-15s\n", "ID", "NOMBRE", "EMERGENCIA");
        System.out.println("-------------------------------------------------");
        for (AdultoMayor a : lista) {
            System.out.printf("%-5d %-25s %-15s\n", a.getIdUsuario(), a.getNomUsuario(), a.getContactoEmergencia());
        }
    }

    // ==========================================
    // 4. MÓDULO MÉDICO (Detallado)
    // ==========================================
    private static void menuMedica() {
        boolean regresar = false;
        while (!regresar) {
            limpiarPantalla();
            imprimirEncabezado("GESTIÓN MÉDICA");
            
            System.out.println("--- 💊 PRESCRIPCIONES ---");
            System.out.println("  1. Recetar Medicamento a Paciente");
            
            System.out.println("\n--- 🩺 SEGUIMIENTO ---");
            System.out.println("  2. Ver Medicamentos de un Paciente");
            System.out.println("  3. Simular Toma (Recordatorio -> Confirmación)");
            
            System.out.println("\n  0. Volver al Menú Principal");
            System.out.println("=================================================");
            System.out.print("  >> Opción: ");
            
            int op = leerEntero();

            switch (op) {
                case 1 -> recetarMedicamento();
                case 2 -> verMedicamentos();
                case 3 -> simularToma();
                case 0 -> regresar = true;
                default -> System.out.println("Opción no válida.");
            }
            if (!regresar) esperarEnter();
        }
    }

    private static void recetarMedicamento() {
        System.out.print("ID del Paciente (Adulto Mayor): "); int id = leerEntero();
        AdultoMayor am = adultoService.buscarAdultoMayorPorId(id);
        
        if (am != null) {
            System.out.print("Medicamento: "); String nom = scanner.nextLine();
            System.out.print("Dosis: "); String dos = scanner.nextLine();
            System.out.print("Hora (e.g. 08:00): "); String hora = scanner.nextLine();
            System.out.print("Modo de Administracion: "); String modA = scanner.nextLine();
            
            Medicamento med = new Medicamento(nom, dos, hora,modA);
            adultoService.agregarMedicamentoAAdultoMayor(id, med);
            System.out.println("✅ Medicamento agregado al expediente.");
        } else {
            System.out.println("❌ Paciente no encontrado.");
        }
    }

    private static void verMedicamentos() {
        System.out.print("ID del Paciente: "); int id = leerEntero();
        AdultoMayor am = adultoService.buscarAdultoMayorPorId(id);
        if (am != null) {
            am.listarMedicamentos();
        } else {
            System.out.println("❌ Paciente no encontrado.");
        }
    }

    private static void simularToma() {
        System.out.println("\n--- SIMULACIÓN DE RECORDATORIO ---");
        System.out.print("ID del Paciente: "); int id = leerEntero();
        AdultoMayor am = adultoService.buscarAdultoMayorPorId(id);
        
        if (am != null && !am.getMedicamentos().isEmpty()) {
            // Tomamos el primer medicamento para el ejemplo
            Medicamento med = am.getMedicamentos().get(0);
            
            System.out.println(">> ⏰ Hora: " + med.getHoraRecordatorio());
            med.enviarRecordatorioAAdultoMayor(am);
            am.aceptarRecordatorio(med);
            med.confirmarToma();
            System.out.println("✅ Ciclo completado.");
        } else {
            System.out.println("❌ El paciente no existe o no tiene medicinas registradas.");
        }
    }

    // ==========================================
    // 5. MÓDULO LOGÍSTICA (Detallado)
    // ==========================================
    private static void menuLogistica() {
        boolean regresar = false;
        while (!regresar) {
            limpiarPantalla();
            imprimirEncabezado("LOGÍSTICA Y RECICLAJE");
            
            System.out.println("--- 🏢 INFRAESTRUCTURA ---");
            System.out.println("  1. Registrar Nuevo Centro de Acopio");
            System.out.println("  2. Listar Centros Activos");
            
            System.out.println("\n--- 🚚 OPERACIONES ---");
            System.out.println("  3. Registrar Entrega de Material (Bidireccional)");
            
            System.out.println("\n  0. Volver al Menú Principal");
            System.out.println("=================================================");
            System.out.print("  >> Opción: ");
            
            int op = leerEntero();

            switch (op) {
                case 1 -> registrarCentro();
                case 2 -> listarCentros();
                case 3 -> registrarEntrega();
                case 0 -> regresar = true;
                default -> System.out.println("Opción no válida.");
            }
            if (!regresar) esperarEnter();
        }
    }

    private static void registrarCentro() {
        System.out.print("Nombre del Centro: "); String nom = scanner.nextLine();
        System.out.print("Dirección: "); String dir = scanner.nextLine();
        CentroDeAcopio c = new CentroDeAcopio(nom, dir, "Multimaterial");
        centroService.crearCentro(c);
        System.out.println("✅ Centro registrado con ID: " + c.getId());
    }

    private static void listarCentros() {
        List<CentroDeAcopio> lista = centroService.listarCentros();
        System.out.println("\n--- CENTROS DE ACOPIO ---");
        for (CentroDeAcopio c : lista) {
            System.out.println("ID: " + c.getId() + " | " + c.getNombre() + " | " + c.getDireccion());
        }
    }

    private static void registrarEntrega() {
        System.out.print("ID del Centro de Acopio: "); int idC = leerEntero();
        // Validamos existencia previa (opcional, el servicio también lo valida)
        CentroDeAcopio c = centroService.buscarCentroPorId(idC);
        
        if (c != null) {
            System.out.print("Material (Papel/Plástico/Vidrio): "); String mat = scanner.nextLine();
            System.out.print("Peso (Kg): "); float kgs = Float.parseFloat(scanner.nextLine());
            
            Entrega entrega = new Entrega(mat, kgs, LocalDate.now());
            centroService.registrarEntregaEnCentro(idC, entrega);
            // El mensaje de éxito está en el servicio
        } else {
            System.out.println("❌ Centro no encontrado.");
        }
    }

    // ==========================================
    // 6. MÓDULO SOCIAL (Detallado)
    // ==========================================
    private static void menuSocial() {
        boolean regresar = false;
        while (!regresar) {
            limpiarPantalla();
            imprimirEncabezado("FUNDACIONES Y ACTIVIDADES");
            
            System.out.println("--- 🤝 ORGANIZACIONES ---");
            System.out.println("  1. Registrar Fundación Aliada");
            System.out.println("  2. Eliminar Fundación (Cuidado: Cascada)");
            
            System.out.println("\n--- 📅 EVENTOS ---");
            System.out.println("  3. Programar Actividad en Fundación");
            
            System.out.println("\n  0. Volver al Menú Principal");
            System.out.println("=================================================");
            System.out.print("  >> Opción: ");
            
            int op = leerEntero();

            switch (op) {
                case 1 -> registrarFundacion();
                case 2 -> eliminarFundacion();
                case 3 -> programarActividad();
                case 0 -> regresar = true;
                default -> System.out.println("Opción no válida.");
            }
            if (!regresar) esperarEnter();
        }
    }

    private static void registrarFundacion() {
        System.out.print("Nombre Fundación: "); String nom = scanner.nextLine();
        System.out.print("Sede: "); String sede = scanner.nextLine();
        System.out.print("Actividad: "); String acti = scanner.nextLine();
        Fundacion f = new Fundacion(nom, sede,acti);
        fundacionService.crearFundacion(f);
        System.out.println("✅ Fundación creada con ID: " + f.getId());
    }

    private static void eliminarFundacion() {
        System.out.print("ID de Fundación a eliminar: "); int id = leerEntero();
        Fundacion f = fundacionService.buscarFundacionPorId(id);
        if (f != null) {
            System.out.println("⚠️ ADVERTENCIA: Esto borrará la fundación '" + f.getNombre() + "' y todas sus actividades.");
            System.out.print("¿Seguro? (1=Si, 0=No): ");
            if (leerEntero() == 1) {
                fundacionService.eliminarFundacion(f);
                System.out.println("🗑️ Fundación eliminada.");
            }
        } else {
            System.out.println("❌ ID no encontrado.");
        }
    }

    private static void programarActividad() {
        System.out.print("ID Fundación: "); int idF = leerEntero();
        System.out.print("Nombre Actividad: "); String nom = scanner.nextLine();
        System.out.print("Descripción: "); String desc = scanner.nextLine();
        
        Actividad a = new Actividad(nom, desc, "2025-12-01", "Sede Principal", 50);
        fundacionService.agregarActividadAFundacion(idF, a);
    }

    // ==========================================
    // UTILIDADES
    // ==========================================
    
    private static void imprimirEncabezado(String titulo) {
        System.out.println("=================================================");
        System.out.println("   " + titulo);
        System.out.println("=================================================");
    }

    private static int leerEntero() {
        try {
            String input = scanner.nextLine();
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private static void esperarEnter() {
        System.out.println("\n[Presione Enter para continuar...]");
        scanner.nextLine();
    }
    
    private static void limpiarPantalla() {
        // Imprime varias líneas vacías para "limpiar" la consola visualmente
        for (int i = 0; i < 2; i++) System.out.println();
    }
}