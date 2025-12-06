package medibuddy.interfaces;

import medibuddy.model.Actividad;
import medibuddy.model.AdultoMayor;
import medibuddy.service.ActividadService;
import medibuddy.service.AdultoMayorService;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class JInscripciones extends javax.swing.JFrame {

    // Servicios
    private final AdultoMayorService adultoService = new AdultoMayorService();
    private final ActividadService actividadService = new ActividadService();
    
    // Listas auxiliares para manejar los IDs
    private List<AdultoMayor> listaAdultos;
    private List<Actividad> listaActividades;

    public JInscripciones() {
        initComponents();
        cargarComboAdultos();
        cargarTablaActividades();
        setLocationRelativeTo(null); // Centrar
    }

    private void cargarComboAdultos() {
        try {
            listaAdultos = adultoService.listarAdultosMayores();
            DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
            model.addElement("--- Seleccione Adulto Mayor ---");
            
            for (AdultoMayor am : listaAdultos) {
                // Mostramos Nombre + Apellido para distinguir
                String nombre = am.getNomUsuario() + " " + 
                                (am.getApellidoPaterno() != null ? am.getApellidoPaterno() : "");
                model.addElement(nombre);
            }
            cnbAdultos.setModel(model);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void cargarTablaActividades() {
        DefaultTableModel model = (DefaultTableModel) jTableActividades.getModel();
        model.setRowCount(0);
        
        try {
            listaActividades = actividadService.listarActividades();
            for (Actividad a : listaActividades) {
                String organizador = (a.getOrganizador() != null) ? a.getOrganizador().getNombre() : "N/A";
                
                // Calculamos cupo disponible (visual)
                int inscritos = (a.getParticipantes() != null) ? a.getParticipantes().size() : 0;
                String cupoInfo = inscritos + " / " + a.getCupoMaximo();

                model.addRow(new Object[]{
                    a.getIdActividad(),
                    a.getNomActividad(),
                    a.getFecha(),
                    a.getUbicacion(),
                    organizador,
                    cupoInfo
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btnRegresar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        cnbAdultos = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableActividades = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        btnInscribir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel1.setText("Inscripción a Actividades");

        btnRegresar.setText("Regresar");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Paso 1: Seleccionar Participante"));

        jLabel2.setText("Adulto Mayor:");

        cnbAdultos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(cnbAdultos, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cnbAdultos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Paso 2: Seleccionar Actividad de la Lista"));

        jTableActividades.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Actividad", "Fecha", "Ubicación", "Organizador", "Cupo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTableActividades);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setText("* Haga clic en una fila para seleccionarla");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 550, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
                .addContainerGap())
        );

        btnInscribir.setBackground(new java.awt.Color(111, 207, 123));
        btnInscribir.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnInscribir.setForeground(new java.awt.Color(255, 255, 255));
        btnInscribir.setText("CONFIRMAR INSCRIPCIÓN");
        btnInscribir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInscribirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnRegresar)
                        .addGap(116, 116, 116)
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(196, 196, 196)
                .addComponent(btnInscribir, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(btnRegresar))
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnInscribir, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnInscribirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInscribirActionPerformed
        // 1. Validaciones Visuales
        int idxAdulto = cnbAdultos.getSelectedIndex();
        int fila = jTableActividades.getSelectedRow();

        if (idxAdulto <= 0) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un Adulto Mayor de la lista.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (fila < 0) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar una Actividad de la tabla.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // 2. Bloque TRY-CATCH para la Lógica de Negocio
        try {
            // A. Obtener el Adulto seleccionado (Restamos 1 por el encabezado del combo)
            AdultoMayor adulto = listaAdultos.get(idxAdulto - 1);
            
            // B. Obtener el ID de la Actividad seleccionada (Columna 0 de la tabla)
            int idActividad = (int) jTableActividades.getValueAt(fila, 0);

            // C. LLAMAR AL SERVICIO (Aquí es donde salta el error si ya está inscrito o lleno)
            adultoService.inscribirEnActividad(adulto.getIdUsuario(), idActividad);
            
            // D. Mensaje de Éxito (solo llega aquí si no hubo error)
            JOptionPane.showMessageDialog(this, 
                "✅ ¡Inscripción exitosa!\n" + adulto.getNomUsuario() + " asistirá a la actividad.", 
                "Éxito", JOptionPane.INFORMATION_MESSAGE);
            
            // E. Refrescar tabla para ver actualizado el contador de cupo
            cargarTablaActividades(); 

        } catch (Exception e) {
            // Si el servicio dice "Ya está inscrito", e.getMessage() tendrá ese texto.
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error de Inscripción", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnInscribirActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        this.dispose();
        try {
            // Reemplaza con tu menú real
            // new medibuddy.interfaces.JMenuPrincipal().setVisible(true);
            new medibuddy.interfaces.JActividad().setVisible(true); // O volver a actividades
        } catch (Exception e) {}
    }//GEN-LAST:event_btnRegresarActionPerformed

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) {}
        
        java.awt.EventQueue.invokeLater(() -> new JInscripciones().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnInscribir;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JComboBox<String> cnbAdultos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableActividades;
    // End of variables declaration//GEN-END:variables
}