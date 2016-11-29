/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

/*----------------------------------------------------------*/
 /* Datum Name Was */
 /* 18.11.16 Impram Erstellung*/
 /* 24.11.16 Yoeruek Aufsplittung der StartAv Klasse in einzelne Klassen, da Code für eine Klasse zu lang. */
 /* 27.11.16 Yoeruek Anpassung der Größenverhältnisse (Schriftart, Layout)*/
 /*----------------------------------------------------------*/
public class ArtikelSuche extends javax.swing.JInternalFrame {
    
    ArtikelAnzeige ArtAnzeige;
    
    /**
     * Creates new form ArtikelSuche
     */
    public ArtikelSuche() {
        initComponents();
    }
    
    // Ausgabe von Artikel Anzeige Maske nach betätigung des Anzeige Buttons
    public void setArtikelAnzeige(ArtikelAnzeige aa) {
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

        ArtikelSuche = new javax.swing.JPanel();
        jbAnzeigen_ArtikelSuche = new javax.swing.JButton();
        jbSuchen_ArtikelSuche = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jt_ArtikelSuche = new javax.swing.JTable();
        jbAbbrechen_ArtikelSuche = new javax.swing.JButton();
        jLabel38 = new javax.swing.JLabel();
        jSeparator7 = new javax.swing.JSeparator();
        jcbArtikelID_ArtikelSuche = new javax.swing.JComboBox();
        jtfSuchkriterium_ArtikelSuche = new javax.swing.JTextField();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);

        ArtikelSuche.setPreferredSize(new java.awt.Dimension(1200, 900));
        ArtikelSuche.setRequestFocusEnabled(false);

        jbAnzeigen_ArtikelSuche.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jbAnzeigen_ArtikelSuche.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/anzeigen.png"))); // NOI18N
        jbAnzeigen_ArtikelSuche.setText("Anzeigen");
        jbAnzeigen_ArtikelSuche.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAnzeigen_ArtikelSucheActionPerformed(evt);
            }
        });

        jbSuchen_ArtikelSuche.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jbSuchen_ArtikelSuche.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/lupe.png"))); // NOI18N
        jbSuchen_ArtikelSuche.setText("Suchen");

        jt_ArtikelSuche.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Artikel-ID", "Artikelname", "Artikeltext", "Bestandsmenge", "Bestandstext", "Einzelwert"
            }
        ));
        jScrollPane3.setViewportView(jt_ArtikelSuche);

        jbAbbrechen_ArtikelSuche.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jbAbbrechen_ArtikelSuche.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/abbruch2.png"))); // NOI18N
        jbAbbrechen_ArtikelSuche.setText("Abbrechen");
        jbAbbrechen_ArtikelSuche.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAbbrechen_ArtikelSucheActionPerformed(evt);
            }
        });

        jLabel38.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel38.setText("Artikel Suche");

        jcbArtikelID_ArtikelSuche.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jcbArtikelID_ArtikelSuche.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Artikel-ID", "Artikelname", "Bestandsmenge", "Einzelwert" }));

        javax.swing.GroupLayout ArtikelSucheLayout = new javax.swing.GroupLayout(ArtikelSuche);
        ArtikelSuche.setLayout(ArtikelSucheLayout);
        ArtikelSucheLayout.setHorizontalGroup(
            ArtikelSucheLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ArtikelSucheLayout.createSequentialGroup()
                .addGap(358, 358, 358)
                .addComponent(jLabel38))
            .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 1207, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(ArtikelSucheLayout.createSequentialGroup()
                .addGap(498, 498, 498)
                .addComponent(jbAnzeigen_ArtikelSuche, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jbAbbrechen_ArtikelSuche, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(ArtikelSucheLayout.createSequentialGroup()
                .addGap(114, 114, 114)
                .addGroup(ArtikelSucheLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(ArtikelSucheLayout.createSequentialGroup()
                        .addComponent(jcbArtikelID_ArtikelSuche, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jtfSuchkriterium_ArtikelSuche, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbSuchen_ArtikelSuche, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 655, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        ArtikelSucheLayout.setVerticalGroup(
            ArtikelSucheLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ArtikelSucheLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel38)
                .addGap(4, 4, 4)
                .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addGroup(ArtikelSucheLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcbArtikelID_ArtikelSuche, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbSuchen_ArtikelSuche, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfSuchkriterium_ArtikelSuche, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(ArtikelSucheLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbAnzeigen_ArtikelSuche, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbAbbrechen_ArtikelSuche, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(160, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ArtikelSuche, javax.swing.GroupLayout.PREFERRED_SIZE, 950, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ArtikelSuche, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbAnzeigen_ArtikelSucheActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAnzeigen_ArtikelSucheActionPerformed
//        ArtikelAnzeige artikelanzeige = new ArtikelAnzeige();
//        JPanel ArtikelSuche = artikelanzeige.getJPanel();
//        ArtikelSuche.setVisible(true);

//        jbAnzeigen_ArtikelSuche.addActionListener(artikelanzeige);
//        artikelanzeige.show();
        //Artikel Anzeige wird sichtbar
        ArtAnzeige.setVisible(true);
    }//GEN-LAST:event_jbAnzeigen_ArtikelSucheActionPerformed

    private void jbAbbrechen_ArtikelSucheActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAbbrechen_ArtikelSucheActionPerformed
  /*----------------------------------------------------------*/
 /* 24.11.16 Impram Schließt das Fenster nach Betätigung des Abbrech Buttons */
 /*----------------------------------------------------------*/
//        this.setVisible(false);
        dispose();
        
    }//GEN-LAST:event_jbAbbrechen_ArtikelSucheActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ArtikelSuche;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JButton jbAbbrechen_ArtikelSuche;
    private javax.swing.JButton jbAnzeigen_ArtikelSuche;
    private javax.swing.JButton jbSuchen_ArtikelSuche;
    private javax.swing.JComboBox jcbArtikelID_ArtikelSuche;
    private javax.swing.JTable jt_ArtikelSuche;
    private javax.swing.JTextField jtfSuchkriterium_ArtikelSuche;
    // End of variables declaration//GEN-END:variables
}
