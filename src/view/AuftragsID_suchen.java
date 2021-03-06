/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javax.swing.JOptionPane;

/*----------------------------------------------------------*/
/* Datum    Name    Was */
/* 14.11.16 Yoeruek Erstellung*/
/* 24.11.16 Yoeruek Aufsplittung der StartAv Klasse in einzelne Klassen, da Code für eine Klasse zu lang. */
/* 27.11.16 Yoeruek Anpassung der Größenverhältnisse (Schriftart, Layout)*/
/* 28.11.16 Yoeruek Korrektur der gesetzten Felder*/
/*----------------------------------------------------------*/
public class AuftragsID_suchen extends javax.swing.JInternalFrame {

    public AuftragsID_suchen(StartAV parent) {
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
        } else if (jcbStatus_AuftragsIDSuchen.getSelectedIndex() == 0){
            fehlermeldung = "Bitte geben Sie den Status ein!";
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

        AuftragsID_suchen = new javax.swing.JPanel();
        jLabel88 = new javax.swing.JLabel();
        jSeparator23 = new javax.swing.JSeparator();
        jcbDatumAuftragsIDSuchen = new javax.swing.JComboBox<>();
        jtfDatum_AuftragsIDSuchen = new javax.swing.JTextField();
        jLabel91 = new javax.swing.JLabel();
        jcbStatus_AuftragsIDSuchen = new javax.swing.JComboBox<>();
        jbUebernehmen_AuftragsIDSuchen = new javax.swing.JButton();
        jbSuchen_AuftragsIDSuchen = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jtfGPName_AuftragsIDSuchen = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jT_AuftragsIDSuchen = new javax.swing.JTable();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setMaximizable(true);

        AuftragsID_suchen.setName(""); // NOI18N
        AuftragsID_suchen.setPreferredSize(new java.awt.Dimension(1200, 800));

        jLabel88.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel88.setText("Auftrags-ID suchen");

        jcbDatumAuftragsIDSuchen.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jcbDatumAuftragsIDSuchen.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Erfassungsdatum", "Lieferdatum", "Abschlussdatum" }));
        jcbDatumAuftragsIDSuchen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbDatumAuftragsIDSuchenActionPerformed(evt);
            }
        });

        jLabel91.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel91.setText("Status:");

        jcbStatus_AuftragsIDSuchen.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jcbStatus_AuftragsIDSuchen.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "erfasst", "freigegeben", "abgeschlossen", "" }));

        jbUebernehmen_AuftragsIDSuchen.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jbUebernehmen_AuftragsIDSuchen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/speichern2.png"))); // NOI18N
        jbUebernehmen_AuftragsIDSuchen.setText("Übernehmen");
        jbUebernehmen_AuftragsIDSuchen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbUebernehmen_AuftragsIDSuchenActionPerformed(evt);
            }
        });

        jbSuchen_AuftragsIDSuchen.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jbSuchen_AuftragsIDSuchen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/lupe.png"))); // NOI18N
        jbSuchen_AuftragsIDSuchen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSuchen_AuftragsIDSuchenActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel1.setText("Gerschäftspartner-Name:");

        jtfGPName_AuftragsIDSuchen.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jT_AuftragsIDSuchen.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jT_AuftragsIDSuchen.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Auftags-ID", "GP-Name", "Status"
            }
        ));
        jScrollPane1.setViewportView(jT_AuftragsIDSuchen);

        javax.swing.GroupLayout AuftragsID_suchenLayout = new javax.swing.GroupLayout(AuftragsID_suchen);
        AuftragsID_suchen.setLayout(AuftragsID_suchenLayout);
        AuftragsID_suchenLayout.setHorizontalGroup(
            AuftragsID_suchenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AuftragsID_suchenLayout.createSequentialGroup()
                .addGroup(AuftragsID_suchenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator23)
                    .addGroup(AuftragsID_suchenLayout.createSequentialGroup()
                        .addGap(290, 290, 290)
                        .addComponent(jLabel88)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AuftragsID_suchenLayout.createSequentialGroup()
                .addGroup(AuftragsID_suchenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(AuftragsID_suchenLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbSuchen_AuftragsIDSuchen, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbUebernehmen_AuftragsIDSuchen, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(AuftragsID_suchenLayout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(AuftragsID_suchenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(AuftragsID_suchenLayout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                                .addComponent(jtfGPName_AuftragsIDSuchen, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(AuftragsID_suchenLayout.createSequentialGroup()
                                .addComponent(jcbDatumAuftragsIDSuchen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jtfDatum_AuftragsIDSuchen, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(AuftragsID_suchenLayout.createSequentialGroup()
                                .addComponent(jLabel91)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jcbStatus_AuftragsIDSuchen, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 449, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(41, 41, 41))
        );
        AuftragsID_suchenLayout.setVerticalGroup(
            AuftragsID_suchenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AuftragsID_suchenLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jLabel88)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator23, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addGroup(AuftragsID_suchenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(AuftragsID_suchenLayout.createSequentialGroup()
                        .addGroup(AuftragsID_suchenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jtfGPName_AuftragsIDSuchen, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(AuftragsID_suchenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jcbDatumAuftragsIDSuchen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfDatum_AuftragsIDSuchen, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(AuftragsID_suchenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel91)
                            .addComponent(jcbStatus_AuftragsIDSuchen, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(AuftragsID_suchenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbUebernehmen_AuftragsIDSuchen, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbSuchen_AuftragsIDSuchen, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(40, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(AuftragsID_suchen, javax.swing.GroupLayout.PREFERRED_SIZE, 937, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(AuftragsID_suchen, javax.swing.GroupLayout.PREFERRED_SIZE, 462, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jcbDatumAuftragsIDSuchenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbDatumAuftragsIDSuchenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbDatumAuftragsIDSuchenActionPerformed

    private void jbSuchen_AuftragsIDSuchenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSuchen_AuftragsIDSuchenActionPerformed
         if(istVollstaendig()){
    
        }   
    }//GEN-LAST:event_jbSuchen_AuftragsIDSuchenActionPerformed

    private void jbUebernehmen_AuftragsIDSuchenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbUebernehmen_AuftragsIDSuchenActionPerformed
        /*----------------------------------------------------------*/
        /* 24.11.16 Yoeruek Schließt das Fenster nach Betätigung des Abbrech Buttons */
        /*----------------------------------------------------------*/
        this.setVisible(false);
    }//GEN-LAST:event_jbUebernehmen_AuftragsIDSuchenActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel AuftragsID_suchen;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel88;
    private javax.swing.JLabel jLabel91;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator23;
    private javax.swing.JTable jT_AuftragsIDSuchen;
    private javax.swing.JButton jbSuchen_AuftragsIDSuchen;
    private javax.swing.JButton jbUebernehmen_AuftragsIDSuchen;
    private javax.swing.JComboBox<String> jcbDatumAuftragsIDSuchen;
    private javax.swing.JComboBox<String> jcbStatus_AuftragsIDSuchen;
    private javax.swing.JTextField jtfDatum_AuftragsIDSuchen;
    private javax.swing.JTextField jtfGPName_AuftragsIDSuchen;
    // End of variables declaration//GEN-END:variables
}
