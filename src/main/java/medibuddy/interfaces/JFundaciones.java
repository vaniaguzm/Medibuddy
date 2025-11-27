
package medibuddy.interfaces;

import medibuddy.model.AdultoMayor;
import medibuddy.model.Fundacion; 
import medibuddy.service.AdultoMayorService;
import medibuddy.service.FundacionService;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import java.util.logging.Level;


public class JFundaciones extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(JFundaciones.class.getName());
    private final AdultoMayorService adultoService = new AdultoMayorService();
    private final FundacionService fundacionService = new FundacionService();
    
    private List<AdultoMayor> listaAdultos;
    private List<Fundacion> listaFundaciones;
    
    public JFundaciones() {
        initComponents();
        cargarTablaFundaciones();
        inicializarDatosTabla(); 
        cargarComboAdultos();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        btnAsignar = new javax.swing.JButton();
        btnQuitar = new javax.swing.JButton();
        btnRegresar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        cnbAdulto = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel4.setText("Adulto:");

        btnAsignar.setBackground(new java.awt.Color(111, 207, 123));
        btnAsignar.setForeground(new java.awt.Color(255, 255, 255));
        btnAsignar.setText("Asignar Actividad");
        btnAsignar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAsignarActionPerformed(evt);
            }
        });

        btnQuitar.setBackground(new java.awt.Color(255, 0, 0));
        btnQuitar.setForeground(new java.awt.Color(255, 255, 255));
        btnQuitar.setText("Quitar de la Actividad");
        btnQuitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuitarActionPerformed(evt);
            }
        });

        btnRegresar.setText("Regresar");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel1.setText("Gestion Fundaciones");

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnAsignar)
                                .addGap(64, 64, 64)
                                .addComponent(btnQuitar))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cnbAdulto, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 422, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnRegresar)
                                .addGap(62, 62, 62)
                                .addComponent(jLabel1)))))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(btnRegresar))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cnbAdulto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAsignar, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
                    .addComponent(btnQuitar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAsignarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAsignarActionPerformed
       int indexAdulto = cnbAdulto.getSelectedIndex();
        int filaTabla = jTable1.getSelectedRow();
        
        // Validaciones visuales
        if (indexAdulto <= 0) {
            JOptionPane.showMessageDialog(this, "Seleccione un Adulto Mayor.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (filaTabla < 0) {
            JOptionPane.showMessageDialog(this, "Seleccione una Actividad de la tabla.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            // Obtener objetos reales
            AdultoMayor adulto = listaAdultos.get(indexAdulto - 1);
            
            // Obtener objeto de la lista paralela
            Fundacion fundacion = listaFundaciones.get(filaTabla); 

            
            // Llamar al servicio para crear la relación
            // Esto asume que tienes un método para vincularlos en FundacionService o AdultoMayorService
            fundacionService.inscribirAdultoEnActividad(adulto, fundacion);
            
            JOptionPane.showMessageDialog(this, 
                "¡Éxito! " + adulto.getNomUsuario() + " asignado a " + fundacion.getActividad());
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al asignar: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            logger.log(Level.SEVERE, "Fallo asignación", e);
        }
    }//GEN-LAST:event_btnAsignarActionPerformed

    private void btnQuitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitarActionPerformed
        int indexAdulto = cnbAdulto.getSelectedIndex();
        int filaTabla = jTable1.getSelectedRow();
        
        if (indexAdulto <= 0 || filaTabla < 0) {
            JOptionPane.showMessageDialog(this, "Seleccione Adulto y Actividad para desvincular.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            AdultoMayor adulto = listaAdultos.get(indexAdulto - 1);
            Fundacion fundacion = listaFundaciones.get(filaTabla);
            
            // Llamar al servicio para eliminar la relación
            fundacionService.removerAdultoDeActividad(adulto, fundacion);
            
            JOptionPane.showMessageDialog(this, "Se quitó la asignación correctamente.");
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al quitar: " + e.getMessage());
        }
    }//GEN-LAST:event_btnQuitarActionPerformed

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

    private void cargarComboAdultos() {
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
        try {
            listaAdultos = adultoService.listarAdultosMayores();
            model.addElement("--- Seleccione Adulto ---");
            for (AdultoMayor am : listaAdultos) {
                model.addElement(am.getNomUsuario() + " (ID: " + am.getIdUsuario() + ")");
            }
            cnbAdulto.setModel(model);
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error al cargar adultos", e);
        }
    }
    
    private void inicializarDatosTabla() {
        List<Fundacion> existentes = fundacionService.listarFundaciones();
        
            try {
                fundacionService.crearFundacion(new Fundacion("Fundación Vida", "Yoga", "Av. Vallarta 2440"));
                fundacionService.crearFundacion(new Fundacion("Abuelos Felices", "Bingo", "C. Morelos 450, Centro"));
                fundacionService.crearFundacion(new Fundacion("Corazones Unidos", "Baile", "Av. Chapultepec Sur 15"));
                fundacionService.crearFundacion(new Fundacion("Mano Amiga", "Pintura", "Calz. Independencia Nte 800"));
                fundacionService.crearFundacion(new Fundacion("Tercera Juventud", "Caminata", "Parque Metropolitano"));
                fundacionService.crearFundacion(new Fundacion("Luz de Esperanza", "Tejido", "Av. Américas 1500"));
                fundacionService.crearFundacion(new Fundacion("Sendero Dorado", "Canto", "Calle 5 de Febrero 300"));
                fundacionService.crearFundacion(new Fundacion("Vitalidad", "Gimnasia", "Av. Patria 900"));
                fundacionService.crearFundacion(new Fundacion("Amor Mayor", "Lectura", "Biblioteca Publica Central"));
                fundacionService.crearFundacion(new Fundacion("Raíces", "Cocina", "Mercado de Abastos Local 4"));
            } catch (Exception e) {
                logger.log(Level.SEVERE, "Error al crear datos de prueba", e);
            }
        
    }

    private void cargarTablaFundaciones() {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
        
        try {
            // Traemos las fundacionesde la base de datos
            listaFundaciones = fundacionService.listarFundaciones();
            
            for (Fundacion f : listaFundaciones) {
                
                model.addRow(new Object[]{
                    f.getId(),          // Columna  ID oculto o visible
                    f.getNombre(),      // Columna Nombre Fundación
                    f.getActividad(),   // Columna  Actividad (ej. Bingo)
                    f.getDireccion()// Columna  Direccion
                });
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al cargar tabla.", "Error", JOptionPane.ERROR_MESSAGE);
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
        java.awt.EventQueue.invokeLater(() -> new JFundaciones().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAsignar;
    private javax.swing.JButton btnQuitar;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JComboBox<String> cnbAdulto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
