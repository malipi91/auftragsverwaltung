/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.text.DecimalFormatSymbols;

/*----------------------------------------------------------*/
/* Datum    Name    Was */
/* 14.11.16 Yoeruek Erstellung*/
/* 24.11.16 Yoeruek Aufsplittung der StartAv Klasse in einzelne Klassen, da Code für eine Klasse zu lang. */
/* 27.11.16 Yoeruek Anpassung der Größenverhältnisse (Schriftart, Layout)*/
/*----------------------------------------------------------*/
public class ArtikelAnzeige extends javax.swing.JInternalFrame {
    
    //Variablendeklaration
    StartAV myParent;
 
    /**
     * Creates new form ArtikelAnzeige
     */
    public ArtikelAnzeige(StartAV parent) {
          myParent = parent;
          
        initComponents();
        //Mehmet Impram 27.11.2016
//        jtfArtikelID_ArtikelAnzeigen.setEnabled(false);
        jtfartikelname_ArtikelAnzeigen.setEnabled(false);
        jtffrei_ArtikelAnzeigen.setEnabled(false);
        jtfreserviert_ArtikelAnzeigen.setEnabled(false);
        jtfzulauf_ArtikelAnzeigen.setEnabled(false);
        jtfverkauft_ArtikelAnzeigen.setEnabled(false);
        jtaArtikeltext_ArtikelAnzeigen.setEnabled(false);
        jtaBestelltext_ArtikelAnzeigen.setEnabled(false);
        jtfeinzelwertnetto_ArtikelAnzeigen.setEnabled(false);
        jtfeinzelwertbrutto_ArtikelAnzeigen.setEnabled(false);
        jtfbestellwertnetto_ArtikelAnzeigen.setEnabled(false);
        jtfbestellwertbrutto_ArtikelAnzeigen.setEnabled(false);
        jcbmehrwertsteuer_ArtikelAnzeigen.setEnabled(false);
                
        
         //Mechmet Impram
//        jtfArtikelID_ArtikelAnzeigen.setDocument(new UniversalDokument(false, true, "", 5));
//        jtfartikelname_ArtikelAnzeigen.setDocument(new UniversalDokument(true, false, "-. ' ", -1));
//        jtffrei_ArtikelAnzeigen.setDocument(new UniversalDokument(false, true, "", 5));
//        jtfreserviert_ArtikelAnzeigen.setDocument(new UniversalDokument(false, true, "", 5));
//        jtfzulauf_ArtikelAnzeigen.setDocument(new UniversalDokument(false, true, "", 5));
//        jtfverkauft_ArtikelAnzeigen.setDocument(new UniversalDokument(false, true, "", 5));
//        jtaArtikeltext_ArtikelAnzeigen.setDocument(new UniversalDokument(true, false, "-. ' ", -1));
//        jtaBestelltext_ArtikelAnzeigen.setDocument(new UniversalDokument(true, true, "- . ' ", -1));
//        jtfeinzelwertnetto_ArtikelAnzeigen.setDocument(new UniversalDokument(false, true, DecimalFormatSymbols.getInstance().getDecimalSeparator() + "", -1));
//        jtfeinzelwertnetto_ArtikelAnzeigen.setInputVerifier(new UniversalVerifier("\\d+(\\" + DecimalFormatSymbols.getInstance().getDecimalSeparator() + "\\d\\d)?", "ungultiges format", "Bitte geben sie ein Preis mit 2 Nachkommastellen oder eine ganze Zahl"));
//        jtfeinzelwertbrutto_ArtikelAnzeigen.setDocument(new UniversalDokument(false, true, DecimalFormatSymbols.getInstance().getDecimalSeparator() + "", -1));
//        jtfeinzelwertbrutto_ArtikelAnzeigen.setInputVerifier(new UniversalVerifier("\\d+(\\" + DecimalFormatSymbols.getInstance().getDecimalSeparator() + "\\d\\d)?", "ungultiges format", "Bitte geben sie ein Preis mit 2 Nachkommastellen oder eine ganze Zahl"));
//        jtfbestellwertnetto_ArtikelAnzeigen.setDocument(new UniversalDokument(false, true, DecimalFormatSymbols.getInstance().getDecimalSeparator() + "", -1));
//        jtfbestellwertnetto_ArtikelAnzeigen.setInputVerifier(new UniversalVerifier("\\d+(\\" + DecimalFormatSymbols.getInstance().getDecimalSeparator() + "\\d\\d)?", "ungultiges format", "Bitte geben sie ein Preis mit 2 Nachkommastellen oder eine ganze Zahl"));
//        jtfbestellwertbrutto_ArtikelAnzeigen.setDocument(new UniversalDokument(false, true, DecimalFormatSymbols.getInstance().getDecimalSeparator() + "", -1));
//        jtfbestellwertbrutto_ArtikelAnzeigen.setInputVerifier(new UniversalVerifier("\\d+(\\" + DecimalFormatSymbols.getInstance().getDecimalSeparator() + "\\d\\d)?", "ungultiges format", "Bitte geben sie ein Preis mit 2 Nachkommastellen oder eine ganze Zahl"));
//        
        
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ArtikelAnzeige = new javax.swing.JPanel();
        jLabel43 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jtfartikelname_ArtikelAnzeigen = new javax.swing.JTextField();
        jbbearbeiten_ArtikelAnzeigen = new javax.swing.JButton();
        jbabbrechen_ArtikelAnzeigen = new javax.swing.JButton();
        jLabel37 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        jtfArtikelID_ArtikelAnzeigen = new javax.swing.JTextField();
        jbSpeichern_ArtikelAnzeigen = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jtffrei_ArtikelAnzeigen = new javax.swing.JTextField();
        jtfzulauf_ArtikelAnzeigen = new javax.swing.JTextField();
        jLabel46 = new javax.swing.JLabel();
        jtfreserviert_ArtikelAnzeigen = new javax.swing.JTextField();
        jLabel47 = new javax.swing.JLabel();
        jtfverkauft_ArtikelAnzeigen = new javax.swing.JTextField();
        jLabel48 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jLabel140 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jtfeinzelwertnetto_ArtikelAnzeigen = new javax.swing.JTextField();
        jLabel166 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jtfeinzelwertbrutto_ArtikelAnzeigen = new javax.swing.JTextField();
        jLabel168 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jtfbestellwertnetto_ArtikelAnzeigen = new javax.swing.JTextField();
        jLabel167 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        jtfbestellwertbrutto_ArtikelAnzeigen = new javax.swing.JTextField();
        jLabel169 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        jcbmehrwertsteuer_ArtikelAnzeigen = new javax.swing.JComboBox();
        jLabel56 = new javax.swing.JLabel();
        jtaBestelltext_ArtikelAnzeigen = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtaArtikeltext_ArtikelAnzeigen = new javax.swing.JTextArea();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);

        ArtikelAnzeige.setPreferredSize(new java.awt.Dimension(1200, 900));

        jLabel43.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel43.setText("Artikelname:");

        jLabel42.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel42.setText("Artikel-ID:");

        jtfartikelname_ArtikelAnzeigen.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtfartikelname_ArtikelAnzeigen.setMinimumSize(new java.awt.Dimension(6, 25));
        jtfartikelname_ArtikelAnzeigen.setPreferredSize(new java.awt.Dimension(6, 25));
        jtfartikelname_ArtikelAnzeigen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfartikelname_ArtikelAnzeigenActionPerformed(evt);
            }
        });

        jbbearbeiten_ArtikelAnzeigen.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jbbearbeiten_ArtikelAnzeigen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/bearbeiten1.png"))); // NOI18N
        jbbearbeiten_ArtikelAnzeigen.setText("Bearbeiten");
        jbbearbeiten_ArtikelAnzeigen.setPreferredSize(new java.awt.Dimension(130, 35));
        jbbearbeiten_ArtikelAnzeigen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbbearbeiten_ArtikelAnzeigenActionPerformed(evt);
            }
        });

        jbabbrechen_ArtikelAnzeigen.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jbabbrechen_ArtikelAnzeigen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/abbruch2.png"))); // NOI18N
        jbabbrechen_ArtikelAnzeigen.setText("Abbrechen");
        jbabbrechen_ArtikelAnzeigen.setPreferredSize(new java.awt.Dimension(130, 35));
        jbabbrechen_ArtikelAnzeigen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbabbrechen_ArtikelAnzeigenActionPerformed(evt);
            }
        });

        jLabel37.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel37.setText("Artikel Anzeigen");

        jtfArtikelID_ArtikelAnzeigen.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtfArtikelID_ArtikelAnzeigen.setToolTipText("");
        jtfArtikelID_ArtikelAnzeigen.setMinimumSize(new java.awt.Dimension(6, 25));
        jtfArtikelID_ArtikelAnzeigen.setPreferredSize(new java.awt.Dimension(6, 25));

        jbSpeichern_ArtikelAnzeigen.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jbSpeichern_ArtikelAnzeigen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/speichern2.png"))); // NOI18N
        jbSpeichern_ArtikelAnzeigen.setText("Speichern");
        jbSpeichern_ArtikelAnzeigen.setPreferredSize(new java.awt.Dimension(130, 35));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/lupe.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel44.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel44.setText("Bestandsmengen");

        jLabel45.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel45.setText("Frei:");

        jtffrei_ArtikelAnzeigen.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtffrei_ArtikelAnzeigen.setMinimumSize(new java.awt.Dimension(6, 25));
        jtffrei_ArtikelAnzeigen.setPreferredSize(new java.awt.Dimension(6, 25));

        jtfzulauf_ArtikelAnzeigen.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtfzulauf_ArtikelAnzeigen.setMinimumSize(new java.awt.Dimension(6, 25));
        jtfzulauf_ArtikelAnzeigen.setPreferredSize(new java.awt.Dimension(6, 25));

        jLabel46.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel46.setText("Zulauf:");

        jtfreserviert_ArtikelAnzeigen.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtfreserviert_ArtikelAnzeigen.setMinimumSize(new java.awt.Dimension(6, 25));
        jtfreserviert_ArtikelAnzeigen.setPreferredSize(new java.awt.Dimension(6, 25));
        jtfreserviert_ArtikelAnzeigen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfreserviert_ArtikelAnzeigenActionPerformed(evt);
            }
        });

        jLabel47.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel47.setText("Reserviert:");

        jtfverkauft_ArtikelAnzeigen.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtfverkauft_ArtikelAnzeigen.setMinimumSize(new java.awt.Dimension(6, 25));
        jtfverkauft_ArtikelAnzeigen.setPreferredSize(new java.awt.Dimension(6, 25));

        jLabel48.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel48.setText("Verkauft:");

        jLabel50.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel50.setText("Bestelltext:");

        jLabel140.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel140.setText("Artikeltext:");

        jLabel51.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel51.setText("Einzelwert (Netto):");

        jtfeinzelwertnetto_ArtikelAnzeigen.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtfeinzelwertnetto_ArtikelAnzeigen.setMinimumSize(new java.awt.Dimension(6, 25));
        jtfeinzelwertnetto_ArtikelAnzeigen.setPreferredSize(new java.awt.Dimension(6, 25));

        jLabel166.setText("€");

        jLabel52.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel52.setText("Einzelwert (Brutto):");

        jtfeinzelwertbrutto_ArtikelAnzeigen.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtfeinzelwertbrutto_ArtikelAnzeigen.setMinimumSize(new java.awt.Dimension(6, 25));
        jtfeinzelwertbrutto_ArtikelAnzeigen.setPreferredSize(new java.awt.Dimension(6, 25));

        jLabel168.setText("€");

        jLabel53.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel53.setText("Bestellwert (Netto):");

        jtfbestellwertnetto_ArtikelAnzeigen.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtfbestellwertnetto_ArtikelAnzeigen.setMinimumSize(new java.awt.Dimension(6, 25));
        jtfbestellwertnetto_ArtikelAnzeigen.setPreferredSize(new java.awt.Dimension(6, 25));
        jtfbestellwertnetto_ArtikelAnzeigen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfbestellwertnetto_ArtikelAnzeigenActionPerformed(evt);
            }
        });

        jLabel167.setText("€");

        jLabel54.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel54.setText("Bestellwert (Brutto):");

        jtfbestellwertbrutto_ArtikelAnzeigen.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtfbestellwertbrutto_ArtikelAnzeigen.setMinimumSize(new java.awt.Dimension(6, 25));
        jtfbestellwertbrutto_ArtikelAnzeigen.setPreferredSize(new java.awt.Dimension(6, 25));

        jLabel169.setText("€");

        jLabel55.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel55.setText("MwST-Satz:");

        jcbmehrwertsteuer_ArtikelAnzeigen.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "", "7", "19" }));
        jcbmehrwertsteuer_ArtikelAnzeigen.setMinimumSize(new java.awt.Dimension(37, 25));
        jcbmehrwertsteuer_ArtikelAnzeigen.setPreferredSize(new java.awt.Dimension(37, 25));
        jcbmehrwertsteuer_ArtikelAnzeigen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbmehrwertsteuer_ArtikelAnzeigenActionPerformed(evt);
            }
        });

        jLabel56.setText("%");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jtaBestelltext_ArtikelAnzeigen.setViewportView(jTextArea1);

        jtaArtikeltext_ArtikelAnzeigen.setColumns(20);
        jtaArtikeltext_ArtikelAnzeigen.setRows(5);
        jScrollPane1.setViewportView(jtaArtikeltext_ArtikelAnzeigen);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jtaBestelltext_ArtikelAnzeigen, javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel44)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel50)
                                .addGap(334, 334, 334)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel47)
                                        .addGap(67, 67, 67)
                                        .addComponent(jtfreserviert_ArtikelAnzeigen, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel48)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jtfverkauft_ArtikelAnzeigen, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel45, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel46))
                                .addGap(92, 92, 92)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jtfzulauf_ArtikelAnzeigen, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jtffrei_ArtikelAnzeigen, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel140)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 700, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(28, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel51)
                        .addGap(9, 9, 9)
                        .addComponent(jtfeinzelwertnetto_ArtikelAnzeigen, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel166, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel53)
                            .addComponent(jLabel55))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jcbmehrwertsteuer_ArtikelAnzeigen, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel56, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jtfbestellwertnetto_ArtikelAnzeigen, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel167)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel54)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfbestellwertbrutto_ArtikelAnzeigen, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel169))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel52)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jtfeinzelwertbrutto_ArtikelAnzeigen, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(jLabel168)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel44)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel45)
                            .addComponent(jtffrei_ArtikelAnzeigen, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel46)
                            .addComponent(jtfzulauf_ArtikelAnzeigen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(45, 45, 45))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtfreserviert_ArtikelAnzeigen, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel47))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel48)
                            .addComponent(jtfverkauft_ArtikelAnzeigen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(43, 43, 43)))
                .addComponent(jLabel50)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtaBestelltext_ArtikelAnzeigen, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jLabel140)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel51)
                                .addComponent(jtfeinzelwertnetto_ArtikelAnzeigen, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel166))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtfbestellwertnetto_ArtikelAnzeigen, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel53)
                            .addComponent(jLabel167)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel168)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jtfeinzelwertbrutto_ArtikelAnzeigen, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel52, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(8, 8, 8)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel169)
                            .addComponent(jtfbestellwertbrutto_ArtikelAnzeigen, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel54))))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel55)
                    .addComponent(jcbmehrwertsteuer_ArtikelAnzeigen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel56))
                .addGap(70, 70, 70))
        );

        javax.swing.GroupLayout ArtikelAnzeigeLayout = new javax.swing.GroupLayout(ArtikelAnzeige);
        ArtikelAnzeige.setLayout(ArtikelAnzeigeLayout);
        ArtikelAnzeigeLayout.setHorizontalGroup(
            ArtikelAnzeigeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator4, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(ArtikelAnzeigeLayout.createSequentialGroup()
                .addGroup(ArtikelAnzeigeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ArtikelAnzeigeLayout.createSequentialGroup()
                        .addGap(334, 334, 334)
                        .addComponent(jLabel37))
                    .addGroup(ArtikelAnzeigeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(ArtikelAnzeigeLayout.createSequentialGroup()
                            .addComponent(jbSpeichern_ArtikelAnzeigen, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jbbearbeiten_ArtikelAnzeigen, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jbabbrechen_ArtikelAnzeigen, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(ArtikelAnzeigeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(ArtikelAnzeigeLayout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addComponent(jLabel42)
                                .addGap(72, 72, 72)
                                .addComponent(jtfArtikelID_ArtikelAnzeigen, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(69, 69, 69)
                                .addComponent(jLabel43)
                                .addGap(56, 56, 56)
                                .addComponent(jtfartikelname_ArtikelAnzeigen, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(ArtikelAnzeigeLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(184, Short.MAX_VALUE))
        );
        ArtikelAnzeigeLayout.setVerticalGroup(
            ArtikelAnzeigeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ArtikelAnzeigeLayout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(jLabel37)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addGroup(ArtikelAnzeigeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel42)
                    .addComponent(jtfArtikelID_ArtikelAnzeigen, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel43)
                    .addComponent(jtfartikelname_ArtikelAnzeigen, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(ArtikelAnzeigeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbSpeichern_ArtikelAnzeigen, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbbearbeiten_ArtikelAnzeigen, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbabbrechen_ArtikelAnzeigen, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 979, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addGap(0, 29, Short.MAX_VALUE)
                    .addComponent(ArtikelAnzeige, javax.swing.GroupLayout.PREFERRED_SIZE, 950, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 800, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(ArtikelAnzeige, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jcbmehrwertsteuer_ArtikelAnzeigenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbmehrwertsteuer_ArtikelAnzeigenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbmehrwertsteuer_ArtikelAnzeigenActionPerformed

    private void jtfartikelname_ArtikelAnzeigenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfartikelname_ArtikelAnzeigenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfartikelname_ArtikelAnzeigenActionPerformed

    private void jbbearbeiten_ArtikelAnzeigenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbbearbeiten_ArtikelAnzeigenActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jbbearbeiten_ArtikelAnzeigenActionPerformed

    private void jtfreserviert_ArtikelAnzeigenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfreserviert_ArtikelAnzeigenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfreserviert_ArtikelAnzeigenActionPerformed

    private void jbabbrechen_ArtikelAnzeigenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbabbrechen_ArtikelAnzeigenActionPerformed
        /*----------------------------------------------------------*/
        /* 24.11.16 Yoeruek Schließt das Fenster nach Betätigung des Abbrech Buttons */
        /*----------------------------------------------------------*/
        this.setVisible(false);
    }//GEN-LAST:event_jbabbrechen_ArtikelAnzeigenActionPerformed

    private void jtfbestellwertnetto_ArtikelAnzeigenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfbestellwertnetto_ArtikelAnzeigenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfbestellwertnetto_ArtikelAnzeigenActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        /* 30.11.16 Yoeruek Öffnet über die Lupe Artikel-ID Suchen */
        myParent.oeffneArtikelIDSuchen();
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ArtikelAnzeige;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel140;
    private javax.swing.JLabel jLabel166;
    private javax.swing.JLabel jLabel167;
    private javax.swing.JLabel jLabel168;
    private javax.swing.JLabel jLabel169;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JButton jbSpeichern_ArtikelAnzeigen;
    private javax.swing.JButton jbabbrechen_ArtikelAnzeigen;
    private javax.swing.JButton jbbearbeiten_ArtikelAnzeigen;
    private javax.swing.JComboBox jcbmehrwertsteuer_ArtikelAnzeigen;
    private javax.swing.JTextArea jtaArtikeltext_ArtikelAnzeigen;
    private javax.swing.JScrollPane jtaBestelltext_ArtikelAnzeigen;
    private javax.swing.JTextField jtfArtikelID_ArtikelAnzeigen;
    private javax.swing.JTextField jtfartikelname_ArtikelAnzeigen;
    private javax.swing.JTextField jtfbestellwertbrutto_ArtikelAnzeigen;
    private javax.swing.JTextField jtfbestellwertnetto_ArtikelAnzeigen;
    private javax.swing.JTextField jtfeinzelwertbrutto_ArtikelAnzeigen;
    private javax.swing.JTextField jtfeinzelwertnetto_ArtikelAnzeigen;
    private javax.swing.JTextField jtffrei_ArtikelAnzeigen;
    private javax.swing.JTextField jtfreserviert_ArtikelAnzeigen;
    private javax.swing.JTextField jtfverkauft_ArtikelAnzeigen;
    private javax.swing.JTextField jtfzulauf_ArtikelAnzeigen;
    // End of variables declaration//GEN-END:variables


}
