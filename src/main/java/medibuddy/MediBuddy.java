package medibuddy;

import medibuddy.entity.*;
import medibuddy.service.*;
import java.util.Scanner;
import java.time.LocalDate;
import java.util.List;

public class MediBuddy {

    // Instanciamos los servicios (nuestra conexión con la lógica y BD)
    private static final UsuarioService usuarioService = new UsuarioService();
    private static final MedicamentoService medicamentoService = new MedicamentoService();
    private static final ActividadService actividadService = new ActividadService();
    private static final CentroAcopioService centroService = new CentroAcopioService();
    private static final FundacionService fundacionService = new FundacionService();
    
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean salir = false;

        System.out.println("========================================");
        System.out.println("   BIENVENIDO A MEDIBUDDY (CON BD)      ");
        System.out.println("========================================");

        while (!salir) {
            printMenu();
            int opcion = leerEntero("Selecciona una opción: ");

            switch (opcion) {
                case 1:
                    registrarAdultoMayor();
                    break;
                case 2:
                    registrarFamiliarYVincular();
                    break;
                case 3:
                    agregarMedicamento();
                    break;
                case 4:
                    confirmarTomaMedicamento(); 
                    break;
                case 5:
                    crearActividad();
                    break;
                case 6:
                    inscribirEnActividad();
                    break;
                case 7:
                    registrarEntregaCentro(); 
                    break;
                case 8:
                    listarUsuarios();
                    break;
                case 9:
                    listarMedicamentos();
                    break;
                case 10: // NUEVA OPCIÓN
                    menuFundaciones(); 
                    break;
                case 0:
                    salir = true;
                    System.out.println("Cerrando sistema... ¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
            System.out.println("----------------------------------------");
        }
    }

    // --- MÉTODOS DEL MENÚ PRINCIPAL ---

    private static void printMenu() {
        System.out.println("\n--- MENÚ PRINCIPAL ---");
        System.out.println("1. Registrar Adulto Mayor");
        System.out.println("2. Registrar Familiar y Vincular");
        System.out.println("3. Recetar Medicamento");
        System.out.println("4. Confirmar Toma de Medicamento (Check)");
        System.out.println("5. Crear Actividad");
        System.out.println("6. Inscribir Adulto Mayor en Actividad");
        System.out.println("7. Registrar Entrega en Centro de Acopio");
        System.out.println("8. Ver Todos los Usuarios");
        System.out.println("9. Ver Medicamentos Registrados");
        System.out.println("10. Gestionar Fundaciones");
        System.out.println("0. Salir");
    }

    // CASO 1
    private static void registrarAdultoMayor() {
        System.out.println("\n--- NUEVO ADULTO MAYOR ---");
        String nombre = leerTexto("Nombre: ");
        String tel = leerTexto("Teléfono: ");
        String contacto = leerTexto("Contacto Emergencia: ");

        AdultoMayor am = new AdultoMayor();
        am.setNombre(nombre);
        am.setTelefono(tel);
        am.setContactoEmergencia(contacto);

        usuarioService.saveUsuario(am);
        System.out.println("¡Adulto Mayor guardado con ID: " + am.getId() + "!");
    }

    // CASO 2
    private static void registrarFamiliarYVincular() {
        System.out.println("\n--- NUEVO FAMILIAR ---");
        String nombre = leerTexto("Nombre del Familiar: ");
        String parentesco = leerTexto("Parentesco (Hijo/Nieto/etc): ");
        
        Familiar fam = new Familiar();
        fam.setNombre(nombre);
        fam.setParentesco(parentesco);
        usuarioService.saveUsuario(fam);

        System.out.print("ID del Adulto Mayor a cuidar: ");
        Long idAm = scanner.nextLong();
        scanner.nextLine();

        usuarioService.linkFamiliarToAdulto(fam.getId(), idAm);
    }

    // CASO 3
    private static void agregarMedicamento() {
        System.out.println("\n--- NUEVO MEDICAMENTO ---");
        System.out.print("ID del Adulto Mayor que lo tomará: ");
        Long idAm = scanner.nextLong();
        scanner.nextLine(); 

        String nombre = leerTexto("Nombre Medicamento: ");
        String dosis = leerTexto("Dosis (ej. 500mg): ");
        String hora = leerTexto("Hora (ej. 8:00 AM): ");

        Medicamento med = new Medicamento(); // Usa el constructor nuevo
        med.setNombre(nombre);
        med.setDosis(dosis);
        med.setHoraRecordatorio(hora);
        medicamentoService.saveMedicamento(med, idAm);
        System.out.println("Medicamento recetado.");
    }

    // CASO 4
    private static void confirmarTomaMedicamento() {
        System.out.print("\nIngresa el ID del medicamento a confirmar: ");
        Long idMed = scanner.nextLong();
        scanner.nextLine();
        
        medicamentoService.confirmarTomaMedicamento(idMed);
    }

    // CASO 5
    private static void crearActividad() {
        System.out.println("\n--- NUEVA ACTIVIDAD ---");
        String nombre = leerTexto("Nombre Actividad: ");
        String desc = leerTexto("Descripción: ");
        int cupo = leerEntero("Cupo Máximo: ");
        
        Actividad act = new Actividad();
        act.setNombre(nombre);
        act.setDescripcion(desc);
        act.setCupoMaximo(cupo);
        act.setFecha(LocalDate.now());

        actividadService.saveActividad(act);
        System.out.println("Actividad creada con ID: " + act.getId());
    }

    // CASO 6
    private static void inscribirEnActividad() {
        System.out.print("\nID del Adulto Mayor: ");
        Long idAm = scanner.nextLong();
        System.out.print("ID de la Actividad: ");
        Long idAct = scanner.nextLong();
        scanner.nextLine();

        usuarioService.addParticipanteActividad(idAm, idAct);
    }

    // CASO 7
    private static void registrarEntregaCentro() {
        if (centroService.getAllCentrosAcopio().isEmpty()) {
            CentroAcopio c = new CentroAcopio();
            c.setNombre("Centro Principal");
            c.setDireccion("Calle 1");
            c.setTipoMaterial("General");
            centroService.saveCentroAcopio(c);
            System.out.println("(Se creó un Centro automático ID: " + c.getId() + ")");
        }

        System.out.print("\nID del Centro de Acopio: ");
        Long idC = scanner.nextLong();
        scanner.nextLine();
        
        String material = leerTexto("Material entregado: ");
        System.out.print("Cantidad (Kg): ");
        float cantidad = scanner.nextFloat();
        scanner.nextLine();

        centroService.registrarEntrega(idC, material, cantidad);
    }

    // CASO 8
    private static void listarUsuarios() {
        System.out.println("\n--- LISTA DE USUARIOS ---");
        List<Usuario> usuarios = usuarioService.getAllUsuarios();
        if (usuarios.isEmpty()) {
            System.out.println("No hay usuarios registrados.");
            return;
        }
        for (Usuario u : usuarios) {
            String tipo = (u instanceof AdultoMayor) ? "[ADULTO MAYOR]" : "[FAMILIAR]";
            System.out.println(u.getId() + ". " + tipo + " " + u.getNombre() + " - Tel: " + u.getTelefono());
        }
    }
    
    // CASO 9
    private static void listarMedicamentos() {
        System.out.println("\n--- LISTA DE MEDICAMENTOS ---");
        List<Medicamento> medicamentos = medicamentoService.getAllMedicamentos();
        if (medicamentos.isEmpty()) {
            System.out.println("No hay medicamentos registrados.");
            return;
        }
        for (Medicamento m : medicamentos) {
            String estado = m.getTomado() ? "(TOMADO)" : "(PENDIENTE)";
            System.out.println(m.getId() + ". " + m.getNombre() + " " + m.getDosis() + " " + estado);
        }
    }


    // --- MÉTODOS PARA GESTIONAR FUNDACIONES (CASE 10) ---

    private static void menuFundaciones() {
        boolean volver = false;
        while (!volver) {
            System.out.println("\n--- GESTIÓN DE FUNDACIONES ---");
            System.out.println("1. Registrar Nueva Fundación");
            System.out.println("2. Vincular Fundación a Actividad");
            System.out.println("3. Listar Fundaciones");
            System.out.println("0. Volver al Menú Principal");
            
            int opcion = leerEntero("Selecciona una opción: ");

            switch (opcion) {
                case 1:
                    registrarFundacion();
                    break;
                case 2:
                    vincularFundacionActividad();
                    break;
                case 3:
                    listarFundaciones();
                    break;
                case 0:
                    volver = true;
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }

    private static void registrarFundacion() {
        System.out.println("\n--- NUEVA FUNDACIÓN ---");
        String nombre = leerTexto("Nombre de la Fundación: ");
        String tel = leerTexto("Teléfono de contacto: ");

        Fundacion fund = new Fundacion();
        fund.setNombre(nombre);
        fund.setTelefono(tel);

        fundacionService.saveFundacion(fund);
        System.out.println("¡Fundación guardada con ID: " + fund.getId() + "!");
    }

    private static void vincularFundacionActividad() {
        System.out.print("\nID de la Fundación a vincular: ");
        Long idFund = scanner.nextLong();
        System.out.print("ID de la Actividad: ");
        Long idAct = scanner.nextLong();
        scanner.nextLine();

        fundacionService.vincularActividad(idFund, idAct); 
    }

    private static void listarFundaciones() {
        System.out.println("\n--- LISTA DE FUNDACIONES ---");
        List<Fundacion> fundaciones = fundacionService.getAllFundaciones();
        if (fundaciones.isEmpty()) {
            System.out.println("No hay fundaciones registradas.");
            return;
        }
        for (Fundacion f : fundaciones) {
            System.out.println(f.getId() + ". " + f.getNombre() + " - Tel: " + f.getTelefono());
        }
    }


    // --- UTILERÍAS PARA LEER DATOS ---
    
    private static String leerTexto(String mensaje) {
        System.out.print(mensaje);
        return scanner.nextLine();
    }
    
    private static int leerEntero(String mensaje) {
        System.out.print(mensaje);
        while (!scanner.hasNextInt()) {
            System.out.print("Por favor ingresa un número válido: ");
            scanner.next();
        }
        int dato = scanner.nextInt();
        scanner.nextLine(); 
        return dato;
    }
}