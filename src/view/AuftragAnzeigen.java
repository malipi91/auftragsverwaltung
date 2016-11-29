/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

/*----------------------------------------------------------*/
/* Datum Name Was */
/* 15.11.16 Yoeruek Erstellung*/
/* 24.11.16 Yoeruek Aufsplittung der StartAv Klasse in einzelne Klassen, da Code für eine Klasse zu lang. */
/* 27.11.16 Yoeruek Anpassung der Größenverhältnisse (Schriftart, Layout)*/
/*----------------------------------------------------------*/
public class AuftragAnzeigen extends javax.swing.JInternalFrame {


    public AuftragAnzeigen() {
        initComponents();
        
        /* 28.11.2016 Yoeruek Felder werden inaktiv gesetzt*/
        jftfLieferdatum_az.setEnabled(false);
        jftfAbschlussdatum_az.setEnabled(false);
        jftfErfassungsdatum_az.setEnabled(false);
        jtaBeschreibung_az.setEnabled(false);
        jtfAuftragswertbrutto_az.setEnabled(false);
        jtfAuftragswertnetto_az.setEnabled(false);
        jtfGPID_az.setEnabled(false);
        jtfGPName_az.setEnabled(false);
        jtfGPadresse_az.setEnabled(false);
        jtfZKID_az.setEnabled(false);
        jcbAuftragsart_az.setEnabled(false);
        jcbStatus_az.setEnabled(false);
        jtTabellePosition_AuftragAnzeigen.setEnabled(false);
        
//        jtfAuftragsid_az.setEnabled(false);
        
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        AuftragAnzeigen = new javax.swing.JPanel();
        jlAuftragsid = new javax.swing.JLabel();
        jtfAuftragsid_az = new javax.swing.JTextField();
        jlGPNr = new javax.swing.JLabel();
        jtfGPID_az = new javax.swing.JTextField();
        jlAuftragsart = new javax.swing.JLabel();
        jlGPName = new javax.swing.JLabel();
        jtfGPName_az = new javax.swing.JTextField();
        jlErfassungsdatum = new javax.swing.JLabel();
        jlLieferdatum = new javax.swing.JLabel();
        jbSpeichern_az = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtTabellePosition_AuftragAnzeigen = new javax.swing.JTable();
        jbBearbeiten_az = new javax.swing.JButton();
        jbZurueck_az = new javax.swing.JButton();
        titel_az = new javax.swing.JLabel();
        jlGPadresse_az = new javax.swing.JLabel();
        jtfGPadresse_az = new javax.swing.JTextField();
        jlZKID = new javax.swing.JLabel();
        jtfZKID_az = new javax.swing.JTextField();
        jlStatus = new javax.swing.JLabel();
        jcbStatus_az = new javax.swing.JComboBox<>();
        jlAbschlussdatum = new javax.swing.JLabel();
        jlBeschreibung = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtaBeschreibung_az = new javax.swing.JTextArea();
        jlAuftragswertbrutto_az = new javax.swing.JLabel();
        jtfAuftragswertbrutto_az = new javax.swing.JTextField();
        jlAuftragswertnetto_az = new javax.swing.JLabel();
        jtfAuftragswertnetto_az = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        jftfLieferdatum_az = new javax.swing.JFormattedTextField();
        jftfAbschlussdatum_az = new javax.swing.JFormattedTextField();
        jftfErfassungsdatum_az = new javax.swing.JFormattedTextField();
        jbLupeAuftragsID_AuftragAnzeigen = new javax.swing.JButton();
        jcbAuftragsart_az = new javax.swing.JComboBox<>();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);

        AuftragAnzeigen.setPreferredSize(new java.awt.Dimension(1200, 800));

        jlAuftragsid.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jlAuftragsid.setText("Auftrags-ID:");

        jtfAuftragsid_az.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtfAuftragsid_az.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfAuftragsid_azActionPerformed(evt);
            }
        });

        jlGPNr.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jlGPNr.setText("Geschäftspartner-ID:");

        jtfGPID_az.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtfGPID_az.setToolTipText("");
        jtfGPID_az.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfGPID_azActionPerformed(evt);
            }
        });

        jlAuftragsart.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jlAuftragsart.setText("Auftragsart:");

        jlGPName.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jlGPName.setText("Geschäftspartner-Name:");

        jtfGPName_az.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jlErfassungsdatum.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jlErfassungsdatum.setText("Erfassungsdatum:");

        jlLieferdatum.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jlLieferdatum.setText("Lieferdatum:");

        jbSpeichern_az.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jbSpeichern_az.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/speichern2.png"))); // NOI18N
        jbSpeichern_az.setText("Speichern");
        jbSpeichern_az.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSpeichern_azActionPerformed(evt);
            }
        });

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
                "Positionsnr.", "Artikel-ID", "Artikelname", "Menge", "Einzelwert", "Gesamtwert"
            }
        ));
        jtTabellePosition_AuftragAnzeigen.setAutoscrolls(false);
        jScrollPane1.setViewportView(jtTabellePosition_AuftragAnzeigen);

        jbBearbeiten_az.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jbBearbeiten_az.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/bearbeiten1.png"))); // NOI18N
        jbBearbeiten_az.setText("Bearbeiten");
        jbBearbeiten_az.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBearbeiten_azActionPerformed(evt);
            }
        });

        jbZurueck_az.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jbZurueck_az.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/zurück.png"))); // NOI18N
        jbZurueck_az.setText("Zurück");
        jbZurueck_az.setToolTipText("");
        jbZurueck_az.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbZurueck_azActionPerformed(evt);
            }
        });

        titel_az.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        titel_az.setText("Auftrag Anzeigen");

        jlGPadresse_az.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jlGPadresse_az.setText("Geschäftspartner Adresse:");

        jtfGPadresse_az.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jlZKID.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jlZKID.setText("Zahlungskondition-ID:");

        jtfZKID_az.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtfZKID_az.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfZKID_azActionPerformed(evt);
            }
        });

        jlStatus.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jlStatus.setText("Status:");

        jcbStatus_az.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jcbStatus_az.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "erfasst", "freigegeben", "abgeschlossen" }));

        jlAbschlussdatum.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jlAbschlussdatum.setText("Abschlussdatum:");

        jlBeschreibung.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jlBeschreibung.setText("Beschreibung:");

        jtaBeschreibung_az.setColumns(20);
        jtaBeschreibung_az.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtaBeschreibung_az.setRows(5);
        jScrollPane2.setViewportView(jtaBeschreibung_az);

        jlAuftragswertbrutto_az.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jlAuftragswertbrutto_az.setText("Auftragswert(brutto):");

        jtfAuftragswertbrutto_az.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jlAuftragswertnetto_az.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jlAuftragswertnetto_az.setText("Auftragswert (netto):");

        jtfAuftragswertnetto_az.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jbLupeAuftragsID_AuftragAnzeigen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/lupe.png"))); // NOI18N
        jbLupeAuftragsID_AuftragAnzeigen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbLupeAuftragsID_AuftragAnzeigenActionPerformed(evt);
            }
        });

        jcbAuftragsart_az.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jcbAuftragsart_az.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "Barauftrag", "Sofortauftrag", "Terminauftrag", "Bestellauftrag" }));
        jcbAuftragsart_az.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbAuftragsart_azActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout AuftragAnzeigenLayout = new javax.swing.GroupLayout(AuftragAnzeigen);
        AuftragAnzeigen.setLayout(AuftragAnzeigenLayout);
        AuftragAnzeigenLayout.setHorizontalGroup(
            AuftragAnzeigenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(AuftragAnzeigenLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(AuftragAnzeigenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(AuftragAnzeigenLayout.createSequentialGroup()
                        .addGroup(AuftragAnzeigenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jlGPName, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, AuftragAnzeigenLayout.createSequentialGroup()
                                .addGap(336, 336, 336)
                                .addComponent(titel_az, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())
                    .addGroup(AuftragAnzeigenLayout.createSequentialGroup()
                        .addGroup(AuftragAnzeigenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(AuftragAnzeigenLayout.createSequentialGroup()
                                .addGroup(AuftragAnzeigenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jlAuftragsid)
                                    .addComponent(jlGPNr)
                                    .addComponent(jlAuftragswertbrutto_az)
                                    .addComponent(jlAuftragswertnetto_az))
                                .addGap(78, 78, 78)
                                .addGroup(AuftragAnzeigenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(AuftragAnzeigenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jtfGPID_az, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                                        .addComponent(jtfGPName_az, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                                        .addComponent(jtfGPadresse_az, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                                        .addComponent(jtfAuftragswertbrutto_az, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                                        .addComponent(jtfAuftragswertnetto_az, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE))
                                    .addComponent(jtfAuftragsid_az, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jlGPadresse_az))
                        .addGap(7, 7, 7)
                        .addComponent(jbLupeAuftragsID_AuftragAnzeigen, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addGroup(AuftragAnzeigenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(AuftragAnzeigenLayout.createSequentialGroup()
                                .addComponent(jlBeschreibung)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(AuftragAnzeigenLayout.createSequentialGroup()
                                .addGroup(AuftragAnzeigenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jlAbschlussdatum)
                                    .addComponent(jlStatus)
                                    .addComponent(jlZKID)
                                    .addComponent(jlAuftragsart)
                                    .addComponent(jlLieferdatum)
                                    .addComponent(jlErfassungsdatum))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(AuftragAnzeigenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jftfLieferdatum_az, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jftfErfassungsdatum_az, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jcbAuftragsart_az, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jtfZKID_az, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jcbStatus_az, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jftfAbschlussdatum_az, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(AuftragAnzeigenLayout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
            .addGroup(AuftragAnzeigenLayout.createSequentialGroup()
                .addContainerGap(38, Short.MAX_VALUE)
                .addGroup(AuftragAnzeigenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(AuftragAnzeigenLayout.createSequentialGroup()
                        .addComponent(jbSpeichern_az, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jbBearbeiten_az, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jbZurueck_az, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 835, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(77, Short.MAX_VALUE))
        );
        AuftragAnzeigenLayout.setVerticalGroup(
            AuftragAnzeigenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AuftragAnzeigenLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titel_az)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(AuftragAnzeigenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(AuftragAnzeigenLayout.createSequentialGroup()
                        .addGroup(AuftragAnzeigenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(AuftragAnzeigenLayout.createSequentialGroup()
                                .addGap(41, 41, 41)
                                .addGroup(AuftragAnzeigenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jlAuftragsid)
                                    .addComponent(jtfAuftragsid_az, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jlAuftragsart)
                                    .addComponent(jbLupeAuftragsID_AuftragAnzeigen, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(AuftragAnzeigenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jlGPNr)
                                    .addComponent(jtfGPID_az, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(AuftragAnzeigenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jlGPName)
                                    .addComponent(jtfGPName_az, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jlStatus))
                                .addGap(18, 18, 18)
                                .addGroup(AuftragAnzeigenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jlGPadresse_az)
                                    .addComponent(jtfGPadresse_az, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(AuftragAnzeigenLayout.createSequentialGroup()
                                .addGap(93, 93, 93)
                                .addComponent(jlZKID)
                                .addGap(61, 61, 61)
                                .addComponent(jlErfassungsdatum)))
                        .addGap(18, 18, 18)
                        .addComponent(jlLieferdatum))
                    .addGroup(AuftragAnzeigenLayout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addGroup(AuftragAnzeigenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(AuftragAnzeigenLayout.createSequentialGroup()
                                .addGap(130, 130, 130)
                                .addComponent(jftfErfassungsdatum_az, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jftfLieferdatum_az, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(AuftragAnzeigenLayout.createSequentialGroup()
                                .addComponent(jcbAuftragsart_az, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jtfZKID_az, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jcbStatus_az, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGroup(AuftragAnzeigenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(AuftragAnzeigenLayout.createSequentialGroup()
                        .addGap(89, 89, 89)
                        .addGroup(AuftragAnzeigenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlAuftragswertbrutto_az)
                            .addComponent(jtfAuftragswertbrutto_az, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(AuftragAnzeigenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlAuftragswertnetto_az)
                            .addComponent(jtfAuftragswertnetto_az, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(AuftragAnzeigenLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(AuftragAnzeigenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlAbschlussdatum)
                            .addComponent(jftfAbschlussdatum_az, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(39, 39, 39)
                        .addComponent(jlBeschreibung)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(36, 36, 36)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(AuftragAnzeigenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbZurueck_az, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbBearbeiten_az, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbSpeichern_az, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(AuftragAnzeigen, javax.swing.GroupLayout.PREFERRED_SIZE, 950, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(AuftragAnzeigen, javax.swing.GroupLayout.DEFAULT_SIZE, 782, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtfAuftragsid_azActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfAuftragsid_azActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfAuftragsid_azActionPerformed

    private void jtfGPID_azActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfGPID_azActionPerformed

    }//GEN-LAST:event_jtfGPID_azActionPerformed

    private void jcbAuftragsart_azActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbAuftragsart_azActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbAuftragsart_azActionPerformed

    private void jbZurueck_azActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbZurueck_azActionPerformed
        /*----------------------------------------------------------*/
        /* 24.11.16 Yoeruek Schließt das Fenster nach Betätigung des Abbrech Buttons */
        /*----------------------------------------------------------*/
        this.setVisible(false);
    }//GEN-LAST:event_jbZurueck_azActionPerformed

    private void jtfZKID_azActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfZKID_azActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfZKID_azActionPerformed

    private void jbBearbeiten_azActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBearbeiten_azActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbBearbeiten_azActionPerformed

    private void jbSpeichern_azActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSpeichern_azActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbSpeichern_azActionPerformed

    private void jbLupeAuftragsID_AuftragAnzeigenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbLupeAuftragsID_AuftragAnzeigenActionPerformed

    }//GEN-LAST:event_jbLupeAuftragsID_AuftragAnzeigenActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel AuftragAnzeigen;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JButton jbBearbeiten_az;
    private javax.swing.JButton jbLupeAuftragsID_AuftragAnzeigen;
    private javax.swing.JButton jbSpeichern_az;
    private javax.swing.JButton jbZurueck_az;
    private javax.swing.JComboBox<String> jcbAuftragsart_az;
    private javax.swing.JComboBox<String> jcbStatus_az;
    private javax.swing.JFormattedTextField jftfAbschlussdatum_az;
    private javax.swing.JFormattedTextField jftfErfassungsdatum_az;
    private javax.swing.JFormattedTextField jftfLieferdatum_az;
    private javax.swing.JLabel jlAbschlussdatum;
    private javax.swing.JLabel jlAuftragsart;
    private javax.swing.JLabel jlAuftragsid;
    private javax.swing.JLabel jlAuftragswertbrutto_az;
    private javax.swing.JLabel jlAuftragswertnetto_az;
    private javax.swing.JLabel jlBeschreibung;
    private javax.swing.JLabel jlErfassungsdatum;
    private javax.swing.JLabel jlGPName;
    private javax.swing.JLabel jlGPNr;
    private javax.swing.JLabel jlGPadresse_az;
    private javax.swing.JLabel jlLieferdatum;
    private javax.swing.JLabel jlStatus;
    private javax.swing.JLabel jlZKID;
    private javax.swing.JTable jtTabellePosition_AuftragAnzeigen;
    private javax.swing.JTextArea jtaBeschreibung_az;
    private javax.swing.JTextField jtfAuftragsid_az;
    private javax.swing.JTextField jtfAuftragswertbrutto_az;
    private javax.swing.JTextField jtfAuftragswertnetto_az;
    private javax.swing.JTextField jtfGPID_az;
    private javax.swing.JTextField jtfGPName_az;
    private javax.swing.JTextField jtfGPadresse_az;
    private javax.swing.JTextField jtfZKID_az;
    private javax.swing.JLabel titel_az;
    // End of variables declaration//GEN-END:variables
}
