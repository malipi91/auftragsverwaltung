/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Toolkit;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import javax.swing.text.PlainDocument;

/*----------------------------------------------------------*/
/* Datum    Name    Was */
/* 11.11.16 Impram  angelegt */
/* 11.11.16 Yoeruek angelegt */
/* 16.11.16 Citak   angelegt */
/*----------------------------------------------------------*/



public class StartAV extends javax.swing.JFrame {

    //Mehmet Impram 
    private final String ABMELDE_TITEL = "ABMELDEN";
    private final String ABMELDE_TEXT = "Möchten Sie wirklich abmelden";
    //Mehmet Impram 27.11.2016
    private final String INFO_TITEL = "Info zum Anmelden auf das System";
    private final String INFO_TEXT = "Bei Benutzername & Passwort geben sie min. 1 Buchstaben ein ";
    boolean istEingeloggt = false;
    private Object view;

    /**
     * Creates new form StartAV
     */
    private static class sindZErlaubt {
        public sindZErlaubt() {
        }
    }

    private static class sindBErlaubt {
        public sindBErlaubt() {
        }
    }
    // Mechmet Impram
    private DefaultFormatterFactory erstelleMF(String schablone) {
        DefaultFormatterFactory dffmf = null;
        MaskFormatter mf = null;
        try {
            mf = new MaskFormatter(schablone);
            mf.setOverwriteMode(true);
            mf.setAllowsInvalid(false);
            mf.setCommitsOnValidEdit(true);
            mf.setValueContainsLiteralCharacters(false);
            dffmf = new DefaultFormatterFactory(mf);
        } catch (ParseException ex) {
        }
        return dffmf;
    }

    public StartAV() {
        initComponents();
        //Startseite
        // Mechmet Impram
//Benutzername Feld akzeptiert nur Buchstaben.
        jtfBenutzername_Startseite.setDocument(new UniversalDokument(true, false, "-. ' ", -1));
        // Mechmet Impram
//Passwort Feld ebenso akzeptiert nur Buchstaben.        
        jpwpasswort_Startseite.setDocument((new UniversalDokument(true, false, "-. ' ", -1)));

    }
/*------------------------------------------------------------*/
/* 29.11.16 Yoeruek Methode zum Aufrufen der einzelnen Masken */
/*------------------------------------------------------------*/
    public void oeffneAuftragIDSuchen() {
        jifAuftragsID_suchen.setVisible(true);
    }
    
/*------------------------------------------------------------*/
/* 29.11.16 Yoeruek Methode zum Aufrufen der einzelnen Masken */
/*------------------------------------------------------------*/
    public void oeffneGPIDSuchen(){
        jifGPID_suchen.setVisible(true);
    }
    
/*------------------------------------------------------------*/
/* 30.11.16 Yoeruek Methode zum Aufrufen der einzelnen Masken */
/*------------------------------------------------------------*/
    public void oeffneArtikelIDSuchen(){
        jifArtikelID_suchen.setVisible(true);
    }
    
/*------------------------------------------------------------*/
/* 30.11.16 Yoeruek Methode zum Aufrufen der einzelnen Masken */
/*------------------------------------------------------------*/
    public void oeffneZKIDSuchen(){
        jifZKID_suchen.setVisible(true);
    }
    

    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jPopupMenu1 = new javax.swing.JPopupMenu();
        desktopPane = new javax.swing.JDesktopPane();
        SeiteZwei = new javax.swing.JPanel();
        Startseite = new javax.swing.JPanel();
        jtfBenutzername_Startseite = new javax.swing.JTextField();
        jpwpasswort_Startseite = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jbanmelden_Startseite = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JSeparator();
        jifArtikelAnlegen = new view.ArtikelAnlegen();
        jifGPID_suchen = new view.GPID_suchen(this);
        jifArtikelID_suchen = new view.ArtikelID_suchen(this);
        jifArtikelAnzeige = new view.ArtikelAnzeige(this);
        jifArtikelBearbeiten = new view.ArtikelBearbeiten(this);
        jifArtikelSuche = new view.ArtikelSuche();
        jifAuftraegeAlle = new view.AuftraegeAlle();
        jifAuftragAnlegen = new view.AuftragAnlegen(this);
        jifAuftragAnzeigen = new view.AuftragAnzeigen(this);
        jifAuftragBearbeiten = new view.AuftragBearbeiten();
        jifAuftragSuchen = new view.AuftragSuchen(this);
        jifAuftragsID_suchen = new view.AuftragsID_suchen(this);
        jifKundeAnlegen = new view.KundeAnlegen();
        jifKundeAnzeigen = new view.KundeAnzeigen(this);
        jifKundeBearbeiten = new view.KundeBearbeiten();
        jifKundeSuchen = new view.KundeSuchen();
        jifLieferantAnlegen = new view.LieferantAnlegen();
        jifLieferantAnzeigen = new view.LieferantAnzeigen(this);
        jifLieferantBearbeiten = new view.LieferantBearbeiten();
        jifLieferantSuchen = new view.LieferantSuchen();
        jifZKAnlegen = new view.ZKAnlegen();
        jifZKAnzeigen = new view.ZKAnzeigen(this);
        jifZKBearbeiten = new view.ZKBearbeiten(this);
        jifZKID_suchen = new view.ZKID_suchen();
        jifZKSuchen = new view.ZKSuchen();
        menuBar = new javax.swing.JMenuBar();
        jmDatei = new javax.swing.JMenu();
        miAbmelden = new javax.swing.JMenuItem();
        miBeenden = new javax.swing.JMenuItem();
        jmAuftrag = new javax.swing.JMenu();
        miGesamtAuftraege = new javax.swing.JMenuItem();
        miAuftraganzeigen = new javax.swing.JMenuItem();
        miAuftraganlegen = new javax.swing.JMenuItem();
        miAuftragbearbeiten = new javax.swing.JMenuItem();
        jmArtikel = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        miArtikelanzeigen = new javax.swing.JMenuItem();
        miArtikelanlegen = new javax.swing.JMenuItem();
        miArtikelbearbeiten = new javax.swing.JMenuItem();
        jmSuche = new javax.swing.JMenu();
        miAuftragSuche = new javax.swing.JMenuItem();
        miArtikelSuche = new javax.swing.JMenuItem();
        miLieferantSuche = new javax.swing.JMenuItem();
        miKundeSuche = new javax.swing.JMenuItem();
        miZKSuche = new javax.swing.JMenuItem();
        jmGeschäftspartner = new javax.swing.JMenu();
        jmLieferant = new javax.swing.JMenu();
        miLieferantanzeigen = new javax.swing.JMenuItem();
        miLieferantanlegen = new javax.swing.JMenuItem();
        miLieferantbearbeiten = new javax.swing.JMenuItem();
        jmKunde = new javax.swing.JMenu();
        miKundeanzeigen = new javax.swing.JMenuItem();
        miKundeanlegen = new javax.swing.JMenuItem();
        miKundebearbeiten = new javax.swing.JMenuItem();
        jmZahlungskondition = new javax.swing.JMenu();
        miZKAnzeigen = new javax.swing.JMenuItem();
        miZKAnlegen = new javax.swing.JMenuItem();
        miZKBearbeiten = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImages(null);
        setMinimumSize(new java.awt.Dimension(1400, 1000));

        desktopPane.setInheritsPopupMenu(true);

        SeiteZwei.setPreferredSize(new java.awt.Dimension(2000, 1100));

        Startseite.setMaximumSize(new java.awt.Dimension(2147483647, 2147483647));
        Startseite.setMinimumSize(new java.awt.Dimension(1400, 1000));
        Startseite.setPreferredSize(new java.awt.Dimension(1200, 800));
        Startseite.setRequestFocusEnabled(false);

        jtfBenutzername_Startseite.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jpwpasswort_Startseite.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jpwpasswort_Startseite.setText("jPasswordField1");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel3.setText("Passwort");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel4.setText("Benutzername");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel6.setText("Willkommen");

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
            .addGroup(StartseiteLayout.createSequentialGroup()
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 1175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(StartseiteLayout.createSequentialGroup()
                .addGap(460, 460, 460)
                .addGroup(StartseiteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addGroup(StartseiteLayout.createSequentialGroup()
                        .addGroup(StartseiteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(StartseiteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jbanmelden_Startseite, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfBenutzername_Startseite, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jpwpasswort_Startseite, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        StartseiteLayout.setVerticalGroup(
            StartseiteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(StartseiteLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(StartseiteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jtfBenutzername_Startseite, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(StartseiteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jpwpasswort_Startseite, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jbanmelden_Startseite, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout SeiteZweiLayout = new javax.swing.GroupLayout(SeiteZwei);
        SeiteZwei.setLayout(SeiteZweiLayout);
        SeiteZweiLayout.setHorizontalGroup(
            SeiteZweiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SeiteZweiLayout.createSequentialGroup()
                .addComponent(Startseite, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 800, Short.MAX_VALUE))
        );
        SeiteZweiLayout.setVerticalGroup(
            SeiteZweiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SeiteZweiLayout.createSequentialGroup()
                .addComponent(Startseite, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 300, Short.MAX_VALUE))
        );

        desktopPane.add(SeiteZwei);
        SeiteZwei.setBounds(0, 0, 2000, 1100);

        jifArtikelAnlegen.setVisible(false);
        desktopPane.add(jifArtikelAnlegen);
        jifArtikelAnlegen.setBounds(0, 0, 966, 833);

        jifGPID_suchen.setVisible(false);
        desktopPane.add(jifGPID_suchen);
<<<<<<< HEAD
        jifGPID_suchen.setBounds(0, 0, 660, 489);
=======
        jifGPID_suchen.setBounds(0, 0, 660, 482);
>>>>>>> origin/mehmet

        jifArtikelID_suchen.setClosable(true);
        jifArtikelID_suchen.setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        jifArtikelID_suchen.setVisible(false);
        desktopPane.add(jifArtikelID_suchen);
        jifArtikelID_suchen.setBounds(0, 0, 784, 634);

        jifArtikelAnzeige.setVisible(false);
        desktopPane.add(jifArtikelAnzeige);
        jifArtikelAnzeige.setBounds(0, 0, 995, 833);

        jifArtikelBearbeiten.setVisible(false);
        desktopPane.add(jifArtikelBearbeiten);
        jifArtikelBearbeiten.setBounds(0, 0, 966, 833);

        jifArtikelSuche.setVisible(false);
        desktopPane.add(jifArtikelSuche);
        jifArtikelSuche.setBounds(0, 0, 966, 833);

        jifAuftraegeAlle.setVisible(false);
        desktopPane.add(jifAuftraegeAlle);
        jifAuftraegeAlle.setBounds(0, 0, 966, 833);

        jifAuftragAnlegen.setVisible(false);
        desktopPane.add(jifAuftragAnlegen);
<<<<<<< HEAD
        jifAuftragAnlegen.setBounds(0, 0, 966, 844);

        jifAuftragAnzeigen.setVisible(false);
        desktopPane.add(jifAuftragAnzeigen);
        jifAuftragAnzeigen.setBounds(0, 0, 966, 848);

        jifAuftragBearbeiten.setVisible(false);
        desktopPane.add(jifAuftragBearbeiten);
        jifAuftragBearbeiten.setBounds(0, 0, 1174, 877);

        jifAuftragSuchen.setVisible(false);
        desktopPane.add(jifAuftragSuchen);
        jifAuftragSuchen.setBounds(0, 0, 966, 847);
=======
        jifAuftragAnlegen.setBounds(0, 0, 966, 833);

        jifAuftragAnzeigen.setVisible(false);
        desktopPane.add(jifAuftragAnzeigen);
        jifAuftragAnzeigen.setBounds(0, 0, 966, 837);

        jifAuftragBearbeiten.setVisible(false);
        desktopPane.add(jifAuftragBearbeiten);
        jifAuftragBearbeiten.setBounds(0, 0, 1174, 870);

        jifAuftragSuchen.setVisible(false);
        desktopPane.add(jifAuftragSuchen);
        jifAuftragSuchen.setBounds(0, 0, 966, 836);
>>>>>>> origin/mehmet

        jifAuftragsID_suchen.setVisible(false);
        desktopPane.add(jifAuftragsID_suchen);
        jifAuftragsID_suchen.setBounds(0, 0, 953, 495);

        jifKundeAnlegen.setVisible(false);
        desktopPane.add(jifKundeAnlegen);
<<<<<<< HEAD
        jifKundeAnlegen.setBounds(0, 0, 966, 736);

        jifKundeAnzeigen.setVisible(false);
        desktopPane.add(jifKundeAnzeigen);
        jifKundeAnzeigen.setBounds(0, 0, 990, 840);
=======
        jifKundeAnlegen.setBounds(0, 0, 1029, 717);

        jifKundeAnzeigen.setVisible(false);
        desktopPane.add(jifKundeAnzeigen);
        jifKundeAnzeigen.setBounds(0, 0, 966, 833);
>>>>>>> origin/mehmet

        jifKundeBearbeiten.setVisible(false);
        desktopPane.add(jifKundeBearbeiten);
        jifKundeBearbeiten.setBounds(0, 0, 966, 833);

        jifKundeSuchen.setVisible(false);
        desktopPane.add(jifKundeSuchen);
        jifKundeSuchen.setBounds(0, 0, 966, 833);

        jifLieferantAnlegen.setVisible(false);
        desktopPane.add(jifLieferantAnlegen);
        jifLieferantAnlegen.setBounds(0, 0, 966, 837);

        jifLieferantAnzeigen.setVisible(false);
        desktopPane.add(jifLieferantAnzeigen);
<<<<<<< HEAD
        jifLieferantAnzeigen.setBounds(0, 0, 966, 844);
=======
        jifLieferantAnzeigen.setBounds(0, 0, 966, 837);
>>>>>>> origin/mehmet

        jifLieferantBearbeiten.setVisible(false);
        desktopPane.add(jifLieferantBearbeiten);
        jifLieferantBearbeiten.setBounds(0, 0, 967, 833);

        jifLieferantSuchen.setVisible(false);
        desktopPane.add(jifLieferantSuchen);
        jifLieferantSuchen.setBounds(0, 0, 966, 833);

        jifZKAnlegen.setVisible(false);
        desktopPane.add(jifZKAnlegen);
        jifZKAnlegen.setBounds(0, 0, 966, 833);

        jifZKAnzeigen.setVisible(false);
        desktopPane.add(jifZKAnzeigen);
        jifZKAnzeigen.setBounds(0, 0, 966, 833);

        jifZKBearbeiten.setVisible(false);
        desktopPane.add(jifZKBearbeiten);
        jifZKBearbeiten.setBounds(0, 0, 966, 833);

        jifZKID_suchen.setVisible(false);
        desktopPane.add(jifZKID_suchen);
        jifZKID_suchen.setBounds(0, 0, 816, 433);

        jifZKSuchen.setVisible(false);
        desktopPane.add(jifZKSuchen);
        jifZKSuchen.setBounds(0, 0, 966, 833);

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

        miGesamtAuftraege.setText("Gesamt Aufträge");
        miGesamtAuftraege.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miGesamtAuftraegeActionPerformed(evt);
            }
        });
        jmAuftrag.add(miGesamtAuftraege);

        miAuftraganzeigen.setText("Anzeigen");
        miAuftraganzeigen.setToolTipText("");
        miAuftraganzeigen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miAuftraganzeigenActionPerformed(evt);
            }
        });
        jmAuftrag.add(miAuftraganzeigen);

        miAuftraganlegen.setMnemonic('t');
        miAuftraganlegen.setText("Anlegen");
        miAuftraganlegen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miAuftraganlegenActionPerformed(evt);
            }
        });
        jmAuftrag.add(miAuftraganlegen);

        miAuftragbearbeiten.setMnemonic('y');
        miAuftragbearbeiten.setText("Bearbeiten");
        miAuftragbearbeiten.setToolTipText("");
        miAuftragbearbeiten.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miAuftragbearbeitenActionPerformed(evt);
            }
        });
        jmAuftrag.add(miAuftragbearbeiten);

        menuBar.add(jmAuftrag);

        jmArtikel.setMnemonic('h');
        jmArtikel.setText("Artikel");
        jmArtikel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmArtikelActionPerformed(evt);
            }
        });

        jMenuItem1.setText("Gesamt Artikeln");
        jmArtikel.add(jMenuItem1);

        miArtikelanzeigen.setText("Anzeigen");
        miArtikelanzeigen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miArtikelanzeigenActionPerformed(evt);
            }
        });
        jmArtikel.add(miArtikelanzeigen);

        miArtikelanlegen.setMnemonic('c');
        miArtikelanlegen.setText("Anlegen");
        miArtikelanlegen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miArtikelanlegenActionPerformed(evt);
            }
        });
        jmArtikel.add(miArtikelanlegen);

        miArtikelbearbeiten.setMnemonic('a');
        miArtikelbearbeiten.setText("Bearbeiten");
        miArtikelbearbeiten.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miArtikelbearbeitenActionPerformed(evt);
            }
        });
        jmArtikel.add(miArtikelbearbeiten);

        menuBar.add(jmArtikel);

        jmSuche.setText("Suche");
        jmSuche.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmSucheActionPerformed(evt);
            }
        });

        miAuftragSuche.setText("Auftrag");
        miAuftragSuche.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miAuftragSucheActionPerformed(evt);
            }
        });
        jmSuche.add(miAuftragSuche);

        miArtikelSuche.setText("Artikel");
        miArtikelSuche.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miArtikelSucheActionPerformed(evt);
            }
        });
        jmSuche.add(miArtikelSuche);

        miLieferantSuche.setText("Lieferant");
        miLieferantSuche.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miLieferantSucheActionPerformed(evt);
            }
        });
        jmSuche.add(miLieferantSuche);

        miKundeSuche.setText("Kunde");
        miKundeSuche.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miKundeSucheActionPerformed(evt);
            }
        });
        jmSuche.add(miKundeSuche);

        miZKSuche.setText("Zahlungskondition");
        miZKSuche.setToolTipText("");
        miZKSuche.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miZKSucheActionPerformed(evt);
            }
        });
        jmSuche.add(miZKSuche);

        menuBar.add(jmSuche);

        jmGeschäftspartner.setText("Geschäftspartner");

        jmLieferant.setText("Lieferant");

        miLieferantanzeigen.setText("Anzeigen");
        miLieferantanzeigen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miLieferantanzeigenActionPerformed(evt);
            }
        });
        jmLieferant.add(miLieferantanzeigen);

        miLieferantanlegen.setText("Anlegen");
        miLieferantanlegen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miLieferantanlegenActionPerformed(evt);
            }
        });
        jmLieferant.add(miLieferantanlegen);

        miLieferantbearbeiten.setText("Bearbeiten");
        miLieferantbearbeiten.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miLieferantbearbeitenActionPerformed(evt);
            }
        });
        jmLieferant.add(miLieferantbearbeiten);

        jmGeschäftspartner.add(jmLieferant);

        jmKunde.setText("Kunde");

        miKundeanzeigen.setText("Anzeigen");
        miKundeanzeigen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miKundeanzeigenActionPerformed(evt);
            }
        });
        jmKunde.add(miKundeanzeigen);

        miKundeanlegen.setText("Anlegen");
        miKundeanlegen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miKundeanlegenActionPerformed(evt);
            }
        });
        jmKunde.add(miKundeanlegen);

        miKundebearbeiten.setText("Bearbeiten");
        miKundebearbeiten.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miKundebearbeitenActionPerformed(evt);
            }
        });
        jmKunde.add(miKundebearbeiten);

        jmGeschäftspartner.add(jmKunde);

        menuBar.add(jmGeschäftspartner);

        jmZahlungskondition.setText("Zahlungskondition");

        miZKAnzeigen.setText("Anzeigen");
        miZKAnzeigen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miZKAnzeigenActionPerformed(evt);
            }
        });
        jmZahlungskondition.add(miZKAnzeigen);

        miZKAnlegen.setText("Anlegen");
        miZKAnlegen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miZKAnlegenActionPerformed(evt);
            }
        });
        jmZahlungskondition.add(miZKAnlegen);

        miZKBearbeiten.setText("Bearbeiten");
        miZKBearbeiten.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miZKBearbeitenActionPerformed(evt);
            }
        });
        jmZahlungskondition.add(miZKBearbeiten);

        menuBar.add(jmZahlungskondition);

        jMenu1.setText("?");

        jMenuItem2.setText("Info");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        menuBar.add(jMenu1);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 1200, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 974, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void miBeendenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miBeendenActionPerformed
        System.exit(0);
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

    private void miAuftraganzeigenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miAuftraganzeigenActionPerformed
    if (istEingeloggt == true) {
            jifAuftragAnzeigen.setVisible(true);
            /*----------------------------------------------------------*/
 /* 21.11.16 Samet Variable istEngeloggt, um den Staus des Login zu erfassen
        Bei istEingeloggt=false wird die untesn setehende Fehlermeldung ausgegeben.*/
 /*----------------------------------------------------------*/
        } else {
            JOptionPane.showMessageDialog(null, "Bitte einloggen!");
        }
    }//GEN-LAST:event_miAuftraganzeigenActionPerformed

    private void miAuftragSucheActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miAuftragSucheActionPerformed
        if (istEingeloggt == true) {
            jifAuftragSuchen.setVisible(true);
        } /*----------------------------------------------------------*/ /* 21.11.16 Samet Variable istEngeloggt, um den Staus des Login zu erfassen
        Bei istEingeloggt=false wird die untesn setehende Fehlermeldung ausgegeben.*/ /*----------------------------------------------------------*/ else {
            JOptionPane.showMessageDialog(null, "Bitte einloggen!");
        }
    }//GEN-LAST:event_miAuftragSucheActionPerformed

    private void miArtikelSucheActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miArtikelSucheActionPerformed
        if (istEingeloggt == true) {
            jifArtikelSuche.setVisible(true);
            //Verbindung von Artikel Suche zu Artikel Anzeigen über Button
            jifArtikelSuche.setArtikelAnzeige(jifArtikelAnzeige);
        } /*----------------------------------------------------------*/ /* 21.11.16 Samet Variable istEngeloggt, um den Staus des Login zu erfassen
        Bei istEingeloggt=false wird die untesn setehende Fehlermeldung ausgegeben.*/ /*----------------------------------------------------------*/ else {
            JOptionPane.showMessageDialog(null, "Bitte einloggen!");
        }
    }//GEN-LAST:event_miArtikelSucheActionPerformed

    private void miArtikelanzeigenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miArtikelanzeigenActionPerformed
        if (istEingeloggt == true) {
            jifArtikelAnzeige.setVisible(true);
        } /*----------------------------------------------------------*/ /* 21.11.16 Samet Variable istEngeloggt, um den Staus des Login zu erfassen
        Bei istEingeloggt=false wird die untesn setehende Fehlermeldung ausgegeben.*/ /*----------------------------------------------------------*/ else {
            JOptionPane.showMessageDialog(null, "Bitte einloggen!");
        }
    }//GEN-LAST:event_miArtikelanzeigenActionPerformed

    private void miArtikelanlegenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miArtikelanlegenActionPerformed
        if (istEingeloggt == true) {
            jifArtikelAnlegen.setVisible(true);
        } /*----------------------------------------------------------*/ /* 21.11.16 Samet Variable istEngeloggt, um den Staus des Login zu erfassen
        Bei istEingeloggt=false wird die untesn setehende Fehlermeldung ausgegeben.*/ /*----------------------------------------------------------*/ else {
            JOptionPane.showMessageDialog(null, "Bitte einloggen!");
        }
    }//GEN-LAST:event_miArtikelanlegenActionPerformed

    private void miArtikelbearbeitenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miArtikelbearbeitenActionPerformed
        if (istEingeloggt == true) {
            jifArtikelBearbeiten.setVisible(true);
        } /*----------------------------------------------------------*/ /* 21.11.16 Samet Variable istEngeloggt, um den Staus des Login zu erfassen
        Bei istEingeloggt=false wird die untesn setehende Fehlermeldung ausgegeben.*/ /*----------------------------------------------------------*/ else {
            JOptionPane.showMessageDialog(null, "Bitte einloggen!");
        }
    }//GEN-LAST:event_miArtikelbearbeitenActionPerformed

    private void miAuftraganlegenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miAuftraganlegenActionPerformed
        if (istEingeloggt == true) {
            jifAuftragAnlegen.setVisible(true);
        } /*----------------------------------------------------------*/ /* 21.11.16 Samet Variable istEngeloggt, um den Staus des Login zu erfassen
        Bei istEingeloggt=false wird die untesn setehende Fehlermeldung ausgegeben.*/ /*----------------------------------------------------------*/ else {
            JOptionPane.showMessageDialog(null, "Bitte einloggen!");
        }
    }//GEN-LAST:event_miAuftraganlegenActionPerformed

    private void miAuftragbearbeitenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miAuftragbearbeitenActionPerformed
        if (istEingeloggt) {
            jifAuftragBearbeiten.setVisible(true);
        } /*----------------------------------------------------------*/ /* 21.11.16 Samet Variable istEngeloggt, um den Staus des Login zu erfassen
        Bei istEingeloggt=false wird die untesn setehende Fehlermeldung ausgegeben.*/ /*----------------------------------------------------------*/ else {
            JOptionPane.showMessageDialog(null, "Bitte einloggen!");
        }
    }//GEN-LAST:event_miAuftragbearbeitenActionPerformed

    private void miLieferantSucheActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miLieferantSucheActionPerformed
        if (istEingeloggt == true) {
            jifLieferantSuchen.setVisible(true);
        } /*----------------------------------------------------------*/ 
        /* 21.11.16 Samet Variable istEngeloggt, um den Staus des Login zu erfassen
        Bei istEingeloggt=false wird die untesn setehende Fehlermeldung ausgegeben.*/ 
        /*----------------------------------------------------------*/ 
        else {
            JOptionPane.showMessageDialog(null, "Bitte einloggen!");
        }
    }//GEN-LAST:event_miLieferantSucheActionPerformed

    private void miKundeSucheActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miKundeSucheActionPerformed
        if (istEingeloggt == true) {
            jifKundeSuchen.setVisible(true);
        } /*----------------------------------------------------------*/ /* 21.11.16 Samet Variable istEngeloggt, um den Staus des Login zu erfassen
        Bei istEingeloggt=false wird die untesn setehende Fehlermeldung ausgegeben.*/ /*----------------------------------------------------------*/ else {
            JOptionPane.showMessageDialog(null, "Bitte einloggen!");
        }
    }//GEN-LAST:event_miKundeSucheActionPerformed

    private void miLieferantanzeigenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miLieferantanzeigenActionPerformed
        if (istEingeloggt == true) {
            jifLieferantAnzeigen.setVisible(true);
        } /*----------------------------------------------------------*/ 
        /* 21.11.16 Samet Variable istEngeloggt, um den Staus des Login zu erfassen
        Bei istEingeloggt=false wird die untesn setehende Fehlermeldung ausgegeben.*/ 
        /*----------------------------------------------------------*/ 
        else {
            JOptionPane.showMessageDialog(null, "Bitte einloggen!");
        }
    }//GEN-LAST:event_miLieferantanzeigenActionPerformed

    private void miLieferantanlegenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miLieferantanlegenActionPerformed
        if (istEingeloggt == true) {
            jifLieferantAnlegen.setVisible(true);
        } /*----------------------------------------------------------*/ 
        /* 21.11.16 Samet Variable istEngeloggt, um den Staus des Login zu erfassen
        Bei istEingeloggt=false wird die untesn setehende Fehlermeldung ausgegeben.*/ 
        /*----------------------------------------------------------*/ 
        else {
            JOptionPane.showMessageDialog(null, "Bitte einloggen!");
        }
    }//GEN-LAST:event_miLieferantanlegenActionPerformed

    private void miLieferantbearbeitenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miLieferantbearbeitenActionPerformed
        if (istEingeloggt == true) {
            jifLieferantBearbeiten.setVisible(true);
        } /*----------------------------------------------------------*/ 
        /* 21.11.16 Samet Variable istEngeloggt, um den Staus des Login zu erfassen
        Bei istEingeloggt=false wird die untesn setehende Fehlermeldung ausgegeben.*/ 
        /*----------------------------------------------------------*/ 
        else {
            JOptionPane.showMessageDialog(null, "Bitte einloggen!");
        }
    }//GEN-LAST:event_miLieferantbearbeitenActionPerformed

    private void miKundeanzeigenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miKundeanzeigenActionPerformed
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
    }//GEN-LAST:event_miKundeanzeigenActionPerformed

    private void miKundeanlegenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miKundeanlegenActionPerformed
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
    }//GEN-LAST:event_miKundeanlegenActionPerformed

    private void miKundebearbeitenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miKundebearbeitenActionPerformed
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
    }//GEN-LAST:event_miKundebearbeitenActionPerformed

    private void miZKAnzeigenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miZKAnzeigenActionPerformed
        if (istEingeloggt == true) {
            jifZKAnzeigen.setVisible(true);
        } /*----------------------------------------------------------*/ /* 21.11.16 Samet Variable istEngeloggt, um den Staus des Login zu erfassen
        Bei istEingeloggt=false wird die untesn setehende Fehlermeldung ausgegeben.*/ /*----------------------------------------------------------*/ else {
            JOptionPane.showMessageDialog(null, "Bitte einloggen!");
        }
    }//GEN-LAST:event_miZKAnzeigenActionPerformed

    private void miZKAnlegenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miZKAnlegenActionPerformed
        if (istEingeloggt == true) {
            jifZKAnlegen.setVisible(true);
        } /*----------------------------------------------------------*/ /* 21.11.16 Samet Variable istEngeloggt, um den Staus des Login zu erfassen
        Bei istEingeloggt=false wird die untesn setehende Fehlermeldung ausgegeben.*/ /*----------------------------------------------------------*/ else {
            JOptionPane.showMessageDialog(null, "Bitte einloggen!");
        }
    }//GEN-LAST:event_miZKAnlegenActionPerformed

    private void miZKSucheActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miZKSucheActionPerformed
        if (istEingeloggt == true) {
            jifZKSuchen.setVisible(true);
        } //Samet, Variable istEingeloggt, um den Status eingeloggt oder nicht eingeloggt zu erfassen.
        // Bei istEingeloggt=false wird die unten stehende Fehlermeldung ausgegeben.
        else {
            JOptionPane.showMessageDialog(null, "Bitte einloggen!");
        }
    }//GEN-LAST:event_miZKSucheActionPerformed

    private void miZKBearbeitenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miZKBearbeitenActionPerformed
        if (istEingeloggt == true) {
            jifZKBearbeiten.setVisible(true);
        } /*----------------------------------------------------------*/ /* 21.11.16 Samet Variable istEngeloggt, um den Staus des Login zu erfassen
        Bei istEingeloggt=false wird die untesn setehende Fehlermeldung ausgegeben.*/ /*----------------------------------------------------------*/ else {
            JOptionPane.showMessageDialog(null, "Bitte einloggen!");
        }
    }//GEN-LAST:event_miZKBearbeitenActionPerformed

    private void jmDateiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmDateiActionPerformed
        if (istEingeloggt == true) {
        } else {
            JOptionPane.showMessageDialog(null, "Sie müssen eingeloggt sein, um sich abmelden zu können !");
        }
    }//GEN-LAST:event_jmDateiActionPerformed

    private void jmAuftragActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmAuftragActionPerformed
        if (istEingeloggt == true) {
        }/*----------------------------------------------------------*/ /* 21.11.16 Samet Variable istEngeloggt, um den Staus des Login zu erfassen
        Bei istEingeloggt=false wird die untesn setehende Fehlermeldung ausgegeben.*/ /*----------------------------------------------------------*/ else {
            JOptionPane.showMessageDialog(null, "Bitte einloggen!");
        }
    }//GEN-LAST:event_jmAuftragActionPerformed

    private void jmSucheActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmSucheActionPerformed
        if (istEingeloggt == true) {
        } else {
        }
    }//GEN-LAST:event_jmSucheActionPerformed

    private void jmArtikelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmArtikelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jmArtikelActionPerformed
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

    private void miGesamtAuftraegeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miGesamtAuftraegeActionPerformed
        if (istEingeloggt == true) {
            jifAuftraegeAlle.setVisible(true);
        } /*----------------------------------------------------------*/ /* 21.11.16 Samet Variable istEngeloggt, um den Staus des Login zu erfassen
        Bei istEingeloggt=false wird die untesn setehende Fehlermeldung ausgegeben.*/ /*----------------------------------------------------------*/ else {
            JOptionPane.showMessageDialog(null, "Bitte einloggen!");
        }
    }//GEN-LAST:event_miGesamtAuftraegeActionPerformed
//27.11.2016 Impram
    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
         JOptionPane.showMessageDialog(null, INFO_TEXT, INFO_TITEL, JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jMenuItem2ActionPerformed
    

    
    
    
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
            @Override
            public void run() {
                new StartAV().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel SeiteZwei;
    private javax.swing.JPanel Startseite;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JDesktopPane desktopPane;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JButton jbanmelden_Startseite;
    private view.ArtikelAnlegen jifArtikelAnlegen;
    private view.ArtikelAnzeige jifArtikelAnzeige;
    private view.ArtikelBearbeiten jifArtikelBearbeiten;
    private view.ArtikelID_suchen jifArtikelID_suchen;
    private view.ArtikelSuche jifArtikelSuche;
    private view.AuftraegeAlle jifAuftraegeAlle;
    private view.AuftragAnlegen jifAuftragAnlegen;
    private view.AuftragAnzeigen jifAuftragAnzeigen;
    private view.AuftragBearbeiten jifAuftragBearbeiten;
    private view.AuftragSuchen jifAuftragSuchen;
    private view.AuftragsID_suchen jifAuftragsID_suchen;
    private view.GPID_suchen jifGPID_suchen;
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
    private javax.swing.JMenu jmGeschäftspartner;
    private javax.swing.JMenu jmKunde;
    private javax.swing.JMenu jmLieferant;
    private javax.swing.JMenu jmSuche;
    private javax.swing.JMenu jmZahlungskondition;
    private javax.swing.JPasswordField jpwpasswort_Startseite;
    private javax.swing.JTextField jtfBenutzername_Startseite;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem miAbmelden;
    private javax.swing.JMenuItem miArtikelSuche;
    private javax.swing.JMenuItem miArtikelanlegen;
    private javax.swing.JMenuItem miArtikelanzeigen;
    private javax.swing.JMenuItem miArtikelbearbeiten;
    private javax.swing.JMenuItem miAuftragSuche;
    private javax.swing.JMenuItem miAuftraganlegen;
    private javax.swing.JMenuItem miAuftraganzeigen;
    private javax.swing.JMenuItem miAuftragbearbeiten;
    private javax.swing.JMenuItem miBeenden;
    private javax.swing.JMenuItem miGesamtAuftraege;
    private javax.swing.JMenuItem miKundeSuche;
    private javax.swing.JMenuItem miKundeanlegen;
    private javax.swing.JMenuItem miKundeanzeigen;
    private javax.swing.JMenuItem miKundebearbeiten;
    private javax.swing.JMenuItem miLieferantSuche;
    private javax.swing.JMenuItem miLieferantanlegen;
    private javax.swing.JMenuItem miLieferantanzeigen;
    private javax.swing.JMenuItem miLieferantbearbeiten;
    private javax.swing.JMenuItem miZKAnlegen;
    private javax.swing.JMenuItem miZKAnzeigen;
    private javax.swing.JMenuItem miZKBearbeiten;
    private javax.swing.JMenuItem miZKSuche;
    // End of variables declaration//GEN-END:variables

    

}
