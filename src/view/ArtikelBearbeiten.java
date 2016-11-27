/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.text.DecimalFormatSymbols;
import javax.swing.JOptionPane;

/*----------------------------------------------------------*/
/* Datum Name Was */
/* 15.11.16 Impram Erstellung*/
/* 24.11.16 Yoeruek Aufsplittung der StartAv Klasse in einzelne Klassen, da Code für eine Klasse zu lang. */
/* 26.11.16 Impram Überarbeitung der Maske*/
/* 27.11.16 Impram Anpassung der Größenverhältnisse (Schriftart, Layout)*/
/*----------------------------------------------------------*/
public class ArtikelBearbeiten extends javax.swing.JInternalFrame {

    /**
     * Creates new form ArtikelBearbeiten
     */
    public ArtikelBearbeiten() {
        initComponents();
        
        //Mechmet Impram
        jtfArtikelID_ArtikelBearbeiten.setDocument(new UniversalDokument(false, true, "", 5));
        //Artikel Id kann man nicht bearbeiten
       // jtfArtikelID_ArtikelBearbeiten.setEnabled(false);
        //27.11.2016
        jtfArtikelname_ArtikelBearbeiten.setDocument(new UniversalDokument(true, false, "-, ' ", -1));
        jtffreiArtikelBearbeiten.setDocument(new UniversalDokument(false, true, "", 5));
        jtfverkauftArtikelBearbeiten.setDocument(new UniversalDokument(false, true, "", 5));
        jtfzulaufArtikelBearbeiten.setDocument(new UniversalDokument(false, true, "", 5));
        jtfreserviertArtikelBearbeiten.setDocument(new UniversalDokument(false, true, "", 5));
        jtfBestellTextArtikelBearbeiten.setDocument(new UniversalDokument(true, false, "-, ' ", -1));
        jtfArtikelTextArtikelBearbeiten.setDocument(new UniversalDokument(true, false, "-, ' ", -1));
        jtfEinzelwertNettoArtikelBearbeiten.setDocument(new UniversalDokument(false, true, DecimalFormatSymbols.getInstance().getDecimalSeparator() + "", -1));
        jtfEinzelwertNettoArtikelBearbeiten.setInputVerifier(new UniversalVerifier("\\d+(\\" + DecimalFormatSymbols.getInstance().getDecimalSeparator() + "\\d\\d)?", "ungultiges format", "Bitte geben sie ein Preis mit 2 Nachkommastellen oder eine ganze Zahl"));
        jtfEinzelwertBruttoArtikelBearbeiten.setDocument(new UniversalDokument(false, true, DecimalFormatSymbols.getInstance().getDecimalSeparator() + "", -1));
        jtfEinzelwertBruttoArtikelBearbeiten.setInputVerifier(new UniversalVerifier("\\d+(\\" + DecimalFormatSymbols.getInstance().getDecimalSeparator() + "\\d\\d)?", "ungultiges format", "Bitte geben sie ein Preis mit 2 Nachkommastellen oder eine ganze Zahl"));
        jtfBestellwertNettoArtikelBearbeiten.setDocument(new UniversalDokument(false, true, DecimalFormatSymbols.getInstance().getDecimalSeparator() + "", -1));
        jtfBestellwertNettoArtikelBearbeiten.setInputVerifier(new UniversalVerifier("\\d+(\\" + DecimalFormatSymbols.getInstance().getDecimalSeparator() + "\\d\\d)?", "ungultiges format", "Bitte geben sie ein Preis mit 2 Nachkommastellen oder eine ganze Zahl"));
        jtfBestellwertBruttoArtikelBearbeiten.setDocument(new UniversalDokument(false, true, DecimalFormatSymbols.getInstance().getDecimalSeparator() + "", -1));
        jtfBestellwertBruttoArtikelBearbeiten.setInputVerifier(new UniversalVerifier("\\d+(\\" + DecimalFormatSymbols.getInstance().getDecimalSeparator() + "\\d\\d)?", "ungultiges format", "Bitte geben sie ein Preis mit 2 Nachkommastellen oder eine ganze Zahl"));
        

        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ArtikelBearbeiten = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jbBearbeiten_ArtikelBearbeiten = new javax.swing.JButton();
        jbLöschen_ArtikelBearbeiten = new javax.swing.JButton();
        jLabel40 = new javax.swing.JLabel();
        jSeparator8 = new javax.swing.JSeparator();
        jbAbbrechenArtikelBearbeiten = new javax.swing.JButton();
        jbSpeichernArtikelBearbeiten = new javax.swing.JButton();
        jtfArtikelID_ArtikelBearbeiten = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jtfArtikelname_ArtikelBearbeiten = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jtffreiArtikelBearbeiten = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jtfzulaufArtikelBearbeiten = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jtfreserviertArtikelBearbeiten = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jtfverkauftArtikelBearbeiten = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jtfBestellTextArtikelBearbeiten = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jtfArtikelTextArtikelBearbeiten = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jtfEinzelwertNettoArtikelBearbeiten = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jtfBestellwertNettoArtikelBearbeiten = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jtfEinzelwertBruttoArtikelBearbeiten = new javax.swing.JTextField();
        jtfBestellwertBruttoArtikelBearbeiten = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jcbMWSTArtikelBearbeiten = new javax.swing.JComboBox<>();
        jLabel20 = new javax.swing.JLabel();
        jbLupe_ArtikelBearbeiten = new javax.swing.JButton();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);

        ArtikelBearbeiten.setPreferredSize(new java.awt.Dimension(1200, 800));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel5.setText("Artikel-ID:");

        jbBearbeiten_ArtikelBearbeiten.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jbBearbeiten_ArtikelBearbeiten.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/bearbeiten1.png"))); // NOI18N
        jbBearbeiten_ArtikelBearbeiten.setText("Bearbeiten");
        jbBearbeiten_ArtikelBearbeiten.setMaximumSize(new java.awt.Dimension(130, 35));
        jbBearbeiten_ArtikelBearbeiten.setPreferredSize(new java.awt.Dimension(130, 35));
        jbBearbeiten_ArtikelBearbeiten.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBearbeiten_ArtikelBearbeitenActionPerformed(evt);
            }
        });

        jbLöschen_ArtikelBearbeiten.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jbLöschen_ArtikelBearbeiten.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/müll2.png"))); // NOI18N
        jbLöschen_ArtikelBearbeiten.setText("Löschen");
        jbLöschen_ArtikelBearbeiten.setPreferredSize(new java.awt.Dimension(130, 35));
        jbLöschen_ArtikelBearbeiten.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbLöschen_ArtikelBearbeitenActionPerformed(evt);
            }
        });

        jLabel40.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel40.setText("Artikel Bearbeiten");

        jbAbbrechenArtikelBearbeiten.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jbAbbrechenArtikelBearbeiten.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/abbruch2.png"))); // NOI18N
        jbAbbrechenArtikelBearbeiten.setText("Abbrechen");
        jbAbbrechenArtikelBearbeiten.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAbbrechenArtikelBearbeitenActionPerformed(evt);
            }
        });

        jbSpeichernArtikelBearbeiten.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jbSpeichernArtikelBearbeiten.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/speichern2.png"))); // NOI18N
        jbSpeichernArtikelBearbeiten.setText("Speichern");
        jbSpeichernArtikelBearbeiten.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSpeichernArtikelBearbeitenActionPerformed(evt);
            }
        });

        jtfArtikelID_ArtikelBearbeiten.setMinimumSize(new java.awt.Dimension(6, 25));
        jtfArtikelID_ArtikelBearbeiten.setPreferredSize(new java.awt.Dimension(59, 25));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel2.setText("Artikelname:");

        jtfArtikelname_ArtikelBearbeiten.setMinimumSize(new java.awt.Dimension(6, 25));
        jtfArtikelname_ArtikelBearbeiten.setPreferredSize(new java.awt.Dimension(6, 25));

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Bearbeiten", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Bestandsmengen");

        jtffreiArtikelBearbeiten.setMinimumSize(new java.awt.Dimension(6, 25));
        jtffreiArtikelBearbeiten.setPreferredSize(new java.awt.Dimension(6, 25));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel4.setText("Frei:");

        jtfzulaufArtikelBearbeiten.setMinimumSize(new java.awt.Dimension(6, 25));
        jtfzulaufArtikelBearbeiten.setPreferredSize(new java.awt.Dimension(6, 25));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel6.setText("Zulauf:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel7.setText("Reserviert:");

        jtfreserviertArtikelBearbeiten.setMinimumSize(new java.awt.Dimension(6, 25));
        jtfreserviertArtikelBearbeiten.setPreferredSize(new java.awt.Dimension(6, 25));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel8.setText("Verlauft:");

        jtfverkauftArtikelBearbeiten.setMinimumSize(new java.awt.Dimension(6, 25));
        jtfverkauftArtikelBearbeiten.setPreferredSize(new java.awt.Dimension(6, 25));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel9.setText("Bestelltext:");

        jtfBestellTextArtikelBearbeiten.setMinimumSize(new java.awt.Dimension(6, 25));
        jtfBestellTextArtikelBearbeiten.setPreferredSize(new java.awt.Dimension(6, 25));

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel10.setText("Artikeltext:");

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel11.setText("Einzelwert (Netto):");

        jtfEinzelwertNettoArtikelBearbeiten.setMinimumSize(new java.awt.Dimension(6, 25));
        jtfEinzelwertNettoArtikelBearbeiten.setPreferredSize(new java.awt.Dimension(6, 25));

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel12.setText("Bestellwert (Netto):");

        jtfBestellwertNettoArtikelBearbeiten.setMinimumSize(new java.awt.Dimension(6, 25));
        jtfBestellwertNettoArtikelBearbeiten.setPreferredSize(new java.awt.Dimension(6, 25));

        jLabel16.setText("€");

        jLabel17.setText("€");

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel14.setText("Einzelwert (Brutto):");

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel15.setText("Bestellwert (Brutto):");

        jtfEinzelwertBruttoArtikelBearbeiten.setMinimumSize(new java.awt.Dimension(6, 25));
        jtfEinzelwertBruttoArtikelBearbeiten.setPreferredSize(new java.awt.Dimension(6, 25));

        jtfBestellwertBruttoArtikelBearbeiten.setMinimumSize(new java.awt.Dimension(6, 25));
        jtfBestellwertBruttoArtikelBearbeiten.setPreferredSize(new java.awt.Dimension(6, 25));

        jLabel18.setText("€");

        jLabel19.setText("€");

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel13.setText("MwST-Satz:");

        jcbMWSTArtikelBearbeiten.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "7", "19" }));

        jLabel20.setText("%");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel4))
                        .addGap(89, 89, 89)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtffreiArtikelBearbeiten, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfzulaufArtikelBearbeiten, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(122, 122, 122)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jtfverkauftArtikelBearbeiten, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(43, 43, 43)
                                .addComponent(jtfreserviertArtikelBearbeiten, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jtfBestellTextArtikelBearbeiten, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel12))
                                .addGap(55, 55, 55)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jtfEinzelwertNettoArtikelBearbeiten, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jtfBestellwertNettoArtikelBearbeiten, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel16)
                                    .addComponent(jLabel17))))
                        .addGap(57, 57, 57)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel14)
                                    .addComponent(jLabel15))
                                .addGap(48, 48, 48)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jtfEinzelwertBruttoArtikelBearbeiten, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jtfBestellwertBruttoArtikelBearbeiten, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel18)
                                    .addComponent(jLabel19)))
                            .addComponent(jtfArtikelTextArtikelBearbeiten, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addGap(108, 108, 108)
                        .addComponent(jcbMWSTArtikelBearbeiten, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel20)))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jtffreiArtikelBearbeiten, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jtfreserviertArtikelBearbeiten, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jtfzulaufArtikelBearbeiten, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(jtfverkauftArtikelBearbeiten, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfBestellTextArtikelBearbeiten, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfArtikelTextArtikelBearbeiten, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(48, 48, 48)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(jtfEinzelwertNettoArtikelBearbeiten, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(jtfBestellwertNettoArtikelBearbeiten, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(jtfEinzelwertBruttoArtikelBearbeiten, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel18))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(jtfBestellwertBruttoArtikelBearbeiten, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel19))))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jcbMWSTArtikelBearbeiten, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jbLupe_ArtikelBearbeiten.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/lupe.png"))); // NOI18N

        javax.swing.GroupLayout ArtikelBearbeitenLayout = new javax.swing.GroupLayout(ArtikelBearbeiten);
        ArtikelBearbeiten.setLayout(ArtikelBearbeitenLayout);
        ArtikelBearbeitenLayout.setHorizontalGroup(
            ArtikelBearbeitenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ArtikelBearbeitenLayout.createSequentialGroup()
                .addGap(269, 269, 269)
                .addComponent(jLabel40)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ArtikelBearbeitenLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, 855, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
            .addGroup(ArtikelBearbeitenLayout.createSequentialGroup()
                .addGroup(ArtikelBearbeitenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(ArtikelBearbeitenLayout.createSequentialGroup()
                        .addComponent(jbSpeichernArtikelBearbeiten, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jbAbbrechenArtikelBearbeiten, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(ArtikelBearbeitenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(ArtikelBearbeitenLayout.createSequentialGroup()
                            .addGap(36, 36, 36)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jtfArtikelID_ArtikelBearbeiten, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jbLupe_ArtikelBearbeiten, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(75, 75, 75)
                            .addGroup(ArtikelBearbeitenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(ArtikelBearbeitenLayout.createSequentialGroup()
                                    .addComponent(jbBearbeiten_ArtikelBearbeiten, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jbLöschen_ArtikelBearbeiten, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(ArtikelBearbeitenLayout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jtfArtikelname_ArtikelBearbeiten, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        ArtikelBearbeitenLayout.setVerticalGroup(
            ArtikelBearbeitenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ArtikelBearbeitenLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel40)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ArtikelBearbeitenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfArtikelID_ArtikelBearbeiten, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jtfArtikelname_ArtikelBearbeiten, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbLupe_ArtikelBearbeiten, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(ArtikelBearbeitenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbBearbeiten_ArtikelBearbeiten, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbLöschen_ArtikelBearbeiten, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(ArtikelBearbeitenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbAbbrechenArtikelBearbeiten, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbSpeichernArtikelBearbeiten, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ArtikelBearbeiten, javax.swing.GroupLayout.PREFERRED_SIZE, 855, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(ArtikelBearbeiten, javax.swing.GroupLayout.PREFERRED_SIZE, 731, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 22, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

// 27.11.2016 Mehmet Impram Überprüfung der Pflichtfeld Artikel ID.    
//    private boolean istVollstaendig(){
//    boolean istVollstaendig = false;
//    String fehlermeldung = "";
//    if(jtfArtikelID_ArtikelBearbeiten.getText().equals("")){
//        fehlermeldung = "Bitte geben Sie eine Artikel ID an";
//    }
//    if ( fehlermeldung.equals("")){
//        istVollstaendig = true;
//    } else {
//        JOptionPane.showMessageDialog(this, fehlermeldung, "Unvollständig", JOptionPane.WARNING_MESSAGE);
//    } return istVollstaendig;
//}
    private void jbBearbeiten_ArtikelBearbeitenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBearbeiten_ArtikelBearbeitenActionPerformed
//if (istVollstaendig()) {
//            
//        }       
    }//GEN-LAST:event_jbBearbeiten_ArtikelBearbeitenActionPerformed

    private void jbLöschen_ArtikelBearbeitenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbLöschen_ArtikelBearbeitenActionPerformed
          // Hicran Yoeruek
        // Schließt das Fenster nach Betätigung des Abbrech Buttons komplett.
        this.setVisible(false);
     
    }//GEN-LAST:event_jbLöschen_ArtikelBearbeitenActionPerformed

    private void jbAbbrechenArtikelBearbeitenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAbbrechenArtikelBearbeitenActionPerformed
        // TODO add your handling code here:
        //Mehmet Impram nach Betätigung der Abbrechen Button wird das fenster geschlossen.
//        this.setVisible(false);
    }//GEN-LAST:event_jbAbbrechenArtikelBearbeitenActionPerformed

 //Mehmet Impram 27.11.2016   
    private boolean pruefeVollstaendigkeit () {
        boolean pruefeVollstaendigkeit = false;
        String fehlermeldung = "";
        if( jtfArtikelname_ArtikelBearbeiten.getText().equals("")){
            fehlermeldung = "Bitte füllen Sie den Namens Feld.";
        } else if (jtffreiArtikelBearbeiten.getText().equals("")){
            fehlermeldung = "Bitte füllen Sie den Freien Feld.";
        } else if (jtfverkauftArtikelBearbeiten.getText().equals("")){
            fehlermeldung = "Bitte füllen Sie den Verkauften Feld.";
        } else if (jtfzulaufArtikelBearbeiten.getText().equals("")){
            fehlermeldung = "Bitte füllen Sie den Zulauf Feld.";
        } else if (jtfreserviertArtikelBearbeiten.getText().equals("")){
            fehlermeldung = "Bitte füllen Sie den Reservierten Feld.";
        } else if (jtfBestellTextArtikelBearbeiten.getText().equals("")){
            fehlermeldung = "Bitte geben Sie Bestell Text an";
            
        }else if (jtfArtikelTextArtikelBearbeiten.getText().equals("")){
            fehlermeldung = "Bitte geben Sie Artikel Text an.";
        } else if ( jtfBestellwertNettoArtikelBearbeiten.getText().equals("")){
            fehlermeldung = "Bitte geben Sie den Netto Wert.";
        } else if ( jtfBestellwertBruttoArtikelBearbeiten.getText().equals("")){
            fehlermeldung = "Bitte geben Sie den Brutto Wert.";
        } else if (jtfEinzelwertNettoArtikelBearbeiten.getText().equals("")){
            fehlermeldung = "Bitte geben Sie den Netto Einzelwert.";
        } else if (jtfEinzelwertBruttoArtikelBearbeiten.getText().equals("")){
            fehlermeldung = "Bitte geben Sie den Brutto Einzelwert";
        } else if (jcbMWSTArtikelBearbeiten.getSelectedIndex() == 0) {
            fehlermeldung = "Bitte wählen Sie den MwST.";
        }
        if (fehlermeldung.equals("")){
            pruefeVollstaendigkeit = true;
        } else { JOptionPane.showMessageDialog(this, fehlermeldung, "Unvollständig", JOptionPane.WARNING_MESSAGE);
    } return pruefeVollstaendigkeit;
    }
    private void jbSpeichernArtikelBearbeitenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSpeichernArtikelBearbeitenActionPerformed
        // TODO add your handling code here:
        if (pruefeVollstaendigkeit()){
    }//GEN-LAST:event_jbSpeichernArtikelBearbeitenActionPerformed
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ArtikelBearbeiten;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JButton jbAbbrechenArtikelBearbeiten;
    private javax.swing.JButton jbBearbeiten_ArtikelBearbeiten;
    private javax.swing.JButton jbLupe_ArtikelBearbeiten;
    private javax.swing.JButton jbLöschen_ArtikelBearbeiten;
    private javax.swing.JButton jbSpeichernArtikelBearbeiten;
    private javax.swing.JComboBox<String> jcbMWSTArtikelBearbeiten;
    private javax.swing.JTextField jtfArtikelID_ArtikelBearbeiten;
    private javax.swing.JTextField jtfArtikelTextArtikelBearbeiten;
    private javax.swing.JTextField jtfArtikelname_ArtikelBearbeiten;
    private javax.swing.JTextField jtfBestellTextArtikelBearbeiten;
    private javax.swing.JTextField jtfBestellwertBruttoArtikelBearbeiten;
    private javax.swing.JTextField jtfBestellwertNettoArtikelBearbeiten;
    private javax.swing.JTextField jtfEinzelwertBruttoArtikelBearbeiten;
    private javax.swing.JTextField jtfEinzelwertNettoArtikelBearbeiten;
    private javax.swing.JTextField jtffreiArtikelBearbeiten;
    private javax.swing.JTextField jtfreserviertArtikelBearbeiten;
    private javax.swing.JTextField jtfverkauftArtikelBearbeiten;
    private javax.swing.JTextField jtfzulaufArtikelBearbeiten;
    // End of variables declaration//GEN-END:variables
}
