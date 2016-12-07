/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javax.swing.JOptionPane;

/*--------------------------------------------------------------------------------------------------------*/
/* Datum    Name    Was                                                                                   */
/* 14.11.16 Yoeruek Erstellung                                                                            */
/* 24.11.16 Yoeruek Aufsplittung der StartAv Klasse in einzelne Klassen, da Code für eine Klasse zu lang. */
/* 27.11.16 Yoeruek Anpassung der Größenverhältnisse (Schriftart, Layout)                                 */
/* 28.11.16 Yoeruek Korrektur der gesetzten Felder                                                        */
/* 05.12.16 Yoeruek Klasse neu strukturiert                                                               */
/*--------------------------------------------------------------------------------------------------------*/
public class AuftragsID_suchen extends javax.swing.JInternalFrame {


    public AuftragsID_suchen() {
        initComponents();
    }

  /*-------------------------------------------------------------*/
    /* 01.12.16 Yoeruek Prüfung nach Pflichtfeldern, falls nichts  */ 
    /*            angegeben ist wird eine Fehlermeldung ausgegeben */
    /*-------------------------------------------------------------*/
    public boolean istVollstaendig(){
        Boolean vollstaendig = false;
        String fehlermeldung = "";
        if(jcbDatumAuftragsIDSuchen.getSelectedIndex() == 0){
            fehlermeldung = "Bitte wählen Sie ein Suchkriterium für das Datum aus!";
            jcbDatumAuftragsIDSuchen.requestFocusInWindow();
        } else if (jtfDatum_AuftragsIDSuchen.getText().equals("")){
            fehlermeldung = "Bitte geben Sie ein Datum ein!";
            jtfDatum_AuftragsIDSuchen.requestFocusInWindow();
        } else if (jcbGP_AuftragsIDSuchen.getSelectedIndex() == 0){
            fehlermeldung = "Bitte wählen Sie ein Suchkriterium für einen Geschäftspartner aus!";
            jcbGP_AuftragsIDSuchen.requestFocusInWindow();
        } else if (jtfGP_AuftragsIDSuchen.getText().equals("")){
            fehlermeldung = "Bitte füllen Sie das Eingabefeld aus!";
            jtfGP_AuftragsIDSuchen.requestFocusInWindow();
        } else if (jcbStatus_AuftragsIDSuchen.getSelectedIndex() == 0){
            fehlermeldung = "Bitte geben Sie einen Status ein!";
            jcbStatus_AuftragsIDSuchen.requestFocusInWindow();
        } 
        if(fehlermeldung.equals("")){
            vollstaendig = true;
        }else{
            JOptionPane.showMessageDialog(this, fehlermeldung,"Unvollständig" ,JOptionPane.WARNING_MESSAGE);
        }return vollstaendig;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jcbGP_AuftragsIDSuchen = new javax.swing.JComboBox<>();
        jtfGP_AuftragsIDSuchen = new javax.swing.JTextField();
        jcbDatumAuftragsIDSuchen = new javax.swing.JComboBox<>();
        jtfDatum_AuftragsIDSuchen = new javax.swing.JTextField();
        jcbStatus_AuftragsIDSuchen = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jbSuchen_AuftragsIDSuchen = new javax.swing.JButton();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(450, 450));
        setNormalBounds(new java.awt.Rectangle(0, 0, 0, 0));
        setPreferredSize(new java.awt.Dimension(450, 300));

        jPanel1.setPreferredSize(new java.awt.Dimension(300, 450));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Auftrags-ID Suchen");

        jcbGP_AuftragsIDSuchen.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jcbGP_AuftragsIDSuchen.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Geschäftspartner Name", "Geschäftspartner ID" }));

        jtfGP_AuftragsIDSuchen.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jcbDatumAuftragsIDSuchen.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jcbDatumAuftragsIDSuchen.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Erfassungsdatum", "Lieferdatum", "Abschlussdatum" }));

        jtfDatum_AuftragsIDSuchen.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jcbStatus_AuftragsIDSuchen.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jcbStatus_AuftragsIDSuchen.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "erfasst", "freigegeben", "abgeschlossen", "" }));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel2.setText("Status:");

        jbSuchen_AuftragsIDSuchen.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jbSuchen_AuftragsIDSuchen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/lupe.png"))); // NOI18N
        jbSuchen_AuftragsIDSuchen.setText("Suchen");
        jbSuchen_AuftragsIDSuchen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSuchen_AuftragsIDSuchenActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(109, 109, 109)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jbSuchen_AuftragsIDSuchen)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jcbDatumAuftragsIDSuchen, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jcbGP_AuftragsIDSuchen, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(jLabel2))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jcbStatus_AuftragsIDSuchen, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jtfGP_AuftragsIDSuchen, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jtfDatum_AuftragsIDSuchen, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(50, Short.MAX_VALUE))
            .addComponent(jSeparator1)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcbGP_AuftragsIDSuchen, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfGP_AuftragsIDSuchen, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcbDatumAuftragsIDSuchen, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfDatum_AuftragsIDSuchen, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcbStatus_AuftragsIDSuchen, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addComponent(jbSuchen_AuftragsIDSuchen)
                .addContainerGap(73, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbSuchen_AuftragsIDSuchenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSuchen_AuftragsIDSuchenActionPerformed
        if(istVollstaendig()){
            this.setVisible(false);
        }   
    }//GEN-LAST:event_jbSuchen_AuftragsIDSuchenActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton jbSuchen_AuftragsIDSuchen;
    private javax.swing.JComboBox<String> jcbDatumAuftragsIDSuchen;
    private javax.swing.JComboBox<String> jcbGP_AuftragsIDSuchen;
    private javax.swing.JComboBox<String> jcbStatus_AuftragsIDSuchen;
    private javax.swing.JTextField jtfDatum_AuftragsIDSuchen;
    private javax.swing.JTextField jtfGP_AuftragsIDSuchen;
    // End of variables declaration//GEN-END:variables
}
