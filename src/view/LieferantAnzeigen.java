package view;

/*----------------------------------------------------------*/
/* Datum Name Was */
/* 19.11.16 Citak Erstellung
/* 24.11.16 Yoeruek Aufsplittung der StartAv Klasse in einzelne Klassen, da Code für eine Klasse zu lang. */
/* 27.11.16 Citak Anpassung der Größenverhältnisse (Schriftart, Layout)*/
/*----------------------------------------------------------*/
public class LieferantAnzeigen extends javax.swing.JInternalFrame {
    
    //Variablendeklaration
    StartAV myParent;

    /* 06.12.16 Yoeruek Konstruktor, damit beim rein ziehen der Masken in die StartAV keine Probleme entstehen. */
    public LieferantAnzeigen(){
        initComponents();
    }
    
    /* 06.12.16 Yoeruek Konstruktor wird beim Ausführen der StartAV benutzt*/
    public LieferantAnzeigen(StartAV parent) {
        initComponents();
        myParent = parent;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LieferantAnzeigen = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jbzurueck_LieferantAnzeigen = new javax.swing.JButton();
        jSeparator16 = new javax.swing.JSeparator();
        jbLupeGPID_LieferantAnzeigen = new javax.swing.JButton();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);

        LieferantAnzeigen.setPreferredSize(new java.awt.Dimension(1200, 900));

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel10.setText("Lieferant anzeigen");

        jbzurueck_LieferantAnzeigen.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jbzurueck_LieferantAnzeigen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/zurück.png"))); // NOI18N
        jbzurueck_LieferantAnzeigen.setText("Zurück");
        jbzurueck_LieferantAnzeigen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbzurueck_LieferantAnzeigenActionPerformed(evt);
            }
        });

        jbLupeGPID_LieferantAnzeigen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/lupe2.png"))); // NOI18N
        jbLupeGPID_LieferantAnzeigen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbLupeGPID_LieferantAnzeigenActionPerformed(evt);
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
                        .addComponent(jbzurueck_LieferantAnzeigen, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(LieferantAnzeigenLayout.createSequentialGroup()
                        .addGap(297, 297, 297)
                        .addComponent(jLabel10))
                    .addComponent(jSeparator16, javax.swing.GroupLayout.PREFERRED_SIZE, 943, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LieferantAnzeigenLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jbLupeGPID_LieferantAnzeigen, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(319, 319, 319))
        );
        LieferantAnzeigenLayout.setVerticalGroup(
            LieferantAnzeigenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LieferantAnzeigenLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jLabel10)
                .addGap(9, 9, 9)
                .addComponent(jSeparator16, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbLupeGPID_LieferantAnzeigen, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(125, 125, 125)
                .addComponent(jbzurueck_LieferantAnzeigen, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(565, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 950, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(LieferantAnzeigen, javax.swing.GroupLayout.PREFERRED_SIZE, 950, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 804, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(LieferantAnzeigen, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbzurueck_LieferantAnzeigenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbzurueck_LieferantAnzeigenActionPerformed
         /*----------------------------------------------------------*/
        /* 24.11.16 Citak Schließt das Fenster nach Betätigung des Abbrech Buttons */
        /*----------------------------------------------------------*/
        this.setVisible(false);
    }//GEN-LAST:event_jbzurueck_LieferantAnzeigenActionPerformed

    private void jbLupeGPID_LieferantAnzeigenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbLupeGPID_LieferantAnzeigenActionPerformed
        /* 30.11.16 Yoeruek Öffnet über die Lupe GP-ID Suchen */
//        myParent.oeffneGPIDSuchen();
    }//GEN-LAST:event_jbLupeGPID_LieferantAnzeigenActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel LieferantAnzeigen;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JSeparator jSeparator16;
    private javax.swing.JButton jbLupeGPID_LieferantAnzeigen;
    private javax.swing.JButton jbzurueck_LieferantAnzeigen;
    // End of variables declaration//GEN-END:variables
}
