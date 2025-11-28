
package medibuddy.interfaces;

// Importaciones necesarias las de la base de datos y para los mensajes y manejo de la tabla en la interfaz
import medibuddy.model.AdultoMayor; 
import medibuddy.service.AdultoMayorService;
import java.util.List;
import medibuddy.model.Medicamento;
import medibuddy.model.Fundacion;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.util.logging.Level;
import medibuddy.service.MedicamentoService; 
import medibuddy.service.FundacionService;
    
public class JAdultosMayores extends javax.swing.JFrame {
    //se crea la instancia del adulto
    private final AdultoMayorService adultoService = new AdultoMayorService();
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(JAdultosMayores.class.getName());
    private final MedicamentoService medicamentoService = new MedicamentoService();
    private final FundacionService fundacionService = new FundacionService();
    private final java.util.ArrayList<Medicamento> medicamentosTemporales = new java.util.ArrayList<>();
    
    private List<Medicamento> listaMedicamentosCatalogo;

    public JAdultosMayores() {
        initComponents();
        cargarTabla();
        cargarMedicamentosCombo();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        txtTelEmergencia = new javax.swing.JTextField();
        btnAgregar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnRegresar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        cnbMedicamento = new javax.swing.JComboBox<>();
        btnMas = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel1.setText("Gestion Adultos Mayores");

        jLabel2.setText("Nombre:");

        jLabel3.setText("Telefono:");

        jLabel4.setText("Telefono Emergencia:");

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

        txtTelEmergencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelEmergenciaActionPerformed(evt);
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

        jLabel5.setText("Medicamento a Suministrar:");

        cnbMedicamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cnbMedicamentoActionPerformed(evt);
            }
        });

        btnMas.setText("+");
        btnMas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTelefono))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTelEmergencia, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                        .addGap(4, 4, 4)
                        .addComponent(btnRegresar)
                        .addGap(141, 141, 141)
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(1, 1, 1)
                .addComponent(btnMas))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(btnRegresar))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtTelEmergencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cnbMedicamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnMas))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnActualizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAgregar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

    private void txtTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelefonoActionPerformed

    private void txtTelEmergenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelEmergenciaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelEmergenciaActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        String nombre = txtNombre.getText().trim();
        String telefono = txtTelefono.getText().trim();
        String telEmergencia = txtTelEmergencia.getText().trim();
        int indexMed = cnbMedicamento.getSelectedIndex();

        if (nombre.isEmpty() || telefono.isEmpty() || telEmergencia.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Debe llenar todos los campos de texto.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            //Crear el Adulto Mayor
            AdultoMayor nuevoAdulto = new AdultoMayor(nombre, "Adulto Mayor", telefono, telEmergencia);
            
            //  Revisamos si hay medicamentos en la lista temporal (del botón +)
            if (!medicamentosTemporales.isEmpty()) {
                for (Medicamento m : medicamentosTemporales) {
                    nuevoAdulto.agregarMedicamento(m);
                }
            } 
            // O si el usuario no usó el botón "+" pero seleccionó uno en el combo
            else if (cnbMedicamento.getSelectedIndex() > 0) {
                 int index = cnbMedicamento.getSelectedIndex();
                 Medicamento medCatalogo = listaMedicamentosCatalogo.get(index - 1);
                 Medicamento medParaAdulto = new Medicamento(
                    medCatalogo.getNomMedicamento(), medCatalogo.getDosis(), 
                    medCatalogo.getHoraRecordatorio(), medCatalogo.getModoAministracion());
                 nuevoAdulto.agregarMedicamento(medParaAdulto);
            }

            //Guardar en DB
            adultoService.crearAdultoMayor(nuevoAdulto);
            
            // Limpiar la lista temporal para el siguiente registro
            medicamentosTemporales.clear();
            JOptionPane.showMessageDialog(this, "Adulto Mayor registrado con éxito.");
            cargarTabla();
            btnLimpiarActionPerformed(null);
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al registrar: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            logger.log(Level.SEVERE, "Fallo al agregar", e);
        }
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        int filaSeleccionada = jTable1.getSelectedRow();
        if (filaSeleccionada < 0) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un registro para actualizar.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        if(txtNombre.getText().trim().isEmpty() || txtTelefono.getText().trim().isEmpty() || txtTelEmergencia.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(this,"Llena primero los campos antes de actualizar", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }else{
            try {
            int id = (int) jTable1.getValueAt(filaSeleccionada, 0);
            AdultoMayor adulto = adultoService.buscarAdultoMayorPorId(id);
            
            if (adulto != null) {
                adulto.setNomUsuario(txtNombre.getText().trim());
                adulto.setTelefono(txtTelefono.getText().trim());
                adulto.setContactoEmergencia(txtTelEmergencia.getText().trim());
                
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

                adultoService.actualizarAdultoMayor(adulto);
                JOptionPane.showMessageDialog(this, "Actualizado correctamente.");
                cargarTabla();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al actualizar.");
        }
        }

        
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // 1. Verificar si hay una fila seleccionada
        int filaSeleccionada = jTable1.getSelectedRow();
        
        if (filaSeleccionada < 0) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un registro de la tabla para eliminar.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        // 2. Obtener el ID de la fila seleccionada (Columna 0)
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        int id = (int) model.getValueAt(filaSeleccionada, 0);

        // 3. Confirmar la acción con el usuario
        int confirmacion = JOptionPane.showConfirmDialog(this, 
                "¿Está seguro que desea eliminar al Adulto Mayor con ID: " + id + "?\nEsta acción no se puede deshacer.", 
                "Confirmar Eliminación", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

        if (confirmacion == JOptionPane.YES_OPTION) {
            try {
                // 4. Buscar la entidad en la base de datos
                AdultoMayor adulto = adultoService.buscarAdultoMayorPorId(id);
                
                if (adulto != null) {
                    // 5. Llamar al Service para eliminar
                    adultoService.eliminarAdultoMayor(adulto);
                    
                    // 6. Mensaje de éxito y actualización de interfaz
                    JOptionPane.showMessageDialog(this, "Registro eliminado con éxito.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                    cargarTabla(); // Recargar datos en la tabla
                    btnLimpiarActionPerformed(null); // Limpiar los campos de texto
                } else {
                    JOptionPane.showMessageDialog(this, "El registro ya no existe en la base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (Exception e) {
                // 7. Manejo de errores (Ej: Restricción de llave foránea si tiene familiares asignados)
                JOptionPane.showMessageDialog(this, "No se pudo eliminar el registro.\nEs posible que tenga Familiares o Datos asociados.", "Error de Base de Datos", JOptionPane.ERROR_MESSAGE);
                logger.log(Level.SEVERE, "Fallo al eliminar Adulto", e);
            }
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        txtNombre.setText("");
        txtTelefono.setText("");
        txtTelEmergencia.setText("");
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
        logger.log(Level.SEVERE, "Fallo al abrir el Menú Principal", e);
    }
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void cnbMedicamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cnbMedicamentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cnbMedicamentoActionPerformed

    private void btnMasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMasActionPerformed
        int index = cnbMedicamento.getSelectedIndex();
        if (index > 0) { // Si seleccionó algo válido
            Medicamento medCatalogo = listaMedicamentosCatalogo.get(index - 1);
            
            // Crear copia para el adulto
            Medicamento medParaAdulto = new Medicamento(
                    medCatalogo.getNomMedicamento(), 
                    medCatalogo.getDosis(), 
                    medCatalogo.getHoraRecordatorio(),
                    medCatalogo.getModoAministracion()
            );
            
            medicamentosTemporales.add(medParaAdulto);
            JOptionPane.showMessageDialog(this, "Medicamento añadido a la lista temporal: " + medParaAdulto.getNomMedicamento());
        }
    }//GEN-LAST:event_btnMasActionPerformed

    private void cargarMedicamentosCombo() {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
        
        try {
            List<AdultoMayor> adultos = adultoService.listarAdultosMayores();
            List<Fundacion> todasFundaciones = fundacionService.listarFundaciones();

            for (AdultoMayor am : adultos) {
                
                // --- 1. MÚLTIPLES MEDICAMENTOS ---
                StringBuilder sbMed = new StringBuilder();
                if (am.getMedicamentos().isEmpty()) {
                    sbMed.append("Ninguno");
                } else {
                    for (Medicamento m : am.getMedicamentos()) {
                        // Agrega nombre y dosis, separado por coma
                        sbMed.append(m.getNomMedicamento()).append(" (").append(m.getDosis()).append("), ");
                    }
                    // Quitar la última coma y espacio extra
                    if (sbMed.length() > 2) sbMed.setLength(sbMed.length() - 2);
                }

                // --- 2. MÚLTIPLES ACTIVIDADES ---
                StringBuilder sbAct = new StringBuilder();
                boolean tieneActividad = false;
                
                for (Fundacion f : todasFundaciones) {
                    // Si el adulto está en la lista de asistentes de esta fundación
                    if (f.getAsistentes().contains(am)) {
                        sbAct.append(f.getActividad()).append(", ");
                        tieneActividad = true;
                    }
                }
                
                if (!tieneActividad) {
                    sbAct.append("No inscrito");
                } else {
                    // Quitar la última coma
                    if (sbAct.length() > 2) sbAct.setLength(sbAct.length() - 2);
                }

                model.addRow(new Object[]{
                    am.getIdUsuario(),
                    am.getNomUsuario(),
                    am.getTelefono(),
                    am.getContactoEmergencia(),
                    sbMed.toString(), // Muestra la lista concatenada
                    sbAct.toString()  // Muestra la lista concatenada
                });
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al cargar datos.", "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
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
        java.awt.EventQueue.invokeLater(() -> new JAdultosMayores().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnMas;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JComboBox<String> cnbMedicamento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtTelEmergencia;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
