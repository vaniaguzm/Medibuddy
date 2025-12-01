
package medibuddy.interfaces;

// Importaciones necesarias las de la base de datos y para los mensajes y manejo de la tabla en la interfaz
import medibuddy.model.AdultoMayor;
import medibuddy.model.Fundacion;
import medibuddy.model.Medicamento;
import medibuddy.service.AdultoMayorService;
import medibuddy.service.FundacionService;

import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.util.logging.Level;

    
public class JAdultosMayores extends javax.swing.JFrame {
    //se crea la instancia del adulto
   private final AdultoMayorService adultoService = new AdultoMayorService();
    private final FundacionService fundacionService = new FundacionService();
    
    private List<Medicamento> listaMedicamentosCatalogo;

    public JAdultosMayores() {
        initComponents();
        cargarTabla();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        btnAgregar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnRegresar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtApellidoPa = new javax.swing.JTextField();
        txtApellidoMa = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel1.setText("Gestion Adultos Mayores");

        jLabel2.setText("Nombre:");

<<<<<<< Updated upstream
        jLabel3.setText("Telefono:");
=======
        jLabel3.setText("Telefono del Adulto:");
>>>>>>> Stashed changes

        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });

        txtTelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelefonoActionPerformed(evt);
            }
        });

        btnAgregar.setBackground(new java.awt.Color(111, 207, 123));
        btnAgregar.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnActualizar.setBackground(new java.awt.Color(0, 204, 255));
        btnActualizar.setForeground(new java.awt.Color(255, 255, 255));
        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        btnEliminar.setBackground(new java.awt.Color(255, 0, 0));
        btnEliminar.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnLimpiar.setBackground(new java.awt.Color(204, 204, 204));
        btnLimpiar.setForeground(new java.awt.Color(255, 255, 255));
        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Nombre", "Telefono", "Tel.Emergencia", "Medicamento", "Actividad"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        btnRegresar.setText("Regresar");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        jLabel6.setText("Apellido Paterno:");

        jLabel7.setText("Apellido Materno:");

        txtApellidoPa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtApellidoPaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 594, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
<<<<<<< Updated upstream
=======
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTelefono))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(23, 23, 23))
                            .addComponent(cnbMedicamento, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(btnAgregar)
                        .addGap(64, 64, 64)
                        .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
>>>>>>> Stashed changes
                        .addGap(4, 4, 4)
                        .addComponent(btnRegresar)
                        .addGap(77, 77, 77)
                        .addComponent(jLabel1))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnAgregar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel6)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtApellidoPa))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel7)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtApellidoMa))))))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(btnRegresar))
                .addGap(18, 18, 18)
<<<<<<< Updated upstream
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtApellidoPa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtApellidoMa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
=======
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cnbMedicamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnMas))))
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 6, Short.MAX_VALUE)
                        .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnActualizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAgregar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
>>>>>>> Stashed changes
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

    private void txtTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelefonoActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        String nombre = txtNombre.getText().trim();
        String apePa = txtApellidoPa.getText().trim();
        String apeMa = txtApellidoMa.getText().trim();
        String telefono = txtTelefono.getText().trim();
<<<<<<< Updated upstream

        if (nombre.isEmpty() || apePa.isEmpty() || telefono.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nombre, Apellido Paterno y Teléfono son obligatorios.", "Aviso", JOptionPane.WARNING_MESSAGE);
=======
        int indexMed = cnbMedicamento.getSelectedIndex();

        if (nombre.isEmpty() || telefono.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Debe llenar todos los campos de texto.", "Advertencia", JOptionPane.WARNING_MESSAGE);
>>>>>>> Stashed changes
            return;
        }

        try {
<<<<<<< Updated upstream
            // 1. Crear Objeto con los datos separados
            AdultoMayor nuevoAdulto = new AdultoMayor(nombre, apePa, apeMa, telefono);
=======
            //Crear el Adulto Mayor
            AdultoMayor nuevoAdulto = new AdultoMayor(nombre, "Adulto Mayor", telefono);
>>>>>>> Stashed changes
            
            // 2. Guardar en BD (Sin medicamentos, esos se asignan en otro lado o se eliminó la función aquí)
            adultoService.crearAdultoMayor(nuevoAdulto);
            
            JOptionPane.showMessageDialog(this, "Adulto Mayor registrado exitosamente.");
            btnLimpiarActionPerformed(null);
            cargarTabla();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al registrar: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        int fila = jTable1.getSelectedRow();
        if (fila < 0) {
            JOptionPane.showMessageDialog(this, "Seleccione un registro para actualizar.");
            return;
        }
<<<<<<< Updated upstream
=======
        
        if(txtNombre.getText().trim().isEmpty() || txtTelefono.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(this,"Llena primero los campos antes de actualizar", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }else{
            try {
            int id = (int) jTable1.getValueAt(filaSeleccionada, 0);
            AdultoMayor adulto = adultoService.buscarAdultoMayorPorId(id);
            
            if (adulto != null) {
                adulto.setNomUsuario(txtNombre.getText().trim());
                adulto.setTelefono(txtTelefono.getText().trim());

                
                // Actualizar Medicamento si cambió en el combo
                int indexMed = cnbMedicamento.getSelectedIndex();
                if (indexMed > 0) {
                    // Borramos anteriores (simplificación para este ejercicio)
                    adulto.getMedicamentos().clear();
                    
                    Medicamento medCatalogo = listaMedicamentosCatalogo.get(indexMed - 1);
                    Medicamento nuevoMed = new Medicamento(
                        medCatalogo.getNomMedicamento(), 
                        medCatalogo.getDosis(), 
                        medCatalogo.getHoraRecordatorio(),
                        medCatalogo.getModoAministracion()
                    );
                    adulto.agregarMedicamento(nuevoMed);
                }
>>>>>>> Stashed changes

        try {
            int id = (int) jTable1.getValueAt(fila, 0);
            AdultoMayor adulto = adultoService.buscarAdultoMayorPorId(id);

            if (adulto != null) {
                // Actualizar datos personales
                adulto.setNomUsuario(txtNombre.getText().trim());
                adulto.setApellidoPaterno(txtApellidoPa.getText().trim());
                adulto.setApellidoMaterno(txtApellidoMa.getText().trim());
                adulto.setTelefono(txtTelefono.getText().trim());
                
                adultoService.actualizarAdultoMayor(adulto);
                
                JOptionPane.showMessageDialog(this, "Registro actualizado.");
                btnLimpiarActionPerformed(null);
                cargarTabla();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al actualizar.");
        }
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        int fila = jTable1.getSelectedRow();
        if (fila < 0) {
            JOptionPane.showMessageDialog(this, "Seleccione un registro.");
            return;
        }

        int id = (int) jTable1.getValueAt(fila, 0);
        int confirm = JOptionPane.showConfirmDialog(this, "¿Eliminar al Adulto ID: " + id + "?", "Confirmar", JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            try {
                AdultoMayor am = adultoService.buscarAdultoMayorPorId(id);
                if (am != null) {
                    adultoService.eliminarAdultoMayor(am);
                    JOptionPane.showMessageDialog(this, "Eliminado correctamente.");
                    cargarTabla();
                    btnLimpiarActionPerformed(null);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "No se pudo eliminar (puede tener datos asociados).");
            }
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        txtNombre.setText("");
        txtApellidoPa.setText("");
        txtApellidoMa.setText("");
        txtTelefono.setText("");
<<<<<<< Updated upstream
=======

>>>>>>> Stashed changes
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
    //Ocultar la ventana actual (JAdultosMayores)
    this.dispose(); // O this.setVisible(false);

    //Crear y mostrar la ventana del Menú Principal
    try {
        medibuddy.interfaces.JMenuPrincipal menu = new medibuddy.interfaces.JMenuPrincipal();
        menu.setVisible(true);
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "No se pudo cargar el Menú Principal.", "Error de Navegación", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void txtApellidoPaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtApellidoPaActionPerformed

    }//GEN-LAST:event_txtApellidoPaActionPerformed

<<<<<<< Updated upstream
   
    
    
    private void cargarTabla(){
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0); // Limpiar tabla

        try {
            // 1. Obtener lista de adultos
            List<AdultoMayor> adultos = adultoService.listarAdultosMayores();
            
            // OMISIÓN TEMPORAL: No cargamos fundaciones por ahora
            // List<Fundacion> todasFundaciones = fundacionService.listarFundaciones(); 

            for (AdultoMayor am : adultos) {
                
                // A. CONCATENAR NOMBRE COMPLETO
                String nombreCompleto = am.getNomUsuario() + " " + 
                                        (am.getApellidoPaterno() != null ? am.getApellidoPaterno() : "") + " " + 
                                        (am.getApellidoMaterno() != null ? am.getApellidoMaterno() : "");

                // B. OBTENER TELÉFONO DE EMERGENCIA (DEL FAMILIAR)
                String telEmergencia = "Sin Familiar";
                if (am.getFamiliarResponsable() != null) {
                    telEmergencia = am.getFamiliarResponsable().getTelefono() + 
                                    " (" + am.getFamiliarResponsable().getRelacion() + ")";
                }

                // C. LISTA DE MEDICAMENTOS (Solo visualización)
                StringBuilder sbMed = new StringBuilder();
                if (am.getMedicamentos().isEmpty()) {
                    sbMed.append("Ninguno");
                } else {
                    for (Medicamento m : am.getMedicamentos()) {
                        sbMed.append(m.getNomMedicamento()).append(" (");
                    }
                    // Quitar última coma
                    if (sbMed.length() > 2) sbMed.setLength(sbMed.length() - 2);
                }


                // AGREGAR FILA
                model.addRow(new Object[]{
                    am.getIdUsuario(),
                    nombreCompleto.trim(), // Nombre + Apellidos
                    am.getTelefono(),
                    telEmergencia,         // Dato del Familiar
                    sbMed.toString(),      // Medicamentos
                });
=======
    private void cargarMedicamentosCombo() {
        // 1. Usamos DefaultComboBoxModel, NO DefaultTableModel
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
        
        try {
            // 2. Traemos la lista de MEDICAMENTOS, no de adultos
            listaMedicamentosCatalogo = medicamentoService.listarMedicamentos();
            
            // 3. Opción por defecto
            model.addElement("--- Seleccione Medicamento ---");
            
            // 4. Llenamos el modelo con los datos del medicamento
            for (Medicamento m : listaMedicamentosCatalogo) {
                // Mostramos Nombre y Dosis
                model.addElement(m.getNomMedicamento() + " - " + m.getDosis());
>>>>>>> Stashed changes
            }
            
            // 5. Asignamos el modelo al ComboBox
            cnbMedicamento.setModel(model);
            
        } catch (Exception e) {
<<<<<<< Updated upstream
            JOptionPane.showMessageDialog(this, "Error al cargar la tabla.", "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace(); // Imprime el error en consola para depurar
=======
            logger.log(Level.SEVERE, "Error al cargar medicamentos en el combo", e);
            JOptionPane.showMessageDialog(this, "No se pudieron cargar los medicamentos.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void cargarTabla(){
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
        
        try {
            List<AdultoMayor> adultos = adultoService.listarAdultosMayores();
            
            // Para encontrar la actividad, necesitamos todas las fundaciones
            List<Fundacion> todasFundaciones = fundacionService.listarFundaciones();

            for (AdultoMayor am : adultos) {
                
                //Lógica para mostrar Medicamento
                String infoMedicamento = "Ninguno";
                if (!am.getMedicamentos().isEmpty()) {
                    // Tomamos el último agregado o el primero
                    Medicamento m = am.getMedicamentos().get(0);
                    // Formato pedido: Nombre y Dosis, Modo
                    infoMedicamento = m.getNomMedicamento() + " - " + m.getDosis() + ", " + m.getModoAministracion();
                }

                //Lógica para mostrar Actividad (Buscando en fundaciones)
                String infoActividad = "No inscrito";
                for (Fundacion f : todasFundaciones) {
                    if (f.getAsistentes().contains(am)) {
                        infoActividad = f.getActividad(); // Muestra la actividad de esa fundación
                        break; // dejamos de buscar
                    }
                }

                model.addRow(new Object[]{
                    am.getIdUsuario(),
                    am.getNomUsuario(),
                    am.getTelefono(),
                    am.getContactoEmergencia(),
                    infoMedicamento, 
                    infoActividad    
                });
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al cargar datos.", "Error", JOptionPane.ERROR_MESSAGE);
            logger.log(Level.SEVERE, "Fallo al cargar tabla", e);
>>>>>>> Stashed changes
        }
    }
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new JAdultosMayores().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
<<<<<<< Updated upstream
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
=======
    private javax.swing.JLabel jLabel5;
>>>>>>> Stashed changes
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtApellidoMa;
    private javax.swing.JTextField txtApellidoPa;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
