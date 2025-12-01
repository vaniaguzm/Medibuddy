package medibuddy.interfaces;

import medibuddy.model.Actividad;
import medibuddy.model.Organizador;
import medibuddy.model.Fundacion;
import medibuddy.model.AdultoMayor;
import medibuddy.service.ActividadService;
import medibuddy.service.OrganizadorService;

import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JActividad extends javax.swing.JFrame {
    
    private static final Logger logger = Logger.getLogger(JActividad.class.getName());

    // Servicios
    private final ActividadService actividadService = new ActividadService();
    private final OrganizadorService organizadorService = new OrganizadorService();
    
    // Lista auxiliar para el combo
    private List<Organizador> listaOrganizadores;

    public JActividad() {
        initComponents();
        cargarCombos();
        cargarTablaActividades(); 
        
        // Inicializamos la tabla de participantes vacía
        DefaultTableModel modelParticipantes = (DefaultTableModel) tblParticipantes.getModel();
        modelParticipantes.setRowCount(0);
        
        setLocationRelativeTo(null);
    }

    private void cargarCombos() {
        try {
            listaOrganizadores = organizadorService.listarTodosLosOrganizadores();
            DefaultComboBoxModel<String> modelOrg = new DefaultComboBoxModel<>();
            modelOrg.addElement("--- Seleccione Organizador ---");
            
            for (Organizador o : listaOrganizadores) {
                String tipo = (o instanceof Fundacion) ? " (Fundación)" : " (Centro Acopio)";
                modelOrg.addElement(o.getNombre() + tipo);
            }
            cnbOrganizador.setModel(modelOrg);

            DefaultComboBoxModel<String> modelCupo = new DefaultComboBoxModel<>();
            modelCupo.addElement("100");
            modelCupo.addElement("50");
            modelCupo.addElement("200");
            modelCupo.addElement("500");
            cnbCupo.setModel(modelCupo);

        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error cargando combos", e);
        }
    }
    
    // Carga la tabla superior (Actividades)
    private void cargarTablaActividades() {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
        
        try {
            List<Actividad> actividades = actividadService.listarActividades();
            for (Actividad a : actividades) {
                String nombreOrg = "Sin Asignar";
                if (a.getOrganizador() != null) {
                    nombreOrg = a.getOrganizador().getNombre();
                }
                
                model.addRow(new Object[]{
                    a.getIdActividad(),
                    nombreOrg,
                    a.getNomActividad(),
                    a.getFecha(),
                    a.getUbicacion(),
                    a.getCupoMaximo()
                });
            }
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error cargando tabla actividades", e);
        }
    }
    
    // --- MÉTODO CORREGIDO: Carga la tabla inferior (Participantes) ---
    private void cargarParticipantes(int idActividad) {
        DefaultTableModel model = (DefaultTableModel) tblParticipantes.getModel();
        model.setRowCount(0); // Limpiar tabla
        
        try {
            // Buscamos la actividad completa. El repositorio hace FETCH de participantes, 
            // así que Hibernate ya trae la lista lista para usar.
            Actividad actividad = actividadService.buscarActividadPorId(idActividad);
            
            if (actividad != null && actividad.getParticipantes() != null) {
                for (AdultoMayor am : actividad.getParticipantes()) {
                    // Concatenamos apellidos para mostrarlos juntos
                    String apellidos = am.getApellidoPaterno() + " " + am.getApellidoMaterno();
                    
                    model.addRow(new Object[]{
                        am.getIdUsuario(),
                        am.getNomUsuario(), // Corrección basada en tu modelo Usuario
                        apellidos,          // Corrección basada en tu modelo AdultoMayor
                        am.getTelefono()
                    });
                }
            }
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error cargando participantes", e);
        }
    }
    
    // Método para llenar los campos al hacer clic en la tabla superior
    private void llenarCampos() {
        int fila = jTable1.getSelectedRow();
        if (fila >= 0) {
            try {
                int id = (int) jTable1.getValueAt(fila, 0);
                
                // 1. Llenar el formulario de arriba
                Actividad a = actividadService.buscarActividadPorId(id);
                
                if (a != null) {
                    txtActividad.setText(a.getNomActividad());
                    txtDescripcion.setText(a.getDescripcion());
                    txtFecha.setText(a.getFecha());
                    txtUbicacion.setText(a.getUbicacion());
                    
                    if (a.getOrganizador() != null) {
                        String nombreOrg = a.getOrganizador().getNombre();
                        for (int i = 1; i < cnbOrganizador.getItemCount(); i++) {
                            if (cnbOrganizador.getItemAt(i).contains(nombreOrg)) {
                                cnbOrganizador.setSelectedIndex(i);
                                break;
                            }
                        }
                    }
                    cnbCupo.setSelectedItem(String.valueOf(a.getCupoMaximo()));
                    
                    // 2. --- ACTUALIZAR LA SEGUNDA TABLA ---
                    cargarParticipantes(id);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btnRegresar = new javax.swing.JButton();
        btnIrInscripciones = new javax.swing.JButton();
        
        // Formulario
        jLabel2 = new javax.swing.JLabel();
        cnbOrganizador = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        txtActividad = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtDescripcion = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtFecha = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtUbicacion = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        cnbCupo = new javax.swing.JComboBox<>();

        // Botones
        btnAgregar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();

        // Tabla 1: Actividades
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        
        // --- Componentes para la segunda tabla ---
        jLabelParticipantes = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblParticipantes = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); 
        jLabel1.setText("Gestión de Actividades");

        btnRegresar.setText("Regresar");
        btnRegresar.addActionListener(evt -> btnRegresarActionPerformed(evt));

        btnIrInscripciones.setBackground(new java.awt.Color(255, 153, 51));
        btnIrInscripciones.setForeground(new java.awt.Color(255, 255, 255));
        btnIrInscripciones.setText("Registrar Adulto Mayor a Actividad");
        btnIrInscripciones.addActionListener(evt -> btnIrInscripcionesActionPerformed(evt));

        jLabel2.setText("Organizador:");
        jLabel3.setText("Nombre Actividad:");
        jLabel4.setText("Descripción:");
        jLabel5.setText("Fecha:");
        jLabel6.setText("Ubicación:");
        jLabel7.setText("Cupo Máximo:");
        
        // Etiqueta de la nueva tabla
        jLabelParticipantes.setFont(new java.awt.Font("Segoe UI", 1, 14));
        jLabelParticipantes.setText("Adultos Mayores Inscritos en la actividad seleccionada:");

        // Configuración Botones
        btnAgregar.setBackground(new java.awt.Color(111, 207, 123));
        btnAgregar.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(evt -> btnAgregarActionPerformed(evt));

        btnActualizar.setBackground(new java.awt.Color(0, 204, 255));
        btnActualizar.setForeground(new java.awt.Color(255, 255, 255));
        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(evt -> btnActualizarActionPerformed(evt));

        btnEliminar.setBackground(new java.awt.Color(255, 0, 0));
        btnEliminar.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(evt -> btnEliminarActionPerformed(evt));

        btnLimpiar.setBackground(new java.awt.Color(204, 204, 204));
        btnLimpiar.setForeground(new java.awt.Color(255, 255, 255));
        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(evt -> btnLimpiarActionPerformed(evt));

        // Configuración Tabla 1 (Actividades)
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {},
            new String [] {
                "ID", "Organizador", "Actividad", "Fecha", "Ubicación", "Cupo"
            }
        ) {
            boolean[] canEdit = new boolean [] { false, false, false, false, false, false };
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                llenarCampos(); // Esto actualiza ambas tablas
            }
        });
        jScrollPane1.setViewportView(jTable1);
        
        // Configuración Tabla 2 (Participantes)
        tblParticipantes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {},
            new String [] {
                "ID Usuario", "Nombre", "Apellidos", "Teléfono"
            }
        ) {
            boolean[] canEdit = new boolean [] { false, false, false, false };
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblParticipantes);

        // --- Layout ---
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1) // Tabla 1
                    .addComponent(jScrollPane2) // Tabla 2
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelParticipantes)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cnbOrganizador, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtActividad)
                                    .addComponent(txtDescripcion)
                                    .addComponent(txtFecha)
                                    .addComponent(txtUbicacion)
                                    .addComponent(cnbCupo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnRegresar)
                                .addGap(30, 30, 30)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                                .addComponent(btnIrInscripciones))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(btnRegresar)
                    .addComponent(btnIrInscripciones, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cnbOrganizador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtActividad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtUbicacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(cnbCupo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelParticipantes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>                        

    // --- ACCIONES DE BOTONES ---

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {
        String nombre = txtActividad.getText().trim();
        String desc = txtDescripcion.getText().trim();
        String fecha = txtFecha.getText().trim();
        String ubi = txtUbicacion.getText().trim();
        int idxOrg = cnbOrganizador.getSelectedIndex();
        
        if (nombre.isEmpty() || fecha.isEmpty() || idxOrg <= 0) {
            JOptionPane.showMessageDialog(this, "Nombre, Fecha y Organizador son obligatorios.");
            return;
        }

        try {
            int cupo = Integer.parseInt((String) cnbCupo.getSelectedItem());
            Organizador organizadorSeleccionado = listaOrganizadores.get(idxOrg - 1);
            
            Actividad nueva = new Actividad(nombre, desc, fecha, ubi, cupo);
            organizadorService.crearActividad(organizadorSeleccionado.getId(), nueva);
            
            JOptionPane.showMessageDialog(this, "Actividad creada exitosamente.");
            cargarTablaActividades(); 
            btnLimpiarActionPerformed(null);
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al guardar: " + e.getMessage());
        }
    }

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {
        int fila = jTable1.getSelectedRow();
        if (fila < 0) {
            JOptionPane.showMessageDialog(this, "Seleccione una actividad de la tabla superior.");
            return;
        }
        
        try {
            int id = (int) jTable1.getValueAt(fila, 0);
            Actividad a = actividadService.buscarActividadPorId(id);
            
            if (a != null) {
                a.setNomActividad(txtActividad.getText().trim());
                a.setDescripcion(txtDescripcion.getText().trim());
                a.setFecha(txtFecha.getText().trim());
                a.setUbicacion(txtUbicacion.getText().trim());
                a.setCupoMaximo(Integer.parseInt((String) cnbCupo.getSelectedItem()));
                
                int idxOrg = cnbOrganizador.getSelectedIndex();
                if (idxOrg > 0) {
                    a.setOrganizador(listaOrganizadores.get(idxOrg - 1));
                }
                
                actividadService.actualizarActividad(a);
                JOptionPane.showMessageDialog(this, "Actividad actualizada.");
                cargarTablaActividades();
                btnLimpiarActionPerformed(null);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al actualizar: " + e.getMessage());
        }
    }

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {
        int fila = jTable1.getSelectedRow();
        if (fila < 0) {
            JOptionPane.showMessageDialog(this, "Seleccione una actividad.");
            return;
        }
        
        int id = (int) jTable1.getValueAt(fila, 0);
        int confirm = JOptionPane.showConfirmDialog(this, "¿Eliminar actividad?", "Confirmar", JOptionPane.YES_NO_OPTION);
        
        if (confirm == JOptionPane.YES_OPTION) {
            try {
                Actividad a = actividadService.buscarActividadPorId(id);
                actividadService.eliminarActividad(a);
                cargarTablaActividades();
                btnLimpiarActionPerformed(null);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {
        txtActividad.setText("");
        txtDescripcion.setText("");
        txtFecha.setText("");
        txtUbicacion.setText("");
        cnbOrganizador.setSelectedIndex(0);
        cnbCupo.setSelectedIndex(0);
        jTable1.clearSelection();
        
        // Limpiamos también la tabla de participantes
        DefaultTableModel model = (DefaultTableModel) tblParticipantes.getModel();
        model.setRowCount(0);
    }

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {
        this.dispose();
        try {
            new medibuddy.interfaces.JMenuPrincipal().setVisible(true);
        } catch (Exception e) {}
    }

    private void btnIrInscripcionesActionPerformed(java.awt.event.ActionEvent evt) {
        this.dispose();
        try {
            new medibuddy.interfaces.JInscripciones().setVisible(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al abrir inscripciones: " + e.getMessage());
        }
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new JActividad().setVisible(true));
    }

    // Variables declaration
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JButton btnIrInscripciones;
    private javax.swing.JComboBox<String> cnbOrganizador;
    private javax.swing.JComboBox<String> cnbCupo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    // NUEVA ETIQUETA
    private javax.swing.JLabel jLabelParticipantes; 
    
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    
    // NUEVA TABLA Y SCROLL
    private javax.swing.JScrollPane jScrollPane2; 
    private javax.swing.JTable tblParticipantes;
    
    private javax.swing.JTextField txtActividad;
    private javax.swing.JTextField txtDescripcion;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtUbicacion;
}