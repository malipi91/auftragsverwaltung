/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

/*----------------------------------------------------------*/
 /* Datum Name Was */
 /* 17.11.16 Yoeruek Erstellung*/
 /* 24.11.16 Yoeruek Aufsplittung der StartAv Klasse in einzelne Klassen, da Code für eine Klasse zu lang. */
 /* 27.11.16 Yoeruek Anpassung der Größenverhältnisse (Schriftart, Layout)*/
 /*----------------------------------------------------------*/
public class ZKID_suchen extends javax.swing.JInternalFrame {

    /**
     * Creates new form ZKID_suchen
     */
    public ZKID_suchen() {
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

        ZKID_suchen = new javax.swing.JPanel();
        jLabel80 = new javax.swing.JLabel();
        jSeparator27 = new javax.swing.JSeparator();
        jbAbbrechen_ZKIDSuchen = new javax.swing.JButton();
        jbAnzeigen_ZKIDSuchen = new javax.swing.JButton();
        jLabel126 = new javax.swing.JLabel();
        jLabel127 = new javax.swing.JLabel();
        jtfLieferzeitSofort_ZKIDSuchen = new javax.swing.JTextField();
        jtfLieferzeitWunsch_ZKIDSuchen = new javax.swing.JTextField();
        jLabel128 = new javax.swing.JLabel();
        jLabel129 = new javax.swing.JLabel();
        jtfSkontozeit1_ZKIDSuchen = new javax.swing.JTextField();
        jtfMahnzeit1_ZKIDSuchen = new javax.swing.JTextField();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);

        ZKID_suchen.setPreferredSize(new java.awt.Dimension(1200, 800));

        jLabel80.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel80.setText("Zahlungskondition-ID Suchen");

        jbAbbrechen_ZKIDSuchen.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jbAbbrechen_ZKIDSuchen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/abbruch2.png"))); // NOI18N
        jbAbbrechen_ZKIDSuchen.setText("Abbrechen");
        jbAbbrechen_ZKIDSuchen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAbbrechen_ZKIDSuchenActionPerformed(evt);
            }
        });

        jbAnzeigen_ZKIDSuchen.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jbAnzeigen_ZKIDSuchen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/anzeigen.png"))); // NOI18N
        jbAnzeigen_ZKIDSuchen.setText("Anzeigen");
        jbAnzeigen_ZKIDSuchen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAnzeigen_ZKIDSuchenActionPerformed(evt);
            }
        });

        jLabel126.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel126.setText("Lieferzeit-Sofort:");

        jLabel127.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel127.setText("Lieferzeit-Wunsch:");

        jtfLieferzeitSofort_ZKIDSuchen.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jtfLieferzeitWunsch_ZKIDSuchen.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel128.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel128.setText("Skontozeit 1:");

        jLabel129.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel129.setText("Mahnzeit:");

        jtfSkontozeit1_ZKIDSuchen.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jtfMahnzeit1_ZKIDSuchen.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        javax.swing.GroupLayout ZKID_suchenLayout = new javax.swing.GroupLayout(ZKID_suchen);
        ZKID_suchen.setLayout(ZKID_suchenLayout);
        ZKID_suchenLayout.setHorizontalGroup(
            ZKID_suchenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator27)
            .addGroup(ZKID_suchenLayout.createSequentialGroup()
                .addGroup(ZKID_suchenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ZKID_suchenLayout.createSequentialGroup()
                        .addGap(79, 79, 79)
                        .addGroup(ZKID_suchenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(ZKID_suchenLayout.createSequentialGroup()
                                .addGroup(ZKID_suchenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel126)
                                    .addComponent(jLabel127))
                                .addGap(28, 28, 28)
                                .addGroup(ZKID_suchenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jtfLieferzeitSofort_ZKIDSuchen, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jtfLieferzeitWunsch_ZKIDSuchen, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(99, 99, 99)
                                .addGroup(ZKID_suchenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel128)
                                    .addComponent(jLabel129))
                                .addGap(31, 31, 31)
                                .addGroup(ZKID_suchenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jtfSkontozeit1_ZKIDSuchen, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jtfMahnzeit1_ZKIDSuchen, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(ZKID_suchenLayout.createSequentialGroup()
                                .addComponent(jbAnzeigen_ZKIDSuchen, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jbAbbrechen_ZKIDSuchen, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(1, 1, 1))))
                    .addGroup(ZKID_suchenLayout.createSequentialGroup()
                        .addGap(223, 223, 223)
                        .addComponent(jLabel80)))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        ZKID_suchenLayout.setVerticalGroup(
            ZKID_suchenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ZKID_suchenLayout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jLabel80)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator27, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(ZKID_suchenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel126)
                    .addComponent(jtfLieferzeitSofort_ZKIDSuchen, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel128)
                    .addComponent(jtfSkontozeit1_ZKIDSuchen, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(ZKID_suchenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel127)
                    .addComponent(jtfLieferzeitWunsch_ZKIDSuchen, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel129)
                    .addComponent(jtfMahnzeit1_ZKIDSuchen, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(ZKID_suchenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbAnzeigen_ZKIDSuchen, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbAbbrechen_ZKIDSuchen, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(191, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 800, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(ZKID_suchen, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(ZKID_suchen, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbAbbrechen_ZKIDSuchenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAbbrechen_ZKIDSuchenActionPerformed
        /*----------------------------------------------------------*/
 /* 24.11.16 Yoeruek Schließt das Fenster nach Betätigung des Abbrech Buttons */
 /*----------------------------------------------------------*/
        this.setVisible(false);
    }//GEN-LAST:event_jbAbbrechen_ZKIDSuchenActionPerformed

    private void jbAnzeigen_ZKIDSuchenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAnzeigen_ZKIDSuchenActionPerformed

    }//GEN-LAST:event_jbAnzeigen_ZKIDSuchenActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ZKID_suchen;
    private javax.swing.JLabel jLabel126;
    private javax.swing.JLabel jLabel127;
    private javax.swing.JLabel jLabel128;
    private javax.swing.JLabel jLabel129;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JSeparator jSeparator27;
    private javax.swing.JButton jbAbbrechen_ZKIDSuchen;
    private javax.swing.JButton jbAnzeigen_ZKIDSuchen;
    private javax.swing.JTextField jtfLieferzeitSofort_ZKIDSuchen;
    private javax.swing.JTextField jtfLieferzeitWunsch_ZKIDSuchen;
    private javax.swing.JTextField jtfMahnzeit1_ZKIDSuchen;
    private javax.swing.JTextField jtfSkontozeit1_ZKIDSuchen;
    // End of variables declaration//GEN-END:variables
}
