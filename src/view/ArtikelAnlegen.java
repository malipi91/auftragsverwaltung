/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.text.DecimalFormatSymbols;
import javax.swing.JOptionPane;

/*----------------------------------------------------------------------------*/
 /* Datum    Name    Was */
 /* 15.11.16 Impram  Erstellung*/
 /* 24.11.16 Yoeruek Aufsplittung der StartAv Klasse in einzelne Klassen, da 
                     Code für eine Klasse zu lang. */
 /* 27.11.16 Impram  Anpassung der Größenverhältnisse (Schriftart, Layout)*/
 /*---------------------------------------------------------------------------*/
public class ArtikelAnlegen extends javax.swing.JInternalFrame {

    public ArtikelAnlegen() {
        initComponents();

 /*---------------------------------------------------------------------------*/
 /* 29.11.16    Yoeruek    Wird inaktiv gesetzt und der generierte            */
 /*                          freie Code von der DB gezogen                    */
 /*---------------------------------------------------------------------------*/
        jtfartikelid_ArtikelAnlegen.setEnabled(false);

        //Mechmet Impram
        jtfartikelid_ArtikelAnlegen.setDocument(new UniversalDokument(false, true, "", 5));
        jtfartikelname_ArtikelAnlegen.setDocument(new UniversalDokument(true, false, "-. ' ", -1));
        jtffrei_ArtikelAnlegen.setDocument(new UniversalDokument(false, true, "", 5));
        jtfreserviert_ArtikelAnlegen.setDocument(new UniversalDokument(false, true, "", 5));
        jtfzulauf_ArtikelAnlegen.setDocument(new UniversalDokument(false, true, "", 5));
        jtfverkauft_ArtikelAnlegen.setDocument(new UniversalDokument(false, true, "", 5));
        jtaArtikeltext_ArtikelAnlegen.setDocument(new UniversalDokument(true, false, "-. ' ", -1));
        jtaBestelltext_ArtikelAnlegen.setDocument(new UniversalDokument(true, true, "- . ' ", -1));
        jtfeinzelwertnetto_ArtikelAnlegen.setDocument(new UniversalDokument(false, true, DecimalFormatSymbols.getInstance().getDecimalSeparator() + "", -1));
        jtfeinzelwertnetto_ArtikelAnlegen.setInputVerifier(new UniversalVerifier("\\d+(\\" + DecimalFormatSymbols.getInstance().getDecimalSeparator() + "\\d\\d)?", "ungultiges format", "Bitte geben sie ein Preis mit 2 Nachkommastellen oder eine ganze Zahl"));
        jtfeinzelwertbrutto_ArtikelAnlegen.setDocument(new UniversalDokument(false, true, DecimalFormatSymbols.getInstance().getDecimalSeparator() + "", -1));
        jtfeinzelwertbrutto_ArtikelAnlegen.setInputVerifier(new UniversalVerifier("\\d+(\\" + DecimalFormatSymbols.getInstance().getDecimalSeparator() + "\\d\\d)?", "ungultiges format", "Bitte geben sie ein Preis mit 2 Nachkommastellen oder eine ganze Zahl"));
        jtfbestellwertnetto_ArtikelAnlegen.setDocument(new UniversalDokument(false, true, DecimalFormatSymbols.getInstance().getDecimalSeparator() + "", -1));
        jtfbestellwertnetto_ArtikelAnlegen.setInputVerifier(new UniversalVerifier("\\d+(\\" + DecimalFormatSymbols.getInstance().getDecimalSeparator() + "\\d\\d)?", "ungultiges format", "Bitte geben sie ein Preis mit 2 Nachkommastellen oder eine ganze Zahl"));
        jtfbestellwertbrutto_ArtikelAnlegen.setDocument(new UniversalDokument(false, true, DecimalFormatSymbols.getInstance().getDecimalSeparator() + "", -1));
        jtfbestellwertbrutto_ArtikelAnlegen.setInputVerifier(new UniversalVerifier("\\d+(\\" + DecimalFormatSymbols.getInstance().getDecimalSeparator() + "\\d\\d)?", "ungultiges format", "Bitte geben sie ein Preis mit 2 Nachkommastellen oder eine ganze Zahl"));

    }

//        public int gibArtikeID(){
//        return bekommeLetzteID(String artikel);           
//         }  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ArtikelAnlegen = new javax.swing.JPanel();
        jLabel39 = new javax.swing.JLabel();
        jSeparator13 = new javax.swing.JSeparator();
        jbAbbrechen_ArtikelAnlegen = new javax.swing.JButton();
        jbSpeichern_ArtikelAnlegen = new javax.swing.JButton();
        jtfartikelname_ArtikelAnlegen = new javax.swing.JTextField();
        jtfartikelid_ArtikelAnlegen = new javax.swing.JTextField();
        jLabel64 = new javax.swing.JLabel();
        jLabel65 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel66 = new javax.swing.JLabel();
        jLabel67 = new javax.swing.JLabel();
        jtffrei_ArtikelAnlegen = new javax.swing.JTextField();
        jLabel68 = new javax.swing.JLabel();
        jtfzulauf_ArtikelAnlegen = new javax.swing.JTextField();
        jtfverkauft_ArtikelAnlegen = new javax.swing.JTextField();
        jLabel69 = new javax.swing.JLabel();
        jtfreserviert_ArtikelAnlegen = new javax.swing.JTextField();
        jLabel70 = new javax.swing.JLabel();
        jLabel63 = new javax.swing.JLabel();
        jLabel71 = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        jtfeinzelwertnetto_ArtikelAnlegen = new javax.swing.JTextField();
        jLabel170 = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        jtfeinzelwertbrutto_ArtikelAnlegen = new javax.swing.JTextField();
        jLabel172 = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        jtfbestellwertnetto_ArtikelAnlegen = new javax.swing.JTextField();
        jLabel171 = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        jtfbestellwertbrutto_ArtikelAnlegen = new javax.swing.JTextField();
        jLabel173 = new javax.swing.JLabel();
        jcbMwst_ArtikelAnlegen = new javax.swing.JComboBox();
        jLabel58 = new javax.swing.JLabel();
        jLabel72 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtaBestelltext_ArtikelAnlegen = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtaArtikeltext_ArtikelAnlegen = new javax.swing.JTextArea();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);

        ArtikelAnlegen.setPreferredSize(new java.awt.Dimension(1200, 900));

        jLabel39.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel39.setText("Artikel Anlegen");

        jbAbbrechen_ArtikelAnlegen.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jbAbbrechen_ArtikelAnlegen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/abbruch2.png"))); // NOI18N
        jbAbbrechen_ArtikelAnlegen.setText("Abbrechen");
        jbAbbrechen_ArtikelAnlegen.setPreferredSize(new java.awt.Dimension(130, 35));
        jbAbbrechen_ArtikelAnlegen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAbbrechen_ArtikelAnlegenActionPerformed(evt);
            }
        });

        jbSpeichern_ArtikelAnlegen.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jbSpeichern_ArtikelAnlegen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/speichern2.png"))); // NOI18N
        jbSpeichern_ArtikelAnlegen.setText("Speichern");
        jbSpeichern_ArtikelAnlegen.setPreferredSize(new java.awt.Dimension(130, 35));
        jbSpeichern_ArtikelAnlegen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSpeichern_ArtikelAnlegenActionPerformed(evt);
            }
        });

        jtfartikelname_ArtikelAnlegen.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtfartikelname_ArtikelAnlegen.setMinimumSize(new java.awt.Dimension(6, 25));
        jtfartikelname_ArtikelAnlegen.setPreferredSize(new java.awt.Dimension(6, 25));

        jtfartikelid_ArtikelAnlegen.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtfartikelid_ArtikelAnlegen.setMinimumSize(new java.awt.Dimension(6, 25));
        jtfartikelid_ArtikelAnlegen.setPreferredSize(new java.awt.Dimension(6, 25));
        jtfartikelid_ArtikelAnlegen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfartikelid_ArtikelAnlegenActionPerformed(evt);
            }
        });

        jLabel64.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel64.setText("Artikel-ID:");

        jLabel65.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel65.setText("Artikelname:");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel66.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel66.setText("Bestandsmengen");

        jLabel67.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel67.setText("Frei:");

        jtffrei_ArtikelAnlegen.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtffrei_ArtikelAnlegen.setMinimumSize(new java.awt.Dimension(6, 25));
        jtffrei_ArtikelAnlegen.setPreferredSize(new java.awt.Dimension(6, 25));

        jLabel68.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel68.setText("Zulauf:");

        jtfzulauf_ArtikelAnlegen.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtfzulauf_ArtikelAnlegen.setMinimumSize(new java.awt.Dimension(6, 25));
        jtfzulauf_ArtikelAnlegen.setPreferredSize(new java.awt.Dimension(6, 25));

        jtfverkauft_ArtikelAnlegen.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtfverkauft_ArtikelAnlegen.setMinimumSize(new java.awt.Dimension(6, 25));
        jtfverkauft_ArtikelAnlegen.setPreferredSize(new java.awt.Dimension(6, 25));
        jtfverkauft_ArtikelAnlegen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfverkauft_ArtikelAnlegenActionPerformed(evt);
            }
        });

        jLabel69.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel69.setText("Reserviert:");

        jtfreserviert_ArtikelAnlegen.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtfreserviert_ArtikelAnlegen.setMinimumSize(new java.awt.Dimension(6, 25));
        jtfreserviert_ArtikelAnlegen.setPreferredSize(new java.awt.Dimension(6, 25));

        jLabel70.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel70.setText("Verkauft:");

        jLabel63.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel63.setText("Bestelltext:");

        jLabel71.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel71.setText("Artikeltext:");

        jLabel59.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel59.setText("Einzelwert (Netto):");

        jtfeinzelwertnetto_ArtikelAnlegen.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtfeinzelwertnetto_ArtikelAnlegen.setMinimumSize(new java.awt.Dimension(6, 25));
        jtfeinzelwertnetto_ArtikelAnlegen.setPreferredSize(new java.awt.Dimension(6, 25));
        jtfeinzelwertnetto_ArtikelAnlegen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfeinzelwertnetto_ArtikelAnlegenActionPerformed(evt);
            }
        });

        jLabel170.setText("€");

        jLabel62.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel62.setText("Einzelwert (Brutto):");

        jtfeinzelwertbrutto_ArtikelAnlegen.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtfeinzelwertbrutto_ArtikelAnlegen.setMinimumSize(new java.awt.Dimension(6, 25));
        jtfeinzelwertbrutto_ArtikelAnlegen.setPreferredSize(new java.awt.Dimension(6, 25));
        jtfeinzelwertbrutto_ArtikelAnlegen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfeinzelwertbrutto_ArtikelAnlegenActionPerformed(evt);
            }
        });

        jLabel172.setText("€");

        jLabel60.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel60.setText("Bestellwert (Netto):");

        jtfbestellwertnetto_ArtikelAnlegen.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtfbestellwertnetto_ArtikelAnlegen.setMinimumSize(new java.awt.Dimension(6, 25));
        jtfbestellwertnetto_ArtikelAnlegen.setPreferredSize(new java.awt.Dimension(6, 25));

        jLabel171.setText("€");

        jLabel61.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel61.setText("Bestellwert (Brutto):");

        jtfbestellwertbrutto_ArtikelAnlegen.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtfbestellwertbrutto_ArtikelAnlegen.setMinimumSize(new java.awt.Dimension(6, 25));
        jtfbestellwertbrutto_ArtikelAnlegen.setPreferredSize(new java.awt.Dimension(6, 25));

        jLabel173.setText("€");

        jcbMwst_ArtikelAnlegen.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "", "7", "19" }));
        jcbMwst_ArtikelAnlegen.setMinimumSize(new java.awt.Dimension(37, 25));
        jcbMwst_ArtikelAnlegen.setPreferredSize(new java.awt.Dimension(37, 25));
        jcbMwst_ArtikelAnlegen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbMwst_ArtikelAnlegenActionPerformed(evt);
            }
        });

        jLabel58.setText("%");

        jLabel72.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel72.setText("MwST-Satz:");

        jtaBestelltext_ArtikelAnlegen.setColumns(20);
        jtaBestelltext_ArtikelAnlegen.setRows(5);
        jScrollPane1.setViewportView(jtaBestelltext_ArtikelAnlegen);

        jtaArtikeltext_ArtikelAnlegen.setColumns(20);
        jtaArtikeltext_ArtikelAnlegen.setRows(5);
        jScrollPane2.setViewportView(jtaArtikeltext_ArtikelAnlegen);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel71)
                        .addGap(618, 618, 618))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel63)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel72)
                                .addGap(65, 65, 65)
                                .addComponent(jcbMwst_ArtikelAnlegen, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel58, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel67, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel68))
                                            .addGap(84, 84, 84)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jtfzulauf_ArtikelAnlegen, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jtffrei_ArtikelAnlegen, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGap(97, 97, 97)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel70)
                                                .addComponent(jLabel69)))
                                        .addComponent(jLabel66))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jtfreserviert_ArtikelAnlegen, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jtfverkauft_ArtikelAnlegen, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 707, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel60)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(jtfbestellwertnetto_ArtikelAnlegen, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jLabel171))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel59)
                                            .addGap(18, 18, 18)
                                            .addComponent(jtfeinzelwertnetto_ArtikelAnlegen, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jLabel170)))
                                    .addGap(75, 75, 75)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel62)
                                        .addComponent(jLabel61))
                                    .addGap(18, 18, 18)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(jtfeinzelwertbrutto_ArtikelAnlegen, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jLabel172))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(jtfbestellwertbrutto_ArtikelAnlegen, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jLabel173))))
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 710, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 27, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel66)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel67)
                            .addComponent(jtffrei_ArtikelAnlegen, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel68)
                            .addComponent(jtfzulauf_ArtikelAnlegen, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel69)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel70))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jtfverkauft_ArtikelAnlegen, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jtfreserviert_ArtikelAnlegen, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(36, 36, 36)
                .addComponent(jLabel63)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(jLabel71)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel59)
                            .addComponent(jtfeinzelwertnetto_ArtikelAnlegen, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel170))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel60)
                            .addComponent(jtfbestellwertnetto_ArtikelAnlegen, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel171))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jcbMwst_ArtikelAnlegen, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel72)
                                .addComponent(jLabel58))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtfeinzelwertbrutto_ArtikelAnlegen, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel172)
                            .addComponent(jLabel62))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel173, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfbestellwertbrutto_ArtikelAnlegen, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel61))))
                .addGap(43, 43, 43))
        );

        javax.swing.GroupLayout ArtikelAnlegenLayout = new javax.swing.GroupLayout(ArtikelAnlegen);
        ArtikelAnlegen.setLayout(ArtikelAnlegenLayout);
        ArtikelAnlegenLayout.setHorizontalGroup(
            ArtikelAnlegenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator13, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(ArtikelAnlegenLayout.createSequentialGroup()
                .addGap(356, 356, 356)
                .addComponent(jLabel39)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(ArtikelAnlegenLayout.createSequentialGroup()
                .addGroup(ArtikelAnlegenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(ArtikelAnlegenLayout.createSequentialGroup()
                        .addComponent(jbSpeichern_ArtikelAnlegen, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jbAbbrechen_ArtikelAnlegen, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(ArtikelAnlegenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(ArtikelAnlegenLayout.createSequentialGroup()
                            .addGap(78, 78, 78)
                            .addComponent(jLabel64)
                            .addGap(61, 61, 61)
                            .addComponent(jtfartikelid_ArtikelAnlegen, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(89, 89, 89)
                            .addComponent(jLabel65)
                            .addGap(87, 87, 87)
                            .addComponent(jtfartikelname_ArtikelAnlegen, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(ArtikelAnlegenLayout.createSequentialGroup()
                            .addGap(64, 64, 64)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(22, 133, Short.MAX_VALUE))
        );
        ArtikelAnlegenLayout.setVerticalGroup(
            ArtikelAnlegenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ArtikelAnlegenLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel39)
                .addGap(11, 11, 11)
                .addComponent(jSeparator13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(ArtikelAnlegenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfartikelid_ArtikelAnlegen, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel64)
                    .addComponent(jtfartikelname_ArtikelAnlegen, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel65))
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(ArtikelAnlegenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbSpeichern_ArtikelAnlegen, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbAbbrechen_ArtikelAnlegen, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(60, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ArtikelAnlegen, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 950, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ArtikelAnlegen, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtfeinzelwertbrutto_ArtikelAnlegenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfeinzelwertbrutto_ArtikelAnlegenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfeinzelwertbrutto_ArtikelAnlegenActionPerformed

    private void jbAbbrechen_ArtikelAnlegenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAbbrechen_ArtikelAnlegenActionPerformed
  /*----------------------------------------------------------*/
 /* 24.11.16 Yoeruek Schließt das Fenster nach Betätigung des Abbrech Buttons */
 /*----------------------------------------------------------*/
        this.setVisible(false);

    }//GEN-LAST:event_jbAbbrechen_ArtikelAnlegenActionPerformed
    /*----------------------------------------------------------*/
 /* 20.11.16 Impram Schließt das Fenster nach Betätigung des Abbrech Buttons */
 /*----------------------------------------------------------*/
    private boolean istVollstaendig() {
        boolean istVollstaendig = false;
        String fehlermeldung = "";
        if (jtfartikelid_ArtikelAnlegen.getText().equals("")) {
            fehlermeldung = "Bitte geben Sie Artikel ID an";
            jtfartikelid_ArtikelAnlegen.requestFocusInWindow();
        } else if (jtfartikelname_ArtikelAnlegen.getText().equals("")) {
            fehlermeldung = "Bitte geben Sie Artikel Name an";
        } else if (jtffrei_ArtikelAnlegen.getText().equals("")) {
            fehlermeldung = "Bitte die freie Menge eingeben.";
            jtffrei_ArtikelAnlegen.requestFocusInWindow();
        } else if (jtfzulauf_ArtikelAnlegen.getText().equals("")) {
            fehlermeldung = "Bitte die Zulauf Menge eingeben.";
        } else if (jtfreserviert_ArtikelAnlegen.getText().equals("")) {
            fehlermeldung = "Bitte die reservierte Menge eingeben";
        } else if (jtfverkauft_ArtikelAnlegen.getText().equals("")) {
            fehlermeldung = "Bitte die verkaufte Menge eingeben";
        } else if (jtaBestelltext_ArtikelAnlegen.getText().equals("")) {
            fehlermeldung = "Bitte den Bestelltext eingeben.";
        } else if (jtaArtikeltext_ArtikelAnlegen.getText().equals("")) {
            fehlermeldung = "Bitte den Artikeltext eingeben.";

        } else if (jtfeinzelwertnetto_ArtikelAnlegen.getText().equals("")) {
            fehlermeldung = "Bitte geben Sie den EinzelWert Netto ein, eine ganze Zahl oder 2 nach Kommastellen";
        } else if (jtfeinzelwertbrutto_ArtikelAnlegen.getText().equals("")) {
            fehlermeldung = "Bitte geben Sie den EinzelWert Netto ein, eine ganze Zahl oder 2 nach Kommastellen";
        } else if (jtfbestellwertnetto_ArtikelAnlegen.getText().equals("")) {
            fehlermeldung = "Bitte geben Sie den BestellWert Netto ein, eine ganze Zahl oder 2 nach Kommastellen";

        } else if (jtfbestellwertbrutto_ArtikelAnlegen.getText().equals("")) {
            fehlermeldung = "Bitte geben Sie den BestellWert Brutto ein, eine ganze Zahl oder 2 nach Kommastellen";
        } else if (jcbMwst_ArtikelAnlegen.getSelectedIndex() == 0) {
            fehlermeldung = "Wählen Sie Bitte den MSWT";
        }

        if (fehlermeldung.equals("")) {
            istVollstaendig = true;
        } else {
            JOptionPane.showMessageDialog(this, fehlermeldung, "Unvollständig", JOptionPane.WARNING_MESSAGE);
        }
        return istVollstaendig;

    }


    private void jbSpeichern_ArtikelAnlegenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSpeichern_ArtikelAnlegenActionPerformed
        // TODO add your handling code here:
        if (istVollstaendig()) {

        }
    }//GEN-LAST:event_jbSpeichern_ArtikelAnlegenActionPerformed

    private void jtfartikelid_ArtikelAnlegenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfartikelid_ArtikelAnlegenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfartikelid_ArtikelAnlegenActionPerformed

    private void jcbMwst_ArtikelAnlegenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbMwst_ArtikelAnlegenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbMwst_ArtikelAnlegenActionPerformed

    private void jtfeinzelwertnetto_ArtikelAnlegenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfeinzelwertnetto_ArtikelAnlegenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfeinzelwertnetto_ArtikelAnlegenActionPerformed

    private void jtfverkauft_ArtikelAnlegenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfverkauft_ArtikelAnlegenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfverkauft_ArtikelAnlegenActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ArtikelAnlegen;
    private javax.swing.JLabel jLabel170;
    private javax.swing.JLabel jLabel171;
    private javax.swing.JLabel jLabel172;
    private javax.swing.JLabel jLabel173;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator13;
    private javax.swing.JButton jbAbbrechen_ArtikelAnlegen;
    private javax.swing.JButton jbSpeichern_ArtikelAnlegen;
    private javax.swing.JComboBox jcbMwst_ArtikelAnlegen;
    private javax.swing.JTextArea jtaArtikeltext_ArtikelAnlegen;
    private javax.swing.JTextArea jtaBestelltext_ArtikelAnlegen;
    private javax.swing.JTextField jtfartikelid_ArtikelAnlegen;
    private javax.swing.JTextField jtfartikelname_ArtikelAnlegen;
    private javax.swing.JTextField jtfbestellwertbrutto_ArtikelAnlegen;
    private javax.swing.JTextField jtfbestellwertnetto_ArtikelAnlegen;
    private javax.swing.JTextField jtfeinzelwertbrutto_ArtikelAnlegen;
    private javax.swing.JTextField jtfeinzelwertnetto_ArtikelAnlegen;
    private javax.swing.JTextField jtffrei_ArtikelAnlegen;
    private javax.swing.JTextField jtfreserviert_ArtikelAnlegen;
    private javax.swing.JTextField jtfverkauft_ArtikelAnlegen;
    private javax.swing.JTextField jtfzulauf_ArtikelAnlegen;
    // End of variables declaration//GEN-END:variables
}
