
package medibuddy.interfaces;

import medibuddy.model.Actividad;
import medibuddy.model.Fundacion;
import medibuddy.service.ActividadService;
import medibuddy.service.FundacionService;

import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.util.logging.Level;
import java.util.logging.Logger;


public class JActividad extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(JActividad.class.getName());

    // Servicios
    private final ActividadService actividadService = new ActividadService();
    private final FundacionService fundacionService = new FundacionService();
    
    // Lista auxiliar para el combo de fundaciones
    private List<Fundacion> listaFundaciones;

    public JActividad() {
        initComponents();
        cargarCombos();
        cargarTabla();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnAgregar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        btnRegresar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        btnAgregar1 = new javax.swing.JButton();
        btnEliminar1 = new javax.swing.JButton();
        btnActualizar1 = new javax.swing.JButton();
        btnLimpiar1 = new javax.swing.JButton();
        cnbFundacion = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        txtActividad = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtDescripcion = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtFecha = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        txtUbicacion = new javax.swing.JTextField();
        btnRegresar1 = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Fundacion", "Actividad", "Direccion"
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

        btnAgregar.setBackground(new java.awt.Color(111, 207, 123));
        btnAgregar.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
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

        btnActualizar.setBackground(new java.awt.Color(0, 204, 255));
        btnActualizar.setForeground(new java.awt.Color(255, 255, 255));
        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
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

        btnRegresar.setText("Regresar");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        jLabel1.setText("Gestion Actividad");

        jLabel2.setText("Fundacion Creadora:");

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Fundacion", "Actividad", "Direccion"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTable2);

        btnAgregar1.setBackground(new java.awt.Color(111, 207, 123));
        btnAgregar1.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregar1.setText("Agregar");
        btnAgregar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregar1ActionPerformed(evt);
            }
        });

        btnEliminar1.setBackground(new java.awt.Color(255, 0, 0));
        btnEliminar1.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminar1.setText("Eliminar");
        btnEliminar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminar1ActionPerformed(evt);
            }
        });

        btnActualizar1.setBackground(new java.awt.Color(0, 204, 255));
        btnActualizar1.setForeground(new java.awt.Color(255, 255, 255));
        btnActualizar1.setText("Actualizar");
        btnActualizar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizar1ActionPerformed(evt);
            }
        });

        btnLimpiar1.setBackground(new java.awt.Color(204, 204, 204));
        btnLimpiar1.setForeground(new java.awt.Color(255, 255, 255));
        btnLimpiar1.setText("Limpiar");
        btnLimpiar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiar1ActionPerformed(evt);
            }
        });

        jLabel3.setText("Nombre de Actividad:");

        jLabel4.setText("Descripcion:");

        jLabel5.setText("Fecha:");

        jLabel6.setText("Ubicacion:");

        jLabel7.setText("Cupo Maximo:");

        btnRegresar1.setText("Regresar");
        btnRegresar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresar1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 6, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 422, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnAgregar1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnActualizar1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnEliminar1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnLimpiar1, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtUbicacion))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cnbFundacion, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtActividad))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtDescripcion))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnRegresar1)
                                        .addGap(33, 33, 33)
                                        .addComponent(jLabel1))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(btnRegresar1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cnbFundacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnEliminar1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnActualizar1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAgregar1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnLimpiar1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        String nombre = txtActividad.getText().trim();
        String desc = txtDescripcion.getText().trim();
        String fecha = txtFecha.getText().trim();
        String ubi = txtUbicacion.getText().trim();
        int idxFundacion = cnbFundacion.getSelectedIndex();
        
        if (nombre.isEmpty() || fecha.isEmpty() || idxFundacion <= 0) {
            JOptionPane.showMessageDialog(this, "Nombre, Fecha y Fundación son obligatorios.");
            return;
        }

        try {
            int cupo = Integer.parseInt((String) jComboBox1.getSelectedItem());
            Fundacion fundacion = listaFundaciones.get(idxFundacion - 1);
            
            Actividad nueva = new Actividad(nombre, desc, fecha, ubi, cupo);
            nueva.setOrganizador(fundacion); // Asignar la relación
            
            actividadService.crearActividad(nueva);
            
            JOptionPane.showMessageDialog(this, "Actividad creada.");
            cargarTabla();
            btnLimpiarActionPerformed(null);
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al guardar: " + e.getMessage());
        }
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        int fila = jTable1.getSelectedRow();
        if (fila < 0) return;
        
        int id = (int) jTable1.getValueAt(fila, 0);
        int confirm = JOptionPane.showConfirmDialog(this, "¿Eliminar actividad?", "Confirmar", JOptionPane.YES_NO_OPTION);
        
        if (confirm == JOptionPane.YES_OPTION) {
            try {
                Actividad a = actividadService.buscarActividadPorId(id);
                actividadService.eliminarActividad(a);
                cargarTabla();
                btnLimpiarActionPerformed(null);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        int fila = jTable1.getSelectedRow();
        if (fila < 0) return;
        
        try {
            int id = (int) jTable1.getValueAt(fila, 0);
            Actividad a = actividadService.buscarActividadPorId(id);
            
            if (a != null) {
                a.setNomActividad(txtActividad.getText().trim());
                a.setDescripcion(txtDescripcion.getText().trim());
                a.setFecha(txtFecha.getText().trim());
                a.setUbicacion(txtUbicacion.getText().trim());
                a.setCupoMaximo(Integer.parseInt((String) jComboBox1.getSelectedItem()));
                
                if (cnbFundacion.getSelectedIndex() > 0) {
                    a.setOrganizador(listaFundaciones.get(cnbFundacion.getSelectedIndex() - 1));
                }
                
                actividadService.actualizarActividad(a);
                JOptionPane.showMessageDialog(this, "Actualizado.");
                cargarTabla();
                btnLimpiarActionPerformed(null);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al actualizar.");
        }
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        txtActividad.setText("");
        txtDescripcion.setText("");
        txtFecha.setText("");
        txtUbicacion.setText("");
        cnbFundacion.setSelectedIndex(0);
        jComboBox1.setSelectedIndex(0); // Volver a 100
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnAgregar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregar1ActionPerformed
        String nombre = txtActividad.getText().trim();
        String desc = txtDescripcion.getText().trim();
        String fecha = txtFecha.getText().trim();
        String ubi = txtUbicacion.getText().trim();
        int idxFundacion = cnbFundacion.getSelectedIndex();
        
        if (nombre.isEmpty() || fecha.isEmpty() || idxFundacion <= 0) {
            JOptionPane.showMessageDialog(this, "Nombre, Fecha y Fundación son obligatorios.");
            return;
        }

        try {
            int cupo = Integer.parseInt((String) jComboBox1.getSelectedItem());
            Fundacion fundacion = listaFundaciones.get(idxFundacion - 1);
            
            Actividad nueva = new Actividad(nombre, desc, fecha, ubi, cupo);
            nueva.setOrganizador(fundacion); // Asignar la relación
            
            actividadService.crearActividad(nueva);
            
            JOptionPane.showMessageDialog(this, "Actividad creada.");
            cargarTabla();
            btnLimpiarActionPerformed(null);
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al guardar: " + e.getMessage());
        }
    }//GEN-LAST:event_btnAgregar1ActionPerformed

    private void btnEliminar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminar1ActionPerformed
        int fila = jTable1.getSelectedRow();
        if (fila < 0) return;
        
        int id = (int) jTable1.getValueAt(fila, 0);
        int confirm = JOptionPane.showConfirmDialog(this, "¿Eliminar actividad?", "Confirmar", JOptionPane.YES_NO_OPTION);
        
        if (confirm == JOptionPane.YES_OPTION) {
            try {
                Actividad a = actividadService.buscarActividadPorId(id);
                actividadService.eliminarActividad(a);
                cargarTabla();
                btnLimpiarActionPerformed(null);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_btnEliminar1ActionPerformed

    private void btnActualizar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizar1ActionPerformed
        int fila = jTable1.getSelectedRow();
        if (fila < 0) return;
        
        try {
            int id = (int) jTable1.getValueAt(fila, 0);
            Actividad a = actividadService.buscarActividadPorId(id);
            
            if (a != null) {
                a.setNomActividad(txtActividad.getText().trim());
                a.setDescripcion(txtDescripcion.getText().trim());
                a.setFecha(txtFecha.getText().trim());
                a.setUbicacion(txtUbicacion.getText().trim());
                a.setCupoMaximo(Integer.parseInt((String) jComboBox1.getSelectedItem()));
                
                if (cnbFundacion.getSelectedIndex() > 0) {
                    a.setOrganizador(listaFundaciones.get(cnbFundacion.getSelectedIndex() - 1));
                }
                
                actividadService.actualizarActividad(a);
                JOptionPane.showMessageDialog(this, "Actualizado.");
                cargarTabla();
                btnLimpiarActionPerformed(null);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al actualizar.");
        }
    }//GEN-LAST:event_btnActualizar1ActionPerformed

    private void btnLimpiar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiar1ActionPerformed
        txtActividad.setText("");
        txtDescripcion.setText("");
        txtFecha.setText("");
        txtUbicacion.setText("");
        cnbFundacion.setSelectedIndex(0);
        jComboBox1.setSelectedIndex(0); // Volver a 100
    }//GEN-LAST:event_btnLimpiar1ActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        //Ocultar la ventana actual (JAdultosMayores)
        this.dispose(); // O this.setVisible(false);

        //Crear y mostrar la ventana del Menú Principal
        try {
            // Reemplaza JMenuPrincipal() con el nombre real de tu clase de Menú Principal
            medibuddy.interfaces.JMenuPrincipal menu = new medibuddy.interfaces.JMenuPrincipal();
            menu.setVisible(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "No se pudo cargar el Menú Principal.", "Error de Navegación", JOptionPane.ERROR_MESSAGE);
            logger.log(Level.SEVERE, "Fallo al abrir el Menú Principal", e);
        }
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void btnRegresar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresar1ActionPerformed
        //Ocultar la ventana actual (JAdultosMayores)
        this.dispose(); // O this.setVisible(false);

        //Crear y mostrar la ventana del Menú Principal
        try {
            // Reemplaza JMenuPrincipal() con el nombre real de tu clase de Menú Principal
            medibuddy.interfaces.JMenuPrincipal menu = new medibuddy.interfaces.JMenuPrincipal();
            menu.setVisible(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "No se pudo cargar el Menú Principal.", "Error de Navegación", JOptionPane.ERROR_MESSAGE);
            logger.log(Level.SEVERE, "Fallo al abrir el Menú Principal", e);
        }
    }//GEN-LAST:event_btnRegresar1ActionPerformed

    private void cargarCombos() {
        try {
            // A. Combo Fundaciones
            listaFundaciones = fundacionService.listarFundaciones();
            DefaultComboBoxModel<String> modelFun = new DefaultComboBoxModel<>();
            modelFun.addElement("--- Seleccione Fundación ---");
            for (Fundacion f : listaFundaciones) {
                modelFun.addElement(f.getNombre());
            }
            cnbFundacion.setModel(modelFun);

            // B. Combo Cupo Máximo (Predeterminado a 100 como pediste)
            DefaultComboBoxModel<String> modelCupo = new DefaultComboBoxModel<>();
            modelCupo.addElement("100"); // Default
            modelCupo.addElement("50");
            modelCupo.addElement("200");
            modelCupo.addElement("500");
            jComboBox1.setModel(modelCupo); // jComboBox1 es el combo de cupo

        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error cargando combos", e);
        }
    }
    
    private void cargarTabla() {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
        
        try {
            List<Actividad> actividades = actividadService.listarActividades();
            for (Actividad a : actividades) {
                String nombreOrg = (a.getOrganizador() != null) ? a.getOrganizador().getNombre() : "Sin Asignar";
                
                model.addRow(new Object[]{
                    a.getIdActividad(),
                    nombreOrg,          // Fundación
                    a.getNomActividad(),
                    a.getFecha(),
                    a.getUbicacion(),
                    a.getCupoMaximo()
                });
            }
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error cargando tabla", e);
        }
    }
    
    private void llenarCampos() {
        int fila = jTable1.getSelectedRow();
        if (fila >= 0) {
            try {
                int id = (int) jTable1.getValueAt(fila, 0);
                Actividad a = actividadService.buscarActividadPorId(id);
                
                if (a != null) {
                    txtActividad.setText(a.getNomActividad());
                    txtDescripcion.setText(a.getDescripcion());
                    txtFecha.setText(a.getFecha());
                    txtUbicacion.setText(a.getUbicacion());
                    
                    // Seleccionar Fundación en Combo
                    if (a.getOrganizador() != null) {
                        cnbFundacion.setSelectedItem(a.getOrganizador().getNombre());
                    }
                    
                    // Seleccionar Cupo
                    jComboBox1.setSelectedItem(String.valueOf(a.getCupoMaximo()));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
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
        java.awt.EventQueue.invokeLater(() -> new JActividad().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnActualizar1;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnAgregar1;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnEliminar1;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnLimpiar1;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JButton btnRegresar1;
    private javax.swing.JComboBox<String> cnbFundacion;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField txtActividad;
    private javax.swing.JTextField txtDescripcion;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtUbicacion;
    // End of variables declaration//GEN-END:variables
}
