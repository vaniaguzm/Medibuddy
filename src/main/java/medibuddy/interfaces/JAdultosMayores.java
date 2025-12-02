package medibuddy.interfaces;

import medibuddy.model.AdultoMayor;
import medibuddy.service.AdultoMayorService;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class JAdultosMayores extends javax.swing.JFrame {

    // Instancia del servicio
    private final AdultoMayorService adultoService = new AdultoMayorService();
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(JAdultosMayores.class.getName());

    /**
     * Creates new form JAdultosMayores
     */
    public JAdultosMayores() {
        initComponents();
        cargarTabla(); // Cargar datos al iniciar
        setLocationRelativeTo(null); // Centrar ventana
        inicializarDatosPrueba();
    }

    /**
     * Método para limpiar las cajas de texto
     */
    private void limpiarCampos() {
        txtNombre.setText("");
        txtApPaterno.setText("");
        txtApMaterno.setText("");
        txtTelefono.setText("");
        txtEmergencia.setText("");
    }

    /**
     * Carga la lista de la base de datos a la JTable
     */
    private void cargarTabla() {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0); // Limpiar tabla
        try {
            List<AdultoMayor> lista = adultoService.listarAdultosMayores();
            for (AdultoMayor am : lista) {
                model.addRow(new Object[]{
                    am.getIdUsuario(),
                    am.getNomUsuario(),
                    am.getApellidoPaterno(),
                    am.getApellidoMaterno(),
                    am.getTelefono(),
                    am.getContactoEmergencia()
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al cargar datos: " + e.getMessage());
        }
    }

    private void inicializarDatosPrueba() {
        try {
            AdultoMayor a1 = new AdultoMayor("Juan Pérez", "López", "García", "33345678753","3311223344");
            a1.setContactoEmergencia("No tiene"); // Se actualizará cuando se cree el familiar

            AdultoMayor a2 = new AdultoMayor("María González", "Sánchez", "Torres","33456745312" ,"3344556677");
            a2.setContactoEmergencia("No tiene");

            AdultoMayor a3 = new AdultoMayor("Roberto Díaz", "Ramírez", "Vega", "3346956712","3388990011");
            a3.setContactoEmergencia("No tiene");

            AdultoMayor a4 = new AdultoMayor("Carmen Ruiz", "Ortiz", "Méndez", "3348576790","3322114455");
            a4.setContactoEmergencia("No tiene");

            System.out.println("✅ Datos de prueba de Adultos Mayores creados.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "No se pudo cargar los datos.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btnRegresar = new javax.swing.JButton();
        
        // Etiquetas
        jLabel2 = new javax.swing.JLabel(); // Nombre
        jLabel3 = new javax.swing.JLabel(); // Ap Paterno
        jLabel4 = new javax.swing.JLabel(); // Ap Materno
        jLabel5 = new javax.swing.JLabel(); // Telefono
        jLabel6 = new javax.swing.JLabel(); // Emergencia

        // Campos de Texto
        txtNombre = new javax.swing.JTextField();
        txtApPaterno = new javax.swing.JTextField();
        txtApMaterno = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        txtEmergencia = new javax.swing.JTextField();

        // Botones
        btnAgregar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();

        // Tabla
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gestión de Adultos Mayores");

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); 
        jLabel1.setText("Gestión Adultos Mayores");

        btnRegresar.setText("Regresar");
        btnRegresar.addActionListener(evt -> btnRegresarActionPerformed(evt));

        // Configuración de etiquetas y campos
        jLabel2.setText("Nombre:");
        jLabel3.setText("Apellido Paterno:");
        jLabel4.setText("Apellido Materno:");
        jLabel5.setText("Teléfono:");
        jLabel6.setText("Contacto Emergencia:");

        // Configuración de Botones
        btnAgregar.setBackground(new java.awt.Color(111, 207, 123)); // Verde
        btnAgregar.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(evt -> btnAgregarActionPerformed(evt));

        btnActualizar.setBackground(new java.awt.Color(0, 204, 255)); // Azul
        btnActualizar.setForeground(new java.awt.Color(255, 255, 255));
        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(evt -> btnActualizarActionPerformed(evt));

        btnEliminar.setBackground(new java.awt.Color(255, 0, 0)); // Rojo
        btnEliminar.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(evt -> btnEliminarActionPerformed(evt));

        btnLimpiar.setBackground(new java.awt.Color(204, 204, 204)); // Gris
        btnLimpiar.setForeground(new java.awt.Color(255, 255, 255));
        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(evt -> btnLimpiarActionPerformed(evt));

        // Configuración de Tabla
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {},
            new String [] {
                "ID", "Nombre", "Ap. Paterno", "Ap. Materno", "Teléfono", "Emergencia"
            }
        ) {
            boolean[] canEdit = new boolean [] { false, false, false, false, false, false };
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        
        // Evento para llenar campos al hacer click en la tabla (Opcional, mejora UX)
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        
        jScrollPane1.setViewportView(jTable1);

        // --- DISEÑO (LAYOUT) ---
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnRegresar)
                        .addGap(160, 160, 160)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                            .addComponent(txtApPaterno)
                            .addComponent(txtApMaterno)
                            .addComponent(txtTelefono)
                            .addComponent(txtEmergencia)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(40, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(btnRegresar))
                .addGap(25, 25, 25)
                // Fila Nombre
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                // Fila Ap Paterno
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtApPaterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                // Fila Ap Materno
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtApMaterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                // Fila Telefono
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                // Fila Emergencia
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtEmergencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                // Botones
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                // Tabla
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>                        

    // -------------------------------------------------------------------------
    // ACCIONES DE BOTONES
    // -------------------------------------------------------------------------

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {
        // 1. Recolección de datos
        String nombre = txtNombre.getText().trim();
        String apPaterno = txtApPaterno.getText().trim();
        String apMaterno = txtApMaterno.getText().trim();
        String telefono = txtTelefono.getText().trim();
        String emergencia = txtEmergencia.getText().trim();

        // 2. Validaciones
        if (nombre.isEmpty() || apPaterno.isEmpty() || telefono.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nombre, Apellido Paterno y Teléfono son obligatorios.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            // 3. Crear Objeto 
            AdultoMayor nuevoAdulto = new AdultoMayor();
            nuevoAdulto.setNomUsuario(nombre);
            nuevoAdulto.setApellidoPaterno(apPaterno); // 👈 Verifica que este setter exista en el modelo
            nuevoAdulto.setApellidoMaterno(apMaterno); // 👈 Verifica que este setter exista en el modelo
            nuevoAdulto.setTelefono(telefono);
            nuevoAdulto.setContactoEmergencia(emergencia);
            nuevoAdulto.setTipoUsuario("Adulto Mayor");

            // 4. Guardar
            adultoService.crearAdultoMayor(nuevoAdulto);

            JOptionPane.showMessageDialog(this, "Adulto Mayor registrado correctamente.");
            limpiarCampos();
            cargarTabla();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al guardar: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {
        int fila = jTable1.getSelectedRow();
        if (fila < 0) {
            JOptionPane.showMessageDialog(this, "Seleccione un usuario de la tabla para actualizar.");
            return;
        }

        try {
            int id = (int) jTable1.getValueAt(fila, 0); // ID está en col 0
            AdultoMayor adulto = adultoService.buscarAdultoMayorPorId(id);

            if (adulto != null) {
                // Actualizar datos del objeto con lo que hay en las cajas de texto
                adulto.setNomUsuario(txtNombre.getText().trim());
                adulto.setApellidoPaterno(txtApPaterno.getText().trim());
                adulto.setApellidoMaterno(txtApMaterno.getText().trim());
                adulto.setTelefono(txtTelefono.getText().trim());
                adulto.setContactoEmergencia(txtEmergencia.getText().trim());

                adultoService.actualizarAdultoMayor(adulto);
                
                JOptionPane.showMessageDialog(this, "Usuario actualizado correctamente.");
                cargarTabla();
                limpiarCampos();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al actualizar: " + e.getMessage());
        }
    }

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {
        int fila = jTable1.getSelectedRow();
        if (fila < 0) {
            JOptionPane.showMessageDialog(this, "Seleccione un usuario para eliminar.");
            return;
        }

        int id = (int) jTable1.getValueAt(fila, 0);
        int confirm = JOptionPane.showConfirmDialog(this, 
                "¿Está seguro de eliminar a este Adulto Mayor?\nSe borrarán sus medicinas y citas asociadas.", 
                "Confirmar Eliminación", 
                JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            try {
                AdultoMayor adulto = adultoService.buscarAdultoMayorPorId(id);
                adultoService.eliminarAdultoMayor(adulto);
                
                cargarTabla();
                limpiarCampos();
                JOptionPane.showMessageDialog(this, "Usuario eliminado.");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Error al eliminar: " + e.getMessage());
            }
        }
    }

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {
        limpiarCampos();
        jTable1.clearSelection();
    }

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {
        this.dispose(); 
        // Aquí deberías abrir tu menú principal
        try {
            medibuddy.interfaces.JMenuPrincipal menu = new medibuddy.interfaces.JMenuPrincipal();
            menu.setVisible(true);
        } catch (Exception e) {
            // Si no existe la clase menú aún, solo cierra esta.
        }
    }
    
    // Al hacer click en la tabla, llenamos los campos de texto
    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {                                     
        int fila = jTable1.getSelectedRow();
        if (fila >= 0) {
            txtNombre.setText(jTable1.getValueAt(fila, 1).toString());
            // Manejo de nulos para evitar errores si el apellido viene vacío
            Object apPaterno = jTable1.getValueAt(fila, 2);
            Object apMaterno = jTable1.getValueAt(fila, 3);
            Object tel = jTable1.getValueAt(fila, 4);
            Object emerg = jTable1.getValueAt(fila, 5);

            txtApPaterno.setText(apPaterno != null ? apPaterno.toString() : "");
            txtApMaterno.setText(apMaterno != null ? apMaterno.toString() : "");
            txtTelefono.setText(tel != null ? tel.toString() : "");
            txtEmergencia.setText(emerg != null ? emerg.toString() : "");
        }
    } 

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new JAdultosMayores().setVisible(true));
    }

    // Variables declaration
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtApPaterno;
    private javax.swing.JTextField txtApMaterno;
    private javax.swing.JTextField txtTelefono;
    private javax.swing.JTextField txtEmergencia;
    // End of variables declaration                   
}