/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

/*----------------------------------------------------------*/
/* Datum Name Was */
/* 20.11.16 Citak Erstellung
/* 24.11.16 Yoeruek Aufsplittung der StartAv Klasse in einzelne Klassen, da Code für eine Klasse zu lang. */
/* 27.11.16 Citak Anpassung der Größenverhältnisse (Schriftart, Layout)*/
/*----------------------------------------------------------*/
public class KundeAnlegen extends javax.swing.JInternalFrame {

    /**
     * Creates new form KundeAnlegen
     */
    public KundeAnlegen() {
        initComponents();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Group_KundeAnlegen = new javax.swing.ButtonGroup();
        KundeAnlegen = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        abbrechen_KundeAnlegen = new javax.swing.JButton();
        jSeparator20 = new javax.swing.JSeparator();
        jLabel147 = new javax.swing.JLabel();
        jtfGPID_KundeAnlegen = new javax.swing.JTextField();
        jLabel148 = new javax.swing.JLabel();
        jtfKreditlimit_KundenAnlegen = new javax.swing.JTextField();
        jrbLieferadresseIdentisch_KundeAnlegen = new javax.swing.JRadioButton();
        jrbAbweichendeLieferadresse_KundeAnlegen = new javax.swing.JRadioButton();
        jPKontakt = new javax.swing.JPanel();
        jLabel149 = new javax.swing.JLabel();
        jtfTelefon_KundeAnlegen = new javax.swing.JTextField();
        jLabel150 = new javax.swing.JLabel();
        jrfTelefax_KundeAnlegen = new javax.swing.JTextField();
        jLabel151 = new javax.swing.JLabel();
        jtfEMail_KundeAnlegen = new javax.swing.JTextField();
        jPRechnungsdaten = new javax.swing.JPanel();
        jLabel152 = new javax.swing.JLabel();
        jcbAnredeRG_KundeAnlegen = new javax.swing.JComboBox<>();
        jLabel153 = new javax.swing.JLabel();
        jtfNameRG_KundeAnlegen = new javax.swing.JTextField();
        jLabel154 = new javax.swing.JLabel();
        jtfVornameRG_KundeAnlegen = new javax.swing.JTextField();
        jLabel155 = new javax.swing.JLabel();
        jtfFirmaRG_KundeAnlegen = new javax.swing.JTextField();
        jLabel156 = new javax.swing.JLabel();
        jtfStraßeRG_KundeAnlegen = new javax.swing.JTextField();
        jtfHNrRG_KundeAnlegen = new javax.swing.JTextField();
        jLabel157 = new javax.swing.JLabel();
        jtfPlzRG_KundeAnlegen = new javax.swing.JTextField();
        jtfOrtRG_KundeAnlegen = new javax.swing.JTextField();
        jLabel158 = new javax.swing.JLabel();
        jtfStaatRG_KundeAnlegen = new javax.swing.JTextField();
        jPLieferdaten = new javax.swing.JPanel();
        jLabel159 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel160 = new javax.swing.JLabel();
        jtfName2_KundeAnlegen = new javax.swing.JTextField();
        jLabel161 = new javax.swing.JLabel();
        jtfVorname2_KundeAnlegen = new javax.swing.JTextField();
        jLabel162 = new javax.swing.JLabel();
        jtfFirma2_KundeAnlegen = new javax.swing.JTextField();
        jLabel163 = new javax.swing.JLabel();
        jtfStraße2_KundeAnlegen = new javax.swing.JTextField();
        jLabel164 = new javax.swing.JLabel();
        jtfPlz2_KundeAnlegen = new javax.swing.JTextField();
        jLabel165 = new javax.swing.JLabel();
        jtfStaat2_KundeAnlegen = new javax.swing.JTextField();
        jbSpeichern = new javax.swing.JButton();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);

        KundeAnlegen.setPreferredSize(new java.awt.Dimension(1200, 800));

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel14.setText("Kunde Anlegen");

        abbrechen_KundeAnlegen.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        abbrechen_KundeAnlegen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/abbruch2.png"))); // NOI18N
        abbrechen_KundeAnlegen.setText("Abbrechen");
        abbrechen_KundeAnlegen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                abbrechen_KundeAnlegenActionPerformed(evt);
            }
        });

        jLabel147.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel147.setText("GP-ID:");

        jtfGPID_KundeAnlegen.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtfGPID_KundeAnlegen.setToolTipText("");
        jtfGPID_KundeAnlegen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfGPID_KundeAnlegenActionPerformed(evt);
            }
        });

        jLabel148.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel148.setText("Kreditlimit:");

        jtfKreditlimit_KundenAnlegen.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        Group_KundeAnlegen.add(jrbLieferadresseIdentisch_KundeAnlegen);
        jrbLieferadresseIdentisch_KundeAnlegen.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jrbLieferadresseIdentisch_KundeAnlegen.setText("Lieferadresse identisch");
        jrbLieferadresseIdentisch_KundeAnlegen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbLieferadresseIdentisch_KundeAnlegenActionPerformed(evt);
            }
        });

        Group_KundeAnlegen.add(jrbAbweichendeLieferadresse_KundeAnlegen);
        jrbAbweichendeLieferadresse_KundeAnlegen.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jrbAbweichendeLieferadresse_KundeAnlegen.setText("abweichende Lieferadresse");
        jrbAbweichendeLieferadresse_KundeAnlegen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbAbweichendeLieferadresse_KundeAnlegenActionPerformed(evt);
            }
        });

        jPKontakt.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Kontakt", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N

        jLabel149.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel149.setText("Telefon:");

        jtfTelefon_KundeAnlegen.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtfTelefon_KundeAnlegen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfTelefon_KundeAnlegenActionPerformed(evt);
            }
        });

        jLabel150.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel150.setText("Telefax:");

        jrfTelefax_KundeAnlegen.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel151.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel151.setText("E-Mail:");

        jtfEMail_KundeAnlegen.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPKontaktLayout = new javax.swing.GroupLayout(jPKontakt);
        jPKontakt.setLayout(jPKontaktLayout);
        jPKontaktLayout.setHorizontalGroup(
            jPKontaktLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPKontaktLayout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addGroup(jPKontaktLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel149)
                    .addComponent(jLabel150)
                    .addComponent(jLabel151))
                .addGap(18, 18, 18)
                .addGroup(jPKontaktLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jtfTelefon_KundeAnlegen, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jrfTelefax_KundeAnlegen, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfEMail_KundeAnlegen, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPKontaktLayout.setVerticalGroup(
            jPKontaktLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPKontaktLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPKontaktLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel149)
                    .addComponent(jtfTelefon_KundeAnlegen, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPKontaktLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel150)
                    .addComponent(jrfTelefax_KundeAnlegen, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPKontaktLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfEMail_KundeAnlegen, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel151))
                .addContainerGap(195, Short.MAX_VALUE))
        );

        jPRechnungsdaten.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Rechnungsdaten", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N

        jLabel152.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel152.setText("Anrede");

        jcbAnredeRG_KundeAnlegen.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jcbAnredeRG_KundeAnlegen.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-", "Frau ", "Herr" }));

        jLabel153.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel153.setText("Name:");

        jtfNameRG_KundeAnlegen.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel154.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel154.setText("Vorname:");

        jtfVornameRG_KundeAnlegen.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel155.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel155.setText("Firma:");

        jtfFirmaRG_KundeAnlegen.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel156.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel156.setText("Straße,HNr. :");

        jtfStraßeRG_KundeAnlegen.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jtfHNrRG_KundeAnlegen.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel157.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel157.setText("PLZ, Ort:");

        jtfPlzRG_KundeAnlegen.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtfPlzRG_KundeAnlegen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfPlzRG_KundeAnlegenActionPerformed(evt);
            }
        });

        jtfOrtRG_KundeAnlegen.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtfOrtRG_KundeAnlegen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfOrtRG_KundeAnlegenActionPerformed(evt);
            }
        });

        jLabel158.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel158.setText("Staat:");

        jtfStaatRG_KundeAnlegen.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPRechnungsdatenLayout = new javax.swing.GroupLayout(jPRechnungsdaten);
        jPRechnungsdaten.setLayout(jPRechnungsdatenLayout);
        jPRechnungsdatenLayout.setHorizontalGroup(
            jPRechnungsdatenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPRechnungsdatenLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPRechnungsdatenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPRechnungsdatenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPRechnungsdatenLayout.createSequentialGroup()
                            .addGroup(jPRechnungsdatenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel156)
                                .addComponent(jLabel157))
                            .addGroup(jPRechnungsdatenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPRechnungsdatenLayout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jtfHNrRG_KundeAnlegen, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPRechnungsdatenLayout.createSequentialGroup()
                                    .addGap(12, 12, 12)
                                    .addGroup(jPRechnungsdatenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jtfStaatRG_KundeAnlegen, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPRechnungsdatenLayout.createSequentialGroup()
                                            .addComponent(jtfPlzRG_KundeAnlegen, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jtfOrtRG_KundeAnlegen))))))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPRechnungsdatenLayout.createSequentialGroup()
                            .addGroup(jPRechnungsdatenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel152)
                                .addComponent(jLabel153)
                                .addComponent(jLabel154)
                                .addComponent(jLabel155))
                            .addGap(31, 31, 31)
                            .addGroup(jPRechnungsdatenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jcbAnredeRG_KundeAnlegen, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jtfVornameRG_KundeAnlegen, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jtfFirmaRG_KundeAnlegen, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jtfNameRG_KundeAnlegen, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jtfStraßeRG_KundeAnlegen, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jLabel158)))
        );
        jPRechnungsdatenLayout.setVerticalGroup(
            jPRechnungsdatenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPRechnungsdatenLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPRechnungsdatenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel152)
                    .addComponent(jcbAnredeRG_KundeAnlegen, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPRechnungsdatenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel153)
                    .addComponent(jtfNameRG_KundeAnlegen, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPRechnungsdatenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtfVornameRG_KundeAnlegen, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel154))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPRechnungsdatenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel155)
                    .addComponent(jtfFirmaRG_KundeAnlegen, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPRechnungsdatenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel156)
                    .addGroup(jPRechnungsdatenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jtfHNrRG_KundeAnlegen, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jtfStraßeRG_KundeAnlegen, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPRechnungsdatenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel157)
                    .addGroup(jPRechnungsdatenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jtfPlzRG_KundeAnlegen, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jtfOrtRG_KundeAnlegen, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPRechnungsdatenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel158)
                    .addComponent(jtfStaatRG_KundeAnlegen, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(67, Short.MAX_VALUE))
        );

        jPLieferdaten.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Lieferdaten", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N

        jLabel159.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel159.setText("Anrede");

        jComboBox1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-", "Frau", "Herr" }));

        jLabel160.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel160.setText("Name:");

        jtfName2_KundeAnlegen.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel161.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel161.setText("Vorname:");

        jtfVorname2_KundeAnlegen.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel162.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel162.setText("Firma:");

        jtfFirma2_KundeAnlegen.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtfFirma2_KundeAnlegen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfFirma2_KundeAnlegenActionPerformed(evt);
            }
        });

        jLabel163.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel163.setText("Straße, HNr. :");

        jtfStraße2_KundeAnlegen.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel164.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel164.setText("PLZ, Ort:");

        jtfPlz2_KundeAnlegen.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel165.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel165.setText("Staat:");

        jtfStaat2_KundeAnlegen.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPLieferdatenLayout = new javax.swing.GroupLayout(jPLieferdaten);
        jPLieferdaten.setLayout(jPLieferdatenLayout);
        jPLieferdatenLayout.setHorizontalGroup(
            jPLieferdatenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPLieferdatenLayout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addGroup(jPLieferdatenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPLieferdatenLayout.createSequentialGroup()
                        .addGroup(jPLieferdatenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel159)
                            .addComponent(jLabel160)
                            .addComponent(jLabel161)
                            .addComponent(jLabel162))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPLieferdatenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfName2_KundeAnlegen, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfVorname2_KundeAnlegen, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfFirma2_KundeAnlegen, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPLieferdatenLayout.createSequentialGroup()
                        .addGroup(jPLieferdatenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel163)
                            .addComponent(jLabel164)
                            .addComponent(jLabel165))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPLieferdatenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtfStraße2_KundeAnlegen, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfPlz2_KundeAnlegen, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfStaat2_KundeAnlegen, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPLieferdatenLayout.setVerticalGroup(
            jPLieferdatenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPLieferdatenLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPLieferdatenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel159)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPLieferdatenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel160)
                    .addComponent(jtfName2_KundeAnlegen, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPLieferdatenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel161)
                    .addComponent(jtfVorname2_KundeAnlegen, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPLieferdatenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel162)
                    .addComponent(jtfFirma2_KundeAnlegen, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPLieferdatenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel163)
                    .addComponent(jtfStraße2_KundeAnlegen, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPLieferdatenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel164)
                    .addComponent(jtfPlz2_KundeAnlegen, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPLieferdatenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel165)
                    .addComponent(jtfStaat2_KundeAnlegen, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(73, Short.MAX_VALUE))
        );

        jbSpeichern.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jbSpeichern.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/speichern2.png"))); // NOI18N
        jbSpeichern.setText("Speichern");

        javax.swing.GroupLayout KundeAnlegenLayout = new javax.swing.GroupLayout(KundeAnlegen);
        KundeAnlegen.setLayout(KundeAnlegenLayout);
        KundeAnlegenLayout.setHorizontalGroup(
            KundeAnlegenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator20)
            .addGroup(KundeAnlegenLayout.createSequentialGroup()
                .addGroup(KundeAnlegenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(KundeAnlegenLayout.createSequentialGroup()
                        .addComponent(jbSpeichern, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(abbrechen_KundeAnlegen, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(KundeAnlegenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(KundeAnlegenLayout.createSequentialGroup()
                            .addGap(395, 395, 395)
                            .addComponent(jLabel14))
                        .addGroup(KundeAnlegenLayout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(KundeAnlegenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(KundeAnlegenLayout.createSequentialGroup()
                                    .addGroup(KundeAnlegenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel148)
                                        .addComponent(jLabel147))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(KundeAnlegenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jtfGPID_KundeAnlegen, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jtfKreditlimit_KundenAnlegen, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(KundeAnlegenLayout.createSequentialGroup()
                                    .addComponent(jrbLieferadresseIdentisch_KundeAnlegen)
                                    .addGap(18, 18, 18)
                                    .addComponent(jrbAbweichendeLieferadresse_KundeAnlegen))))
                        .addGroup(KundeAnlegenLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jPKontakt, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jPRechnungsdaten, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jPLieferdaten, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        KundeAnlegenLayout.setVerticalGroup(
            KundeAnlegenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(KundeAnlegenLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator20, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(KundeAnlegenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel147)
                    .addComponent(jtfGPID_KundeAnlegen, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(KundeAnlegenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel148)
                    .addComponent(jtfKreditlimit_KundenAnlegen, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(KundeAnlegenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jrbLieferadresseIdentisch_KundeAnlegen)
                    .addComponent(jrbAbweichendeLieferadresse_KundeAnlegen))
                .addGap(30, 30, 30)
                .addGroup(KundeAnlegenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPKontakt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPRechnungsdaten, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPLieferdaten, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(KundeAnlegenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(abbrechen_KundeAnlegen, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbSpeichern, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(105, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(KundeAnlegen, javax.swing.GroupLayout.PREFERRED_SIZE, 950, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(KundeAnlegen, javax.swing.GroupLayout.DEFAULT_SIZE, 696, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void abbrechen_KundeAnlegenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_abbrechen_KundeAnlegenActionPerformed
    /*----------------------------------------------------------*/
    /* 24.11.16 Yoeruek Schließt das Fenster nach Betätigung des Abbrech Buttons */
    /*----------------------------------------------------------*/
        this.setVisible(false);
    }//GEN-LAST:event_abbrechen_KundeAnlegenActionPerformed

    private void jtfGPID_KundeAnlegenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfGPID_KundeAnlegenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfGPID_KundeAnlegenActionPerformed

    private void jrbLieferadresseIdentisch_KundeAnlegenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbLieferadresseIdentisch_KundeAnlegenActionPerformed
        //Citak
        jPLieferdaten.setVisible(false);
    }//GEN-LAST:event_jrbLieferadresseIdentisch_KundeAnlegenActionPerformed

    private void jrbAbweichendeLieferadresse_KundeAnlegenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbAbweichendeLieferadresse_KundeAnlegenActionPerformed
        //Citak
        jPLieferdaten.setVisible(true);
    }//GEN-LAST:event_jrbAbweichendeLieferadresse_KundeAnlegenActionPerformed

    private void jtfTelefon_KundeAnlegenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfTelefon_KundeAnlegenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfTelefon_KundeAnlegenActionPerformed

    private void jtfPlzRG_KundeAnlegenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfPlzRG_KundeAnlegenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfPlzRG_KundeAnlegenActionPerformed

    private void jtfOrtRG_KundeAnlegenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfOrtRG_KundeAnlegenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfOrtRG_KundeAnlegenActionPerformed

    private void jtfFirma2_KundeAnlegenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfFirma2_KundeAnlegenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfFirma2_KundeAnlegenActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup Group_KundeAnlegen;
    private javax.swing.JPanel KundeAnlegen;
    private javax.swing.JButton abbrechen_KundeAnlegen;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel147;
    private javax.swing.JLabel jLabel148;
    private javax.swing.JLabel jLabel149;
    private javax.swing.JLabel jLabel150;
    private javax.swing.JLabel jLabel151;
    private javax.swing.JLabel jLabel152;
    private javax.swing.JLabel jLabel153;
    private javax.swing.JLabel jLabel154;
    private javax.swing.JLabel jLabel155;
    private javax.swing.JLabel jLabel156;
    private javax.swing.JLabel jLabel157;
    private javax.swing.JLabel jLabel158;
    private javax.swing.JLabel jLabel159;
    private javax.swing.JLabel jLabel160;
    private javax.swing.JLabel jLabel161;
    private javax.swing.JLabel jLabel162;
    private javax.swing.JLabel jLabel163;
    private javax.swing.JLabel jLabel164;
    private javax.swing.JLabel jLabel165;
    private javax.swing.JPanel jPKontakt;
    public static javax.swing.JPanel jPLieferdaten;
    private javax.swing.JPanel jPRechnungsdaten;
    private javax.swing.JSeparator jSeparator20;
    private javax.swing.JButton jbSpeichern;
    private javax.swing.JComboBox<String> jcbAnredeRG_KundeAnlegen;
    private javax.swing.JRadioButton jrbAbweichendeLieferadresse_KundeAnlegen;
    private javax.swing.JRadioButton jrbLieferadresseIdentisch_KundeAnlegen;
    private javax.swing.JTextField jrfTelefax_KundeAnlegen;
    private javax.swing.JTextField jtfEMail_KundeAnlegen;
    private javax.swing.JTextField jtfFirma2_KundeAnlegen;
    private javax.swing.JTextField jtfFirmaRG_KundeAnlegen;
    private javax.swing.JTextField jtfGPID_KundeAnlegen;
    private javax.swing.JTextField jtfHNrRG_KundeAnlegen;
    private javax.swing.JTextField jtfKreditlimit_KundenAnlegen;
    private javax.swing.JTextField jtfName2_KundeAnlegen;
    private javax.swing.JTextField jtfNameRG_KundeAnlegen;
    private javax.swing.JTextField jtfOrtRG_KundeAnlegen;
    private javax.swing.JTextField jtfPlz2_KundeAnlegen;
    private javax.swing.JTextField jtfPlzRG_KundeAnlegen;
    private javax.swing.JTextField jtfStaat2_KundeAnlegen;
    private javax.swing.JTextField jtfStaatRG_KundeAnlegen;
    private javax.swing.JTextField jtfStraße2_KundeAnlegen;
    private javax.swing.JTextField jtfStraßeRG_KundeAnlegen;
    private javax.swing.JTextField jtfTelefon_KundeAnlegen;
    private javax.swing.JTextField jtfVorname2_KundeAnlegen;
    private javax.swing.JTextField jtfVornameRG_KundeAnlegen;
    // End of variables declaration//GEN-END:variables
}
