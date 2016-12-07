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
import model.Auftrag;
import model.Zahlungskondition;
import util.DBConnection;

/*----------------------------------------------------------*/
/* Datum Name Was                                           */
/* 05.12.16 MaLi Anlegen der Klasse                         */
/*----------------------------------------------------------*/
/**
 * Diese Klasse dient der Bündelung der Funktionen zum Zugriff auf die DB-Tabelle
 * Zahlungskondition.
 * @author Martin Lipinski
 */
public class DAOZahlungskondition {
    
    
    /*----------------------------------------------------------*/
    /* Datum Name Was                                           */
    /* 05.12.16 MaLi Anlegen des Konstruktors                   */
    /*----------------------------------------------------------*/
    /**
     * Konstruktor zum Erzeugen eines Objekts.
     * 
     * @throws SQLException
     */
    public DAOZahlungskondition() throws SQLException {
    }
    
    /*----------------------------------------------------------*/
    /* Datum Name Was                                           */
    /* 05.12.16 MaLi Anlegen der Methode                        */
    /*----------------------------------------------------------*/
    /**
     * Diese Methode dient zum Anlegen neuer Zahlungskonditionen.
     * 
     * @param zk Übergeben eines Zahlungskonditions Objekts.
     * @throws SQLException
     */
    public void legeNeueZahlungskonditionAn(Zahlungskondition zk) 
            throws SQLException {
        
        // Anlegen einer neuen DBConnection.
        DBConnection con = new DBConnection();
        
        // Übergabe der Connection an ein Connection Objekt.
        Connection conn = con.createConection();

        // Statement das zum Ausführen des Inserts dient.
        String sql = "insert into zahlungskondition "
                + "(ZK_ID, Auftragsart, Skonto_1, Skonto_2, Skontozeit_1, "
                + "Skontozeit_2, Mahnzeit_1, Mahnzeit_2, Mahnzeit_3, "
                + "Lieferzeit_SOFORT, Lieferzeit_WUNSCH) "
                + "values (?,?,?,?,?,?,?,?,?,?,?)";
        
        PreparedStatement stmt = conn.prepareStatement(sql);
        
        // Übergabe der Daten aus ZK Objekt in das PreparedStatement
        if(zk.getZk_ID() == null){
            stmt.setString(1, this.erhoeheLetzteZKID());
        } else {
            stmt.setString(1, zk.getZk_ID());
        }
        
        stmt.setString(2, zk.getAuftragsart());
        stmt.setInt(3, zk.getSkonto_1());
        stmt.setInt(4, zk.getSkonto_2());
        stmt.setInt(5, zk.getSkontozeit_1());
        stmt.setInt(6, zk.getSkontozeit_2());
        stmt.setInt(7, zk.getMahnzeit_1());
        stmt.setInt(8, zk.getMahnzeit_2());
        stmt.setInt(9, zk.getMahnzeit_3());
        stmt.setInt(10, zk.getLieferzeit_sofort());
        stmt.setInt(11, zk.getLieferzeit_wunsch());
        
        try {
            
            // Ausführen des Updates 
            stmt.executeUpdate();
            
            //Datenbankverbindung wird geschlossen
            conn.close();
            
            // Ausgabe der Fehlermeldung 
        } catch (SQLException e) {
            System.out.println(e);
            System.out.println("Objekt wurde nicht hinzugefügt.");
        }
    }

    /*----------------------------------------------------------*/
    /* Datum Name Was                                           */
    /* 14.11.16 MaLi Anlegen der Methode                        */
    /*----------------------------------------------------------*/
    /**
     * Die Methode liest anhand der Auftragskopf-ID einen Datensatz aus der
     * Datenbank und liefert diesen als Auftrags-Objekt aus.
     *
     * @param id erhält die ID als String.
     * @return gibt ein Auftrags-Objekt aus.
     * @throws SQLException
     */
    public Zahlungskondition erhalteZahlungskonditionFuerID(String id) 
            throws SQLException {
        
        // Erzeugen eines neuen DBConnection Objekts.
        DBConnection con = new DBConnection();
        
        // Übergabe der Connection an ein Connection Objekt.
        Connection conn = con.createConection();
        
        // Erzeugen eines SQL ResultSets.
        ResultSet rs;
        
        // Erzeugen eines Statements Objekts über das Objekt der Connection.
        Statement stmt = conn.createStatement();
        
        // SQL-Anweisung die alle Spalten anhand der ZK_ID liefert.
        String sql = "select * from zahlungskondition where ZK_ID= " + id;
        
        // Erzeugen eines leeren Auftrags-Objekt.
        Zahlungskondition zk = new Zahlungskondition();

        try {
            
            // Ausführen des SQL-Befehls.
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                
                // Prüft, ob das LKZ bei dem Wert gesetzt ist.
                if(rs.getString("LKZ") == null){
                    
                    // Übergeben der abgefragten Daten aus der DB-Tabelle an Objekt.
                    zk.setZk_ID(rs.getString("ZK_ID"));
                    zk.setAuftragsart(rs.getString("Auftragsart"));
                    zk.setSkonto_1(rs.getInt("Skonto_1"));
                    zk.setSkonto_2(rs.getInt("Skonto_2"));
                    zk.setSkontozeit_1(rs.getInt("Skontozeit_1"));
                    zk.setSkontozeit_2(rs.getInt("Skontozeit_2"));
                    zk.setMahnzeit_1(rs.getInt("Mahnzeit_1"));
                    zk.setMahnzeit_2(rs.getInt("Mahnzeit_2"));
                    zk.setMahnzeit_3(rs.getInt("Mahnzeit_3"));
                    zk.setLieferzeit_sofort(rs.getInt("Lieferzeit_SOFORT"));
                    zk.setLieferzeit_wunsch(rs.getInt("Lieferzeit_WUNSCH"));
                    
                } else {
                    
                    // Gibt bei gesetztem LKZ ein Null-Objekt wieder.
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
        // Ausgabe des Zahlungskonditions-Objekts.
        return zk;
    }
    
    
    /*----------------------------------------------------------*/
    /* Datum Name Was                                           */
    /* 05.12.16 MaLi Anlegen der Methode                        */
    /*----------------------------------------------------------*/
    /**
     * Diese Methode zeigt eine bestimmte Anzahl der angelegten 
     * Zahlungskondtionen.
     * 
     * @param anzahl Die Anzahl der anzuzeigenden Zahlungskonditionen.
     * @return gibt eine ArrayList vom Typ Zahlungskondition aus.
     * @throws SQLException
     */
    public ArrayList<Zahlungskondition> gibAlleZahlungskonditionen(int anzahl) 
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
        String sql = "select * from zahlungskondition";
        
        // Erzeugen einer ArrayList vom Typ Zahlungskonditionen
        ArrayList<Zahlungskondition> zahlungskondis = new ArrayList<>();
        
        try{
            // Ausführen der Statements
            rs = stmt.executeQuery(sql);

            // Schleife zum Speichern alle Auftragsobjekte
            while(rs.next() && anzahl != 0){
                
                // Prüft ob LKZ gesetzt ist
                if(rs.getString("LKZ") == null){
                    
                    // Erstellen eines neuen Zahlungskonditions-Objekts.
                    Zahlungskondition zk = new Zahlungskondition();
                    
                    // Übergeben der abgefragten Daten aus der DB-Tabelle an Objekt.
                    zk.setZk_ID(rs.getString("ZK_ID"));
                    zk.setAuftragsart(rs.getString("Auftragsart"));
                    zk.setSkonto_1(rs.getInt("Skonto_1"));
                    zk.setSkonto_2(rs.getInt("Skonto_2"));
                    zk.setSkontozeit_1(rs.getInt("Skontozeit_1"));
                    zk.setSkontozeit_2(rs.getInt("Skontozeit_2"));
                    zk.setMahnzeit_1(rs.getInt("Mahnzeit_1"));
                    zk.setMahnzeit_2(rs.getInt("Mahnzeit_2"));
                    zk.setMahnzeit_3(rs.getInt("Mahnzeit_3"));
                    zk.setLieferzeit_sofort(rs.getInt("Lieferzeit_SOFORT"));
                    zk.setLieferzeit_wunsch(rs.getInt("Lieferzeit_WUNSCH"));
                    
                    // Speicherung des Objekts in der ArrayList
                    zahlungskondis.add(zk);
                    System.out.println("Ich werde gepspeichert!");
                } 
                // Reduziert die Anzahl.
                anzahl = anzahl -1;
        }
            
            // Schließt die Verbindung zur DB.
            conn.close();
            
            // Gibt die Auftrags ArrayList aus.
            return zahlungskondis;
        
        // Fehlerbehandlung
        } catch(SQLException e){
            System.out.println(e);
            System.out.println("Fehler in der Speicherung von Aufträgen.");
            return null;
        }
    }
    
    
    
    /*----------------------------------------------------------*/
    /* Datum Name Was                                           */
    /* 05.12.16 MaLi Anlegen der Methode                        */
    /*----------------------------------------------------------*/
    /**
     * Methode zum Löschen einer Zahlungskondition in der DB-Tabelle. Es wird 
     * lediglich ein LKZ gesetzt. 
     * 
     * @param id ZK-ID die gelöscht werden soll.
     * @throws SQLException
     */
    public void loescheZahlungskondition(String id) throws SQLException{
        
        // Erzeugen eines neuen DBConnection Objekts.
        DBConnection con = new DBConnection();
        
        // Übergabe der Connection an ein Connection Objekt.
        Connection conn = con.createConection();
        
        // Erzeugen eines Statements Objekts über das Objekt der Connection.
        Statement stmt = conn.createStatement();
        
        // Lösch-Statement
        String sql = "Update Zahlungskondition SET LKZ='w' where ZK_ID=" + id;
        
        // Ausführen des Statements
        stmt.executeUpdate(sql);
        
        // Schließe die Verbindung zur DB.
        conn.close();
    }
    
    
    /*----------------------------------------------------------*/
    /* Datum Name Was                                           */
    /* 05.12.16 MaLi Anlegen der Methode                        */
    /*----------------------------------------------------------*/
    /**
     * Diese Methode dient zum Ändern von bestehenden Zahlungskonditionen.
     * 
     * @param id die ID der zuänderten Zahlungskondition
     * @param zk Zahlungskondition Objekt das die Änderungen enthält.
     * @throws SQLException
     */
    public void bearbeiteZahlungskondition(String id, Zahlungskondition zk) 
            throws SQLException{
        
        // Erzeugen eines neuen DBConnection Objekts.
        DBConnection con = new DBConnection();
        
        // Übergabe der Connection an ein Connection Objekt.
        Connection conn = con.createConection();

        // UpdateString zum Ausführen des Updates
        String sql = "update Zahlungskondition set Skonto_1=?, "
                + "Skonto_2=?, Skontozeit_1=?, Skontozeit_2=?, "
                + "Mahnzeit_1=?, Mahnzeit_2=?, Mahnzeit_3=?, "
                + "Lieferzeit_SOFORT=?, Lieferzeit_WUNSCH=?, Auftragsart=? WHERE ZK_ID=" + id;
        
        // Übergabe des Strings an das PreparedStatement
        PreparedStatement stmt = conn.prepareStatement(sql);
        
        // Zuweisung der zu übergebenden Werte aus dem Zahlungskonditions-Objekt.
        stmt.setInt(1, zk.getSkonto_1());
        stmt.setInt(2, zk.getSkonto_2());
        stmt.setInt(3, zk.getSkontozeit_1());
        stmt.setInt(4, zk.getSkontozeit_2());
        stmt.setInt(5, zk.getMahnzeit_1());
        stmt.setInt(6, zk.getMahnzeit_2());
        stmt.setInt(7, zk.getMahnzeit_3());
        stmt.setInt(8, zk.getLieferzeit_sofort());
        stmt.setInt(9, zk.getLieferzeit_wunsch());
        stmt.setString(10, zk.getAuftragsart());
        
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
    
    
    /*----------------------------------------------------------*/
    /* Datum Name Was                                           */
    /* 05.12.16 MaLi Anlegen der Methode                        */
    /*----------------------------------------------------------*/
    /**
     * Diese Methode liest die letzte ZK-ID aus der DB-Tabelle aus und gibt 
     * diese anschließend aus.
     * 
     * @return gibt die letzte ZK-ID aus.
     * @throws SQLException
     */
    public String findeLetzteZKID() throws SQLException{
        
        // Erzeugen eines neuen DBConnection Objekts.
        DBConnection con = new DBConnection();
        
        // Übergabe der Connection an ein Connection Objekt.
        Connection conn = con.createConection();
        
        // Erzeugen eines SQL ResultSets.
        ResultSet rs = null;
        
        // Erzeugen eines Statements Objekts über das Objekt der Connection.
        Statement stmt = conn.createStatement();
        
        // SQL-Anweisung die alle Spalten anhand der Auftragskopf_ID liefert.
        String sql = "select ZK_ID, Erfassungsdatum from zahlungskondition order by Erfassungsdatum DESC";
        
        // Enthält das Ergebnis. Initialisiert ist eine leere Zeichenkette.
        String erg = "";
        try{
            
            // Ausführen der Statements
            rs = stmt.executeQuery(sql);
            
            if(rs.first()){
                erg = rs.getString("ZK_ID");
            } else {
                return null;
            }
            // Schließt die Verbindung zur DB.
            conn.close();
            
            // Gibt die letzte ZK-ID aus.
            return erg;  
            
        // Fehlerbehandlung
        } catch(SQLException e){
            System.out.println(e);
            System.out.println("Fehler beim Auslesen der letzten ID.");
            return null;
        }
    }
    
    
    /*----------------------------------------------------------*/
    /* Datum Name Was                                           */
    /* 05.12.16 MaLi Anlegen der Methode                        */
    /*----------------------------------------------------------*/
    /**
     * Diese Methode dient dem Erhöhen der letzten ZK-ID. Sie wandelt zunächst
     * die ID vom Typ String in einen Integer um und erhöht diese um 1. 
     * Ausgegeben wird abschließend die erhöhte ID als String.
     * 
     * @return gibt die erhöhte neue ID aus. 
     * @throws SQLException
     */
    public String erhoeheLetzteZKID() throws SQLException{
        
        // Sucht die letzte ID und gibt diese die lok. Variable weiter.
        String id = this.findeLetzteZKID();
        if(id == null){
            return "1";
        } else {
            // Parsed den String zu einem Integer.
            int idInt = Integer.parseInt(id);
        
            // Erhöhe den Integer um 1.
            int erg = idInt + 1;
        
            // Gibt den erhöhten Wert als String wieder.
            return String.valueOf(erg);
        }
        
    }
    
}
