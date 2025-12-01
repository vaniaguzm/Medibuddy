
package medibuddy.interfaces;


import medibuddy.model.Medicamento;
import medibuddy.service.MedicamentoService;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ItemEvent; // Importante para detectar cambios en el combo

public class JMedicamentos extends javax.swing.JFrame {
    // Instancia del servicio de Medicamentos
    private final MedicamentoService medicamentoService = new MedicamentoService();
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(JMedicamentos.class.getName());

    /**
     * Creates new form JMedicamentos
     */
    public JMedicamentos() {
        initComponents();
<<<<<<< Updated upstream
        configurarCombosIniciales();
=======
>>>>>>> Stashed changes
        cargarTabla();
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
        btnAgregar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cnbTipo = new javax.swing.JComboBox<>();
        cnbDosis = new javax.swing.JComboBox<>();
        cnbModoAdmin = new javax.swing.JComboBox<>();
        txtOtro = new javax.swing.JTextField();

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
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Nombre Medicamento", "Tipo de Medicamento", "Dosis del Medicamento", "Modo de administracion"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
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

        jLabel4.setText("Tipo de medicamento:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                            .addComponent(jLabel5)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(cnbModoAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                            .addComponent(jLabel3)
                                            .addGap(18, 18, 18)
                                            .addComponent(cnbDosis, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGap(12, 253, Short.MAX_VALUE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel4)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(cnbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(txtOtro))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel2)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(txtNombreMed, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGap(0, 0, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(47, 47, 47)
                                .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(76, 76, 76)
                                .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(21, 21, 21))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(btnRegresar)
                        .addGap(141, 141, 141)
                        .addComponent(jLabel1)
                        .addGap(0, 286, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
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
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cnbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtOtro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cnbDosis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cnbModoAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
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
        int fila = jTable1.getSelectedRow();
        if (fila < 0) return;
        
        int id = (int) jTable1.getValueAt(fila, 0);
        int confirm = JOptionPane.showConfirmDialog(this, "¿Eliminar medicamento?", "Confirmar", JOptionPane.YES_NO_OPTION);
        
        if (confirm == JOptionPane.YES_OPTION) {
            try {
                Medicamento med = medicamentoService.buscarMedicamentoPorId(id);
                medicamentoService.eliminarMedicamento(med);
                cargarTabla();
                limpiarCampos();
            } catch (Exception e) {
                e.printStackTrace();
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
        }
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        txtNombreMed.setText("");
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void txtNombreMedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreMedActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreMedActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
       // 1. Recolección de datos
        String nombre = txtNombreMed.getText().trim();
        String tipo = (String) cnbTipo.getSelectedItem();
        String dosis = (String) cnbDosis.getSelectedItem();
        String modo = (String) cnbModoAdmin.getSelectedItem();
        String hora = JOptionPane.showInputDialog(this, "Ingrese hora recordatorio (ej. 08:00):", "08:00");

        // Lógica especial para "Otro"
        if ("Otro".equals(tipo)) {
            tipo = txtOtro.getText().trim(); // Guardamos lo que escribió el usuario
            if (tipo.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Especifique el tipo de medicamento en el campo 'Otro'.");
                return;
            }
            dosis = "N/A"; // O podrías pedir dosis manual con otro input
        }

        // 2. Validaciones
        if (nombre.isEmpty() || cnbTipo.getSelectedIndex() <= 0 || cnbModoAdmin.getSelectedIndex() <= 0 || hora == null) {
            JOptionPane.showMessageDialog(this, "Llene todos los campos.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            Medicamento nuevo = new Medicamento(nombre, tipo, dosis, hora, modo);
            medicamentoService.crearMedicamento(nuevo);
            
            JOptionPane.showMessageDialog(this, "Medicamento agregado.");
            limpiarCampos();
            cargarTabla();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al guardar: " + e.getMessage());
        }
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
       int fila = jTable1.getSelectedRow();
        if (fila < 0) return;

        try {
            int id = (int) jTable1.getValueAt(fila, 0);
            Medicamento med = medicamentoService.buscarMedicamentoPorId(id);

            if (med != null) {
                String tipo = (String) cnbTipo.getSelectedItem();
                String dosis = (String) cnbDosis.getSelectedItem();
                
                if ("Otro".equals(tipo)) {
                    tipo = txtOtro.getText().trim();
                }

                med.setNomMedicamento(txtNombreMed.getText().trim());
                med.setPresentacionMedicamento(tipo);
                med.setDosis(dosis);
                med.setModoAdministracion((String) cnbModoAdmin.getSelectedItem());
                
                medicamentoService.actualizarMedicamento(med);
                JOptionPane.showMessageDialog(this, "Actualizado.");
                cargarTabla();
                limpiarCampos();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al actualizar.");
        }
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void configurarCombosIniciales() {
        // A. Llenar Tipos de Medicamento
        cnbTipo.setModel(new DefaultComboBoxModel<>(new String[] {
            "--- Seleccione Tipo ---",
            "Tableta/Comprimido",
            "Cápsula",
            "Jarabe",
            "Suspensión",
            "Gotas",
            "Crema/Pomada",
            "Inyectable",
            "Otro"
        }));

        // B. Llenar Modos de Administración (Fijos)
        cnbModoAdmin.setModel(new DefaultComboBoxModel<>(new String[] {
            "--- Seleccione Modo ---",
            "Oral",
            "Sublingual",
            "Tópica (Piel)",
            "Oftálmica (Ojos)",
            "Intramuscular",
            "Intravenosa"
        }));

        // C. Configurar estado inicial
        txtOtro.setEnabled(false);
        cnbDosis.setEnabled(false);

        // D. Agregar Listener al Combo Tipo para cambiar Dosis dinámicamente
        cnbTipo.addItemListener(evt -> {
            if (evt.getStateChange() == ItemEvent.SELECTED) {
                actualizarComboDosisAndOtro((String) evt.getItem());
            }
        });
    }
    
    private void actualizarComboDosisAndOtro(String tipoSeleccionado) {
        DefaultComboBoxModel<String> modeloDosis = new DefaultComboBoxModel<>();
        txtOtro.setEnabled(false);
        txtOtro.setText("");
        cnbDosis.setEnabled(true);

        switch (tipoSeleccionado) {
            case "Tableta/Comprimido":
            case "Cápsula":
                modeloDosis.addElement("10 mg");
                modeloDosis.addElement("20 mg");
                modeloDosis.addElement("50 mg");
                modeloDosis.addElement("100 mg");
                modeloDosis.addElement("250 mg");
                modeloDosis.addElement("500 mg");
                modeloDosis.addElement("800 mg");
                modeloDosis.addElement("1 g");
                break;
            case "Jarabe":
            case "Suspensión":
                modeloDosis.addElement("5 ml (1 cucharadita)");
                modeloDosis.addElement("10 ml (1 cucharada)");
                modeloDosis.addElement("15 ml");
                modeloDosis.addElement("2.5 ml");
                break;
            case "Gotas":
                modeloDosis.addElement("2 gotas");
                modeloDosis.addElement("5 gotas");
                modeloDosis.addElement("10 gotas");
                modeloDosis.addElement("20 gotas (1 ml)");
                break;
            case "Crema/Pomada":
                modeloDosis.addElement("Aplicar capa fina");
                modeloDosis.addElement("Cantidad pequeña");
                modeloDosis.addElement("Generosamente");
                break;
            case "Inyectable":
                modeloDosis.addElement("1 ml");
                modeloDosis.addElement("2 ml");
                modeloDosis.addElement("3 ml");
                modeloDosis.addElement("5 ml");
                break;
            case "Otro":
                txtOtro.setEnabled(true); // Habilitar campo de texto
                txtOtro.requestFocus();
                modeloDosis.addElement("Especificar manual");
                cnbDosis.setEnabled(false); // Dosis manual se escribiría en otro lado si fuera necesario
                break;
            default:
                cnbDosis.setEnabled(false);
                break;
        }
        cnbDosis.setModel(modeloDosis);
    }
    
    private void cargarTabla() {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
        try {
            List<Medicamento> lista = medicamentoService.listarMedicamentos();
            for (Medicamento m : lista) {
                model.addRow(new Object[]{
                    m.getIdMedicamento(),
                    m.getNomMedicamento(),
                    m.getPresentacionMedicamento(),
                    m.getDosis(),
                    m.getModoAdministracion()
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void llenarCamposDesdeTabla() {
        int fila = jTable1.getSelectedRow();
        if (fila >= 0) {
            txtNombreMed.setText(jTable1.getValueAt(fila, 1).toString());
            // Nota: Seleccionar el combo exacto es complejo si es "Otro", 
            // pero para edición básica cargamos el nombre.
        }
    }

    private void limpiarCampos() {
        txtNombreMed.setText("");
        txtOtro.setText("");
        cnbTipo.setSelectedIndex(0);
        cnbModoAdmin.setSelectedIndex(0);
        // cnbDosis se limpia solo al cambiar tipo
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
    private javax.swing.JComboBox<String> cnbDosis;
    private javax.swing.JComboBox<String> cnbModoAdmin;
    private javax.swing.JComboBox<String> cnbTipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtNombreMed;
    private javax.swing.JTextField txtOtro;
    // End of variables declaration//GEN-END:variables
}
