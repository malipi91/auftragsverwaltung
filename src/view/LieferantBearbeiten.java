/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

/*----------------------------------------------------------*/
/* Datum Name Was */
/* 24.11.16 Yoeruek Aufsplittung der StartAv Klasse in einzelne Klassen, da Code für eine Klasse zu lang. */
/* 27.11.16 Yoeruek Anpassung der Größenverhältnisse (Schriftart, Layout)*/
/*----------------------------------------------------------*/
public class LieferantBearbeiten extends javax.swing.JInternalFrame {

    /**
     * Creates new form LieferantBearbeiten
     */
    public LieferantBearbeiten() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LieferantBearbeiten = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jbzurueck_LieferantBearbeiten = new javax.swing.JButton();
        jSeparator18 = new javax.swing.JSeparator();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);

        LieferantBearbeiten.setPreferredSize(new java.awt.Dimension(1200, 900));

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel12.setText("Lieferant Bearbeiten");

        jbzurueck_LieferantBearbeiten.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jbzurueck_LieferantBearbeiten.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/zurück.png"))); // NOI18N
        jbzurueck_LieferantBearbeiten.setText("Zurück");
        jbzurueck_LieferantBearbeiten.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbzurueck_LieferantBearbeitenActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout LieferantBearbeitenLayout = new javax.swing.GroupLayout(LieferantBearbeiten);
        LieferantBearbeiten.setLayout(LieferantBearbeitenLayout);
        LieferantBearbeitenLayout.setHorizontalGroup(
            LieferantBearbeitenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LieferantBearbeitenLayout.createSequentialGroup()
                .addGroup(LieferantBearbeitenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(LieferantBearbeitenLayout.createSequentialGroup()
                        .addGroup(LieferantBearbeitenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(LieferantBearbeitenLayout.createSequentialGroup()
                                .addGap(356, 356, 356)
                                .addComponent(jbzurueck_LieferantBearbeiten, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(LieferantBearbeitenLayout.createSequentialGroup()
                                .addGap(346, 346, 346)
                                .addComponent(jLabel12)))
                        .addGap(0, 435, Short.MAX_VALUE))
                    .addComponent(jSeparator18, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        LieferantBearbeitenLayout.setVerticalGroup(
            LieferantBearbeitenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LieferantBearbeitenLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel12)
                .addGap(15, 15, 15)
                .addComponent(jSeparator18, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(165, 165, 165)
                .addComponent(jbzurueck_LieferantBearbeiten, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(539, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 951, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(LieferantBearbeiten, javax.swing.GroupLayout.PREFERRED_SIZE, 950, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 1, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 800, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(LieferantBearbeiten, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbzurueck_LieferantBearbeitenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbzurueck_LieferantBearbeitenActionPerformed
        /*----------------------------------------------------------*/
        /* Datum Name Was */
        /* 24.11.16 Yoeruek Schließt das Fenster nach Betätigung des Abbrech Buttons */
        /*----------------------------------------------------------*/
        this.setVisible(false);
    }//GEN-LAST:event_jbzurueck_LieferantBearbeitenActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel LieferantBearbeiten;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JSeparator jSeparator18;
    private javax.swing.JButton jbzurueck_LieferantBearbeiten;
    // End of variables declaration//GEN-END:variables
}
