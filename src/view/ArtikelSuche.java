/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

/**
 *
 * @author User
 */
public class ArtikelSuche extends javax.swing.JInternalFrame {

    /**
     * Creates new form ArtikelSuche
     */
    public ArtikelSuche() {
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

        ArtikelSuche = new javax.swing.JPanel();
        jLabel57 = new javax.swing.JLabel();
        jbAnzeigen_ArtikelSuche = new javax.swing.JButton();
        jbSuchen_ArtikelSuche = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jt_ArtikelSuche = new javax.swing.JTable();
        jbAbbrechen_ArtikelSuche = new javax.swing.JButton();
        jLabel38 = new javax.swing.JLabel();
        jSeparator7 = new javax.swing.JSeparator();
        jcbArtikelID_ArtikelSuche = new javax.swing.JComboBox();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);

        ArtikelSuche.setPreferredSize(new java.awt.Dimension(1200, 800));
        ArtikelSuche.setRequestFocusEnabled(false);

        jLabel57.setText("Artikel-ID:");

        jbAnzeigen_ArtikelSuche.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/anzeigen.png"))); // NOI18N
        jbAnzeigen_ArtikelSuche.setText("Anzeigen");
        jbAnzeigen_ArtikelSuche.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAnzeigen_ArtikelSucheActionPerformed(evt);
            }
        });

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

        jbAbbrechen_ArtikelSuche.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/abbruch2.png"))); // NOI18N
        jbAbbrechen_ArtikelSuche.setText("Abbrechen");
        jbAbbrechen_ArtikelSuche.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAbbrechen_ArtikelSucheActionPerformed(evt);
            }
        });

        jLabel38.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel38.setText("Artikel Suche");

        jcbArtikelID_ArtikelSuche.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "", "Artikel-ID", "Artikelname", "Bestandsmenge", "Einzelwert" }));

        javax.swing.GroupLayout ArtikelSucheLayout = new javax.swing.GroupLayout(ArtikelSuche);
        ArtikelSuche.setLayout(ArtikelSucheLayout);
        ArtikelSucheLayout.setHorizontalGroup(
            ArtikelSucheLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ArtikelSucheLayout.createSequentialGroup()
                .addGap(232, 232, 232)
                .addComponent(jbAnzeigen_ArtikelSuche)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbAbbrechen_ArtikelSuche))
            .addGroup(ArtikelSucheLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel57)
                .addGap(18, 18, 18)
                .addComponent(jcbArtikelID_ArtikelSuche, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(131, 131, 131)
                .addComponent(jbSuchen_ArtikelSuche))
            .addGroup(ArtikelSucheLayout.createSequentialGroup()
                .addGap(358, 358, 358)
                .addComponent(jLabel38))
            .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 1207, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(ArtikelSucheLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 655, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                    .addComponent(jLabel57)
                    .addComponent(jbSuchen_ArtikelSuche)
                    .addComponent(jcbArtikelID_ArtikelSuche, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(ArtikelSucheLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbAnzeigen_ArtikelSuche)
                    .addComponent(jbAbbrechen_ArtikelSuche))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1043, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(197, 197, 197)
                    .addComponent(ArtikelSuche, javax.swing.GroupLayout.PREFERRED_SIZE, 649, Short.MAX_VALUE)
                    .addGap(197, 197, 197)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 662, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(ArtikelSuche, javax.swing.GroupLayout.DEFAULT_SIZE, 636, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbAnzeigen_ArtikelSucheActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAnzeigen_ArtikelSucheActionPerformed
       
    }//GEN-LAST:event_jbAnzeigen_ArtikelSucheActionPerformed

    private void jbAbbrechen_ArtikelSucheActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAbbrechen_ArtikelSucheActionPerformed
      this.setVisible(false);
    }//GEN-LAST:event_jbAbbrechen_ArtikelSucheActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ArtikelSuche;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JButton jbAbbrechen_ArtikelSuche;
    private javax.swing.JButton jbAnzeigen_ArtikelSuche;
    private javax.swing.JButton jbSuchen_ArtikelSuche;
    private javax.swing.JComboBox jcbArtikelID_ArtikelSuche;
    private javax.swing.JTable jt_ArtikelSuche;
    // End of variables declaration//GEN-END:variables
}