/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.text.DecimalFormatSymbols;

/*----------------------------------------------------------*/
/* Datum Name Was */
/* 14.11.16 Yoeruek Erstellung*/
/* 24.11.16 Yoeruek Aufsplittung der StartAv Klasse in einzelne Klassen, da Code für eine Klasse zu lang. */
/*----------------------------------------------------------*/
public class ArtikelAnzeige extends javax.swing.JInternalFrame {

    /**
     * Creates new form ArtikelAnzeige
     */
    public ArtikelAnzeige() {
        initComponents();
        //Mehmet Impram 27.11.2016
        jtfArtikelID_ArtikelAnzeigen.setEnabled(false);
        jtfartikelname_ArtikelAnzeigen.setEnabled(false);
        jtffrei_ArtikelAnzeigen.setEnabled(false);
        jtfreserviert_ArtikelAnzeigen.setEnabled(false);
        jtfzulauf_ArtikelAnzeigen.setEnabled(false);
        jtfverkauft_ArtikelAnzeigen.setEnabled(false);
        jtfartikeltext_ArtikelAnzeigen.setEnabled(false);
        jtfbestelltext_ArtikelAnzeigen.setEnabled(false);
        jtfeinzelwertnetto_ArtikelAnzeigen.setEnabled(false);
        jtfeinzelwertbrutto_ArtikelAnzeigen.setEnabled(false);
        jtfbestellwertnetto_ArtikelAnzeigen.setEnabled(false);
        jtfbestellwertbrutto_ArtikelAnzeigen.setEnabled(false);
        jcbmehrwertsteuer_ArtikelAnzeigen.setEnabled(false);
                
        
         //Mechmet Impram
        jtfArtikelID_ArtikelAnzeigen.setDocument(new UniversalDokument(false, true, "", 5));
        jtfartikelname_ArtikelAnzeigen.setDocument(new UniversalDokument(true, false, "-. ' ", -1));
        jtffrei_ArtikelAnzeigen.setDocument(new UniversalDokument(false, true, "", 5));
        jtfreserviert_ArtikelAnzeigen.setDocument(new UniversalDokument(false, true, "", 5));
        jtfzulauf_ArtikelAnzeigen.setDocument(new UniversalDokument(false, true, "", 5));
        jtfverkauft_ArtikelAnzeigen.setDocument(new UniversalDokument(false, true, "", 5));
        jtfartikeltext_ArtikelAnzeigen.setDocument(new UniversalDokument(true, false, "-. ' ", -1));
        jtfbestelltext_ArtikelAnzeigen.setDocument(new UniversalDokument(true, true, "- . ' ", -1));
        jtfeinzelwertnetto_ArtikelAnzeigen.setDocument(new UniversalDokument(false, true, DecimalFormatSymbols.getInstance().getDecimalSeparator() + "", -1));
        jtfeinzelwertnetto_ArtikelAnzeigen.setInputVerifier(new UniversalVerifier("\\d+(\\" + DecimalFormatSymbols.getInstance().getDecimalSeparator() + "\\d\\d)?", "ungultiges format", "Bitte geben sie ein Preis mit 2 Nachkommastellen oder eine ganze Zahl"));
        jtfeinzelwertbrutto_ArtikelAnzeigen.setDocument(new UniversalDokument(false, true, DecimalFormatSymbols.getInstance().getDecimalSeparator() + "", -1));
        jtfeinzelwertbrutto_ArtikelAnzeigen.setInputVerifier(new UniversalVerifier("\\d+(\\" + DecimalFormatSymbols.getInstance().getDecimalSeparator() + "\\d\\d)?", "ungultiges format", "Bitte geben sie ein Preis mit 2 Nachkommastellen oder eine ganze Zahl"));
        jtfbestellwertnetto_ArtikelAnzeigen.setDocument(new UniversalDokument(false, true, DecimalFormatSymbols.getInstance().getDecimalSeparator() + "", -1));
        jtfbestellwertnetto_ArtikelAnzeigen.setInputVerifier(new UniversalVerifier("\\d+(\\" + DecimalFormatSymbols.getInstance().getDecimalSeparator() + "\\d\\d)?", "ungultiges format", "Bitte geben sie ein Preis mit 2 Nachkommastellen oder eine ganze Zahl"));
        jtfbestellwertbrutto_ArtikelAnzeigen.setDocument(new UniversalDokument(false, true, DecimalFormatSymbols.getInstance().getDecimalSeparator() + "", -1));
        jtfbestellwertbrutto_ArtikelAnzeigen.setInputVerifier(new UniversalVerifier("\\d+(\\" + DecimalFormatSymbols.getInstance().getDecimalSeparator() + "\\d\\d)?", "ungultiges format", "Bitte geben sie ein Preis mit 2 Nachkommastellen oder eine ganze Zahl"));
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ArtikelAnzeige = new javax.swing.JPanel();
        jLabel53 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        jtfbestellwertnetto_ArtikelAnzeigen = new javax.swing.JTextField();
        jLabel51 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jtfbestelltext_ArtikelAnzeigen = new javax.swing.JTextField();
        jtfartikeltext_ArtikelAnzeigen = new javax.swing.JTextField();
        jLabel55 = new javax.swing.JLabel();
        jcbmehrwertsteuer_ArtikelAnzeigen = new javax.swing.JComboBox();
        jLabel48 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jtfeinzelwertnetto_ArtikelAnzeigen = new javax.swing.JTextField();
        jtfbestellwertbrutto_ArtikelAnzeigen = new javax.swing.JTextField();
        jtffrei_ArtikelAnzeigen = new javax.swing.JTextField();
        jtfzulauf_ArtikelAnzeigen = new javax.swing.JTextField();
        jtfartikelname_ArtikelAnzeigen = new javax.swing.JTextField();
        jbbearbeiten_ArtikelAnzeigen = new javax.swing.JButton();
        jtfreserviert_ArtikelAnzeigen = new javax.swing.JTextField();
        jbabbrechen_ArtikelAnzeigen = new javax.swing.JButton();
        jtfverkauft_ArtikelAnzeigen = new javax.swing.JTextField();
        jtfeinzelwertbrutto_ArtikelAnzeigen = new javax.swing.JTextField();
        jLabel56 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jSeparator6 = new javax.swing.JSeparator();
        jtfArtikelID_ArtikelAnzeigen = new javax.swing.JTextField();
        jbSpeichern_ArtikelAnzeigen = new javax.swing.JButton();
        jLabel166 = new javax.swing.JLabel();
        jLabel167 = new javax.swing.JLabel();
        jLabel168 = new javax.swing.JLabel();
        jLabel169 = new javax.swing.JLabel();
        jLabel140 = new javax.swing.JLabel();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);

        ArtikelAnzeige.setPreferredSize(new java.awt.Dimension(1200, 800));

        jLabel53.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel53.setText("Bestellwert (Netto):");

        jLabel54.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel54.setText("(Brutto):");

        jtfbestellwertnetto_ArtikelAnzeigen.setMinimumSize(new java.awt.Dimension(6, 25));
        jtfbestellwertnetto_ArtikelAnzeigen.setPreferredSize(new java.awt.Dimension(6, 25));

        jLabel51.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel51.setText("Einzelwert (Netto):");

        jLabel52.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel52.setText("(Brutto):");

        jLabel50.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel50.setText("Bestelltext:");

        jtfbestelltext_ArtikelAnzeigen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfbestelltext_ArtikelAnzeigenActionPerformed(evt);
            }
        });

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

        jLabel48.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel48.setText("Verkauft:");

        jLabel47.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel47.setText("Reserviert:");

        jLabel46.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel46.setText("Zulauf:");

        jLabel45.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel45.setText("Frei:");

        jLabel44.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel44.setText("Bestandsmengen");

        jLabel43.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel43.setText("Artikelname:");

        jLabel42.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel42.setText("Artikel-ID:");

        jtfeinzelwertnetto_ArtikelAnzeigen.setMinimumSize(new java.awt.Dimension(6, 25));
        jtfeinzelwertnetto_ArtikelAnzeigen.setPreferredSize(new java.awt.Dimension(6, 25));

        jtfbestellwertbrutto_ArtikelAnzeigen.setMinimumSize(new java.awt.Dimension(6, 25));
        jtfbestellwertbrutto_ArtikelAnzeigen.setPreferredSize(new java.awt.Dimension(6, 25));

        jtffrei_ArtikelAnzeigen.setMinimumSize(new java.awt.Dimension(6, 25));
        jtffrei_ArtikelAnzeigen.setPreferredSize(new java.awt.Dimension(6, 25));

        jtfzulauf_ArtikelAnzeigen.setMinimumSize(new java.awt.Dimension(6, 25));
        jtfzulauf_ArtikelAnzeigen.setPreferredSize(new java.awt.Dimension(6, 25));

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

        jtfreserviert_ArtikelAnzeigen.setMinimumSize(new java.awt.Dimension(6, 25));
        jtfreserviert_ArtikelAnzeigen.setPreferredSize(new java.awt.Dimension(6, 25));
        jtfreserviert_ArtikelAnzeigen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfreserviert_ArtikelAnzeigenActionPerformed(evt);
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

        jtfverkauft_ArtikelAnzeigen.setMinimumSize(new java.awt.Dimension(6, 25));
        jtfverkauft_ArtikelAnzeigen.setPreferredSize(new java.awt.Dimension(6, 25));

        jtfeinzelwertbrutto_ArtikelAnzeigen.setMinimumSize(new java.awt.Dimension(6, 25));
        jtfeinzelwertbrutto_ArtikelAnzeigen.setPreferredSize(new java.awt.Dimension(6, 25));

        jLabel56.setText("%");

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

        jLabel166.setText("€");

        jLabel167.setText("€");

        jLabel168.setText("€");

        jLabel169.setText("€");

        jLabel140.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel140.setText("Artikeltext:");

        javax.swing.GroupLayout ArtikelAnzeigeLayout = new javax.swing.GroupLayout(ArtikelAnzeige);
        ArtikelAnzeige.setLayout(ArtikelAnzeigeLayout);
        ArtikelAnzeigeLayout.setHorizontalGroup(
            ArtikelAnzeigeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator6, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(ArtikelAnzeigeLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ArtikelAnzeigeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ArtikelAnzeigeLayout.createSequentialGroup()
                        .addComponent(jLabel42)
                        .addGap(57, 57, 57)
                        .addGroup(ArtikelAnzeigeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtfartikelname_ArtikelAnzeigen, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfArtikelID_ArtikelAnzeigen, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(ArtikelAnzeigeLayout.createSequentialGroup()
                        .addGroup(ArtikelAnzeigeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel55)
                            .addComponent(jLabel44)
                            .addComponent(jLabel43)
                            .addGroup(ArtikelAnzeigeLayout.createSequentialGroup()
                                .addGroup(ArtikelAnzeigeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(ArtikelAnzeigeLayout.createSequentialGroup()
                                        .addComponent(jLabel46)
                                        .addGap(74, 74, 74)
                                        .addGroup(ArtikelAnzeigeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jtffrei_ArtikelAnzeigen, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jtfzulauf_ArtikelAnzeigen, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(jLabel45, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(103, 103, 103)
                                .addGroup(ArtikelAnzeigeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel47)
                                    .addComponent(jLabel48))
                                .addGap(26, 26, 26)
                                .addGroup(ArtikelAnzeigeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jtfverkauft_ArtikelAnzeigen, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jtfreserviert_ArtikelAnzeigen, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ArtikelAnzeigeLayout.createSequentialGroup()
                                .addComponent(jbSpeichern_ArtikelAnzeigen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jbbearbeiten_ArtikelAnzeigen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jbabbrechen_ArtikelAnzeigen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(ArtikelAnzeigeLayout.createSequentialGroup()
                                .addGroup(ArtikelAnzeigeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jtfbestelltext_ArtikelAnzeigen, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel51)
                                    .addGroup(ArtikelAnzeigeLayout.createSequentialGroup()
                                        .addGap(173, 173, 173)
                                        .addGroup(ArtikelAnzeigeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(ArtikelAnzeigeLayout.createSequentialGroup()
                                                .addComponent(jtfbestellwertnetto_ArtikelAnzeigen, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel167))
                                            .addGroup(ArtikelAnzeigeLayout.createSequentialGroup()
                                                .addComponent(jtfeinzelwertnetto_ArtikelAnzeigen, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel166, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(ArtikelAnzeigeLayout.createSequentialGroup()
                                                .addComponent(jcbmehrwertsteuer_ArtikelAnzeigen, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel56, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addComponent(jLabel53)
                                    .addComponent(jLabel50))
                                .addGap(108, 108, 108)
                                .addGroup(ArtikelAnzeigeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel140)
                                    .addComponent(jtfartikeltext_ArtikelAnzeigen, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(ArtikelAnzeigeLayout.createSequentialGroup()
                                        .addGroup(ArtikelAnzeigeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addGroup(ArtikelAnzeigeLayout.createSequentialGroup()
                                                .addComponent(jLabel54)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jtfbestellwertbrutto_ArtikelAnzeigen, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(ArtikelAnzeigeLayout.createSequentialGroup()
                                                .addComponent(jLabel52)
                                                .addGap(32, 32, 32)
                                                .addComponent(jtfeinzelwertbrutto_ArtikelAnzeigen, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(ArtikelAnzeigeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel168)
                                            .addComponent(jLabel169))))))
                        .addContainerGap(630, Short.MAX_VALUE))))
            .addComponent(jSeparator4, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(ArtikelAnzeigeLayout.createSequentialGroup()
                .addGap(334, 334, 334)
                .addComponent(jLabel37)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jSeparator5)
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
                    .addComponent(jtfArtikelID_ArtikelAnzeigen, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(ArtikelAnzeigeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel43)
                    .addComponent(jtfartikelname_ArtikelAnzeigen, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel44)
                .addGap(15, 15, 15)
                .addGroup(ArtikelAnzeigeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel45)
                    .addComponent(jtffrei_ArtikelAnzeigen, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel47)
                    .addComponent(jtfreserviert_ArtikelAnzeigen, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 22, Short.MAX_VALUE)
                .addGroup(ArtikelAnzeigeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtfzulauf_ArtikelAnzeigen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(ArtikelAnzeigeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel46)
                        .addComponent(jLabel48)
                        .addComponent(jtfverkauft_ArtikelAnzeigen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addGroup(ArtikelAnzeigeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel50)
                    .addComponent(jLabel140))
                .addGap(2, 2, 2)
                .addGroup(ArtikelAnzeigeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfartikeltext_ArtikelAnzeigen, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfbestelltext_ArtikelAnzeigen, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 22, Short.MAX_VALUE)
                .addGroup(ArtikelAnzeigeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel51)
                    .addComponent(jLabel52)
                    .addComponent(jLabel168)
                    .addComponent(jtfeinzelwertnetto_ArtikelAnzeigen, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel166)
                    .addComponent(jtfeinzelwertbrutto_ArtikelAnzeigen, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(ArtikelAnzeigeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfbestellwertnetto_ArtikelAnzeigen, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel53)
                    .addComponent(jLabel167)
                    .addComponent(jLabel54)
                    .addComponent(jtfbestellwertbrutto_ArtikelAnzeigen, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel169))
                .addGap(18, 18, 18)
                .addGroup(ArtikelAnzeigeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel55)
                    .addComponent(jcbmehrwertsteuer_ArtikelAnzeigen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel56))
                .addGap(19, 19, 19)
                .addGroup(ArtikelAnzeigeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbSpeichern_ArtikelAnzeigen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbbearbeiten_ArtikelAnzeigen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbabbrechen_ArtikelAnzeigen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(127, 127, 127))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1395, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(ArtikelAnzeige, javax.swing.GroupLayout.DEFAULT_SIZE, 1375, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 798, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(ArtikelAnzeige, javax.swing.GroupLayout.DEFAULT_SIZE, 784, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtfbestelltext_ArtikelAnzeigenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfbestelltext_ArtikelAnzeigenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfbestelltext_ArtikelAnzeigenActionPerformed

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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ArtikelAnzeige;
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
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JButton jbSpeichern_ArtikelAnzeigen;
    private javax.swing.JButton jbabbrechen_ArtikelAnzeigen;
    private javax.swing.JButton jbbearbeiten_ArtikelAnzeigen;
    private javax.swing.JComboBox jcbmehrwertsteuer_ArtikelAnzeigen;
    private javax.swing.JTextField jtfArtikelID_ArtikelAnzeigen;
    private javax.swing.JTextField jtfartikelname_ArtikelAnzeigen;
    private javax.swing.JTextField jtfartikeltext_ArtikelAnzeigen;
    private javax.swing.JTextField jtfbestelltext_ArtikelAnzeigen;
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
