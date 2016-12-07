/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javax.swing.JOptionPane;

/*--------------------------------------------------------------------------------------------------------*/
 /* Datum    Name    Was                                                                                   */
 /* 15.11.16 Yoeruek Erstellung                                                                            */
 /* 24.11.16 Yoeruek Aufsplittung der StartAv Klasse in einzelne Klassen, da Code für eine Klasse zu lang. */
 /* 27.11.16 Yoeruek Anpassung der Größenverhältnisse (Schriftart, Layout)                                 */
 /* 05.12.16 Yoeruek Klasse neu strukturiert                                                               */
 /*--------------------------------------------------------------------------------------------------------*/
public class AuftragAnzeigen extends javax.swing.JInternalFrame {

    /**
     * Creates new form AuftragAnzeigen
     */
    StartAV myParent;

    
    /* 06.12.16 Yoeruek Konstruktor, damit beim rein ziehen der Masken in die StartAV keine Probleme entstehen. */
    public AuftragAnzeigen() {
        initComponents();
    }

    
    /* 06.12.16 Yoeruek Konstruktor wird beim Ausführen der StartAV benutzt*/
    public AuftragAnzeigen(StartAV parent) {
        initComponents();

        //Variablendeklaration
        myParent = parent;
        /* 28.11.2016 Yoeruek Felder werden inaktiv gesetzt*/
        jftfLieferdatum_az.setEnabled(false);
        jftfAbschlussdatum_az.setEnabled(false);
        jftfErfassungsdatum_az.setEnabled(false);
        jtaBeschreibung_az.setEnabled(false);
        jtfAuftragswertbrutto_az.setEnabled(false);
//        jtfAuftragswertnetto_az.setEnabled(false);
        jtfGPID_az.setEnabled(false);
        jtfGPName_az.setEnabled(false);
        jtfGPadresse_az.setEnabled(false);
        jtfZKID_az.setEnabled(false);
        jcbAuftragsart_az.setEnabled(false);
        jcbStatus_az.setEnabled(false);
        jtTabellePosition_AuftragAnzeigen.setEnabled(false);
    }

    /*------------------------------------------------------------*/
 /* 01.12.16 Yoeruek Prüfung nach Pflichtfeldern, falls nichts */
 /*            angegeben ist wird eine Fehlermeldung ausgegeben*/
 /*------------------------------------------------------------*/
    public boolean istVollstaendig() {
        Boolean vollstaendig = false;
        String fehlermeldung = "";
        if (jtfAuftragsid_az.getText().equals("")) {
            fehlermeldung = "Geben Sie bitte eine Auftrags-ID ein!";
            jtfAuftragsid_az.requestFocusInWindow();
        }
        if (fehlermeldung.equals("")) {
            vollstaendig = true;
        } else {
            JOptionPane.showMessageDialog(this, fehlermeldung, "Unvollständig", JOptionPane.WARNING_MESSAGE);
        }
        return vollstaendig;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jbZurueck_az = new javax.swing.JButton();
        jbBearbeiten_az = new javax.swing.JButton();
        jpAuftragsposition_AuftragAnzeigen = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtTabellePosition_AuftragAnzeigen = new javax.swing.JTable();
        jpAuftragskopf_AuftragAnzeigen = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtaBeschreibung_az = new javax.swing.JTextArea();
        jLabel12 = new javax.swing.JLabel();
        jtfAuftragswertbrutto_az = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jftfAbschlussdatum_az = new javax.swing.JFormattedTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jftfLieferdatum_az = new javax.swing.JFormattedTextField();
        jftfErfassungsdatum_az = new javax.swing.JFormattedTextField();
        jLabel9 = new javax.swing.JLabel();
        jtfZKID_az = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jcbAuftragsart_az = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jcbStatus_az = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jtfGPadresse_az = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jtfGPName_az = new javax.swing.JTextField();
        jtfGPID_az = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jtfAuftragsid_az = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(900, 800));

        jPanel1.setPreferredSize(new java.awt.Dimension(900, 800));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Auftrag Anzeigen");

        jbZurueck_az.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jbZurueck_az.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/zurück.png"))); // NOI18N
        jbZurueck_az.setText("Zurück");
        jbZurueck_az.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbZurueck_azActionPerformed(evt);
            }
        });

        jbBearbeiten_az.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jbBearbeiten_az.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/bearbeiten1.png"))); // NOI18N
        jbBearbeiten_az.setText("Bearbeiten");

        jpAuftragsposition_AuftragAnzeigen.setBorder(javax.swing.BorderFactory.createTitledBorder("Auftragsposition"));

        jtTabellePosition_AuftragAnzeigen.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtTabellePosition_AuftragAnzeigen.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Positionsnr.", "Artikel ID", "Artikelname", "Menge", "Einzelwert", "Gesamtwert"
            }
        ));
        jScrollPane2.setViewportView(jtTabellePosition_AuftragAnzeigen);

        javax.swing.GroupLayout jpAuftragsposition_AuftragAnzeigenLayout = new javax.swing.GroupLayout(jpAuftragsposition_AuftragAnzeigen);
        jpAuftragsposition_AuftragAnzeigen.setLayout(jpAuftragsposition_AuftragAnzeigenLayout);
        jpAuftragsposition_AuftragAnzeigenLayout.setHorizontalGroup(
            jpAuftragsposition_AuftragAnzeigenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpAuftragsposition_AuftragAnzeigenLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 811, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jpAuftragsposition_AuftragAnzeigenLayout.setVerticalGroup(
            jpAuftragsposition_AuftragAnzeigenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpAuftragsposition_AuftragAnzeigenLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jpAuftragskopf_AuftragAnzeigen.setBorder(javax.swing.BorderFactory.createTitledBorder("Auftragskopf"));

        jtaBeschreibung_az.setColumns(20);
        jtaBeschreibung_az.setRows(5);
        jScrollPane1.setViewportView(jtaBeschreibung_az);

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel12.setText("Beschreibung:");

        jtfAuftragswertbrutto_az.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel13.setText("Auftragswert (brutto):");

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel11.setText("Abschlussdatum:");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel10.setText("Lieferdatum:");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel9.setText("Erfassungsdatum:");

        jtfZKID_az.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel7.setText("Zahlungskondition ID:");

        jcbAuftragsart_az.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jcbAuftragsart_az.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Barauftrag", "Sofortauftrag", "Terminauftrag", "Bestellauftrag" }));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel6.setText("Auftragsart:");

        jcbStatus_az.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jcbStatus_az.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "erfasst", "freigegeben", "abgeschlossen" }));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel8.setText("Status:");

        jtfGPadresse_az.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel5.setText("Geschäftspartner Adresse:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel4.setText("Geschäftspartner Name:");

        jtfGPName_az.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jtfGPID_az.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel3.setText("Geschäftspartner ID:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel2.setText("Auftrags-ID:");

        jtfAuftragsid_az.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        javax.swing.GroupLayout jpAuftragskopf_AuftragAnzeigenLayout = new javax.swing.GroupLayout(jpAuftragskopf_AuftragAnzeigen);
        jpAuftragskopf_AuftragAnzeigen.setLayout(jpAuftragskopf_AuftragAnzeigenLayout);
        jpAuftragskopf_AuftragAnzeigenLayout.setHorizontalGroup(
            jpAuftragskopf_AuftragAnzeigenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpAuftragskopf_AuftragAnzeigenLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpAuftragskopf_AuftragAnzeigenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 813, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jpAuftragskopf_AuftragAnzeigenLayout.createSequentialGroup()
                        .addGroup(jpAuftragskopf_AuftragAnzeigenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel8))
                        .addGap(37, 37, 37)
                        .addGroup(jpAuftragskopf_AuftragAnzeigenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jcbStatus_az, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfAuftragsid_az, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfGPID_az, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfGPName_az, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfGPadresse_az, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(114, 114, 114)
                        .addGroup(jpAuftragskopf_AuftragAnzeigenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpAuftragskopf_AuftragAnzeigenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jpAuftragskopf_AuftragAnzeigenLayout.createSequentialGroup()
                                    .addGap(153, 153, 153)
                                    .addGroup(jpAuftragskopf_AuftragAnzeigenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jftfAbschlussdatum_az, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jftfLieferdatum_az, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jftfErfassungsdatum_az, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addComponent(jtfAuftragswertbrutto_az, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jpAuftragskopf_AuftragAnzeigenLayout.createSequentialGroup()
                                .addGroup(jpAuftragskopf_AuftragAnzeigenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel13))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jpAuftragskopf_AuftragAnzeigenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jtfZKID_az, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jcbAuftragsart_az, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addComponent(jLabel12))
                .addContainerGap(39, Short.MAX_VALUE))
        );
        jpAuftragskopf_AuftragAnzeigenLayout.setVerticalGroup(
            jpAuftragskopf_AuftragAnzeigenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpAuftragskopf_AuftragAnzeigenLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jpAuftragskopf_AuftragAnzeigenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jpAuftragskopf_AuftragAnzeigenLayout.createSequentialGroup()
                        .addGroup(jpAuftragskopf_AuftragAnzeigenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jcbAuftragsart_az, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addGroup(jpAuftragskopf_AuftragAnzeigenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jtfZKID_az, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jpAuftragskopf_AuftragAnzeigenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(jftfErfassungsdatum_az, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jpAuftragskopf_AuftragAnzeigenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(jftfLieferdatum_az, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jpAuftragskopf_AuftragAnzeigenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(jftfAbschlussdatum_az, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jpAuftragskopf_AuftragAnzeigenLayout.createSequentialGroup()
                        .addGroup(jpAuftragskopf_AuftragAnzeigenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtfAuftragsid_az, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addGroup(jpAuftragskopf_AuftragAnzeigenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtfGPID_az, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(jpAuftragskopf_AuftragAnzeigenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtfGPName_az, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(jpAuftragskopf_AuftragAnzeigenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jtfGPadresse_az, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jpAuftragskopf_AuftragAnzeigenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(jcbStatus_az, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(jpAuftragskopf_AuftragAnzeigenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfAuftragswertbrutto_az, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addGap(18, 18, 18)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(82, 82, 82))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(359, 359, 359)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jpAuftragskopf_AuftragAnzeigen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpAuftragsposition_AuftragAnzeigen, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jbBearbeiten_az, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jbZurueck_az, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpAuftragskopf_AuftragAnzeigen, javax.swing.GroupLayout.PREFERRED_SIZE, 438, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpAuftragsposition_AuftragAnzeigen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbZurueck_az, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbBearbeiten_az, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 748, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbZurueck_azActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbZurueck_azActionPerformed
        /* 24.11.16 Yoeruek Schließt das Fenster nach Betätigung des Zurück Buttons */
        this.setVisible(false);
    }//GEN-LAST:event_jbZurueck_azActionPerformed




    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton jbBearbeiten_az;
    private javax.swing.JButton jbZurueck_az;
    private javax.swing.JComboBox<String> jcbAuftragsart_az;
    private javax.swing.JComboBox<String> jcbStatus_az;
    private javax.swing.JFormattedTextField jftfAbschlussdatum_az;
    private javax.swing.JFormattedTextField jftfErfassungsdatum_az;
    private javax.swing.JFormattedTextField jftfLieferdatum_az;
    private javax.swing.JPanel jpAuftragskopf_AuftragAnzeigen;
    private javax.swing.JPanel jpAuftragsposition_AuftragAnzeigen;
    private javax.swing.JTable jtTabellePosition_AuftragAnzeigen;
    private javax.swing.JTextArea jtaBeschreibung_az;
    private javax.swing.JTextField jtfAuftragsid_az;
    private javax.swing.JTextField jtfAuftragswertbrutto_az;
    private javax.swing.JTextField jtfGPID_az;
    private javax.swing.JTextField jtfGPName_az;
    private javax.swing.JTextField jtfGPadresse_az;
    private javax.swing.JTextField jtfZKID_az;
    // End of variables declaration//GEN-END:variables
}
