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
public class ArtikelSuchen extends javax.swing.JInternalFrame {
    
    //Variablendeklaration
    StartAV myParent;
 
    //Konstantendeklaration
    private final String Loeschen_Text = "Soll der Artikel wirklich gelöscht werden?"; 
    private final String Loeschen_Titel = "Artikel Löschen";
    
    /* 06.12.16 Yoeruek Konstruktor, damit beim rein ziehen der Masken in die StartAV keine Probleme entstehen. */
    public ArtikelSuchen(){
        initComponents();
    }
    
    /* 06.12.16 Yoeruek Konstruktor wird beim Ausführen der StartAV benutzt*/
    public ArtikelSuchen(StartAV parent) {
        myParent = parent;
        initComponents();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ArtikelSuche = new javax.swing.JPanel();
        jLabel37 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        jtfArtikelID_ArtikelSuchen = new javax.swing.JTextField();
        jbsuchen_artikelsuchen = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtArtikelListe = new javax.swing.JTable();
        jbLöschen_artikelSuchen = new javax.swing.JButton();
        jbBearbeiten_artikelSuchen = new javax.swing.JButton();
        jcbSuchkriterium_ArtikelAnzeige = new javax.swing.JComboBox<>();
        jbAnzeigen_ArtikelSuchen = new javax.swing.JButton();

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

        ArtikelSuche.setPreferredSize(new java.awt.Dimension(1200, 900));

        jLabel37.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel37.setText("Artikel Suchen");

        jtfArtikelID_ArtikelSuchen.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtfArtikelID_ArtikelSuchen.setToolTipText("");
        jtfArtikelID_ArtikelSuchen.setMinimumSize(new java.awt.Dimension(6, 25));
        jtfArtikelID_ArtikelSuchen.setPreferredSize(new java.awt.Dimension(6, 25));
        jtfArtikelID_ArtikelSuchen.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfArtikelID_ArtikelSuchenKeyTyped(evt);
            }
        });

        jbsuchen_artikelsuchen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/lupe.png"))); // NOI18N
        jbsuchen_artikelsuchen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbsuchen_artikelsuchenActionPerformed(evt);
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

        jbLöschen_artikelSuchen.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jbLöschen_artikelSuchen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/müll2.png"))); // NOI18N
        jbLöschen_artikelSuchen.setPreferredSize(new java.awt.Dimension(130, 35));
        jbLöschen_artikelSuchen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbLöschen_artikelSuchenActionPerformed(evt);
            }
        });

        jbBearbeiten_artikelSuchen.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jbBearbeiten_artikelSuchen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/bearbeiten1.png"))); // NOI18N
        jbBearbeiten_artikelSuchen.setPreferredSize(new java.awt.Dimension(130, 35));
        jbBearbeiten_artikelSuchen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBearbeiten_artikelSuchenActionPerformed(evt);
            }
        });

        jcbSuchkriterium_ArtikelAnzeige.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jcbSuchkriterium_ArtikelAnzeige.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Artikel-ID", "Artikelname", "Bestandsmenge Frei", "Einzelwert" }));

        jbAnzeigen_ArtikelSuchen.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jbAnzeigen_ArtikelSuchen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/anzeigen.png"))); // NOI18N
        jbAnzeigen_ArtikelSuchen.setText("Anzeigen");
        jbAnzeigen_ArtikelSuchen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAnzeigen_ArtikelSuchenActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ArtikelSucheLayout = new javax.swing.GroupLayout(ArtikelSuche);
        ArtikelSuche.setLayout(ArtikelSucheLayout);
        ArtikelSucheLayout.setHorizontalGroup(
            ArtikelSucheLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator4, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(ArtikelSucheLayout.createSequentialGroup()
                .addGroup(ArtikelSucheLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ArtikelSucheLayout.createSequentialGroup()
                        .addGap(392, 392, 392)
                        .addComponent(jLabel37))
                    .addGroup(ArtikelSucheLayout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(ArtikelSucheLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jbAnzeigen_ArtikelSuchen, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(ArtikelSucheLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 871, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(ArtikelSucheLayout.createSequentialGroup()
                                    .addComponent(jcbSuchkriterium_ArtikelAnzeige, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jtfArtikelID_ArtikelSuchen, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jbsuchen_artikelsuchen, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jbBearbeiten_artikelSuchen, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jbLöschen_artikelSuchen, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(52, Short.MAX_VALUE))
        );
        ArtikelSucheLayout.setVerticalGroup(
            ArtikelSucheLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ArtikelSucheLayout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(jLabel37)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addGroup(ArtikelSucheLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbsuchen_artikelsuchen, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(ArtikelSucheLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jtfArtikelID_ArtikelSuchen, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jcbSuchkriterium_ArtikelAnzeige, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jbBearbeiten_artikelSuchen, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbLöschen_artikelSuchen, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(57, 57, 57)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(jbAnzeigen_ArtikelSuchen, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(ArtikelSuche, javax.swing.GroupLayout.PREFERRED_SIZE, 950, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ArtikelSuche, javax.swing.GroupLayout.PREFERRED_SIZE, 674, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void setzeArtikelAnzeigeZurueck(){
        this.jtfArtikelID_ArtikelSuchen.setText("");
    }
    private void formInternalFrameClosed(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosed
        /* 02.12.16 Yoeruek Schließt das aktuelle Fenster */
       this.setzeArtikelAnzeigeZurueck();
    }//GEN-LAST:event_formInternalFrameClosed

    private void jbBearbeiten_artikelSuchenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBearbeiten_artikelSuchenActionPerformed
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
            (this.jtfArtikelID_ArtikelSuchen.getText());
            artikelBearbeiten.setVisible(true);

        }
    }//GEN-LAST:event_jbBearbeiten_artikelSuchenActionPerformed

    private void jbLöschen_artikelSuchenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbLöschen_artikelSuchenActionPerformed
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
    }//GEN-LAST:event_jbLöschen_artikelSuchenActionPerformed

    private void jbsuchen_artikelsuchenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbsuchen_artikelsuchenActionPerformed
        /* 30.11.16 Yoeruek Öffnet über die Lupe Artikel-ID Suchen */
        //this.myParent.oeffneSucheArtikelAnzeigen();

    }//GEN-LAST:event_jbsuchen_artikelsuchenActionPerformed

    private void jtfArtikelID_ArtikelSuchenKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfArtikelID_ArtikelSuchenKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfArtikelID_ArtikelSuchenKeyTyped

    private void jbAnzeigen_ArtikelSuchenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAnzeigen_ArtikelSuchenActionPerformed
        myParent.oeffneArtikelAnzeigen();
    }//GEN-LAST:event_jbAnzeigen_ArtikelSuchenActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ArtikelSuche;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JButton jbAnzeigen_ArtikelSuchen;
    private javax.swing.JButton jbBearbeiten_artikelSuchen;
    private javax.swing.JButton jbLöschen_artikelSuchen;
    private javax.swing.JButton jbsuchen_artikelsuchen;
    private javax.swing.JComboBox<String> jcbSuchkriterium_ArtikelAnzeige;
    private javax.swing.JTable jtArtikelListe;
    private javax.swing.JTextField jtfArtikelID_ArtikelSuchen;
    // End of variables declaration//GEN-END:variables


}
