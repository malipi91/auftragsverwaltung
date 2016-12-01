/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.text.DecimalFormatSymbols;

/*----------------------------------------------------------*/
/* Datum Name Was */
/* 15.11.16 Impram Erstellung*/
/* 24.11.16 Yoeruek Aufsplittung der StartAv Klasse in einzelne Klassen, da Code für eine Klasse zu lang. */
/* 27.11.16 Yoeruek Anpassung der Größenverhältnisse (Schriftart, Layout)*/
/*----------------------------------------------------------*/
public class AuftragSuchen extends javax.swing.JInternalFrame {

    //Variablendeklaration
    StartAV myParent;

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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
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
        jbSuchen_AuftragSuchen = new javax.swing.JButton();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jtTabelle_AuftragSuche = new javax.swing.JTable();
        jbAnzeigen_AuftragSuchen = new javax.swing.JButton();
        jbLupeAuftragsID_AuftragSuchen = new javax.swing.JButton();
        jbLupeGPName_AuftragSuchen = new javax.swing.JButton();

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

        jbSuchen_AuftragSuchen.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jbSuchen_AuftragSuchen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/lupe.png"))); // NOI18N
        jbSuchen_AuftragSuchen.setText("Suchen");

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

        jbLupeAuftragsID_AuftragSuchen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/lupe2.png"))); // NOI18N
        jbLupeAuftragsID_AuftragSuchen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbLupeAuftragsID_AuftragSuchenActionPerformed(evt);
            }
        });

        jbLupeGPName_AuftragSuchen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/lupe2.png"))); // NOI18N
        jbLupeGPName_AuftragSuchen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbLupeGPName_AuftragSuchenActionPerformed(evt);
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
                        .addGroup(AuftragSuchenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(AuftragSuchenLayout.createSequentialGroup()
                                .addGap(314, 314, 314)
                                .addComponent(titel_as))
                            .addGroup(AuftragSuchenLayout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addGroup(AuftragSuchenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, AuftragSuchenLayout.createSequentialGroup()
                                        .addGroup(AuftragSuchenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jlAuftragsnr_as)
                                            .addComponent(jLabel26)
                                            .addComponent(jLabel27)
                                            .addComponent(jLabel29)
                                            .addComponent(jLabel30))
                                        .addGap(35, 35, 35)
                                        .addGroup(AuftragSuchenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jftfLieferdatum_AuftragSuche, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jftfErfassungsdatum_AuftragSuche, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jtfAuftragsID_AuftragSuchen)
                                            .addComponent(jcbSuchkriterium_AuftragSuchen, 0, 150, Short.MAX_VALUE)
                                            .addComponent(jtfGPID_AuftragSuchen))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(AuftragSuchenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jbLupeAuftragsID_AuftragSuchen, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jbLupeGPName_AuftragSuchen, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                                                        .addComponent(jLabel36)))
                                                .addGap(7, 7, 7))
                                            .addGroup(AuftragSuchenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(jbSuchen_AuftragSuchen, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGroup(AuftragSuchenLayout.createSequentialGroup()
                                                    .addComponent(jLabel33)
                                                    .addGap(18, 18, 18)
                                                    .addComponent(jcbStatus_AuftragSuche, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                    .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 710, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 190, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AuftragSuchenLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jbAnzeigen_AuftragSuchen, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jbZurueck_AutragSuchen, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        AuftragSuchenLayout.setVerticalGroup(
            AuftragSuchenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AuftragSuchenLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titel_as)
                .addGap(4, 4, 4)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(AuftragSuchenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(jcbSuchkriterium_AuftragSuchen, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(AuftragSuchenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlAuftragsnr_as)
                    .addComponent(jtfAuftragsID_AuftragSuchen, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel31)
                    .addComponent(jcbStatusArt_AuftragSuche, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbLupeAuftragsID_AuftragSuchen, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(AuftragSuchenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbLupeGPName_AuftragSuchen, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(AuftragSuchenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel27)
                        .addComponent(jtfGPID_AuftragSuchen, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jtfMinAuftragswert_AuftragSuche, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel32)
                        .addComponent(jtfMaxAuftragswert_AuftragSuche, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel35)
                        .addComponent(jLabel34)
                        .addComponent(jLabel36)))
                .addGap(18, 18, 18)
                .addGroup(AuftragSuchenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(AuftragSuchenLayout.createSequentialGroup()
                        .addGroup(AuftragSuchenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel29)
                            .addComponent(jftfLieferdatum_AuftragSuche, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(AuftragSuchenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel30)
                            .addComponent(jftfErfassungsdatum_AuftragSuche, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(AuftragSuchenLayout.createSequentialGroup()
                        .addGroup(AuftragSuchenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel33)
                            .addComponent(jcbStatus_AuftragSuche, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jbSuchen_AuftragSuchen, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(32, 32, 32)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(AuftragSuchenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbAnzeigen_AuftragSuchen, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbZurueck_AutragSuchen, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(149, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 950, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(AuftragSuchen, javax.swing.GroupLayout.PREFERRED_SIZE, 950, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 803, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(AuftragSuchen, javax.swing.GroupLayout.DEFAULT_SIZE, 819, Short.MAX_VALUE))
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
     
    }//GEN-LAST:event_jbAnzeigen_AuftragSuchenActionPerformed

    private void jbLupeAuftragsID_AuftragSuchenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbLupeAuftragsID_AuftragSuchenActionPerformed
        /* 30.11.16 Yoeruek Öffnet über die Lupe Artikel-ID Suchen */
        myParent.oeffneArtikelIDSuchen();
    }//GEN-LAST:event_jbLupeAuftragsID_AuftragSuchenActionPerformed

    private void jbLupeGPName_AuftragSuchenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbLupeGPName_AuftragSuchenActionPerformed
        /* 30.11.16 Yoeruek Öffnet über die Lupe GP-ID Suchen */
        myParent.oeffneGPIDSuchen();
    }//GEN-LAST:event_jbLupeGPName_AuftragSuchenActionPerformed


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
    private javax.swing.JButton jbLupeAuftragsID_AuftragSuchen;
    private javax.swing.JButton jbLupeGPName_AuftragSuchen;
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
