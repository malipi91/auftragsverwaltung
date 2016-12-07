/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

/*-----------------------------------------------------------------------*/
/* Datum Name Was                                                        */
/* 18.11.16 Impram Erstellung                                            */
/* 24.11.16 Yoeruek Aufsplittung der StartAv Klasse in einzelne Klassen, */
/*                  da Code für eine Klasse zu lang.                     */
/* 27.11.16 Yoeruek Anpassung der Größenverhältnisse (Schriftart, Layout)*/
/*-----------------------------------------------------------------------*/

public class ArtikelAnzeigen extends javax.swing.JInternalFrame {
    
    //Variablendeklaration
    ArtikelSuchen ArtAnzeige;
    
    /**
     * Creates new form ArtikelSuche
     */
    public ArtikelAnzeigen() {
        initComponents();
    }
    
    /* 29.11.16 Yoeruek Ausgabe von Artikel Anzeige Maske nach betätigung des Anzeige Buttons */
    public void setArtikelAnzeige(ArtikelSuchen aa) {
        this.ArtAnzeige = aa;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ArtikelAnzeigen = new javax.swing.JPanel();
        jbAnzeigen_ArtikelAnzeige = new javax.swing.JButton();
        jbAbbrechen_ArtikelAnzeige = new javax.swing.JButton();
        jLabel38 = new javax.swing.JLabel();
        jSeparator7 = new javax.swing.JSeparator();
        jtfArtikelID_ArtikelAnzeige = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jtfArtikelname_ArtikelAnzeige = new javax.swing.JTextField();
        jpArtikelAnzeige = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jtfFrei_ArtikelAnzeige = new javax.swing.JTextField();
        jtfZulauf_ArtikelAnzeige = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jtfReserviert_ArtikelAnzeige = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jtfVerkauft_ArtikelAnzeige = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtaBestelltext_ArtikelAnzeige = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtaArtikeltext_ArtikelAnzeige = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jtfEinzelwertNetto_ArtikelAnzeige = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jtfEinzelwertBrutto_ArtikelAnzeige = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jcbMwst_ArtikelAnzeige = new javax.swing.JComboBox<>();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);

        ArtikelAnzeigen.setPreferredSize(new java.awt.Dimension(1200, 900));
        ArtikelAnzeigen.setRequestFocusEnabled(false);

        jbAnzeigen_ArtikelAnzeige.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jbAnzeigen_ArtikelAnzeige.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/bearbeiten1.png"))); // NOI18N
        jbAnzeigen_ArtikelAnzeige.setText("Bearbeiten");
        jbAnzeigen_ArtikelAnzeige.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAnzeigen_ArtikelAnzeigeActionPerformed(evt);
            }
        });

        jbAbbrechen_ArtikelAnzeige.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jbAbbrechen_ArtikelAnzeige.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/abbruch2.png"))); // NOI18N
        jbAbbrechen_ArtikelAnzeige.setText("Abbrechen");
        jbAbbrechen_ArtikelAnzeige.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAbbrechen_ArtikelAnzeigeActionPerformed(evt);
            }
        });

        jLabel38.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel38.setText("Artikel Anzeigen");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel1.setText("Artikel-ID:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel2.setText("Artikelname:");

        jtfArtikelname_ArtikelAnzeige.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtfArtikelname_ArtikelAnzeige.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfArtikelname_ArtikelAnzeigeActionPerformed(evt);
            }
        });

        jpArtikelAnzeige.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Bestandsmengen");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel6.setText("Frei:");
        jLabel6.setToolTipText("");

        jtfFrei_ArtikelAnzeige.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jtfZulauf_ArtikelAnzeige.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel7.setText("Zulauf:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel8.setText("Reserviert:");

        jtfReserviert_ArtikelAnzeige.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel9.setText("Verkauft:");

        jtfVerkauft_ArtikelAnzeige.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtfVerkauft_ArtikelAnzeige.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfVerkauft_ArtikelAnzeigeActionPerformed(evt);
            }
        });

        jtaBestelltext_ArtikelAnzeige.setColumns(20);
        jtaBestelltext_ArtikelAnzeige.setRows(5);
        jScrollPane2.setViewportView(jtaBestelltext_ArtikelAnzeige);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel4.setText("Bestelltext:");

        jtaArtikeltext_ArtikelAnzeige.setColumns(20);
        jtaArtikeltext_ArtikelAnzeige.setRows(5);
        jScrollPane1.setViewportView(jtaArtikeltext_ArtikelAnzeige);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel3.setText("Artikeltext:");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel10.setText("Einzelwert (netto):");

        jtfEinzelwertNetto_ArtikelAnzeige.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel11.setText("Einzelwert (brutto):");

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel12.setText("MwST-Satz:");

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel13.setText("%");

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel14.setText("€");

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel15.setText("€");

        jcbMwst_ArtikelAnzeige.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "7", "19" }));

        javax.swing.GroupLayout jpArtikelAnzeigeLayout = new javax.swing.GroupLayout(jpArtikelAnzeige);
        jpArtikelAnzeige.setLayout(jpArtikelAnzeigeLayout);
        jpArtikelAnzeigeLayout.setHorizontalGroup(
            jpArtikelAnzeigeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpArtikelAnzeigeLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpArtikelAnzeigeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpArtikelAnzeigeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel5)
                        .addGroup(jpArtikelAnzeigeLayout.createSequentialGroup()
                            .addGroup(jpArtikelAnzeigeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel6)
                                .addComponent(jLabel7))
                            .addGap(89, 89, 89)
                            .addGroup(jpArtikelAnzeigeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jtfFrei_ArtikelAnzeige, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jtfZulauf_ArtikelAnzeige, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(93, 93, 93)
                            .addGroup(jpArtikelAnzeigeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel8)
                                .addComponent(jLabel9))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                            .addGroup(jpArtikelAnzeigeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jtfVerkauft_ArtikelAnzeige, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jtfReserviert_ArtikelAnzeige, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addComponent(jLabel4)
                        .addComponent(jLabel3)
                        .addGroup(jpArtikelAnzeigeLayout.createSequentialGroup()
                            .addComponent(jLabel10)
                            .addGap(26, 26, 26)
                            .addComponent(jtfEinzelwertNetto_ArtikelAnzeige, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel14)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel12)
                            .addGap(33, 33, 33)
                            .addComponent(jcbMwst_ArtikelAnzeige, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel13))
                        .addComponent(jScrollPane1)
                        .addComponent(jScrollPane2))
                    .addGroup(jpArtikelAnzeigeLayout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(18, 18, 18)
                        .addComponent(jtfEinzelwertBrutto_ArtikelAnzeige, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel15)))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        jpArtikelAnzeigeLayout.setVerticalGroup(
            jpArtikelAnzeigeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpArtikelAnzeigeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addGroup(jpArtikelAnzeigeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jtfFrei_ArtikelAnzeige, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(jtfReserviert_ArtikelAnzeige, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jpArtikelAnzeigeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfZulauf_ArtikelAnzeige, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel9)
                    .addComponent(jtfVerkauft_ArtikelAnzeige, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addGroup(jpArtikelAnzeigeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jtfEinzelwertNetto_ArtikelAnzeige, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14)
                    .addComponent(jcbMwst_ArtikelAnzeige, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jpArtikelAnzeigeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jtfEinzelwertBrutto_ArtikelAnzeige, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15))
                .addContainerGap(40, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout ArtikelAnzeigenLayout = new javax.swing.GroupLayout(ArtikelAnzeigen);
        ArtikelAnzeigen.setLayout(ArtikelAnzeigenLayout);
        ArtikelAnzeigenLayout.setHorizontalGroup(
            ArtikelAnzeigenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ArtikelAnzeigenLayout.createSequentialGroup()
                .addGap(308, 308, 308)
                .addComponent(jLabel38))
            .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 1207, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(ArtikelAnzeigenLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(ArtikelAnzeigenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(ArtikelAnzeigenLayout.createSequentialGroup()
                        .addComponent(jbAnzeigen_ArtikelAnzeige, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jbAbbrechen_ArtikelAnzeige, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(ArtikelAnzeigenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jpArtikelAnzeige, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(ArtikelAnzeigenLayout.createSequentialGroup()
                            .addGap(14, 14, 14)
                            .addComponent(jLabel1)
                            .addGap(66, 66, 66)
                            .addComponent(jtfArtikelID_ArtikelAnzeige, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(94, 94, 94)
                            .addComponent(jLabel2)
                            .addGap(32, 32, 32)
                            .addComponent(jtfArtikelname_ArtikelAnzeige, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))))
        );
        ArtikelAnzeigenLayout.setVerticalGroup(
            ArtikelAnzeigenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ArtikelAnzeigenLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jLabel38)
                .addGap(7, 7, 7)
                .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(ArtikelAnzeigenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jtfArtikelID_ArtikelAnzeige, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jtfArtikelname_ArtikelAnzeige, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jpArtikelAnzeige, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(ArtikelAnzeigenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbAnzeigen_ArtikelAnzeige, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbAbbrechen_ArtikelAnzeige, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(ArtikelAnzeigen, javax.swing.GroupLayout.PREFERRED_SIZE, 793, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(ArtikelAnzeigen, javax.swing.GroupLayout.PREFERRED_SIZE, 737, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 3, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbAnzeigen_ArtikelAnzeigeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAnzeigen_ArtikelAnzeigeActionPerformed

        /*29.11.16 Yoeruek Artikel Anzeige wird sichtbar*/
        ArtAnzeige.setVisible(true);
    }//GEN-LAST:event_jbAnzeigen_ArtikelAnzeigeActionPerformed

    private void jbAbbrechen_ArtikelAnzeigeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAbbrechen_ArtikelAnzeigeActionPerformed
  /*--------------------------------------------------------------------------*/
 /* 24.11.16 Impram Schließt das Fenster nach Betätigung des Abbrech Buttons */
 /*-------------------------------------------------------------------------*/
        this.setVisible(false);
//        dispose();
        
    }//GEN-LAST:event_jbAbbrechen_ArtikelAnzeigeActionPerformed

    private void jtfVerkauft_ArtikelAnzeigeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfVerkauft_ArtikelAnzeigeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfVerkauft_ArtikelAnzeigeActionPerformed

    private void jtfArtikelname_ArtikelAnzeigeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfArtikelname_ArtikelAnzeigeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfArtikelname_ArtikelAnzeigeActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ArtikelAnzeigen;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JButton jbAbbrechen_ArtikelAnzeige;
    private javax.swing.JButton jbAnzeigen_ArtikelAnzeige;
    private javax.swing.JComboBox<String> jcbMwst_ArtikelAnzeige;
    private javax.swing.JPanel jpArtikelAnzeige;
    private javax.swing.JTextArea jtaArtikeltext_ArtikelAnzeige;
    private javax.swing.JTextArea jtaBestelltext_ArtikelAnzeige;
    private javax.swing.JTextField jtfArtikelID_ArtikelAnzeige;
    private javax.swing.JTextField jtfArtikelname_ArtikelAnzeige;
    private javax.swing.JTextField jtfEinzelwertBrutto_ArtikelAnzeige;
    private javax.swing.JTextField jtfEinzelwertNetto_ArtikelAnzeige;
    private javax.swing.JTextField jtfFrei_ArtikelAnzeige;
    private javax.swing.JTextField jtfReserviert_ArtikelAnzeige;
    private javax.swing.JTextField jtfVerkauft_ArtikelAnzeige;
    private javax.swing.JTextField jtfZulauf_ArtikelAnzeige;
    // End of variables declaration//GEN-END:variables
}