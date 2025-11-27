
package medibuddy.interfaces;


import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.util.logging.Level;
import medibuddy.service.MedicamentoService;
import medibuddy.model.Medicamento;

public class JMedicamentos extends javax.swing.JFrame {
    // Instancia del servicio de Medicamentos
    private final MedicamentoService medicamentoService = new MedicamentoService();
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(JMedicamentos.class.getName());

    /**
     * Creates new form JMedicamentos
     */
    public JMedicamentos() {
        initComponents();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnEliminar = new javax.swing.JButton();
        btnRegresar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtNombreMed = new javax.swing.JTextField();
        txtDosisMed = new javax.swing.JTextField();
        btnAgregar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txtModoAdmin = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnEliminar.setBackground(new java.awt.Color(255, 0, 0));
        btnEliminar.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnRegresar.setText("Regresar");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
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
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Nombre Medicamento", "Dosis del Medicamento", "Modo de administracion"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel1.setText("Gestion Medicamento");

        jLabel2.setText("Nombre Medicamento:");

        jLabel3.setText("Dosis Medicamento:");

        txtNombreMed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreMedActionPerformed(evt);
            }
        });

        txtDosisMed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDosisMedActionPerformed(evt);
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

        jLabel5.setText("Modo de Administracion:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(btnRegresar)
                        .addGap(141, 141, 141)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 614, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(47, 47, 47)
                                .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(46, 46, 46)
                                .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtModoAdmin))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtNombreMed))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtDosisMed, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(btnRegresar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNombreMed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtDosisMed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtModoAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        int filaSeleccionada = jTable1.getSelectedRow();
        if (filaSeleccionada < 0) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un Medicamento para eliminar.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        // 1. Obtener el ID del Medicamento seleccionado
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        int idMed = (int) model.getValueAt(filaSeleccionada, 0);

        int confirmacion = JOptionPane.showConfirmDialog(this, 
                "¿Está seguro que desea eliminar el Medicamento con ID: " + idMed + "?", 
                "Confirmar Eliminación", JOptionPane.YES_NO_OPTION);

        if (confirmacion == JOptionPane.YES_OPTION) {
            try {
                // 2. Buscar la entidad para eliminar
                Medicamento medicamentoAEliminar = medicamentoService.buscarMedicamentoPorId(idMed);
                
                if (medicamentoAEliminar != null) {
                    // 3. Llama al Service para eliminar de la DB
                    medicamentoService.eliminarMedicamento(medicamentoAEliminar);
                    
                    JOptionPane.showMessageDialog(this, "Medicamento eliminado con éxito.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                    cargarTabla(); 
                    btnLimpiarActionPerformed(null);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Error al eliminar el Medicamento.", "Error de DB", JOptionPane.ERROR_MESSAGE);
                logger.log(Level.SEVERE, "Fallo al eliminar Medicamento", e);
            }
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        //Ocultar la ventana actual (JAdultosMayores)
        this.dispose(); // O this.setVisible(false);

        //Crear y mostrar la ventana del Menú Principal
        try {
            medibuddy.interfaces.JMenuPrincipal menu = new medibuddy.interfaces.JMenuPrincipal();
            menu.setVisible(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "No se pudo cargar el Menú Principal.", "Error de Navegación", JOptionPane.ERROR_MESSAGE);
            logger.log(Level.SEVERE, "Fallo al abrir el Menú Principal", e);
        }
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        txtNombreMed.setText("");
        txtDosisMed.setText("");
        txtModoAdmin.setText("");
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void txtNombreMedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreMedActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreMedActionPerformed

    private void txtDosisMedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDosisMedActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDosisMedActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
       String nombreMed = txtNombreMed.getText().trim();
        String dosisMed = txtDosisMed.getText().trim();
        String modoAdmin = txtModoAdmin.getText().trim();
        // hora de recordatorio
        String horaMed = JOptionPane.showInputDialog(this, "Ingrese la hora del recordatorio (ej. 08:00):"); 
        
        // Validar campos
        if (nombreMed.isEmpty() || dosisMed.isEmpty() || modoAdmin.isEmpty() || horaMed == null || horaMed.isEmpty() || modoAdmin.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Debe llenar todos los campos y la hora de recordatorio.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            //  Crear el objeto Medicamento
            Medicamento nuevoMedicamento = new Medicamento(nombreMed, dosisMed, horaMed, modoAdmin);
            nuevoMedicamento.setModoAdministracion(modoAdmin); // Asumiendo este método existe
            
            // 3. Guardar en la DB
            medicamentoService.crearMedicamento(nuevoMedicamento); // Asumiendo este método existe en MedicamentoService
            
            JOptionPane.showMessageDialog(this, "Medicamento registrado con éxito.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            cargarTabla(); 
            btnLimpiarActionPerformed(null);
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al registrar Medicamento.", "Error", JOptionPane.ERROR_MESSAGE);
            logger.log(Level.SEVERE, "Fallo al agregar Medicamento", e);
        }
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        int filaSeleccionada = jTable1.getSelectedRow();
        
        // Validar selección de fila
        if (filaSeleccionada < 0) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un registro para actualizar.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String nombreMed = txtNombreMed.getText().trim();
        String dosisMed = txtDosisMed.getText().trim();
        String modoAdmin = txtModoAdmin.getText().trim();
        
        // Validar campos llenos
        if (nombreMed.isEmpty() || dosisMed.isEmpty() || modoAdmin.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Debe llenar todos los campos.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            // Obtener el ID del medicamento de la tabla
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            int idMed = (int) model.getValueAt(filaSeleccionada, 0); 
            
            // Buscar la entidad en la DB
            Medicamento medicamentoExistente = medicamentoService.buscarMedicamentoPorId(idMed);
            
            if (medicamentoExistente != null) {
                //Actualizar los datos del objeto
                medicamentoExistente.setNomMedicamento(nombreMed);
                medicamentoExistente.setDosis(dosisMed);
                medicamentoExistente.setModoAdministracion(modoAdmin); 


                // Guardar los cambios en la DB
                medicamentoService.actualizarMedicamento(medicamentoExistente);
                
                JOptionPane.showMessageDialog(this, "Medicamento actualizado con éxito.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                cargarTabla(); 
                btnLimpiarActionPerformed(null);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al actualizar.", "Error de DB", JOptionPane.ERROR_MESSAGE);
            logger.log(Level.SEVERE, "Fallo al actualizar Medicamento", e);
        }
    }//GEN-LAST:event_btnActualizarActionPerformed

    
    private void cargarTabla() {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0); // Limpiar filas

        try {
            // Asumo que MedicamentoService.listarMedicamentos() existe
            List<Medicamento> medicamentos = medicamentoService.listarMedicamentos(); 
            
            for (Medicamento med : medicamentos) {

                model.addRow(new Object[]{
                    med.getIdMedicamento(), 
                    med.getNomMedicamento(),
                    med.getDosis(),
                    med.getModoAministracion()
                });
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al cargar datos de Medicamentos.", "Error", JOptionPane.ERROR_MESSAGE);
            logger.log(Level.SEVERE, "Fallo al cargar tabla de Medicamentos", e);
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
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new JMedicamentos().setVisible(true));
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
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtDosisMed;
    private javax.swing.JTextField txtModoAdmin;
    private javax.swing.JTextField txtNombreMed;
    // End of variables declaration//GEN-END:variables
}
