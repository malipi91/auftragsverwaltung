package view;

/*----------------------------------------------------------*/
/* Datum Name Was */
/* 17.11.16 Yoeruek Erstellung*/
/* 24.11.16 Yoeruek Aufsplittung der StartAv Klasse in einzelne Klassen, da Code für eine Klasse zu lang. */
/* 27.11.16 Yoeruek Anpassung der Größenverhältnisse (Schriftart, Layout)*/
/*----------------------------------------------------------*/
public class ZKBearbeiten extends javax.swing.JInternalFrame {
    //Variablendeklaration
    StartAV myParent;

    /* 06.12.16 Yoeruek Konstruktor, damit beim rein ziehen der Masken in die StartAV keine Probleme entstehen. */
    public ZKBearbeiten(){
        initComponents();
    }
    
    /* 06.12.16 Yoeruek Konstruktor wird beim Ausführen der StartAV benutzt*/
    public ZKBearbeiten(StartAV parent) {
        initComponents();
        myParent = parent;
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ZKBearbeiten = new javax.swing.JPanel();
        jLabel76 = new javax.swing.JLabel();
        jSeparator22 = new javax.swing.JSeparator();
        jbAbbrechen_ZKBearbeiten = new javax.swing.JButton();
        jbBearbeiten_ZKBearbeiten = new javax.swing.JButton();
        jLabel124 = new javax.swing.JLabel();
        jtfZKID_ZKBearbeiten = new javax.swing.JTextField();
        jbLupeZKID_ZKBearbeiten = new javax.swing.JButton();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);

        ZKBearbeiten.setMaximumSize(new java.awt.Dimension(2000, 2000));
        ZKBearbeiten.setMinimumSize(new java.awt.Dimension(500, 500));
        ZKBearbeiten.setPreferredSize(new java.awt.Dimension(1200, 900));

        jLabel76.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel76.setText("Zahlungskonditionen Bearbeiten");

        jbAbbrechen_ZKBearbeiten.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jbAbbrechen_ZKBearbeiten.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/abbruch2.png"))); // NOI18N
        jbAbbrechen_ZKBearbeiten.setText("Abbrechen");
        jbAbbrechen_ZKBearbeiten.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAbbrechen_ZKBearbeitenActionPerformed(evt);
            }
        });

        jbBearbeiten_ZKBearbeiten.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jbBearbeiten_ZKBearbeiten.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/bearbeiten1.png"))); // NOI18N
        jbBearbeiten_ZKBearbeiten.setText("Bearbeiten");
        jbBearbeiten_ZKBearbeiten.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBearbeiten_ZKBearbeitenActionPerformed(evt);
            }
        });

        jLabel124.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel124.setText("ZK-ID:");

        jbLupeZKID_ZKBearbeiten.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/lupe.png"))); // NOI18N
        jbLupeZKID_ZKBearbeiten.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbLupeZKID_ZKBearbeitenActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ZKBearbeitenLayout = new javax.swing.GroupLayout(ZKBearbeiten);
        ZKBearbeiten.setLayout(ZKBearbeitenLayout);
        ZKBearbeitenLayout.setHorizontalGroup(
            ZKBearbeitenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator22)
            .addGroup(ZKBearbeitenLayout.createSequentialGroup()
                .addGroup(ZKBearbeitenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ZKBearbeitenLayout.createSequentialGroup()
                        .addGap(252, 252, 252)
                        .addComponent(jLabel76))
                    .addGroup(ZKBearbeitenLayout.createSequentialGroup()
                        .addGap(289, 289, 289)
                        .addGroup(ZKBearbeitenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(ZKBearbeitenLayout.createSequentialGroup()
                                .addComponent(jLabel124)
                                .addGap(18, 18, 18)
                                .addComponent(jtfZKID_ZKBearbeiten, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jbLupeZKID_ZKBearbeiten, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(ZKBearbeitenLayout.createSequentialGroup()
                                .addComponent(jbBearbeiten_ZKBearbeiten, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jbAbbrechen_ZKBearbeiten, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(361, Short.MAX_VALUE))
        );
        ZKBearbeitenLayout.setVerticalGroup(
            ZKBearbeitenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ZKBearbeitenLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel76)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator22, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(ZKBearbeitenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbLupeZKID_ZKBearbeiten, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(ZKBearbeitenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel124)
                        .addComponent(jtfZKID_ZKBearbeiten, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(ZKBearbeitenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbBearbeiten_ZKBearbeiten, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbAbbrechen_ZKBearbeiten, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(646, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 950, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(ZKBearbeiten, javax.swing.GroupLayout.PREFERRED_SIZE, 950, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 800, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(ZKBearbeiten, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbAbbrechen_ZKBearbeitenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAbbrechen_ZKBearbeitenActionPerformed
        /*----------------------------------------------------------*/
        /* 24.11.16 Yoeruek Schließt das Fenster nach Betätigung des Abbrech Buttons */
        /*----------------------------------------------------------*/
        this.setVisible(false);
    }//GEN-LAST:event_jbAbbrechen_ZKBearbeitenActionPerformed

    private void jbBearbeiten_ZKBearbeitenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBearbeiten_ZKBearbeitenActionPerformed

    }//GEN-LAST:event_jbBearbeiten_ZKBearbeitenActionPerformed

    private void jbLupeZKID_ZKBearbeitenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbLupeZKID_ZKBearbeitenActionPerformed
        /* 30.11.16 Yoeruek Öffnet über die Lupe ZK-ID Suchen */
//        myParent.oeffneZKIDSuchen();
    }//GEN-LAST:event_jbLupeZKID_ZKBearbeitenActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ZKBearbeiten;
    private javax.swing.JLabel jLabel124;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JSeparator jSeparator22;
    private javax.swing.JButton jbAbbrechen_ZKBearbeiten;
    private javax.swing.JButton jbBearbeiten_ZKBearbeiten;
    private javax.swing.JButton jbLupeZKID_ZKBearbeiten;
    private javax.swing.JTextField jtfZKID_ZKBearbeiten;
    // End of variables declaration//GEN-END:variables
}
