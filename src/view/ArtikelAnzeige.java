/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import dao.DAOArtikel;
import dao.DAOAuftragsposition;
import java.sql.SQLException;
import java.text.DecimalFormatSymbols;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Auftragsposition;

/*----------------------------------------------------------*/
/* Datum    Name    Was */
/* 14.11.16 Yoeruek Erstellung*/
/* 24.11.16 Yoeruek Aufsplittung der StartAv Klasse in einzelne Klassen, da Code für eine Klasse zu lang. */
/* 27.11.16 Yoeruek Anpassung der Größenverhältnisse (Schriftart, Layout)*/
/*----------------------------------------------------------*/
public class ArtikelAnzeige extends javax.swing.JInternalFrame {
    
    //Variablendeklaration
    StartAV myParent;
 
    //Konstantendeklaration
    private final String Loeschen_Text = "Soll der Artikel wirklich gelöscht werden?"; 
    private final String Loeschen_Titel = "Artikel Löschen";
    
    /**
     * Creates new form ArtikelAnzeige
     */
    public ArtikelAnzeige(StartAV parent) {
          myParent = parent;
         
          
        initComponents();
     
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ArtikelAnzeige = new javax.swing.JPanel();
        jLabel37 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        jtfArtikelID_ArtikelAnzeigen = new javax.swing.JTextField();
        jbsuchen_artikelanzeigen = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtArtikelListe = new javax.swing.JTable();
        jbLöschen_artikelAnzeigen = new javax.swing.JButton();
        jbBearbeiten_artikelAnzeigen = new javax.swing.JButton();
        jcbSuchkriterium_ArtikelAnzeige = new javax.swing.JComboBox<>();
        jbAnzeigen_ArtikelAnzeige = new javax.swing.JButton();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameClosed(evt);
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
            }
        });

        ArtikelAnzeige.setPreferredSize(new java.awt.Dimension(1200, 900));

        jLabel37.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel37.setText("Artikel Anzeigen");

        jtfArtikelID_ArtikelAnzeigen.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtfArtikelID_ArtikelAnzeigen.setToolTipText("");
        jtfArtikelID_ArtikelAnzeigen.setMinimumSize(new java.awt.Dimension(6, 25));
        jtfArtikelID_ArtikelAnzeigen.setPreferredSize(new java.awt.Dimension(6, 25));
        jtfArtikelID_ArtikelAnzeigen.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfArtikelID_ArtikelAnzeigenKeyTyped(evt);
            }
        });

<<<<<<< HEAD
        jbSpeichern_ArtikelAnzeigen.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jbSpeichern_ArtikelAnzeigen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/speichern2.png"))); // NOI18N
        jbSpeichern_ArtikelAnzeigen.setText("Speichern");
        jbSpeichern_ArtikelAnzeigen.setPreferredSize(new java.awt.Dimension(130, 35));
        jbSpeichern_ArtikelAnzeigen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSpeichern_ArtikelAnzeigenActionPerformed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/lupe2.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
=======
        jbsuchen_artikelanzeigen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/lupe2.png"))); // NOI18N
        jbsuchen_artikelanzeigen.addActionListener(new java.awt.event.ActionListener() {
>>>>>>> 89806cc862e2033d0b3cc242f9fc6a7422d9ef87
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbsuchen_artikelanzeigenActionPerformed(evt);
            }
        });

        jtArtikelListe.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtArtikelListe.setModel(new javax.swing.table.DefaultTableModel(
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
                "Artikel ID", "Artikelname", "Artikeltext", "Bestandsmenge Frei", "Bestelltext", "Einzelwert"
            }
        ));
        jScrollPane1.setViewportView(jtArtikelListe);

        jbLöschen_artikelAnzeigen.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jbLöschen_artikelAnzeigen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/müll2.png"))); // NOI18N
        jbLöschen_artikelAnzeigen.setPreferredSize(new java.awt.Dimension(130, 35));
        jbLöschen_artikelAnzeigen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbLöschen_artikelAnzeigenActionPerformed(evt);
            }
        });

        jbBearbeiten_artikelAnzeigen.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jbBearbeiten_artikelAnzeigen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/bearbeiten1.png"))); // NOI18N
        jbBearbeiten_artikelAnzeigen.setPreferredSize(new java.awt.Dimension(130, 35));
        jbBearbeiten_artikelAnzeigen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBearbeiten_artikelAnzeigenActionPerformed(evt);
            }
        });

        jcbSuchkriterium_ArtikelAnzeige.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jcbSuchkriterium_ArtikelAnzeige.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Artikel-ID", "Artikelname", "Bestandsmenge Frei", "Einzelwert" }));

        jbAnzeigen_ArtikelAnzeige.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jbAnzeigen_ArtikelAnzeige.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/anzeigen.png"))); // NOI18N
        jbAnzeigen_ArtikelAnzeige.setText("Anzeigen");
        jbAnzeigen_ArtikelAnzeige.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAnzeigen_ArtikelAnzeigeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ArtikelAnzeigeLayout = new javax.swing.GroupLayout(ArtikelAnzeige);
        ArtikelAnzeige.setLayout(ArtikelAnzeigeLayout);
        ArtikelAnzeigeLayout.setHorizontalGroup(
            ArtikelAnzeigeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator4, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(ArtikelAnzeigeLayout.createSequentialGroup()
                .addGroup(ArtikelAnzeigeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ArtikelAnzeigeLayout.createSequentialGroup()
                        .addGap(355, 355, 355)
                        .addComponent(jLabel37))
<<<<<<< HEAD
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
                .addContainerGap(186, Short.MAX_VALUE))
=======
                    .addGroup(ArtikelAnzeigeLayout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(ArtikelAnzeigeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jbAnzeigen_ArtikelAnzeige, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(ArtikelAnzeigeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 871, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(ArtikelAnzeigeLayout.createSequentialGroup()
                                    .addComponent(jcbSuchkriterium_ArtikelAnzeige, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jtfArtikelID_ArtikelAnzeigen, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jbsuchen_artikelanzeigen, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jbBearbeiten_artikelAnzeigen, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jbLöschen_artikelAnzeigen, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(52, Short.MAX_VALUE))
>>>>>>> 89806cc862e2033d0b3cc242f9fc6a7422d9ef87
        );
        ArtikelAnzeigeLayout.setVerticalGroup(
            ArtikelAnzeigeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ArtikelAnzeigeLayout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(jLabel37)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
<<<<<<< HEAD
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
                .addContainerGap(33, Short.MAX_VALUE))
=======
                .addGap(33, 33, 33)
                .addGroup(ArtikelAnzeigeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbsuchen_artikelanzeigen, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(ArtikelAnzeigeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jtfArtikelID_ArtikelAnzeigen, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jcbSuchkriterium_ArtikelAnzeige, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jbBearbeiten_artikelAnzeigen, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbLöschen_artikelAnzeigen, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(57, 57, 57)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(jbAnzeigen_ArtikelAnzeige, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(150, Short.MAX_VALUE))
>>>>>>> 89806cc862e2033d0b3cc242f9fc6a7422d9ef87
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(ArtikelAnzeige, javax.swing.GroupLayout.PREFERRED_SIZE, 950, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(ArtikelAnzeige, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 4, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void setzeArtikelAnzeigeZurueck(){
        this.jtfArtikelID_ArtikelAnzeigen.setText("");
    }
    private void formInternalFrameClosed(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosed
        /* 02.12.16 Yoeruek Schließt das aktuelle Fenster */
       this.setzeArtikelAnzeigeZurueck();
    }//GEN-LAST:event_formInternalFrameClosed

    private void jbBearbeiten_artikelAnzeigenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBearbeiten_artikelAnzeigenActionPerformed
        /*--------------------------------------------------------------------------------------------*/
        /* 02.12.16 Yoeruek Die Methode prüft ob ein Artikel ausgewählt wurde, und übergibt die         */
        /*                eingegeben Artikel ID weiter an die nächste Maske. Wenn nichts ausgewählt   */
        /*                wurde kommt es zu einer Fehlermeldung.                                      */
        /*--------------------------------------------------------------------------------------------*/

        if(jtArtikelListe.getSelectedRow()== -1){
            JOptionPane.showMessageDialog(this, "Bitte wählen Sie einen Artikel aus!",
                "Keine Auswahl",JOptionPane.CLOSED_OPTION);
        }else{
            //Es wird ein neues Objekt erzeugt und die Artikel Id
            //wird der Maske Artikel Bearbeiten übergeben.
            ArtikelBearbeiten artikelBearbeiten =
            this.myParent.getArtikelBearbeiten();
            artikelBearbeiten.ladeDatenfuerArtikelID
            (this.jtfArtikelID_ArtikelAnzeigen.getText());
            artikelBearbeiten.setVisible(true);

        }
    }//GEN-LAST:event_jbBearbeiten_artikelAnzeigenActionPerformed

    private void jbLöschen_artikelAnzeigenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbLöschen_artikelAnzeigenActionPerformed
        /*--------------------------------------------------------------------------------------------*/
        /* 02.12.16 Yoeruek Die Methode prüft ob ein Artikel markiert ist und löscht anschließend     */
        /*                  die Daten. Falls nichts markiert wurde wird eine Fehlermeldung ausgegeben.*/
        /*--------------------------------------------------------------------------------------------*/

        //prüfen ob artikel zum löschen ausgewählt ist muss noch angelegt werden
        boolean istArtikelAusgewaehlt = true;
        if(istArtikelAusgewaehlt){
            DefaultTableModel model = (DefaultTableModel) this.jtArtikelListe.getModel();
            int index = this.jtArtikelListe.getSelectedRow(); //auswahl markieren
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
            JOptionPane.showConfirmDialog(this, Loeschen_Text, Loeschen_Titel, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            //          JOptionPane.showMessageDialog(this, "Soll der Artikel wirklich gelöscht werden?",
                //                    "Artikel löschen",JOptionPane.CLOSED_OPTION);
        }
        this.setVisible(false);
    }//GEN-LAST:event_jbLöschen_artikelAnzeigenActionPerformed

    private void jbsuchen_artikelanzeigenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbsuchen_artikelanzeigenActionPerformed
        /* 30.11.16 Yoeruek Öffnet über die Lupe Artikel-ID Suchen */
        //this.myParent.oeffneSucheArtikelAnzeigen();

<<<<<<< HEAD
    private void jbbearbeiten_ArtikelAnzeigenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbbearbeiten_ArtikelAnzeigenActionPerformed
        // TODO add your handling code here:
        
        jtfartikelname_ArtikelAnzeigen.setEnabled(true);
        jtffrei_ArtikelAnzeigen.setEnabled(true);
        jtfreserviert_ArtikelAnzeigen.setEnabled(true);
        jtfzulauf_ArtikelAnzeigen.setEnabled(true);
        jtfverkauft_ArtikelAnzeigen.setEnabled(true);
        jtaArtikeltext_ArtikelAnzeigen.setEnabled(true);
        jtaBestelltext_ArtikelAnzeigen.setEnabled(true);
        jtfeinzelwertnetto_ArtikelAnzeigen.setEnabled(true);
        jtfeinzelwertbrutto_ArtikelAnzeigen.setEnabled(true);
        jtfbestellwertnetto_ArtikelAnzeigen.setEnabled(true);
        jtfbestellwertbrutto_ArtikelAnzeigen.setEnabled(true);
        jcbmehrwertsteuer_ArtikelAnzeigen.setEnabled(true);
        
    }//GEN-LAST:event_jbbearbeiten_ArtikelAnzeigenActionPerformed
=======
    }//GEN-LAST:event_jbsuchen_artikelanzeigenActionPerformed
>>>>>>> 89806cc862e2033d0b3cc242f9fc6a7422d9ef87

    private void jtfArtikelID_ArtikelAnzeigenKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfArtikelID_ArtikelAnzeigenKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfArtikelID_ArtikelAnzeigenKeyTyped

    private void jbAnzeigen_ArtikelAnzeigeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAnzeigen_ArtikelAnzeigeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbAnzeigen_ArtikelAnzeigeActionPerformed

    private void jbSpeichern_ArtikelAnzeigenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSpeichern_ArtikelAnzeigenActionPerformed
        // TODO add your handling code here:
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
    }//GEN-LAST:event_jbSpeichern_ArtikelAnzeigenActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ArtikelAnzeige;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JButton jbAnzeigen_ArtikelAnzeige;
    private javax.swing.JButton jbBearbeiten_artikelAnzeigen;
    private javax.swing.JButton jbLöschen_artikelAnzeigen;
    private javax.swing.JButton jbsuchen_artikelanzeigen;
    private javax.swing.JComboBox<String> jcbSuchkriterium_ArtikelAnzeige;
    private javax.swing.JTable jtArtikelListe;
    private javax.swing.JTextField jtfArtikelID_ArtikelAnzeigen;
    // End of variables declaration//GEN-END:variables


}
