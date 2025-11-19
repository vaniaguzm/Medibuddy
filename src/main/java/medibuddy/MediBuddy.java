package medibuddy;

import medibuddy.model.*;
import medibuddy.service.*;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;

public class MediBuddy {

    // ==========================================
    // 1. CONFIGURACIÓN E INSTANCIAS GLOBALES
    // ==========================================
    private static final Scanner scanner = new Scanner(System.in);
    
    // Servicios para conectar con la Base de Datos
    private static final AdultoMayorService adultoService = new AdultoMayorService();
    private static final FamiliarService familiarService = new FamiliarService();
    private static final FundacionService fundacionService = new FundacionService();
    private static final CentroDeAcopioService centroService = new CentroDeAcopioService();
    // Nota: MedicamentoService se usa implícitamente dentro de la lógica de AdultoMayor

    public static void main(String[] args) {
        boolean salir = false;

        System.out.println("==========================================");
        System.out.println("   BIENVENIDO A MEDIBUDDY (SISTEMA DB)    ");
        System.out.println("==========================================");

        while (!salir) {
            System.out.println("\n--- MENÚ PRINCIPAL ---");
            System.out.println("1. Gestión Adultos Mayores y Medicamentos");
            System.out.println("2. Gestión de Familiares");
            System.out.println("3. Gestión de Fundaciones y Actividades");
            System.out.println("4. Gestión de Centros de Acopio y Entregas");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = leerEntero();

            switch (opcion) {
                case 1:
                    bloqueAdultosMayores();
                    break;
                case 2:
                    bloqueFamiliares();
                    break;
                case 3:
                    bloqueFundaciones();
                    break;
                case 4:
                    bloqueCentrosAcopio();
                    break;
                case 5:
                    salir = true;
                    System.out.println("Cerrando sistema...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }
        scanner.close();
    }

    // ===================================================================================
    // BLOQUE: ADULTO MAYOR Y MEDICAMENTOS
    // ===================================================================================
    private static void bloqueAdultosMayores() {
        boolean volver = false;
        while (!volver) {
            System.out.println("\n--- MENÚ ADULTOS MAYORES ---");
            System.out.println("1. Registrar nuevo Adulto Mayor");
            System.out.println("2. Agregar Medicamento a un Adulto Mayor");
            System.out.println("3. Listar Adultos Mayores y sus Medicinas");
            System.out.println("4. Eliminar Adulto Mayor");
            System.out.println("5. Volver al Menú Principal");
            System.out.print("Opción: ");

            int opt = leerEntero();
            switch (opt) {
                case 1: // CREAR
                    System.out.print("Nombre: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Teléfono: ");
                    String tel = scanner.nextLine();
                    System.out.print("Contacto de Emergencia: ");
                    String contacto = scanner.nextLine();

                    AdultoMayor nuevoAm = new AdultoMayor(nombre, "Adulto Mayor", tel, contacto);
                    adultoService.crearAdultoMayor(nuevoAm);
                    System.out.println(">> Adulto Mayor registrado con éxito.");
                    break;

                case 2: // AGREGAR MEDICAMENTO (Relación)
                    System.out.print("Ingresa el ID del Adulto Mayor: ");
                    int idAm = leerEntero();
                    
                    AdultoMayor amEncontrado = adultoService.buscarAdultoMayorPorId(idAm);
                    if (amEncontrado != null) {
                        System.out.print("Nombre Medicamento: ");
                        String nomMed = scanner.nextLine();
                        System.out.print("Dosis: ");
                        String dosis = scanner.nextLine();
                        System.out.print("Hora Recordatorio (ej. 08:00 AM): ");
                        String hora = scanner.nextLine();

                        Medicamento med = new Medicamento(nomMed, dosis, hora);
                        // Usamos el servicio para guardar el medicamento vinculado al adulto
                        adultoService.agregarMedicamentoAAdultoMayor(idAm, med);
                        System.out.println(">> Medicamento agregado a " + amEncontrado.getNomUsuario());
                    } else {
                        System.out.println("Error: No existe Adulto Mayor con ese ID.");
                    }
                    break;

                case 3: // LISTAR
                    List<AdultoMayor> lista = adultoService.listarAdultosMayores();
                    System.out.println("\n--- LISTADO ---");
                    for (AdultoMayor am : lista) {
                        System.out.println("ID: " + am.getIdUsuario() + " | " + am.getNomUsuario() + " (Tel: " + am.getTelefono() + ")");
                        if (am.getMedicamentos() != null && !am.getMedicamentos().isEmpty()) {
                            for (Medicamento m : am.getMedicamentos()) {
                                System.out.println("   -> Med: " + m.getNomMedicamento() + " - " + m.getDosis());
                            }
                        } else {
                            System.out.println("   (Sin medicamentos)");
                        }
                    }
                    break;
                
                case 4: // ELIMINAR
                    System.out.print("ID del Adulto a eliminar: ");
                    int idDel = leerEntero();
                    AdultoMayor amDel = adultoService.buscarAdultoMayorPorId(idDel);
                    if(amDel != null) {
                        adultoService.eliminarAdultoMayor(amDel);
                        System.out.println(">> Adulto mayor eliminado.");
                    } else {
                        System.out.println("ID no encontrado.");
                    }
                    break;

                case 5:
                    volver = true;
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        }
    }

    // ===================================================================================
    // BLOQUE: FAMILIARES (Vinculados a Adultos Mayores)
    // ===================================================================================
    private static void bloqueFamiliares() {
        boolean volver = false;
        while(!volver) {
            System.out.println("\n--- MENÚ FAMILIARES ---");
            System.out.println("1. Registrar Familiar (y asociar)");
            System.out.println("2. Listar Familiares");
            System.out.println("3. Volver al Menú Principal");
            System.out.print("Opción: ");

            int opt = leerEntero();
            switch (opt) {
                case 1: // CREAR
                    System.out.print("Nombre del Familiar: ");
                    String nom = scanner.nextLine();
                    System.out.print("Teléfono: ");
                    String tel = scanner.nextLine();
                    System.out.print("Relación (Hijo, Nieto, etc): ");
                    String rel = scanner.nextLine();
                    
                    System.out.print("ID del Adulto Mayor a cuidar: ");
                    int idAm = leerEntero();
                    
                    AdultoMayor am = adultoService.buscarAdultoMayorPorId(idAm);
                    if (am != null) {
                        Familiar familiar = new Familiar(nom, "Familiar", tel, rel, am);
                        familiarService.crearFamiliar(familiar);
                        System.out.println(">> Familiar registrado y asociado a " + am.getNomUsuario());
                    } else {
                        System.out.println("Error: ID de Adulto Mayor no encontrado.");
                    }
                    break;

                case 2: // LISTAR
                    List<Familiar> fams = familiarService.listarFamiliares();
                    System.out.println("\n--- LISTADO ---");
                    for (Familiar f : fams) {
                        String cuidaA = (f.getAdultoMayorAsociado() != null) 
                                ? f.getAdultoMayorAsociado().getNomUsuario() 
                                : "Nadie";
                        System.out.println("ID: " + f.getIdUsuario() + " | " + f.getNomUsuario() + 
                                           " (" + f.getRelacion() + ") cuida a -> " + cuidaA);
                    }
                    break;

                case 3:
                    volver = true;
                    break;
            }
        }
    }

    // ===================================================================================
    // BLOQUE: FUNDACIONES Y ACTIVIDADES
    // ===================================================================================
    private static void bloqueFundaciones() {
        boolean volver = false;
        while(!volver) {
            System.out.println("\n--- MENÚ FUNDACIONES ---");
            System.out.println("1. Registrar Fundación");
            System.out.println("2. Crear Actividad para una Fundación");
            System.out.println("3. Listar Fundaciones y Actividades");
            System.out.println("4. Volver al Menú Principal");
            System.out.print("Opción: ");

            int opt = leerEntero();
            switch (opt) {
                case 1: // CREAR FUNDACIÓN
                    System.out.print("Nombre Fundación: ");
                    String nom = scanner.nextLine();
                    System.out.print("Dirección: ");
                    String dir = scanner.nextLine();
                    fundacionService.crearFundacion(new Fundacion(nom, dir));
                    System.out.println(">> Fundación creada.");
                    break;

                case 2: // CREAR ACTIVIDAD (Relación)
                    System.out.print("ID de la Fundación: ");
                    int idFun = leerEntero();
                    Fundacion fun = fundacionService.buscarFundacionPorId(idFun);
                    
                    if (fun != null) {
                        System.out.print("Nombre Actividad: ");
                        String nomAct = scanner.nextLine();
                        System.out.print("Descripción: ");
                        String desc = scanner.nextLine();
                        System.out.print("Ubicación: ");
                        String ubi = scanner.nextLine();
                        System.out.print("Fecha (YYYY-MM-DD): ");
                        String fechaStr = scanner.nextLine();
                        System.out.print("Cupo máximo: ");
                        int cupo = leerEntero();

                        try {
                            Actividad act = new Actividad(nomAct, desc, fechaStr, ubi, cupo);
                            fundacionService.agregarActividadAFundacion(idFun, act);
                            System.out.println(">> Actividad agregada a la fundación.");
                        } catch (DateTimeParseException e) {
                            System.out.println("Error: Formato de fecha inválido.");
                        }
                    } else {
                        System.out.println("Fundación no encontrada.");
                    }
                    break;
                
                case 3: // LISTAR
                    List<Fundacion> fundaciones = fundacionService.listarFundaciones();
                    System.out.println("\n--- LISTADO ---");
                    for(Fundacion f : fundaciones) {
                        System.out.println("ID: " + f.getId() + " | " + f.getNombre());
                        for(Actividad a : f.getActividades()) {
                            System.out.println("   -> Actividad: " + a.getNomActividad() + " (" + a.getFecha() + ")");
                        }
                    }
                    break;

                case 4:
                    volver = true;
                    break;
            }
        }
    }

    // ===================================================================================
    // BLOQUE: CENTROS DE ACOPIO Y ENTREGAS
    // ===================================================================================
    private static void bloqueCentrosAcopio() {
        boolean volver = false;
        while(!volver) {
            System.out.println("\n--- MENÚ CENTROS DE ACOPIO ---");
            System.out.println("1. Registrar Centro");
            System.out.println("2. Registrar Entrega de Material");
            System.out.println("3. Listar Centros y Entregas");
            System.out.println("4. Volver al Menú Principal");
            System.out.print("Opción: ");

            int opt = leerEntero();
            switch(opt) {
                case 1: // CREAR CENTRO
                    System.out.print("Nombre Centro: ");
                    String nom = scanner.nextLine();
                    System.out.print("Dirección: ");
                    String dir = scanner.nextLine();
                    System.out.print("Material Principal: ");
                    String mat = scanner.nextLine();
                    centroService.crearCentro(new CentroDeAcopio(nom, dir, mat));
                    System.out.println(">> Centro registrado.");
                    break;
                
                case 2: // REGISTRAR ENTREGA
                    System.out.print("ID del Centro de Acopio: ");
                    int idCen = leerEntero();
                    CentroDeAcopio centro = centroService.buscarCentroPorId(idCen);
                    
                    if(centro != null) {
                        System.out.print("Material entregado: ");
                        String material = scanner.nextLine();
                        System.out.print("Cantidad (kg/unidades): ");
                        try {
                            float cant = Float.parseFloat(scanner.nextLine());
                            Entrega entrega = new Entrega(material, cant, LocalDate.now());
                            centroService.registrarEntregaEnCentro(idCen, entrega);
                            System.out.println(">> Entrega registrada.");
                        } catch (NumberFormatException e) {
                            System.out.println("Error: Cantidad inválida.");
                        }
                    } else {
                        System.out.println("Centro no encontrado.");
                    }
                    break;

                case 3: // LISTAR
                    List<CentroDeAcopio> centros = centroService.listarCentros();
                    System.out.println("\n--- LISTADO ---");
                    for(CentroDeAcopio c : centros) {
                        System.out.println("ID: " + c.getId() + " | " + c.getNombre() + " [" + c.getTipoMaterialPrincipal() + "]");
                        for(Entrega e : c.getEntregas()) {
                            System.out.println("   -> Entrega: " + e.getCantidad() + " de " + e.getMaterial() + " (" + e.getFechaEntrega() + ")");
                        }
                    }
                    break;

                case 4:
                    volver = true;
                    break;
            }
        }
    }

    // ===================================================================================
    // UTILIDADES
    // ===================================================================================
    
    /**
     * Método auxiliar para leer enteros de forma segura.
     * Evita el problema de que scanner.nextInt() deje el salto de línea
     * en el buffer, afectando a los siguientes scanner.nextLine().
     */
    private static int leerEntero() {
        try {
            String input = scanner.nextLine();
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            return -1; // Retorna -1 si no es un número válido
        }
    }
}