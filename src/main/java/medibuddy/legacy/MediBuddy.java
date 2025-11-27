package medibuddy.legacy;


public class MediBuddy {
    public static void main(String[] args) {
    
        // Medicamentos
        Medicamento m1 = new Medicamento(10, "Paracetamol", "500mg", "08:00 AM","dos pastillas cada 6 horas");
        Medicamento m2 = new Medicamento(20, "Omeprazol", "20mg", "7:30 PM", "Dos pastillas cada 4 horas");
        
        // Adultos Mayores
        AdultoMayor am1 = new AdultoMayor(201, "Roberto Casillas", "Adulto Mayor", "3393641712", "3312345678");
        am1.agregarMedicamento(m1);

        AdultoMayor am2 = new AdultoMayor(202, "Sol Trejo", "Adulto Mayor", "3352621788", "3387654321");
        am2.agregarMedicamento(m2);

        // Familiares
        Familiar f1 = new Familiar(101, "Leonardo Casillas", "Familiar", "3312345678", "Hijo/a", am1);
        Familiar f2 = new Familiar(102, "Sol Trejo", "Familiar", "3387654321", "Nieto/a", am2);

        // Centros de Acopio
        CentroDeAcopio c1 = new CentroDeAcopio(1, "Centro Norte", "Av. Direccion Norte 123", "Papel");
        CentroDeAcopio c2 = new CentroDeAcopio(2, "Centro Sur", "Av. Direccion Sur 321", "Cartón");

        // Fundaciones
        Fundacion fund1 = new Fundacion(111, "Fundacion Mascotas Azul", "Las Fuentes");
        Fundacion fund2 = new Fundacion(222, "Fundacion Mascotas Rojo", "Av. Las Rosas");

        // Actividades
        Actividad a1 = new Actividad(11, "Recolección de Papel y Cartón", "Colaboración con Centros Norte y Sur", "2025-07-30", "Av. Centro Occidente", 10);
        Actividad a2 = new Actividad(22, "Apoyo a animales en adopción", "En colaboración con Fundaciones Rojo y Azul", "2025-08-01", "Av. Las Lilas", 8);

        // Asignar actividades
        fund1.agregar_actividad(a2);
        fund2.agregar_actividad(a2);
        c1.agregar_actividad(a1);
        c2.agregar_actividad(a1);

        // Mostrar información básica
        System.out.println(f1.obtener_datos());
        System.out.println(f2.obtener_datos());
        am1.listarMedicamentos();
        am2.listarMedicamentos();
        a1.mostrarActividad();
        a2.mostrarActividad();

        // Medicamento 
        System.out.println("\n MÉTODOS DE MEDICAMENTO ");
        m1.programar_recordatorio();
        m1.enviar_recordatorio_a_adulto_mayor(am1);
        m1.confirmar_toma();

        // AdultoMayor
        System.out.println("\n MÉTODOS DE ADULTO MAYOR ");
        am1.aceptar_recordatorio(m1);
        am1.actualizar_telefono("3333333333");
        System.out.println(am1.recibir_notificacion("Toma tu medicamento."));

        // Familiar
        System.out.println("\n MÉTODOS DE FAMILIAR ");
        f1.asociar_adulto_mayor(am2);
        System.out.println(f1.recibir_notificacion("Tu familiar tiene una nueva actividad."));

        // Fundación 
        System.out.println("\n MÉTODOS DE FUNDACIÓN ");
        fund1.listar_actividades();
        System.out.println(fund1.obtener_datos());

        // Centro de Acopio 
        System.out.println("\n MÉTODOS DE CENTRO DE ACOPIO ");
        c1.agregar_centro();
        c1.registrar_entrega("Papel", 15.5f);

        // Actividad 
        System.out.println("\n MÉTODOS DE ACTIVIDAD ");
        a1.crear_actividad();
        a1.inscribir_usuario(am1);
        a1.cancelar_inscripcion(am1);
    }
}



