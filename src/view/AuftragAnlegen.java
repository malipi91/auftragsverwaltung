/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import dao.DAOArtikel;
import dao.DAOAuftrag;
import dao.DAOAuftragsposition;
import dao.DAOKunde;
import dao.DAOLieferant;
import dao.DAOZahlungskondition;
import java.sql.Array;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import model.Artikel;
import model.Auftrag;
import model.Auftragsposition;
import model.Auftragsstatus;
import model.Kunde;
import model.Lieferant;
import model.Zahlungskondition;
import org.omg.CORBA.portable.ApplicationException;

/*----------------------------------------------------------*/
 /* Datum    Name    Was */
 /* 15.11.16 Yoeruek Erstellung*/
 /* 24.11.16 Yoeruek Aufsplittung der StartAv Klasse in einzelne Klassen, da Code für eine Klasse zu lang. */
 /* 27.11.16 Yoeruek Anpassung der Größenverhältnisse (Schriftart, Layout)*/
 /*----------------------------------------------------------*/
public class AuftragAnlegen extends javax.swing.JInternalFrame {

    //Variablendeklaration
    StartAV myParent;


    // Variablendeklaration Citak 29.11.2016
    private DAOAuftrag daoAuftrag;
    private DAOArtikel daoArtikel;
    private DAOAuftragsposition auftragsposition;
    private int naechste_id;
    private int naechste_positionsnummer = 0;
    private Artikel artikel;
    private int geschaeftspartner_id;
    private int zahlungsbedingungs_id;
    private String auftragsart;
    private String geschaeftspartnername;
    private boolean abweichendeLieferadresse;
    private java.sql.Date abschlussdatum;
    private String text;
    private double auftragswert;
    private String benutzername = "";
    private int auftrags_id;
    private int positions_id;
    private int artikel_id;
    private int menge;
    private String artikelname;
    private double einzelwert_netto;
    private double sum_gesamtWert = 0;
    private java.util.Date util_lieferdatum;
    private java.util.Date aktuelles_datum_erfassung;
    private java.util.Date aktuelles_datum_abschluss;
    private ArrayList<Auftragsposition> auftragsPositionen;
    private ArrayList<Auftragsposition> geloeschte_positionen;
    private boolean bestell_auftrag;
    private boolean bar_auftrag;
    private boolean sofortauftrag;
    private boolean terminauftrag;
    private Kunde kunde;
    private Lieferant lieferant;
    private boolean abw_lieferAdresse;
    private Zahlungskondition zk;
    private DAOZahlungskondition daoZk;

    //Konstantendeklaration Citak 29.11.2016
    private final String statusErfasst = "erfasst";
    private final String statusAbgeschlossen = "Abgeschlossen";
    private final String auftragskopf_Fehlermeldung = "Fehler";
    private final String auftragsArtBar = "Barauftrag";
    private final String auftragsArtSofort = "Sofortauftrag";
    private final String auftragsArtTermin = "Terminauftrag";
    private final String auftragsArtBestellauf = "Bestellauftrag";
    private final String geschaeftsPartner_leer = "Bitte erst einen auswählen!";
    private final String position_loeschen = "Soll die ausgewählte Position wirklich gelöscht werden?";
    private final String auftragspos_exp = "Die Auftragsposition konnte nicht gelöscht werden";
    private final String gueltige_menge = " Bitte geben Sie eine gueltige Menge an";
    private Object POSITION_AUSWAHL;
    private Object POSITION_LOESCHEN;

    /**
     * Creates new form AuftragAnlegen
     */
    public AuftragAnlegen(StartAV parent) {
        initComponents();
        myParent = parent;
    /* 29.11.2016 Yoeruek Felder werden inaktiv gesetzt*/
        jtfAuftragsid_aa.setEnabled(false);
        jtfGesamtwert_AuftragAnlegen.setEnabled(false);
        jftfAbschlussdatum_AuftragAnlegen.setEnabled(false);
        jtfPositionsID_AuftragAnlegen.setEnabled(false);
        

        // Erstelle der Instanzen
        this.auftragsPositionen = new ArrayList<>();
        try {
            this.daoAuftrag = new DAOAuftrag();
            this.daoArtikel = new DAOArtikel();
        } catch (SQLException ex) {
            Logger.getLogger(AuftragAnlegen.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

     /*-------------------------------------------------------------*/
     /* 01.12.16 Yoeruek Prüfung nach Pflichtfeldern, falls nichts */ 
     /*            angegeben ist wird eine Fehlermeldung ausgegeben*/
     /*----------------------------------------------------------*/
    public boolean istVollstaendig(){
        Boolean vollstaendig = false;
        String fehlermeldung = "";
        if(jtfGPID_aa.getText().equals("")) {
            fehlermeldung = "Geben Sie bitte eine GP-ID ein!";
            jtfGPID_aa.requestFocusInWindow();
        }else if (jcbStatus.getSelectedIndex() == 0){
            fehlermeldung = "Geben Sie bitte einen Status ein!";
            jcbStatus.requestFocusInWindow();
        }else if (jftfLieferdatum_aa.getText().equals("")){
            fehlermeldung = "Geben Sie bitte ein Lieferdatum ein!";
            jftfLieferdatum_aa.requestFocusInWindow();
        } else if (jtfArtikelID_AuftragAnlegen.getText().equals("")){
            fehlermeldung = "Geben Sie bitte eine Artikel-ID ein!";
            jtfArtikelID_AuftragAnlegen.requestFocusInWindow();
        } else if (jtfMenge_AuftragAnlegen.getText().equals("")){
            fehlermeldung = "Geben Sie bitte die Menge ein!";
            jtfMenge_AuftragAnlegen.requestFocusInWindow();
        } 
        if(fehlermeldung.equals("")){
            vollstaendig = true;
        }else{
            JOptionPane.showMessageDialog(this, fehlermeldung,"Unvollständig" ,JOptionPane.WARNING_MESSAGE);
        }return vollstaendig;
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        AuftragAnlegen = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jbAbbrechen_aa = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jtfAuftragsid_aa = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jtfGPID_aa = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jcbAuftragsart = new javax.swing.JComboBox<>();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jSeparator9 = new javax.swing.JSeparator();
        jScrollPane5 = new javax.swing.JScrollPane();
        jBeschreibung_aa = new javax.swing.JTextArea();
        jLabel41 = new javax.swing.JLabel();
        jcbStatus = new javax.swing.JComboBox<>();
        jLabel73 = new javax.swing.JLabel();
        Auftragsposition_AuftragAnlegen = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jtfPositionsID_AuftragAnlegen = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jtfArtikelID_AuftragAnlegen = new javax.swing.JTextField();
        jbLupeArtikelID_AuftragAnlegen = new javax.swing.JButton();
        jLabel24 = new javax.swing.JLabel();
        jtfMenge_AuftragAnlegen = new javax.swing.JTextField();
        jLabel122 = new javax.swing.JLabel();
        jtfEinzelwert_AuftragAnlegen = new javax.swing.JTextField();
        jScrollPane8 = new javax.swing.JScrollPane();
        jTAuftragsposition = new javax.swing.JTable();
        jbMinus_AuftragAnlegen = new javax.swing.JButton();
        jbPlus_AuftragAnlegen = new javax.swing.JButton();
        javax.swing.JButton jSpeichern_aa = new javax.swing.JButton();
        jftfAbschlussdatum_AuftragAnlegen = new javax.swing.JFormattedTextField();
        jftfLieferdatum_aa = new javax.swing.JFormattedTextField();
        jftfErfassungsdatum_aa = new javax.swing.JFormattedTextField();
        jbLupeGPID_AuftragAnlegen = new javax.swing.JButton();
        jLabel123 = new javax.swing.JLabel();
        jtfGesamtwert_AuftragAnlegen = new javax.swing.JTextField();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);

        AuftragAnlegen.setPreferredSize(new java.awt.Dimension(1200, 800));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel7.setText("Auftrag anlegen");

        jbAbbrechen_aa.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jbAbbrechen_aa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/abbruch2.png"))); // NOI18N
        jbAbbrechen_aa.setText("Abbrechen");
        jbAbbrechen_aa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAbbrechen_aaActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel1.setText("Auftrags-ID:");

        jtfAuftragsid_aa.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtfAuftragsid_aa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfAuftragsid_aaActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel2.setText("Geschäftspartner ID:");

        jtfGPID_aa.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel19.setText("Auftragsart:");

        jcbAuftragsart.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "Barauftrag", "Sofortauftrag", "Terminauftrag", "Bestellauftrag" }));
        jcbAuftragsart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbAuftragsartActionPerformed(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel21.setText("Erfassungsdatum:");

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel22.setText("Lieferdatum:");

        jLabel25.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel25.setText("Beschreibung:");

        jBeschreibung_aa.setColumns(20);
        jBeschreibung_aa.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jBeschreibung_aa.setRows(5);
        jScrollPane5.setViewportView(jBeschreibung_aa);

        jLabel41.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel41.setText("Status:");

        jcbStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "Erfasst", "Freigegeben", "Abgeschlossen" }));

        jLabel73.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel73.setText("Abschlussdatum:");

        Auftragsposition_AuftragAnlegen.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Auftragspositionen", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel20.setText("Positions-ID:");

        jtfPositionsID_AuftragAnlegen.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel18.setText("Artikel-ID:");

        jtfArtikelID_AuftragAnlegen.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jbLupeArtikelID_AuftragAnlegen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/lupe.png"))); // NOI18N
        jbLupeArtikelID_AuftragAnlegen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbLupeArtikelID_AuftragAnlegenActionPerformed(evt);
            }
        });

        jLabel24.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel24.setText("Menge:");

        jtfMenge_AuftragAnlegen.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtfMenge_AuftragAnlegen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfMenge_AuftragAnlegenActionPerformed(evt);
            }
        });

        jLabel122.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel122.setText("Einzelwert:");

        jtfEinzelwert_AuftragAnlegen.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jTAuftragsposition.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane8.setViewportView(jTAuftragsposition);

        jbMinus_AuftragAnlegen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/minus2.png"))); // NOI18N
        jbMinus_AuftragAnlegen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbMinus_AuftragAnlegenActionPerformed(evt);
            }
        });

        jbPlus_AuftragAnlegen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/plus2.png"))); // NOI18N
        jbPlus_AuftragAnlegen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbPlus_AuftragAnlegenActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout Auftragsposition_AuftragAnlegenLayout = new javax.swing.GroupLayout(Auftragsposition_AuftragAnlegen);
        Auftragsposition_AuftragAnlegen.setLayout(Auftragsposition_AuftragAnlegenLayout);
        Auftragsposition_AuftragAnlegenLayout.setHorizontalGroup(
            Auftragsposition_AuftragAnlegenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Auftragsposition_AuftragAnlegenLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Auftragsposition_AuftragAnlegenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 779, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(Auftragsposition_AuftragAnlegenLayout.createSequentialGroup()
                        .addGroup(Auftragsposition_AuftragAnlegenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel18)
                            .addComponent(jLabel20))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(Auftragsposition_AuftragAnlegenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(Auftragsposition_AuftragAnlegenLayout.createSequentialGroup()
                                .addComponent(jtfArtikelID_AuftragAnlegen, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jbLupeArtikelID_AuftragAnlegen, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jtfPositionsID_AuftragAnlegen, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(81, 81, 81)
                        .addGroup(Auftragsposition_AuftragAnlegenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel122)
                            .addComponent(jLabel24))
                        .addGap(68, 68, 68)
                        .addGroup(Auftragsposition_AuftragAnlegenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtfMenge_AuftragAnlegen, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfEinzelwert_AuftragAnlegen, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(Auftragsposition_AuftragAnlegenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbMinus_AuftragAnlegen, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbPlus_AuftragAnlegen, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        Auftragsposition_AuftragAnlegenLayout.setVerticalGroup(
            Auftragsposition_AuftragAnlegenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Auftragsposition_AuftragAnlegenLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(Auftragsposition_AuftragAnlegenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Auftragsposition_AuftragAnlegenLayout.createSequentialGroup()
                        .addComponent(jbPlus_AuftragAnlegen, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbMinus_AuftragAnlegen, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Auftragsposition_AuftragAnlegenLayout.createSequentialGroup()
                        .addGroup(Auftragsposition_AuftragAnlegenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(Auftragsposition_AuftragAnlegenLayout.createSequentialGroup()
                                .addGroup(Auftragsposition_AuftragAnlegenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jtfMenge_AuftragAnlegen, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel20, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGap(18, 18, 18)
                                .addGroup(Auftragsposition_AuftragAnlegenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jtfEinzelwert_AuftragAnlegen, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(Auftragsposition_AuftragAnlegenLayout.createSequentialGroup()
                                        .addGap(5, 5, 5)
                                        .addGroup(Auftragsposition_AuftragAnlegenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel18)
                                            .addComponent(jtfArtikelID_AuftragAnlegen, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jbLupeArtikelID_AuftragAnlegen, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(Auftragsposition_AuftragAnlegenLayout.createSequentialGroup()
                                .addGroup(Auftragsposition_AuftragAnlegenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel24)
                                    .addComponent(jtfPositionsID_AuftragAnlegen, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(jLabel122)))
                        .addGap(16, 16, 16)
                        .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        jSpeichern_aa.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jSpeichern_aa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/speichern2.png"))); // NOI18N
        jSpeichern_aa.setText("Speichern");
        jSpeichern_aa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jSpeichern_aaActionPerformed(evt);
            }
        });

        jftfErfassungsdatum_aa.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jftfErfassungsdatum_aaFocusLost(evt);
            }
        });

        jbLupeGPID_AuftragAnlegen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/lupe2.png"))); // NOI18N
        jbLupeGPID_AuftragAnlegen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbLupeGPID_AuftragAnlegenActionPerformed(evt);
            }
        });

        jLabel123.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel123.setText("Gesamtwert:");

        jtfGesamtwert_AuftragAnlegen.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        javax.swing.GroupLayout AuftragAnlegenLayout = new javax.swing.GroupLayout(AuftragAnlegen);
        AuftragAnlegen.setLayout(AuftragAnlegenLayout);
        AuftragAnlegenLayout.setHorizontalGroup(
            AuftragAnlegenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AuftragAnlegenLayout.createSequentialGroup()
                .addGap(386, 386, 386)
                .addComponent(jLabel7)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(AuftragAnlegenLayout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(AuftragAnlegenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(AuftragAnlegenLayout.createSequentialGroup()
                        .addGroup(AuftragAnlegenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(AuftragAnlegenLayout.createSequentialGroup()
                                .addComponent(jSpeichern_aa, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jbAbbrechen_aa, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(Auftragsposition_AuftragAnlegen, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(AuftragAnlegenLayout.createSequentialGroup()
                        .addGroup(AuftragAnlegenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane5)
                            .addGroup(AuftragAnlegenLayout.createSequentialGroup()
                                .addGroup(AuftragAnlegenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(AuftragAnlegenLayout.createSequentialGroup()
                                        .addGroup(AuftragAnlegenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel25)
                                            .addGroup(AuftragAnlegenLayout.createSequentialGroup()
                                                .addGroup(AuftragAnlegenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel2)
                                                    .addComponent(jLabel1)
                                                    .addComponent(jLabel41))
                                                .addGap(63, 63, 63)
                                                .addGroup(AuftragAnlegenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(jtfGPID_aa, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jtfAuftragsid_aa, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jcbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jtfGesamtwert_AuftragAnlegen, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jbLupeGPID_AuftragAnlegen, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(80, 80, 80))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, AuftragAnlegenLayout.createSequentialGroup()
                                        .addComponent(jLabel123)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                .addGroup(AuftragAnlegenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel19)
                                    .addComponent(jLabel21)
                                    .addComponent(jLabel22)
                                    .addComponent(jLabel73))
                                .addGap(40, 40, 40)
                                .addGroup(AuftragAnlegenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jftfAbschlussdatum_AuftragAnlegen, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jcbAuftragsart, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jftfLieferdatum_aa, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jftfErfassungsdatum_aa, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(318, 318, 318))))
            .addComponent(jSeparator9)
        );
        AuftragAnlegenLayout.setVerticalGroup(
            AuftragAnlegenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AuftragAnlegenLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator9, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(AuftragAnlegenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jtfAuftragsid_aa, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19)
                    .addComponent(jcbAuftragsart, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(AuftragAnlegenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jtfGPID_aa, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21)
                    .addComponent(jftfErfassungsdatum_aa, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbLupeGPID_AuftragAnlegen, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(AuftragAnlegenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(jftfLieferdatum_aa, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel41)
                    .addComponent(jcbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(AuftragAnlegenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(AuftragAnlegenLayout.createSequentialGroup()
                        .addGroup(AuftragAnlegenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel73)
                            .addComponent(jftfAbschlussdatum_AuftragAnlegen, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel123))
                        .addGap(46, 46, 46)
                        .addComponent(jLabel25))
                    .addGroup(AuftragAnlegenLayout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jtfGesamtwert_AuftragAnlegen, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addComponent(Auftragsposition_AuftragAnlegen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(AuftragAnlegenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbAbbrechen_aa, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSpeichern_aa, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(44, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(AuftragAnlegen, javax.swing.GroupLayout.PREFERRED_SIZE, 950, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(AuftragAnlegen, javax.swing.GroupLayout.DEFAULT_SIZE, 866, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbAbbrechen_aaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAbbrechen_aaActionPerformed
        /*----------------------------------------------------------*/
 /* 24.11.16 Yoeruek Schließt das Fenster nach Betätigung des Abbrech Buttons */
 /*----------------------------------------------------------*/
        this.setVisible(false);
    }//GEN-LAST:event_jbAbbrechen_aaActionPerformed

    private void jtfAuftragsid_aaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfAuftragsid_aaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfAuftragsid_aaActionPerformed

    private void jcbAuftragsartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbAuftragsartActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbAuftragsartActionPerformed

    private void jtfMenge_AuftragAnlegenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfMenge_AuftragAnlegenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfMenge_AuftragAnlegenActionPerformed

 /*----------------------------------------------------------*/
 /* 18.11.2016 Citak Anlegen der Methode                     */
 /* Mit dieser Methode wird ein Auftrag angelegt             */
 /*----------------------------------------------------------*/
    private void jSpeichern_aaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jSpeichern_aaActionPerformed
     /*--------------------------------------------------------------*/
     /* 18.11.2016 Citak Die eingaben werden in der DB abgespeichert */
     /*--------------------------------------------------------------*/
        if(istVollstaendig()){
        Auftragsstatus aStatus = new Auftragsstatus();
        String auftrags_ID = "1122";
//        this.jtfArtikelID_AuftragAnlegen.getText();
        String beschreibung = this.jBeschreibung_aa.getText();
        String erfassungsdatum = this.jftfErfassungsdatum_aa.getText();
        String lieferdatum = this.jftfLieferdatum_aa.getText();
        String auftragsart = (String) this.jcbAuftragsart.getSelectedItem();
        String status = (String) this.jcbStatus.getSelectedItem();
        String abschlussDatum = this.jftfAbschlussdatum_AuftragAnlegen.getText();
        int auftragswert = 10;
        try {
            auftragswert = Integer.parseInt(this.jtfGesamtwert_AuftragAnlegen.getText());
        } catch (NumberFormatException ex) {

        }
        System.out.println("Result: " + beschreibung + erfassungsdatum);

        Auftrag auftrag = new Auftrag(auftrags_ID, beschreibung, erfassungsdatum, lieferdatum,
                auftragsart, auftragswert, aStatus.ueberfuehreAuftragsStatus(status), abschlussDatum);
        try {
            DAOAuftrag daoAuftrag = new DAOAuftrag();
            daoAuftrag.legeNeueAuftragAn(auftrag);
        } catch (SQLException ex) {
            Logger.getLogger(StartAV.class.getName()).log(Level.SEVERE, null, ex);
        }
         }


    }//GEN-LAST:event_jSpeichern_aaActionPerformed


    private void jbLupeGPID_AuftragAnlegenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbLupeGPID_AuftragAnlegenActionPerformed
        /* 29.11.16 Yoeruek Öffnet über die Lupe GP-ID Suchen */
        myParent.oeffneGPIDSuchen();
    }//GEN-LAST:event_jbLupeGPID_AuftragAnlegenActionPerformed

    private void jbLupeArtikelID_AuftragAnlegenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbLupeArtikelID_AuftragAnlegenActionPerformed
        /* 30.11.16 Yoeruek Öffnet über die Lupe Artikel-ID Suchen */
        myParent.oeffneArtikelIDSuchen();
    }//GEN-LAST:event_jbLupeArtikelID_AuftragAnlegenActionPerformed

 /*----------------------------------------------------------*/
 /* 29.12.2016 Citak Anlegen der Methode                     */
 /* Mit dieser Methode wird eine Auftragsposition angelegt   */
 /*----------------------------------------------------------*/
    private void jbPlus_AuftragAnlegenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbPlus_AuftragAnlegenActionPerformed
//        String auftragsID = jtfAuftragsid_aa.getText();
        String auftragsID = "11111";
//        int positionsNr = Integer.valueOf(jtfPositionsID_AuftragAnlegen.getText());
        int positionsNr = 2222;
        int positionsmenge = Integer.valueOf(jtfMenge_AuftragAnlegen.getText());
        int einzelwert = Integer.valueOf(jtfEinzelwert_AuftragAnlegen.getText());
        String artikelID = jtfArtikelID_AuftragAnlegen.getText();
        DefaultTableModel model = (DefaultTableModel) this.jTAuftragsposition.getModel();
        //Die entsprechenden Variablen werden gesetzt. 
        model.setValueAt(auftragsID, 0, 0);
        model.setValueAt(positionsNr, 0, 1);
        model.setValueAt(positionsmenge, 0, 2);
        model.setValueAt(einzelwert, 0, 3);
        model.setValueAt(artikelID, 0, 4);
        int index = this.jTAuftragsposition.getSelectedRow();

        //model.removeRow(0);
//         Die Daten werden aus der Tabelle geholt
        Auftragsposition auftragspos = new Auftragsposition(auftragsID, positionsNr, positionsmenge, einzelwert, artikelID);
        try {
            //Die Daten werden in die Datenbank geschrieben
            DAOAuftragsposition dAOAuftragsposition = new DAOAuftragsposition();
            System.out.println(auftragspos.toString());
            dAOAuftragsposition.legeNeueAuftragspositionAn(auftragspos);
        } catch (SQLException ex) {
            Logger.getLogger(StartAV.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jbPlus_AuftragAnlegenActionPerformed

     /*--------------------------------------------------------------------------*/
     /* 01.12.16 Citak Die Daten werden aus der Datenbank geladen und eine       */
     /*                 ausgewählt Auftragsposition wird gelöscht.               */
     /*--------------------------------------------------------------------------*/
    
    private void jbMinus_AuftragAnlegenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbMinus_AuftragAnlegenActionPerformed
       int index = -1;
        //Index wird auf die ausgewählte Zeile gesetzt.
        index = this.jTAuftragsposition.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) this.jTAuftragsposition.getModel();

        //Fehlerausgabe sobald eine Position nicht markiert wurde. 
        if (index == -1) {
            JOptionPane.showMessageDialog(null, this.POSITION_AUSWAHL, "Position nicht ausgewält", JOptionPane.INFORMATION_MESSAGE);
        } else {
            System.out.println("kopf:  " + index);
            int positionNr = (int) model.getValueAt(index, 0);
            String auftragsID = "11111";

//(String)model.getValueAt(index, 0);
            int antwort = JOptionPane.showConfirmDialog(this, this.POSITION_LOESCHEN, "Position löschen",
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (antwort == JOptionPane.YES_OPTION) {
                model.removeRow(index);

                try {
                    //Die Daten werden in die Datenbank geschrieben
                    DAOAuftragsposition dAOAuftragsposition = new DAOAuftragsposition();
                    dAOAuftragsposition.loescheNeueAuftragsposition(auftragsID, positionNr);
                } catch (SQLException ex) {
                    Logger.getLogger(StartAV.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

    }//GEN-LAST:event_jbMinus_AuftragAnlegenActionPerformed
 /*----------------------------------------------------------*/
 /* 30.12.2016 Citak Anlegen der Methode                     */
 /* Mit dieser Methode wird die Gültigkeit des Datums geprüft*/
 /*----------------------------------------------------------*/
    private void jftfErfassungsdatum_aaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jftfErfassungsdatum_aaFocusLost
        boolean istGueltig = false;
        if (!istGueltigesDatum(jftfErfassungsdatum_aa.getText())) {
            JOptionPane.showMessageDialog(this, "Bitte geben Sie ein gültiges Datum ein", "Fehler Datumsformat", JOptionPane.WARNING_MESSAGE);
            jftfErfassungsdatum_aa.requestFocusInWindow();
            //Überprüfung eines eingegebenen Datums 
        }
    }//GEN-LAST:event_jftfErfassungsdatum_aaFocusLost

  /* 30.11.16 Citak leert die Positionstabelle */
    private void position_text_leeren() {

        jtfPositionsID_AuftragAnlegen.setText("");
        jtfMenge_AuftragAnlegen.setText("");
//        jtfArtikelname_AuftragAnlegen.setText("");
        jtfArtikelID_AuftragAnlegen.setText("");
        jtfEinzelwert_AuftragAnlegen.setText("");
        jtfGesamtwert_AuftragAnlegen.setText("");
    }
    
    
     /* 30.11.16 Citak erstellen eines Datums */
    private boolean istGueltigesDatum(String datum) {
        boolean istGueltig = false;
        SimpleDateFormat df = new SimpleDateFormat("dd.MM.yyyy");
        df.setLenient(false);
        try {
            Date date = df.parse(datum);
            istGueltig = true;
        } catch (ParseException ex) {
        }
        return istGueltig;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel AuftragAnlegen;
    private javax.swing.JPanel Auftragsposition_AuftragAnlegen;
    private javax.swing.JTextArea jBeschreibung_aa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel122;
    private javax.swing.JLabel jLabel123;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JTable jTAuftragsposition;
    private javax.swing.JButton jbAbbrechen_aa;
    private javax.swing.JButton jbLupeArtikelID_AuftragAnlegen;
    private javax.swing.JButton jbLupeGPID_AuftragAnlegen;
    private javax.swing.JButton jbMinus_AuftragAnlegen;
    private javax.swing.JButton jbPlus_AuftragAnlegen;
    private javax.swing.JComboBox<String> jcbAuftragsart;
    private javax.swing.JComboBox<String> jcbStatus;
    private javax.swing.JFormattedTextField jftfAbschlussdatum_AuftragAnlegen;
    private javax.swing.JFormattedTextField jftfErfassungsdatum_aa;
    private javax.swing.JFormattedTextField jftfLieferdatum_aa;
    private javax.swing.JTextField jtfArtikelID_AuftragAnlegen;
    private javax.swing.JTextField jtfAuftragsid_aa;
    private javax.swing.JTextField jtfEinzelwert_AuftragAnlegen;
    private javax.swing.JTextField jtfGPID_aa;
    private javax.swing.JTextField jtfGesamtwert_AuftragAnlegen;
    private javax.swing.JTextField jtfMenge_AuftragAnlegen;
    private javax.swing.JTextField jtfPositionsID_AuftragAnlegen;
    // End of variables declaration//GEN-END:variables

}
