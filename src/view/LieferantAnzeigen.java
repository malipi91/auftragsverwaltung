/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

/**
 *
 * @author Hicran Yoeruek
 */
public class LieferantAnzeigen extends javax.swing.JInternalFrame {

    /**
     * Creates new form LieferantAnzeigen
     */
    public LieferantAnzeigen() {
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

        LieferantAnzeigen = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jbzurueck_LieferantAnzeigen = new javax.swing.JButton();
        jSeparator16 = new javax.swing.JSeparator();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);

        LieferantAnzeigen.setPreferredSize(new java.awt.Dimension(1200, 800));

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel10.setText("Lieferant anzeigen");

        jbzurueck_LieferantAnzeigen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/zurück.png"))); // NOI18N
        jbzurueck_LieferantAnzeigen.setText("Zurück");
        jbzurueck_LieferantAnzeigen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbzurueck_LieferantAnzeigenActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout LieferantAnzeigenLayout = new javax.swing.GroupLayout(LieferantAnzeigen);
        LieferantAnzeigen.setLayout(LieferantAnzeigenLayout);
        LieferantAnzeigenLayout.setHorizontalGroup(
            LieferantAnzeigenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LieferantAnzeigenLayout.createSequentialGroup()
                .addGroup(LieferantAnzeigenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(LieferantAnzeigenLayout.createSequentialGroup()
                        .addGap(246, 246, 246)
                        .addComponent(jbzurueck_LieferantAnzeigen))
                    .addGroup(LieferantAnzeigenLayout.createSequentialGroup()
                        .addGap(297, 297, 297)
                        .addComponent(jLabel10))
                    .addComponent(jSeparator16, javax.swing.GroupLayout.PREFERRED_SIZE, 943, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(74, Short.MAX_VALUE))
        );
        LieferantAnzeigenLayout.setVerticalGroup(
            LieferantAnzeigenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LieferantAnzeigenLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel10)
                .addGap(9, 9, 9)
                .addComponent(jSeparator16, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(157, 157, 157)
                .addComponent(jbzurueck_LieferantAnzeigen)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1041, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(LieferantAnzeigen, javax.swing.GroupLayout.PREFERRED_SIZE, 1017, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 278, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(10, 10, 10)
                    .addComponent(LieferantAnzeigen, javax.swing.GroupLayout.DEFAULT_SIZE, 257, Short.MAX_VALUE)
                    .addGap(11, 11, 11)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbzurueck_LieferantAnzeigenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbzurueck_LieferantAnzeigenActionPerformed
        // Hicran Yoeruek
        // Schließt das Fenster nach Betätigung des Abbrech Buttons komplett.
        this.setVisible(false);
    }//GEN-LAST:event_jbzurueck_LieferantAnzeigenActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel LieferantAnzeigen;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JSeparator jSeparator16;
    private javax.swing.JButton jbzurueck_LieferantAnzeigen;
    // End of variables declaration//GEN-END:variables
}