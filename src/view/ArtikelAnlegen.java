/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.text.DecimalFormatSymbols;
import javax.swing.JOptionPane;

/**
 *
 * @author Hicran Yoeruek
 */
public class ArtikelAnlegen extends javax.swing.JInternalFrame {

    /**
     * Creates new form ArtikelAnlegen
     */
    public ArtikelAnlegen() {
        initComponents();
        //Mechmet Impram
        jtfartikelid_ArtikelAnlegen.setDocument(new UniversalDokument(false, true, "", 5));
        jtfartikelname_ArtikelAnlegen.setDocument(new UniversalDokument(true, false, "-. ' ", -1));
        jtffrei_ArtikelAnlegen.setDocument(new UniversalDokument(false, true, "", 5));
        jtfreserviert_ArtikelAnlegen.setDocument(new UniversalDokument(false, true, "", 5));
        jtfzulauf_ArtikelAnlegen.setDocument(new UniversalDokument(false, true, "", 5));
        jtfverkauft_ArtikelAnlegen.setDocument(new UniversalDokument(false, true, "", 5));
        jtfartikeltext_ArtikelAnlegen.setDocument(new UniversalDokument(true, false, "-. ' ", -1));
        jtfbestelltext_ArtikelAnlegen.setDocument(new UniversalDokument(true, true, "- . ' ", -1));
        jtfeinzelwertnetto_ArtikelAnlegen.setDocument(new UniversalDokument(false, true, DecimalFormatSymbols.getInstance().getDecimalSeparator() + "", -1));
        jtfeinzelwertnetto_ArtikelAnlegen.setInputVerifier(new UniversalVerifier("\\d+(\\" + DecimalFormatSymbols.getInstance().getDecimalSeparator() + "\\d\\d)?", "ungultiges format", "Bitte geben sie ein Preis mit 2 Nachkommastellen oder eine ganze Zahl"));
        jtfeinzelwertbrutto_ArtikelAnlegen.setDocument(new UniversalDokument(false, true, DecimalFormatSymbols.getInstance().getDecimalSeparator() + "", -1));
        jtfeinzelwertbrutto_ArtikelAnlegen.setInputVerifier(new UniversalVerifier("\\d+(\\" + DecimalFormatSymbols.getInstance().getDecimalSeparator() + "\\d\\d)?", "ungultiges format", "Bitte geben sie ein Preis mit 2 Nachkommastellen oder eine ganze Zahl"));
        jtfbestellwertnetto_ArtikelAnlegen.setDocument(new UniversalDokument(false, true, DecimalFormatSymbols.getInstance().getDecimalSeparator() + "", -1));
        jtfbestellwertnetto_ArtikelAnlegen.setInputVerifier(new UniversalVerifier("\\d+(\\" + DecimalFormatSymbols.getInstance().getDecimalSeparator() + "\\d\\d)?", "ungultiges format", "Bitte geben sie ein Preis mit 2 Nachkommastellen oder eine ganze Zahl"));
        jtfbestellwertbrutto_ArtikelAnlegen.setDocument(new UniversalDokument(false, true, DecimalFormatSymbols.getInstance().getDecimalSeparator() + "", -1));
        jtfbestellwertbrutto_ArtikelAnlegen.setInputVerifier(new UniversalVerifier("\\d+(\\" + DecimalFormatSymbols.getInstance().getDecimalSeparator() + "\\d\\d)?", "ungultiges format", "Bitte geben sie ein Preis mit 2 Nachkommastellen oder eine ganze Zahl"));
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ArtikelAnlegen = new javax.swing.JPanel();
        jSeparator11 = new javax.swing.JSeparator();
        jSeparator12 = new javax.swing.JSeparator();
        jLabel39 = new javax.swing.JLabel();
        jSeparator13 = new javax.swing.JSeparator();
        jLabel58 = new javax.swing.JLabel();
        jtfeinzelwertbrutto_ArtikelAnlegen = new javax.swing.JTextField();
        jtfverkauft_ArtikelAnlegen = new javax.swing.JTextField();
        jbAbbrechen_ArtikelAnlegen = new javax.swing.JButton();
        jtfbestellwertnetto_ArtikelAnlegen = new javax.swing.JTextField();
        jtfreserviert_ArtikelAnlegen = new javax.swing.JTextField();
        jLabel59 = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        jbSpeichern_ArtikelAnlegen = new javax.swing.JButton();
        jLabel61 = new javax.swing.JLabel();
        jtfartikelname_ArtikelAnlegen = new javax.swing.JTextField();
        jtfbestelltext_ArtikelAnlegen = new javax.swing.JTextField();
        jtfbestellwertbrutto_ArtikelAnlegen = new javax.swing.JTextField();
        jtfzulauf_ArtikelAnlegen = new javax.swing.JTextField();
        jtfartikeltext_ArtikelAnlegen = new javax.swing.JTextField();
        jtffrei_ArtikelAnlegen = new javax.swing.JTextField();
        jLabel62 = new javax.swing.JLabel();
        jtfartikelid_ArtikelAnlegen = new javax.swing.JTextField();
        jLabel63 = new javax.swing.JLabel();
        jtfeinzelwertnetto_ArtikelAnlegen = new javax.swing.JTextField();
        jLabel64 = new javax.swing.JLabel();
        jLabel65 = new javax.swing.JLabel();
        jLabel66 = new javax.swing.JLabel();
        jLabel67 = new javax.swing.JLabel();
        jLabel68 = new javax.swing.JLabel();
        jLabel69 = new javax.swing.JLabel();
        jLabel70 = new javax.swing.JLabel();
        jcbMwst_ArtikelAnlegen = new javax.swing.JComboBox();
        jLabel71 = new javax.swing.JLabel();
        jLabel72 = new javax.swing.JLabel();
        jLabel170 = new javax.swing.JLabel();
        jLabel171 = new javax.swing.JLabel();
        jLabel172 = new javax.swing.JLabel();
        jLabel173 = new javax.swing.JLabel();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);

        ArtikelAnlegen.setPreferredSize(new java.awt.Dimension(1200, 800));

        jLabel39.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel39.setText("Artikel Anlegen");

        jLabel58.setText("%");

        jtfeinzelwertbrutto_ArtikelAnlegen.setMinimumSize(new java.awt.Dimension(6, 25));
        jtfeinzelwertbrutto_ArtikelAnlegen.setPreferredSize(new java.awt.Dimension(6, 25));
        jtfeinzelwertbrutto_ArtikelAnlegen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfeinzelwertbrutto_ArtikelAnlegenActionPerformed(evt);
            }
        });

        jtfverkauft_ArtikelAnlegen.setMinimumSize(new java.awt.Dimension(6, 25));
        jtfverkauft_ArtikelAnlegen.setPreferredSize(new java.awt.Dimension(6, 25));

        jbAbbrechen_ArtikelAnlegen.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jbAbbrechen_ArtikelAnlegen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/abbruch2.png"))); // NOI18N
        jbAbbrechen_ArtikelAnlegen.setText("Abbrechen");
        jbAbbrechen_ArtikelAnlegen.setPreferredSize(new java.awt.Dimension(130, 35));
        jbAbbrechen_ArtikelAnlegen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAbbrechen_ArtikelAnlegenActionPerformed(evt);
            }
        });

        jtfbestellwertnetto_ArtikelAnlegen.setMinimumSize(new java.awt.Dimension(6, 25));
        jtfbestellwertnetto_ArtikelAnlegen.setPreferredSize(new java.awt.Dimension(6, 25));

        jtfreserviert_ArtikelAnlegen.setMinimumSize(new java.awt.Dimension(6, 25));
        jtfreserviert_ArtikelAnlegen.setPreferredSize(new java.awt.Dimension(6, 25));

        jLabel59.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel59.setText("Einzelwert (Netto):");

        jLabel60.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel60.setText("Bestellwert (Netto):");

        jbSpeichern_ArtikelAnlegen.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jbSpeichern_ArtikelAnlegen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/speichern2.png"))); // NOI18N
        jbSpeichern_ArtikelAnlegen.setText("Speichern");
        jbSpeichern_ArtikelAnlegen.setPreferredSize(new java.awt.Dimension(130, 35));
        jbSpeichern_ArtikelAnlegen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSpeichern_ArtikelAnlegenActionPerformed(evt);
            }
        });

        jLabel61.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel61.setText("(Brutto):");

        jtfartikelname_ArtikelAnlegen.setMinimumSize(new java.awt.Dimension(6, 25));
        jtfartikelname_ArtikelAnlegen.setPreferredSize(new java.awt.Dimension(6, 25));

        jtfbestelltext_ArtikelAnlegen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfbestelltext_ArtikelAnlegenActionPerformed(evt);
            }
        });

        jtfbestellwertbrutto_ArtikelAnlegen.setMinimumSize(new java.awt.Dimension(6, 25));
        jtfbestellwertbrutto_ArtikelAnlegen.setPreferredSize(new java.awt.Dimension(6, 25));

        jtfzulauf_ArtikelAnlegen.setMinimumSize(new java.awt.Dimension(6, 25));
        jtfzulauf_ArtikelAnlegen.setPreferredSize(new java.awt.Dimension(6, 25));

        jtfartikeltext_ArtikelAnlegen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfartikeltext_ArtikelAnlegenActionPerformed(evt);
            }
        });

        jtffrei_ArtikelAnlegen.setMinimumSize(new java.awt.Dimension(6, 25));
        jtffrei_ArtikelAnlegen.setPreferredSize(new java.awt.Dimension(6, 25));

        jLabel62.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel62.setText("(Brutto):");

        jtfartikelid_ArtikelAnlegen.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtfartikelid_ArtikelAnlegen.setMinimumSize(new java.awt.Dimension(6, 25));
        jtfartikelid_ArtikelAnlegen.setPreferredSize(new java.awt.Dimension(6, 25));
        jtfartikelid_ArtikelAnlegen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfartikelid_ArtikelAnlegenActionPerformed(evt);
            }
        });

        jLabel63.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel63.setText("Bestelltext:");

        jtfeinzelwertnetto_ArtikelAnlegen.setMinimumSize(new java.awt.Dimension(6, 25));
        jtfeinzelwertnetto_ArtikelAnlegen.setPreferredSize(new java.awt.Dimension(6, 25));

        jLabel64.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel64.setText("Artikel-ID:");

        jLabel65.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel65.setText("Artikelname:");

        jLabel66.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel66.setText("Bestandsmengen");

        jLabel67.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel67.setText("Frei:");

        jLabel68.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel68.setText("Zulauf:");

        jLabel69.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel69.setText("Reserviert:");

        jLabel70.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel70.setText("Verkauft:");

        jcbMwst_ArtikelAnlegen.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "", "7", "19" }));
        jcbMwst_ArtikelAnlegen.setMinimumSize(new java.awt.Dimension(37, 25));
        jcbMwst_ArtikelAnlegen.setPreferredSize(new java.awt.Dimension(37, 25));
        jcbMwst_ArtikelAnlegen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbMwst_ArtikelAnlegenActionPerformed(evt);
            }
        });

        jLabel71.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel71.setText("Artikeltext:");

        jLabel72.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel72.setText("MwST-Satz:");

        jLabel170.setText("€");

        jLabel171.setText("€");

        jLabel172.setText("€");

        jLabel173.setText("€");

        javax.swing.GroupLayout ArtikelAnlegenLayout = new javax.swing.GroupLayout(ArtikelAnlegen);
        ArtikelAnlegen.setLayout(ArtikelAnlegenLayout);
        ArtikelAnlegenLayout.setHorizontalGroup(
            ArtikelAnlegenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ArtikelAnlegenLayout.createSequentialGroup()
                .addGroup(ArtikelAnlegenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator12, javax.swing.GroupLayout.PREFERRED_SIZE, 930, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(ArtikelAnlegenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jSeparator13)
                        .addComponent(jSeparator11)
                        .addGroup(ArtikelAnlegenLayout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(ArtikelAnlegenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ArtikelAnlegenLayout.createSequentialGroup()
                                    .addComponent(jbSpeichern_ArtikelAnlegen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jbAbbrechen_ArtikelAnlegen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(235, 235, 235))
                                .addGroup(ArtikelAnlegenLayout.createSequentialGroup()
                                    .addGroup(ArtikelAnlegenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, ArtikelAnlegenLayout.createSequentialGroup()
                                            .addComponent(jLabel64)
                                            .addGap(61, 61, 61)
                                            .addGroup(ArtikelAnlegenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(jtfartikelname_ArtikelAnlegen, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                                                .addComponent(jtfartikelid_ArtikelAnlegen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                        .addComponent(jLabel63, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel71, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel65, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel66, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel72, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, ArtikelAnlegenLayout.createSequentialGroup()
                                            .addGroup(ArtikelAnlegenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(ArtikelAnlegenLayout.createSequentialGroup()
                                                    .addGap(304, 304, 304)
                                                    .addComponent(jLabel39))
                                                .addGroup(ArtikelAnlegenLayout.createSequentialGroup()
                                                    .addComponent(jLabel67, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGap(76, 76, 76)
                                                    .addGroup(ArtikelAnlegenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jtffrei_ArtikelAnlegen, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jtfzulauf_ArtikelAnlegen, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGap(96, 96, 96)
                                                    .addGroup(ArtikelAnlegenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel70)
                                                        .addComponent(jLabel69)))
                                                .addComponent(jLabel68)
                                                .addGroup(ArtikelAnlegenLayout.createSequentialGroup()
                                                    .addGroup(ArtikelAnlegenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(ArtikelAnlegenLayout.createSequentialGroup()
                                                            .addComponent(jLabel59)
                                                            .addGap(18, 18, 18)
                                                            .addComponent(jtfeinzelwertnetto_ArtikelAnlegen, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                            .addComponent(jLabel170))
                                                        .addGroup(ArtikelAnlegenLayout.createSequentialGroup()
                                                            .addComponent(jLabel60)
                                                            .addGap(14, 14, 14)
                                                            .addGroup(ArtikelAnlegenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addGroup(ArtikelAnlegenLayout.createSequentialGroup()
                                                                    .addComponent(jcbMwst_ArtikelAnlegen, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                    .addComponent(jLabel58, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addComponent(jtfbestellwertnetto_ArtikelAnlegen, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                            .addComponent(jLabel171)))
                                                    .addGap(93, 93, 93)
                                                    .addGroup(ArtikelAnlegenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(jLabel62)
                                                        .addComponent(jLabel61))))
                                            .addGap(43, 43, 43)
                                            .addGroup(ArtikelAnlegenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(ArtikelAnlegenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(jtfverkauft_ArtikelAnlegen, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                                                    .addComponent(jtfreserviert_ArtikelAnlegen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addGroup(ArtikelAnlegenLayout.createSequentialGroup()
                                                    .addComponent(jtfeinzelwertbrutto_ArtikelAnlegen, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(jLabel172))
                                                .addGroup(ArtikelAnlegenLayout.createSequentialGroup()
                                                    .addComponent(jtfbestellwertbrutto_ArtikelAnlegen, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(jLabel173, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, ArtikelAnlegenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(jtfbestelltext_ArtikelAnlegen, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 348, Short.MAX_VALUE)
                                            .addComponent(jtfartikeltext_ArtikelAnlegen, javax.swing.GroupLayout.Alignment.LEADING)))
                                    .addGap(180, 180, 180))))))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        ArtikelAnlegenLayout.setVerticalGroup(
            ArtikelAnlegenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ArtikelAnlegenLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel39)
                .addGap(13, 13, 13)
                .addComponent(jSeparator13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addGroup(ArtikelAnlegenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel64)
                    .addComponent(jtfartikelid_ArtikelAnlegen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(ArtikelAnlegenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel65)
                    .addComponent(jtfartikelname_ArtikelAnlegen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jSeparator11, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel66)
                .addGap(18, 18, 18)
                .addGroup(ArtikelAnlegenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel67)
                    .addComponent(jtffrei_ArtikelAnlegen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel69)
                    .addComponent(jtfverkauft_ArtikelAnlegen, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(ArtikelAnlegenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel68)
                    .addGroup(ArtikelAnlegenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jtfzulauf_ArtikelAnlegen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel70)
                        .addComponent(jtfreserviert_ArtikelAnlegen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jSeparator12, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel63)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtfbestelltext_ArtikelAnlegen, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel71)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtfartikeltext_ArtikelAnlegen, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(ArtikelAnlegenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel59)
                    .addComponent(jtfeinzelwertnetto_ArtikelAnlegen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel170)
                    .addComponent(jLabel62)
                    .addComponent(jtfeinzelwertbrutto_ArtikelAnlegen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel172))
                .addGap(18, 18, 18)
                .addGroup(ArtikelAnlegenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfbestellwertnetto_ArtikelAnlegen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel60)
                    .addComponent(jLabel171)
                    .addComponent(jLabel61)
                    .addComponent(jLabel173, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfbestellwertbrutto_ArtikelAnlegen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(ArtikelAnlegenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel72)
                    .addComponent(jcbMwst_ArtikelAnlegen, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel58))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ArtikelAnlegenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbAbbrechen_ArtikelAnlegen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbSpeichern_ArtikelAnlegen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 975, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(ArtikelAnlegen, javax.swing.GroupLayout.DEFAULT_SIZE, 955, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 773, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addComponent(ArtikelAnlegen, javax.swing.GroupLayout.DEFAULT_SIZE, 776, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtfeinzelwertbrutto_ArtikelAnlegenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfeinzelwertbrutto_ArtikelAnlegenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfeinzelwertbrutto_ArtikelAnlegenActionPerformed

    private void jbAbbrechen_ArtikelAnlegenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAbbrechen_ArtikelAnlegenActionPerformed
        // Hicran Yoeruek
        // Schließt das Fenster nach Betätigung des Abbrech Buttons komplett.
        this.setVisible(false);
     
    }//GEN-LAST:event_jbAbbrechen_ArtikelAnlegenActionPerformed
//Mehmet Impram 25.11.2016
    private boolean istVollstaendig(){
    boolean istVollstaendig = false;
    String fehlermeldung = "";
    if(jtfartikelid_ArtikelAnlegen.getText().equals("")){
        fehlermeldung = "Bitte geben Sie Artikel ID an";
        jtfartikelid_ArtikelAnlegen.requestFocusInWindow();
    }else if ( jtfartikelname_ArtikelAnlegen.getText().equals("")){
        fehlermeldung ="Bitte geben Sie Artikel Name an";
    }else if (jtffrei_ArtikelAnlegen.getText().equals("")){
        fehlermeldung = "Bitte die freie Menge eingeben.";
        jtffrei_ArtikelAnlegen.requestFocusInWindow();
    }else if (jtfzulauf_ArtikelAnlegen.getText().equals("")){
        fehlermeldung = "Bitte die Zulauf Menge eingeben.";
    }else if ( jtfreserviert_ArtikelAnlegen.getText().equals("")){
        fehlermeldung = "Bitte die reservierte Menge eingeben";
    } else if (jtfverkauft_ArtikelAnlegen.getText().equals("")){
        fehlermeldung = "Bitte die verkaufte Menge eingeben";
    } else if (jtfbestelltext_ArtikelAnlegen.getText().equals("")){
        fehlermeldung = "Bitte den Bestelltext eingeben.";
    } else if (jtfartikeltext_ArtikelAnlegen.getText().equals("")){
        fehlermeldung = "Bitte den Artikeltext eingeben.";
                
    } else if ( jtfeinzelwertnetto_ArtikelAnlegen.getText().equals("")){
        fehlermeldung = "Bitte geben Sie den EinzelWert Netto ein, eine ganze Zahl oder 2 nach Kommastellen";
    } else if ( jtfeinzelwertbrutto_ArtikelAnlegen.getText().equals("")){
         fehlermeldung = "Bitte geben Sie den EinzelWert Netto ein, eine ganze Zahl oder 2 nach Kommastellen";
    } else if ( jtfbestellwertnetto_ArtikelAnlegen.getText().equals("")){
         fehlermeldung = "Bitte geben Sie den BestellWert Netto ein, eine ganze Zahl oder 2 nach Kommastellen";
         
    }else if (jtfbestellwertbrutto_ArtikelAnlegen.getText().equals("")){
         fehlermeldung = "Bitte geben Sie den BestellWert Brutto ein, eine ganze Zahl oder 2 nach Kommastellen";
    } else if (jcbMwst_ArtikelAnlegen.getSelectedIndex() == 0){
        fehlermeldung = "Wählen Sie Bitte den MSWT";
    }
            
    if (fehlermeldung.equals("")){
        istVollstaendig = true;
    } else {
        JOptionPane.showMessageDialog(this, fehlermeldung, "Unvollständig", JOptionPane.WARNING_MESSAGE);
    }return istVollstaendig;
        
}
    

    private void jbSpeichern_ArtikelAnlegenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSpeichern_ArtikelAnlegenActionPerformed
        // TODO add your handling code here:
        if (istVollstaendig()) {
            
        }
    }//GEN-LAST:event_jbSpeichern_ArtikelAnlegenActionPerformed

    private void jtfbestelltext_ArtikelAnlegenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfbestelltext_ArtikelAnlegenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfbestelltext_ArtikelAnlegenActionPerformed

    private void jtfartikeltext_ArtikelAnlegenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfartikeltext_ArtikelAnlegenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfartikeltext_ArtikelAnlegenActionPerformed

    private void jtfartikelid_ArtikelAnlegenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfartikelid_ArtikelAnlegenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfartikelid_ArtikelAnlegenActionPerformed

    private void jcbMwst_ArtikelAnlegenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbMwst_ArtikelAnlegenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbMwst_ArtikelAnlegenActionPerformed


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
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JSeparator jSeparator12;
    private javax.swing.JSeparator jSeparator13;
    private javax.swing.JButton jbAbbrechen_ArtikelAnlegen;
    private javax.swing.JButton jbSpeichern_ArtikelAnlegen;
    private javax.swing.JComboBox jcbMwst_ArtikelAnlegen;
    private javax.swing.JTextField jtfartikelid_ArtikelAnlegen;
    private javax.swing.JTextField jtfartikelname_ArtikelAnlegen;
    private javax.swing.JTextField jtfartikeltext_ArtikelAnlegen;
    private javax.swing.JTextField jtfbestelltext_ArtikelAnlegen;
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
