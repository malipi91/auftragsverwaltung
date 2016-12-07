package view;

import javax.swing.JOptionPane;

/*----------------------------------------------------------*/
/* Datum    Name    Was                                     */
/* 11.11.16 Impram  angelegt                                */
/* 11.11.16 Yoeruek angelegt                                */
/* 16.11.16 Citak   angelegt                                */
/* 05.12.16 Yoeruek Neu Strukturierung der Gesamten Klasse  */
/*----------------------------------------------------------*/
public class StartAV extends javax.swing.JFrame {

//Mehmet Impram 
    private final String ABMELDE_TITEL = "ABMELDEN";
    private final String ABMELDE_TEXT = "Möchten Sie wirklich abmelden";
    //Mehmet Impram 27.11.2016
    private final String INFO_TITEL = "Info zum Anmelden auf das System";
    private final String INFO_TEXT = "Bei Benutzername & Passwort geben sie min. 1 Buchstaben ein ";
    private final String  BEENDE_TEXT = "Sie sind dabei diesen Programm zuschliessen";
    private final String BEENDE_TITEL = "Schliessen bestätigen";
    boolean istEingeloggt = false;
    private Object view;
    
    
    public StartAV() {
        initComponents();
        
        //Startseite Mechmet Impram Benutzername Feld akzeptiert nur Buchstaben.
        jtfBenutzername_Startseite.setDocument(new UniversalDokument(true, false, "-. ' ", -1));
        // Mechmet Impram Passwort Feld ebenso akzeptiert nur Buchstaben.
        jpwpasswort_Startseite.setDocument((new UniversalDokument(true, false, "-. ' ", -1)));
    }

    /*------------------------------------------------------------*/
/* 29.11.16 Yoeruek Methode zum Aufrufen der einzelnen Masken */
/*------------------------------------------------------------*/
//    public void oeffneAuftragIDSuchen() {
//        jifAuftragsID_suchen.setVisible(true);
//    }
    
/*------------------------------------------------------------*/
/* 29.11.16 Yoeruek Methode zum Aufrufen der einzelnen Masken */
/*------------------------------------------------------------*/
//    public void oeffneGPIDSuchen(){
//        jifGPID_suchen.setVisible(true);
//    }
    
/*------------------------------------------------------------*/
/* 30.11.16 Yoeruek Methode zum Aufrufen der einzelnen Masken */
/*------------------------------------------------------------*/
//    public void oeffneArtikelIDSuchen(){
//        jifArtikelID_suchen.setVisible(true);
//    }
    
/*------------------------------------------------------------*/
/* 30.11.16 Yoeruek Methode zum Aufrufen der einzelnen Masken */
/*------------------------------------------------------------*/
//    public void oeffneZKIDSuchen(){
//        jifZKID_suchen.setVisible(true);
//    }
    
    public void oeffneArtikelBearbeiten(){
        this.jifArtikelBearbeiten.setVisible(true);
    }
    
    public ArtikelBearbeiten getArtikelBearbeiten(){
        return this.jifArtikelBearbeiten;
    }
    
    public void oeffneAuftragAnzeige(){
        this.jifAuftragAnzeigen.setVisible(true);
    }
    
    public void oeffneArtikelAnzeigen(){
        this.jifArtikelAnzeige.setVisible(true);
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        desktopPane = new javax.swing.JDesktopPane();
        Startseite = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jtfBenutzername_Startseite = new javax.swing.JTextField();
        jpwpasswort_Startseite = new javax.swing.JPasswordField();
        jbanmelden_Startseite = new javax.swing.JButton();
        SeiteZwei = new javax.swing.JPanel();
        jifArtikelSuche = new view.ArtikelSuchen(this);
        jifArtikelAnzeige = new view.ArtikelAnzeigen();
        jifArtikelAnlegen = new view.ArtikelAnlegen();
        jifArtikelBearbeiten = new view.ArtikelBearbeiten();
        jifAuftragAnlegen = new view.AuftragAnlegen();
        jifAuftragAnzeigen = new view.AuftragAnzeigen(this);
        jifAuftragBearbeiten = new view.AuftragBearbeiten();
        jifAuftragSuchen = new view.AuftragSuchen(this);
        jifKundeAnlegen = new view.KundeAnlegen();
        jifKundeAnzeigen = new view.KundeAnzeigen();
        jifKundeBearbeiten = new view.KundeBearbeiten();
        jifKundeSuchen = new view.KundeSuchen();
        jifLieferantAnlegen = new view.LieferantAnlegen();
        jifLieferantAnzeigen = new view.LieferantAnzeigen();
        jifLieferantBearbeiten = new view.LieferantBearbeiten();
        jifLieferantSuchen = new view.LieferantSuchen();
        jifZKAnlegen = new view.ZKAnlegen();
        jifZKAnzeigen = new view.ZKAnzeigen();
        jifZKBearbeiten = new view.ZKBearbeiten();
        jifZKID_suchen = new view.ZKID_suchen();
        jifZKSuchen = new view.ZKSuchen();
        menuBar = new javax.swing.JMenuBar();
        jmDatei = new javax.swing.JMenu();
        miAbmelden = new javax.swing.JMenuItem();
        miBeenden = new javax.swing.JMenuItem();
        jmAuftrag = new javax.swing.JMenu();
        miAuftragAnlegen = new javax.swing.JMenuItem();
        miAuftragAnzeigen = new javax.swing.JMenuItem();
        miAuftragBearbeiten = new javax.swing.JMenuItem();
        jmStammdaten = new javax.swing.JMenu();
        jmArtikel = new javax.swing.JMenu();
        miArtikelAnlegen = new javax.swing.JMenuItem();
        miArtikelAnzeigen = new javax.swing.JMenuItem();
        miArtikelBearbeiten = new javax.swing.JMenuItem();
        jmKunde = new javax.swing.JMenu();
        miKundeAnlegen = new javax.swing.JMenuItem();
        miKundeAnzeigen = new javax.swing.JMenuItem();
        miKundeBearbeiten = new javax.swing.JMenuItem();
        jmLieferant = new javax.swing.JMenu();
        miLieferantAnlegen = new javax.swing.JMenuItem();
        miLieferantAnzeigen = new javax.swing.JMenuItem();
        miLieferantBearbeiten = new javax.swing.JMenuItem();
        jmKondition = new javax.swing.JMenu();
        miKonditionAnlegen = new javax.swing.JMenuItem();
        miKonditionAnzeigen = new javax.swing.JMenuItem();
        miKonditionBearbeiten = new javax.swing.JMenuItem();
        jmHilfe = new javax.swing.JMenu();
        miInfo = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        Startseite.setPreferredSize(new java.awt.Dimension(1180, 1200));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Willkommen");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel2.setText("Benutzername:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel3.setText("Passwort:");

        jtfBenutzername_Startseite.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jpwpasswort_Startseite.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jbanmelden_Startseite.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jbanmelden_Startseite.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/anmelden.png"))); // NOI18N
        jbanmelden_Startseite.setText("Anmelden");
        jbanmelden_Startseite.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbanmelden_StartseiteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout StartseiteLayout = new javax.swing.GroupLayout(Startseite);
        Startseite.setLayout(StartseiteLayout);
        StartseiteLayout.setHorizontalGroup(
            StartseiteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(StartseiteLayout.createSequentialGroup()
                .addGroup(StartseiteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(StartseiteLayout.createSequentialGroup()
                        .addGap(525, 525, 525)
                        .addComponent(jLabel1))
                    .addGroup(StartseiteLayout.createSequentialGroup()
                        .addGap(407, 407, 407)
                        .addGroup(StartseiteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(28, 28, 28)
                        .addGroup(StartseiteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jpwpasswort_Startseite, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfBenutzername_Startseite, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbanmelden_Startseite, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(1119, Short.MAX_VALUE))
        );
        StartseiteLayout.setVerticalGroup(
            StartseiteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(StartseiteLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(StartseiteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jtfBenutzername_Startseite, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(StartseiteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jpwpasswort_Startseite, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jbanmelden_Startseite, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(670, Short.MAX_VALUE))
        );

        desktopPane.add(Startseite);
        Startseite.setBounds(-3, 0, 1810, 850);

        javax.swing.GroupLayout SeiteZweiLayout = new javax.swing.GroupLayout(SeiteZwei);
        SeiteZwei.setLayout(SeiteZweiLayout);
        SeiteZweiLayout.setHorizontalGroup(
            SeiteZweiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1810, Short.MAX_VALUE)
        );
        SeiteZweiLayout.setVerticalGroup(
            SeiteZweiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1200, Short.MAX_VALUE)
        );

        desktopPane.add(SeiteZwei);
        SeiteZwei.setBounds(0, 0, 1810, 1200);

        jifArtikelSuche.setVisible(false);
        desktopPane.add(jifArtikelSuche);
        jifArtikelSuche.setBounds(0, 0, 966, 714);

        jifArtikelAnzeige.setVisible(false);
        desktopPane.add(jifArtikelAnzeige);
        jifArtikelAnzeige.setBounds(0, 0, 809, 780);

        jifArtikelAnlegen.setVisible(false);
        desktopPane.add(jifArtikelAnlegen);
        jifArtikelAnlegen.setBounds(0, 0, 830, 800);

        jifArtikelBearbeiten.setVisible(false);
        desktopPane.add(jifArtikelBearbeiten);
        jifArtikelBearbeiten.setBounds(0, 0, 890, 770);

        jifAuftragAnlegen.setVisible(false);
        desktopPane.add(jifAuftragAnlegen);
        jifAuftragAnlegen.setBounds(0, 0, 950, 800);

        jifAuftragAnzeigen.setClosable(true);
        jifAuftragAnzeigen.setVisible(false);
        desktopPane.add(jifAuftragAnzeigen);
        jifAuftragAnzeigen.setBounds(0, 0, 900, 800);

        jifAuftragBearbeiten.setVisible(false);
        desktopPane.add(jifAuftragBearbeiten);
        jifAuftragBearbeiten.setBounds(0, 0, 940, 870);

        jifAuftragSuchen.setVisible(false);
        desktopPane.add(jifAuftragSuchen);
        jifAuftragSuchen.setBounds(0, 0, 815, 721);

        jifKundeAnlegen.setVisible(false);
        desktopPane.add(jifKundeAnlegen);
        jifKundeAnlegen.setBounds(0, 0, 966, 738);

        jifKundeAnzeigen.setVisible(false);
        desktopPane.add(jifKundeAnzeigen);
        jifKundeAnzeigen.setBounds(0, 0, 990, 840);

        jifKundeBearbeiten.setVisible(false);
        desktopPane.add(jifKundeBearbeiten);
        jifKundeBearbeiten.setBounds(0, 0, 966, 840);

        jifKundeSuchen.setVisible(false);
        desktopPane.add(jifKundeSuchen);
        jifKundeSuchen.setBounds(0, 0, 966, 840);

        jifLieferantAnlegen.setVisible(false);
        desktopPane.add(jifLieferantAnlegen);
        jifLieferantAnlegen.setBounds(0, 0, 966, 840);

        jifLieferantAnzeigen.setVisible(false);
        desktopPane.add(jifLieferantAnzeigen);
        jifLieferantAnzeigen.setBounds(0, 0, 966, 844);

        jifLieferantBearbeiten.setVisible(false);
        desktopPane.add(jifLieferantBearbeiten);
        jifLieferantBearbeiten.setBounds(0, 0, 967, 840);

        jifLieferantSuchen.setVisible(false);
        desktopPane.add(jifLieferantSuchen);
        jifLieferantSuchen.setBounds(0, 0, 966, 840);

        jifZKAnlegen.setVisible(false);
        desktopPane.add(jifZKAnlegen);
        jifZKAnlegen.setBounds(0, 0, 966, 840);

        jifZKAnzeigen.setVisible(false);
        desktopPane.add(jifZKAnzeigen);
        jifZKAnzeigen.setBounds(0, 0, 966, 840);

        jifZKBearbeiten.setVisible(false);
        desktopPane.add(jifZKBearbeiten);
        jifZKBearbeiten.setBounds(0, 0, 966, 840);

        jifZKID_suchen.setVisible(false);
        desktopPane.add(jifZKID_suchen);
        jifZKID_suchen.setBounds(0, 0, 816, 440);

        jifZKSuchen.setVisible(false);
        desktopPane.add(jifZKSuchen);
        jifZKSuchen.setBounds(0, 0, 966, 840);

        jmDatei.setMnemonic('f');
        jmDatei.setText("Datei");
        jmDatei.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmDateiActionPerformed(evt);
            }
        });

        miAbmelden.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F5, 0));
        miAbmelden.setMnemonic('o');
        miAbmelden.setText("Abmelden");
        miAbmelden.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miAbmeldenActionPerformed(evt);
            }
        });
        jmDatei.add(miAbmelden);

        miBeenden.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ESCAPE, 0));
        miBeenden.setMnemonic('x');
        miBeenden.setText("Beenden");
        miBeenden.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miBeendenActionPerformed(evt);
            }
        });
        jmDatei.add(miBeenden);

        menuBar.add(jmDatei);

        jmAuftrag.setMnemonic('e');
        jmAuftrag.setText("Auftrag");
        jmAuftrag.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmAuftragActionPerformed(evt);
            }
        });

        miAuftragAnlegen.setMnemonic('t');
        miAuftragAnlegen.setText("Anlegen");
        miAuftragAnlegen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miAuftragAnlegenActionPerformed(evt);
            }
        });
        jmAuftrag.add(miAuftragAnlegen);

        miAuftragAnzeigen.setMnemonic('y');
        miAuftragAnzeigen.setText("Anzeigen");
        miAuftragAnzeigen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miAuftragAnzeigenActionPerformed(evt);
            }
        });
        jmAuftrag.add(miAuftragAnzeigen);

        miAuftragBearbeiten.setMnemonic('p');
        miAuftragBearbeiten.setText("Bearbeiten");
        miAuftragBearbeiten.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miAuftragBearbeitenActionPerformed(evt);
            }
        });
        jmAuftrag.add(miAuftragBearbeiten);

        menuBar.add(jmAuftrag);

        jmStammdaten.setText("Stammdaten");
        jmStammdaten.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmStammdatenActionPerformed(evt);
            }
        });

        jmArtikel.setText("Artikel");

        miArtikelAnlegen.setText("Anlegen");
        miArtikelAnlegen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miArtikelAnlegenActionPerformed(evt);
            }
        });
        jmArtikel.add(miArtikelAnlegen);

        miArtikelAnzeigen.setText("Anzeigen");
        miArtikelAnzeigen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miArtikelAnzeigenActionPerformed(evt);
            }
        });
        jmArtikel.add(miArtikelAnzeigen);

        miArtikelBearbeiten.setText("Bearbeiten");
        miArtikelBearbeiten.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miArtikelBearbeitenActionPerformed(evt);
            }
        });
        jmArtikel.add(miArtikelBearbeiten);

        jmStammdaten.add(jmArtikel);

        jmKunde.setText("Kunde");

        miKundeAnlegen.setText("Anlegen");
        miKundeAnlegen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miKundeAnlegenActionPerformed(evt);
            }
        });
        jmKunde.add(miKundeAnlegen);

        miKundeAnzeigen.setText("Anzeigen");
        miKundeAnzeigen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miKundeAnzeigenActionPerformed(evt);
            }
        });
        jmKunde.add(miKundeAnzeigen);

        miKundeBearbeiten.setText("Bearbeiten");
        miKundeBearbeiten.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miKundeBearbeitenActionPerformed(evt);
            }
        });
        jmKunde.add(miKundeBearbeiten);

        jmStammdaten.add(jmKunde);

        jmLieferant.setText("Lieferant");

        miLieferantAnlegen.setText("Anlegen");
        miLieferantAnlegen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miLieferantAnlegenActionPerformed(evt);
            }
        });
        jmLieferant.add(miLieferantAnlegen);

        miLieferantAnzeigen.setText("Anzeigen");
        miLieferantAnzeigen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miLieferantAnzeigenActionPerformed(evt);
            }
        });
        jmLieferant.add(miLieferantAnzeigen);

        miLieferantBearbeiten.setText("Bearbeiten");
        miLieferantBearbeiten.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miLieferantBearbeitenActionPerformed(evt);
            }
        });
        jmLieferant.add(miLieferantBearbeiten);

        jmStammdaten.add(jmLieferant);

        jmKondition.setText("Kondition");

        miKonditionAnlegen.setText("Anlegen");
        miKonditionAnlegen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miKonditionAnlegenActionPerformed(evt);
            }
        });
        jmKondition.add(miKonditionAnlegen);

        miKonditionAnzeigen.setText("Anzeigen");
        miKonditionAnzeigen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miKonditionAnzeigenActionPerformed(evt);
            }
        });
        jmKondition.add(miKonditionAnzeigen);

        miKonditionBearbeiten.setText("Bearbeiten");
        miKonditionBearbeiten.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miKonditionBearbeitenActionPerformed(evt);
            }
        });
        jmKondition.add(miKonditionBearbeiten);

        jmStammdaten.add(jmKondition);

        menuBar.add(jmStammdaten);

        jmHilfe.setMnemonic('h');
        jmHilfe.setText("?");

        miInfo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
        miInfo.setText("Info");
        miInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miInfoActionPerformed(evt);
            }
        });
        jmHilfe.add(miInfo);

        menuBar.add(jmHilfe);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(desktopPane, javax.swing.GroupLayout.PREFERRED_SIZE, 1800, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(desktopPane, javax.swing.GroupLayout.PREFERRED_SIZE, 900, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void miBeendenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miBeendenActionPerformed
//        System.exit(0);
    }//GEN-LAST:event_miBeendenActionPerformed

    private void miAbmeldenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miAbmeldenActionPerformed
        if (istEingeloggt == true) {
            JOptionPane.showMessageDialog(null, ABMELDE_TEXT, ABMELDE_TITEL, JOptionPane.INFORMATION_MESSAGE);
            Startseite.setVisible(true);
        /*----------------------------------------------------------*/
        /* 21.11.16 Samet Variable istEngeloggt wird beim abmelden auf false gesetzt.*/
        /*----------------------------------------------------------*/
            istEingeloggt = false;
        /*----------------------------------------------------------*/
        /* 21.11.16 Samet Variable istEngeloggt, um den Staus des Login zu erfassen
        Bei istEingeloggt=false wird die untesn setehende Fehlermeldung ausgegeben.*/
        /*----------------------------------------------------------*/
        } else {
            JOptionPane.showMessageDialog(null, "Bitte einloggen!");
        }
    }//GEN-LAST:event_miAbmeldenActionPerformed

    private void miAuftragAnzeigenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miAuftragAnzeigenActionPerformed
if (istEingeloggt == true) {
            jifAuftragSuchen.setVisible(true);
            /*----------------------------------------------------------*/
 /* 21.11.16 Samet Variable istEngeloggt, um den Staus des Login zu erfassen
        Bei istEingeloggt=false wird die untesn setehende Fehlermeldung ausgegeben.*/
 /*----------------------------------------------------------*/
        } else {
            JOptionPane.showMessageDialog(null, "Bitte einloggen!");
        }
    }//GEN-LAST:event_miAuftragAnzeigenActionPerformed

    private void miArtikelAnzeigenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miArtikelAnzeigenActionPerformed
            if (istEingeloggt == true) {
            jifArtikelSuche.setVisible(true);
        } /*----------------------------------------------------------*/ /* 21.11.16 Samet Variable istEngeloggt, um den Staus des Login zu erfassen
        Bei istEingeloggt=false wird die untesn setehende Fehlermeldung ausgegeben.*/ /*----------------------------------------------------------*/ else {
            JOptionPane.showMessageDialog(null, "Bitte einloggen!");
        }
    }//GEN-LAST:event_miArtikelAnzeigenActionPerformed

    private void miArtikelAnlegenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miArtikelAnlegenActionPerformed
            if (istEingeloggt == true) {
            jifArtikelAnlegen.setVisible(true);
        } /*----------------------------------------------------------*/ /* 21.11.16 Samet Variable istEngeloggt, um den Staus des Login zu erfassen
        Bei istEingeloggt=false wird die untesn setehende Fehlermeldung ausgegeben.*/ /*----------------------------------------------------------*/ else {
            JOptionPane.showMessageDialog(null, "Bitte einloggen!");
        }
    }//GEN-LAST:event_miArtikelAnlegenActionPerformed

    private void miArtikelBearbeitenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miArtikelBearbeitenActionPerformed
            if (istEingeloggt == true) {
            jifArtikelBearbeiten.setVisible(true);
        } /*----------------------------------------------------------*/ /* 21.11.16 Samet Variable istEngeloggt, um den Staus des Login zu erfassen
        Bei istEingeloggt=false wird die untesn setehende Fehlermeldung ausgegeben.*/ /*----------------------------------------------------------*/ else {
            JOptionPane.showMessageDialog(null, "Bitte einloggen!");
        }
    }//GEN-LAST:event_miArtikelBearbeitenActionPerformed

    private void miAuftragAnlegenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miAuftragAnlegenActionPerformed
           if (istEingeloggt == true) {
            jifAuftragAnlegen.setVisible(true);
        } /*----------------------------------------------------------*/ /* 21.11.16 Samet Variable istEngeloggt, um den Staus des Login zu erfassen
        Bei istEingeloggt=false wird die untesn setehende Fehlermeldung ausgegeben.*/ /*----------------------------------------------------------*/ else {
            JOptionPane.showMessageDialog(null, "Bitte einloggen!");
        }
    }//GEN-LAST:event_miAuftragAnlegenActionPerformed

    private void miAuftragBearbeitenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miAuftragBearbeitenActionPerformed
            if (istEingeloggt) {
            jifAuftragBearbeiten.setVisible(true);
        } /*----------------------------------------------------------*/ /* 21.11.16 Samet Variable istEngeloggt, um den Staus des Login zu erfassen
        Bei istEingeloggt=false wird die untesn setehende Fehlermeldung ausgegeben.*/ /*----------------------------------------------------------*/ else {
            JOptionPane.showMessageDialog(null, "Bitte einloggen!");
        }
    }//GEN-LAST:event_miAuftragBearbeitenActionPerformed

    private void miLieferantAnzeigenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miLieferantAnzeigenActionPerformed
            if (istEingeloggt == true) {
            jifLieferantAnzeigen.setVisible(true);
        } /*----------------------------------------------------------*/ 
        /* 21.11.16 Samet Variable istEngeloggt, um den Staus des Login zu erfassen
        Bei istEingeloggt=false wird die untesn setehende Fehlermeldung ausgegeben.*/ 
        /*----------------------------------------------------------*/ 
        else {
            JOptionPane.showMessageDialog(null, "Bitte einloggen!");
        }
    }//GEN-LAST:event_miLieferantAnzeigenActionPerformed

    private void miLieferantAnlegenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miLieferantAnlegenActionPerformed
            if (istEingeloggt == true) {
            jifLieferantAnlegen.setVisible(true);
        } /*----------------------------------------------------------*/ 
        /* 21.11.16 Samet Variable istEngeloggt, um den Staus des Login zu erfassen
        Bei istEingeloggt=false wird die untesn setehende Fehlermeldung ausgegeben.*/ 
        /*----------------------------------------------------------*/ 
        else {
            JOptionPane.showMessageDialog(null, "Bitte einloggen!");
        }
    }//GEN-LAST:event_miLieferantAnlegenActionPerformed

    private void miLieferantBearbeitenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miLieferantBearbeitenActionPerformed
            if (istEingeloggt == true) {
            jifLieferantBearbeiten.setVisible(true);
        } /*----------------------------------------------------------*/ 
        /* 21.11.16 Samet Variable istEngeloggt, um den Staus des Login zu erfassen
        Bei istEingeloggt=false wird die untesn setehende Fehlermeldung ausgegeben.*/ 
        /*----------------------------------------------------------*/ 
        else {
            JOptionPane.showMessageDialog(null, "Bitte einloggen!");
        }
    }//GEN-LAST:event_miLieferantBearbeitenActionPerformed

    private void miKundeAnzeigenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miKundeAnzeigenActionPerformed
            if (istEingeloggt == true) {
            jifKundeAnzeigen.setVisible(true);
        } 
        /*----------------------------------------------------------*/ 
        /* 21.11.16 Samet Variable istEngeloggt, um den Staus des Login zu erfassen
        Bei istEingeloggt=false wird die untesn setehende Fehlermeldung ausgegeben.*/ 
        /*----------------------------------------------------------*/ 
        else {
            JOptionPane.showMessageDialog(null, "Bitte einloggen!");
        }
    }//GEN-LAST:event_miKundeAnzeigenActionPerformed

    private void miKundeAnlegenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miKundeAnlegenActionPerformed
            if (istEingeloggt == true) {
            jifKundeAnlegen.setVisible(true);
            //Blendet Lieferdaten aus  
            KundeAnlegen.jPLieferdaten.setVisible(false);
        } 
        /*----------------------------------------------------------*/ 
        /* 21.11.16 Samet Variable istEngeloggt, um den Staus des Login zu erfassen
        Bei istEingeloggt=false wird die untesn setehende Fehlermeldung ausgegeben.*/ 
        /*----------------------------------------------------------*/ 
        else {
            JOptionPane.showMessageDialog(null, "Bitte einloggen!");
        }
    }//GEN-LAST:event_miKundeAnlegenActionPerformed

    private void miKundeBearbeitenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miKundeBearbeitenActionPerformed
            if (istEingeloggt == true) {
            jifKundeBearbeiten.setVisible(true);
        } 
        /*----------------------------------------------------------*/ 
        /* 21.11.16 Samet Variable istEngeloggt, um den Staus des Login zu erfassen
        Bei istEingeloggt=false wird die untesn setehende Fehlermeldung ausgegeben.*/ 
        /*----------------------------------------------------------*/ 
        else {
            JOptionPane.showMessageDialog(null, "Bitte einloggen!");
        }
    }//GEN-LAST:event_miKundeBearbeitenActionPerformed

    private void miKonditionAnzeigenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miKonditionAnzeigenActionPerformed
            if (istEingeloggt == true) {
            jifZKAnzeigen.setVisible(true);
        } /*----------------------------------------------------------*/ /* 21.11.16 Samet Variable istEngeloggt, um den Staus des Login zu erfassen
        Bei istEingeloggt=false wird die untesn setehende Fehlermeldung ausgegeben.*/ /*----------------------------------------------------------*/ else {
            JOptionPane.showMessageDialog(null, "Bitte einloggen!");
        }
    }//GEN-LAST:event_miKonditionAnzeigenActionPerformed

    private void miKonditionAnlegenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miKonditionAnlegenActionPerformed
            if (istEingeloggt == true) {
            jifZKAnlegen.setVisible(true);
        } /*----------------------------------------------------------*/ /* 21.11.16 Samet Variable istEngeloggt, um den Staus des Login zu erfassen
        Bei istEingeloggt=false wird die untesn setehende Fehlermeldung ausgegeben.*/ /*----------------------------------------------------------*/ else {
            JOptionPane.showMessageDialog(null, "Bitte einloggen!");
        }
    }//GEN-LAST:event_miKonditionAnlegenActionPerformed

    private void miKonditionBearbeitenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miKonditionBearbeitenActionPerformed
            if (istEingeloggt == true) {
            jifZKBearbeiten.setVisible(true);
        } /*----------------------------------------------------------*/ /* 21.11.16 Samet Variable istEngeloggt, um den Staus des Login zu erfassen
        Bei istEingeloggt=false wird die untesn setehende Fehlermeldung ausgegeben.*/ /*----------------------------------------------------------*/ else {
            JOptionPane.showMessageDialog(null, "Bitte einloggen!");
        }
    }//GEN-LAST:event_miKonditionBearbeitenActionPerformed

    private void jmDateiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmDateiActionPerformed
            if (istEingeloggt == true) {
        } else {
            JOptionPane.showMessageDialog(null, "Sie müssen eingeloggt sein, um sich abmelden zu können !");
        }
    }//GEN-LAST:event_jmDateiActionPerformed

    private void jmAuftragActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmAuftragActionPerformed
                if (istEingeloggt == true) {
        }/*----------------------------------------------------------*/ 
        /* 21.11.16 Samet Variable istEngeloggt, um den Staus des Login zu erfassen
        Bei istEingeloggt=false wird die untesn setehende Fehlermeldung ausgegeben.*/ 
        /*----------------------------------------------------------*/ else {
            JOptionPane.showMessageDialog(null, "Bitte einloggen!");
        }
    }//GEN-LAST:event_jmAuftragActionPerformed

    private void jmStammdatenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmStammdatenActionPerformed
                if (istEingeloggt == true) {
        }/*----------------------------------------------------------*/ 
         /* 21.11.16 Samet Variable istEngeloggt, um den Staus des Login zu erfassen
        Bei istEingeloggt=false wird die untesn setehende Fehlermeldung ausgegeben.*/ 
        /*----------------------------------------------------------*/ else {
            JOptionPane.showMessageDialog(null, "Bitte einloggen!");
        }
    }//GEN-LAST:event_jmStammdatenActionPerformed

    private void jbanmelden_StartseiteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbanmelden_StartseiteActionPerformed
        /* Mechmet Impram 24.11.2016
        Hier werden BN und Passwort mit eingelegte Benutzer auf Richtigkeit vergleichen
        wenn richtig, die Fenster anzeigen, solange muss die Menu invisible sein.
        */
        if(istVollstaendig()){
        Startseite.setVisible(false);
        SeiteZwei.setVisible(true);
        istEingeloggt = true;
        }
    }//GEN-LAST:event_jbanmelden_StartseiteActionPerformed

    private void miInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miInfoActionPerformed
        //27.11.2016 Impram
        JOptionPane.showMessageDialog(null, INFO_TEXT, INFO_TITEL, JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_miInfoActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
//01.12.2016 Impram Wenn man auf Seite Schliessen Betaätigt erscheint eine meldung
        int antwort = JOptionPane.showConfirmDialog(this, BEENDE_TEXT, BEENDE_TITEL, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if( antwort == JOptionPane.YES_OPTION) {

        }     
    }//GEN-LAST:event_formWindowClosing

    //Impram Mehmet 25.11.2016
    //Überprüft auf der Startseite die Felder. Benutzername und Passwortfeld wird als
    //Pflichtfeld gesetzt.Wenn das nicht gefüllt ist erscheint eine Fehlermeldung.
    public boolean istVollstaendig(){
        Boolean vollstaendig = false;
        String fehlermeldung = "";
        if(jtfBenutzername_Startseite.getText().equals("")) {
            fehlermeldung = "Geben Sie bitte Ihren Benutzernamen und das zugehörige Passwort an.";
            jtfBenutzername_Startseite.requestFocusInWindow();
        }else if (jpwpasswort_Startseite.getText().equals("")){
            fehlermeldung = "Geben Sie das Passwort ein";
            jpwpasswort_Startseite.requestFocusInWindow();
        }
        if(fehlermeldung.equals("")){
            vollstaendig = true;
        }else{
            JOptionPane.showMessageDialog(this, fehlermeldung,"Unvollständig" ,JOptionPane.WARNING_MESSAGE);
        }return vollstaendig;
    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(StartAV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StartAV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StartAV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StartAV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StartAV().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel SeiteZwei;
    private javax.swing.JPanel Startseite;
    private javax.swing.JDesktopPane desktopPane;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton jbanmelden_Startseite;
    private view.ArtikelAnlegen jifArtikelAnlegen;
    private view.ArtikelAnzeigen jifArtikelAnzeige;
    private view.ArtikelBearbeiten jifArtikelBearbeiten;
    private view.ArtikelSuchen jifArtikelSuche;
    private view.AuftragAnlegen jifAuftragAnlegen;
    private view.AuftragAnzeigen jifAuftragAnzeigen;
    private view.AuftragBearbeiten jifAuftragBearbeiten;
    private view.AuftragSuchen jifAuftragSuchen;
    private view.KundeAnlegen jifKundeAnlegen;
    private view.KundeAnzeigen jifKundeAnzeigen;
    private view.KundeBearbeiten jifKundeBearbeiten;
    private view.KundeSuchen jifKundeSuchen;
    private view.LieferantAnlegen jifLieferantAnlegen;
    private view.LieferantAnzeigen jifLieferantAnzeigen;
    private view.LieferantBearbeiten jifLieferantBearbeiten;
    private view.LieferantSuchen jifLieferantSuchen;
    private view.ZKAnlegen jifZKAnlegen;
    private view.ZKAnzeigen jifZKAnzeigen;
    private view.ZKBearbeiten jifZKBearbeiten;
    private view.ZKID_suchen jifZKID_suchen;
    private view.ZKSuchen jifZKSuchen;
    private javax.swing.JMenu jmArtikel;
    private javax.swing.JMenu jmAuftrag;
    private javax.swing.JMenu jmDatei;
    private javax.swing.JMenu jmHilfe;
    private javax.swing.JMenu jmKondition;
    private javax.swing.JMenu jmKunde;
    private javax.swing.JMenu jmLieferant;
    private javax.swing.JMenu jmStammdaten;
    private javax.swing.JPasswordField jpwpasswort_Startseite;
    private javax.swing.JTextField jtfBenutzername_Startseite;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem miAbmelden;
    private javax.swing.JMenuItem miArtikelAnlegen;
    private javax.swing.JMenuItem miArtikelAnzeigen;
    private javax.swing.JMenuItem miArtikelBearbeiten;
    private javax.swing.JMenuItem miAuftragAnlegen;
    private javax.swing.JMenuItem miAuftragAnzeigen;
    private javax.swing.JMenuItem miAuftragBearbeiten;
    private javax.swing.JMenuItem miBeenden;
    private javax.swing.JMenuItem miInfo;
    private javax.swing.JMenuItem miKonditionAnlegen;
    private javax.swing.JMenuItem miKonditionAnzeigen;
    private javax.swing.JMenuItem miKonditionBearbeiten;
    private javax.swing.JMenuItem miKundeAnlegen;
    private javax.swing.JMenuItem miKundeAnzeigen;
    private javax.swing.JMenuItem miKundeBearbeiten;
    private javax.swing.JMenuItem miLieferantAnlegen;
    private javax.swing.JMenuItem miLieferantAnzeigen;
    private javax.swing.JMenuItem miLieferantBearbeiten;
    // End of variables declaration//GEN-END:variables

}
