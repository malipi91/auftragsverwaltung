/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JTable;
import model.Auftragsposition;
import util.DBConnection;
import util.Zusatzfunktionen;

/*----------------------------------------------------------*/
/* Datum Name Was                                           */
/* 24.11.16 Duygu Citak Anlegen der Klasse                  */
/* 03.12.16 MaLi Überabeiten der Methoden und Erweiter      */
/*----------------------------------------------------------*/
/**
 *
 * @author Martin Lipinski 
 */
public class DAOAuftragsposition {

    public static Auftragsposition position_aus_Tabelle(ArrayList<Auftragsposition> auftragsPositionen, Auftragsposition auftragsposition) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static Auftragsposition position_aus_Tabelle(JTable jTAuftragsposition) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    /*----------------------------------------------------------*/
    /* Datum Name Was                                           */
    /* 24.11.16 Duygu Citak Variablendeklaration               */
    /*----------------------------------------------------------*/
    
    private DAODataDictionary dd;
    private Zusatzfunktionen zf;
    
    
    private final String TAB_AUFTRAGSPOSITION = "auftragsposition";

    /*----------------------------------------------------------*/
    /* Datum Name Was                                           */
    /* 24.11.16 Duygu Citak Anlegen der Methode                 */
    /* 01.12.16 MaLi Überarbeiten der Methode                   */
    /*----------------------------------------------------------*/
    /**
     * Konstruktor der ein Objekt des DAOAuftragsposition erzeugt. 
    */
    public DAOAuftragsposition(){
        dd = new DAODataDictionary();
        zf = new Zusatzfunktionen();
    }
    

    /*----------------------------------------------------------*/
    /* Datum Name Was                                           */
    /* 24.11.16 Duygu Citak Anlegen der Methode                 */
    /* 24.11.16 MaLi Überarbeiten der Methode                   */
    /*----------------------------------------------------------*/
    /**
     * Diese Methode dient zum Anlegen einer neuen Auftragsposition in der DB.
     * Dazu erhält Sie die Werte aus der GUI über das Auftragsposition-Objekt.
     * @param auftragsposition Objekt der Klasse Auftragsposition
     * @throws SQLException
     */
    public void legeNeueAuftragspositionAn(Auftragsposition auftragsposition) throws SQLException{
        // Erhält die letzte angelegte Auftragspositionsnummer
        String letzteID = dd.bekommeLetzteID(TAB_AUFTRAGSPOSITION);
        // Erzeugt eine neue Verbindung zur DB.
        DBConnection con = new DBConnection();
        // Übergibt die Connection an eine lok. Variable vom Typ Connection.
        Connection conn = con.createConection();
 
        // Statement was das Einfügen der Daten in die DB ausführt.
        String sql = "insert into auftragsposition "
            + "(Auftragskopf_ID,Positionsnummer,Menge,Einzelwert,"
            + "Materialnummer "
            + "values (?,?,?,?,?)";
        
        // Erzeugen eines PreparedStatement.
        PreparedStatement stmt = conn.prepareStatement(sql);
        
        // Übergeben der Werte aus dem Objekt Auftragsposition.
        stmt.setString(1, letzteID);
        stmt.setInt(2, auftragsposition.getPositionsnummer());
        stmt.setInt(3, auftragsposition.getMenge());
        stmt.setInt(4, auftragsposition.getEinzelwert());
        stmt.setString(5, auftragsposition.getArtikelID());
        
        try{
            
            // Ausführen der Anweisung
            stmt.executeUpdate();
            
            // Erhöhen der letzten ID im DataDictionary.
            dd.erhoeheLetzteID(TAB_AUFTRAGSPOSITION);
            
            //Datenbankverbindung wird geschlossen
            conn.close();
            
            // Hier wird die Fehlermeldung ausgegeben
        } catch (SQLException e){
            System.out.println(e);
            System.out.println("Objekt wurde nicht hinzugefügt.");
        }    
    }
     
     
    
    /*----------------------------------------------------------*/
    /* Datum Name Was                                           */
    /* 30.11.16 MaLi Anlegen der Methode                        */
    /*----------------------------------------------------------*/
    /**
     * Diese Methode dient zum Löschen einer Auftragsposition aus einem Auftrag.
     * 
     * @param auftragskopf_id Die Auftrags-ID dessen Pos. gelöscht werden soll.
     * @param positionsnummer Die Position die gelöscht werden
     * @throws SQLException
     */

    public void loescheNeueAuftragsposition(String auftragskopf_id, 
            int positionsnummer) throws SQLException{
         
        // Erzeugen eines neuen DBConnection Objekts.
        DBConnection con = new DBConnection();
        // Übergabe der Connection an ein Connection Objekt.
        Connection conn = con.createConection();
        // Erzeugen eines Statements Objekts über das Objekt der Connection.
        Statement stmt = conn.createStatement();
        // Lösch-Statement
        String sql = "Update Auftragsposition SET LKZ='w' where "
                + "Auftragskopf_ID=" + auftragskopf_id + " AND "
                + "positionsnummer= " + positionsnummer;
        
        // Ausführen des Statements
        stmt.executeUpdate(sql);
        conn.close();
    }
    
    
    /*----------------------------------------------------------*/
    /* Datum Name Was                                           */
    /* 01.12.16 MaLi Anlegen der Methode                        */
    /*----------------------------------------------------------*/
    /**
     * Diese Methode zeigt die Auftragspositionen zu einem Auftrag an. 
     * @param auftragskopf_id Die Auftrag-ID zu der die Pos. gehören.
     * @return gibt eine ArrayList vom Auftragspositionen aus.
     * @throws SQLException
     */
    public ArrayList<Auftragsposition> gibAllePositionen(String auftragskopf_id) 
            throws SQLException{
        
        // Erzeugen eines neuen DBConnection Objekts.
        DBConnection con = new DBConnection();
        // Übergabe der Connection an ein Connection Objekt.
        Connection conn = con.createConection();
        // Erzeugen eines SQL ResultSets.
        ResultSet rs = null;
        // Erzeugen eines Statements Objekts über das Objekt der Connection.
        Statement stmt = conn.createStatement();
        // SQL-Anweisung die alle Spalten anhand der Auftragskopf_ID liefert.
        String sql = "select * from auftragsposition where auftragskopf_ID= " 
                + auftragskopf_id + " order by Positionsnummer";
        
        // Erzeugen eines leeren Auftrags-Objekt.
        ArrayList<Auftragsposition> auftragspositionen = new ArrayList<>();
        
        try{
            // Ausführen der Statements
            rs = stmt.executeQuery(sql);

            // Schleife zum Speichern alle Auftragsobjekte
            while(rs.next()){
                
                // Prüft ob LKZ gesetzt ist
                if(rs.getString("LKZ") == null){
                    Auftragsposition auftragsposition = new Auftragsposition();
                    auftragsposition
                            .setAuftragskopfId(rs.getString("Auftragskopf_ID"));
                    auftragsposition
                            .setPositionsnummer(rs.getInt("Positionsnummer"));
                    auftragsposition
                            .setEinzelwert(rs.getInt("Einzelwert"));
                    auftragsposition
                            .setMenge(rs.getInt("Menge"));
                    auftragsposition
                            .setArtikelID(rs.getString("Materialnummer"));

                    auftragspositionen.add(auftragsposition);
                    System.out.println("Ich werde gepspeichert!");
                } else {
                    return null;
                }               
        }
            // Schließt die Verbindung zur DB.
            conn.close();
            
            // Gibt die Auftrags ArrayList aus.
            return auftragspositionen;
        
        // Fehlerbehandlung
        } catch(SQLException e){
            System.out.println(e);
            System.out.println("Fehler in der Speicherung von Aufträgen.");
            return null;
        }
    }
    
    
    /*----------------------------------------------------------*/
    /* Datum Name Was                                           */
    /* 01.12.16 MaLi Anlegen der Methode                        */
    /*----------------------------------------------------------*/
    /**
     * Die Methode liest anhand der Auftragskopf-ID sowie der Positionsnummer
     * eine Position aus der Tabelle Auftragsposition in der DB.
     *
     * @param id erhält die ID als String.
     * @param positionsnummer die gesuchte Pos.-Nr.
     * @return gibt ein Auftragspositions-Objekt aus.
     * @throws SQLException
     */
    public Auftragsposition gibEineAuftragsposition
        (String id, String positionsnummer) throws SQLException {
        
        // Erzeugen eines neuen DBConnection Objekts.
        DBConnection con = new DBConnection();
        // Übergabe der Connection an ein Connection Objekt.
        Connection conn = con.createConection();
        // Erzeugen eines SQL ResultSets.
        ResultSet rs;
        // Erzeugen eines Statements Objekts über das Objekt der Connection.
        Statement stmt = conn.createStatement();
        // SQL-Anweisung die alle Spalten anhand der Auftragskopf_ID liefert.
        String sql = "select * from auftragsposition where Auftragskopf_ID= " 
                + id + " AND Positionsnummer =" + positionsnummer;
        // Erzeugen eines leeren Auftragsposition-Objekt.
        Auftragsposition auftragsposition = new Auftragsposition();

        try {
            // Ausführen des SQL-Befehls.
            rs = stmt.executeQuery(sql);
            
            while (rs.next()) {
                if(rs.getString("LKZ") == null){
                    
                    // Die Informationen aus der DB werden an das 
                    // Auftrags-Objekt übergeben.
                    auftragsposition
                            .setAuftragskopfId(rs.getString("Auftragskopf_ID"));
                    auftragsposition
                            .setPositionsnummer(rs.getInt("Positionsnummer"));
                    auftragsposition.setEinzelwert(rs.getInt("Einzelwert"));
                    auftragsposition.setMenge(rs.getInt("Menge"));
                    auftragsposition
                            .setArtikelID(rs.getString("Materialnummer"));
                } else {
                    return null;
                }
            }
            // DB-Verbindung wird geschlossen.
            conn.close();
        } catch (SQLException e) {
            // Gibt die Fehlermeldung aus.
            System.out.println(e);
            System.out.println("Objekt nicht gefunden!");
        }
        // Ausgabe des Auftrags-Objekts.
        return auftragsposition;
    }
        
    /*----------------------------------------------------------*/
    /* Datum Name Was                                           */
    /* 02.12.16 MaLi Anlegen der Methode                        */
    /*----------------------------------------------------------*/
    /**
     * Diese Methode dient zum Ändern von bestehenden Auftragspositionen. 
     * Positionsnummer und Auftrags-ID werden allerdings nicht geändert!
     * 
     * @param id die ID des Auftrags
     * @param pos die Position die geändert werden soll
     * @param auftragspos ein Auftragspositions-Objekt
     * @throws SQLException
     */
    public void bearbeiteAuftrag(String id, int pos, Auftragsposition auftragspos) 
            throws SQLException{
        // Erzeugen eines neuen DBConnection Objekts.
        DBConnection con = new DBConnection();
        // Übergabe der Connection an ein Connection Objekt.
        Connection conn = con.createConection();
        // UpdateString zum Ausführen des Updates
        String sql = "update auftragsposition set Menge=?,Einzelwert=?, "
                + "Materialnummer=? WHERE Auftragskopf_ID=" + id 
                + " AND Positionsnummer=" + pos;
        
        // Übergabe des Strings an das PreparedStatement
        PreparedStatement stmt = conn.prepareStatement(sql);
        
        // Zuweisung der zu übergebenden Werte aus dem Auftrags-Objekt.
        stmt.setInt(1, auftragspos.getMenge());
        stmt.setInt(2, auftragspos.getEinzelwert());
        stmt.setString(3, auftragspos.getArtikelID());
//        stmt.setString(8, gp.getGPID());
        
        try {
            
            //Ausführen des Statements
            stmt.execute();
            
            //Datenbankverbindung wird geschlossen
            conn.close();
            
            // Ausgabe der Fehlermeldung 
        } catch (SQLException e) {
            System.out.println(e);
            System.out.println("Objekt wurde nicht geändert");
        }
    }
}