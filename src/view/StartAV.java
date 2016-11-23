/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import dao.DAOAuftrag;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.SQLException;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import javax.swing.text.PlainDocument;
import model.Auftrag;
import model.Auftragsstatus;

/**
 *
 * Ersterstellung 20161111 @author Mechmet Impram, Hicran Yörük Erstellung der
 * GP-Masken 20161116 @author Duygu Citak
 *
 *
 */
//laaalaaaa
public class StartAV extends javax.swing.JFrame {

    //Hicran passt die Rahmengröße des Fensters an.
//    @Override
//    public void setBounds(int x, int y, int width, int height) {
//        super.setBounds(x, y, 1200, 800); //To change body of generated methods, choose Tools | Templates.
//    }
    

    
    
    private final String ABMELDE_TITEL = "ABMELDEN";
    private final String ABMELDE_TEXT = "Möchten Sie wirklich abmelden";
    boolean istEingeloggt = false;
    /**
     * Creates new form StartAV
     */
    private static class sindZErlaubt {

        public sindZErlaubt() {
        }
    }

    private static class sindBErlaubt {

        public sindBErlaubt() {
        }
    }
    // Mechmet Impram
    class UniversalDokument extends PlainDocument {

        private int laenge;
        private String erlaubteZeichen;

        // Mechmet Impram
        public UniversalDokument(boolean sindBErlaubt, boolean sindZErlaubt, String zeichen, int laenge) {
            this.laenge = laenge;
            this.erlaubteZeichen = zeichen;
            if (sindBErlaubt) {
                this.erlaubteZeichen = this.erlaubteZeichen + "wertzuiopüasdfghjklöäyxcvbnm" + "QWERTZUIOPÜASDFGHJKLÖÄYXCVBNM";

            }
            if (sindZErlaubt) {
                this.erlaubteZeichen = this.erlaubteZeichen + "1234567890";
            }
        }

        // Mechmet Impram
        public void insertString(int off, String str, AttributeSet a)
                throws BadLocationException {
            boolean insertString;
            boolean founded = true;
            for (int i = 0; i < str.length() && founded; i++) {
                if (this.erlaubteZeichen.indexOf(str.charAt(i)) == -1) {
                    Toolkit.getDefaultToolkit().beep();
                    founded = false;
                }
            }
            insertString = founded;
            if (this.laenge != -1 && insertString && this.getLength() <= this.laenge) {
                super.insertString(off, str, a);
            } else if (insertString && laenge == -1) {
                super.insertString(off, str, a);
            } else {
                Toolkit.getDefaultToolkit().beep();
            }

        }
    }

    // Mechmet Impram
    class UniversalVerifier extends InputVerifier {

        private String regEx;
        private String titel;
        private String text;

        public UniversalVerifier(String regEx, String Titel, String text) {
            this.regEx = regEx;
            this.text = text;
            this.titel = titel;
        }

        public boolean verify(JComponent input) {
            boolean istGueltig = false;
            if (((JTextField) (input)).getText().matches(regEx)
                    || ((JTextField) input).getText().equals("")) {
                istGueltig = true;
            }
            return istGueltig;
        }

        // Mechmet Impram
        public boolean shouldYieldFocus(JComponent input) {
            boolean yieldFocus = false;
            if (verify(input)) {
                yieldFocus = true;
            } else {
                JOptionPane.showMessageDialog(null, text, titel, JOptionPane.WARNING_MESSAGE);
                ((JTextField) (input)).selectAll();
            }
            return yieldFocus;
        }

    }

    // Mechmet Impram
    private DefaultFormatterFactory erstelleMF(String schablone) {
        DefaultFormatterFactory dffmf = null;
        MaskFormatter mf = null;
        try {
            mf = new MaskFormatter(schablone);
            mf.setOverwriteMode(true);
            mf.setAllowsInvalid(false);
            mf.setCommitsOnValidEdit(true);
            mf.setValueContainsLiteralCharacters(false);
            dffmf = new DefaultFormatterFactory(mf);
        } catch (ParseException ex) {
        }
        return dffmf;
    }

    public StartAV() {

        initComponents();
//        this.jRegister.setVisible(false);
        //Startseite
        // Mechmet Impram
//Benutzername Feld akzeptiert nur Buchstaben.
        jtfBenutzername_Startseite.setDocument(new UniversalDokument(true, false, "-. ' ", -1));
        // Mechmet Impram
//Passwort Feld ebenso akzeptiert nur Buchstaben.        
        jpwpasswort_Startseite.setDocument((new UniversalDokument(true, false, "-. ' ", -1)));
        // Mechmet Impram
        //Artikelanzeigen
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
       // Mechmet Impram
        //Artikelanlegen
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
// Mechmet Impram        
//AuftragSuchen
        jtfAuftragsID_AuftragSuchen.setDocument(new UniversalDokument(false, true, "", 5));
        jtfKundenName_AuftragSuchen.setDocument(new UniversalDokument(true, false, ".-' ", -1));
        jtfLieferantenname_AuftragSuche.setDocument(new UniversalDokument(true, false, ".-' ", -1));
        jftfLieferdatum_AuftragSuche.setFormatterFactory(erstelleMF("##.##.####"));
        jftfErfassungsdatum_AuftragSuche.setFormatterFactory(erstelleMF("##.##.####"));
        jtfMinAuftragswert_AuftragSuche.setDocument(new UniversalDokument(false, true, DecimalFormatSymbols.getInstance().getDecimalSeparator() + "", -1));
        jtfMinAuftragswert_AuftragSuche.setInputVerifier(new UniversalVerifier("\\d+(\\" + DecimalFormatSymbols.getInstance().getDecimalSeparator() + "\\d\\d)?", "ungultiges format", "Bitte geben sie ein Preis mit 2 Nachkommastellen oder eine ganze Zahl"));
     jtfMaxAuftragswert_AuftragSuche.setDocument(new UniversalDokument(false, true, DecimalFormatSymbols.getInstance().getDecimalSeparator() + "", -1));
        jtfMaxAuftragswert_AuftragSuche.setInputVerifier(new UniversalVerifier("\\d+(\\" + DecimalFormatSymbols.getInstance().getDecimalSeparator() + "\\d\\d)?", "ungultiges format", "Bitte geben sie ein Preis mit 2 Nachkommastellen oder eine ganze Zahl"));
       // Mechmet Impram
        //ArtikelBearbeiten
        jtfartikelid_ArtikelBearbeiten.setDocument(new UniversalDokument(false, true, "", 5));
        

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup1 = new javax.swing.ButtonGroup();
        desktopPane = new javax.swing.JDesktopPane();
        Startseite = new javax.swing.JPanel();
        jtfBenutzername_Startseite = new javax.swing.JTextField();
        jpwpasswort_Startseite = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jbanmelden_Startseite = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JSeparator();
        SeiteZwei = new javax.swing.JPanel();
        jifAuftragAnzeigen = new javax.swing.JInternalFrame();
        AuftragAnzeigen = new javax.swing.JPanel();
        jlAuftragsid = new javax.swing.JLabel();
        jtfAuftragsid_az = new javax.swing.JTextField();
        jlGPNr = new javax.swing.JLabel();
        jtfGPID_az = new javax.swing.JTextField();
        jlAuftragsart = new javax.swing.JLabel();
        jcbAuftragsart_az = new javax.swing.JComboBox<String>();
        jlGPName = new javax.swing.JLabel();
        jtfGPName_az = new javax.swing.JTextField();
        jlErfassungsdatum = new javax.swing.JLabel();
        jftfErfassungsdatum_az = new javax.swing.JFormattedTextField();
        jlLieferdatum = new javax.swing.JLabel();
        jftfLieferdatum_az = new javax.swing.JFormattedTextField();
        jbSpeichern_az = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jbBearbeiten_az = new javax.swing.JButton();
        jbZurueck_az = new javax.swing.JButton();
        titel_az = new javax.swing.JLabel();
        jlGPadresse_az = new javax.swing.JLabel();
        jtfGPadresse_az = new javax.swing.JTextField();
        jlZKID = new javax.swing.JLabel();
        jtfZKID_az = new javax.swing.JTextField();
        jlStatus = new javax.swing.JLabel();
        jcbStatus_az = new javax.swing.JComboBox<String>();
        jlAbschlussdatum = new javax.swing.JLabel();
        jtfAbschlussdatum_az = new javax.swing.JTextField();
        jlBeschreibung = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtaBeschreibung_az = new javax.swing.JTextArea();
        jlAuftragswertbrutto_az = new javax.swing.JLabel();
        jtfAuftragswertbrutto_az = new javax.swing.JTextField();
        jlAuftragswertnetto_az = new javax.swing.JLabel();
        jtfAuftragswertnetto_az = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        jifAuftragAnlegen = new javax.swing.JInternalFrame();
        AuftragAnlegen = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jbAbbrechen_aa = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jtfAuftragsid_aa = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jtfGPID_aa = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jtfGPname_aa = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jcbAuftragsart = new javax.swing.JComboBox<String>();
        jLabel21 = new javax.swing.JLabel();
        jtfErfassungsdatum_aa = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jtfLieferdatum_aa = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jSeparator9 = new javax.swing.JSeparator();
        jScrollPane5 = new javax.swing.JScrollPane();
        jBeschreibung_aa = new javax.swing.JTextArea();
        jLabel41 = new javax.swing.JLabel();
        jcbStatus = new javax.swing.JComboBox<String>();
        jLabel73 = new javax.swing.JLabel();
        jtfAbschlussdatum_aa = new javax.swing.JTextField();
        Auftragsposition_AuftragAnlegen = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jtfPositionsID_AuftragAnlegen = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jtfArtikelID_AuftragAnlegen = new javax.swing.JTextField();
        jbLupe_AuftragAnlegen = new javax.swing.JButton();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jtfArtikelname_AuftragAnlegen = new javax.swing.JTextField();
        jtfMenge_AuftragAnlegen = new javax.swing.JTextField();
        jLabel122 = new javax.swing.JLabel();
        jLabel123 = new javax.swing.JLabel();
        jtfEinzelwert_AuftragAnlegen = new javax.swing.JTextField();
        jtfGesamtwert_AuftragAnlegen = new javax.swing.JTextField();
        jScrollPane8 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jbMinus_AuftragAnlegen = new javax.swing.JButton();
        jbPlus_AuftragAnlegen = new javax.swing.JButton();
        javax.swing.JButton jSpeichern_aa = new javax.swing.JButton();
        jifAuftragBearbeiten = new javax.swing.JInternalFrame();
        AuftragBearbeiten = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jbAbbrechen_AuftragBearbeiten = new javax.swing.JButton();
        jSeparator10 = new javax.swing.JSeparator();
        jbBearbeiten_AuftragBearbeiten = new javax.swing.JButton();
        jLabel87 = new javax.swing.JLabel();
        jtfAuftragsID_AuftragBearbeiten = new javax.swing.JTextField();
        jifAuftragSuchen = new javax.swing.JInternalFrame();
        AuftragSuchen = new javax.swing.JPanel();
        titel_as = new javax.swing.JLabel();
        jlAuftragsnr_as = new javax.swing.JLabel();
        jtfAuftragsID_AuftragSuchen = new javax.swing.JTextField();
        jbZurueck_AutragSuchen = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel26 = new javax.swing.JLabel();
        jcbSuchkriterium_AuftragSuchen = new javax.swing.JComboBox();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jtfKundenName_AuftragSuchen = new javax.swing.JTextField();
        jtfLieferantenname_AuftragSuche = new javax.swing.JTextField();
        jftfLieferdatum_AuftragSuche = new javax.swing.JFormattedTextField();
        jftfErfassungsdatum_AuftragSuche = new javax.swing.JFormattedTextField();
        jLabel31 = new javax.swing.JLabel();
        jtfMinAuftragswert_AuftragSuche = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jcbStatusArt_AuftragSuche = new javax.swing.JComboBox();
        jcbStatus_AuftragSuche = new javax.swing.JComboBox();
        jLabel34 = new javax.swing.JLabel();
        jtfMaxAuftragswert_AuftragSuche = new javax.swing.JTextField();
        jbSuchen_AuftragSuchen = new javax.swing.JButton();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jtTabelle_AuftragSuche = new javax.swing.JTable();
        jbAnzeigen_AuftragSuchen = new javax.swing.JButton();
        jifAuftragsID_suchen = new javax.swing.JInternalFrame();
        AuftragsID_suchen = new javax.swing.JPanel();
        jLabel88 = new javax.swing.JLabel();
        jSeparator23 = new javax.swing.JSeparator();
        jLabel89 = new javax.swing.JLabel();
        jtfKundenname_AuftragsIDSuchen = new javax.swing.JTextField();
        jLabel90 = new javax.swing.JLabel();
        jtfLieferantenname_AuftragsIDSuchen = new javax.swing.JTextField();
        jcbDatumAuftragsIDSuchen = new javax.swing.JComboBox<String>();
        jtfDatum_AuftragsIDSuchen = new javax.swing.JTextField();
        jLabel91 = new javax.swing.JLabel();
        jcbStatus_AuftragsIDSuchen = new javax.swing.JComboBox<String>();
        jbAbbrechen_AuftragsIDSuchen = new javax.swing.JButton();
        jbSuchen_AuftragsIDSuchen = new javax.swing.JButton();
        jifArtikelAnzeige = new javax.swing.JInternalFrame();
        ArtikelAnzeige = new javax.swing.JPanel();
        jLabel53 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        jtfbestellwertnetto_ArtikelAnzeigen = new javax.swing.JTextField();
        jLabel51 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jtfbestelltext_ArtikelAnzeigen = new javax.swing.JTextField();
        jtfartikeltext_ArtikelAnzeigen = new javax.swing.JTextField();
        jLabel49 = new javax.swing.JLabel();
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
        jifArtikelAnlegen = new javax.swing.JInternalFrame();
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
        jifArtikelBearbeiten = new javax.swing.JInternalFrame();
        ArtikelBearbeiten = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jtfartikelid_ArtikelBearbeiten = new javax.swing.JTextField();
        jbBearbeiten_ArtikelBearbeiten = new javax.swing.JButton();
        jbAbbrechen_ArtikelBearbeiten = new javax.swing.JButton();
        jLabel40 = new javax.swing.JLabel();
        jSeparator8 = new javax.swing.JSeparator();
        jifArtikelSuche = new javax.swing.JInternalFrame();
        ArtikelSuche = new javax.swing.JPanel();
        jLabel57 = new javax.swing.JLabel();
        jbAnzeigen_ArtikelSuche = new javax.swing.JButton();
        jbSuchen_ArtikelSuche = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jt_ArtikelSuche = new javax.swing.JTable();
        jbAbbrechen_ArtikelSuche = new javax.swing.JButton();
        jLabel38 = new javax.swing.JLabel();
        jSeparator7 = new javax.swing.JSeparator();
        jcbArtikelID_ArtikelSuche = new javax.swing.JComboBox();
        jifLieferantAnzeigen = new javax.swing.JInternalFrame();
        LieferantAnzeigen = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jbzurueck_LieferantAnzeigen = new javax.swing.JButton();
        jSeparator16 = new javax.swing.JSeparator();
        jifLieferantAnlegen = new javax.swing.JInternalFrame();
        LieferantAnlegen = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jbAbbrechen_LieferantAnlegen = new javax.swing.JButton();
        jSeparator17 = new javax.swing.JSeparator();
        jbSpeichern_LieferantAnlegen = new javax.swing.JButton();
        jLabel74 = new javax.swing.JLabel();
        jtfGPID_LieferantAnlegen = new javax.swing.JTextField();
        jLabel75 = new javax.swing.JLabel();
        jtfKreditlimit_LieferantAnlegen = new javax.swing.JTextField();
        Rechnungsdaten_LieferantAnlegen = new javax.swing.JPanel();
        jLabel130 = new javax.swing.JLabel();
        jcbAnredeRG_LieferantAnlegen = new javax.swing.JComboBox<String>();
        jLabel131 = new javax.swing.JLabel();
        jLabel132 = new javax.swing.JLabel();
        jtfNameRG_LieferantAnlegen = new javax.swing.JTextField();
        jtfVornameRG_LieferantAnlegen = new javax.swing.JTextField();
        jLabel133 = new javax.swing.JLabel();
        jtfFirmaRG_LieferantAnlegen = new javax.swing.JTextField();
        jLabel134 = new javax.swing.JLabel();
        jtfStraßeRG_LieferantAnlegen = new javax.swing.JTextField();
        jtfHNrRG_LieferantAnlegen = new javax.swing.JTextField();
        jLabel135 = new javax.swing.JLabel();
        jtfPlzRG_LieferantAnlegen = new javax.swing.JTextField();
        jtfOrtRG_LieferantAnlegen = new javax.swing.JTextField();
        jLabel136 = new javax.swing.JLabel();
        jtfStaatRG_LieferantAnlegen = new javax.swing.JTextField();
        Lieferdaten_LieferantAnlegen = new javax.swing.JPanel();
        jLabel140 = new javax.swing.JLabel();
        jLabel141 = new javax.swing.JLabel();
        jLabel142 = new javax.swing.JLabel();
        jLabel143 = new javax.swing.JLabel();
        jLabel144 = new javax.swing.JLabel();
        jLabel145 = new javax.swing.JLabel();
        jLabel146 = new javax.swing.JLabel();
        jtfStaat2_LieferantAnlegen = new javax.swing.JTextField();
        jcbAnrede2_LieferantAnlegen = new javax.swing.JComboBox<String>();
        jtfName2_LieferantAnlegen = new javax.swing.JTextField();
        jtfVorname2_LieferantAnlegen = new javax.swing.JTextField();
        jtfStraße2_LieferantAnlegen = new javax.swing.JTextField();
        jtfFirma2_LieferantAnlegen = new javax.swing.JTextField();
        jtfHNr2_LieferantAnlegen = new javax.swing.JTextField();
        jtfPlz2_LieferantAnlegen = new javax.swing.JTextField();
        jtfOrt2_LieferantAnlegen = new javax.swing.JTextField();
        jrbLieferadresseidentisch_LieferantAnlegen = new javax.swing.JRadioButton();
        jrbabweichendeLieferadresse_LieferantAnlegen = new javax.swing.JRadioButton();
        Kontakt_LieferantAnlegen = new javax.swing.JPanel();
        jLabel137 = new javax.swing.JLabel();
        jLabel138 = new javax.swing.JLabel();
        jLabel139 = new javax.swing.JLabel();
        jtfTel_LieferantAnlegen = new javax.swing.JTextField();
        jtfFax_LieferantAnlegen = new javax.swing.JTextField();
        jtfEmail_LieferantAnlegen = new javax.swing.JTextField();
        jifLieferantBearbeiten = new javax.swing.JInternalFrame();
        LieferantBearbeiten = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jbzurueck_LieferantBearbeiten = new javax.swing.JButton();
        jSeparator18 = new javax.swing.JSeparator();
        jifLieferantSuchen = new javax.swing.JInternalFrame();
        LieferantSuchen = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jbAbbrechen_LieferantSuchen = new javax.swing.JButton();
        jSeparator14 = new javax.swing.JSeparator();
        jbAnzeigen_LieferantSuchen = new javax.swing.JButton();
        jcbSuchkriterium_LieferantSuchen = new javax.swing.JComboBox<String>();
        jtfSuchkriterium_LieferantSuchen = new javax.swing.JTextField();
        jScrollPane7 = new javax.swing.JScrollPane();
        jt_LieferantSuchen = new javax.swing.JTable();
        jifKundeAnzeigen = new javax.swing.JInternalFrame();
        KundeAnzeigen = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        zurueck_KundeAnzeigen = new javax.swing.JButton();
        jSeparator19 = new javax.swing.JSeparator();
        jifKundeAnlegen = new javax.swing.JInternalFrame();
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
        jcbAnredeRG_KundeAnlegen = new javax.swing.JComboBox<String>();
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
        jComboBox1 = new javax.swing.JComboBox<String>();
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
        jifKundeBearbeiten = new javax.swing.JInternalFrame();
        KundeBearbeiten = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        zurueck_KundeBearbeiten = new javax.swing.JButton();
        jSeparator21 = new javax.swing.JSeparator();
        jifKundeSuchen = new javax.swing.JInternalFrame();
        KundeSuchen = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jbAbbrechen_KundeSuchen = new javax.swing.JButton();
        jSeparator15 = new javax.swing.JSeparator();
        jcbSuchkriterium_KundeSuchen = new javax.swing.JComboBox<String>();
        jtfSuchkriterium_KundeSuchen = new javax.swing.JTextField();
        jbSuchen_KundeSuchen = new javax.swing.JButton();
        jbAnzeigen_KundeSuchen = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        jt_KundeSuchen = new javax.swing.JTable();
        jifZKAnzeigen = new javax.swing.JInternalFrame();
        ZKAnzeigen = new javax.swing.JPanel();
        jLabel77 = new javax.swing.JLabel();
        jbAbbrechen_ZKAnzeigen = new javax.swing.JButton();
        jbBearbeiten_ZKAnzeigen = new javax.swing.JButton();
        jSeparator28 = new javax.swing.JSeparator();
        jbSpeichern_ZKAnzeigen = new javax.swing.JButton();
        jLabel81 = new javax.swing.JLabel();
        jtfZKID_ZKAnzeigen = new javax.swing.JTextField();
        jLabel82 = new javax.swing.JLabel();
        jcbAuftragsart_ZKAnzeigen = new javax.swing.JComboBox<String>();
        jLabel83 = new javax.swing.JLabel();
        jtfLieferzeitSofort_ZKAnzeigen = new javax.swing.JTextField();
        jLabel84 = new javax.swing.JLabel();
        jtfSperrzeitWunsch_ZKAnzeigen = new javax.swing.JTextField();
        Skonto_ZKAnzeigen = new javax.swing.JPanel();
        jLabel85 = new javax.swing.JLabel();
        jLabel86 = new javax.swing.JLabel();
        jLabel92 = new javax.swing.JLabel();
        jLabel93 = new javax.swing.JLabel();
        jSeparator24 = new javax.swing.JSeparator();
        jtfSkontofrist1_ZKAnzeigen = new javax.swing.JTextField();
        jtfSkontofrist2_ZKAnzeigen = new javax.swing.JTextField();
        jtfSkontosatz1_ZKAnzeigen = new javax.swing.JTextField();
        jtfSkontosatz2_ZKAnzeigen = new javax.swing.JTextField();
        jLabel112 = new javax.swing.JLabel();
        jLabel113 = new javax.swing.JLabel();
        jLabel114 = new javax.swing.JLabel();
        jLabel115 = new javax.swing.JLabel();
        Mahnzeit_ZKAnzeigen = new javax.swing.JPanel();
        jLabel94 = new javax.swing.JLabel();
        jLabel95 = new javax.swing.JLabel();
        jLabel96 = new javax.swing.JLabel();
        jtfMahnzeit2_ZKAnzeigen = new javax.swing.JTextField();
        jtfMahnzeit3_ZKAnzeigen = new javax.swing.JTextField();
        jtfMahnzeit1_ZKAnzeigen = new javax.swing.JTextField();
        jLabel116 = new javax.swing.JLabel();
        jLabel117 = new javax.swing.JLabel();
        jLabel118 = new javax.swing.JLabel();
        jbLupe_ZKAnzeigen = new javax.swing.JButton();
        jifZKAnlegen = new javax.swing.JInternalFrame();
        ZKAnlegen = new javax.swing.JPanel();
        jLabel78 = new javax.swing.JLabel();
        jSeparator25 = new javax.swing.JSeparator();
        jbAbbrechen_ZKAnlegen = new javax.swing.JButton();
        jbSpeichern_ZKAnlegen = new javax.swing.JButton();
        jLabel97 = new javax.swing.JLabel();
        jtfZKID_ZKAnlegen = new javax.swing.JTextField();
        jLabel98 = new javax.swing.JLabel();
        jtfAuftragsart_ZKAnlegen = new javax.swing.JTextField();
        jLabel99 = new javax.swing.JLabel();
        jtfLieferzeitSofort_ZKAnlegen = new javax.swing.JTextField();
        jLabel100 = new javax.swing.JLabel();
        jtfSperrzeitWunsch_ZKAnlegen = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel101 = new javax.swing.JLabel();
        jLabel102 = new javax.swing.JLabel();
        jLabel103 = new javax.swing.JLabel();
        jtfSkontofrist1_ZKAnlegen = new javax.swing.JTextField();
        jtfSkontofrist2_ZKAnlegen = new javax.swing.JTextField();
        jtfSkontosatz1_ZKAnlegen = new javax.swing.JTextField();
        jLabel104 = new javax.swing.JLabel();
        jtfSkontosatz2_ZKAnlegen = new javax.swing.JTextField();
        jLabel108 = new javax.swing.JLabel();
        jLabel109 = new javax.swing.JLabel();
        jLabel110 = new javax.swing.JLabel();
        jLabel111 = new javax.swing.JLabel();
        jSeparator29 = new javax.swing.JSeparator();
        jPanel2 = new javax.swing.JPanel();
        jLabel105 = new javax.swing.JLabel();
        jLabel106 = new javax.swing.JLabel();
        jLabel107 = new javax.swing.JLabel();
        jtfMahnzeit1_ZKAnlegen = new javax.swing.JTextField();
        jtfMahnzeit2_ZKAnlegen = new javax.swing.JTextField();
        jtfMahnzeit3_ZKAnlegen = new javax.swing.JTextField();
        jLabel119 = new javax.swing.JLabel();
        jLabel120 = new javax.swing.JLabel();
        jLabel121 = new javax.swing.JLabel();
        jifZKBearbeiten = new javax.swing.JInternalFrame();
        ZKBearbeiten = new javax.swing.JPanel();
        jLabel76 = new javax.swing.JLabel();
        jSeparator22 = new javax.swing.JSeparator();
        jbAbbrechen_ZKBearbeiten = new javax.swing.JButton();
        jbBearbeiten_ZKBearbeiten = new javax.swing.JButton();
        jLabel124 = new javax.swing.JLabel();
        jtfZKID_ZKBearbeiten = new javax.swing.JTextField();
        jifZKSuchen = new javax.swing.JInternalFrame();
        ZKSuchen = new javax.swing.JPanel();
        jbAbbrechen_ZKSuchen = new javax.swing.JButton();
        jbAnzeigen_ZKSuchen = new javax.swing.JButton();
        jbSuchen_ZKSuchen = new javax.swing.JButton();
        jLabel79 = new javax.swing.JLabel();
        jSeparator26 = new javax.swing.JSeparator();
        jLabel125 = new javax.swing.JLabel();
        jcbSuchkriterium_ZKSuchen = new javax.swing.JComboBox<String>();
        jcbAuftragsart_ZKSuchen = new javax.swing.JComboBox<String>();
        jtfSuchkriterium_ZKSuchen = new javax.swing.JTextField();
        jScrollPane9 = new javax.swing.JScrollPane();
        jt_ZKSuchen = new javax.swing.JTable();
        jifZKID_suchen = new javax.swing.JInternalFrame();
        ZKID_suchen = new javax.swing.JPanel();
        jLabel80 = new javax.swing.JLabel();
        jSeparator27 = new javax.swing.JSeparator();
        jbAbbrechen_ZKIDSuchen = new javax.swing.JButton();
        jbAnzeigen_ZKIDSuchen = new javax.swing.JButton();
        jLabel126 = new javax.swing.JLabel();
        jLabel127 = new javax.swing.JLabel();
        jtfLieferzeitSofort_ZKIDSuchen = new javax.swing.JTextField();
        jtfLieferzeitWunsch_ZKIDSuchen = new javax.swing.JTextField();
        jLabel128 = new javax.swing.JLabel();
        jLabel129 = new javax.swing.JLabel();
        jtfSkontozeit1_ZKIDSuchen = new javax.swing.JTextField();
        jtfMahnzeit1_ZKIDSuchen = new javax.swing.JTextField();
        menuBar = new javax.swing.JMenuBar();
        jmDatei = new javax.swing.JMenu();
        miAbmelden = new javax.swing.JMenuItem();
        miBeenden = new javax.swing.JMenuItem();
        jmAuftrag = new javax.swing.JMenu();
        miAuftraganzeigen = new javax.swing.JMenuItem();
        miAuftraganlegen = new javax.swing.JMenuItem();
        miAuftragbearbeiten = new javax.swing.JMenuItem();
        jmArtikel = new javax.swing.JMenu();
        miArtikelanzeigen = new javax.swing.JMenuItem();
        miArtikelanlegen = new javax.swing.JMenuItem();
        miArtikelbearbeiten = new javax.swing.JMenuItem();
        jmSuche = new javax.swing.JMenu();
        miAuftragSuche = new javax.swing.JMenuItem();
        miArtikelSuche = new javax.swing.JMenuItem();
        miLieferantSuche = new javax.swing.JMenuItem();
        miKundeSuche = new javax.swing.JMenuItem();
        miZKSuche = new javax.swing.JMenuItem();
        jmGeschäftspartner = new javax.swing.JMenu();
        jmLieferant = new javax.swing.JMenu();
        miLieferantanzeigen = new javax.swing.JMenuItem();
        miLieferantanlegen = new javax.swing.JMenuItem();
        miLieferantbearbeiten = new javax.swing.JMenuItem();
        jmKunde = new javax.swing.JMenu();
        miKundeanzeigen = new javax.swing.JMenuItem();
        miKundeanlegen = new javax.swing.JMenuItem();
        miKundebearbeiten = new javax.swing.JMenuItem();
        jmZahlungskondition = new javax.swing.JMenu();
        miZKAnzeigen = new javax.swing.JMenuItem();
        miZKAnlegen = new javax.swing.JMenuItem();
        miZKBearbeiten = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImages(null);
        setMinimumSize(new java.awt.Dimension(1400, 1000));
        setPreferredSize(new java.awt.Dimension(1200, 1000));

        desktopPane.setInheritsPopupMenu(true);

        Startseite.setMaximumSize(new java.awt.Dimension(2147483647, 2147483647));
        Startseite.setMinimumSize(new java.awt.Dimension(1400, 1000));
        Startseite.setPreferredSize(new java.awt.Dimension(1200, 800));
        Startseite.setRequestFocusEnabled(false);

        jpwpasswort_Startseite.setText("jPasswordField1");

        jLabel3.setText("Passwort");

        jLabel4.setText("Benutzername");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel6.setText("Willkommen");

        jbanmelden_Startseite.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/anmelden.png"))); // NOI18N
        jbanmelden_Startseite.setText("Anmelden");
        jbanmelden_Startseite.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbanmelden_StartseiteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout StartseiteLayout = new javax.swing.GroupLayout(Startseite);
        Startseite.setLayout(StartseiteLayout);
        StartseiteLayout.setHorizontalGroup(
            StartseiteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(StartseiteLayout.createSequentialGroup()
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 1175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 825, Short.MAX_VALUE))
            .addGroup(StartseiteLayout.createSequentialGroup()
                .addGroup(StartseiteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(StartseiteLayout.createSequentialGroup()
                        .addGap(434, 434, 434)
                        .addComponent(jLabel6))
                    .addGroup(StartseiteLayout.createSequentialGroup()
                        .addGap(357, 357, 357)
                        .addGroup(StartseiteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3))
                        .addGap(72, 72, 72)
                        .addGroup(StartseiteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(StartseiteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jbanmelden_Startseite, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jtfBenutzername_Startseite, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jpwpasswort_Startseite, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        StartseiteLayout.setVerticalGroup(
            StartseiteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(StartseiteLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(StartseiteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jtfBenutzername_Startseite, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(StartseiteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jpwpasswort_Startseite, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jbanmelden_Startseite)
                .addContainerGap(888, Short.MAX_VALUE))
        );

        desktopPane.add(Startseite);
        Startseite.setBounds(0, 0, 1200, 800);

        SeiteZwei.setPreferredSize(new java.awt.Dimension(2000, 1100));

        javax.swing.GroupLayout SeiteZweiLayout = new javax.swing.GroupLayout(SeiteZwei);
        SeiteZwei.setLayout(SeiteZweiLayout);
        SeiteZweiLayout.setHorizontalGroup(
            SeiteZweiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2000, Short.MAX_VALUE)
        );
        SeiteZweiLayout.setVerticalGroup(
            SeiteZweiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1100, Short.MAX_VALUE)
        );

        desktopPane.add(SeiteZwei);
        SeiteZwei.setBounds(0, 0, 2000, 1100);

        jifAuftragAnzeigen.setClosable(true);
        jifAuftragAnzeigen.setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        jifAuftragAnzeigen.setNormalBounds(new java.awt.Rectangle(0, 0, 41, 40));
        jifAuftragAnzeigen.setOpaque(true);
        jifAuftragAnzeigen.setPreferredSize(new java.awt.Dimension(1016, 892));
        jifAuftragAnzeigen.setVisible(false);

        AuftragAnzeigen.setPreferredSize(new java.awt.Dimension(1200, 800));

        jlAuftragsid.setText("Auftrags-Nr:");

        jlGPNr.setText("Geschäftspartner-ID:");

        jtfGPID_az.setToolTipText("");
        jtfGPID_az.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfGPID_azActionPerformed(evt);
            }
        });

        jlAuftragsart.setText("Auftragsart:");

        jcbAuftragsart_az.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "", "Barauftrag", "Sofortauftrag", "Terminauftrag", "Bestellauftrag" }));
        jcbAuftragsart_az.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbAuftragsart_azActionPerformed(evt);
            }
        });

        jlGPName.setText("Geschäftspartner-Name:");

        jlErfassungsdatum.setText("Erfassungsdatum:");

        jlLieferdatum.setText("Lieferdatum:");

        jftfLieferdatum_az.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jftfLieferdatum_azActionPerformed(evt);
            }
        });

        jbSpeichern_az.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/speichern2.png"))); // NOI18N
        jbSpeichern_az.setText("Speichern");
        jbSpeichern_az.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSpeichern_azActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Auftrags-Nr.", "Auftragsart", "GP-Nr.", "GP-Name", "Erfassungsdatum", "Lieferdatum", "Bestellwert"
            }
        ));
        jTable1.setAutoscrolls(false);
        jScrollPane1.setViewportView(jTable1);

        jbBearbeiten_az.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/bearbeiten1.png"))); // NOI18N
        jbBearbeiten_az.setText("Bearbeiten");
        jbBearbeiten_az.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBearbeiten_azActionPerformed(evt);
            }
        });

        jbZurueck_az.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/zurück.png"))); // NOI18N
        jbZurueck_az.setText("Zurück");
        jbZurueck_az.setToolTipText("");
        jbZurueck_az.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbZurueck_azActionPerformed(evt);
            }
        });

        titel_az.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        titel_az.setText("Auftrag anzeigen");

        jlGPadresse_az.setText("Geschäftspartner Adresse:");

        jlZKID.setText("Zahlungskondition-ID");

        jtfZKID_az.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfZKID_azActionPerformed(evt);
            }
        });

        jlStatus.setText("Status");

        jcbStatus_az.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "", "erfasst", "freigegeben", "abgeschlossen" }));

        jlAbschlussdatum.setText("Abschlussdatum:");

        jtfAbschlussdatum_az.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfAbschlussdatum_azActionPerformed(evt);
            }
        });

        jlBeschreibung.setText("Beschreibung:");

        jtaBeschreibung_az.setColumns(20);
        jtaBeschreibung_az.setRows(5);
        jScrollPane2.setViewportView(jtaBeschreibung_az);

        jlAuftragswertbrutto_az.setText("Auftragswert(brutto)");

        jlAuftragswertnetto_az.setText("Auftragswert (netto)");

        javax.swing.GroupLayout AuftragAnzeigenLayout = new javax.swing.GroupLayout(AuftragAnzeigen);
        AuftragAnzeigen.setLayout(AuftragAnzeigenLayout);
        AuftragAnzeigenLayout.setHorizontalGroup(
            AuftragAnzeigenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AuftragAnzeigenLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(AuftragAnzeigenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator2)
                    .addGroup(AuftragAnzeigenLayout.createSequentialGroup()
                        .addGroup(AuftragAnzeigenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(AuftragAnzeigenLayout.createSequentialGroup()
                                .addGroup(AuftragAnzeigenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jlAuftragsid)
                                    .addComponent(jlGPNr)
                                    .addComponent(jlAuftragswertbrutto_az)
                                    .addComponent(jlAuftragswertnetto_az))
                                .addGroup(AuftragAnzeigenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(AuftragAnzeigenLayout.createSequentialGroup()
                                        .addGap(217, 217, 217)
                                        .addComponent(titel_az, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(AuftragAnzeigenLayout.createSequentialGroup()
                                        .addGap(45, 45, 45)
                                        .addGroup(AuftragAnzeigenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(AuftragAnzeigenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(jtfGPID_az)
                                                .addComponent(jtfGPName_az)
                                                .addComponent(jtfGPadresse_az)
                                                .addComponent(jtfAuftragswertbrutto_az, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                                                .addComponent(jtfAuftragswertnetto_az))
                                            .addComponent(jtfAuftragsid_az, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(AuftragAnzeigenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AuftragAnzeigenLayout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(AuftragAnzeigenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jtfZKID_az, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jcbAuftragsart_az, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addGroup(AuftragAnzeigenLayout.createSequentialGroup()
                                                .addGap(149, 149, 149)
                                                .addGroup(AuftragAnzeigenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jlZKID)
                                                    .addComponent(jlErfassungsdatum)
                                                    .addComponent(jlLieferdatum)
                                                    .addComponent(jlAbschlussdatum)
                                                    .addComponent(jlAuftragsart)
                                                    .addComponent(jlStatus))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(AuftragAnzeigenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jftfLieferdatum_az, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jftfErfassungsdatum_az, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jtfAbschlussdatum_az, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jcbStatus_az, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addGroup(AuftragAnzeigenLayout.createSequentialGroup()
                                                .addGap(140, 140, 140)
                                                .addGroup(AuftragAnzeigenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jScrollPane2)
                                                    .addGroup(AuftragAnzeigenLayout.createSequentialGroup()
                                                        .addComponent(jlBeschreibung)
                                                        .addGap(0, 280, Short.MAX_VALUE))))))))
                            .addComponent(jlGPadresse_az)
                            .addComponent(jlGPName))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(AuftragAnzeigenLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(AuftragAnzeigenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(AuftragAnzeigenLayout.createSequentialGroup()
                        .addComponent(jbSpeichern_az)
                        .addGap(18, 18, 18)
                        .addComponent(jbBearbeiten_az)
                        .addGap(18, 18, 18)
                        .addComponent(jbZurueck_az, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 816, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(192, Short.MAX_VALUE))
        );
        AuftragAnzeigenLayout.setVerticalGroup(
            AuftragAnzeigenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AuftragAnzeigenLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titel_az)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addGroup(AuftragAnzeigenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(AuftragAnzeigenLayout.createSequentialGroup()
                        .addGroup(AuftragAnzeigenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlAuftragsid)
                            .addComponent(jtfAuftragsid_az, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(AuftragAnzeigenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlZKID, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(AuftragAnzeigenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jlGPNr)
                                .addComponent(jtfGPID_az, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(AuftragAnzeigenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlGPName)
                            .addComponent(jtfGPName_az, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlStatus))
                        .addGap(18, 18, 18)
                        .addGroup(AuftragAnzeigenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlGPadresse_az)
                            .addComponent(jtfGPadresse_az, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(67, 67, 67))
                    .addGroup(AuftragAnzeigenLayout.createSequentialGroup()
                        .addGroup(AuftragAnzeigenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jcbAuftragsart_az, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlAuftragsart))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jtfZKID_az, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jcbStatus_az, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addGroup(AuftragAnzeigenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jftfErfassungsdatum_az, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlErfassungsdatum))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(AuftragAnzeigenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jftfLieferdatum_az, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlLieferdatum))
                        .addGap(18, 18, 18)
                        .addGroup(AuftragAnzeigenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtfAbschlussdatum_az, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlAbschlussdatum))))
                .addGroup(AuftragAnzeigenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(AuftragAnzeigenLayout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addGroup(AuftragAnzeigenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlAuftragswertbrutto_az)
                            .addComponent(jtfAuftragswertbrutto_az, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(AuftragAnzeigenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlAuftragswertnetto_az)
                            .addComponent(jtfAuftragswertnetto_az, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(AuftragAnzeigenLayout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(jlBeschreibung)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(36, 36, 36)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(AuftragAnzeigenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbZurueck_az, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbBearbeiten_az, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbSpeichern_az, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(217, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jifAuftragAnzeigenLayout = new javax.swing.GroupLayout(jifAuftragAnzeigen.getContentPane());
        jifAuftragAnzeigen.getContentPane().setLayout(jifAuftragAnzeigenLayout);
        jifAuftragAnzeigenLayout.setHorizontalGroup(
            jifAuftragAnzeigenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jifAuftragAnzeigenLayout.createSequentialGroup()
                .addComponent(AuftragAnzeigen, javax.swing.GroupLayout.PREFERRED_SIZE, 1018, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jifAuftragAnzeigenLayout.setVerticalGroup(
            jifAuftragAnzeigenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(AuftragAnzeigen, javax.swing.GroupLayout.DEFAULT_SIZE, 863, Short.MAX_VALUE)
        );

        desktopPane.add(jifAuftragAnzeigen);
        jifAuftragAnzeigen.setBounds(0, 0, 1016, 892);

        jifAuftragAnlegen.setClosable(true);
        jifAuftragAnlegen.setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        jifAuftragAnlegen.setMinimumSize(new java.awt.Dimension(1200, 1000));
        jifAuftragAnlegen.setNormalBounds(new java.awt.Rectangle(0, 0, 41, 40));
        jifAuftragAnlegen.setPreferredSize(new java.awt.Dimension(1016, 1044));
        jifAuftragAnlegen.setVisible(false);

        AuftragAnlegen.setPreferredSize(new java.awt.Dimension(1200, 800));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setText("Auftrag anlegen");

        jbAbbrechen_aa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/abbruch2.png"))); // NOI18N
        jbAbbrechen_aa.setText("Abbrechen");
        jbAbbrechen_aa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAbbrechen_aaActionPerformed(evt);
            }
        });

        jLabel1.setText("Auftrags-ID:");

        jtfAuftragsid_aa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfAuftragsid_aaActionPerformed(evt);
            }
        });

        jLabel2.setText("Geschäftspartner:ID:");

        jLabel17.setText("Geschäftspartner-Name:");

        jLabel19.setText("Auftragsart:");

        jcbAuftragsart.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-", "Barauftrag", "Sofortauftrag", "Terminauftrag", "Bestellauftrag" }));
        jcbAuftragsart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbAuftragsartActionPerformed(evt);
            }
        });

        jLabel21.setText("Erfassungsdatum:");

        jLabel22.setText("Lieferdatum:");

        jLabel25.setText("Beschreibung:");

        jBeschreibung_aa.setColumns(20);
        jBeschreibung_aa.setRows(5);
        jScrollPane5.setViewportView(jBeschreibung_aa);

        jLabel41.setText("Status");

        jcbStatus.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-", "Erfasst", "Freigegeben", "Abgeschlossen" }));

        jLabel73.setText("Abschlussdatum");

        Auftragsposition_AuftragAnlegen.setBorder(javax.swing.BorderFactory.createTitledBorder("Auftragspositionen"));

        jLabel20.setText("Positions-ID:");

        jLabel18.setText("Artikel-ID:");

        jbLupe_AuftragAnlegen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/lupe.png"))); // NOI18N

        jLabel23.setText("Artikelname:");

        jLabel24.setText("Menge");

        jtfMenge_AuftragAnlegen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfMenge_AuftragAnlegenActionPerformed(evt);
            }
        });

        jLabel122.setText("Einzelwert");

        jLabel123.setText("Gesamtwert:");

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane8.setViewportView(jTable2);

        jbMinus_AuftragAnlegen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/minus2.png"))); // NOI18N

        jbPlus_AuftragAnlegen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/plus2.png"))); // NOI18N

        javax.swing.GroupLayout Auftragsposition_AuftragAnlegenLayout = new javax.swing.GroupLayout(Auftragsposition_AuftragAnlegen);
        Auftragsposition_AuftragAnlegen.setLayout(Auftragsposition_AuftragAnlegenLayout);
        Auftragsposition_AuftragAnlegenLayout.setHorizontalGroup(
            Auftragsposition_AuftragAnlegenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Auftragsposition_AuftragAnlegenLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Auftragsposition_AuftragAnlegenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Auftragsposition_AuftragAnlegenLayout.createSequentialGroup()
                        .addGroup(Auftragsposition_AuftragAnlegenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(Auftragsposition_AuftragAnlegenLayout.createSequentialGroup()
                                .addGroup(Auftragsposition_AuftragAnlegenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel20)
                                    .addComponent(jLabel18))
                                .addGap(86, 86, 86)
                                .addGroup(Auftragsposition_AuftragAnlegenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jtfPositionsID_AuftragAnlegen)
                                    .addComponent(jtfArtikelID_AuftragAnlegen, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)))
                            .addGroup(Auftragsposition_AuftragAnlegenLayout.createSequentialGroup()
                                .addComponent(jLabel23)
                                .addGap(86, 86, 86)
                                .addComponent(jtfArtikelname_AuftragAnlegen, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbLupe_AuftragAnlegen, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(75, 75, 75)
                        .addGroup(Auftragsposition_AuftragAnlegenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel122)
                            .addComponent(jLabel24)
                            .addComponent(jLabel123))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(Auftragsposition_AuftragAnlegenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jtfGesamtwert_AuftragAnlegen, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                            .addComponent(jtfMenge_AuftragAnlegen)
                            .addComponent(jtfEinzelwert_AuftragAnlegen))
                        .addGap(136, 136, 136))
                    .addGroup(Auftragsposition_AuftragAnlegenLayout.createSequentialGroup()
                        .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 779, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(Auftragsposition_AuftragAnlegenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jbMinus_AuftragAnlegen)
                            .addComponent(jbPlus_AuftragAnlegen))
                        .addContainerGap(24, Short.MAX_VALUE))))
        );
        Auftragsposition_AuftragAnlegenLayout.setVerticalGroup(
            Auftragsposition_AuftragAnlegenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Auftragsposition_AuftragAnlegenLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(Auftragsposition_AuftragAnlegenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(Auftragsposition_AuftragAnlegenLayout.createSequentialGroup()
                        .addComponent(jbPlus_AuftragAnlegen)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jbMinus_AuftragAnlegen))
                    .addGroup(Auftragsposition_AuftragAnlegenLayout.createSequentialGroup()
                        .addGroup(Auftragsposition_AuftragAnlegenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(Auftragsposition_AuftragAnlegenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jtfPositionsID_AuftragAnlegen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel24)
                                .addComponent(jtfMenge_AuftragAnlegen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel20, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(Auftragsposition_AuftragAnlegenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(Auftragsposition_AuftragAnlegenLayout.createSequentialGroup()
                                .addGroup(Auftragsposition_AuftragAnlegenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel18)
                                    .addComponent(jtfArtikelID_AuftragAnlegen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(Auftragsposition_AuftragAnlegenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel23)
                                    .addGroup(Auftragsposition_AuftragAnlegenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jtfArtikelname_AuftragAnlegen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel123))))
                            .addGroup(Auftragsposition_AuftragAnlegenLayout.createSequentialGroup()
                                .addGroup(Auftragsposition_AuftragAnlegenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jtfEinzelwert_AuftragAnlegen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel122))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jtfGesamtwert_AuftragAnlegen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jbLupe_AuftragAnlegen))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        jSpeichern_aa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/speichern2.png"))); // NOI18N
        jSpeichern_aa.setText("Speichern");
        jSpeichern_aa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jSpeichern_aaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout AuftragAnlegenLayout = new javax.swing.GroupLayout(AuftragAnlegen);
        AuftragAnlegen.setLayout(AuftragAnlegenLayout);
        AuftragAnlegenLayout.setHorizontalGroup(
            AuftragAnlegenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AuftragAnlegenLayout.createSequentialGroup()
                .addComponent(jSeparator9)
                .addContainerGap())
            .addGroup(AuftragAnlegenLayout.createSequentialGroup()
                .addGap(386, 386, 386)
                .addComponent(jLabel7)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(AuftragAnlegenLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(AuftragAnlegenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(AuftragAnlegenLayout.createSequentialGroup()
                        .addComponent(jSpeichern_aa)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jbAbbrechen_aa))
                    .addGroup(AuftragAnlegenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(Auftragsposition_AuftragAnlegen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(AuftragAnlegenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane5)
                            .addGroup(AuftragAnlegenLayout.createSequentialGroup()
                                .addGroup(AuftragAnlegenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(AuftragAnlegenLayout.createSequentialGroup()
                                        .addGroup(AuftragAnlegenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel2)
                                            .addComponent(jLabel1)
                                            .addComponent(jLabel17)
                                            .addComponent(jLabel41))
                                        .addGap(39, 39, 39)
                                        .addGroup(AuftragAnlegenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jtfGPname_aa)
                                            .addComponent(jtfGPID_aa)
                                            .addComponent(jtfAuftragsid_aa, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jcbStatus, 0, 150, Short.MAX_VALUE)))
                                    .addComponent(jLabel25))
                                .addGap(106, 106, 106)
                                .addGroup(AuftragAnlegenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel19)
                                    .addComponent(jLabel21)
                                    .addComponent(jLabel22)
                                    .addComponent(jLabel73))
                                .addGap(40, 40, 40)
                                .addGroup(AuftragAnlegenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jtfErfassungsdatum_aa)
                                    .addComponent(jtfLieferdatum_aa)
                                    .addComponent(jtfAbschlussdatum_aa)
                                    .addComponent(jcbAuftragsart, 0, 150, Short.MAX_VALUE))))))
                .addContainerGap(75, Short.MAX_VALUE))
        );
        AuftragAnlegenLayout.setVerticalGroup(
            AuftragAnlegenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AuftragAnlegenLayout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator9, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(AuftragAnlegenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jtfAuftragsid_aa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19)
                    .addComponent(jcbAuftragsart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(AuftragAnlegenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jtfGPID_aa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfErfassungsdatum_aa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(AuftragAnlegenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(jtfGPname_aa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22)
                    .addComponent(jtfLieferdatum_aa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(AuftragAnlegenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel73)
                    .addComponent(jtfAbschlussdatum_aa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel41))
                .addGap(23, 23, 23)
                .addComponent(jLabel25)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(Auftragsposition_AuftragAnlegen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(AuftragAnlegenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbAbbrechen_aa)
                    .addComponent(jSpeichern_aa))
                .addContainerGap(48, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jifAuftragAnlegenLayout = new javax.swing.GroupLayout(jifAuftragAnlegen.getContentPane());
        jifAuftragAnlegen.getContentPane().setLayout(jifAuftragAnlegenLayout);
        jifAuftragAnlegenLayout.setHorizontalGroup(
            jifAuftragAnlegenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1000, Short.MAX_VALUE)
            .addGroup(jifAuftragAnlegenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(AuftragAnlegen, javax.swing.GroupLayout.DEFAULT_SIZE, 1000, Short.MAX_VALUE))
        );
        jifAuftragAnlegenLayout.setVerticalGroup(
            jifAuftragAnlegenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1008, Short.MAX_VALUE)
            .addGroup(jifAuftragAnlegenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jifAuftragAnlegenLayout.createSequentialGroup()
                    .addComponent(AuftragAnlegen, javax.swing.GroupLayout.PREFERRED_SIZE, 683, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 325, Short.MAX_VALUE)))
        );

        desktopPane.add(jifAuftragAnlegen);
        jifAuftragAnlegen.setBounds(0, 0, 1016, 1044);

        jifAuftragBearbeiten.setClosable(true);
        jifAuftragBearbeiten.setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        jifAuftragBearbeiten.setNormalBounds(new java.awt.Rectangle(0, 0, 41, 40));
        jifAuftragBearbeiten.setPreferredSize(new java.awt.Dimension(1016, 770));
        jifAuftragBearbeiten.setVisible(false);

        AuftragBearbeiten.setPreferredSize(new java.awt.Dimension(1200, 800));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setText("Auftrag Bearbeiten");

        jbAbbrechen_AuftragBearbeiten.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/abbruch2.png"))); // NOI18N
        jbAbbrechen_AuftragBearbeiten.setText("Abbrechen");
        jbAbbrechen_AuftragBearbeiten.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAbbrechen_AuftragBearbeitenActionPerformed(evt);
            }
        });

        jbBearbeiten_AuftragBearbeiten.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/bearbeiten1.png"))); // NOI18N
        jbBearbeiten_AuftragBearbeiten.setText("Bearbeiten");
        jbBearbeiten_AuftragBearbeiten.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBearbeiten_AuftragBearbeitenActionPerformed(evt);
            }
        });

        jLabel87.setText("Auftrags-ID:");

        javax.swing.GroupLayout AuftragBearbeitenLayout = new javax.swing.GroupLayout(AuftragBearbeiten);
        AuftragBearbeiten.setLayout(AuftragBearbeitenLayout);
        AuftragBearbeitenLayout.setHorizontalGroup(
            AuftragBearbeitenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator10, javax.swing.GroupLayout.DEFAULT_SIZE, 1022, Short.MAX_VALUE)
            .addGroup(AuftragBearbeitenLayout.createSequentialGroup()
                .addGap(190, 190, 190)
                .addComponent(jLabel8))
            .addGroup(AuftragBearbeitenLayout.createSequentialGroup()
                .addGap(248, 248, 248)
                .addGroup(AuftragBearbeitenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(AuftragBearbeitenLayout.createSequentialGroup()
                        .addComponent(jbBearbeiten_AuftragBearbeiten, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbAbbrechen_AuftragBearbeiten, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(AuftragBearbeitenLayout.createSequentialGroup()
                        .addComponent(jLabel87)
                        .addGap(31, 31, 31)
                        .addComponent(jtfAuftragsID_AuftragBearbeiten, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        AuftragBearbeitenLayout.setVerticalGroup(
            AuftragBearbeitenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AuftragBearbeitenLayout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jLabel8)
                .addGap(18, 18, 18)
                .addComponent(jSeparator10, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(AuftragBearbeitenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel87)
                    .addComponent(jtfAuftragsID_AuftragBearbeiten, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(AuftragBearbeitenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbAbbrechen_AuftragBearbeiten)
                    .addComponent(jbBearbeiten_AuftragBearbeiten))
                .addContainerGap(589, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jifAuftragBearbeitenLayout = new javax.swing.GroupLayout(jifAuftragBearbeiten.getContentPane());
        jifAuftragBearbeiten.getContentPane().setLayout(jifAuftragBearbeitenLayout);
        jifAuftragBearbeitenLayout.setHorizontalGroup(
            jifAuftragBearbeitenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jifAuftragBearbeitenLayout.createSequentialGroup()
                .addComponent(AuftragBearbeiten, javax.swing.GroupLayout.PREFERRED_SIZE, 1022, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jifAuftragBearbeitenLayout.setVerticalGroup(
            jifAuftragBearbeitenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(AuftragBearbeiten, javax.swing.GroupLayout.DEFAULT_SIZE, 741, Short.MAX_VALUE)
        );

        desktopPane.add(jifAuftragBearbeiten);
        jifAuftragBearbeiten.setBounds(0, 0, 1016, 770);

        jifAuftragSuchen.setClosable(true);
        jifAuftragSuchen.setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        jifAuftragSuchen.setNormalBounds(new java.awt.Rectangle(0, 0, 41, 40));
        jifAuftragSuchen.setPreferredSize(new java.awt.Dimension(1016, 770));
        jifAuftragSuchen.setVisible(false);

        AuftragSuchen.setPreferredSize(new java.awt.Dimension(1200, 800));

        titel_as.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        titel_as.setText("Auftrag Suchen");

        jlAuftragsnr_as.setText("Auftrags-ID:");

        jbZurueck_AutragSuchen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/zurück.png"))); // NOI18N
        jbZurueck_AutragSuchen.setText("Zurück");
        jbZurueck_AutragSuchen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbZurueck_AutragSuchenActionPerformed(evt);
            }
        });

        jLabel26.setText("Suchkriterium:");

        jcbSuchkriterium_AuftragSuchen.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Auftrags-ID", "Kundenname", "Lieferantenname", "Lieferdatum", "Erfassungsdatum", "Status", "Auftragswert", "Auftragsart" }));
        jcbSuchkriterium_AuftragSuchen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbSuchkriterium_AuftragSuchenActionPerformed(evt);
            }
        });

        jLabel27.setText("Kundenname:");

        jLabel28.setText("Lieferantenname:");

        jLabel29.setText("Lieferdatum:");

        jLabel30.setText("Erfassungsdatum:");

        jtfKundenName_AuftragSuchen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfKundenName_AuftragSuchenActionPerformed(evt);
            }
        });

        jLabel31.setText("Status");

        jtfMinAuftragswert_AuftragSuche.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfMinAuftragswert_AuftragSucheActionPerformed(evt);
            }
        });

        jLabel32.setText("Auftragswert");

        jLabel33.setText("Auftragsart");

        jcbStatusArt_AuftragSuche.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "", "erfasst", "freigegeben", "abgeschlossen" }));

        jcbStatus_AuftragSuche.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "", "Barauftrag", "Sofortauftrag", "Terminauftrag", "Bestellauftrag" }));

        jLabel34.setText("bis");

        jbSuchen_AuftragSuchen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/lupe.png"))); // NOI18N
        jbSuchen_AuftragSuchen.setText("Suchen");

        jLabel35.setText("€");

        jLabel36.setText("€");

        jtTabelle_AuftragSuche.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Auftrags-ID", "Status", "Kundenname", "Lieferantenname", "Lieferdatum", "Auftragsart", "Auftragswert"
            }
        ));
        jScrollPane4.setViewportView(jtTabelle_AuftragSuche);

        jbAnzeigen_AuftragSuchen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/anzeigen.png"))); // NOI18N
        jbAnzeigen_AuftragSuchen.setText("Anzeigen");
        jbAnzeigen_AuftragSuchen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAnzeigen_AuftragSuchenActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout AuftragSuchenLayout = new javax.swing.GroupLayout(AuftragSuchen);
        AuftragSuchen.setLayout(AuftragSuchenLayout);
        AuftragSuchenLayout.setHorizontalGroup(
            AuftragSuchenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AuftragSuchenLayout.createSequentialGroup()
                .addGroup(AuftragSuchenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addGroup(AuftragSuchenLayout.createSequentialGroup()
                        .addGroup(AuftragSuchenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(AuftragSuchenLayout.createSequentialGroup()
                                .addGap(404, 404, 404)
                                .addComponent(titel_as))
                            .addGroup(AuftragSuchenLayout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addGroup(AuftragSuchenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, AuftragSuchenLayout.createSequentialGroup()
                                        .addGroup(AuftragSuchenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jlAuftragsnr_as)
                                            .addComponent(jLabel26)
                                            .addComponent(jLabel27)
                                            .addComponent(jLabel28)
                                            .addComponent(jLabel29)
                                            .addComponent(jLabel30))
                                        .addGap(35, 35, 35)
                                        .addGroup(AuftragSuchenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jftfLieferdatum_AuftragSuche, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jtfLieferantenname_AuftragSuche)
                                            .addComponent(jftfErfassungsdatum_AuftragSuche, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jtfAuftragsID_AuftragSuchen)
                                            .addComponent(jcbSuchkriterium_AuftragSuchen, 0, 150, Short.MAX_VALUE)
                                            .addComponent(jtfKundenName_AuftragSuchen))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(AuftragSuchenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AuftragSuchenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AuftragSuchenLayout.createSequentialGroup()
                                                    .addComponent(jLabel33)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(jcbStatus_AuftragSuche, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AuftragSuchenLayout.createSequentialGroup()
                                                    .addGroup(AuftragSuchenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel31)
                                                        .addComponent(jLabel32))
                                                    .addGap(5, 5, Short.MAX_VALUE)
                                                    .addGroup(AuftragSuchenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(AuftragSuchenLayout.createSequentialGroup()
                                                            .addComponent(jtfMinAuftragswert_AuftragSuche, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                            .addComponent(jLabel35)
                                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                            .addComponent(jLabel34)
                                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                            .addComponent(jtfMaxAuftragswert_AuftragSuche, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                            .addComponent(jLabel36))
                                                        .addComponent(jcbStatusArt_AuftragSuche, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                            .addComponent(jbSuchen_AuftragSuchen, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, AuftragSuchenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 710, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(AuftragSuchenLayout.createSequentialGroup()
                                            .addComponent(jbAnzeigen_AuftragSuchen)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(jbZurueck_AutragSuchen, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(4, 4, 4))))))
                        .addGap(0, 240, Short.MAX_VALUE)))
                .addContainerGap())
        );
        AuftragSuchenLayout.setVerticalGroup(
            AuftragSuchenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AuftragSuchenLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titel_as)
                .addGap(4, 4, 4)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(AuftragSuchenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(jcbSuchkriterium_AuftragSuchen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addGroup(AuftragSuchenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlAuftragsnr_as)
                    .addComponent(jtfAuftragsID_AuftragSuchen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel31)
                    .addComponent(jcbStatusArt_AuftragSuche, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(AuftragSuchenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27)
                    .addComponent(jtfKundenName_AuftragSuchen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfMinAuftragswert_AuftragSuche, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel32)
                    .addComponent(jtfMaxAuftragswert_AuftragSuche, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel35)
                    .addComponent(jLabel34)
                    .addComponent(jLabel36))
                .addGap(18, 18, 18)
                .addGroup(AuftragSuchenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel28)
                    .addGroup(AuftragSuchenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jtfLieferantenname_AuftragSuche, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel33)
                        .addComponent(jcbStatus_AuftragSuche, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(AuftragSuchenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel29)
                    .addComponent(jftfLieferdatum_AuftragSuche, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(AuftragSuchenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel30)
                    .addGroup(AuftragSuchenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jftfErfassungsdatum_AuftragSuche, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jbSuchen_AuftragSuchen)))
                .addGap(29, 29, 29)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(AuftragSuchenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbAnzeigen_AuftragSuchen)
                    .addComponent(jbZurueck_AutragSuchen))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jifAuftragSuchenLayout = new javax.swing.GroupLayout(jifAuftragSuchen.getContentPane());
        jifAuftragSuchen.getContentPane().setLayout(jifAuftragSuchenLayout);
        jifAuftragSuchenLayout.setHorizontalGroup(
            jifAuftragSuchenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(AuftragSuchen, javax.swing.GroupLayout.DEFAULT_SIZE, 1000, Short.MAX_VALUE)
        );
        jifAuftragSuchenLayout.setVerticalGroup(
            jifAuftragSuchenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(AuftragSuchen, javax.swing.GroupLayout.DEFAULT_SIZE, 741, Short.MAX_VALUE)
        );

        desktopPane.add(jifAuftragSuchen);
        jifAuftragSuchen.setBounds(0, 0, 1016, 770);

        jifAuftragsID_suchen.setClosable(true);
        jifAuftragsID_suchen.setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        jifAuftragsID_suchen.setMinimumSize(new java.awt.Dimension(76, 40));
        jifAuftragsID_suchen.setNormalBounds(new java.awt.Rectangle(0, 0, 60, 40));
        jifAuftragsID_suchen.setPreferredSize(new java.awt.Dimension(1016, 770));
        jifAuftragsID_suchen.setVisible(false);

        AuftragsID_suchen.setName(""); // NOI18N
        AuftragsID_suchen.setPreferredSize(new java.awt.Dimension(1200, 800));

        jLabel88.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel88.setText("Auftrags-ID suchen");

        jLabel89.setText("Kundenname:");

        jLabel90.setText("Lieferantenname:");

        jtfLieferantenname_AuftragsIDSuchen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfLieferantenname_AuftragsIDSuchenActionPerformed(evt);
            }
        });

        jcbDatumAuftragsIDSuchen.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Erfassungsdatum", "Lieferdatum", "Abschlussdatum" }));
        jcbDatumAuftragsIDSuchen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbDatumAuftragsIDSuchenActionPerformed(evt);
            }
        });

        jLabel91.setText("Status:");

        jcbStatus_AuftragsIDSuchen.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "erfasst", "freigegeben", "abgeschlossen", "" }));

        jbAbbrechen_AuftragsIDSuchen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/abbruch2.png"))); // NOI18N
        jbAbbrechen_AuftragsIDSuchen.setText("Abbrechen");

        jbSuchen_AuftragsIDSuchen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/lupe.png"))); // NOI18N
        jbSuchen_AuftragsIDSuchen.setText("Suchen");
        jbSuchen_AuftragsIDSuchen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSuchen_AuftragsIDSuchenActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout AuftragsID_suchenLayout = new javax.swing.GroupLayout(AuftragsID_suchen);
        AuftragsID_suchen.setLayout(AuftragsID_suchenLayout);
        AuftragsID_suchenLayout.setHorizontalGroup(
            AuftragsID_suchenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AuftragsID_suchenLayout.createSequentialGroup()
                .addGroup(AuftragsID_suchenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator23)
                    .addGroup(AuftragsID_suchenLayout.createSequentialGroup()
                        .addGroup(AuftragsID_suchenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(AuftragsID_suchenLayout.createSequentialGroup()
                                .addGap(242, 242, 242)
                                .addComponent(jLabel88))
                            .addGroup(AuftragsID_suchenLayout.createSequentialGroup()
                                .addGap(86, 86, 86)
                                .addGroup(AuftragsID_suchenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(AuftragsID_suchenLayout.createSequentialGroup()
                                        .addComponent(jbSuchen_AuftragsIDSuchen, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jbAbbrechen_AuftragsIDSuchen))
                                    .addGroup(AuftragsID_suchenLayout.createSequentialGroup()
                                        .addGroup(AuftragsID_suchenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel89, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel90))
                                        .addGap(33, 33, 33)
                                        .addGroup(AuftragsID_suchenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jtfLieferantenname_AuftragsIDSuchen, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jtfKundenname_AuftragsIDSuchen, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(79, 79, 79)
                                        .addGroup(AuftragsID_suchenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(AuftragsID_suchenLayout.createSequentialGroup()
                                                .addComponent(jcbDatumAuftragsIDSuchen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(24, 24, 24)
                                                .addComponent(jtfDatum_AuftragsIDSuchen, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(AuftragsID_suchenLayout.createSequentialGroup()
                                                .addComponent(jLabel91)
                                                .addGap(108, 108, 108)
                                                .addComponent(jcbStatus_AuftragsIDSuchen, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                        .addGap(0, 268, Short.MAX_VALUE)))
                .addContainerGap())
        );
        AuftragsID_suchenLayout.setVerticalGroup(
            AuftragsID_suchenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AuftragsID_suchenLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel88)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator23, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addGroup(AuftragsID_suchenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel89)
                    .addComponent(jtfKundenname_AuftragsIDSuchen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfDatum_AuftragsIDSuchen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbDatumAuftragsIDSuchen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(AuftragsID_suchenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel90)
                    .addComponent(jtfLieferantenname_AuftragsIDSuchen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel91)
                    .addComponent(jcbStatus_AuftragsIDSuchen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addGroup(AuftragsID_suchenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbAbbrechen_AuftragsIDSuchen)
                    .addComponent(jbSuchen_AuftragsIDSuchen))
                .addContainerGap(504, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jifAuftragsID_suchenLayout = new javax.swing.GroupLayout(jifAuftragsID_suchen.getContentPane());
        jifAuftragsID_suchen.getContentPane().setLayout(jifAuftragsID_suchenLayout);
        jifAuftragsID_suchenLayout.setHorizontalGroup(
            jifAuftragsID_suchenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(AuftragsID_suchen, javax.swing.GroupLayout.DEFAULT_SIZE, 1000, Short.MAX_VALUE)
        );
        jifAuftragsID_suchenLayout.setVerticalGroup(
            jifAuftragsID_suchenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(AuftragsID_suchen, javax.swing.GroupLayout.DEFAULT_SIZE, 741, Short.MAX_VALUE)
        );

        desktopPane.add(jifAuftragsID_suchen);
        jifAuftragsID_suchen.setBounds(0, 0, 1016, 770);

        jifArtikelAnzeige.setClosable(true);
        jifArtikelAnzeige.setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        jifArtikelAnzeige.setNormalBounds(new java.awt.Rectangle(0, 0, 41, 40));
        jifArtikelAnzeige.setPreferredSize(new java.awt.Dimension(1016, 892));
        jifArtikelAnzeige.setVisible(false);

        ArtikelAnzeige.setPreferredSize(new java.awt.Dimension(1200, 800));

        jLabel53.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel53.setText("Bestellwert (Netto):");

        jLabel54.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel54.setText("(Brutto):");

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

        jLabel49.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel49.setText("Artikeltext:");

        jLabel55.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel55.setText("MwST-Satz:");

        jcbmehrwertsteuer_ArtikelAnzeigen.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "", "7", "19" }));
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

        jtfeinzelwertnetto_ArtikelAnzeigen.setPreferredSize(new java.awt.Dimension(6, 25));

        jtfbestellwertbrutto_ArtikelAnzeigen.setPreferredSize(new java.awt.Dimension(6, 25));

        jtffrei_ArtikelAnzeigen.setPreferredSize(new java.awt.Dimension(6, 25));

        jtfzulauf_ArtikelAnzeigen.setPreferredSize(new java.awt.Dimension(6, 25));

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

        jtfverkauft_ArtikelAnzeigen.setPreferredSize(new java.awt.Dimension(6, 25));

        jtfeinzelwertbrutto_ArtikelAnzeigen.setPreferredSize(new java.awt.Dimension(6, 25));

        jLabel56.setText("%");

        jLabel37.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel37.setText("Artikel Anzeigen");

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

        javax.swing.GroupLayout ArtikelAnzeigeLayout = new javax.swing.GroupLayout(ArtikelAnzeige);
        ArtikelAnzeige.setLayout(ArtikelAnzeigeLayout);
        ArtikelAnzeigeLayout.setHorizontalGroup(
            ArtikelAnzeigeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ArtikelAnzeigeLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ArtikelAnzeigeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(ArtikelAnzeigeLayout.createSequentialGroup()
                        .addGroup(ArtikelAnzeigeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(ArtikelAnzeigeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jtfbestelltext_ArtikelAnzeigen, javax.swing.GroupLayout.DEFAULT_SIZE, 348, Short.MAX_VALUE)
                                .addComponent(jtfartikeltext_ArtikelAnzeigen))
                            .addGroup(ArtikelAnzeigeLayout.createSequentialGroup()
                                .addGroup(ArtikelAnzeigeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel53)
                                    .addComponent(jLabel55))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 6, Short.MAX_VALUE)
                                .addGroup(ArtikelAnzeigeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(ArtikelAnzeigeLayout.createSequentialGroup()
                                        .addComponent(jcbmehrwertsteuer_ArtikelAnzeigen, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel56, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ArtikelAnzeigeLayout.createSequentialGroup()
                                        .addComponent(jtfbestellwertnetto_ArtikelAnzeigen, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel167)
                                        .addGap(177, 177, 177))))
                            .addGroup(ArtikelAnzeigeLayout.createSequentialGroup()
                                .addGap(187, 187, 187)
                                .addComponent(jLabel37))
                            .addComponent(jLabel44)
                            .addComponent(jLabel43)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ArtikelAnzeigeLayout.createSequentialGroup()
                                .addComponent(jLabel51)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jtfeinzelwertnetto_ArtikelAnzeigen, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel166, javax.swing.GroupLayout.PREFERRED_SIZE, 6, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(87, 87, 87)
                                .addGroup(ArtikelAnzeigeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel54)
                                    .addComponent(jLabel52))
                                .addGap(27, 27, 27))
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
                                    .addComponent(jLabel48)
                                    .addComponent(jLabel47))))
                        .addGroup(ArtikelAnzeigeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(ArtikelAnzeigeLayout.createSequentialGroup()
                                .addGroup(ArtikelAnzeigeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jtfverkauft_ArtikelAnzeigen, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jtfreserviert_ArtikelAnzeigen, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(ArtikelAnzeigeLayout.createSequentialGroup()
                                .addGroup(ArtikelAnzeigeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jbabbrechen_ArtikelAnzeigen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(ArtikelAnzeigeLayout.createSequentialGroup()
                                        .addGroup(ArtikelAnzeigeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jtfbestellwertbrutto_ArtikelAnzeigen, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jtfeinzelwertbrutto_ArtikelAnzeigen, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(ArtikelAnzeigeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel168)
                                            .addComponent(jLabel169))))
                                .addContainerGap(544, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, ArtikelAnzeigeLayout.createSequentialGroup()
                        .addGroup(ArtikelAnzeigeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, ArtikelAnzeigeLayout.createSequentialGroup()
                                .addComponent(jLabel42)
                                .addGap(57, 57, 57)
                                .addGroup(ArtikelAnzeigeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jtfartikelname_ArtikelAnzeigen, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jtfArtikelID_ArtikelAnzeigen, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, ArtikelAnzeigeLayout.createSequentialGroup()
                                .addGap(184, 184, 184)
                                .addComponent(jbSpeichern_ArtikelAnzeigen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(45, 45, 45)
                                .addComponent(jbbearbeiten_ArtikelAnzeigen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(ArtikelAnzeigeLayout.createSequentialGroup()
                .addGroup(ArtikelAnzeigeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ArtikelAnzeigeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(ArtikelAnzeigeLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 940, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, ArtikelAnzeigeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, ArtikelAnzeigeLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jSeparator5))
                            .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 940, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(ArtikelAnzeigeLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(ArtikelAnzeigeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel50)
                            .addComponent(jLabel49))))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        ArtikelAnzeigeLayout.setVerticalGroup(
            ArtikelAnzeigeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ArtikelAnzeigeLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ArtikelAnzeigeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel37)
                    .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(ArtikelAnzeigeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel42)
                    .addComponent(jtfArtikelID_ArtikelAnzeigen, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(ArtikelAnzeigeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel43)
                    .addComponent(jtfartikelname_ArtikelAnzeigen, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel44)
                .addGap(15, 15, 15)
                .addGroup(ArtikelAnzeigeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel45)
                    .addComponent(jtffrei_ArtikelAnzeigen, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel47)
                    .addComponent(jtfreserviert_ArtikelAnzeigen, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(ArtikelAnzeigeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                    .addComponent(jLabel46)
                    .addComponent(jLabel48)
                    .addComponent(jtfzulauf_ArtikelAnzeigen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfverkauft_ArtikelAnzeigen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel50)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jtfbestelltext_ArtikelAnzeigen, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel49)
                .addGap(18, 18, 18)
                .addComponent(jtfartikeltext_ArtikelAnzeigen, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(ArtikelAnzeigeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel51)
                    .addComponent(jtfeinzelwertnetto_ArtikelAnzeigen, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel166)
                    .addComponent(jLabel52)
                    .addComponent(jtfeinzelwertbrutto_ArtikelAnzeigen, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel168))
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

        javax.swing.GroupLayout jifArtikelAnzeigeLayout = new javax.swing.GroupLayout(jifArtikelAnzeige.getContentPane());
        jifArtikelAnzeige.getContentPane().setLayout(jifArtikelAnzeigeLayout);
        jifArtikelAnzeigeLayout.setHorizontalGroup(
            jifArtikelAnzeigeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jifArtikelAnzeigeLayout.createSequentialGroup()
                .addComponent(ArtikelAnzeige, javax.swing.GroupLayout.PREFERRED_SIZE, 1018, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jifArtikelAnzeigeLayout.setVerticalGroup(
            jifArtikelAnzeigeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ArtikelAnzeige, javax.swing.GroupLayout.DEFAULT_SIZE, 863, Short.MAX_VALUE)
        );

        desktopPane.add(jifArtikelAnzeige);
        jifArtikelAnzeige.setBounds(0, 0, 1016, 892);

        jifArtikelAnlegen.setClosable(true);
        jifArtikelAnlegen.setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        jifArtikelAnlegen.setMinimumSize(new java.awt.Dimension(76, 40));
        jifArtikelAnlegen.setNormalBounds(new java.awt.Rectangle(0, 0, 60, 40));
        jifArtikelAnlegen.setPreferredSize(new java.awt.Dimension(1016, 770));
        jifArtikelAnlegen.setVisible(false);

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
                        .addComponent(jSeparator13, javax.swing.GroupLayout.DEFAULT_SIZE, 932, Short.MAX_VALUE)
                        .addComponent(jSeparator11)
                        .addGroup(ArtikelAnlegenLayout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(ArtikelAnlegenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(ArtikelAnlegenLayout.createSequentialGroup()
                                    .addComponent(jbSpeichern_ArtikelAnlegen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jbAbbrechen_ArtikelAnlegen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(55, 55, 55))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, ArtikelAnlegenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(ArtikelAnlegenLayout.createSequentialGroup()
                                        .addComponent(jLabel64)
                                        .addGap(61, 61, 61)
                                        .addGroup(ArtikelAnlegenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jtfartikelname_ArtikelAnlegen, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                                            .addComponent(jtfartikelid_ArtikelAnlegen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                    .addComponent(jLabel63)
                                    .addComponent(jLabel71)
                                    .addGroup(ArtikelAnlegenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jtfartikeltext_ArtikelAnlegen, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 348, Short.MAX_VALUE)
                                        .addComponent(jtfbestelltext_ArtikelAnlegen, javax.swing.GroupLayout.Alignment.LEADING))
                                    .addComponent(jLabel65)
                                    .addComponent(jLabel66)
                                    .addComponent(jLabel72)
                                    .addGroup(ArtikelAnlegenLayout.createSequentialGroup()
                                        .addGroup(ArtikelAnlegenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(ArtikelAnlegenLayout.createSequentialGroup()
                                                .addGap(187, 187, 187)
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
                                        .addGap(70, 70, 70)
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
                                                .addComponent(jLabel173, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                            .addGap(180, 180, 180))))
                .addGap(60, 60, 60))
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
                .addGap(18, 18, 18)
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
                .addGap(33, 33, 33)
                .addGroup(ArtikelAnlegenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel72)
                    .addComponent(jcbMwst_ArtikelAnlegen, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel58))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ArtikelAnlegenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbAbbrechen_ArtikelAnlegen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbSpeichern_ArtikelAnlegen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jifArtikelAnlegenLayout = new javax.swing.GroupLayout(jifArtikelAnlegen.getContentPane());
        jifArtikelAnlegen.getContentPane().setLayout(jifArtikelAnlegenLayout);
        jifArtikelAnlegenLayout.setHorizontalGroup(
            jifArtikelAnlegenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ArtikelAnlegen, javax.swing.GroupLayout.DEFAULT_SIZE, 1024, Short.MAX_VALUE)
        );
        jifArtikelAnlegenLayout.setVerticalGroup(
            jifArtikelAnlegenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jifArtikelAnlegenLayout.createSequentialGroup()
                .addComponent(ArtikelAnlegen, javax.swing.GroupLayout.PREFERRED_SIZE, 769, Short.MAX_VALUE)
                .addContainerGap())
        );

        desktopPane.add(jifArtikelAnlegen);
        jifArtikelAnlegen.setBounds(0, 0, 1016, 770);

        jifArtikelBearbeiten.setClosable(true);
        jifArtikelBearbeiten.setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        jifArtikelBearbeiten.setMinimumSize(new java.awt.Dimension(76, 40));
        jifArtikelBearbeiten.setNormalBounds(new java.awt.Rectangle(0, 0, 60, 40));
        jifArtikelBearbeiten.setPreferredSize(new java.awt.Dimension(1016, 770));
        jifArtikelBearbeiten.setVisible(false);

        ArtikelBearbeiten.setPreferredSize(new java.awt.Dimension(1200, 800));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel5.setText("Artikel-ID:");

        jtfartikelid_ArtikelBearbeiten.setPreferredSize(new java.awt.Dimension(6, 25));

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

        jbAbbrechen_ArtikelBearbeiten.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jbAbbrechen_ArtikelBearbeiten.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/abbruch2.png"))); // NOI18N
        jbAbbrechen_ArtikelBearbeiten.setText("Abbrechen");
        jbAbbrechen_ArtikelBearbeiten.setPreferredSize(new java.awt.Dimension(130, 35));
        jbAbbrechen_ArtikelBearbeiten.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAbbrechen_ArtikelBearbeitenActionPerformed(evt);
            }
        });

        jLabel40.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel40.setText("Artikel Bearbeiten");

        javax.swing.GroupLayout ArtikelBearbeitenLayout = new javax.swing.GroupLayout(ArtikelBearbeiten);
        ArtikelBearbeiten.setLayout(ArtikelBearbeitenLayout);
        ArtikelBearbeitenLayout.setHorizontalGroup(
            ArtikelBearbeitenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ArtikelBearbeitenLayout.createSequentialGroup()
                .addGap(269, 269, 269)
                .addComponent(jLabel40)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(ArtikelBearbeitenLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ArtikelBearbeitenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(ArtikelBearbeitenLayout.createSequentialGroup()
                        .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, 923, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(ArtikelBearbeitenLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(ArtikelBearbeitenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(ArtikelBearbeitenLayout.createSequentialGroup()
                                .addComponent(jbBearbeiten_ArtikelBearbeiten, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jbAbbrechen_ArtikelBearbeiten, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(ArtikelBearbeitenLayout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jtfartikelid_ArtikelBearbeiten, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(504, 504, 504))))
        );
        ArtikelBearbeitenLayout.setVerticalGroup(
            ArtikelBearbeitenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ArtikelBearbeitenLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel40)
                .addGap(9, 9, 9)
                .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(ArtikelBearbeitenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfartikelid_ArtikelBearbeiten, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(ArtikelBearbeitenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbAbbrechen_ArtikelBearbeiten, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbBearbeiten_ArtikelBearbeiten, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(579, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jifArtikelBearbeitenLayout = new javax.swing.GroupLayout(jifArtikelBearbeiten.getContentPane());
        jifArtikelBearbeiten.getContentPane().setLayout(jifArtikelBearbeitenLayout);
        jifArtikelBearbeitenLayout.setHorizontalGroup(
            jifArtikelBearbeitenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jifArtikelBearbeitenLayout.createSequentialGroup()
                .addComponent(ArtikelBearbeiten, javax.swing.GroupLayout.PREFERRED_SIZE, 1016, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jifArtikelBearbeitenLayout.setVerticalGroup(
            jifArtikelBearbeitenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ArtikelBearbeiten, javax.swing.GroupLayout.DEFAULT_SIZE, 741, Short.MAX_VALUE)
        );

        desktopPane.add(jifArtikelBearbeiten);
        jifArtikelBearbeiten.setBounds(0, 0, 1016, 770);

        jifArtikelSuche.setClosable(true);
        jifArtikelSuche.setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        jifArtikelSuche.setMinimumSize(new java.awt.Dimension(76, 40));
        jifArtikelSuche.setNormalBounds(new java.awt.Rectangle(0, 0, 60, 40));
        jifArtikelSuche.setPreferredSize(new java.awt.Dimension(1016, 770));
        jifArtikelSuche.setVisible(false);

        ArtikelSuche.setPreferredSize(new java.awt.Dimension(1200, 800));
        ArtikelSuche.setRequestFocusEnabled(false);

        jLabel57.setText("Artikel-ID:");

        jbAnzeigen_ArtikelSuche.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/anzeigen.png"))); // NOI18N
        jbAnzeigen_ArtikelSuche.setText("Anzeigen");
        jbAnzeigen_ArtikelSuche.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAnzeigen_ArtikelSucheActionPerformed(evt);
            }
        });

        jbSuchen_ArtikelSuche.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/lupe.png"))); // NOI18N
        jbSuchen_ArtikelSuche.setText("Suchen");

        jt_ArtikelSuche.setModel(new javax.swing.table.DefaultTableModel(
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
                {null, null, null, null, null, null}
            },
            new String [] {
                "Artikel-ID", "Artikelname", "Artikeltext", "Bestandsmenge", "Bestandstext", "Einzelwert"
            }
        ));
        jScrollPane3.setViewportView(jt_ArtikelSuche);

        jbAbbrechen_ArtikelSuche.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/abbruch2.png"))); // NOI18N
        jbAbbrechen_ArtikelSuche.setText("Abbrechen");
        jbAbbrechen_ArtikelSuche.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAbbrechen_ArtikelSucheActionPerformed(evt);
            }
        });

        jLabel38.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel38.setText("Artikel Suche");

        jcbArtikelID_ArtikelSuche.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "", "Artikel-ID", "Artikelname", "Bestandsmenge", "Einzelwert" }));

        javax.swing.GroupLayout ArtikelSucheLayout = new javax.swing.GroupLayout(ArtikelSuche);
        ArtikelSuche.setLayout(ArtikelSucheLayout);
        ArtikelSucheLayout.setHorizontalGroup(
            ArtikelSucheLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ArtikelSucheLayout.createSequentialGroup()
                .addGap(232, 232, 232)
                .addComponent(jbAnzeigen_ArtikelSuche)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbAbbrechen_ArtikelSuche))
            .addGroup(ArtikelSucheLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel57)
                .addGap(18, 18, 18)
                .addComponent(jcbArtikelID_ArtikelSuche, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(131, 131, 131)
                .addComponent(jbSuchen_ArtikelSuche))
            .addGroup(ArtikelSucheLayout.createSequentialGroup()
                .addGap(358, 358, 358)
                .addComponent(jLabel38))
            .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 1207, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(ArtikelSucheLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 655, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        ArtikelSucheLayout.setVerticalGroup(
            ArtikelSucheLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ArtikelSucheLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel38)
                .addGap(4, 4, 4)
                .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addGroup(ArtikelSucheLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel57)
                    .addComponent(jbSuchen_ArtikelSuche)
                    .addComponent(jcbArtikelID_ArtikelSuche, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(ArtikelSucheLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbAnzeigen_ArtikelSuche)
                    .addComponent(jbAbbrechen_ArtikelSuche))
                .addContainerGap(111, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jifArtikelSucheLayout = new javax.swing.GroupLayout(jifArtikelSuche.getContentPane());
        jifArtikelSuche.getContentPane().setLayout(jifArtikelSucheLayout);
        jifArtikelSucheLayout.setHorizontalGroup(
            jifArtikelSucheLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ArtikelSuche, javax.swing.GroupLayout.DEFAULT_SIZE, 1018, Short.MAX_VALUE)
        );
        jifArtikelSucheLayout.setVerticalGroup(
            jifArtikelSucheLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ArtikelSuche, javax.swing.GroupLayout.DEFAULT_SIZE, 741, Short.MAX_VALUE)
        );

        desktopPane.add(jifArtikelSuche);
        jifArtikelSuche.setBounds(0, 0, 1016, 770);

        jifLieferantAnzeigen.setClosable(true);
        jifLieferantAnzeigen.setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        jifLieferantAnzeigen.setMinimumSize(new java.awt.Dimension(76, 40));
        jifLieferantAnzeigen.setNormalBounds(new java.awt.Rectangle(0, 0, 60, 40));
        jifLieferantAnzeigen.setPreferredSize(new java.awt.Dimension(1016, 770));
        jifLieferantAnzeigen.setVisible(false);

        LieferantAnzeigen.setPreferredSize(new java.awt.Dimension(1200, 800));

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel10.setText("Lieferant anzeigen");

        jbzurueck_LieferantAnzeigen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/zurück.png"))); // NOI18N
        jbzurueck_LieferantAnzeigen.setText("Zurück");
        jbzurueck_LieferantAnzeigen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbzurueck_LieferantAnzeigenActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout LieferantAnzeigenLayout = new javax.swing.GroupLayout(LieferantAnzeigen);
        LieferantAnzeigen.setLayout(LieferantAnzeigenLayout);
        LieferantAnzeigenLayout.setHorizontalGroup(
            LieferantAnzeigenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LieferantAnzeigenLayout.createSequentialGroup()
                .addGroup(LieferantAnzeigenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(LieferantAnzeigenLayout.createSequentialGroup()
                        .addGap(246, 246, 246)
                        .addComponent(jbzurueck_LieferantAnzeigen))
                    .addGroup(LieferantAnzeigenLayout.createSequentialGroup()
                        .addGap(297, 297, 297)
                        .addComponent(jLabel10))
                    .addComponent(jSeparator16, javax.swing.GroupLayout.PREFERRED_SIZE, 943, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(74, Short.MAX_VALUE))
        );
        LieferantAnzeigenLayout.setVerticalGroup(
            LieferantAnzeigenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LieferantAnzeigenLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel10)
                .addGap(9, 9, 9)
                .addComponent(jSeparator16, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(157, 157, 157)
                .addComponent(jbzurueck_LieferantAnzeigen)
                .addContainerGap(490, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jifLieferantAnzeigenLayout = new javax.swing.GroupLayout(jifLieferantAnzeigen.getContentPane());
        jifLieferantAnzeigen.getContentPane().setLayout(jifLieferantAnzeigenLayout);
        jifLieferantAnzeigenLayout.setHorizontalGroup(
            jifLieferantAnzeigenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jifLieferantAnzeigenLayout.createSequentialGroup()
                .addComponent(LieferantAnzeigen, javax.swing.GroupLayout.PREFERRED_SIZE, 1017, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jifLieferantAnzeigenLayout.setVerticalGroup(
            jifLieferantAnzeigenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(LieferantAnzeigen, javax.swing.GroupLayout.DEFAULT_SIZE, 741, Short.MAX_VALUE)
        );

        desktopPane.add(jifLieferantAnzeigen);
        jifLieferantAnzeigen.setBounds(0, 0, 1016, 770);

        jifLieferantAnlegen.setClosable(true);
        jifLieferantAnlegen.setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        jifLieferantAnlegen.setMinimumSize(new java.awt.Dimension(76, 40));
        jifLieferantAnlegen.setNormalBounds(new java.awt.Rectangle(0, 0, 60, 40));
        jifLieferantAnlegen.setPreferredSize(new java.awt.Dimension(1016, 770));
        jifLieferantAnlegen.setVisible(false);

        LieferantAnlegen.setPreferredSize(new java.awt.Dimension(1200, 800));

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel11.setText("Lieferant anlegen");

        jbAbbrechen_LieferantAnlegen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/abbruch2.png"))); // NOI18N
        jbAbbrechen_LieferantAnlegen.setText("Abbrechen");
        jbAbbrechen_LieferantAnlegen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAbbrechen_LieferantAnlegenActionPerformed(evt);
            }
        });

        jbSpeichern_LieferantAnlegen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/speichern2.png"))); // NOI18N
        jbSpeichern_LieferantAnlegen.setText("Speichern");
        jbSpeichern_LieferantAnlegen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSpeichern_LieferantAnlegenActionPerformed(evt);
            }
        });

        jLabel74.setText("GP-ID:");

        jLabel75.setText("Kreditlimit");

        Rechnungsdaten_LieferantAnlegen.setBorder(javax.swing.BorderFactory.createTitledBorder("Rechnungsdaten"));

        jLabel130.setText("Anrede");

        jcbAnredeRG_LieferantAnlegen.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-", "Firma", "Frau", "Herr", "" }));

        jLabel131.setText("Name");

        jLabel132.setText("Vorname");

        jLabel133.setText("Firma");

        jLabel134.setText("Straße, HNr.");

        jLabel135.setText("PLZ, Ort");

        jLabel136.setText("Staat");

        javax.swing.GroupLayout Rechnungsdaten_LieferantAnlegenLayout = new javax.swing.GroupLayout(Rechnungsdaten_LieferantAnlegen);
        Rechnungsdaten_LieferantAnlegen.setLayout(Rechnungsdaten_LieferantAnlegenLayout);
        Rechnungsdaten_LieferantAnlegenLayout.setHorizontalGroup(
            Rechnungsdaten_LieferantAnlegenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Rechnungsdaten_LieferantAnlegenLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Rechnungsdaten_LieferantAnlegenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(Rechnungsdaten_LieferantAnlegenLayout.createSequentialGroup()
                        .addGroup(Rechnungsdaten_LieferantAnlegenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel130)
                            .addComponent(jLabel131)
                            .addComponent(jLabel132)
                            .addComponent(jLabel133))
                        .addGap(38, 38, 38)
                        .addGroup(Rechnungsdaten_LieferantAnlegenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtfVornameRG_LieferantAnlegen)
                            .addComponent(jtfNameRG_LieferantAnlegen)
                            .addComponent(jcbAnredeRG_LieferantAnlegen, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jtfFirmaRG_LieferantAnlegen)))
                    .addGroup(Rechnungsdaten_LieferantAnlegenLayout.createSequentialGroup()
                        .addGroup(Rechnungsdaten_LieferantAnlegenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel134)
                            .addComponent(jLabel135)
                            .addComponent(jLabel136))
                        .addGap(18, 18, 18)
                        .addGroup(Rechnungsdaten_LieferantAnlegenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Rechnungsdaten_LieferantAnlegenLayout.createSequentialGroup()
                                .addComponent(jtfStraßeRG_LieferantAnlegen)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jtfHNrRG_LieferantAnlegen, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(Rechnungsdaten_LieferantAnlegenLayout.createSequentialGroup()
                                .addComponent(jtfPlzRG_LieferantAnlegen, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jtfOrtRG_LieferantAnlegen, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE))
                            .addComponent(jtfStaatRG_LieferantAnlegen))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        Rechnungsdaten_LieferantAnlegenLayout.setVerticalGroup(
            Rechnungsdaten_LieferantAnlegenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Rechnungsdaten_LieferantAnlegenLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Rechnungsdaten_LieferantAnlegenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel130)
                    .addComponent(jcbAnredeRG_LieferantAnlegen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(Rechnungsdaten_LieferantAnlegenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel131)
                    .addComponent(jtfNameRG_LieferantAnlegen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(Rechnungsdaten_LieferantAnlegenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel132)
                    .addComponent(jtfVornameRG_LieferantAnlegen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(Rechnungsdaten_LieferantAnlegenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel133)
                    .addComponent(jtfFirmaRG_LieferantAnlegen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(Rechnungsdaten_LieferantAnlegenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel134)
                    .addComponent(jtfStraßeRG_LieferantAnlegen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfHNrRG_LieferantAnlegen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(Rechnungsdaten_LieferantAnlegenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel135)
                    .addComponent(jtfPlzRG_LieferantAnlegen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfOrtRG_LieferantAnlegen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(Rechnungsdaten_LieferantAnlegenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel136)
                    .addComponent(jtfStaatRG_LieferantAnlegen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(65, Short.MAX_VALUE))
        );

        Lieferdaten_LieferantAnlegen.setBorder(javax.swing.BorderFactory.createTitledBorder("Lieferdaten"));

        jLabel140.setText("Anrede");
        jLabel140.setToolTipText("");

        jLabel141.setText("Name");

        jLabel142.setText("Vorname");

        jLabel143.setText("Firma");

        jLabel144.setText("Straße, HNr.");

        jLabel145.setText("PLZ, Ort");

        jLabel146.setText("Staat");

        jcbAnrede2_LieferantAnlegen.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-", "FIrma", "Frau", "Herr" }));

        javax.swing.GroupLayout Lieferdaten_LieferantAnlegenLayout = new javax.swing.GroupLayout(Lieferdaten_LieferantAnlegen);
        Lieferdaten_LieferantAnlegen.setLayout(Lieferdaten_LieferantAnlegenLayout);
        Lieferdaten_LieferantAnlegenLayout.setHorizontalGroup(
            Lieferdaten_LieferantAnlegenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Lieferdaten_LieferantAnlegenLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Lieferdaten_LieferantAnlegenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Lieferdaten_LieferantAnlegenLayout.createSequentialGroup()
                        .addComponent(jLabel144)
                        .addGap(18, 18, 18)
                        .addComponent(jtfStraße2_LieferantAnlegen, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfHNr2_LieferantAnlegen, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(Lieferdaten_LieferantAnlegenLayout.createSequentialGroup()
                        .addGroup(Lieferdaten_LieferantAnlegenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel146)
                            .addComponent(jLabel140)
                            .addComponent(jLabel141)
                            .addComponent(jLabel142)
                            .addComponent(jLabel143)
                            .addComponent(jLabel145))
                        .addGap(35, 35, 35)
                        .addGroup(Lieferdaten_LieferantAnlegenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtfName2_LieferantAnlegen)
                            .addComponent(jtfVorname2_LieferantAnlegen)
                            .addComponent(jtfFirma2_LieferantAnlegen)
                            .addComponent(jcbAnrede2_LieferantAnlegen, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jtfStaat2_LieferantAnlegen)
                            .addGroup(Lieferdaten_LieferantAnlegenLayout.createSequentialGroup()
                                .addComponent(jtfPlz2_LieferantAnlegen, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jtfOrt2_LieferantAnlegen)))))
                .addContainerGap())
        );
        Lieferdaten_LieferantAnlegenLayout.setVerticalGroup(
            Lieferdaten_LieferantAnlegenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Lieferdaten_LieferantAnlegenLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Lieferdaten_LieferantAnlegenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel140)
                    .addComponent(jcbAnrede2_LieferantAnlegen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(Lieferdaten_LieferantAnlegenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel141)
                    .addComponent(jtfName2_LieferantAnlegen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(Lieferdaten_LieferantAnlegenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel142)
                    .addComponent(jtfVorname2_LieferantAnlegen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(Lieferdaten_LieferantAnlegenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel143)
                    .addComponent(jtfFirma2_LieferantAnlegen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(Lieferdaten_LieferantAnlegenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel144)
                    .addComponent(jtfStraße2_LieferantAnlegen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfHNr2_LieferantAnlegen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(Lieferdaten_LieferantAnlegenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel145)
                    .addComponent(jtfPlz2_LieferantAnlegen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfOrt2_LieferantAnlegen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(Lieferdaten_LieferantAnlegenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel146)
                    .addComponent(jtfStaat2_LieferantAnlegen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        buttonGroup2.add(jrbLieferadresseidentisch_LieferantAnlegen);
        jrbLieferadresseidentisch_LieferantAnlegen.setText("Lieferadresse identisch");
        jrbLieferadresseidentisch_LieferantAnlegen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbLieferadresseidentisch_LieferantAnlegenActionPerformed(evt);
            }
        });

        buttonGroup2.add(jrbabweichendeLieferadresse_LieferantAnlegen);
        jrbabweichendeLieferadresse_LieferantAnlegen.setText("abweichende Lieferadresse");
        jrbabweichendeLieferadresse_LieferantAnlegen.setToolTipText("");
        jrbabweichendeLieferadresse_LieferantAnlegen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbabweichendeLieferadresse_LieferantAnlegenActionPerformed(evt);
            }
        });

        Kontakt_LieferantAnlegen.setBorder(javax.swing.BorderFactory.createTitledBorder("Kontakt"));

        jLabel137.setText("Telefon:");

        jLabel138.setText("Telefax:");

        jLabel139.setText("E-Mail:");

        javax.swing.GroupLayout Kontakt_LieferantAnlegenLayout = new javax.swing.GroupLayout(Kontakt_LieferantAnlegen);
        Kontakt_LieferantAnlegen.setLayout(Kontakt_LieferantAnlegenLayout);
        Kontakt_LieferantAnlegenLayout.setHorizontalGroup(
            Kontakt_LieferantAnlegenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Kontakt_LieferantAnlegenLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Kontakt_LieferantAnlegenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel137)
                    .addComponent(jLabel139)
                    .addComponent(jLabel138))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addGroup(Kontakt_LieferantAnlegenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jtfTel_LieferantAnlegen, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)
                    .addComponent(jtfFax_LieferantAnlegen)
                    .addComponent(jtfEmail_LieferantAnlegen))
                .addContainerGap())
        );
        Kontakt_LieferantAnlegenLayout.setVerticalGroup(
            Kontakt_LieferantAnlegenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Kontakt_LieferantAnlegenLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Kontakt_LieferantAnlegenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel137)
                    .addComponent(jtfTel_LieferantAnlegen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(Kontakt_LieferantAnlegenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel138)
                    .addComponent(jtfFax_LieferantAnlegen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(Kontakt_LieferantAnlegenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel139)
                    .addComponent(jtfEmail_LieferantAnlegen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout LieferantAnlegenLayout = new javax.swing.GroupLayout(LieferantAnlegen);
        LieferantAnlegen.setLayout(LieferantAnlegenLayout);
        LieferantAnlegenLayout.setHorizontalGroup(
            LieferantAnlegenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LieferantAnlegenLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator17))
            .addGroup(LieferantAnlegenLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(LieferantAnlegenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(LieferantAnlegenLayout.createSequentialGroup()
                        .addGroup(LieferantAnlegenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(LieferantAnlegenLayout.createSequentialGroup()
                                .addGroup(LieferantAnlegenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel75)
                                    .addComponent(jLabel74))
                                .addGap(56, 56, 56)
                                .addGroup(LieferantAnlegenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jtfGPID_LieferantAnlegen, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                                    .addComponent(jtfKreditlimit_LieferantAnlegen)))
                            .addGroup(LieferantAnlegenLayout.createSequentialGroup()
                                .addComponent(jrbLieferadresseidentisch_LieferantAnlegen)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jrbabweichendeLieferadresse_LieferantAnlegen)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(LieferantAnlegenLayout.createSequentialGroup()
                        .addGroup(LieferantAnlegenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(LieferantAnlegenLayout.createSequentialGroup()
                                .addComponent(Kontakt_LieferantAnlegen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Rechnungsdaten_LieferantAnlegen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Lieferdaten_LieferantAnlegen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(LieferantAnlegenLayout.createSequentialGroup()
                                .addComponent(jbSpeichern_LieferantAnlegen, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jbAbbrechen_LieferantAnlegen)))
                        .addContainerGap(136, Short.MAX_VALUE))))
            .addGroup(LieferantAnlegenLayout.createSequentialGroup()
                .addGap(422, 422, 422)
                .addComponent(jLabel11)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        LieferantAnlegenLayout.setVerticalGroup(
            LieferantAnlegenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LieferantAnlegenLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator17, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(LieferantAnlegenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel74)
                    .addComponent(jtfGPID_LieferantAnlegen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(LieferantAnlegenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel75)
                    .addComponent(jtfKreditlimit_LieferantAnlegen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(56, 56, 56)
                .addGroup(LieferantAnlegenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jrbLieferadresseidentisch_LieferantAnlegen)
                    .addComponent(jrbabweichendeLieferadresse_LieferantAnlegen, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(LieferantAnlegenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Kontakt_LieferantAnlegen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Lieferdaten_LieferantAnlegen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Rechnungsdaten_LieferantAnlegen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(LieferantAnlegenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbSpeichern_LieferantAnlegen)
                    .addComponent(jbAbbrechen_LieferantAnlegen))
                .addContainerGap(132, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jifLieferantAnlegenLayout = new javax.swing.GroupLayout(jifLieferantAnlegen.getContentPane());
        jifLieferantAnlegen.getContentPane().setLayout(jifLieferantAnlegenLayout);
        jifLieferantAnlegenLayout.setHorizontalGroup(
            jifLieferantAnlegenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jifLieferantAnlegenLayout.createSequentialGroup()
                .addComponent(LieferantAnlegen, javax.swing.GroupLayout.PREFERRED_SIZE, 1019, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jifLieferantAnlegenLayout.setVerticalGroup(
            jifLieferantAnlegenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jifLieferantAnlegenLayout.createSequentialGroup()
                .addComponent(LieferantAnlegen, javax.swing.GroupLayout.PREFERRED_SIZE, 685, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        desktopPane.add(jifLieferantAnlegen);
        jifLieferantAnlegen.setBounds(0, 0, 1016, 770);

        jifLieferantBearbeiten.setClosable(true);
        jifLieferantBearbeiten.setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        jifLieferantBearbeiten.setMinimumSize(new java.awt.Dimension(76, 40));
        jifLieferantBearbeiten.setNormalBounds(new java.awt.Rectangle(0, 0, 60, 40));
        jifLieferantBearbeiten.setPreferredSize(new java.awt.Dimension(1016, 770));
        jifLieferantBearbeiten.setVisible(false);

        LieferantBearbeiten.setPreferredSize(new java.awt.Dimension(1200, 800));

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel12.setText("Lieferant Bearbeiten");

        jbzurueck_LieferantBearbeiten.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/zurück.png"))); // NOI18N
        jbzurueck_LieferantBearbeiten.setText("Zurück");
        jbzurueck_LieferantBearbeiten.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbzurueck_LieferantBearbeitenActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout LieferantBearbeitenLayout = new javax.swing.GroupLayout(LieferantBearbeiten);
        LieferantBearbeiten.setLayout(LieferantBearbeitenLayout);
        LieferantBearbeitenLayout.setHorizontalGroup(
            LieferantBearbeitenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LieferantBearbeitenLayout.createSequentialGroup()
                .addGroup(LieferantBearbeitenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(LieferantBearbeitenLayout.createSequentialGroup()
                        .addGroup(LieferantBearbeitenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(LieferantBearbeitenLayout.createSequentialGroup()
                                .addGap(356, 356, 356)
                                .addComponent(jbzurueck_LieferantBearbeiten))
                            .addGroup(LieferantBearbeitenLayout.createSequentialGroup()
                                .addGap(346, 346, 346)
                                .addComponent(jLabel12)))
                        .addGap(0, 504, Short.MAX_VALUE))
                    .addComponent(jSeparator18, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        LieferantBearbeitenLayout.setVerticalGroup(
            LieferantBearbeitenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LieferantBearbeitenLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel12)
                .addGap(15, 15, 15)
                .addComponent(jSeparator18, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(165, 165, 165)
                .addComponent(jbzurueck_LieferantBearbeiten)
                .addContainerGap(478, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jifLieferantBearbeitenLayout = new javax.swing.GroupLayout(jifLieferantBearbeiten.getContentPane());
        jifLieferantBearbeiten.getContentPane().setLayout(jifLieferantBearbeitenLayout);
        jifLieferantBearbeitenLayout.setHorizontalGroup(
            jifLieferantBearbeitenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jifLieferantBearbeitenLayout.createSequentialGroup()
                .addComponent(LieferantBearbeiten, javax.swing.GroupLayout.PREFERRED_SIZE, 1017, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jifLieferantBearbeitenLayout.setVerticalGroup(
            jifLieferantBearbeitenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(LieferantBearbeiten, javax.swing.GroupLayout.DEFAULT_SIZE, 741, Short.MAX_VALUE)
        );

        desktopPane.add(jifLieferantBearbeiten);
        jifLieferantBearbeiten.setBounds(0, 0, 1016, 770);

        jifLieferantSuchen.setClosable(true);
        jifLieferantSuchen.setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        jifLieferantSuchen.setMinimumSize(new java.awt.Dimension(76, 40));
        jifLieferantSuchen.setNormalBounds(new java.awt.Rectangle(0, 0, 60, 40));
        jifLieferantSuchen.setPreferredSize(new java.awt.Dimension(1016, 770));
        jifLieferantSuchen.setVisible(false);

        LieferantSuchen.setPreferredSize(new java.awt.Dimension(1200, 800));

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel16.setText("Lieferant Suchen");

        jbAbbrechen_LieferantSuchen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/abbruch2.png"))); // NOI18N
        jbAbbrechen_LieferantSuchen.setText("Abbrechen");
        jbAbbrechen_LieferantSuchen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAbbrechen_LieferantSuchenActionPerformed(evt);
            }
        });

        jbAnzeigen_LieferantSuchen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/anzeigen.png"))); // NOI18N
        jbAnzeigen_LieferantSuchen.setText("Anzeigen");
        jbAnzeigen_LieferantSuchen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAnzeigen_LieferantSuchenActionPerformed(evt);
            }
        });

        jcbSuchkriterium_LieferantSuchen.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ID", "Name", "Vorname", "PLZ", "Typ" }));

        jt_LieferantSuchen.setModel(new javax.swing.table.DefaultTableModel(
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
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Anrede", "Name", "Vorname", "PLZ", "Typ"
            }
        ));
        jScrollPane7.setViewportView(jt_LieferantSuchen);

        javax.swing.GroupLayout LieferantSuchenLayout = new javax.swing.GroupLayout(LieferantSuchen);
        LieferantSuchen.setLayout(LieferantSuchenLayout);
        LieferantSuchenLayout.setHorizontalGroup(
            LieferantSuchenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LieferantSuchenLayout.createSequentialGroup()
                .addGroup(LieferantSuchenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(LieferantSuchenLayout.createSequentialGroup()
                        .addGap(295, 295, 295)
                        .addComponent(jLabel16))
                    .addGroup(LieferantSuchenLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSeparator14, javax.swing.GroupLayout.PREFERRED_SIZE, 998, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(LieferantSuchenLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jcbSuchkriterium_LieferantSuchen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jtfSuchkriterium_LieferantSuchen, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LieferantSuchenLayout.createSequentialGroup()
                .addGroup(LieferantSuchenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(LieferantSuchenLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jbAnzeigen_LieferantSuchen, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jbAbbrechen_LieferantSuchen))
                    .addGroup(LieferantSuchenLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane7)))
                .addGap(347, 347, 347))
        );
        LieferantSuchenLayout.setVerticalGroup(
            LieferantSuchenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LieferantSuchenLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel16)
                .addGap(10, 10, 10)
                .addComponent(jSeparator14, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(LieferantSuchenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcbSuchkriterium_LieferantSuchen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfSuchkriterium_LieferantSuchen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(85, 85, 85)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addGroup(LieferantSuchenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbAnzeigen_LieferantSuchen)
                    .addComponent(jbAbbrechen_LieferantSuchen))
                .addContainerGap(286, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jifLieferantSuchenLayout = new javax.swing.GroupLayout(jifLieferantSuchen.getContentPane());
        jifLieferantSuchen.getContentPane().setLayout(jifLieferantSuchenLayout);
        jifLieferantSuchenLayout.setHorizontalGroup(
            jifLieferantSuchenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jifLieferantSuchenLayout.createSequentialGroup()
                .addComponent(LieferantSuchen, javax.swing.GroupLayout.PREFERRED_SIZE, 999, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 85, Short.MAX_VALUE))
        );
        jifLieferantSuchenLayout.setVerticalGroup(
            jifLieferantSuchenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(LieferantSuchen, javax.swing.GroupLayout.DEFAULT_SIZE, 751, Short.MAX_VALUE)
        );

        desktopPane.add(jifLieferantSuchen);
        jifLieferantSuchen.setBounds(0, 0, 1100, 780);

        jifKundeAnzeigen.setClosable(true);
        jifKundeAnzeigen.setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        jifKundeAnzeigen.setMinimumSize(new java.awt.Dimension(76, 40));
        jifKundeAnzeigen.setNormalBounds(new java.awt.Rectangle(0, 0, 60, 40));
        jifKundeAnzeigen.setPreferredSize(new java.awt.Dimension(1016, 770));
        jifKundeAnzeigen.setVisible(false);

        KundeAnzeigen.setPreferredSize(new java.awt.Dimension(1200, 800));

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel13.setText("Kunde anzeigen");

        zurueck_KundeAnzeigen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/zurück.png"))); // NOI18N
        zurueck_KundeAnzeigen.setText("Zurück");
        zurueck_KundeAnzeigen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                zurueck_KundeAnzeigenActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout KundeAnzeigenLayout = new javax.swing.GroupLayout(KundeAnzeigen);
        KundeAnzeigen.setLayout(KundeAnzeigenLayout);
        KundeAnzeigenLayout.setHorizontalGroup(
            KundeAnzeigenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(KundeAnzeigenLayout.createSequentialGroup()
                .addGap(297, 297, 297)
                .addGroup(KundeAnzeigenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(zurueck_KundeAnzeigen)
                    .addComponent(jLabel13))
                .addContainerGap(596, Short.MAX_VALUE))
            .addGroup(KundeAnzeigenLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator19)
                .addContainerGap())
        );
        KundeAnzeigenLayout.setVerticalGroup(
            KundeAnzeigenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(KundeAnzeigenLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel13)
                .addGap(12, 12, 12)
                .addComponent(jSeparator19, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(191, 191, 191)
                .addComponent(zurueck_KundeAnzeigen)
                .addContainerGap(454, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jifKundeAnzeigenLayout = new javax.swing.GroupLayout(jifKundeAnzeigen.getContentPane());
        jifKundeAnzeigen.getContentPane().setLayout(jifKundeAnzeigenLayout);
        jifKundeAnzeigenLayout.setHorizontalGroup(
            jifKundeAnzeigenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jifKundeAnzeigenLayout.createSequentialGroup()
                .addComponent(KundeAnzeigen, javax.swing.GroupLayout.PREFERRED_SIZE, 1018, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jifKundeAnzeigenLayout.setVerticalGroup(
            jifKundeAnzeigenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(KundeAnzeigen, javax.swing.GroupLayout.DEFAULT_SIZE, 741, Short.MAX_VALUE)
        );

        desktopPane.add(jifKundeAnzeigen);
        jifKundeAnzeigen.setBounds(0, 0, 1016, 770);

        jifKundeAnlegen.setClosable(true);
        jifKundeAnlegen.setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        jifKundeAnlegen.setMinimumSize(new java.awt.Dimension(76, 40));
        jifKundeAnlegen.setNormalBounds(new java.awt.Rectangle(0, 0, 60, 40));
        jifKundeAnlegen.setPreferredSize(new java.awt.Dimension(1016, 770));
        jifKundeAnlegen.setVisible(false);

        KundeAnlegen.setPreferredSize(new java.awt.Dimension(1200, 800));

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel14.setText("Kunde Anlegen");

        abbrechen_KundeAnlegen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/abbruch2.png"))); // NOI18N
        abbrechen_KundeAnlegen.setText("Abbrechen");
        abbrechen_KundeAnlegen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                abbrechen_KundeAnlegenActionPerformed(evt);
            }
        });

        jLabel147.setText("GP-ID:");

        jtfGPID_KundeAnlegen.setToolTipText("");
        jtfGPID_KundeAnlegen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfGPID_KundeAnlegenActionPerformed(evt);
            }
        });

        jLabel148.setText("Kreditlimit:");

        buttonGroup1.add(jrbLieferadresseIdentisch_KundeAnlegen);
        jrbLieferadresseIdentisch_KundeAnlegen.setText("Lieferadresse identisch");
        jrbLieferadresseIdentisch_KundeAnlegen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbLieferadresseIdentisch_KundeAnlegenActionPerformed(evt);
            }
        });

        buttonGroup1.add(jrbAbweichendeLieferadresse_KundeAnlegen);
        jrbAbweichendeLieferadresse_KundeAnlegen.setText("abweichende Lieferadresse");
        jrbAbweichendeLieferadresse_KundeAnlegen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbAbweichendeLieferadresse_KundeAnlegenActionPerformed(evt);
            }
        });

        jPKontakt.setBorder(javax.swing.BorderFactory.createTitledBorder("Kontakt"));

        jLabel149.setText("Telefon:");

        jtfTelefon_KundeAnlegen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfTelefon_KundeAnlegenActionPerformed(evt);
            }
        });

        jLabel150.setText("Telefax:");

        jLabel151.setText("E-Mail:");

        javax.swing.GroupLayout jPKontaktLayout = new javax.swing.GroupLayout(jPKontakt);
        jPKontakt.setLayout(jPKontaktLayout);
        jPKontaktLayout.setHorizontalGroup(
            jPKontaktLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPKontaktLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPKontaktLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel149)
                    .addComponent(jLabel150)
                    .addComponent(jLabel151))
                .addGap(28, 28, 28)
                .addGroup(jPKontaktLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jtfTelefon_KundeAnlegen, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
                    .addComponent(jrfTelefax_KundeAnlegen)
                    .addComponent(jtfEMail_KundeAnlegen))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPKontaktLayout.setVerticalGroup(
            jPKontaktLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPKontaktLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPKontaktLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel149)
                    .addComponent(jtfTelefon_KundeAnlegen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPKontaktLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel150)
                    .addComponent(jrfTelefax_KundeAnlegen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPKontaktLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfEMail_KundeAnlegen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel151))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPRechnungsdaten.setBorder(javax.swing.BorderFactory.createTitledBorder("Rechnungsdaten"));

        jLabel152.setText("Anrede");

        jcbAnredeRG_KundeAnlegen.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-", "Frau ", "Herr" }));

        jLabel153.setText("Name:");

        jLabel154.setText("Vorname:");

        jLabel155.setText("Firma:");

        jLabel156.setText("Straße,HNr. :");

        jLabel157.setText("PLZ, Ort:");

        jtfPlzRG_KundeAnlegen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfPlzRG_KundeAnlegenActionPerformed(evt);
            }
        });

        jtfOrtRG_KundeAnlegen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfOrtRG_KundeAnlegenActionPerformed(evt);
            }
        });

        jLabel158.setText("Staat:");

        javax.swing.GroupLayout jPRechnungsdatenLayout = new javax.swing.GroupLayout(jPRechnungsdaten);
        jPRechnungsdaten.setLayout(jPRechnungsdatenLayout);
        jPRechnungsdatenLayout.setHorizontalGroup(
            jPRechnungsdatenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPRechnungsdatenLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPRechnungsdatenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPRechnungsdatenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPRechnungsdatenLayout.createSequentialGroup()
                            .addGroup(jPRechnungsdatenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel156)
                                .addComponent(jLabel157))
                            .addGroup(jPRechnungsdatenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPRechnungsdatenLayout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jtfHNrRG_KundeAnlegen, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPRechnungsdatenLayout.createSequentialGroup()
                                    .addGap(12, 12, 12)
                                    .addGroup(jPRechnungsdatenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jtfStaatRG_KundeAnlegen)
                                        .addGroup(jPRechnungsdatenLayout.createSequentialGroup()
                                            .addComponent(jtfPlzRG_KundeAnlegen, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                                .addComponent(jcbAnredeRG_KundeAnlegen, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jtfVornameRG_KundeAnlegen)
                                .addComponent(jtfFirmaRG_KundeAnlegen)
                                .addComponent(jtfNameRG_KundeAnlegen, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jtfStraßeRG_KundeAnlegen, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jLabel158))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPRechnungsdatenLayout.setVerticalGroup(
            jPRechnungsdatenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPRechnungsdatenLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPRechnungsdatenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel152)
                    .addComponent(jcbAnredeRG_KundeAnlegen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPRechnungsdatenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel153)
                    .addComponent(jtfNameRG_KundeAnlegen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPRechnungsdatenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtfVornameRG_KundeAnlegen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel154))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPRechnungsdatenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel155)
                    .addComponent(jtfFirmaRG_KundeAnlegen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPRechnungsdatenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel156)
                    .addGroup(jPRechnungsdatenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jtfHNrRG_KundeAnlegen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jtfStraßeRG_KundeAnlegen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPRechnungsdatenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel157)
                    .addGroup(jPRechnungsdatenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jtfPlzRG_KundeAnlegen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jtfOrtRG_KundeAnlegen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPRechnungsdatenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel158)
                    .addComponent(jtfStaatRG_KundeAnlegen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPLieferdaten.setBorder(javax.swing.BorderFactory.createTitledBorder("Lieferdaten"));

        jLabel159.setText("Anrede");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-", "Frau", "Herr" }));

        jLabel160.setText("Name:");

        jLabel161.setText("Vorname:");

        jLabel162.setText("Firma:");

        jtfFirma2_KundeAnlegen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfFirma2_KundeAnlegenActionPerformed(evt);
            }
        });

        jLabel163.setText("Straße, HNr. :");

        jLabel164.setText("PLZ, Ort:");

        jLabel165.setText("Staat:");

        javax.swing.GroupLayout jPLieferdatenLayout = new javax.swing.GroupLayout(jPLieferdaten);
        jPLieferdaten.setLayout(jPLieferdatenLayout);
        jPLieferdatenLayout.setHorizontalGroup(
            jPLieferdatenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPLieferdatenLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPLieferdatenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPLieferdatenLayout.createSequentialGroup()
                        .addGroup(jPLieferdatenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel159)
                            .addComponent(jLabel160)
                            .addComponent(jLabel161)
                            .addComponent(jLabel162))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                        .addGroup(jPLieferdatenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jComboBox1, 0, 190, Short.MAX_VALUE)
                            .addComponent(jtfName2_KundeAnlegen)
                            .addComponent(jtfVorname2_KundeAnlegen)
                            .addComponent(jtfFirma2_KundeAnlegen)))
                    .addGroup(jPLieferdatenLayout.createSequentialGroup()
                        .addGroup(jPLieferdatenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel163)
                            .addComponent(jLabel164)
                            .addComponent(jLabel165))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPLieferdatenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtfStraße2_KundeAnlegen)
                            .addComponent(jtfPlz2_KundeAnlegen)
                            .addComponent(jtfStaat2_KundeAnlegen))))
                .addGap(23, 23, 23))
        );
        jPLieferdatenLayout.setVerticalGroup(
            jPLieferdatenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPLieferdatenLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPLieferdatenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel159)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPLieferdatenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel160)
                    .addComponent(jtfName2_KundeAnlegen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPLieferdatenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel161)
                    .addComponent(jtfVorname2_KundeAnlegen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPLieferdatenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel162)
                    .addComponent(jtfFirma2_KundeAnlegen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPLieferdatenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel163)
                    .addComponent(jtfStraße2_KundeAnlegen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPLieferdatenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel164)
                    .addComponent(jtfPlz2_KundeAnlegen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPLieferdatenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel165)
                    .addComponent(jtfStaat2_KundeAnlegen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(73, Short.MAX_VALUE))
        );

        jbSpeichern.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/speichern2.png"))); // NOI18N
        jbSpeichern.setText("Speichern");

        javax.swing.GroupLayout KundeAnlegenLayout = new javax.swing.GroupLayout(KundeAnlegen);
        KundeAnlegen.setLayout(KundeAnlegenLayout);
        KundeAnlegenLayout.setHorizontalGroup(
            KundeAnlegenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(KundeAnlegenLayout.createSequentialGroup()
                .addGroup(KundeAnlegenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(KundeAnlegenLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSeparator20))
                    .addGroup(KundeAnlegenLayout.createSequentialGroup()
                        .addGroup(KundeAnlegenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(KundeAnlegenLayout.createSequentialGroup()
                                .addGap(0, 724, Short.MAX_VALUE)
                                .addComponent(jbSpeichern, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(abbrechen_KundeAnlegen, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(KundeAnlegenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(KundeAnlegenLayout.createSequentialGroup()
                                    .addGap(311, 311, 311)
                                    .addComponent(jLabel14))
                                .addGroup(KundeAnlegenLayout.createSequentialGroup()
                                    .addGap(21, 21, 21)
                                    .addGroup(KundeAnlegenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(KundeAnlegenLayout.createSequentialGroup()
                                            .addComponent(jrbLieferadresseIdentisch_KundeAnlegen)
                                            .addGap(18, 18, 18)
                                            .addComponent(jrbAbweichendeLieferadresse_KundeAnlegen))
                                        .addGroup(KundeAnlegenLayout.createSequentialGroup()
                                            .addGroup(KundeAnlegenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(jLabel148)
                                                .addComponent(jLabel147))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addGroup(KundeAnlegenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(jtfGPID_KundeAnlegen)
                                                .addComponent(jtfKreditlimit_KundenAnlegen, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)))))
                                .addGroup(KundeAnlegenLayout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(jPKontakt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jPRechnungsdaten, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jPLieferdaten, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 55, Short.MAX_VALUE)))
                .addContainerGap())
        );
        KundeAnlegenLayout.setVerticalGroup(
            KundeAnlegenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(KundeAnlegenLayout.createSequentialGroup()
                .addContainerGap(139, Short.MAX_VALUE)
                .addComponent(jLabel14)
                .addGap(20, 20, 20)
                .addComponent(jSeparator20, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(KundeAnlegenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel147)
                    .addComponent(jtfGPID_KundeAnlegen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(KundeAnlegenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel148)
                    .addComponent(jtfKreditlimit_KundenAnlegen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49)
                .addGroup(KundeAnlegenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jrbLieferadresseIdentisch_KundeAnlegen)
                    .addComponent(jrbAbweichendeLieferadresse_KundeAnlegen))
                .addGap(18, 18, 18)
                .addGroup(KundeAnlegenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPLieferdaten, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPKontakt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPRechnungsdaten, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(28, 28, 28)
                .addGroup(KundeAnlegenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(abbrechen_KundeAnlegen)
                    .addComponent(jbSpeichern)))
        );

        javax.swing.GroupLayout jifKundeAnlegenLayout = new javax.swing.GroupLayout(jifKundeAnlegen.getContentPane());
        jifKundeAnlegen.getContentPane().setLayout(jifKundeAnlegenLayout);
        jifKundeAnlegenLayout.setHorizontalGroup(
            jifKundeAnlegenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jifKundeAnlegenLayout.createSequentialGroup()
                .addComponent(KundeAnlegen, javax.swing.GroupLayout.PREFERRED_SIZE, 1017, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jifKundeAnlegenLayout.setVerticalGroup(
            jifKundeAnlegenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(KundeAnlegen, javax.swing.GroupLayout.DEFAULT_SIZE, 741, Short.MAX_VALUE)
        );

        desktopPane.add(jifKundeAnlegen);
        jifKundeAnlegen.setBounds(0, 0, 1016, 770);

        jifKundeBearbeiten.setClosable(true);
        jifKundeBearbeiten.setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        jifKundeBearbeiten.setMinimumSize(new java.awt.Dimension(76, 40));
        jifKundeBearbeiten.setNormalBounds(new java.awt.Rectangle(0, 0, 60, 40));
        jifKundeBearbeiten.setPreferredSize(new java.awt.Dimension(1016, 770));
        jifKundeBearbeiten.setVisible(false);

        KundeBearbeiten.setPreferredSize(new java.awt.Dimension(1200, 800));

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel15.setText("Kunde bearbeiten");

        zurueck_KundeBearbeiten.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/zurück.png"))); // NOI18N
        zurueck_KundeBearbeiten.setText("Zurück");
        zurueck_KundeBearbeiten.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                zurueck_KundeBearbeitenActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout KundeBearbeitenLayout = new javax.swing.GroupLayout(KundeBearbeiten);
        KundeBearbeiten.setLayout(KundeBearbeitenLayout);
        KundeBearbeitenLayout.setHorizontalGroup(
            KundeBearbeitenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(KundeBearbeitenLayout.createSequentialGroup()
                .addGroup(KundeBearbeitenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(KundeBearbeitenLayout.createSequentialGroup()
                        .addGroup(KundeBearbeitenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(KundeBearbeitenLayout.createSequentialGroup()
                                .addGap(275, 275, 275)
                                .addComponent(zurueck_KundeBearbeiten))
                            .addGroup(KundeBearbeitenLayout.createSequentialGroup()
                                .addGap(283, 283, 283)
                                .addComponent(jLabel15)))
                        .addGap(0, 583, Short.MAX_VALUE))
                    .addComponent(jSeparator21, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        KundeBearbeitenLayout.setVerticalGroup(
            KundeBearbeitenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(KundeBearbeitenLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel15)
                .addGap(12, 12, 12)
                .addComponent(jSeparator21, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(179, 179, 179)
                .addComponent(zurueck_KundeBearbeiten)
                .addContainerGap(467, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jifKundeBearbeitenLayout = new javax.swing.GroupLayout(jifKundeBearbeiten.getContentPane());
        jifKundeBearbeiten.getContentPane().setLayout(jifKundeBearbeitenLayout);
        jifKundeBearbeitenLayout.setHorizontalGroup(
            jifKundeBearbeitenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jifKundeBearbeitenLayout.createSequentialGroup()
                .addComponent(KundeBearbeiten, javax.swing.GroupLayout.PREFERRED_SIZE, 1014, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jifKundeBearbeitenLayout.setVerticalGroup(
            jifKundeBearbeitenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(KundeBearbeiten, javax.swing.GroupLayout.DEFAULT_SIZE, 741, Short.MAX_VALUE)
        );

        desktopPane.add(jifKundeBearbeiten);
        jifKundeBearbeiten.setBounds(0, 0, 1016, 770);

        jifKundeSuchen.setClosable(true);
        jifKundeSuchen.setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        jifKundeSuchen.setMinimumSize(new java.awt.Dimension(76, 40));
        jifKundeSuchen.setNormalBounds(new java.awt.Rectangle(0, 0, 60, 40));
        jifKundeSuchen.setPreferredSize(new java.awt.Dimension(1016, 770));
        jifKundeSuchen.setVisible(false);

        KundeSuchen.setPreferredSize(new java.awt.Dimension(1200, 800));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel9.setText("Kunde Suchen");

        jbAbbrechen_KundeSuchen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/abbruch2.png"))); // NOI18N
        jbAbbrechen_KundeSuchen.setText("Abbrechen");
        jbAbbrechen_KundeSuchen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAbbrechen_KundeSuchenActionPerformed(evt);
            }
        });

        jcbSuchkriterium_KundeSuchen.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ID", "Name", "Vorname", "PLZ", "Typ" }));

        jtfSuchkriterium_KundeSuchen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfSuchkriterium_KundeSuchenActionPerformed(evt);
            }
        });

        jbSuchen_KundeSuchen.setText("Suchen");

        jbAnzeigen_KundeSuchen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/anzeigen.png"))); // NOI18N
        jbAnzeigen_KundeSuchen.setText("Anzeigen");
        jbAnzeigen_KundeSuchen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAnzeigen_KundeSuchenActionPerformed(evt);
            }
        });

        jt_KundeSuchen.setModel(new javax.swing.table.DefaultTableModel(
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
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Anrede", "Name", "Vorname", "PLZ", "Typ"
            }
        ));
        jScrollPane6.setViewportView(jt_KundeSuchen);

        javax.swing.GroupLayout KundeSuchenLayout = new javax.swing.GroupLayout(KundeSuchen);
        KundeSuchen.setLayout(KundeSuchenLayout);
        KundeSuchenLayout.setHorizontalGroup(
            KundeSuchenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(KundeSuchenLayout.createSequentialGroup()
                .addGroup(KundeSuchenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator15)
                    .addGroup(KundeSuchenLayout.createSequentialGroup()
                        .addGroup(KundeSuchenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(KundeSuchenLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jbAnzeigen_KundeSuchen, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jbAbbrechen_KundeSuchen))
                            .addGroup(KundeSuchenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(KundeSuchenLayout.createSequentialGroup()
                                    .addGap(375, 375, 375)
                                    .addComponent(jLabel9))
                                .addGroup(KundeSuchenLayout.createSequentialGroup()
                                    .addGap(55, 55, 55)
                                    .addComponent(jcbSuchkriterium_KundeSuchen, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jtfSuchkriterium_KundeSuchen, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(44, 44, 44)
                                    .addComponent(jbSuchen_KundeSuchen, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(KundeSuchenLayout.createSequentialGroup()
                                    .addGap(44, 44, 44)
                                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 730, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 235, Short.MAX_VALUE)))
                .addContainerGap())
        );
        KundeSuchenLayout.setVerticalGroup(
            KundeSuchenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(KundeSuchenLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel9)
                .addGap(11, 11, 11)
                .addComponent(jSeparator15, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(KundeSuchenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcbSuchkriterium_KundeSuchen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfSuchkriterium_KundeSuchen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbSuchen_KundeSuchen))
                .addGap(65, 65, 65)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addGroup(KundeSuchenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbAnzeigen_KundeSuchen)
                    .addComponent(jbAbbrechen_KundeSuchen))
                .addContainerGap(264, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jifKundeSuchenLayout = new javax.swing.GroupLayout(jifKundeSuchen.getContentPane());
        jifKundeSuchen.getContentPane().setLayout(jifKundeSuchenLayout);
        jifKundeSuchenLayout.setHorizontalGroup(
            jifKundeSuchenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jifKundeSuchenLayout.createSequentialGroup()
                .addComponent(KundeSuchen, javax.swing.GroupLayout.PREFERRED_SIZE, 1019, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jifKundeSuchenLayout.setVerticalGroup(
            jifKundeSuchenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(KundeSuchen, javax.swing.GroupLayout.DEFAULT_SIZE, 741, Short.MAX_VALUE)
        );

        desktopPane.add(jifKundeSuchen);
        jifKundeSuchen.setBounds(0, 0, 1016, 770);

        jifZKAnzeigen.setClosable(true);
        jifZKAnzeigen.setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        jifZKAnzeigen.setMinimumSize(new java.awt.Dimension(76, 40));
        jifZKAnzeigen.setNormalBounds(new java.awt.Rectangle(0, 0, 60, 40));
        jifZKAnzeigen.setPreferredSize(new java.awt.Dimension(1016, 770));
        jifZKAnzeigen.setVisible(false);

        ZKAnzeigen.setPreferredSize(new java.awt.Dimension(1200, 800));

        jLabel77.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel77.setText("Zahlungskonditionen Anzeigen");

        jbAbbrechen_ZKAnzeigen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/abbruch2.png"))); // NOI18N
        jbAbbrechen_ZKAnzeigen.setText("Abbrechen");
        jbAbbrechen_ZKAnzeigen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAbbrechen_ZKAnzeigenActionPerformed(evt);
            }
        });

        jbBearbeiten_ZKAnzeigen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/bearbeiten1.png"))); // NOI18N
        jbBearbeiten_ZKAnzeigen.setText("Bearbeiten");
        jbBearbeiten_ZKAnzeigen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBearbeiten_ZKAnzeigenActionPerformed(evt);
            }
        });

        jbSpeichern_ZKAnzeigen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/speichern2.png"))); // NOI18N
        jbSpeichern_ZKAnzeigen.setText("Speichern");

        jLabel81.setText("ZK-ID:");

        jLabel82.setText("Auftragsart:");

        jcbAuftragsart_ZKAnzeigen.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Barauftrag", "Sofortauftrag", "Terminauftrag", "Bestellauftrag" }));

        jLabel83.setText("Lieferzeit-Sofort:");

        jLabel84.setText("Sperrzeit-Wunsch:");
        jLabel84.setToolTipText("");

        Skonto_ZKAnzeigen.setBorder(javax.swing.BorderFactory.createTitledBorder("Skonto"));

        jLabel85.setText("Skontofrist 1:");

        jLabel86.setText("Skontofrist 2:");

        jLabel92.setText("Skontosatz 1:");

        jLabel93.setText("Skontosatz 2:");

        jSeparator24.setBackground(new java.awt.Color(200, 200, 200));
        jSeparator24.setForeground(new java.awt.Color(190, 190, 190));

        jLabel112.setText("Tage");

        jLabel113.setText("Tage");

        jLabel114.setText("%");

        jLabel115.setText("%");

        javax.swing.GroupLayout Skonto_ZKAnzeigenLayout = new javax.swing.GroupLayout(Skonto_ZKAnzeigen);
        Skonto_ZKAnzeigen.setLayout(Skonto_ZKAnzeigenLayout);
        Skonto_ZKAnzeigenLayout.setHorizontalGroup(
            Skonto_ZKAnzeigenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Skonto_ZKAnzeigenLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Skonto_ZKAnzeigenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel85)
                    .addComponent(jLabel86)
                    .addComponent(jLabel92)
                    .addComponent(jLabel93))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
                .addGroup(Skonto_ZKAnzeigenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Skonto_ZKAnzeigenLayout.createSequentialGroup()
                        .addGroup(Skonto_ZKAnzeigenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jtfSkontofrist2_ZKAnzeigen, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
                            .addComponent(jtfSkontofrist1_ZKAnzeigen))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(Skonto_ZKAnzeigenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel112)
                            .addComponent(jLabel113)))
                    .addGroup(Skonto_ZKAnzeigenLayout.createSequentialGroup()
                        .addComponent(jtfSkontosatz1_ZKAnzeigen, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel114))
                    .addGroup(Skonto_ZKAnzeigenLayout.createSequentialGroup()
                        .addComponent(jtfSkontosatz2_ZKAnzeigen, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel115)))
                .addContainerGap())
            .addComponent(jSeparator24)
        );
        Skonto_ZKAnzeigenLayout.setVerticalGroup(
            Skonto_ZKAnzeigenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Skonto_ZKAnzeigenLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(Skonto_ZKAnzeigenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel85)
                    .addComponent(jtfSkontofrist1_ZKAnzeigen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel112))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(Skonto_ZKAnzeigenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfSkontofrist2_ZKAnzeigen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel86)
                    .addComponent(jLabel113))
                .addGap(18, 18, 18)
                .addComponent(jSeparator24, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addGroup(Skonto_ZKAnzeigenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel92)
                    .addComponent(jtfSkontosatz1_ZKAnzeigen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel114))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(Skonto_ZKAnzeigenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel93)
                    .addComponent(jtfSkontosatz2_ZKAnzeigen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel115))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        Mahnzeit_ZKAnzeigen.setBorder(javax.swing.BorderFactory.createTitledBorder("Mahnzeit"));

        jLabel94.setText("Mahnzeit 1:");
        jLabel94.setToolTipText("");

        jLabel95.setText("Mahnzeit 2:");

        jLabel96.setText("Mahnzeit 3:");

        jtfMahnzeit2_ZKAnzeigen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfMahnzeit2_ZKAnzeigenActionPerformed(evt);
            }
        });

        jtfMahnzeit1_ZKAnzeigen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfMahnzeit1_ZKAnzeigenActionPerformed(evt);
            }
        });

        jLabel116.setText("Tage");

        jLabel117.setText("Tage");

        jLabel118.setText("Tage");

        javax.swing.GroupLayout Mahnzeit_ZKAnzeigenLayout = new javax.swing.GroupLayout(Mahnzeit_ZKAnzeigen);
        Mahnzeit_ZKAnzeigen.setLayout(Mahnzeit_ZKAnzeigenLayout);
        Mahnzeit_ZKAnzeigenLayout.setHorizontalGroup(
            Mahnzeit_ZKAnzeigenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Mahnzeit_ZKAnzeigenLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Mahnzeit_ZKAnzeigenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel94)
                    .addComponent(jLabel95)
                    .addComponent(jLabel96))
                .addGap(75, 75, 75)
                .addGroup(Mahnzeit_ZKAnzeigenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Mahnzeit_ZKAnzeigenLayout.createSequentialGroup()
                        .addComponent(jtfMahnzeit2_ZKAnzeigen, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel117))
                    .addGroup(Mahnzeit_ZKAnzeigenLayout.createSequentialGroup()
                        .addComponent(jtfMahnzeit1_ZKAnzeigen, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel116))
                    .addGroup(Mahnzeit_ZKAnzeigenLayout.createSequentialGroup()
                        .addComponent(jtfMahnzeit3_ZKAnzeigen, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel118)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        Mahnzeit_ZKAnzeigenLayout.setVerticalGroup(
            Mahnzeit_ZKAnzeigenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Mahnzeit_ZKAnzeigenLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Mahnzeit_ZKAnzeigenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel94)
                    .addComponent(jtfMahnzeit1_ZKAnzeigen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel116))
                .addGap(18, 18, 18)
                .addGroup(Mahnzeit_ZKAnzeigenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel95)
                    .addComponent(jtfMahnzeit2_ZKAnzeigen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel117))
                .addGap(18, 18, 18)
                .addGroup(Mahnzeit_ZKAnzeigenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel96)
                    .addComponent(jtfMahnzeit3_ZKAnzeigen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel118))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jbLupe_ZKAnzeigen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/lupe.png"))); // NOI18N
        jbLupe_ZKAnzeigen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbLupe_ZKAnzeigenActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ZKAnzeigenLayout = new javax.swing.GroupLayout(ZKAnzeigen);
        ZKAnzeigen.setLayout(ZKAnzeigenLayout);
        ZKAnzeigenLayout.setHorizontalGroup(
            ZKAnzeigenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator28)
            .addGroup(ZKAnzeigenLayout.createSequentialGroup()
                .addGroup(ZKAnzeigenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ZKAnzeigenLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(ZKAnzeigenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(ZKAnzeigenLayout.createSequentialGroup()
                                .addComponent(jbSpeichern_ZKAnzeigen)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jbBearbeiten_ZKAnzeigen)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jbAbbrechen_ZKAnzeigen))
                            .addGroup(ZKAnzeigenLayout.createSequentialGroup()
                                .addGroup(ZKAnzeigenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ZKAnzeigenLayout.createSequentialGroup()
                                        .addComponent(Skonto_ZKAnzeigen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(45, 45, 45))
                                    .addGroup(ZKAnzeigenLayout.createSequentialGroup()
                                        .addGap(15, 15, 15)
                                        .addGroup(ZKAnzeigenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel81)
                                            .addComponent(jLabel83))
                                        .addGap(48, 48, 48)
                                        .addGroup(ZKAnzeigenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(ZKAnzeigenLayout.createSequentialGroup()
                                                .addComponent(jtfZKID_ZKAnzeigen, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jbLupe_ZKAnzeigen, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(jtfLieferzeitSofort_ZKAnzeigen, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 82, Short.MAX_VALUE)))
                                .addGroup(ZKAnzeigenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(ZKAnzeigenLayout.createSequentialGroup()
                                        .addGroup(ZKAnzeigenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel84)
                                            .addComponent(jLabel82))
                                        .addGap(40, 40, 40)
                                        .addGroup(ZKAnzeigenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jtfSperrzeitWunsch_ZKAnzeigen, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jcbAuftragsart_ZKAnzeigen, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(Mahnzeit_ZKAnzeigen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(ZKAnzeigenLayout.createSequentialGroup()
                        .addGap(361, 361, 361)
                        .addComponent(jLabel77)))
                .addContainerGap(253, Short.MAX_VALUE))
        );
        ZKAnzeigenLayout.setVerticalGroup(
            ZKAnzeigenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ZKAnzeigenLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel77)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator28, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(ZKAnzeigenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel83)
                    .addComponent(jbLupe_ZKAnzeigen)
                    .addGroup(ZKAnzeigenLayout.createSequentialGroup()
                        .addGroup(ZKAnzeigenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtfZKID_ZKAnzeigen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel81))
                        .addGap(18, 18, 18)
                        .addComponent(jtfLieferzeitSofort_ZKAnzeigen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(ZKAnzeigenLayout.createSequentialGroup()
                        .addGroup(ZKAnzeigenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel82)
                            .addComponent(jcbAuftragsart_ZKAnzeigen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(ZKAnzeigenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel84)
                            .addComponent(jtfSperrzeitWunsch_ZKAnzeigen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(72, 72, 72)
                .addGroup(ZKAnzeigenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Skonto_ZKAnzeigen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Mahnzeit_ZKAnzeigen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(19, 19, 19)
                .addGroup(ZKAnzeigenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbSpeichern_ZKAnzeigen)
                    .addComponent(jbAbbrechen_ZKAnzeigen)
                    .addComponent(jbBearbeiten_ZKAnzeigen))
                .addContainerGap(259, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jifZKAnzeigenLayout = new javax.swing.GroupLayout(jifZKAnzeigen.getContentPane());
        jifZKAnzeigen.getContentPane().setLayout(jifZKAnzeigenLayout);
        jifZKAnzeigenLayout.setHorizontalGroup(
            jifZKAnzeigenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jifZKAnzeigenLayout.createSequentialGroup()
                .addComponent(ZKAnzeigen, javax.swing.GroupLayout.PREFERRED_SIZE, 1018, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jifZKAnzeigenLayout.setVerticalGroup(
            jifZKAnzeigenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ZKAnzeigen, javax.swing.GroupLayout.DEFAULT_SIZE, 741, Short.MAX_VALUE)
        );

        desktopPane.add(jifZKAnzeigen);
        jifZKAnzeigen.setBounds(0, 0, 1016, 770);

        jifZKAnlegen.setClosable(true);
        jifZKAnlegen.setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        jifZKAnlegen.setMinimumSize(new java.awt.Dimension(76, 40));
        jifZKAnlegen.setNormalBounds(new java.awt.Rectangle(0, 0, 60, 40));
        jifZKAnlegen.setPreferredSize(new java.awt.Dimension(1016, 770));
        jifZKAnlegen.setVisible(false);

        ZKAnlegen.setPreferredSize(new java.awt.Dimension(1200, 800));

        jLabel78.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel78.setText("Zahlungskonditionen Anlegen");

        jbAbbrechen_ZKAnlegen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/abbruch2.png"))); // NOI18N
        jbAbbrechen_ZKAnlegen.setText("Abbrechen");
        jbAbbrechen_ZKAnlegen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAbbrechen_ZKAnlegenActionPerformed(evt);
            }
        });

        jbSpeichern_ZKAnlegen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/speichern2.png"))); // NOI18N
        jbSpeichern_ZKAnlegen.setText("Speichern");
        jbSpeichern_ZKAnlegen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSpeichern_ZKAnlegenActionPerformed(evt);
            }
        });

        jLabel97.setText("ZK-ID:");

        jLabel98.setText("Auftragsart:");

        jLabel99.setText("Lieferzeit-Sofort:");

        jLabel100.setText("Sperrzeit-Wunsch:");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Skonto"));

        jLabel101.setText("Skontofrist 1:");

        jLabel102.setText("Skontofrist 2:");

        jLabel103.setText("Skontosatz 1:");

        jLabel104.setText("Skontosatz 2:");

        jLabel108.setText("Tage");

        jLabel109.setText("Tage");

        jLabel110.setText("%");

        jLabel111.setText("%");

        jSeparator29.setBackground(new java.awt.Color(200, 200, 200));
        jSeparator29.setForeground(new java.awt.Color(190, 190, 190));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel101)
                    .addComponent(jLabel102)
                    .addComponent(jLabel103)
                    .addComponent(jLabel104))
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jtfSkontosatz1_ZKAnlegen)
                    .addComponent(jtfSkontofrist1_ZKAnlegen)
                    .addComponent(jtfSkontofrist2_ZKAnlegen)
                    .addComponent(jtfSkontosatz2_ZKAnlegen, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel108)
                    .addComponent(jLabel109)
                    .addComponent(jLabel110)
                    .addComponent(jLabel111))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jSeparator29)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel101)
                    .addComponent(jtfSkontofrist1_ZKAnlegen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel108))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel102)
                    .addComponent(jtfSkontofrist2_ZKAnlegen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel109))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator29, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel103)
                    .addComponent(jtfSkontosatz1_ZKAnlegen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel110))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel104)
                    .addComponent(jtfSkontosatz2_ZKAnlegen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel111))
                .addContainerGap(45, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Mahnzeit"));

        jLabel105.setText("Mahnzeit 1:");

        jLabel106.setText("Mahnzeit 2:");

        jLabel107.setText("Mahnzeit 3:");

        jLabel119.setText("Tage");

        jLabel120.setText("Tage");

        jLabel121.setText("Tage");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel105)
                    .addComponent(jLabel106)
                    .addComponent(jLabel107))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jtfMahnzeit1_ZKAnlegen)
                    .addComponent(jtfMahnzeit2_ZKAnlegen)
                    .addComponent(jtfMahnzeit3_ZKAnlegen, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel119)
                    .addComponent(jLabel120)
                    .addComponent(jLabel121))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel105)
                    .addComponent(jtfMahnzeit1_ZKAnlegen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel119))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel106)
                    .addComponent(jtfMahnzeit2_ZKAnlegen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel120))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel107)
                    .addComponent(jtfMahnzeit3_ZKAnlegen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel121))
                .addContainerGap(111, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout ZKAnlegenLayout = new javax.swing.GroupLayout(ZKAnlegen);
        ZKAnlegen.setLayout(ZKAnlegenLayout);
        ZKAnlegenLayout.setHorizontalGroup(
            ZKAnlegenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator25)
            .addGroup(ZKAnlegenLayout.createSequentialGroup()
                .addGroup(ZKAnlegenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ZKAnlegenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(ZKAnlegenLayout.createSequentialGroup()
                            .addGroup(ZKAnlegenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(ZKAnlegenLayout.createSequentialGroup()
                                    .addGap(39, 39, 39)
                                    .addGroup(ZKAnlegenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel97)
                                        .addComponent(jLabel99))
                                    .addGap(18, 18, 18)
                                    .addGroup(ZKAnlegenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jtfLieferzeitSofort_ZKAnlegen, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jtfZKID_ZKAnlegen, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(ZKAnlegenLayout.createSequentialGroup()
                                    .addGap(24, 24, 24)
                                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(ZKAnlegenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(ZKAnlegenLayout.createSequentialGroup()
                                    .addGap(46, 46, 46)
                                    .addGroup(ZKAnlegenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(ZKAnlegenLayout.createSequentialGroup()
                                            .addComponent(jLabel100)
                                            .addGap(26, 26, 26)
                                            .addComponent(jtfSperrzeitWunsch_ZKAnlegen, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(ZKAnlegenLayout.createSequentialGroup()
                                            .addComponent(jLabel98)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jtfAuftragsart_ZKAnlegen, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGroup(ZKAnlegenLayout.createSequentialGroup()
                                    .addGap(32, 32, 32)
                                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(ZKAnlegenLayout.createSequentialGroup()
                            .addComponent(jbSpeichern_ZKAnlegen, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jbAbbrechen_ZKAnlegen)))
                    .addGroup(ZKAnlegenLayout.createSequentialGroup()
                        .addGap(281, 281, 281)
                        .addComponent(jLabel78)))
                .addContainerGap(306, Short.MAX_VALUE))
        );
        ZKAnlegenLayout.setVerticalGroup(
            ZKAnlegenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ZKAnlegenLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel78)
                .addGap(18, 18, 18)
                .addComponent(jSeparator25, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addGroup(ZKAnlegenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel97)
                    .addComponent(jtfZKID_ZKAnlegen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel98)
                    .addComponent(jtfAuftragsart_ZKAnlegen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(ZKAnlegenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel99)
                    .addComponent(jtfLieferzeitSofort_ZKAnlegen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel100)
                    .addComponent(jtfSperrzeitWunsch_ZKAnlegen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(79, 79, 79)
                .addGroup(ZKAnlegenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(ZKAnlegenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbSpeichern_ZKAnlegen)
                    .addComponent(jbAbbrechen_ZKAnlegen))
                .addContainerGap(217, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jifZKAnlegenLayout = new javax.swing.GroupLayout(jifZKAnlegen.getContentPane());
        jifZKAnlegen.getContentPane().setLayout(jifZKAnlegenLayout);
        jifZKAnlegenLayout.setHorizontalGroup(
            jifZKAnlegenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jifZKAnlegenLayout.createSequentialGroup()
                .addComponent(ZKAnlegen, javax.swing.GroupLayout.PREFERRED_SIZE, 1020, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jifZKAnlegenLayout.setVerticalGroup(
            jifZKAnlegenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ZKAnlegen, javax.swing.GroupLayout.DEFAULT_SIZE, 741, Short.MAX_VALUE)
        );

        desktopPane.add(jifZKAnlegen);
        jifZKAnlegen.setBounds(0, 0, 1016, 770);

        jifZKBearbeiten.setClosable(true);
        jifZKBearbeiten.setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        jifZKBearbeiten.setMinimumSize(new java.awt.Dimension(76, 40));
        jifZKBearbeiten.setNormalBounds(new java.awt.Rectangle(0, 0, 60, 40));
        jifZKBearbeiten.setPreferredSize(new java.awt.Dimension(1016, 770));
        jifZKBearbeiten.setVisible(false);

        ZKBearbeiten.setMaximumSize(new java.awt.Dimension(2000, 2000));
        ZKBearbeiten.setMinimumSize(new java.awt.Dimension(500, 500));
        ZKBearbeiten.setPreferredSize(new java.awt.Dimension(1200, 800));

        jLabel76.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel76.setText("Zahlungskonditionen Bearbeiten");

        jbAbbrechen_ZKBearbeiten.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/abbruch2.png"))); // NOI18N
        jbAbbrechen_ZKBearbeiten.setText("Abbrechen");
        jbAbbrechen_ZKBearbeiten.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAbbrechen_ZKBearbeitenActionPerformed(evt);
            }
        });

        jbBearbeiten_ZKBearbeiten.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/bearbeiten1.png"))); // NOI18N
        jbBearbeiten_ZKBearbeiten.setText("Bearbeiten");
        jbBearbeiten_ZKBearbeiten.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBearbeiten_ZKBearbeitenActionPerformed(evt);
            }
        });

        jLabel124.setText("ZK-ID:");

        javax.swing.GroupLayout ZKBearbeitenLayout = new javax.swing.GroupLayout(ZKBearbeiten);
        ZKBearbeiten.setLayout(ZKBearbeitenLayout);
        ZKBearbeitenLayout.setHorizontalGroup(
            ZKBearbeitenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator22)
            .addGroup(ZKBearbeitenLayout.createSequentialGroup()
                .addGroup(ZKBearbeitenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ZKBearbeitenLayout.createSequentialGroup()
                        .addGap(297, 297, 297)
                        .addComponent(jLabel76))
                    .addGroup(ZKBearbeitenLayout.createSequentialGroup()
                        .addGap(289, 289, 289)
                        .addGroup(ZKBearbeitenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(ZKBearbeitenLayout.createSequentialGroup()
                                .addComponent(jLabel124)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jtfZKID_ZKBearbeiten, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(ZKBearbeitenLayout.createSequentialGroup()
                                .addComponent(jbBearbeiten_ZKBearbeiten)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jbAbbrechen_ZKBearbeiten)))))
                .addContainerGap(470, Short.MAX_VALUE))
        );
        ZKBearbeitenLayout.setVerticalGroup(
            ZKBearbeitenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ZKBearbeitenLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel76)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator22, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(ZKBearbeitenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel124)
                    .addComponent(jtfZKID_ZKBearbeiten, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(ZKBearbeitenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbBearbeiten_ZKBearbeiten)
                    .addComponent(jbAbbrechen_ZKBearbeiten))
                .addContainerGap(595, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jifZKBearbeitenLayout = new javax.swing.GroupLayout(jifZKBearbeiten.getContentPane());
        jifZKBearbeiten.getContentPane().setLayout(jifZKBearbeitenLayout);
        jifZKBearbeitenLayout.setHorizontalGroup(
            jifZKBearbeitenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jifZKBearbeitenLayout.createSequentialGroup()
                .addComponent(ZKBearbeiten, javax.swing.GroupLayout.PREFERRED_SIZE, 1019, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jifZKBearbeitenLayout.setVerticalGroup(
            jifZKBearbeitenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ZKBearbeiten, javax.swing.GroupLayout.DEFAULT_SIZE, 741, Short.MAX_VALUE)
        );

        desktopPane.add(jifZKBearbeiten);
        jifZKBearbeiten.setBounds(0, 0, 1016, 770);

        jifZKSuchen.setClosable(true);
        jifZKSuchen.setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        jifZKSuchen.setMinimumSize(new java.awt.Dimension(76, 40));
        jifZKSuchen.setNormalBounds(new java.awt.Rectangle(0, 0, 60, 40));
        jifZKSuchen.setPreferredSize(new java.awt.Dimension(1016, 770));
        jifZKSuchen.setVisible(false);

        ZKSuchen.setPreferredSize(new java.awt.Dimension(1200, 800));
        ZKSuchen.setRequestFocusEnabled(false);

        jbAbbrechen_ZKSuchen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/abbruch2.png"))); // NOI18N
        jbAbbrechen_ZKSuchen.setText("Abbrechen");
        jbAbbrechen_ZKSuchen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAbbrechen_ZKSuchenActionPerformed(evt);
            }
        });

        jbAnzeigen_ZKSuchen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/anzeigen.png"))); // NOI18N
        jbAnzeigen_ZKSuchen.setText("Anzeigen");
        jbAnzeigen_ZKSuchen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAnzeigen_ZKSuchenActionPerformed(evt);
            }
        });

        jbSuchen_ZKSuchen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/lupe.png"))); // NOI18N
        jbSuchen_ZKSuchen.setText("Suchen");

        jLabel79.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel79.setText("Zahlungskonditionen Suchen");

        jLabel125.setText("Auftragsart:");

        jcbSuchkriterium_ZKSuchen.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ZK-ID", "Skontosatz 1", "Skontofrist 1", "Mahnzeit 1" }));

        jcbAuftragsart_ZKSuchen.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Sofortauftrag", "Barauftrag", "Terminauftrag", "Bestellauftrag" }));

        jt_ZKSuchen.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ZK-ID", "Auftragsart", "Skontosatz 1", "Skontofrist 1", "Mahnzeit 1"
            }
        ));
        jScrollPane9.setViewportView(jt_ZKSuchen);

        javax.swing.GroupLayout ZKSuchenLayout = new javax.swing.GroupLayout(ZKSuchen);
        ZKSuchen.setLayout(ZKSuchenLayout);
        ZKSuchenLayout.setHorizontalGroup(
            ZKSuchenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator26)
            .addGroup(ZKSuchenLayout.createSequentialGroup()
                .addGroup(ZKSuchenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ZKSuchenLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(ZKSuchenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(ZKSuchenLayout.createSequentialGroup()
                                .addGap(448, 448, 448)
                                .addComponent(jbAnzeigen_ZKSuchen)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jbAbbrechen_ZKSuchen))
                            .addGroup(ZKSuchenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 672, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(ZKSuchenLayout.createSequentialGroup()
                                    .addGroup(ZKSuchenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel125)
                                        .addComponent(jcbSuchkriterium_ZKSuchen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(25, 25, 25)
                                    .addGroup(ZKSuchenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jtfSuchkriterium_ZKSuchen)
                                        .addComponent(jcbAuftragsart_ZKSuchen, 0, 150, Short.MAX_VALUE))
                                    .addGap(52, 52, 52)
                                    .addComponent(jbSuchen_ZKSuchen, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(ZKSuchenLayout.createSequentialGroup()
                        .addGap(241, 241, 241)
                        .addComponent(jLabel79)))
                .addGap(0, 322, Short.MAX_VALUE))
        );
        ZKSuchenLayout.setVerticalGroup(
            ZKSuchenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ZKSuchenLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel79)
                .addGap(16, 16, 16)
                .addComponent(jSeparator26, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ZKSuchenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel125)
                    .addComponent(jcbAuftragsart_ZKSuchen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(ZKSuchenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcbSuchkriterium_ZKSuchen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfSuchkriterium_ZKSuchen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbSuchen_ZKSuchen))
                .addGap(30, 30, 30)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(ZKSuchenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbAbbrechen_ZKSuchen)
                    .addComponent(jbAnzeigen_ZKSuchen))
                .addContainerGap(270, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jifZKSuchenLayout = new javax.swing.GroupLayout(jifZKSuchen.getContentPane());
        jifZKSuchen.getContentPane().setLayout(jifZKSuchenLayout);
        jifZKSuchenLayout.setHorizontalGroup(
            jifZKSuchenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jifZKSuchenLayout.createSequentialGroup()
                .addComponent(ZKSuchen, javax.swing.GroupLayout.PREFERRED_SIZE, 1014, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jifZKSuchenLayout.setVerticalGroup(
            jifZKSuchenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ZKSuchen, javax.swing.GroupLayout.DEFAULT_SIZE, 741, Short.MAX_VALUE)
        );

        desktopPane.add(jifZKSuchen);
        jifZKSuchen.setBounds(0, 0, 1016, 770);

        jifZKID_suchen.setClosable(true);
        jifZKID_suchen.setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        jifZKID_suchen.setVisible(false);

        ZKID_suchen.setPreferredSize(new java.awt.Dimension(1200, 800));

        jLabel80.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel80.setText("Zahlungskondition-ID Suchen");

        jbAbbrechen_ZKIDSuchen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/abbruch2.png"))); // NOI18N
        jbAbbrechen_ZKIDSuchen.setText("Abbrechen");
        jbAbbrechen_ZKIDSuchen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAbbrechen_ZKIDSuchenActionPerformed(evt);
            }
        });

        jbAnzeigen_ZKIDSuchen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/anzeigen.png"))); // NOI18N
        jbAnzeigen_ZKIDSuchen.setText("Anzeigen");
        jbAnzeigen_ZKIDSuchen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAnzeigen_ZKIDSuchenActionPerformed(evt);
            }
        });

        jLabel126.setText("Lieferzeit-Sofort:");

        jLabel127.setText("Lieferzeit-Wunsch:");

        jLabel128.setText("Skontozeit 1:");

        jLabel129.setText("Mahnzeit:");

        javax.swing.GroupLayout ZKID_suchenLayout = new javax.swing.GroupLayout(ZKID_suchen);
        ZKID_suchen.setLayout(ZKID_suchenLayout);
        ZKID_suchenLayout.setHorizontalGroup(
            ZKID_suchenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator27)
            .addGroup(ZKID_suchenLayout.createSequentialGroup()
                .addGroup(ZKID_suchenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ZKID_suchenLayout.createSequentialGroup()
                        .addGap(79, 79, 79)
                        .addGroup(ZKID_suchenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(ZKID_suchenLayout.createSequentialGroup()
                                .addGroup(ZKID_suchenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel126)
                                    .addComponent(jLabel127))
                                .addGap(28, 28, 28)
                                .addGroup(ZKID_suchenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jtfLieferzeitSofort_ZKIDSuchen, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                                    .addComponent(jtfLieferzeitWunsch_ZKIDSuchen))
                                .addGap(99, 99, 99)
                                .addGroup(ZKID_suchenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel128)
                                    .addComponent(jLabel129))
                                .addGap(31, 31, 31)
                                .addGroup(ZKID_suchenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jtfSkontozeit1_ZKIDSuchen, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                                    .addComponent(jtfMahnzeit1_ZKIDSuchen)))
                            .addGroup(ZKID_suchenLayout.createSequentialGroup()
                                .addComponent(jbAnzeigen_ZKIDSuchen)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jbAbbrechen_ZKIDSuchen)
                                .addGap(1, 1, 1))))
                    .addGroup(ZKID_suchenLayout.createSequentialGroup()
                        .addGap(301, 301, 301)
                        .addComponent(jLabel80)))
                .addContainerGap(327, Short.MAX_VALUE))
        );
        ZKID_suchenLayout.setVerticalGroup(
            ZKID_suchenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ZKID_suchenLayout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jLabel80)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator27, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(ZKID_suchenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel126)
                    .addComponent(jtfLieferzeitSofort_ZKIDSuchen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel128)
                    .addComponent(jtfSkontozeit1_ZKIDSuchen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(ZKID_suchenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel127)
                    .addComponent(jtfLieferzeitWunsch_ZKIDSuchen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel129)
                    .addComponent(jtfMahnzeit1_ZKIDSuchen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(ZKID_suchenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbAnzeigen_ZKIDSuchen)
                    .addComponent(jbAbbrechen_ZKIDSuchen))
                .addContainerGap(494, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jifZKID_suchenLayout = new javax.swing.GroupLayout(jifZKID_suchen.getContentPane());
        jifZKID_suchen.getContentPane().setLayout(jifZKID_suchenLayout);
        jifZKID_suchenLayout.setHorizontalGroup(
            jifZKID_suchenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jifZKID_suchenLayout.createSequentialGroup()
                .addComponent(ZKID_suchen, javax.swing.GroupLayout.PREFERRED_SIZE, 1017, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jifZKID_suchenLayout.setVerticalGroup(
            jifZKID_suchenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ZKID_suchen, javax.swing.GroupLayout.DEFAULT_SIZE, 692, Short.MAX_VALUE)
        );

        desktopPane.add(jifZKID_suchen);
        jifZKID_suchen.setBounds(0, 0, 1033, 721);

        jmDatei.setMnemonic('f');
        jmDatei.setText("Datei");
        jmDatei.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmDateiActionPerformed(evt);
            }
        });

        miAbmelden.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F5, 0));
        miAbmelden.setMnemonic('o');
        miAbmelden.setText("Abmelden");
        miAbmelden.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miAbmeldenActionPerformed(evt);
            }
        });
        jmDatei.add(miAbmelden);

        miBeenden.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ESCAPE, 0));
        miBeenden.setMnemonic('x');
        miBeenden.setText("Beenden");
        miBeenden.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miBeendenActionPerformed(evt);
            }
        });
        jmDatei.add(miBeenden);

        menuBar.add(jmDatei);

        jmAuftrag.setMnemonic('e');
        jmAuftrag.setText("Auftrag");
        jmAuftrag.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmAuftragActionPerformed(evt);
            }
        });

        miAuftraganzeigen.setText("Anzeigen");
        miAuftraganzeigen.setToolTipText("");
        miAuftraganzeigen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miAuftraganzeigenActionPerformed(evt);
            }
        });
        jmAuftrag.add(miAuftraganzeigen);

        miAuftraganlegen.setMnemonic('t');
        miAuftraganlegen.setText("Anlegen");
        miAuftraganlegen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miAuftraganlegenActionPerformed(evt);
            }
        });
        jmAuftrag.add(miAuftraganlegen);

        miAuftragbearbeiten.setMnemonic('y');
        miAuftragbearbeiten.setText("Bearbeiten");
        miAuftragbearbeiten.setToolTipText("");
        miAuftragbearbeiten.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miAuftragbearbeitenActionPerformed(evt);
            }
        });
        jmAuftrag.add(miAuftragbearbeiten);

        menuBar.add(jmAuftrag);

        jmArtikel.setMnemonic('h');
        jmArtikel.setText("Artikel");
        jmArtikel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmArtikelActionPerformed(evt);
            }
        });

        miArtikelanzeigen.setText("Anzeigen");
        miArtikelanzeigen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miArtikelanzeigenActionPerformed(evt);
            }
        });
        jmArtikel.add(miArtikelanzeigen);

        miArtikelanlegen.setMnemonic('c');
        miArtikelanlegen.setText("Anlegen");
        miArtikelanlegen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miArtikelanlegenActionPerformed(evt);
            }
        });
        jmArtikel.add(miArtikelanlegen);

        miArtikelbearbeiten.setMnemonic('a');
        miArtikelbearbeiten.setText("Bearbeiten");
        miArtikelbearbeiten.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miArtikelbearbeitenActionPerformed(evt);
            }
        });
        jmArtikel.add(miArtikelbearbeiten);

        menuBar.add(jmArtikel);

        jmSuche.setText("Suche");
        jmSuche.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmSucheActionPerformed(evt);
            }
        });

        miAuftragSuche.setText("Auftrag");
        miAuftragSuche.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miAuftragSucheActionPerformed(evt);
            }
        });
        jmSuche.add(miAuftragSuche);

        miArtikelSuche.setText("Artikel");
        miArtikelSuche.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miArtikelSucheActionPerformed(evt);
            }
        });
        jmSuche.add(miArtikelSuche);

        miLieferantSuche.setText("Lieferant");
        miLieferantSuche.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miLieferantSucheActionPerformed(evt);
            }
        });
        jmSuche.add(miLieferantSuche);

        miKundeSuche.setText("Kunde");
        miKundeSuche.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miKundeSucheActionPerformed(evt);
            }
        });
        jmSuche.add(miKundeSuche);

        miZKSuche.setText("Zahlungskondition");
        miZKSuche.setToolTipText("");
        miZKSuche.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miZKSucheActionPerformed(evt);
            }
        });
        jmSuche.add(miZKSuche);

        menuBar.add(jmSuche);

        jmGeschäftspartner.setText("Geschäftspartner");

        jmLieferant.setText("Lieferant");

        miLieferantanzeigen.setText("Anzeigen");
        miLieferantanzeigen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miLieferantanzeigenActionPerformed(evt);
            }
        });
        jmLieferant.add(miLieferantanzeigen);

        miLieferantanlegen.setText("Anlegen");
        miLieferantanlegen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miLieferantanlegenActionPerformed(evt);
            }
        });
        jmLieferant.add(miLieferantanlegen);

        miLieferantbearbeiten.setText("Bearbeiten");
        miLieferantbearbeiten.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miLieferantbearbeitenActionPerformed(evt);
            }
        });
        jmLieferant.add(miLieferantbearbeiten);

        jmGeschäftspartner.add(jmLieferant);

        jmKunde.setText("Kunde");

        miKundeanzeigen.setText("Anzeigen");
        miKundeanzeigen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miKundeanzeigenActionPerformed(evt);
            }
        });
        jmKunde.add(miKundeanzeigen);

        miKundeanlegen.setText("Anlegen");
        miKundeanlegen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miKundeanlegenActionPerformed(evt);
            }
        });
        jmKunde.add(miKundeanlegen);

        miKundebearbeiten.setText("Bearbeiten");
        miKundebearbeiten.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miKundebearbeitenActionPerformed(evt);
            }
        });
        jmKunde.add(miKundebearbeiten);

        jmGeschäftspartner.add(jmKunde);

        menuBar.add(jmGeschäftspartner);

        jmZahlungskondition.setText("Zahlungskondition");

        miZKAnzeigen.setText("Anzeigen");
        miZKAnzeigen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miZKAnzeigenActionPerformed(evt);
            }
        });
        jmZahlungskondition.add(miZKAnzeigen);

        miZKAnlegen.setText("Anlegen");
        miZKAnlegen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miZKAnlegenActionPerformed(evt);
            }
        });
        jmZahlungskondition.add(miZKAnlegen);

        miZKBearbeiten.setText("Bearbeiten");
        miZKBearbeiten.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miZKBearbeitenActionPerformed(evt);
            }
        });
        jmZahlungskondition.add(miZKBearbeiten);

        menuBar.add(jmZahlungskondition);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 1200, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 979, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void miBeendenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miBeendenActionPerformed
        System.exit(0);
    }//GEN-LAST:event_miBeendenActionPerformed

    private void miAbmeldenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miAbmeldenActionPerformed
        // Mechmet Impram Ersterstellung
        // Hicran Yörük Erweiterung
        if(istEingeloggt==true){
        JOptionPane.showMessageDialog(null, ABMELDE_TEXT, ABMELDE_TITEL, JOptionPane.INFORMATION_MESSAGE);
//        SeiteZwei.setVisible(false);
//        ArtikelAnlegen.setVisible(false);
//        ArtikelAnzeige.setVisible(false);
//        ArtikelBearbeiten.setVisible(false);
//        ArtikelSuche.setVisible(false);
//        AuftragAnzeigen.setVisible(false);
//        AuftragSuchen.setVisible(false);
//        AuftragAnlegen.setVisible(false);
//        AuftragBearbeiten.setVisible(false);
//        KundeSuchen.setVisible(false);
//        LieferantSuchen.setVisible(false);
//        LieferantAnlegen.setVisible(false);
//        LieferantAnzeigen.setVisible(false);
//        LieferantBearbeiten.setVisible(false);
//        KundeAnlegen.setVisible(false);
//        KundeAnzeigen.setVisible(false);
//        KundeBearbeiten.setVisible(false);
//        AuftragsID_suchen.setVisible(false);
          Startseite.setVisible(true);
//        ZKAnlegen.setVisible(false);
//        ZKAnzeigen.setVisible(false);
//        ZKBearbeiten.setVisible(false);
//        ZKSuchen.setVisible(false);
//        ZKID_suchen.setVisible(false);
        /*----------------------------------------------------------*/
        /* 21.11.16 Samet Variable istEngeloggt wird beim abmelden auf false gesetzt.*/
        /*----------------------------------------------------------*/
        istEingeloggt=false;
        
        /*----------------------------------------------------------*/
        /* 21.11.16 Samet Variable istEngeloggt, um den Staus des Login zu erfassen
        Bei istEingeloggt=false wird die untesn setehende Fehlermeldung ausgegeben.*/
        /*----------------------------------------------------------*/
        
        }
        else{
        JOptionPane.showMessageDialog(null,"Bitte einloggen!");
        }
       
    }//GEN-LAST:event_miAbmeldenActionPerformed

    private void miAuftraganzeigenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miAuftraganzeigenActionPerformed
        // Mechmet Impram Ersterstellung
        // Hicran Yörük Erweiterung
    if(istEingeloggt==true){
//        SeiteZwei.setVisible(false);
//        ArtikelAnlegen.setVisible(false);
//        ArtikelAnzeige.setVisible(false);
//        ArtikelBearbeiten.setVisible(false);
//        ArtikelSuche.setVisible(false);
          jifAuftragAnzeigen.setVisible(true);
//        AuftragSuchen.setVisible(false);
//        AuftragAnlegen.setVisible(false);
//        AuftragBearbeiten.setVisible(false);
//        KundeSuchen.setVisible(false);
//        LieferantSuchen.setVisible(false);
//        LieferantAnlegen.setVisible(false);
//        LieferantAnzeigen.setVisible(false);
//        LieferantBearbeiten.setVisible(false);
//        KundeAnlegen.setVisible(false);
//        KundeAnzeigen.setVisible(false);
//        KundeBearbeiten.setVisible(false);
//        Startseite.setVisible(false);
//        AuftragsID_suchen.setVisible(false);
//        ZKAnlegen.setVisible(false);
//        ZKAnzeigen.setVisible(false);
//        ZKBearbeiten.setVisible(false);
//        ZKSuchen.setVisible(false);
//        ZKID_suchen.setVisible(false);
       /*----------------------------------------------------------*/
        /* 21.11.16 Samet Variable istEngeloggt, um den Staus des Login zu erfassen
        Bei istEingeloggt=false wird die untesn setehende Fehlermeldung ausgegeben.*/
        /*----------------------------------------------------------*/
        }else {
        JOptionPane.showMessageDialog(null,"Bitte einloggen!");    
        }
    }//GEN-LAST:event_miAuftraganzeigenActionPerformed

    private void miAuftragSucheActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miAuftragSucheActionPerformed
        // Mechmet Impram Ersterstellung
        // Hicran Yörük Erweiterung
    if(istEingeloggt==true){
//        SeiteZwei.setVisible(false);
//        ArtikelAnlegen.setVisible(false);
//        ArtikelAnzeige.setVisible(false);
//        ArtikelBearbeiten.setVisible(false);
//        ArtikelSuche.setVisible(false);
//        AuftragAnzeigen.setVisible(false);
          jifAuftragSuchen.setVisible(true);
//        AuftragAnlegen.setVisible(false);
//        AuftragBearbeiten.setVisible(false);
//        KundeSuchen.setVisible(false);
//        LieferantSuchen.setVisible(false);
//        LieferantAnlegen.setVisible(false);
//        LieferantAnzeigen.setVisible(false);
//        LieferantBearbeiten.setVisible(false);
//        KundeAnlegen.setVisible(false);
//        KundeAnzeigen.setVisible(false);
//        KundeBearbeiten.setVisible(false);
//        Startseite.setVisible(false);
//        AuftragsID_suchen.setVisible(false);
//        ZKAnlegen.setVisible(false);
//        ZKAnzeigen.setVisible(false);
//        ZKBearbeiten.setVisible(false);
//        ZKSuchen.setVisible(false);
//        ZKID_suchen.setVisible(false);
        }
        /*----------------------------------------------------------*/
        /* 21.11.16 Samet Variable istEngeloggt, um den Staus des Login zu erfassen
        Bei istEingeloggt=false wird die untesn setehende Fehlermeldung ausgegeben.*/
        /*----------------------------------------------------------*/
        else{
        JOptionPane.showMessageDialog(null,"Bitte einloggen!");
        }
    }//GEN-LAST:event_miAuftragSucheActionPerformed

    private void jbBearbeiten_azActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBearbeiten_azActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbBearbeiten_azActionPerformed

    private void jcbmehrwertsteuer_ArtikelAnzeigenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbmehrwertsteuer_ArtikelAnzeigenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbmehrwertsteuer_ArtikelAnzeigenActionPerformed

    private void jbbearbeiten_ArtikelAnzeigenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbbearbeiten_ArtikelAnzeigenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbbearbeiten_ArtikelAnzeigenActionPerformed

    private void jbabbrechen_ArtikelAnzeigenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbabbrechen_ArtikelAnzeigenActionPerformed
        // Mechmet Impram Ersterstellung
        jifArtikelAnzeige.setVisible(false);
        SeiteZwei.setVisible(true);
    }//GEN-LAST:event_jbabbrechen_ArtikelAnzeigenActionPerformed

    private void jbAnzeigen_ArtikelSucheActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAnzeigen_ArtikelSucheActionPerformed
        // Mechmet Impram Ersterstellung
        jifArtikelSuche.setVisible(false);
        jifArtikelAnzeige.setVisible(true);
    }//GEN-LAST:event_jbAnzeigen_ArtikelSucheActionPerformed

    private void jbAbbrechen_ArtikelSucheActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAbbrechen_ArtikelSucheActionPerformed
        // Mechmet Impram Ersterstellung
        jifArtikelSuche.setVisible(false);
        SeiteZwei.setVisible(true);
        //     SeiteZweiFrame.setVisible(true);
    }//GEN-LAST:event_jbAbbrechen_ArtikelSucheActionPerformed

    private void jbBearbeiten_ArtikelBearbeitenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBearbeiten_ArtikelBearbeitenActionPerformed
        // Mechmet Impram Ersterstellung
        // Hicran Yörük Erweiterung
        jifArtikelBearbeiten.setVisible(false);
        jifArtikelAnzeige.setVisible(true);

    }//GEN-LAST:event_jbBearbeiten_ArtikelBearbeitenActionPerformed

    private void jbAbbrechen_ArtikelBearbeitenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAbbrechen_ArtikelBearbeitenActionPerformed
        // Mechmet Impram Ersterstellung
//        ArtikelAnlegen.setVisible(false);
          SeiteZwei.setVisible(true);
//        AuftragSuche.setVisible(false);
//        AuftragAnzeige.setVisible(false);
//        AuftragAnlegen.setVisible(false);
//        ArtikelAendern.setVisible(false);
//        ArtikelSuche.setVisible(false);
//        RegistrierungFrame.setVisible(false);
//        ArtikelAnzeige.setVisible(false);
          jifArtikelBearbeiten.setVisible(false);
    }//GEN-LAST:event_jbAbbrechen_ArtikelBearbeitenActionPerformed

    private void jbZurueck_azActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbZurueck_azActionPerformed
        // Mechmet Impram Ersterstellung
        SeiteZwei.setVisible(true);
        jifAuftragAnzeigen.setVisible(false);

    }//GEN-LAST:event_jbZurueck_azActionPerformed

    private void miArtikelSucheActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miArtikelSucheActionPerformed
        // Mechmet Impram Ersterstellung
        // Hicran Yörük Erweiterung
        if(istEingeloggt==true){
//        SeiteZwei.setVisible(false);
//        ArtikelAnlegen.setVisible(false);
//        ArtikelAnzeige.setVisible(false);
//        ArtikelBearbeiten.setVisible(false);
          jifArtikelSuche.setVisible(true);
//        AuftragAnzeigen.setVisible(false);
//        AuftragSuchen.setVisible(false);
//        AuftragAnlegen.setVisible(false);
//        AuftragBearbeiten.setVisible(false);
//        KundeSuchen.setVisible(false);
//        LieferantSuchen.setVisible(false);
//        LieferantAnlegen.setVisible(false);
//        LieferantAnzeigen.setVisible(false);
//        LieferantBearbeiten.setVisible(false);
//        KundeAnlegen.setVisible(false);
//        KundeAnzeigen.setVisible(false);
//        KundeBearbeiten.setVisible(false);
//        Startseite.setVisible(false);
//        AuftragsID_suchen.setVisible(false);
//         ZKAnlegen.setVisible(false);
//        ZKAnzeigen.setVisible(false);
//        ZKBearbeiten.setVisible(false);
//        ZKSuchen.setVisible(false);
//        ZKID_suchen.setVisible(false);
        }
        /*----------------------------------------------------------*/
        /* 21.11.16 Samet Variable istEngeloggt, um den Staus des Login zu erfassen
        Bei istEingeloggt=false wird die untesn setehende Fehlermeldung ausgegeben.*/
        /*----------------------------------------------------------*/
        else{
        JOptionPane.showMessageDialog(null,"Bitte einloggen!");
        }
    }//GEN-LAST:event_miArtikelSucheActionPerformed

    private void miArtikelanzeigenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miArtikelanzeigenActionPerformed
        // Mechmet Impram Ersterstellung
        // Hicran Yörük Erweiterung
    if(istEingeloggt==true){
//        SeiteZwei.setVisible(false);
//        ArtikelAnlegen.setVisible(false);
        jifArtikelAnzeige.setVisible(true);
//        ArtikelBearbeiten.setVisible(false);
//        ArtikelSuche.setVisible(false);
//        AuftragAnzeigen.setVisible(false);
//        AuftragSuchen.setVisible(false);
//        AuftragAnlegen.setVisible(false);
//        AuftragBearbeiten.setVisible(false);
//        KundeSuchen.setVisible(false);
//        LieferantSuchen.setVisible(false);
//        LieferantAnlegen.setVisible(false);
//        LieferantAnzeigen.setVisible(false);
//        LieferantBearbeiten.setVisible(false);
//        KundeAnlegen.setVisible(false);
//        KundeAnzeigen.setVisible(false);
//        KundeBearbeiten.setVisible(false);
//        Startseite.setVisible(false);
//        AuftragsID_suchen.setVisible(false);
//         ZKAnlegen.setVisible(false);
//        ZKAnzeigen.setVisible(false);
//        ZKBearbeiten.setVisible(false);
//        ZKSuchen.setVisible(false);
//        ZKID_suchen.setVisible(false);
        }
        /*----------------------------------------------------------*/
        /* 21.11.16 Samet Variable istEngeloggt, um den Staus des Login zu erfassen
        Bei istEingeloggt=false wird die untesn setehende Fehlermeldung ausgegeben.*/
        /*----------------------------------------------------------*/
        else{
        JOptionPane.showMessageDialog(null,"Bitte einloggen!");
        }
    }//GEN-LAST:event_miArtikelanzeigenActionPerformed

    private void miArtikelanlegenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miArtikelanlegenActionPerformed
        // TODO add your handling code here:
    if(istEingeloggt==true){
//        SeiteZwei.setVisible(false);
        jifArtikelAnlegen.setVisible(true);
//        ArtikelAnzeige.setVisible(false);
//        ArtikelBearbeiten.setVisible(false);
//        ArtikelSuche.setVisible(false);
//        AuftragAnzeigen.setVisible(false);
//        AuftragSuchen.setVisible(false);
//        AuftragAnlegen.setVisible(false);
//        AuftragBearbeiten.setVisible(false);
//        KundeSuchen.setVisible(false);
//        LieferantSuchen.setVisible(false);
//        LieferantAnlegen.setVisible(false);
//        LieferantAnzeigen.setVisible(false);
//        LieferantBearbeiten.setVisible(false);
//        KundeAnlegen.setVisible(false);
//        KundeAnzeigen.setVisible(false);
//        KundeBearbeiten.setVisible(false);
//        Startseite.setVisible(false);
//        AuftragsID_suchen.setVisible(false);
//         ZKAnlegen.setVisible(false);
//        ZKAnzeigen.setVisible(false);
//        ZKBearbeiten.setVisible(false);
//        ZKSuchen.setVisible(false);
//        ZKID_suchen.setVisible(false);
        }
        /*----------------------------------------------------------*/
        /* 21.11.16 Samet Variable istEngeloggt, um den Staus des Login zu erfassen
        Bei istEingeloggt=false wird die untesn setehende Fehlermeldung ausgegeben.*/
        /*----------------------------------------------------------*/
        else{
        JOptionPane.showMessageDialog(null,"Bitte einloggen!");       
        }
    }//GEN-LAST:event_miArtikelanlegenActionPerformed

    private void miArtikelbearbeitenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miArtikelbearbeitenActionPerformed
        // Mechmet Impram Ersterstellung
        // Hicran Yörük Erweiterung
    if(istEingeloggt==true){
//        SeiteZwei.setVisible(false);
//        ArtikelAnlegen.setVisible(false);
//        ArtikelAnzeige.setVisible(false);
        jifArtikelBearbeiten.setVisible(true);
//        ArtikelSuche.setVisible(false);
//        AuftragAnzeigen.setVisible(false);
//        AuftragSuchen.setVisible(false);
//        AuftragAnlegen.setVisible(false);
//        AuftragBearbeiten.setVisible(false);
//        KundeSuchen.setVisible(false);
//        LieferantSuchen.setVisible(false);
//        LieferantAnlegen.setVisible(false);
//        LieferantAnzeigen.setVisible(false);
//        LieferantBearbeiten.setVisible(false);
//        KundeAnlegen.setVisible(false);
//        KundeAnzeigen.setVisible(false);
//        KundeBearbeiten.setVisible(false);
//        Startseite.setVisible(false);
//        AuftragsID_suchen.setVisible(false);
//         ZKAnlegen.setVisible(false);
//        ZKAnzeigen.setVisible(false);
//        ZKBearbeiten.setVisible(false);
//        ZKSuchen.setVisible(false);
//        ZKID_suchen.setVisible(false);
        }
       /*----------------------------------------------------------*/
        /* 21.11.16 Samet Variable istEngeloggt, um den Staus des Login zu erfassen
        Bei istEingeloggt=false wird die untesn setehende Fehlermeldung ausgegeben.*/
        /*----------------------------------------------------------*/
        else{
        JOptionPane.showMessageDialog(null,"Bitte einloggen!");
        }
    }//GEN-LAST:event_miArtikelbearbeitenActionPerformed

    private void miAuftraganlegenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miAuftraganlegenActionPerformed
        // Mechmet Impram Ersterstellung
        // Hicran Yörük Erweiterung
    if(istEingeloggt==true){
//        SeiteZwei.setVisible(false);
//        ArtikelAnlegen.setVisible(false);
//        ArtikelAnzeige.setVisible(false);
//        ArtikelBearbeiten.setVisible(false);
//        ArtikelSuche.setVisible(false);
//        AuftragAnzeigen.setVisible(false);
//        AuftragSuchen.setVisible(false);
        jifAuftragAnlegen.setVisible(true);
//        AuftragBearbeiten.setVisible(false);
//        KundeSuchen.setVisible(false);
//        LieferantSuchen.setVisible(false);
//        LieferantAnlegen.setVisible(false);
//        LieferantAnzeigen.setVisible(false);
//        LieferantBearbeiten.setVisible(false);
//        KundeAnlegen.setVisible(false);
//        KundeAnzeigen.setVisible(false);
//        KundeBearbeiten.setVisible(false);
//        Startseite.setVisible(false);
//        AuftragsID_suchen.setVisible(false);
//        ZKAnlegen.setVisible(false);
//        ZKAnzeigen.setVisible(false);
//        ZKBearbeiten.setVisible(false);
//        ZKSuchen.setVisible(false);
//        ZKID_suchen.setVisible(false);
        }
        /*----------------------------------------------------------*/
        /* 21.11.16 Samet Variable istEngeloggt, um den Staus des Login zu erfassen
        Bei istEingeloggt=false wird die untesn setehende Fehlermeldung ausgegeben.*/
        /*----------------------------------------------------------*/
        else{
        JOptionPane.showMessageDialog(null,"Bitte einloggen!");
        }
    }//GEN-LAST:event_miAuftraganlegenActionPerformed

    private void miAuftragbearbeitenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miAuftragbearbeitenActionPerformed
        // Mechmet Impram Ersterstellung
        // Hicran Yörük Erweiterung
    if(istEingeloggt){
//        SeiteZwei.setVisible(false);
//        ArtikelAnlegen.setVisible(false);
//        ArtikelAnzeige.setVisible(false);
//        ArtikelBearbeiten.setVisible(false);
//        ArtikelSuche.setVisible(false);
//        AuftragAnzeigen.setVisible(false);
//        AuftragSuchen.setVisible(false);
//        AuftragAnlegen.setVisible(false);
        jifAuftragBearbeiten.setVisible(true);
//        KundeSuchen.setVisible(false);
//        LieferantSuchen.setVisible(false);
//        LieferantAnlegen.setVisible(false);
//        LieferantAnzeigen.setVisible(false);
//        LieferantBearbeiten.setVisible(false);
//        KundeAnlegen.setVisible(false);
//        KundeAnzeigen.setVisible(false);
//        KundeBearbeiten.setVisible(false);
//        Startseite.setVisible(false);
//        AuftragsID_suchen.setVisible(false);
        }
        /*----------------------------------------------------------*/
        /* 21.11.16 Samet Variable istEngeloggt, um den Staus des Login zu erfassen
        Bei istEingeloggt=false wird die untesn setehende Fehlermeldung ausgegeben.*/
        /*----------------------------------------------------------*/
        else{
        JOptionPane.showMessageDialog(null,"Bitte einloggen!");
        }
    }//GEN-LAST:event_miAuftragbearbeitenActionPerformed

    private void miLieferantSucheActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miLieferantSucheActionPerformed
        // Mechmet Impram Ersterstellung
        // Duygu Citak Erweiterung
    if(istEingeloggt==true){
//        SeiteZwei.setVisible(false);
//        ArtikelAnlegen.setVisible(false);
//        ArtikelAnzeige.setVisible(false);
//        ArtikelBearbeiten.setVisible(false);
//        ArtikelSuche.setVisible(false);
//        AuftragAnzeigen.setVisible(false);
//        AuftragSuchen.setVisible(false);
//        AuftragAnlegen.setVisible(false);
//        AuftragBearbeiten.setVisible(false);
//        KundeSuchen.setVisible(false);
        LieferantSuchen.setVisible(true);
//        LieferantAnlegen.setVisible(false);
//        LieferantAnzeigen.setVisible(false);
//        LieferantBearbeiten.setVisible(false);
//        KundeAnlegen.setVisible(false);
//        KundeAnzeigen.setVisible(false);
//        KundeBearbeiten.setVisible(false);
//        Startseite.setVisible(false);
//        AuftragsID_suchen.setVisible(false);
//         ZKAnlegen.setVisible(false);
//        ZKAnzeigen.setVisible(false);
//        ZKBearbeiten.setVisible(false);
//        ZKSuchen.setVisible(false);
//        ZKID_suchen.setVisible(false);
        }
        /*----------------------------------------------------------*/
        /* 21.11.16 Samet Variable istEngeloggt, um den Staus des Login zu erfassen
        Bei istEingeloggt=false wird die untesn setehende Fehlermeldung ausgegeben.*/
        /*----------------------------------------------------------*/
        else{
        JOptionPane.showMessageDialog(null,"Bitte einloggen!");
        }
    }//GEN-LAST:event_miLieferantSucheActionPerformed

    private void jbAbbrechen_AuftragBearbeitenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAbbrechen_AuftragBearbeitenActionPerformed
        // Mechmet Impram Ersterstellung
        // Hicran Yörük Erweiterung
        SeiteZwei.setVisible(true);
        jifArtikelAnlegen.setVisible(false);
        jifArtikelAnzeige.setVisible(false);
        jifArtikelBearbeiten.setVisible(false);
        jifArtikelSuche.setVisible(false);
        jifAuftragAnzeigen.setVisible(false);
        jifAuftragSuchen.setVisible(false);
        jifAuftragAnlegen.setVisible(false);
        jifAuftragBearbeiten.setVisible(false);
        jifKundeSuchen.setVisible(false);
        jifLieferantSuchen.setVisible(false);
        jifLieferantAnlegen.setVisible(false);
        jifLieferantAnzeigen.setVisible(false);
        jifLieferantBearbeiten.setVisible(false);
        jifKundeAnlegen.setVisible(false);
        jifKundeAnzeigen.setVisible(false);
        jifKundeBearbeiten.setVisible(false);
        Startseite.setVisible(false);      
        jifAuftragsID_suchen.setVisible(false);

    }//GEN-LAST:event_jbAbbrechen_AuftragBearbeitenActionPerformed

    private void jbAbbrechen_LieferantSuchenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAbbrechen_LieferantSuchenActionPerformed
        // Mechmet Impram Ersterstellung
        // Duygu Citak Erweiterung
        SeiteZwei.setVisible(true);
        jifArtikelAnlegen.setVisible(false);
        jifArtikelAnzeige.setVisible(false);
        jifArtikelBearbeiten.setVisible(false);
        jifArtikelSuche.setVisible(false);
        jifAuftragAnzeigen.setVisible(false);
        jifAuftragSuchen.setVisible(false);
        jifAuftragAnlegen.setVisible(false);
       jifAuftragBearbeiten.setVisible(false);
        jifKundeSuchen.setVisible(false);
        jifLieferantSuchen.setVisible(false);
        jifLieferantAnlegen.setVisible(false);
        jifLieferantAnzeigen.setVisible(false);
        jifLieferantBearbeiten.setVisible(false);
        jifKundeAnlegen.setVisible(false);
        jifKundeAnzeigen.setVisible(false);
        jifKundeBearbeiten.setVisible(false);
        Startseite.setVisible(false);
        jifAuftragsID_suchen.setVisible(false);
        // TODO add your handling code here:
    }//GEN-LAST:event_jbAbbrechen_LieferantSuchenActionPerformed

    private void jbAbbrechen_KundeSuchenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAbbrechen_KundeSuchenActionPerformed
        // Mechmet Impram Ersterstellung
        // Duygu Citak Erweiterung
        SeiteZwei.setVisible(true);
        jifArtikelAnlegen.setVisible(false);
        jifArtikelAnzeige.setVisible(false);
        jifArtikelBearbeiten.setVisible(false);
        jifArtikelSuche.setVisible(false);
        jifAuftragAnzeigen.setVisible(false);
        jifAuftragSuchen.setVisible(false);
        jifAuftragAnlegen.setVisible(false);
        jifAuftragBearbeiten.setVisible(false);
        jifKundeSuchen.setVisible(false);
        jifLieferantSuchen.setVisible(false);
        jifLieferantAnlegen.setVisible(false);
        jifLieferantAnzeigen.setVisible(false);
        jifLieferantBearbeiten.setVisible(false);
        jifKundeAnlegen.setVisible(false);
        jifKundeAnzeigen.setVisible(false);
        jifKundeBearbeiten.setVisible(false);
        Startseite.setVisible(false);  
        jifAuftragsID_suchen.setVisible(false);
    }//GEN-LAST:event_jbAbbrechen_KundeSuchenActionPerformed

    private void miKundeSucheActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miKundeSucheActionPerformed
        // Mechmet Impram Ersterstellung
        // Duygu Citak Erweiterung
        if(istEingeloggt == true){
//        SeiteZwei.setVisible(false);
//        ArtikelAnlegen.setVisible(false);
//        ArtikelAnzeige.setVisible(false);
//        ArtikelBearbeiten.setVisible(false);
//        ArtikelSuche.setVisible(false);
//        AuftragAnzeigen.setVisible(false);
//        AuftragSuchen.setVisible(false);
//        AuftragAnlegen.setVisible(false);
//        AuftragBearbeiten.setVisible(false);
        jifKundeSuchen.setVisible(true);
//        LieferantSuchen.setVisible(false);
//        LieferantAnlegen.setVisible(false);
//        LieferantAnzeigen.setVisible(false);
//        LieferantBearbeiten.setVisible(false);
//        KundeAnlegen.setVisible(false);
//        KundeAnzeigen.setVisible(false);
//        KundeBearbeiten.setVisible(false);
//        Startseite.setVisible(false);
//        AuftragsID_suchen.setVisible(false);
//         ZKAnlegen.setVisible(false);
//        ZKAnzeigen.setVisible(false);
//        ZKBearbeiten.setVisible(false);
//        ZKSuchen.setVisible(false);
//        ZKID_suchen.setVisible(false);
        }
        /*----------------------------------------------------------*/
        /* 21.11.16 Samet Variable istEngeloggt, um den Staus des Login zu erfassen
        Bei istEingeloggt=false wird die untesn setehende Fehlermeldung ausgegeben.*/
        /*----------------------------------------------------------*/
        else{
        JOptionPane.showMessageDialog(null,"Bitte einloggen!");
        }
    }//GEN-LAST:event_miKundeSucheActionPerformed

    private void miLieferantanzeigenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miLieferantanzeigenActionPerformed
        // Mechmet Impram Ersterstellung
        // Duygu Citak Erweiterung
    if(istEingeloggt==true){
//        SeiteZwei.setVisible(false);
//        ArtikelAnlegen.setVisible(false);
//        ArtikelAnzeige.setVisible(false);
//        ArtikelBearbeiten.setVisible(false);
//        ArtikelSuche.setVisible(false);
//        AuftragAnzeigen.setVisible(false);
//        AuftragSuchen.setVisible(false);
//        AuftragAnlegen.setVisible(false);
//        AuftragBearbeiten.setVisible(false);
//        KundeSuchen.setVisible(false);
//        LieferantSuchen.setVisible(false);
//        LieferantAnlegen.setVisible(false);
        jifLieferantAnzeigen.setVisible(true);
//        LieferantBearbeiten.setVisible(false);
//        KundeAnlegen.setVisible(false);
//        KundeAnzeigen.setVisible(false);
//        KundeBearbeiten.setVisible(false);
//        Startseite.setVisible(false);
//        AuftragsID_suchen.setVisible(false);
//         ZKAnlegen.setVisible(false);
//        ZKAnzeigen.setVisible(false);
//        ZKBearbeiten.setVisible(false);
//        ZKSuchen.setVisible(false);
//        ZKID_suchen.setVisible(false);
        }
       /*----------------------------------------------------------*/
        /* 21.11.16 Samet Variable istEngeloggt, um den Staus des Login zu erfassen
        Bei istEingeloggt=false wird die untesn setehende Fehlermeldung ausgegeben.*/
        /*----------------------------------------------------------*/
        else{
        JOptionPane.showMessageDialog(null,"Bitte einloggen!");
        }
    }//GEN-LAST:event_miLieferantanzeigenActionPerformed

    private void miLieferantanlegenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miLieferantanlegenActionPerformed
        // Mechmet Impram Ersterstellung
        // Duygu Citak Erweiterung
    if(istEingeloggt==true){
//        SeiteZwei.setVisible(false);
//        ArtikelAnlegen.setVisible(false);
//        ArtikelAnzeige.setVisible(false);
//        ArtikelBearbeiten.setVisible(false);
//        ArtikelSuche.setVisible(false);
//        AuftragAnzeigen.setVisible(false);
//        AuftragSuchen.setVisible(false);
//        AuftragAnlegen.setVisible(false);
//        AuftragBearbeiten.setVisible(false);
//        KundeSuchen.setVisible(false);
//        LieferantSuchen.setVisible(false);
        LieferantAnlegen.setVisible(true);
//        LieferantAnzeigen.setVisible(false);
//        LieferantBearbeiten.setVisible(false);
//        KundeAnlegen.setVisible(false);
//        KundeAnzeigen.setVisible(false);
//        KundeBearbeiten.setVisible(false);
//        Startseite.setVisible(false);
//        AuftragsID_suchen.setVisible(false);
//        Rechnungsdaten_LieferantAnlegen.setVisible(true);
//        Lieferdaten_LieferantAnlegen.setVisible(false);
//        Kontakt_LieferantAnlegen.setVisible(true);
//         ZKAnlegen.setVisible(false);
//        ZKAnzeigen.setVisible(false);
//        ZKBearbeiten.setVisible(false);
//        ZKSuchen.setVisible(false);
//        ZKID_suchen.setVisible(false);
        }
        /*----------------------------------------------------------*/
        /* 21.11.16 Samet Variable istEngeloggt, um den Staus des Login zu erfassen
        Bei istEingeloggt=false wird die untesn setehende Fehlermeldung ausgegeben.*/
        /*----------------------------------------------------------*/
        else{
        JOptionPane.showMessageDialog(null,"Bitte einloggen!");
        }
    }//GEN-LAST:event_miLieferantanlegenActionPerformed

    private void miLieferantbearbeitenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miLieferantbearbeitenActionPerformed
        // Mechmet Impram Ersterstellung
        // Duygu Citak Erweiterung
    if(istEingeloggt==true){
//        SeiteZwei.setVisible(false);
//        ArtikelAnlegen.setVisible(false);
//        ArtikelAnzeige.setVisible(false);
//        ArtikelBearbeiten.setVisible(false);
//        ArtikelSuche.setVisible(false);
//        AuftragAnzeigen.setVisible(false);
//        AuftragSuchen.setVisible(false);
//        AuftragAnlegen.setVisible(false);
//        AuftragBearbeiten.setVisible(false);
//        KundeSuchen.setVisible(false);
//        LieferantSuchen.setVisible(false);
//        LieferantAnlegen.setVisible(false);
//        LieferantAnzeigen.setVisible(false);
        jifLieferantBearbeiten.setVisible(true);
//        KundeAnlegen.setVisible(false);
//        KundeAnzeigen.setVisible(false);
//        KundeBearbeiten.setVisible(false);
//        Startseite.setVisible(false);
//        AuftragsID_suchen.setVisible(false);
//         ZKAnlegen.setVisible(false);
//        ZKAnzeigen.setVisible(false);
//        ZKBearbeiten.setVisible(false);
//        ZKSuchen.setVisible(false);
//        ZKID_suchen.setVisible(false);
        }
        /*----------------------------------------------------------*/
        /* 21.11.16 Samet Variable istEngeloggt, um den Staus des Login zu erfassen
        Bei istEingeloggt=false wird die untesn setehende Fehlermeldung ausgegeben.*/
        /*----------------------------------------------------------*/
        else{
        JOptionPane.showMessageDialog(null,"Bitte einloggen!");
        }
    }//GEN-LAST:event_miLieferantbearbeitenActionPerformed

    private void miKundeanzeigenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miKundeanzeigenActionPerformed
        // Mechmet Impram Ersterstellung
        // Duygu Citak Erweiterung
    if(istEingeloggt==true){
//        SeiteZwei.setVisible(false);
//        ArtikelAnlegen.setVisible(false);
//        ArtikelAnzeige.setVisible(false);
//        ArtikelBearbeiten.setVisible(false);
//        ArtikelSuche.setVisible(false);
//        AuftragAnzeigen.setVisible(false);
//        AuftragSuchen.setVisible(false);
//        AuftragAnlegen.setVisible(false);
//        AuftragBearbeiten.setVisible(false);
//        KundeSuchen.setVisible(false);
//        LieferantSuchen.setVisible(false);
//        LieferantAnlegen.setVisible(false);
//        LieferantAnzeigen.setVisible(false);
//        LieferantBearbeiten.setVisible(false);
//        KundeAnlegen.setVisible(false);
        jifKundeAnzeigen.setVisible(true);
//        KundeBearbeiten.setVisible(false);
//        Startseite.setVisible(false);
//        AuftragsID_suchen.setVisible(false);
//         ZKAnlegen.setVisible(false);
//        ZKAnzeigen.setVisible(false);
//        ZKBearbeiten.setVisible(false);
//        ZKSuchen.setVisible(false);
//        ZKID_suchen.setVisible(false);
        }
        /*----------------------------------------------------------*/
        /* 21.11.16 Samet Variable istEngeloggt, um den Staus des Login zu erfassen
        Bei istEingeloggt=false wird die untesn setehende Fehlermeldung ausgegeben.*/
        /*----------------------------------------------------------*/
        else{
        JOptionPane.showMessageDialog(null,"Bitte einloggen!");
        }
    }//GEN-LAST:event_miKundeanzeigenActionPerformed

    private void miKundeanlegenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miKundeanlegenActionPerformed
        // Mechmet Impram Ersterstellung
        // Duygu Citak Erweiterung
    if(istEingeloggt==true){
//        SeiteZwei.setVisible(false);
//        ArtikelAnlegen.setVisible(false);
//        ArtikelAnzeige.setVisible(false);
//        ArtikelBearbeiten.setVisible(false);
//        ArtikelSuche.setVisible(false);
//        AuftragAnzeigen.setVisible(false);
//        AuftragSuchen.setVisible(false);
//        AuftragAnlegen.setVisible(false);
//        AuftragBearbeiten.setVisible(false);
//        KundeSuchen.setVisible(false);
//        LieferantSuchen.setVisible(false);
//        LieferantAnlegen.setVisible(false);
//        LieferantAnzeigen.setVisible(false);
//        LieferantBearbeiten.setVisible(false);
        jifKundeAnlegen.setVisible(true);
//        KundeAnzeigen.setVisible(false);
//        KundeBearbeiten.setVisible(false);
//        Startseite.setVisible(false);
//        AuftragsID_suchen.setVisible(false);
//         ZKAnlegen.setVisible(false);
//        ZKAnzeigen.setVisible(false);
//        ZKBearbeiten.setVisible(false);
//        ZKSuchen.setVisible(false);
//        ZKID_suchen.setVisible(false);
//        jPKontakt.setVisible(true);
//        jPRechnungsdaten.setVisible(true);
//        jPLieferdaten.setVisible(false);
        }
        /*----------------------------------------------------------*/
        /* 21.11.16 Samet Variable istEngeloggt, um den Staus des Login zu erfassen
        Bei istEingeloggt=false wird die untesn setehende Fehlermeldung ausgegeben.*/
        /*----------------------------------------------------------*/
        else{
        JOptionPane.showMessageDialog(null,"Bitte einloggen!");
        }
    }//GEN-LAST:event_miKundeanlegenActionPerformed

    private void miKundebearbeitenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miKundebearbeitenActionPerformed
        // Mechmet Impram Ersterstellung
        // Duygu Citak Erweiterung
    if(istEingeloggt==true){
//        SeiteZwei.setVisible(false);
//        ArtikelAnlegen.setVisible(false);
//        ArtikelAnzeige.setVisible(false);
//        ArtikelBearbeiten.setVisible(false);
//        ArtikelSuche.setVisible(false);
//        AuftragAnzeigen.setVisible(false);
//        AuftragSuchen.setVisible(false);
//        AuftragAnlegen.setVisible(false);
//        AuftragBearbeiten.setVisible(false);
//        KundeSuchen.setVisible(false);
//        LieferantSuchen.setVisible(false);
//        LieferantAnlegen.setVisible(false);
//        LieferantAnzeigen.setVisible(false);
//        LieferantBearbeiten.setVisible(false);
//        KundeAnlegen.setVisible(false);
//        KundeAnzeigen.setVisible(false);
        jifKundeBearbeiten.setVisible(true);
//        Startseite.setVisible(false);
//        AuftragsID_suchen.setVisible(false);
//         ZKAnlegen.setVisible(false);
//        ZKAnzeigen.setVisible(false);
//        ZKBearbeiten.setVisible(false);
//        ZKSuchen.setVisible(false);
//        ZKID_suchen.setVisible(false);
        }
        /*----------------------------------------------------------*/
        /* 21.11.16 Samet Variable istEngeloggt, um den Staus des Login zu erfassen
        Bei istEingeloggt=false wird die untesn setehende Fehlermeldung ausgegeben.*/
        /*----------------------------------------------------------*/
        else{
        JOptionPane.showMessageDialog(null,"Bitte einloggen!");
        }
    }//GEN-LAST:event_miKundebearbeitenActionPerformed

    private void jbZurueck_AutragSuchenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbZurueck_AutragSuchenActionPerformed
        // Mechmet Impram Ersterstellung
        // Hicran Yörük Erweiterung
        SeiteZwei.setVisible(true);
        jifArtikelAnlegen.setVisible(false);
        jifArtikelAnzeige.setVisible(false);
        jifArtikelBearbeiten.setVisible(false);
        jifArtikelSuche.setVisible(false);
        jifAuftragAnzeigen.setVisible(false);
        jifAuftragSuchen.setVisible(false);
        jifAuftragAnlegen.setVisible(false);
        jifAuftragBearbeiten.setVisible(false);
        jifKundeSuchen.setVisible(false);
        jifLieferantSuchen.setVisible(false);
        jifLieferantAnlegen.setVisible(false);
        jifLieferantAnzeigen.setVisible(false);
        jifLieferantBearbeiten.setVisible(false);
        jifKundeAnlegen.setVisible(false);
        jifKundeAnzeigen.setVisible(false);
        jifKundeBearbeiten.setVisible(false);
        Startseite.setVisible(false);
        jifAuftragsID_suchen.setVisible(false);
    }//GEN-LAST:event_jbZurueck_AutragSuchenActionPerformed

    private void jbAbbrechen_aaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAbbrechen_aaActionPerformed
           // Mechmet Impram Ersterstellung
        // Hicran Yörük Erweiterung
        SeiteZwei.setVisible(true);
        jifArtikelAnlegen.setVisible(false);
        jifArtikelAnzeige.setVisible(false);
        jifArtikelBearbeiten.setVisible(false);
        jifArtikelSuche.setVisible(false);
        jifAuftragAnzeigen.setVisible(false);
        jifAuftragSuchen.setVisible(false);
        jifAuftragAnlegen.setVisible(false);
        jifAuftragBearbeiten.setVisible(false);
        jifKundeSuchen.setVisible(false);
        jifLieferantSuchen.setVisible(false);
        jifLieferantAnlegen.setVisible(false);
        jifLieferantAnzeigen.setVisible(false);
        jifLieferantBearbeiten.setVisible(false);
        jifKundeAnlegen.setVisible(false);
        jifKundeAnzeigen.setVisible(false);
        jifKundeBearbeiten.setVisible(false);
        Startseite.setVisible(false);
        jifAuftragsID_suchen.setVisible(false);
    }//GEN-LAST:event_jbAbbrechen_aaActionPerformed

    private void jbzurueck_LieferantAnzeigenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbzurueck_LieferantAnzeigenActionPerformed
        // Mechmet Impram Ersterstellung
        // Duygu Citak Erweiterung
        SeiteZwei.setVisible(true);
        jifArtikelAnlegen.setVisible(false);
        jifArtikelAnzeige.setVisible(false);
        jifArtikelBearbeiten.setVisible(false);
        jifArtikelSuche.setVisible(false);
        jifAuftragAnzeigen.setVisible(false);
        jifAuftragSuchen.setVisible(false);
        jifAuftragAnlegen.setVisible(false);
        jifAuftragBearbeiten.setVisible(false);
        jifKundeSuchen.setVisible(false);
        jifLieferantSuchen.setVisible(false);
        jifLieferantAnlegen.setVisible(false);
        jifLieferantAnzeigen.setVisible(false);
        jifLieferantBearbeiten.setVisible(false);
        jifKundeAnlegen.setVisible(false);
        jifKundeAnzeigen.setVisible(false);
        jifKundeBearbeiten.setVisible(false);
        Startseite.setVisible(false);   
        jifAuftragsID_suchen.setVisible(false);// TODO add your handling code here:
    }//GEN-LAST:event_jbzurueck_LieferantAnzeigenActionPerformed

    private void jbAbbrechen_LieferantAnlegenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAbbrechen_LieferantAnlegenActionPerformed
        // Mechmet Impram Ersterstellung
        // Duygu Citak Erweiterung
        SeiteZwei.setVisible(true);
        jifArtikelAnlegen.setVisible(false);
        jifArtikelAnzeige.setVisible(false);
        jifArtikelBearbeiten.setVisible(false);
        jifArtikelSuche.setVisible(false);
        jifAuftragAnzeigen.setVisible(false);
        jifAuftragSuchen.setVisible(false);
        jifAuftragAnlegen.setVisible(false);
        jifAuftragBearbeiten.setVisible(false);
        jifKundeSuchen.setVisible(false);
        jifLieferantSuchen.setVisible(false);
        jifLieferantAnlegen.setVisible(false);
        jifLieferantAnzeigen.setVisible(false);
        jifLieferantBearbeiten.setVisible(false);
        jifKundeAnlegen.setVisible(false);
        jifKundeAnzeigen.setVisible(false);
        jifKundeBearbeiten.setVisible(false);
        Startseite.setVisible(false);   
        jifAuftragsID_suchen.setVisible(false);// TODO add your handling code here:
    }//GEN-LAST:event_jbAbbrechen_LieferantAnlegenActionPerformed

    private void jbzurueck_LieferantBearbeitenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbzurueck_LieferantBearbeitenActionPerformed
        // Mechmet Impram Ersterstellung
        // Duygu Citak Erweiterung
        SeiteZwei.setVisible(true);
        jifArtikelAnlegen.setVisible(false);
        jifArtikelAnzeige.setVisible(false);
        jifArtikelBearbeiten.setVisible(false);
        jifArtikelSuche.setVisible(false);
        jifAuftragAnzeigen.setVisible(false);
        jifAuftragSuchen.setVisible(false);
        jifAuftragAnlegen.setVisible(false);
        jifAuftragBearbeiten.setVisible(false);
        jifKundeSuchen.setVisible(false);
        jifLieferantSuchen.setVisible(false);
        jifLieferantAnlegen.setVisible(false);
        jifLieferantAnzeigen.setVisible(false);
        jifLieferantBearbeiten.setVisible(false);
        jifKundeAnlegen.setVisible(false);
        jifKundeAnzeigen.setVisible(false);
        jifKundeBearbeiten.setVisible(false);
        Startseite.setVisible(false);
        jifAuftragsID_suchen.setVisible(false);        // TODO add your handling code here:
    }//GEN-LAST:event_jbzurueck_LieferantBearbeitenActionPerformed

    private void zurueck_KundeAnzeigenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_zurueck_KundeAnzeigenActionPerformed
        // Mechmet Impram Ersterstellung
        // Duygu Citak Erweiterung
        SeiteZwei.setVisible(true);
        jifArtikelAnlegen.setVisible(false);
        jifArtikelAnzeige.setVisible(false);
        jifArtikelBearbeiten.setVisible(false);
        jifArtikelSuche.setVisible(false);
        jifAuftragAnzeigen.setVisible(false);
        jifAuftragSuchen.setVisible(false);
        jifAuftragAnlegen.setVisible(false);
        jifAuftragBearbeiten.setVisible(false);
        jifKundeSuchen.setVisible(false);
        jifLieferantSuchen.setVisible(false);
        jifLieferantAnlegen.setVisible(false);
        jifLieferantAnzeigen.setVisible(false);
        jifLieferantBearbeiten.setVisible(false);
        jifKundeAnlegen.setVisible(false);
        jifKundeAnzeigen.setVisible(false);
        jifKundeBearbeiten.setVisible(false);
        Startseite.setVisible(false);      
        jifAuftragsID_suchen.setVisible(false);
    }//GEN-LAST:event_zurueck_KundeAnzeigenActionPerformed

    private void abbrechen_KundeAnlegenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_abbrechen_KundeAnlegenActionPerformed
        // Mechmet Impram Ersterstellung
        // Duygu Citak Erweiterung
        SeiteZwei.setVisible(true);
        jifArtikelAnlegen.setVisible(false);
        jifArtikelAnzeige.setVisible(false);
        jifArtikelBearbeiten.setVisible(false);
        jifArtikelSuche.setVisible(false);
        jifAuftragAnzeigen.setVisible(false);
        jifAuftragSuchen.setVisible(false);
        jifAuftragAnlegen.setVisible(false);
        jifAuftragBearbeiten.setVisible(false);
        jifKundeSuchen.setVisible(false);
        jifLieferantSuchen.setVisible(false);
        jifLieferantAnlegen.setVisible(false);
        jifLieferantAnzeigen.setVisible(false);
        jifLieferantBearbeiten.setVisible(false);
        jifKundeAnlegen.setVisible(false);
        jifKundeAnzeigen.setVisible(false);
        jifKundeBearbeiten.setVisible(false);
        Startseite.setVisible(false);       
        jifAuftragsID_suchen.setVisible(false);
// TODO add your handling code here:
    }//GEN-LAST:event_abbrechen_KundeAnlegenActionPerformed

    private void zurueck_KundeBearbeitenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_zurueck_KundeBearbeitenActionPerformed
        // Mechmet Impram Ersterstellung
        // Duygu Citak Erweiterung
        SeiteZwei.setVisible(true);
        jifArtikelAnlegen.setVisible(false);
        jifArtikelAnzeige.setVisible(false);
        jifArtikelBearbeiten.setVisible(false);
        jifArtikelSuche.setVisible(false);
        jifAuftragAnzeigen.setVisible(false);
        jifAuftragSuchen.setVisible(false);
        jifAuftragAnlegen.setVisible(false);
        jifAuftragBearbeiten.setVisible(false);
        jifKundeSuchen.setVisible(false);
        jifLieferantSuchen.setVisible(false);
        jifLieferantAnlegen.setVisible(false);
        jifLieferantAnzeigen.setVisible(false);
        jifLieferantBearbeiten.setVisible(false);
        jifKundeAnlegen.setVisible(false);
        jifKundeAnzeigen.setVisible(false);
        jifKundeBearbeiten.setVisible(false);
        jifAuftragsID_suchen.setVisible(false);
        Startseite.setVisible(false);        
    }//GEN-LAST:event_zurueck_KundeBearbeitenActionPerformed

    private void jtfGPID_azActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfGPID_azActionPerformed
        
    }//GEN-LAST:event_jtfGPID_azActionPerformed

    private void jtfAuftragsid_aaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfAuftragsid_aaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfAuftragsid_aaActionPerformed

    private void jtfKundenName_AuftragSuchenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfKundenName_AuftragSuchenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfKundenName_AuftragSuchenActionPerformed

    private void jtfMinAuftragswert_AuftragSucheActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfMinAuftragswert_AuftragSucheActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfMinAuftragswert_AuftragSucheActionPerformed

    private void jbAnzeigen_AuftragSuchenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAnzeigen_AuftragSuchenActionPerformed
        // Mechmet Impram Ersterstellung
        // Hicran Yörük Erweiterung
        SeiteZwei.setVisible(false);
        jifArtikelAnlegen.setVisible(false);
        jifArtikelAnzeige.setVisible(false);
        jifArtikelBearbeiten.setVisible(false);
        jifArtikelSuche.setVisible(false);
        jifAuftragAnzeigen.setVisible(true);
        jifAuftragSuchen.setVisible(false);
        jifAuftragAnlegen.setVisible(false);
        jifAuftragBearbeiten.setVisible(false);
        jifKundeSuchen.setVisible(false);
        jifLieferantSuchen.setVisible(false);
        jifLieferantAnlegen.setVisible(false);
        jifLieferantAnzeigen.setVisible(false);
        jifLieferantBearbeiten.setVisible(false);
        jifKundeAnlegen.setVisible(false);
        jifKundeAnzeigen.setVisible(false);
        jifKundeBearbeiten.setVisible(false);
        jifAuftragsID_suchen.setVisible(false);
        Startseite.setVisible(false);
    }//GEN-LAST:event_jbAnzeigen_AuftragSuchenActionPerformed

    private void jbAbbrechen_ArtikelAnlegenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAbbrechen_ArtikelAnlegenActionPerformed
        // Mechmet Impram Ersterstellung
        // Hicran Yörük Erweiterung
        SeiteZwei.setVisible(true);
        jifArtikelAnlegen.setVisible(false);
        jifArtikelAnzeige.setVisible(false);
        jifArtikelBearbeiten.setVisible(false);
        jifArtikelSuche.setVisible(false);
        jifAuftragAnzeigen.setVisible(false);
        jifAuftragSuchen.setVisible(false);
        jifAuftragAnlegen.setVisible(false);
        jifAuftragBearbeiten.setVisible(false);
        jifKundeSuchen.setVisible(false);
        jifLieferantSuchen.setVisible(false);
        jifLieferantAnlegen.setVisible(false);
        jifLieferantAnzeigen.setVisible(false);
        jifLieferantBearbeiten.setVisible(false);
        jifKundeAnlegen.setVisible(false);
        jifKundeAnzeigen.setVisible(false);
        jifKundeBearbeiten.setVisible(false);
        jifAuftragsID_suchen.setVisible(false);
        Startseite.setVisible(false);
    }//GEN-LAST:event_jbAbbrechen_ArtikelAnlegenActionPerformed

    private void jbSpeichern_ArtikelAnlegenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSpeichern_ArtikelAnlegenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbSpeichern_ArtikelAnlegenActionPerformed

    private void jtfartikelid_ArtikelAnlegenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfartikelid_ArtikelAnlegenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfartikelid_ArtikelAnlegenActionPerformed

    private void jcbMwst_ArtikelAnlegenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbMwst_ArtikelAnlegenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbMwst_ArtikelAnlegenActionPerformed

    private void jcbSuchkriterium_AuftragSuchenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbSuchkriterium_AuftragSuchenActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jcbSuchkriterium_AuftragSuchenActionPerformed
//    public void jS(){
//          Auftragsstatus aStatus = new Auftragsstatus();
//        String beschreibung = this.jBeschreibung_aa.getText();
//        String erfassungsdatum = this.jtfErfassungsdatum_aa.getText();
//        String lieferdatum = this.jtfLieferdatum_aa.getText();
//        String auftragsart = (String)this.jcbAuftragsart.getSelectedItem();
//        String status  = (String) this.jcbStatus.getSelectedItem();
//        String abschlussDatum = this.jtfAbschlussdatum_aa.getText();
//        System.out.println("Result: " + beschreibung + erfassungsdatum  );
//        Auftrag auftrag = new Auftrag(beschreibung, erfassungsdatum, lieferdatum,
//        auftragsart, aStatus.ueberfuehreAuftragsStatus(status), abschlussDatum);
//        try {
//            DAOAuftrag daoAuftrag = new DAOAuftrag();
//            daoAuftrag.legeNeueAuftragAn(auftrag);
//        }catch (SQLException ex){
//            Logger.getLogger(StartAV.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
    private void jSpeichern_aaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jSpeichern_aaActionPerformed
        //Hicran 18.11.2016
        // Die Daten werden in der Gui-Maske geschrieben und nach bestätigung des Speicher
        //Buttons werden die Daten in die Datenbank gespeichert
        Auftragsstatus aStatus = new Auftragsstatus();
        String beschreibung = this.jBeschreibung_aa.getText();
        String erfassungsdatum = this.jtfErfassungsdatum_aa.getText();
        String lieferdatum = this.jtfLieferdatum_aa.getText();
        String auftragsart = (String)this.jcbAuftragsart.getSelectedItem();
        String status  = (String) this.jcbStatus.getSelectedItem();
        String abschlussDatum = this.jtfAbschlussdatum_aa.getText();
        System.out.println("Result: " + beschreibung + erfassungsdatum  );
        Auftrag auftrag = new Auftrag(beschreibung, erfassungsdatum, lieferdatum,
        auftragsart, aStatus.ueberfuehreAuftragsStatus(status), abschlussDatum);
        try {
            DAOAuftrag daoAuftrag = new DAOAuftrag();
            daoAuftrag.legeNeueAuftragAn(auftrag);
        }catch (SQLException ex){
            Logger.getLogger(StartAV.class.getName()).log(Level.SEVERE, null, ex);
        }
//    jS();
        
    }//GEN-LAST:event_jSpeichern_aaActionPerformed

    private void jrbLieferadresseidentisch_LieferantAnlegenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbLieferadresseidentisch_LieferantAnlegenActionPerformed
        // Duygu Citak Ersterstellung
        Lieferdaten_LieferantAnlegen.setVisible(false);
    }//GEN-LAST:event_jrbLieferadresseidentisch_LieferantAnlegenActionPerformed

    private void jrbabweichendeLieferadresse_LieferantAnlegenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbabweichendeLieferadresse_LieferantAnlegenActionPerformed
        // Duygu Citak Ersterstellung
        Lieferdaten_LieferantAnlegen.setVisible(true);
    }//GEN-LAST:event_jrbabweichendeLieferadresse_LieferantAnlegenActionPerformed

    private void jbBearbeiten_AuftragBearbeitenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBearbeiten_AuftragBearbeitenActionPerformed
        // Hicran Yörük Ersterstellung
        jifAuftragBearbeiten.setVisible(false);
        jifAuftragAnzeigen.setVisible(true);

        // TODO add your handling code here:
    }//GEN-LAST:event_jbBearbeiten_AuftragBearbeitenActionPerformed

    private void jbAnzeigen_LieferantSuchenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAnzeigen_LieferantSuchenActionPerformed
        // Duygu Citak Ersterstellung
        jifLieferantSuchen.setVisible(false);
        jifLieferantAnzeigen.setVisible(true);
    }//GEN-LAST:event_jbAnzeigen_LieferantSuchenActionPerformed

    private void jbAnzeigen_KundeSuchenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAnzeigen_KundeSuchenActionPerformed
        // Duygu Citak Ersterstellung
        KundeSuchen.setVisible(false);
        KundeAnzeigen.setVisible(true);

        // TODO add your handling code here:
    }//GEN-LAST:event_jbAnzeigen_KundeSuchenActionPerformed

    private void miZKAnzeigenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miZKAnzeigenActionPerformed
        // Hicran Yörük Ersterstellung
        if(istEingeloggt==true){
//        SeiteZwei.setVisible(false);
//        ArtikelAnlegen.setVisible(false);
//        ArtikelAnzeige.setVisible(false);
//        ArtikelBearbeiten.setVisible(false);
//        ArtikelSuche.setVisible(false);
//        AuftragAnzeigen.setVisible(false);
//        AuftragSuchen.setVisible(false);
//        AuftragAnlegen.setVisible(false);
//        AuftragBearbeiten.setVisible(false);
//        KundeSuchen.setVisible(false);
//        LieferantSuchen.setVisible(false);
//        LieferantAnlegen.setVisible(false);
//        LieferantAnzeigen.setVisible(false);
//        LieferantBearbeiten.setVisible(false);
//        KundeAnlegen.setVisible(false);
//        KundeAnzeigen.setVisible(false);
//        KundeBearbeiten.setVisible(false);
//        Startseite.setVisible(false);
//        AuftragsID_suchen.setVisible(false);  
        jifZKAnzeigen.setVisible(true);
//        ZKAnlegen.setVisible(false);
//        ZKBearbeiten.setVisible(false);
//        ZKSuchen.setVisible(false);
//        ZKID_suchen.setVisible(false);
        }
        /*----------------------------------------------------------*/
        /* 21.11.16 Samet Variable istEngeloggt, um den Staus des Login zu erfassen
        Bei istEingeloggt=false wird die untesn setehende Fehlermeldung ausgegeben.*/
        /*----------------------------------------------------------*/
        else{
        JOptionPane.showMessageDialog(null,"Bitte einloggen!");
        }
    }//GEN-LAST:event_miZKAnzeigenActionPerformed

    private void miZKAnlegenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miZKAnlegenActionPerformed
        // Hicran Yörük Ersterstellung
    if(istEingeloggt==true){
//        SeiteZwei.setVisible(false);
//        ArtikelAnlegen.setVisible(false);
//        ArtikelAnzeige.setVisible(false);
//        ArtikelBearbeiten.setVisible(false);
//        ArtikelSuche.setVisible(false);
//        AuftragAnzeigen.setVisible(false);
//        AuftragSuchen.setVisible(false);
//        AuftragAnlegen.setVisible(false);
//        AuftragBearbeiten.setVisible(false);
//        KundeSuchen.setVisible(false);
//        LieferantSuchen.setVisible(false);
//        LieferantAnlegen.setVisible(false);
//        LieferantAnzeigen.setVisible(false);
//        LieferantBearbeiten.setVisible(false);
//        KundeAnlegen.setVisible(false);
//        KundeAnzeigen.setVisible(false);
//        KundeBearbeiten.setVisible(false);
//        Startseite.setVisible(false);
//        AuftragsID_suchen.setVisible(false);  
//        ZKAnzeigen.setVisible(false);
        jifZKAnlegen.setVisible(true);
//        ZKBearbeiten.setVisible(false);
//        ZKSuchen.setVisible(false);
//        ZKID_suchen.setVisible(false);
        }
        /*----------------------------------------------------------*/
        /* 21.11.16 Samet Variable istEngeloggt, um den Staus des Login zu erfassen
        Bei istEingeloggt=false wird die untesn setehende Fehlermeldung ausgegeben.*/
        /*----------------------------------------------------------*/
        else{
        JOptionPane.showMessageDialog(null,"Bitte einloggen!");
        }
        
    }//GEN-LAST:event_miZKAnlegenActionPerformed

    private void jcbDatumAuftragsIDSuchenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbDatumAuftragsIDSuchenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbDatumAuftragsIDSuchenActionPerformed

    private void jtfLieferantenname_AuftragsIDSuchenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfLieferantenname_AuftragsIDSuchenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfLieferantenname_AuftragsIDSuchenActionPerformed

    private void jbSuchen_AuftragsIDSuchenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSuchen_AuftragsIDSuchenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbSuchen_AuftragsIDSuchenActionPerformed

    private void jbBearbeiten_ZKAnzeigenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBearbeiten_ZKAnzeigenActionPerformed
//       
    }//GEN-LAST:event_jbBearbeiten_ZKAnzeigenActionPerformed

    private void miZKSucheActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miZKSucheActionPerformed
        // Hicran Yörük Ersterstellung
        if(istEingeloggt==true){
//        SeiteZwei.setVisible(false);
//        ArtikelAnlegen.setVisible(false);
//        ArtikelAnzeige.setVisible(false);
//        ArtikelBearbeiten.setVisible(false);
//        ArtikelSuche.setVisible(false);
//        AuftragAnzeigen.setVisible(false);
//        AuftragSuchen.setVisible(false);
//        AuftragAnlegen.setVisible(false);
//        AuftragBearbeiten.setVisible(false);
//        KundeSuchen.setVisible(false);
//        LieferantSuchen.setVisible(false);
//        LieferantAnlegen.setVisible(false);
//        LieferantAnzeigen.setVisible(false);
//        LieferantBearbeiten.setVisible(false);
//        KundeAnlegen.setVisible(false);
//        KundeAnzeigen.setVisible(false);
//        KundeBearbeiten.setVisible(false);
//        Startseite.setVisible(false);
//        AuftragsID_suchen.setVisible(false);  
//        ZKAnzeigen.setVisible(false);
//        ZKAnlegen.setVisible(false);
//        ZKBearbeiten.setVisible(false);
        jifZKSuchen.setVisible(true);
//        ZKID_suchen.setVisible(false);
        }
        //Samet, Variable istEingeloggt, um den Status eingeloggt oder nicht eingeloggt zu erfassen.
        // Bei istEingeloggt=false wird die unten stehende Fehlermeldung ausgegeben.
        else{
        JOptionPane.showMessageDialog(null,"Bitte einloggen!");
        }
    }//GEN-LAST:event_miZKSucheActionPerformed

    private void miZKBearbeitenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miZKBearbeitenActionPerformed

        // Hicran Yörük Ersterstellung
    if(istEingeloggt==true){

        // Hicran Yörük Ersterstellung, alle Panels werden versteckt bis auf 
        //ZKBearbeiten auf sichtbar gesetzt
//        SeiteZwei.setVisible(false);
//        ArtikelAnlegen.setVisible(false);
//        ArtikelAnzeige.setVisible(false);
//        ArtikelBearbeiten.setVisible(false);
//        ArtikelSuche.setVisible(false);
//        AuftragAnzeigen.setVisible(false);
//        AuftragSuchen.setVisible(false);
//        AuftragAnlegen.setVisible(false);
//        AuftragBearbeiten.setVisible(false);
//        KundeSuchen.setVisible(false);
//        LieferantSuchen.setVisible(false);
//        LieferantAnlegen.setVisible(false);
//        LieferantAnzeigen.setVisible(false);
//        LieferantBearbeiten.setVisible(false);
//        KundeAnlegen.setVisible(false);
//        KundeAnzeigen.setVisible(false);
//        KundeBearbeiten.setVisible(false);
//        Startseite.setVisible(false);
//        AuftragsID_suchen.setVisible(false);  
//        ZKAnzeigen.setVisible(false);
//        ZKAnlegen.setVisible(false);
        jifZKBearbeiten.setVisible(true);
//        ZKSuchen.setVisible(false);
//        ZKID_suchen.setVisible(false);
        }
        /*----------------------------------------------------------*/
        /* 21.11.16 Samet Variable istEngeloggt, um den Staus des Login zu erfassen
        Bei istEingeloggt=false wird die untesn setehende Fehlermeldung ausgegeben.*/
        /*----------------------------------------------------------*/
        else{
        JOptionPane.showMessageDialog(null,"Bitte einloggen!");
        }
    }//GEN-LAST:event_miZKBearbeitenActionPerformed

    private void jbAbbrechen_ZKAnzeigenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAbbrechen_ZKAnzeigenActionPerformed
        // Hicran Yörük Ersterstellung
        SeiteZwei.setVisible(true);
        jifZKAnzeigen.setVisible(false);        
    }//GEN-LAST:event_jbAbbrechen_ZKAnzeigenActionPerformed

    private void jbAbbrechen_ZKAnlegenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAbbrechen_ZKAnlegenActionPerformed
        // Hicran Yörük Ersterstellung
        SeiteZwei.setVisible(true);
        jifZKAnlegen.setVisible(false);
    }//GEN-LAST:event_jbAbbrechen_ZKAnlegenActionPerformed

    private void jbAbbrechen_ZKBearbeitenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAbbrechen_ZKBearbeitenActionPerformed
        // Hicran Yörük Ersterstellung
        SeiteZwei.setVisible(true);
        jifZKBearbeiten.setVisible(false);
    }//GEN-LAST:event_jbAbbrechen_ZKBearbeitenActionPerformed

    private void jbAbbrechen_ZKSuchenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAbbrechen_ZKSuchenActionPerformed
        // Hicran Yörük Ersterstellung
        SeiteZwei.setVisible(true);
        jifZKSuchen.setVisible(false);
    }//GEN-LAST:event_jbAbbrechen_ZKSuchenActionPerformed

    private void jbAbbrechen_ZKIDSuchenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAbbrechen_ZKIDSuchenActionPerformed
        // Hicran Yörük Ersterstellung
        SeiteZwei.setVisible(true);
       
    }//GEN-LAST:event_jbAbbrechen_ZKIDSuchenActionPerformed

    private void jbBearbeiten_ZKBearbeitenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBearbeiten_ZKBearbeitenActionPerformed
        // Hicran Yörük Ersterstellung
        jifZKBearbeiten.setVisible(false);
        jifZKAnzeigen.setVisible(true);
    }//GEN-LAST:event_jbBearbeiten_ZKBearbeitenActionPerformed

    private void jbAnzeigen_ZKSuchenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAnzeigen_ZKSuchenActionPerformed
        // Hicran Yörük ErsterstellungZKSuchen.setVisible(false);
        jifZKAnzeigen.setVisible(true);
    }//GEN-LAST:event_jbAnzeigen_ZKSuchenActionPerformed

    private void jbAnzeigen_ZKIDSuchenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAnzeigen_ZKIDSuchenActionPerformed
        // Hicran Yörük Ersterstellung
        jifZKID_suchen.setVisible(false);
        jifZKAnzeigen.setVisible(true);
    }//GEN-LAST:event_jbAnzeigen_ZKIDSuchenActionPerformed

    private void jtfMahnzeit1_ZKAnzeigenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfMahnzeit1_ZKAnzeigenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfMahnzeit1_ZKAnzeigenActionPerformed

    private void jtfMahnzeit2_ZKAnzeigenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfMahnzeit2_ZKAnzeigenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfMahnzeit2_ZKAnzeigenActionPerformed

    private void jbLupe_ZKAnzeigenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbLupe_ZKAnzeigenActionPerformed
        // Hicran Yörük Ersterstellung
        jifZKAnzeigen.setVisible(false);
        jifZKID_suchen.setVisible(true);
    }//GEN-LAST:event_jbLupe_ZKAnzeigenActionPerformed

    private void jtfMenge_AuftragAnlegenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfMenge_AuftragAnlegenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfMenge_AuftragAnlegenActionPerformed

    private void jbSpeichern_ZKAnlegenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSpeichern_ZKAnlegenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbSpeichern_ZKAnlegenActionPerformed

    private void jftfLieferdatum_azActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jftfLieferdatum_azActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jftfLieferdatum_azActionPerformed

    private void jtfZKID_azActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfZKID_azActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfZKID_azActionPerformed

    private void jcbAuftragsart_azActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbAuftragsart_azActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbAuftragsart_azActionPerformed

    private void jtfAbschlussdatum_azActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfAbschlussdatum_azActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfAbschlussdatum_azActionPerformed

    private void jbSpeichern_LieferantAnlegenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSpeichern_LieferantAnlegenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbSpeichern_LieferantAnlegenActionPerformed

    private void jtfSuchkriterium_KundeSuchenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfSuchkriterium_KundeSuchenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfSuchkriterium_KundeSuchenActionPerformed

    private void jbSpeichern_azActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSpeichern_azActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbSpeichern_azActionPerformed

    private void jcbAuftragsartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbAuftragsartActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbAuftragsartActionPerformed

    private void jmDateiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmDateiActionPerformed
if(istEingeloggt==true){
}
else{
     JOptionPane.showMessageDialog(null,"Sie müssen eingeloggt sein, um sich abmelden zu können !");
     }
        
// TODO add your handling code here:
    }//GEN-LAST:event_jmDateiActionPerformed

    private void jmAuftragActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmAuftragActionPerformed
if(istEingeloggt==true){
        
    
    
    
    }/*----------------------------------------------------------*/
        /* 21.11.16 Samet Variable istEngeloggt, um den Staus des Login zu erfassen
        Bei istEingeloggt=false wird die untesn setehende Fehlermeldung ausgegeben.*/
        /*----------------------------------------------------------*/
        else{
        JOptionPane.showMessageDialog(null,"Bitte einloggen!");
        }
                // TODO add your handling code here:
    }//GEN-LAST:event_jmAuftragActionPerformed

    private void jmSucheActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmSucheActionPerformed
    // TODO add your handling code here:
    
    if(istEingeloggt==true){
        
    }
    else{
        
    }
    }//GEN-LAST:event_jmSucheActionPerformed

    private void jmArtikelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmArtikelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jmArtikelActionPerformed

    private void jtfGPID_KundeAnlegenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfGPID_KundeAnlegenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfGPID_KundeAnlegenActionPerformed
    /*
    Duygu Citak
    */
    private void jrbLieferadresseIdentisch_KundeAnlegenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbLieferadresseIdentisch_KundeAnlegenActionPerformed
        jPLieferdaten.setVisible(false);
    }//GEN-LAST:event_jrbLieferadresseIdentisch_KundeAnlegenActionPerformed

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
    /*
    Duygu Citak 
    */
    private void jrbAbweichendeLieferadresse_KundeAnlegenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbAbweichendeLieferadresse_KundeAnlegenActionPerformed
      jPLieferdaten.setVisible(true);
    }//GEN-LAST:event_jrbAbweichendeLieferadresse_KundeAnlegenActionPerformed

    private void jbanmelden_StartseiteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbanmelden_StartseiteActionPerformed
        /* Mechmet Impram
        Hier werden BN und Passwort mit eingelegte Benutzer auf Richtigkeit vergleichen
        wenn richtig, die Fenster anzeigen, solange muss die Menu invisible sein.
        */

        Startseite.setVisible(false);
        SeiteZwei.setVisible(true);
        istEingeloggt=true;
    }//GEN-LAST:event_jbanmelden_StartseiteActionPerformed

    private void jtfbestelltext_ArtikelAnzeigenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfbestelltext_ArtikelAnzeigenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfbestelltext_ArtikelAnzeigenActionPerformed

    private void jtfeinzelwertbrutto_ArtikelAnlegenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfeinzelwertbrutto_ArtikelAnlegenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfeinzelwertbrutto_ArtikelAnlegenActionPerformed

    private void jtfreserviert_ArtikelAnzeigenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfreserviert_ArtikelAnzeigenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfreserviert_ArtikelAnzeigenActionPerformed

    private void jtfartikelname_ArtikelAnzeigenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfartikelname_ArtikelAnzeigenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfartikelname_ArtikelAnzeigenActionPerformed

    private void jtfartikeltext_ArtikelAnlegenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfartikeltext_ArtikelAnlegenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfartikeltext_ArtikelAnlegenActionPerformed

    private void jtfbestelltext_ArtikelAnlegenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfbestelltext_ArtikelAnlegenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfbestelltext_ArtikelAnlegenActionPerformed
    
    
   
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(StartAV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StartAV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StartAV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StartAV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StartAV().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ArtikelAnlegen;
    private javax.swing.JPanel ArtikelAnzeige;
    private javax.swing.JPanel ArtikelBearbeiten;
    private javax.swing.JPanel ArtikelSuche;
    private javax.swing.JPanel AuftragAnlegen;
    private javax.swing.JPanel AuftragAnzeigen;
    private javax.swing.JPanel AuftragBearbeiten;
    private javax.swing.JPanel AuftragSuchen;
    private javax.swing.JPanel AuftragsID_suchen;
    private javax.swing.JPanel Auftragsposition_AuftragAnlegen;
    private javax.swing.JPanel Kontakt_LieferantAnlegen;
    private javax.swing.JPanel KundeAnlegen;
    private javax.swing.JPanel KundeAnzeigen;
    private javax.swing.JPanel KundeBearbeiten;
    private javax.swing.JPanel KundeSuchen;
    private javax.swing.JPanel LieferantAnlegen;
    private javax.swing.JPanel LieferantAnzeigen;
    private javax.swing.JPanel LieferantBearbeiten;
    private javax.swing.JPanel LieferantSuchen;
    private javax.swing.JPanel Lieferdaten_LieferantAnlegen;
    private javax.swing.JPanel Mahnzeit_ZKAnzeigen;
    private javax.swing.JPanel Rechnungsdaten_LieferantAnlegen;
    private javax.swing.JPanel SeiteZwei;
    private javax.swing.JPanel Skonto_ZKAnzeigen;
    private javax.swing.JPanel Startseite;
    private javax.swing.JPanel ZKAnlegen;
    private javax.swing.JPanel ZKAnzeigen;
    private javax.swing.JPanel ZKBearbeiten;
    private javax.swing.JPanel ZKID_suchen;
    private javax.swing.JPanel ZKSuchen;
    private javax.swing.JButton abbrechen_KundeAnlegen;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JDesktopPane desktopPane;
    private javax.swing.JTextArea jBeschreibung_aa;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel100;
    private javax.swing.JLabel jLabel101;
    private javax.swing.JLabel jLabel102;
    private javax.swing.JLabel jLabel103;
    private javax.swing.JLabel jLabel104;
    private javax.swing.JLabel jLabel105;
    private javax.swing.JLabel jLabel106;
    private javax.swing.JLabel jLabel107;
    private javax.swing.JLabel jLabel108;
    private javax.swing.JLabel jLabel109;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel110;
    private javax.swing.JLabel jLabel111;
    private javax.swing.JLabel jLabel112;
    private javax.swing.JLabel jLabel113;
    private javax.swing.JLabel jLabel114;
    private javax.swing.JLabel jLabel115;
    private javax.swing.JLabel jLabel116;
    private javax.swing.JLabel jLabel117;
    private javax.swing.JLabel jLabel118;
    private javax.swing.JLabel jLabel119;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel120;
    private javax.swing.JLabel jLabel121;
    private javax.swing.JLabel jLabel122;
    private javax.swing.JLabel jLabel123;
    private javax.swing.JLabel jLabel124;
    private javax.swing.JLabel jLabel125;
    private javax.swing.JLabel jLabel126;
    private javax.swing.JLabel jLabel127;
    private javax.swing.JLabel jLabel128;
    private javax.swing.JLabel jLabel129;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel130;
    private javax.swing.JLabel jLabel131;
    private javax.swing.JLabel jLabel132;
    private javax.swing.JLabel jLabel133;
    private javax.swing.JLabel jLabel134;
    private javax.swing.JLabel jLabel135;
    private javax.swing.JLabel jLabel136;
    private javax.swing.JLabel jLabel137;
    private javax.swing.JLabel jLabel138;
    private javax.swing.JLabel jLabel139;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel140;
    private javax.swing.JLabel jLabel141;
    private javax.swing.JLabel jLabel142;
    private javax.swing.JLabel jLabel143;
    private javax.swing.JLabel jLabel144;
    private javax.swing.JLabel jLabel145;
    private javax.swing.JLabel jLabel146;
    private javax.swing.JLabel jLabel147;
    private javax.swing.JLabel jLabel148;
    private javax.swing.JLabel jLabel149;
    private javax.swing.JLabel jLabel15;
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
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel160;
    private javax.swing.JLabel jLabel161;
    private javax.swing.JLabel jLabel162;
    private javax.swing.JLabel jLabel163;
    private javax.swing.JLabel jLabel164;
    private javax.swing.JLabel jLabel165;
    private javax.swing.JLabel jLabel166;
    private javax.swing.JLabel jLabel167;
    private javax.swing.JLabel jLabel168;
    private javax.swing.JLabel jLabel169;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel170;
    private javax.swing.JLabel jLabel171;
    private javax.swing.JLabel jLabel172;
    private javax.swing.JLabel jLabel173;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
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
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JLabel jLabel88;
    private javax.swing.JLabel jLabel89;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel90;
    private javax.swing.JLabel jLabel91;
    private javax.swing.JLabel jLabel92;
    private javax.swing.JLabel jLabel93;
    private javax.swing.JLabel jLabel94;
    private javax.swing.JLabel jLabel95;
    private javax.swing.JLabel jLabel96;
    private javax.swing.JLabel jLabel97;
    private javax.swing.JLabel jLabel98;
    private javax.swing.JLabel jLabel99;
    private javax.swing.JPanel jPKontakt;
    private javax.swing.JPanel jPLieferdaten;
    private javax.swing.JPanel jPRechnungsdaten;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JSeparator jSeparator12;
    private javax.swing.JSeparator jSeparator13;
    private javax.swing.JSeparator jSeparator14;
    private javax.swing.JSeparator jSeparator15;
    private javax.swing.JSeparator jSeparator16;
    private javax.swing.JSeparator jSeparator17;
    private javax.swing.JSeparator jSeparator18;
    private javax.swing.JSeparator jSeparator19;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator20;
    private javax.swing.JSeparator jSeparator21;
    private javax.swing.JSeparator jSeparator22;
    private javax.swing.JSeparator jSeparator23;
    private javax.swing.JSeparator jSeparator24;
    private javax.swing.JSeparator jSeparator25;
    private javax.swing.JSeparator jSeparator26;
    private javax.swing.JSeparator jSeparator27;
    private javax.swing.JSeparator jSeparator28;
    private javax.swing.JSeparator jSeparator29;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JButton jbAbbrechen_ArtikelAnlegen;
    private javax.swing.JButton jbAbbrechen_ArtikelBearbeiten;
    private javax.swing.JButton jbAbbrechen_ArtikelSuche;
    private javax.swing.JButton jbAbbrechen_AuftragBearbeiten;
    private javax.swing.JButton jbAbbrechen_AuftragsIDSuchen;
    private javax.swing.JButton jbAbbrechen_KundeSuchen;
    private javax.swing.JButton jbAbbrechen_LieferantAnlegen;
    private javax.swing.JButton jbAbbrechen_LieferantSuchen;
    private javax.swing.JButton jbAbbrechen_ZKAnlegen;
    private javax.swing.JButton jbAbbrechen_ZKAnzeigen;
    private javax.swing.JButton jbAbbrechen_ZKBearbeiten;
    private javax.swing.JButton jbAbbrechen_ZKIDSuchen;
    private javax.swing.JButton jbAbbrechen_ZKSuchen;
    private javax.swing.JButton jbAbbrechen_aa;
    private javax.swing.JButton jbAnzeigen_ArtikelSuche;
    private javax.swing.JButton jbAnzeigen_AuftragSuchen;
    private javax.swing.JButton jbAnzeigen_KundeSuchen;
    private javax.swing.JButton jbAnzeigen_LieferantSuchen;
    private javax.swing.JButton jbAnzeigen_ZKIDSuchen;
    private javax.swing.JButton jbAnzeigen_ZKSuchen;
    private javax.swing.JButton jbBearbeiten_ArtikelBearbeiten;
    private javax.swing.JButton jbBearbeiten_AuftragBearbeiten;
    private javax.swing.JButton jbBearbeiten_ZKAnzeigen;
    private javax.swing.JButton jbBearbeiten_ZKBearbeiten;
    private javax.swing.JButton jbBearbeiten_az;
    private javax.swing.JButton jbLupe_AuftragAnlegen;
    private javax.swing.JButton jbLupe_ZKAnzeigen;
    private javax.swing.JButton jbMinus_AuftragAnlegen;
    private javax.swing.JButton jbPlus_AuftragAnlegen;
    private javax.swing.JButton jbSpeichern;
    private javax.swing.JButton jbSpeichern_ArtikelAnlegen;
    private javax.swing.JButton jbSpeichern_ArtikelAnzeigen;
    private javax.swing.JButton jbSpeichern_LieferantAnlegen;
    private javax.swing.JButton jbSpeichern_ZKAnlegen;
    private javax.swing.JButton jbSpeichern_ZKAnzeigen;
    private javax.swing.JButton jbSpeichern_az;
    private javax.swing.JButton jbSuchen_ArtikelSuche;
    private javax.swing.JButton jbSuchen_AuftragSuchen;
    private javax.swing.JButton jbSuchen_AuftragsIDSuchen;
    private javax.swing.JButton jbSuchen_KundeSuchen;
    private javax.swing.JButton jbSuchen_ZKSuchen;
    private javax.swing.JButton jbZurueck_AutragSuchen;
    private javax.swing.JButton jbZurueck_az;
    private javax.swing.JButton jbabbrechen_ArtikelAnzeigen;
    private javax.swing.JButton jbanmelden_Startseite;
    private javax.swing.JButton jbbearbeiten_ArtikelAnzeigen;
    private javax.swing.JButton jbzurueck_LieferantAnzeigen;
    private javax.swing.JButton jbzurueck_LieferantBearbeiten;
    private javax.swing.JComboBox<String> jcbAnrede2_LieferantAnlegen;
    private javax.swing.JComboBox<String> jcbAnredeRG_KundeAnlegen;
    private javax.swing.JComboBox<String> jcbAnredeRG_LieferantAnlegen;
    private javax.swing.JComboBox jcbArtikelID_ArtikelSuche;
    private javax.swing.JComboBox<String> jcbAuftragsart;
    private javax.swing.JComboBox<String> jcbAuftragsart_ZKAnzeigen;
    private javax.swing.JComboBox<String> jcbAuftragsart_ZKSuchen;
    private javax.swing.JComboBox<String> jcbAuftragsart_az;
    private javax.swing.JComboBox<String> jcbDatumAuftragsIDSuchen;
    private javax.swing.JComboBox jcbMwst_ArtikelAnlegen;
    private javax.swing.JComboBox<String> jcbStatus;
    private javax.swing.JComboBox jcbStatusArt_AuftragSuche;
    private javax.swing.JComboBox jcbStatus_AuftragSuche;
    private javax.swing.JComboBox<String> jcbStatus_AuftragsIDSuchen;
    private javax.swing.JComboBox<String> jcbStatus_az;
    private javax.swing.JComboBox jcbSuchkriterium_AuftragSuchen;
    private javax.swing.JComboBox<String> jcbSuchkriterium_KundeSuchen;
    private javax.swing.JComboBox<String> jcbSuchkriterium_LieferantSuchen;
    private javax.swing.JComboBox<String> jcbSuchkriterium_ZKSuchen;
    private javax.swing.JComboBox jcbmehrwertsteuer_ArtikelAnzeigen;
    private javax.swing.JFormattedTextField jftfErfassungsdatum_AuftragSuche;
    private javax.swing.JFormattedTextField jftfErfassungsdatum_az;
    private javax.swing.JFormattedTextField jftfLieferdatum_AuftragSuche;
    private javax.swing.JFormattedTextField jftfLieferdatum_az;
    private javax.swing.JInternalFrame jifArtikelAnlegen;
    private javax.swing.JInternalFrame jifArtikelAnzeige;
    private javax.swing.JInternalFrame jifArtikelBearbeiten;
    private javax.swing.JInternalFrame jifArtikelSuche;
    private javax.swing.JInternalFrame jifAuftragAnlegen;
    private javax.swing.JInternalFrame jifAuftragAnzeigen;
    private javax.swing.JInternalFrame jifAuftragBearbeiten;
    private javax.swing.JInternalFrame jifAuftragSuchen;
    private javax.swing.JInternalFrame jifAuftragsID_suchen;
    private javax.swing.JInternalFrame jifKundeAnlegen;
    private javax.swing.JInternalFrame jifKundeAnzeigen;
    private javax.swing.JInternalFrame jifKundeBearbeiten;
    private javax.swing.JInternalFrame jifKundeSuchen;
    private javax.swing.JInternalFrame jifLieferantAnlegen;
    private javax.swing.JInternalFrame jifLieferantAnzeigen;
    private javax.swing.JInternalFrame jifLieferantBearbeiten;
    private javax.swing.JInternalFrame jifLieferantSuchen;
    private javax.swing.JInternalFrame jifZKAnlegen;
    private javax.swing.JInternalFrame jifZKAnzeigen;
    private javax.swing.JInternalFrame jifZKBearbeiten;
    private javax.swing.JInternalFrame jifZKID_suchen;
    private javax.swing.JInternalFrame jifZKSuchen;
    private javax.swing.JLabel jlAbschlussdatum;
    private javax.swing.JLabel jlAuftragsart;
    private javax.swing.JLabel jlAuftragsid;
    private javax.swing.JLabel jlAuftragsnr_as;
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
    private javax.swing.JMenu jmArtikel;
    private javax.swing.JMenu jmAuftrag;
    private javax.swing.JMenu jmDatei;
    private javax.swing.JMenu jmGeschäftspartner;
    private javax.swing.JMenu jmKunde;
    private javax.swing.JMenu jmLieferant;
    private javax.swing.JMenu jmSuche;
    private javax.swing.JMenu jmZahlungskondition;
    private javax.swing.JPasswordField jpwpasswort_Startseite;
    private javax.swing.JRadioButton jrbAbweichendeLieferadresse_KundeAnlegen;
    private javax.swing.JRadioButton jrbLieferadresseIdentisch_KundeAnlegen;
    private javax.swing.JRadioButton jrbLieferadresseidentisch_LieferantAnlegen;
    private javax.swing.JRadioButton jrbabweichendeLieferadresse_LieferantAnlegen;
    private javax.swing.JTextField jrfTelefax_KundeAnlegen;
    private javax.swing.JTable jtTabelle_AuftragSuche;
    private javax.swing.JTable jt_ArtikelSuche;
    private javax.swing.JTable jt_KundeSuchen;
    private javax.swing.JTable jt_LieferantSuchen;
    private javax.swing.JTable jt_ZKSuchen;
    private javax.swing.JTextArea jtaBeschreibung_az;
    private javax.swing.JTextField jtfAbschlussdatum_aa;
    private javax.swing.JTextField jtfAbschlussdatum_az;
    private javax.swing.JTextField jtfArtikelID_ArtikelAnzeigen;
    private javax.swing.JTextField jtfArtikelID_AuftragAnlegen;
    private javax.swing.JTextField jtfArtikelname_AuftragAnlegen;
    private javax.swing.JTextField jtfAuftragsID_AuftragBearbeiten;
    private javax.swing.JTextField jtfAuftragsID_AuftragSuchen;
    private javax.swing.JTextField jtfAuftragsart_ZKAnlegen;
    private javax.swing.JTextField jtfAuftragsid_aa;
    private javax.swing.JTextField jtfAuftragsid_az;
    private javax.swing.JTextField jtfAuftragswertbrutto_az;
    private javax.swing.JTextField jtfAuftragswertnetto_az;
    private javax.swing.JTextField jtfBenutzername_Startseite;
    private javax.swing.JTextField jtfDatum_AuftragsIDSuchen;
    private javax.swing.JTextField jtfEMail_KundeAnlegen;
    private javax.swing.JTextField jtfEinzelwert_AuftragAnlegen;
    private javax.swing.JTextField jtfEmail_LieferantAnlegen;
    private javax.swing.JTextField jtfErfassungsdatum_aa;
    private javax.swing.JTextField jtfFax_LieferantAnlegen;
    private javax.swing.JTextField jtfFirma2_KundeAnlegen;
    private javax.swing.JTextField jtfFirma2_LieferantAnlegen;
    private javax.swing.JTextField jtfFirmaRG_KundeAnlegen;
    private javax.swing.JTextField jtfFirmaRG_LieferantAnlegen;
    private javax.swing.JTextField jtfGPID_KundeAnlegen;
    private javax.swing.JTextField jtfGPID_LieferantAnlegen;
    private javax.swing.JTextField jtfGPID_aa;
    private javax.swing.JTextField jtfGPID_az;
    private javax.swing.JTextField jtfGPName_az;
    private javax.swing.JTextField jtfGPadresse_az;
    private javax.swing.JTextField jtfGPname_aa;
    private javax.swing.JTextField jtfGesamtwert_AuftragAnlegen;
    private javax.swing.JTextField jtfHNr2_LieferantAnlegen;
    private javax.swing.JTextField jtfHNrRG_KundeAnlegen;
    private javax.swing.JTextField jtfHNrRG_LieferantAnlegen;
    private javax.swing.JTextField jtfKreditlimit_KundenAnlegen;
    private javax.swing.JTextField jtfKreditlimit_LieferantAnlegen;
    private javax.swing.JTextField jtfKundenName_AuftragSuchen;
    private javax.swing.JTextField jtfKundenname_AuftragsIDSuchen;
    private javax.swing.JTextField jtfLieferantenname_AuftragSuche;
    private javax.swing.JTextField jtfLieferantenname_AuftragsIDSuchen;
    private javax.swing.JTextField jtfLieferdatum_aa;
    private javax.swing.JTextField jtfLieferzeitSofort_ZKAnlegen;
    private javax.swing.JTextField jtfLieferzeitSofort_ZKAnzeigen;
    private javax.swing.JTextField jtfLieferzeitSofort_ZKIDSuchen;
    private javax.swing.JTextField jtfLieferzeitWunsch_ZKIDSuchen;
    private javax.swing.JTextField jtfMahnzeit1_ZKAnlegen;
    private javax.swing.JTextField jtfMahnzeit1_ZKAnzeigen;
    private javax.swing.JTextField jtfMahnzeit1_ZKIDSuchen;
    private javax.swing.JTextField jtfMahnzeit2_ZKAnlegen;
    private javax.swing.JTextField jtfMahnzeit2_ZKAnzeigen;
    private javax.swing.JTextField jtfMahnzeit3_ZKAnlegen;
    private javax.swing.JTextField jtfMahnzeit3_ZKAnzeigen;
    private javax.swing.JTextField jtfMaxAuftragswert_AuftragSuche;
    private javax.swing.JTextField jtfMenge_AuftragAnlegen;
    private javax.swing.JTextField jtfMinAuftragswert_AuftragSuche;
    private javax.swing.JTextField jtfName2_KundeAnlegen;
    private javax.swing.JTextField jtfName2_LieferantAnlegen;
    private javax.swing.JTextField jtfNameRG_KundeAnlegen;
    private javax.swing.JTextField jtfNameRG_LieferantAnlegen;
    private javax.swing.JTextField jtfOrt2_LieferantAnlegen;
    private javax.swing.JTextField jtfOrtRG_KundeAnlegen;
    private javax.swing.JTextField jtfOrtRG_LieferantAnlegen;
    private javax.swing.JTextField jtfPlz2_KundeAnlegen;
    private javax.swing.JTextField jtfPlz2_LieferantAnlegen;
    private javax.swing.JTextField jtfPlzRG_KundeAnlegen;
    private javax.swing.JTextField jtfPlzRG_LieferantAnlegen;
    private javax.swing.JTextField jtfPositionsID_AuftragAnlegen;
    private javax.swing.JTextField jtfSkontofrist1_ZKAnlegen;
    private javax.swing.JTextField jtfSkontofrist1_ZKAnzeigen;
    private javax.swing.JTextField jtfSkontofrist2_ZKAnlegen;
    private javax.swing.JTextField jtfSkontofrist2_ZKAnzeigen;
    private javax.swing.JTextField jtfSkontosatz1_ZKAnlegen;
    private javax.swing.JTextField jtfSkontosatz1_ZKAnzeigen;
    private javax.swing.JTextField jtfSkontosatz2_ZKAnlegen;
    private javax.swing.JTextField jtfSkontosatz2_ZKAnzeigen;
    private javax.swing.JTextField jtfSkontozeit1_ZKIDSuchen;
    private javax.swing.JTextField jtfSperrzeitWunsch_ZKAnlegen;
    private javax.swing.JTextField jtfSperrzeitWunsch_ZKAnzeigen;
    private javax.swing.JTextField jtfStaat2_KundeAnlegen;
    private javax.swing.JTextField jtfStaat2_LieferantAnlegen;
    private javax.swing.JTextField jtfStaatRG_KundeAnlegen;
    private javax.swing.JTextField jtfStaatRG_LieferantAnlegen;
    private javax.swing.JTextField jtfStraße2_KundeAnlegen;
    private javax.swing.JTextField jtfStraße2_LieferantAnlegen;
    private javax.swing.JTextField jtfStraßeRG_KundeAnlegen;
    private javax.swing.JTextField jtfStraßeRG_LieferantAnlegen;
    private javax.swing.JTextField jtfSuchkriterium_KundeSuchen;
    private javax.swing.JTextField jtfSuchkriterium_LieferantSuchen;
    private javax.swing.JTextField jtfSuchkriterium_ZKSuchen;
    private javax.swing.JTextField jtfTel_LieferantAnlegen;
    private javax.swing.JTextField jtfTelefon_KundeAnlegen;
    private javax.swing.JTextField jtfVorname2_KundeAnlegen;
    private javax.swing.JTextField jtfVorname2_LieferantAnlegen;
    private javax.swing.JTextField jtfVornameRG_KundeAnlegen;
    private javax.swing.JTextField jtfVornameRG_LieferantAnlegen;
    private javax.swing.JTextField jtfZKID_ZKAnlegen;
    private javax.swing.JTextField jtfZKID_ZKAnzeigen;
    private javax.swing.JTextField jtfZKID_ZKBearbeiten;
    private javax.swing.JTextField jtfZKID_az;
    private javax.swing.JTextField jtfartikelid_ArtikelAnlegen;
    private javax.swing.JTextField jtfartikelid_ArtikelBearbeiten;
    private javax.swing.JTextField jtfartikelname_ArtikelAnlegen;
    private javax.swing.JTextField jtfartikelname_ArtikelAnzeigen;
    private javax.swing.JTextField jtfartikeltext_ArtikelAnlegen;
    private javax.swing.JTextField jtfartikeltext_ArtikelAnzeigen;
    private javax.swing.JTextField jtfbestelltext_ArtikelAnlegen;
    private javax.swing.JTextField jtfbestelltext_ArtikelAnzeigen;
    private javax.swing.JTextField jtfbestellwertbrutto_ArtikelAnlegen;
    private javax.swing.JTextField jtfbestellwertbrutto_ArtikelAnzeigen;
    private javax.swing.JTextField jtfbestellwertnetto_ArtikelAnlegen;
    private javax.swing.JTextField jtfbestellwertnetto_ArtikelAnzeigen;
    private javax.swing.JTextField jtfeinzelwertbrutto_ArtikelAnlegen;
    private javax.swing.JTextField jtfeinzelwertbrutto_ArtikelAnzeigen;
    private javax.swing.JTextField jtfeinzelwertnetto_ArtikelAnlegen;
    private javax.swing.JTextField jtfeinzelwertnetto_ArtikelAnzeigen;
    private javax.swing.JTextField jtffrei_ArtikelAnlegen;
    private javax.swing.JTextField jtffrei_ArtikelAnzeigen;
    private javax.swing.JTextField jtfreserviert_ArtikelAnlegen;
    private javax.swing.JTextField jtfreserviert_ArtikelAnzeigen;
    private javax.swing.JTextField jtfverkauft_ArtikelAnlegen;
    private javax.swing.JTextField jtfverkauft_ArtikelAnzeigen;
    private javax.swing.JTextField jtfzulauf_ArtikelAnlegen;
    private javax.swing.JTextField jtfzulauf_ArtikelAnzeigen;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem miAbmelden;
    private javax.swing.JMenuItem miArtikelSuche;
    private javax.swing.JMenuItem miArtikelanlegen;
    private javax.swing.JMenuItem miArtikelanzeigen;
    private javax.swing.JMenuItem miArtikelbearbeiten;
    private javax.swing.JMenuItem miAuftragSuche;
    private javax.swing.JMenuItem miAuftraganlegen;
    private javax.swing.JMenuItem miAuftraganzeigen;
    private javax.swing.JMenuItem miAuftragbearbeiten;
    private javax.swing.JMenuItem miBeenden;
    private javax.swing.JMenuItem miKundeSuche;
    private javax.swing.JMenuItem miKundeanlegen;
    private javax.swing.JMenuItem miKundeanzeigen;
    private javax.swing.JMenuItem miKundebearbeiten;
    private javax.swing.JMenuItem miLieferantSuche;
    private javax.swing.JMenuItem miLieferantanlegen;
    private javax.swing.JMenuItem miLieferantanzeigen;
    private javax.swing.JMenuItem miLieferantbearbeiten;
    private javax.swing.JMenuItem miZKAnlegen;
    private javax.swing.JMenuItem miZKAnzeigen;
    private javax.swing.JMenuItem miZKBearbeiten;
    private javax.swing.JMenuItem miZKSuche;
    private javax.swing.JLabel titel_as;
    private javax.swing.JLabel titel_az;
    private javax.swing.JButton zurueck_KundeAnzeigen;
    private javax.swing.JButton zurueck_KundeBearbeiten;
    // End of variables declaration//GEN-END:variables

}
