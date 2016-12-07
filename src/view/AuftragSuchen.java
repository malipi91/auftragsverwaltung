package view;

import dao.DAOArtikel;
import java.sql.SQLException;
import java.text.DecimalFormatSymbols;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/*----------------------------------------------------------*/
/* Datum Name Was */
/* 15.11.16 Impram Erstellung*/
/* 24.11.16 Yoeruek Aufsplittung der StartAv Klasse in einzelne Klassen, da Code für eine Klasse zu lang. */
/* 27.11.16 Yoeruek Anpassung der Größenverhältnisse (Schriftart, Layout)*/
/*----------------------------------------------------------*/
public class AuftragSuchen extends javax.swing.JInternalFrame {

    //Variablendeklaration
    StartAV myParent;

     /* 06.12.16 Yoeruek Konstruktor, damit beim rein ziehen der Masken in die StartAV keine Probleme entstehen. */
    public AuftragSuchen(){
        initComponents();
    }
    
    /* 06.12.16 Yoeruek Konstruktor wird beim Ausführen der StartAV benutzt*/
    public AuftragSuchen(StartAV  parent) {
        initComponents();
        myParent = parent;
        
 
       //Mechmet Impram
        jtfAuftragsID_AuftragSuchen.setDocument(new UniversalDokument(false, true, "", 5));
        jtfGPID_AuftragSuchen.setDocument(new UniversalDokument(true, false, ".-' ", -1));
//        jtfLieferantenname_AuftragSuche.setDocument(new UniversalDokument(true, false, ".-' ", -1));
//        jftfLieferdatum_AuftragSuche.setFormatterFactory(erstelleMF("##.##.####"));
//        jftfErfassungsdatum_AuftragSuche.setFormatterFactory(erstelleMF("##.##.####"));
        jtfMinAuftragswert_AuftragSuche.setDocument(new UniversalDokument(false, true, DecimalFormatSymbols.getInstance().getDecimalSeparator() + "", -1));
        jtfMinAuftragswert_AuftragSuche.setInputVerifier(new UniversalVerifier("\\d+(\\" + DecimalFormatSymbols.getInstance().getDecimalSeparator() + "\\d\\d)?", "ungultiges format", "Bitte geben sie ein Preis mit 2 Nachkommastellen oder eine ganze Zahl"));
        jtfMaxAuftragswert_AuftragSuche.setDocument(new UniversalDokument(false, true, DecimalFormatSymbols.getInstance().getDecimalSeparator() + "", -1));
        jtfMaxAuftragswert_AuftragSuche.setInputVerifier(new UniversalVerifier("\\d+(\\" + DecimalFormatSymbols.getInstance().getDecimalSeparator() + "\\d\\d)?", "ungultiges format", "Bitte geben sie ein Preis mit 2 Nachkommastellen oder eine ganze Zahl"));
   
    }

    /*-------------------------------------------------------------*/
    /* 01.12.16 Yoeruek Prüfung nach Pflichtfeldern, falls nichts  */ 
    /*            angegeben ist wird eine Fehlermeldung ausgegeben */
    /*-------------------------------------------------------------*/
//    public boolean istVollstaendig(){
//        Boolean vollstaendig = false;
//        String fehlermeldung = "";
//        if(jcbSuchkriterium_AuftragSuchen.getSelectedIndex() == 0){
//            fehlermeldung = "Bitte wählen Sie ein Suchkriterium aus und "
//                    + "füllen Sie das dazugehörige Eingabefeld aus!";
//            jcbSuchkriterium_AuftragSuchen.requestFocusInWindow();
//        } 
//        if(fehlermeldung.equals("")){
//            vollstaendig = true;
//        }else{
//            JOptionPane.showMessageDialog(this, fehlermeldung,"Unvollständig" ,JOptionPane.WARNING_MESSAGE);
//        }return vollstaendig;
//    }
//    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        AuftragSuchen = new javax.swing.JPanel();
        titel_as = new javax.swing.JLabel();
        jlAuftragsnr_as = new javax.swing.JLabel();
        jtfAuftragsID_AuftragSuchen = new javax.swing.JTextField();
        jbZurueck_AutragSuchen = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel26 = new javax.swing.JLabel();
        jcbSuchkriterium_AuftragSuchen = new javax.swing.JComboBox();
        jLabel27 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jtfGPID_AuftragSuchen = new javax.swing.JTextField();
        jftfLieferdatum_AuftragSuche = new javax.swing.JFormattedTextField();
        jftfErfassungsdatum_AuftragSuche = new javax.swing.JFormattedTextField();
        jLabel31 = new javax.swing.JLabel();
        jtfMinAuftragswert_AuftragSuche = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jcbStatusArt_AuftragSuche = new javax.swing.JComboBox();
        jcbStatus_AuftragSuche = new javax.swing.JComboBox();
        jLabel34 = new javax.swing.JLabel();
        jtfMaxAuftragswert_AuftragSuche = new javax.swing.JTextField();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jtTabelle_AuftragSuche = new javax.swing.JTable();
        jbAnzeigen_AuftragSuchen = new javax.swing.JButton();
        jbSuchen_AuftragSuchen = new javax.swing.JButton();
        jbBearbeiten_auftragSuchen = new javax.swing.JButton();
        jbLöschen_AuftragSuchen = new javax.swing.JButton();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);

        AuftragSuchen.setPreferredSize(new java.awt.Dimension(1200, 900));

        titel_as.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        titel_as.setText("Auftrag Suchen");

        jlAuftragsnr_as.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jlAuftragsnr_as.setText("Auftrags-ID:");

        jtfAuftragsID_AuftragSuchen.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jbZurueck_AutragSuchen.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jbZurueck_AutragSuchen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/zurück.png"))); // NOI18N
        jbZurueck_AutragSuchen.setText("Zurück");
        jbZurueck_AutragSuchen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbZurueck_AutragSuchenActionPerformed(evt);
            }
        });

        jLabel26.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel26.setText("Suchkriterium:");

        jcbSuchkriterium_AuftragSuchen.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jcbSuchkriterium_AuftragSuchen.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Auftrags-ID", "Geschäftspartner-ID", "Lieferdatum", "Erfassungsdatum", "Status", "Auftragswert", "Auftragsart" }));
        jcbSuchkriterium_AuftragSuchen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbSuchkriterium_AuftragSuchenActionPerformed(evt);
            }
        });

        jLabel27.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel27.setText("Geschäftspartner-ID:");

        jLabel29.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel29.setText("Lieferdatum:");

        jLabel30.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel30.setText("Erfassungsdatum:");

        jtfGPID_AuftragSuchen.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtfGPID_AuftragSuchen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfGPID_AuftragSuchenActionPerformed(evt);
            }
        });

        jLabel31.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel31.setText("Status");

        jtfMinAuftragswert_AuftragSuche.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtfMinAuftragswert_AuftragSuche.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfMinAuftragswert_AuftragSucheActionPerformed(evt);
            }
        });

        jLabel32.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel32.setText("Auftragswert");

        jLabel33.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel33.setText("Auftragsart");

        jcbStatusArt_AuftragSuche.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jcbStatusArt_AuftragSuche.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "", "erfasst", "freigegeben", "abgeschlossen" }));

        jcbStatus_AuftragSuche.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jcbStatus_AuftragSuche.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "", "Barauftrag", "Sofortauftrag", "Terminauftrag", "Bestellauftrag" }));

        jLabel34.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel34.setText("bis");

        jtfMaxAuftragswert_AuftragSuche.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel35.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel35.setText("€");

        jLabel36.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel36.setText("€");

        jtTabelle_AuftragSuche.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Auftrags-ID", "GP-ID", "GP-Name", "Status", "Lieferdatum", "Auftragsart", "Auftragswert"
            }
        ));
        jScrollPane4.setViewportView(jtTabelle_AuftragSuche);

        jbAnzeigen_AuftragSuchen.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jbAnzeigen_AuftragSuchen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/anzeigen.png"))); // NOI18N
        jbAnzeigen_AuftragSuchen.setText("Anzeigen");
        jbAnzeigen_AuftragSuchen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAnzeigen_AuftragSuchenActionPerformed(evt);
            }
        });

        jbSuchen_AuftragSuchen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/lupe.png"))); // NOI18N
        jbSuchen_AuftragSuchen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSuchen_AuftragSuchenActionPerformed(evt);
            }
        });

        jbBearbeiten_auftragSuchen.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jbBearbeiten_auftragSuchen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/bearbeiten1.png"))); // NOI18N
        jbBearbeiten_auftragSuchen.setPreferredSize(new java.awt.Dimension(130, 35));
        jbBearbeiten_auftragSuchen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBearbeiten_auftragSuchenActionPerformed(evt);
            }
        });

        jbLöschen_AuftragSuchen.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jbLöschen_AuftragSuchen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/müll2.png"))); // NOI18N
        jbLöschen_AuftragSuchen.setPreferredSize(new java.awt.Dimension(130, 35));
        jbLöschen_AuftragSuchen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbLöschen_AuftragSuchenActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout AuftragSuchenLayout = new javax.swing.GroupLayout(AuftragSuchen);
        AuftragSuchen.setLayout(AuftragSuchenLayout);
        AuftragSuchenLayout.setHorizontalGroup(
            AuftragSuchenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AuftragSuchenLayout.createSequentialGroup()
                .addGroup(AuftragSuchenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addGroup(AuftragSuchenLayout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(AuftragSuchenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, AuftragSuchenLayout.createSequentialGroup()
                                .addGroup(AuftragSuchenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jlAuftragsnr_as)
                                    .addComponent(jLabel26)
                                    .addComponent(jLabel27)
                                    .addComponent(jLabel29)
                                    .addComponent(jLabel30))
                                .addGap(35, 35, 35)
                                .addGroup(AuftragSuchenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(AuftragSuchenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jftfLieferdatum_AuftragSuche, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jftfErfassungsdatum_AuftragSuche, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jtfAuftragsID_AuftragSuchen)
                                        .addComponent(jtfGPID_AuftragSuchen, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jcbSuchkriterium_AuftragSuchen, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(AuftragSuchenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(AuftragSuchenLayout.createSequentialGroup()
                                        .addGap(89, 89, 89)
                                        .addGroup(AuftragSuchenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AuftragSuchenLayout.createSequentialGroup()
                                                .addGroup(AuftragSuchenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel31)
                                                    .addComponent(jLabel32))
                                                .addGap(5, 5, 5)
                                                .addGroup(AuftragSuchenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jcbStatusArt_AuftragSuche, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGroup(AuftragSuchenLayout.createSequentialGroup()
                                                        .addComponent(jtfMinAuftragswert_AuftragSuche, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(1, 1, 1)
                                                        .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(11, 11, 11)
                                                        .addComponent(jLabel34)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(jtfMaxAuftragswert_AuftragSuche, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(jLabel36))))
                                            .addGroup(AuftragSuchenLayout.createSequentialGroup()
                                                .addComponent(jLabel33)
                                                .addGap(18, 18, 18)
                                                .addComponent(jcbStatus_AuftragSuche, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(AuftragSuchenLayout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(jbSuchen_AuftragSuchen, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jbBearbeiten_auftragSuchen, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jbLöschen_AuftragSuchen, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, AuftragSuchenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(AuftragSuchenLayout.createSequentialGroup()
                                    .addComponent(jbAnzeigen_AuftragSuchen, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jbZurueck_AutragSuchen, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 710, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(190, 190, 190))
                    .addGroup(AuftragSuchenLayout.createSequentialGroup()
                        .addGap(317, 317, 317)
                        .addComponent(titel_as)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        AuftragSuchenLayout.setVerticalGroup(
            AuftragSuchenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AuftragSuchenLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(titel_as)
                .addGap(4, 4, 4)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(AuftragSuchenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(AuftragSuchenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel26)
                        .addComponent(jcbSuchkriterium_AuftragSuchen, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jbSuchen_AuftragSuchen, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbBearbeiten_auftragSuchen, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbLöschen_AuftragSuchen, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(AuftragSuchenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(AuftragSuchenLayout.createSequentialGroup()
                        .addComponent(jlAuftragsnr_as)
                        .addGap(22, 22, 22)
                        .addComponent(jLabel27)
                        .addGap(23, 23, 23)
                        .addComponent(jLabel29)
                        .addGap(23, 23, 23)
                        .addComponent(jLabel30))
                    .addGroup(AuftragSuchenLayout.createSequentialGroup()
                        .addComponent(jtfAuftragsID_AuftragSuchen, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(17, 17, 17)
                        .addComponent(jtfGPID_AuftragSuchen, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jftfLieferdatum_AuftragSuche, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jftfErfassungsdatum_AuftragSuche, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(AuftragSuchenLayout.createSequentialGroup()
                        .addGroup(AuftragSuchenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel31)
                            .addComponent(jcbStatusArt_AuftragSuche, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(17, 17, 17)
                        .addGroup(AuftragSuchenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtfMinAuftragswert_AuftragSuche, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel32)
                            .addComponent(jtfMaxAuftragswert_AuftragSuche, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel35)
                            .addComponent(jLabel34)
                            .addComponent(jLabel36))
                        .addGap(18, 18, 18)
                        .addGroup(AuftragSuchenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel33)
                            .addComponent(jcbStatus_AuftragSuche, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(37, 37, 37)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(AuftragSuchenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbAnzeigen_AuftragSuchen, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbZurueck_AutragSuchen, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(48, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 799, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(AuftragSuchen, javax.swing.GroupLayout.PREFERRED_SIZE, 799, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 673, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(AuftragSuchen, javax.swing.GroupLayout.DEFAULT_SIZE, 689, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbZurueck_AutragSuchenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbZurueck_AutragSuchenActionPerformed
        /*----------------------------------------------------------*/
        /* 24.11.16 Yoeruek Schließt das Fenster nach Betätigung des Abbrech Buttons */
        /*----------------------------------------------------------*/
        this.setVisible(false);     
    }//GEN-LAST:event_jbZurueck_AutragSuchenActionPerformed

    private void jcbSuchkriterium_AuftragSuchenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbSuchkriterium_AuftragSuchenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbSuchkriterium_AuftragSuchenActionPerformed

    private void jtfGPID_AuftragSuchenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfGPID_AuftragSuchenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfGPID_AuftragSuchenActionPerformed

    private void jtfMinAuftragswert_AuftragSucheActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfMinAuftragswert_AuftragSucheActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfMinAuftragswert_AuftragSucheActionPerformed

    private void jbAnzeigen_AuftragSuchenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAnzeigen_AuftragSuchenActionPerformed
//        if(istVollstaendig()){
           myParent.oeffneAuftragAnzeige();
//        }     
    }//GEN-LAST:event_jbAnzeigen_AuftragSuchenActionPerformed

    private void jbSuchen_AuftragSuchenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSuchen_AuftragSuchenActionPerformed
        /* 30.11.16 Yoeruek Öffnet über die Lupe Artikel-ID Suchen */
        //this.myParent.oeffneSucheArtikelAnzeigen();
    }//GEN-LAST:event_jbSuchen_AuftragSuchenActionPerformed

    private void jbBearbeiten_auftragSuchenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBearbeiten_auftragSuchenActionPerformed
        /*--------------------------------------------------------------------------------------------*/
        /* 02.12.16 Yoeruek Die Methode prüft ob ein Artikel ausgewählt wurde, und übergibt die         */
        /*                eingegeben Artikel ID weiter an die nächste Maske. Wenn nichts ausgewählt   */
        /*                wurde kommt es zu einer Fehlermeldung.                                      */
        /*--------------------------------------------------------------------------------------------*/

        if(jtTabelle_AuftragSuche.getSelectedRow()== -1){
            JOptionPane.showMessageDialog(this, "Bitte wählen Sie einen Artikel aus!",
                "Keine Auswahl",JOptionPane.CLOSED_OPTION);
        }else{
            //Es wird ein neues Objekt erzeugt und die Artikel Id
            //wird der Maske Artikel Bearbeiten übergeben.
            ArtikelBearbeiten artikelBearbeiten =
            this.myParent.getArtikelBearbeiten();
            artikelBearbeiten.ladeDatenfuerArtikelID
            (this.jtfAuftragsID_AuftragSuchen.getText());
            artikelBearbeiten.setVisible(true);

        }
    }//GEN-LAST:event_jbBearbeiten_auftragSuchenActionPerformed

    private void jbLöschen_AuftragSuchenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbLöschen_AuftragSuchenActionPerformed
        /*--------------------------------------------------------------------------------------------*/
        /* 02.12.16 Yoeruek Die Methode prüft ob ein Artikel markiert ist und löscht anschließend     */
        /*                  die Daten. Falls nichts markiert wurde wird eine Fehlermeldung ausgegeben.*/
        /*--------------------------------------------------------------------------------------------*/

        //prüfen ob artikel zum löschen ausgewählt ist muss noch angelegt werden
        boolean istArtikelAusgewaehlt = true;
        if(istArtikelAusgewaehlt){
            DefaultTableModel model = (DefaultTableModel) this.jtTabelle_AuftragSuche.getModel();
            int index = this.jtTabelle_AuftragSuche.getSelectedRow(); //auswahl markieren
            String artikelId =(String) model.getValueAt(index, 0);
            model.removeRow(index); //auswahl löschen

            //model.removeRow(0);
            /*   Die Daten werden aus der Tabelle geholt */
            try {
                /*   Die Daten werden in die Datenbank geschrieben */
               DAOArtikel daoArtikel = new DAOArtikel();
                daoArtikel.loescheArtikelMitID(artikelId);
            } catch (SQLException ex) {
                Logger.getLogger(StartAV.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
//            JOptionPane.showConfirmDialog(this, Loeschen_Text, Loeschen_Titel, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            //          JOptionPane.showMessageDialog(this, "Soll der Artikel wirklich gelöscht werden?",
                //                    "Artikel löschen",JOptionPane.CLOSED_OPTION);
        }
        this.setVisible(false);
    }//GEN-LAST:event_jbLöschen_AuftragSuchenActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel AuftragSuchen;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton jbAnzeigen_AuftragSuchen;
    private javax.swing.JButton jbBearbeiten_auftragSuchen;
    private javax.swing.JButton jbLöschen_AuftragSuchen;
    private javax.swing.JButton jbSuchen_AuftragSuchen;
    private javax.swing.JButton jbZurueck_AutragSuchen;
    private javax.swing.JComboBox jcbStatusArt_AuftragSuche;
    private javax.swing.JComboBox jcbStatus_AuftragSuche;
    private javax.swing.JComboBox jcbSuchkriterium_AuftragSuchen;
    private javax.swing.JFormattedTextField jftfErfassungsdatum_AuftragSuche;
    private javax.swing.JFormattedTextField jftfLieferdatum_AuftragSuche;
    private javax.swing.JLabel jlAuftragsnr_as;
    private javax.swing.JTable jtTabelle_AuftragSuche;
    private javax.swing.JTextField jtfAuftragsID_AuftragSuchen;
    private javax.swing.JTextField jtfGPID_AuftragSuchen;
    private javax.swing.JTextField jtfMaxAuftragswert_AuftragSuche;
    private javax.swing.JTextField jtfMinAuftragswert_AuftragSuche;
    private javax.swing.JLabel titel_as;
    // End of variables declaration//GEN-END:variables
}
