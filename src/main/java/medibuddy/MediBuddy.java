package medibuddy;

import medibuddy.model.AdultoMayor;
import medibuddy.model.Medicamento;
import medibuddy.service.AdultoMayorService;
import medibuddy.service.MedicamentoService;

import java.util.List;
import java.util.Scanner;

public class MediBuddy {
    private static final Scanner scanner = new Scanner(System.in);
    private static final AdultoMayorService adultoMayorService = new AdultoMayorService();
    private static final MedicamentoService medicamentoService = new MedicamentoService();

    public static void main(String[] args) {
        boolean salir = false;
        while (!salir) {
            System.out.println("\n--- Menú Principal ---");
            System.out.println("1. Gestionar Adultos Mayores");
            System.out.println("2. Gestionar Medicamentos");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1:
                    menuAdultosMayores();
                    break;
                case 2:
                    menuMedicamentos();
                    break;
                case 3:
                    salir = true;
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }

    private static void menuAdultosMayores() {
        boolean volver = false;
        while (!volver) {
            System.out.println("\n--- Menú Adultos Mayores ---");
            System.out.println("1. Crear Adulto Mayor");
            System.out.println("2. Listar Adultos Mayores");
            System.out.println("3. Buscar Adulto Mayor por ID");
            System.out.println("4. Actualizar Adulto Mayor");
            System.out.println("5. Eliminar Adulto Mayor");
            System.out.println("6. Agregar Medicamento a Adulto Mayor");
            System.out.println("7. Volver al Menú Principal");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1:
                    crearAdultoMayor();
                    break;
                case 2:
                    listarAdultosMayores();
                    break;
                case 3:
                    buscarAdultoMayorPorId();
                    break;
                case 4:
                    actualizarAdultoMayor();
                    break;
                case 5:
                    eliminarAdultoMayor();
                    break;
                case 6:
                    agregarMedicamentoAAdultoMayor();
                    break;
                case 7:
                    volver = true;
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }

    private static void menuMedicamentos() {
        boolean volver = false;
        while (!volver) {
            System.out.println("\n--- Menú Medicamentos ---");
            System.out.println("1. Crear Medicamento");
            System.out.println("2. Listar Medicamentos");
            System.out.println("3. Buscar Medicamento por ID");
            System.out.println("4. Actualizar Medicamento");
            System.out.println("5. Eliminar Medicamento");
            System.out.println("6. Volver al Menú Principal");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1:
                    crearMedicamento();
                    break;
                case 2:
                    listarMedicamentos();
                    break;
                case 3:
                    buscarMedicamentoPorId();
                    break;
                case 4:
                    actualizarMedicamento();
                    break;
                case 5:
                    eliminarMedicamento();
                    break;
                case 6:
                    volver = true;
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }

    private static void crearAdultoMayor() {
        System.out.println("\n--- Crear Adulto Mayor ---");
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Tipo de Usuario: ");
        String tipoUsuario = scanner.nextLine();
        System.out.print("Teléfono: ");
        String telefono = scanner.nextLine();
        System.out.print("Contacto de Emergencia: ");
        String contactoEmergencia = scanner.nextLine();

        AdultoMayor adultoMayor = new AdultoMayor(nombre, tipoUsuario, telefono, contactoEmergencia);
        adultoMayorService.crearAdultoMayor(adultoMayor);
        System.out.println("Adulto Mayor creado con éxito.");
    }
    private static void listarAdultosMayores() {
        System.out.println("\n--- Listar Adultos Mayores ---");
        List<AdultoMayor> adultosMayores = adultoMayorService.listarAdultosMayores();
        if (adultosMayores.isEmpty()) {
            System.out.println("No hay adultos mayores registrados.");
        } else {
            adultosMayores.forEach(System.out::println);
        }
    }

    private static void buscarAdultoMayorPorId() {
        System.out.println("\n--- Buscar Adulto Mayor por ID ---");
        System.out.print("ID del Adulto Mayor: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        AdultoMayor adultoMayor = adultoMayorService.buscarAdultoMayorPorId(id);
        if (adultoMayor != null) {
            System.out.println(adultoMayor);
        } else {
            System.out.println("Adulto Mayor no encontrado.");
        }
    }

    private static void actualizarAdultoMayor() {
        System.out.println("\n--- Actualizar Adulto Mayor ---");
        System.out.print("ID del Adulto Mayor a actualizar: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        AdultoMayor adultoMayor = adultoMayorService.buscarAdultoMayorPorId(id);
        if (adultoMayor != null) {
            System.out.print("Nuevo Nombre: ");
            String nombre = scanner.nextLine();
            System.out.print("Nuevo Teléfono: ");
            String telefono = scanner.nextLine();
            System.out.print("Nuevo Contacto de Emergencia: ");
            String contactoEmergencia = scanner.nextLine();

            adultoMayor.setNomUsuario(nombre);
            adultoMayor.setTelefono(telefono);
            adultoMayor.setContactoEmergencia(contactoEmergencia);

            adultoMayorService.actualizarAdultoMayor(adultoMayor);
            System.out.println("Adulto Mayor actualizado con éxito.");
        } else {
            System.out.println("Adulto Mayor no encontrado.");
        }
    }

    private static void eliminarAdultoMayor() {
        System.out.println("\n--- Eliminar Adulto Mayor ---");
        System.out.print("ID del Adulto Mayor a eliminar: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        AdultoMayor adultoMayor = adultoMayorService.buscarAdultoMayorPorId(id);
        if (adultoMayor != null) {
            adultoMayorService.eliminarAdultoMayor(adultoMayor);
            System.out.println("Adulto Mayor eliminado con éxito.");
        } else {
            System.out.println("Adulto Mayor no encontrado.");
        }
    }

    private static void agregarMedicamentoAAdultoMayor() {
        System.out.println("\n--- Agregar Medicamento a Adulto Mayor ---");
        System.out.print("ID del Adulto Mayor: ");
        int idAdultoMayor = scanner.nextInt();
        scanner.nextLine();
        System.out.print("ID del Medicamento: ");
        int idMedicamento = scanner.nextInt();
        scanner.nextLine();

        AdultoMayor adultoMayor = adultoMayorService.buscarAdultoMayorPorId(idAdultoMayor);
        Medicamento medicamento = medicamentoService.buscarMedicamentoPorId(idMedicamento);

        if (adultoMayor != null && medicamento != null) {
            adultoMayor.agregarMedicamento(medicamento);
            adultoMayorService.actualizarAdultoMayor(adultoMayor);
            System.out.println("Medicamento agregado con éxito al Adulto Mayor.");
        } else {
            System.out.println("Adulto Mayor o Medicamento no encontrado.");
        }
    }

    // Métodos para Medicamentos
    private static void crearMedicamento() {
        System.out.println("\n--- Crear Medicamento ---");

        System.out.print("Nombre del Medicamento: ");
        String nombre = scanner.nextLine();
        System.out.print("Dosis: ");
        String dosis = scanner.nextLine();
        System.out.print("Hora de Recordatorio: ");
        String horaRecordatorio = scanner.nextLine();

        Medicamento medicamento = new Medicamento(nombre, dosis, horaRecordatorio);
        medicamentoService.crearMedicamento(medicamento);
        System.out.println("Medicamento creado con éxito.");
    }

    private static void listarMedicamentos() {
        System.out.println("\n--- Listar Medicamentos ---");
        List<Medicamento> medicamentos = medicamentoService.listarMedicamentos();
        if (medicamentos.isEmpty()) {
            System.out.println("No hay medicamentos registrados.");
        } else {
            medicamentos.forEach(System.out::println);
        }
    }

    private static void buscarMedicamentoPorId() {
        System.out.println("\n--- Buscar Medicamento por ID ---");
        System.out.print("ID del Medicamento: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Medicamento medicamento = medicamentoService.buscarMedicamentoPorId(id);
        if (medicamento != null) {
            System.out.println(medicamento);
        } else {
            System.out.println("Medicamento no encontrado.");
        }
    }

    private static void actualizarMedicamento() {
        System.out.println("\n--- Actualizar Medicamento ---");
        System.out.print("ID del Medicamento a actualizar: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Medicamento medicamento = medicamentoService.buscarMedicamentoPorId(id);
        if (medicamento != null) {
            System.out.print("Nuevo Nombre: ");
            String nombre = scanner.nextLine();
            System.out.print("Nueva Dosis: ");
            String dosis = scanner.nextLine();
            System.out.print("Nueva Hora de Recordatorio: ");
            String horaRecordatorio = scanner.nextLine();

            medicamento.setNomMedicamento(nombre);
            medicamento.setDosis(dosis);
            medicamento.setHoraRecordatorio(horaRecordatorio);

            medicamentoService.actualizarMedicamento(medicamento);
            System.out.println("Medicamento actualizado con éxito.");
        } else {
            System.out.println("Medicamento no encontrado.");
        }
    }

    private static void eliminarMedicamento() {
        System.out.println("\n--- Eliminar Medicamento ---");
        System.out.print("ID del Medicamento a eliminar: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Medicamento medicamento = medicamentoService.buscarMedicamentoPorId(id);
        if (medicamento != null) {
            medicamentoService.eliminarMedicamento(medicamento);
            System.out.println("Medicamento eliminado con éxito.");
        } else {
            System.out.println("Medicamento no encontrado.");
        }
    }
}
