package medibuddy.interfaces;





public class JMenuPrincipal extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(JMenuPrincipal.class.getName());


    public JMenuPrincipal() {
        initComponents();
        setLocationRelativeTo(null);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JTitulo = new javax.swing.JLabel();
        btnAdultosMayores = new javax.swing.JButton();
        btnCentros = new javax.swing.JButton();
        btnFamiliares = new javax.swing.JButton();
        btnFundaciones = new javax.swing.JButton();
        btnMedicamentos = new javax.swing.JButton();
        btnActividad = new javax.swing.JButton();
        btnInscripciones = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        JTitulo.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        JTitulo.setText("MediBuddy");

        btnAdultosMayores.setText("Adultos Mayores");
        btnAdultosMayores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdultosMayoresActionPerformed(evt);
            }
        });

        btnCentros.setText("Centros de Acopio");
        btnCentros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCentrosActionPerformed(evt);
            }
        });

        btnFamiliares.setText("Familiares");
        btnFamiliares.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFamiliaresActionPerformed(evt);
            }
        });

        btnFundaciones.setText("Fundaciones");
        btnFundaciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFundacionesActionPerformed(evt);
            }
        });

        btnMedicamentos.setText("Medicamentos");
        btnMedicamentos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMedicamentosActionPerformed(evt);
            }
        });

        btnActividad.setText("Actividad");
        btnActividad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActividadActionPerformed(evt);
            }
        });

        btnInscripciones.setText("Inscripciones");
        btnInscripciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInscripcionesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(137, 137, 137)
                        .addComponent(JTitulo))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnActividad, javax.swing.GroupLayout.DEFAULT_SIZE, 306, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(btnFundaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnCentros, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnAdultosMayores, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnMedicamentos, javax.swing.GroupLayout.DEFAULT_SIZE, 306, Short.MAX_VALUE)
                            .addComponent(btnFamiliares, javax.swing.GroupLayout.DEFAULT_SIZE, 306, Short.MAX_VALUE)
                            .addComponent(btnInscripciones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(54, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(JTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAdultosMayores, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCentros, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnFundaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnFamiliares, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnMedicamentos, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnActividad, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnInscripciones, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAdultosMayoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdultosMayoresActionPerformed
        JAdultosMayores ventana = new JAdultosMayores();
        ventana.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnAdultosMayoresActionPerformed

    private void btnCentrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCentrosActionPerformed
        JCentrosAcopio ventana = new JCentrosAcopio();
        ventana.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnCentrosActionPerformed

    private void btnFamiliaresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFamiliaresActionPerformed
        JFamiliares ventana = new JFamiliares();
        ventana.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnFamiliaresActionPerformed

    private void btnFundacionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFundacionesActionPerformed
        JFundaciones ventana = new JFundaciones();
        ventana.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnFundacionesActionPerformed

    private void btnMedicamentosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMedicamentosActionPerformed
        JMedicamentos ventana = new JMedicamentos();
        ventana.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnMedicamentosActionPerformed

    private void btnActividadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActividadActionPerformed
        JActividad ventana = new JActividad();
        ventana.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnActividadActionPerformed

    private void btnInscripcionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInscripcionesActionPerformed
        JInscripciones ventana = new JInscripciones();
        ventana.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnInscripcionesActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(() -> {
            new JMenuPrincipal().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel JTitulo;
    private javax.swing.JButton btnActividad;
    private javax.swing.JButton btnAdultosMayores;
    private javax.swing.JButton btnCentros;
    private javax.swing.JButton btnFamiliares;
    private javax.swing.JButton btnFundaciones;
    private javax.swing.JButton btnInscripciones;
    private javax.swing.JButton btnMedicamentos;
    // End of variables declaration//GEN-END:variables
}
