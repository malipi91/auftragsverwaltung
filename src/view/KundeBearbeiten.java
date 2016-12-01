/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

/*--------------------------------------------------------------------------*/
/* Datum    Name    Was                                                     */
/* 24.11.16 Yoeruek Aufsplittung der StartAv Klasse in einzelne Klassen,    */
/*                  da Code für eine Klasse zu lang.                        */
/* 27.11.16 Yoeruek Anpassung der Größenverhältnisse (Schriftart, Layout)   */
/*--------------------------------------------------------------------------*/
public class KundeBearbeiten extends javax.swing.JInternalFrame {

    /**
     * Creates new form KundeBearbeiten
     */
    public KundeBearbeiten() {
        initComponents();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        KundeBearbeiten = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        zurueck_KundeBearbeiten = new javax.swing.JButton();
        jSeparator21 = new javax.swing.JSeparator();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);

        KundeBearbeiten.setPreferredSize(new java.awt.Dimension(1200, 900));

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel15.setText("Kunde bearbeiten");

        zurueck_KundeBearbeiten.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        zurueck_KundeBearbeiten.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/zurück.png"))); // NOI18N
        zurueck_KundeBearbeiten.setText("Zurück");
        zurueck_KundeBearbeiten.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                zurueck_KundeBearbeitenActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout KundeBearbeitenLayout = new javax.swing.GroupLayout(KundeBearbeiten);
        KundeBearbeiten.setLayout(KundeBearbeitenLayout);
        KundeBearbeitenLayout.setHorizontalGroup(
            KundeBearbeitenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(KundeBearbeitenLayout.createSequentialGroup()
                .addGroup(KundeBearbeitenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(KundeBearbeitenLayout.createSequentialGroup()
                        .addGroup(KundeBearbeitenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(KundeBearbeitenLayout.createSequentialGroup()
                                .addGap(275, 275, 275)
                                .addComponent(zurueck_KundeBearbeiten, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(KundeBearbeitenLayout.createSequentialGroup()
                                .addGap(283, 283, 283)
                                .addComponent(jLabel15)))
                        .addGap(0, 468, Short.MAX_VALUE))
                    .addComponent(jSeparator21, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        KundeBearbeitenLayout.setVerticalGroup(
            KundeBearbeitenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(KundeBearbeitenLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel15)
                .addGap(12, 12, 12)
                .addComponent(jSeparator21, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(179, 179, 179)
                .addComponent(zurueck_KundeBearbeiten, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(527, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(KundeBearbeiten, javax.swing.GroupLayout.PREFERRED_SIZE, 950, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(KundeBearbeiten, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void zurueck_KundeBearbeitenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_zurueck_KundeBearbeitenActionPerformed
    /*----------------------------------------------------------*/
    /* 24.11.16 Yoeruek Schließt das Fenster nach Betätigung des Abbrech Buttons */
    /*----------------------------------------------------------*/
        this.setVisible(false);
    }//GEN-LAST:event_zurueck_KundeBearbeitenActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel KundeBearbeiten;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JSeparator jSeparator21;
    private javax.swing.JButton zurueck_KundeBearbeiten;
    // End of variables declaration//GEN-END:variables
}
