package view;

/*--------------------------------------------------------------------------------------------------------*/
/* Datum    Name    Was                                                                                   */
/* 19.11.16 Yoeruek Erstellung                                                                            */
/* 24.11.16 Yoeruek Aufsplittung der StartAv Klasse in einzelne Klassen, da Code für eine Klasse zu lang. */
/* 27.11.16 Yoeruek Anpassung der Größenverhältnisse (Schriftart, Layout)                                 */
/*--------------------------------------------------------------------------------------------------------*/

public class ZKAnzeigen extends javax.swing.JInternalFrame {
    
    //Variablendeklaration
    StartAV myParent;

    /* 06.12.16 Yoeruek Konstruktor, damit beim rein ziehen der Masken in die StartAV keine Probleme entstehen. */
    public ZKAnzeigen(){
        initComponents();
    }
    
    /* 06.12.16 Yoeruek Konstruktor wird beim Ausführen der StartAV benutzt*/
    public ZKAnzeigen(StartAV parent) {
        initComponents();
        myParent = parent;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ZKAnzeigen = new javax.swing.JPanel();
        jLabel77 = new javax.swing.JLabel();
        jbAbbrechen_ZKAnzeigen = new javax.swing.JButton();
        jbBearbeiten_ZKAnzeigen = new javax.swing.JButton();
        jSeparator28 = new javax.swing.JSeparator();
        jbSpeichern_ZKAnzeigen = new javax.swing.JButton();
        jLabel81 = new javax.swing.JLabel();
        jtfZKID_ZKAnzeigen = new javax.swing.JTextField();
        jLabel82 = new javax.swing.JLabel();
        jcbAuftragsart_ZKAnzeigen = new javax.swing.JComboBox<>();
        jLabel83 = new javax.swing.JLabel();
        jtfLieferzeitSofort_ZKAnzeigen = new javax.swing.JTextField();
        jLabel84 = new javax.swing.JLabel();
        jtfSperrzeitWunsch_ZKAnzeigen = new javax.swing.JTextField();
        Skonto_ZKAnzeigen = new javax.swing.JPanel();
        jLabel85 = new javax.swing.JLabel();
        jLabel86 = new javax.swing.JLabel();
        jLabel92 = new javax.swing.JLabel();
        jLabel93 = new javax.swing.JLabel();
        jSeparator24 = new javax.swing.JSeparator();
        jtfSkontofrist1_ZKAnzeigen = new javax.swing.JTextField();
        jtfSkontofrist2_ZKAnzeigen = new javax.swing.JTextField();
        jtfSkontosatz1_ZKAnzeigen = new javax.swing.JTextField();
        jtfSkontosatz2_ZKAnzeigen = new javax.swing.JTextField();
        jLabel112 = new javax.swing.JLabel();
        jLabel113 = new javax.swing.JLabel();
        jLabel114 = new javax.swing.JLabel();
        jLabel115 = new javax.swing.JLabel();
        Mahnzeit_ZKAnzeigen = new javax.swing.JPanel();
        jLabel94 = new javax.swing.JLabel();
        jLabel95 = new javax.swing.JLabel();
        jLabel96 = new javax.swing.JLabel();
        jtfMahnzeit2_ZKAnzeigen = new javax.swing.JTextField();
        jtfMahnzeit3_ZKAnzeigen = new javax.swing.JTextField();
        jtfMahnzeit1_ZKAnzeigen = new javax.swing.JTextField();
        jLabel116 = new javax.swing.JLabel();
        jLabel117 = new javax.swing.JLabel();
        jLabel118 = new javax.swing.JLabel();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);

        ZKAnzeigen.setPreferredSize(new java.awt.Dimension(1200, 900));

        jLabel77.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel77.setText("Zahlungskonditionen Anzeigen");

        jbAbbrechen_ZKAnzeigen.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jbAbbrechen_ZKAnzeigen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/abbruch2.png"))); // NOI18N
        jbAbbrechen_ZKAnzeigen.setText("Abbrechen");
        jbAbbrechen_ZKAnzeigen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAbbrechen_ZKAnzeigenActionPerformed(evt);
            }
        });

        jbBearbeiten_ZKAnzeigen.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jbBearbeiten_ZKAnzeigen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/bearbeiten1.png"))); // NOI18N
        jbBearbeiten_ZKAnzeigen.setText("Bearbeiten");
        jbBearbeiten_ZKAnzeigen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBearbeiten_ZKAnzeigenActionPerformed(evt);
            }
        });

        jbSpeichern_ZKAnzeigen.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jbSpeichern_ZKAnzeigen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/speichern2.png"))); // NOI18N
        jbSpeichern_ZKAnzeigen.setText("Speichern");

        jLabel81.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel81.setText("ZK-ID:");

        jtfZKID_ZKAnzeigen.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel82.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel82.setText("Auftragsart:");

        jcbAuftragsart_ZKAnzeigen.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jcbAuftragsart_ZKAnzeigen.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Barauftrag", "Sofortauftrag", "Terminauftrag", "Bestellauftrag" }));

        jLabel83.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel83.setText("Lieferzeit-Sofort:");

        jtfLieferzeitSofort_ZKAnzeigen.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel84.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel84.setText("Sperrzeit-Wunsch:");
        jLabel84.setToolTipText("");

        jtfSperrzeitWunsch_ZKAnzeigen.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        Skonto_ZKAnzeigen.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Skonto", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N

        jLabel85.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel85.setText("Skontofrist 1:");

        jLabel86.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel86.setText("Skontofrist 2:");

        jLabel92.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel92.setText("Skontosatz 1:");

        jLabel93.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel93.setText("Skontosatz 2:");

        jSeparator24.setBackground(new java.awt.Color(200, 200, 200));
        jSeparator24.setForeground(new java.awt.Color(190, 190, 190));

        jtfSkontofrist1_ZKAnzeigen.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jtfSkontofrist2_ZKAnzeigen.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jtfSkontosatz1_ZKAnzeigen.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jtfSkontosatz2_ZKAnzeigen.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel112.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel112.setText("Tage");

        jLabel113.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel113.setText("Tage");

        jLabel114.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel114.setText("%");

        jLabel115.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel115.setText("%");

        javax.swing.GroupLayout Skonto_ZKAnzeigenLayout = new javax.swing.GroupLayout(Skonto_ZKAnzeigen);
        Skonto_ZKAnzeigen.setLayout(Skonto_ZKAnzeigenLayout);
        Skonto_ZKAnzeigenLayout.setHorizontalGroup(
            Skonto_ZKAnzeigenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Skonto_ZKAnzeigenLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Skonto_ZKAnzeigenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel85)
                    .addComponent(jLabel86)
                    .addComponent(jLabel92)
                    .addComponent(jLabel93))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
                .addGroup(Skonto_ZKAnzeigenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Skonto_ZKAnzeigenLayout.createSequentialGroup()
                        .addGroup(Skonto_ZKAnzeigenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jtfSkontofrist2_ZKAnzeigen, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfSkontofrist1_ZKAnzeigen, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(Skonto_ZKAnzeigenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel112)
                            .addComponent(jLabel113)))
                    .addGroup(Skonto_ZKAnzeigenLayout.createSequentialGroup()
                        .addComponent(jtfSkontosatz1_ZKAnzeigen, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel114))
                    .addGroup(Skonto_ZKAnzeigenLayout.createSequentialGroup()
                        .addComponent(jtfSkontosatz2_ZKAnzeigen, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel115)))
                .addContainerGap())
            .addComponent(jSeparator24)
        );
        Skonto_ZKAnzeigenLayout.setVerticalGroup(
            Skonto_ZKAnzeigenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Skonto_ZKAnzeigenLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(Skonto_ZKAnzeigenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel85)
                    .addComponent(jtfSkontofrist1_ZKAnzeigen, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel112))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(Skonto_ZKAnzeigenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfSkontofrist2_ZKAnzeigen, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel86)
                    .addComponent(jLabel113))
                .addGap(18, 18, 18)
                .addComponent(jSeparator24, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addGroup(Skonto_ZKAnzeigenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel92)
                    .addComponent(jtfSkontosatz1_ZKAnzeigen, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel114))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(Skonto_ZKAnzeigenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel93)
                    .addComponent(jtfSkontosatz2_ZKAnzeigen, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel115))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        Mahnzeit_ZKAnzeigen.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Mahnzeit", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N

        jLabel94.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel94.setText("Mahnzeit 1:");
        jLabel94.setToolTipText("");

        jLabel95.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel95.setText("Mahnzeit 2:");

        jLabel96.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel96.setText("Mahnzeit 3:");

        jtfMahnzeit2_ZKAnzeigen.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtfMahnzeit2_ZKAnzeigen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfMahnzeit2_ZKAnzeigenActionPerformed(evt);
            }
        });

        jtfMahnzeit3_ZKAnzeigen.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jtfMahnzeit1_ZKAnzeigen.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtfMahnzeit1_ZKAnzeigen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfMahnzeit1_ZKAnzeigenActionPerformed(evt);
            }
        });

        jLabel116.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel116.setText("Tage");

        jLabel117.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel117.setText("Tage");

        jLabel118.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel118.setText("Tage");

        javax.swing.GroupLayout Mahnzeit_ZKAnzeigenLayout = new javax.swing.GroupLayout(Mahnzeit_ZKAnzeigen);
        Mahnzeit_ZKAnzeigen.setLayout(Mahnzeit_ZKAnzeigenLayout);
        Mahnzeit_ZKAnzeigenLayout.setHorizontalGroup(
            Mahnzeit_ZKAnzeigenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Mahnzeit_ZKAnzeigenLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Mahnzeit_ZKAnzeigenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel94)
                    .addComponent(jLabel95)
                    .addComponent(jLabel96))
                .addGap(75, 75, 75)
                .addGroup(Mahnzeit_ZKAnzeigenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Mahnzeit_ZKAnzeigenLayout.createSequentialGroup()
                        .addComponent(jtfMahnzeit2_ZKAnzeigen, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel117))
                    .addGroup(Mahnzeit_ZKAnzeigenLayout.createSequentialGroup()
                        .addComponent(jtfMahnzeit1_ZKAnzeigen, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel116))
                    .addGroup(Mahnzeit_ZKAnzeigenLayout.createSequentialGroup()
                        .addComponent(jtfMahnzeit3_ZKAnzeigen, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel118)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        Mahnzeit_ZKAnzeigenLayout.setVerticalGroup(
            Mahnzeit_ZKAnzeigenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Mahnzeit_ZKAnzeigenLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Mahnzeit_ZKAnzeigenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel94)
                    .addComponent(jtfMahnzeit1_ZKAnzeigen, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel116))
                .addGap(18, 18, 18)
                .addGroup(Mahnzeit_ZKAnzeigenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel95)
                    .addComponent(jtfMahnzeit2_ZKAnzeigen, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel117))
                .addGap(18, 18, 18)
                .addGroup(Mahnzeit_ZKAnzeigenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel96)
                    .addComponent(jtfMahnzeit3_ZKAnzeigen, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel118))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout ZKAnzeigenLayout = new javax.swing.GroupLayout(ZKAnzeigen);
        ZKAnzeigen.setLayout(ZKAnzeigenLayout);
        ZKAnzeigenLayout.setHorizontalGroup(
            ZKAnzeigenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator28)
            .addGroup(ZKAnzeigenLayout.createSequentialGroup()
                .addGroup(ZKAnzeigenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ZKAnzeigenLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(ZKAnzeigenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(ZKAnzeigenLayout.createSequentialGroup()
                                .addComponent(jbSpeichern_ZKAnzeigen, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jbBearbeiten_ZKAnzeigen, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jbAbbrechen_ZKAnzeigen, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(ZKAnzeigenLayout.createSequentialGroup()
                                .addGroup(ZKAnzeigenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ZKAnzeigenLayout.createSequentialGroup()
                                        .addComponent(Skonto_ZKAnzeigen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(45, 45, 45))
                                    .addGroup(ZKAnzeigenLayout.createSequentialGroup()
                                        .addGap(15, 15, 15)
                                        .addGroup(ZKAnzeigenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel81)
                                            .addComponent(jLabel83))
                                        .addGap(48, 48, 48)
                                        .addGroup(ZKAnzeigenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jtfZKID_ZKAnzeigen, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jtfLieferzeitSofort_ZKAnzeigen, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 136, Short.MAX_VALUE)))
                                .addGroup(ZKAnzeigenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(ZKAnzeigenLayout.createSequentialGroup()
                                        .addGroup(ZKAnzeigenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel84)
                                            .addComponent(jLabel82))
                                        .addGap(40, 40, 40)
                                        .addGroup(ZKAnzeigenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jtfSperrzeitWunsch_ZKAnzeigen, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jcbAuftragsart_ZKAnzeigen, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(Mahnzeit_ZKAnzeigen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(ZKAnzeigenLayout.createSequentialGroup()
                        .addGap(307, 307, 307)
                        .addComponent(jLabel77)))
                .addContainerGap(100, Short.MAX_VALUE))
        );
        ZKAnzeigenLayout.setVerticalGroup(
            ZKAnzeigenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ZKAnzeigenLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel77)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator28, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(ZKAnzeigenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ZKAnzeigenLayout.createSequentialGroup()
                        .addGroup(ZKAnzeigenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtfZKID_ZKAnzeigen, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel81))
                        .addGap(18, 18, 18)
                        .addGroup(ZKAnzeigenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtfLieferzeitSofort_ZKAnzeigen, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel83)))
                    .addGroup(ZKAnzeigenLayout.createSequentialGroup()
                        .addGroup(ZKAnzeigenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel82)
                            .addComponent(jcbAuftragsart_ZKAnzeigen, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(ZKAnzeigenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel84)
                            .addComponent(jtfSperrzeitWunsch_ZKAnzeigen, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(72, 72, 72)
                .addGroup(ZKAnzeigenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Skonto_ZKAnzeigen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Mahnzeit_ZKAnzeigen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(19, 19, 19)
                .addGroup(ZKAnzeigenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbSpeichern_ZKAnzeigen, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbAbbrechen_ZKAnzeigen, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbBearbeiten_ZKAnzeigen, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(294, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 950, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(ZKAnzeigen, javax.swing.GroupLayout.PREFERRED_SIZE, 950, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 800, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(ZKAnzeigen, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbAbbrechen_ZKAnzeigenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAbbrechen_ZKAnzeigenActionPerformed
        /*----------------------------------------------------------*/
        /* 24.11.16 Yoeruek Schließt das Fenster nach Betätigung des Abbrech Buttons */
        /*----------------------------------------------------------*/
        this.setVisible(false);
    }//GEN-LAST:event_jbAbbrechen_ZKAnzeigenActionPerformed

    private void jbBearbeiten_ZKAnzeigenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBearbeiten_ZKAnzeigenActionPerformed
        //
    }//GEN-LAST:event_jbBearbeiten_ZKAnzeigenActionPerformed

    private void jtfMahnzeit2_ZKAnzeigenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfMahnzeit2_ZKAnzeigenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfMahnzeit2_ZKAnzeigenActionPerformed

    private void jtfMahnzeit1_ZKAnzeigenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfMahnzeit1_ZKAnzeigenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfMahnzeit1_ZKAnzeigenActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Mahnzeit_ZKAnzeigen;
    private javax.swing.JPanel Skonto_ZKAnzeigen;
    private javax.swing.JPanel ZKAnzeigen;
    private javax.swing.JLabel jLabel112;
    private javax.swing.JLabel jLabel113;
    private javax.swing.JLabel jLabel114;
    private javax.swing.JLabel jLabel115;
    private javax.swing.JLabel jLabel116;
    private javax.swing.JLabel jLabel117;
    private javax.swing.JLabel jLabel118;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel92;
    private javax.swing.JLabel jLabel93;
    private javax.swing.JLabel jLabel94;
    private javax.swing.JLabel jLabel95;
    private javax.swing.JLabel jLabel96;
    private javax.swing.JSeparator jSeparator24;
    private javax.swing.JSeparator jSeparator28;
    private javax.swing.JButton jbAbbrechen_ZKAnzeigen;
    private javax.swing.JButton jbBearbeiten_ZKAnzeigen;
    private javax.swing.JButton jbSpeichern_ZKAnzeigen;
    private javax.swing.JComboBox<String> jcbAuftragsart_ZKAnzeigen;
    private javax.swing.JTextField jtfLieferzeitSofort_ZKAnzeigen;
    private javax.swing.JTextField jtfMahnzeit1_ZKAnzeigen;
    private javax.swing.JTextField jtfMahnzeit2_ZKAnzeigen;
    private javax.swing.JTextField jtfMahnzeit3_ZKAnzeigen;
    private javax.swing.JTextField jtfSkontofrist1_ZKAnzeigen;
    private javax.swing.JTextField jtfSkontofrist2_ZKAnzeigen;
    private javax.swing.JTextField jtfSkontosatz1_ZKAnzeigen;
    private javax.swing.JTextField jtfSkontosatz2_ZKAnzeigen;
    private javax.swing.JTextField jtfSperrzeitWunsch_ZKAnzeigen;
    private javax.swing.JTextField jtfZKID_ZKAnzeigen;
    // End of variables declaration//GEN-END:variables
}
