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
import model.Geschaeftspartner;
import util.DBConnection;
import util.Zusatzfunktionen;


/*----------------------------------------------------------*/
/* Datum Name Was                                           */
/* 14.11.16 MaLi Anlegen der Klasse                         */
/* 14.11.16 HiYö Erweitern der Klasse                       */
/*----------------------------------------------------------*/
/**
 * Diese Klasse bündelt Methoden die auf die DB-Tabelle Auftrag zugreift.
 * @author Martin Lipinski
 * Änderungen zum Testen
 * 2 Einträge zum Testen
 */
public class DAOAuftrag {

    private Zusatzfunktionen zf;

    private final String TAB_AUFTRAG = "auftrag";

    public DAOAuftrag() throws SQLException {
        zf = new Zusatzfunktionen();
    }
    
    /*----------------------------------------------------------*/
    /* Datum Name Was                                           */
    /* 14.11.16 Hicran Yörük Anlegen der Methode                */
    /* 03.12.16 MaLi Überarbeiten der Methode                   */
    /*----------------------------------------------------------*/
    /* 
    * Diese Methode legt durch Eingabe der Werte in die GUI einen neuen Auftrag 
    * in die Datenbank     
    */
    public void legeNeueAuftragAn(Auftrag auftrag) throws SQLException {
        DBConnection con = new DBConnection();
        Connection conn = con.createConection();

    
        String sql = "insert into auftrag "
                + "(Auftragskopf_ID,Auftragsart,Auftragstext,"
                + "Auftragswert,Lieferdatum,AStatus, Abschlussdatum) "
                + "values (?,?,?,?,?,?,?)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, this.erhoeheLetzteID());
        stmt.setString(2, auftrag.getAuftragsart());
        stmt.setString(3, auftrag.getAuftragstext());
//        stmt.setTimestamp(4, new Date(java.sql.Timestamp.valueOf(zf.gebeTimestamp())));
        stmt.setInt(4,auftrag.getAuftragswert());
        stmt.setDate(5, java.sql.Date.valueOf(auftrag.getLieferdatum()));
        stmt.setString(6, auftrag.getStatus());
        stmt.setDate(7, java.sql.Date.valueOf(auftrag.getAbschlussdatum()));
        stmt.setString(4, auftrag.getErfassungsdatum());
        
//stmt.setDate(4, new Date(Long.parseLong(auftrag.getLieferdatum())));
//java.sql.Timestamp.valueOf(auftrag.getErfassungsdatum());

        try {
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
    public Auftrag erhalteAuftragFuerID(String id) throws SQLException {
        // Erzeugen eines neuen DBConnection Objekts.
        DBConnection con = new DBConnection();
        // Übergabe der Connection an ein Connection Objekt.
        Connection conn = con.createConection();
        // Erzeugen eines SQL ResultSets.
        ResultSet rs;
        // Erzeugen eines Statements Objekts über das Objekt der Connection.
        Statement stmt = conn.createStatement();
        // SQL-Anweisung die alle Spalten anhand der Auftragskopf_ID liefert.
        String sql = "select * from auftrag where Auftragskopf_ID= " + id;
        // Erzeugen eines leeren Auftrags-Objekt.
        Auftrag auftrag = new Auftrag();

        try {
            // Ausführen des SQL-Befehls.
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                if(rs.getString("LKZ") == null){
                    // Die Informationen aus der DB werden an das Auftrags-Objekt übergeben.
                    auftrag.setAuftrags_ID(rs.getString("Auftragskopf_ID"));
                    auftrag.setAuftragstext(rs.getString("Auftragstext"));
                    auftrag.setAuftragsart(rs.getString("Auftragsart"));
                    auftrag.setErfassungsdatum(rs.getString("Erfassungsdatum"));
                    auftrag.setAbschlussdatum(rs.getString("Abschlussdatum"));
                    auftrag.setLieferdatum(rs.getString("Lieferdatum"));
                    auftrag.setAuftragswert(rs.getInt("Auftragswert"));
                    auftrag.setzeGeschaeftspartnerID(rs.getString("GP_ID"));
                    auftrag.setLKZ(rs.getString("LKZ"));
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
        return auftrag;
    }
    public Auftrag erhalteLKZAuftragFuerID(String id) throws SQLException {
        // Erzeugen eines neuen DBConnection Objekts.
        DBConnection con = new DBConnection();
        // Übergabe der Connection an ein Connection Objekt.
        Connection conn = con.createConection();
        // Erzeugen eines SQL ResultSets.
        ResultSet rs;
        // Erzeugen eines Statements Objekts über das Objekt der Connection.
        Statement stmt = conn.createStatement();
        // SQL-Anweisung die alle Spalten anhand der Auftragskopf_ID liefert.
        String sql = "select * from auftrag where Auftragskopf_ID= " + id;
        // Erzeugen eines leeren Auftrags-Objekt.
        Auftrag auftrag = new Auftrag();

        try {
            // Ausführen des SQL-Befehls.
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                if(rs.getString("LKZ") != null){
                    // Die Informationen aus der DB werden an das Auftrags-Objekt übergeben.
                    
                    auftrag.setLKZ(rs.getString("LKZ"));
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
        return auftrag;
    }
    
    
    /*----------------------------------------------------------*/
    /* Datum Name Was                                           */
    /* 28.11.16 MaLi Anlegen der Methode                        */
    /* 01.12.16 MaLi Überarbeiten der Methode                   */
    /*----------------------------------------------------------*/
    /**
     * Diese Methode zeigt eine bestimmte Anzahl der Aufträge an. 
     * @param anzahl Die Anzahl der anzuzeigenden Auftraege.
     * @return gibt eine ArrayList vom Auftrag aus.
     * @throws SQLException
     */
    public ArrayList<Auftrag> gibAlleAuftraege(int anzahl) throws SQLException{
        // Erzeugen eines neuen DBConnection Objekts.
        DBConnection con = new DBConnection();
        // Übergabe der Connection an ein Connection Objekt.
        Connection conn = con.createConection();
        // Erzeugen eines SQL ResultSets.
        ResultSet rs = null;
        // Erzeugen eines Statements Objekts über das Objekt der Connection.
        Statement stmt = conn.createStatement();
        // SQL-Anweisung die alle Spalten anhand der Auftragskopf_ID liefert.
        String sql = "select * from auftrag order by Erfassungsdatum";
        // Erzeugen eines leeren Auftrags-Objekt.
        ArrayList<Auftrag> auftraege = new ArrayList<>();
        
        try{
            // Ausführen der Statements
            rs = stmt.executeQuery(sql);

            // Schleife zum Speichern alle Auftragsobjekte
            while(rs.next() && anzahl != 0){
                
                // Prüft ob LKZ gesetzt ist
                if(rs.getString("LKZ") == null){
                    Auftrag auftrag = new Auftrag();
                    auftrag.setAuftrags_ID(rs.getString("Auftragskopf_ID"));
                    auftrag.setAuftragsart(rs.getString("Auftragsart"));
                    auftrag.setErfassungsdatum(rs.getString("Erfassungsdatum"));
                    auftrag.setAuftragswert(rs.getInt("Auftragswert"));
                    auftrag.setLieferdatum(rs.getString("Lieferdatum"));
                    auftrag.setStatus(rs.getString("AStatus"));
                    auftrag.setAbschlussdatum(rs.getString("Abschlussdatum"));
                    auftrag.setzeGeschaeftspartnerID(rs.getString("GP_ID"));
                    auftraege.add(auftrag);
                    System.out.println("Ich werde gepspeichert!");
                } else {
                    return null;
                }
                // Reduziert die Anzahl.
                anzahl = anzahl -1;
        }
            
            // Schließt die Verbindung zur DB.
            conn.close();
            
            // Gibt die Auftrags ArrayList aus.
            return auftraege;
        
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
     * Methode zum Löschen eines Auftrags anhand der ID.
     * @param id Auftragskopf-ID die gelöscht werden soll.
     * @throws SQLException
     */
    public void loescheAuftrag(String id) throws SQLException{
        // Erzeugen eines neuen DBConnection Objekts.
        DBConnection con = new DBConnection();
        // Übergabe der Connection an ein Connection Objekt.
        Connection conn = con.createConection();
        // Erzeugen eines Statements Objekts über das Objekt der Connection.
        Statement stmt = conn.createStatement();
        // Lösch-Statement
        String sql = "Update Auftrag SET LKZ='w' where Auftragskopf_ID=" + id;
        
        // Ausführen des Statements
        stmt.executeUpdate(sql);
        conn.close();
    }
    
    /*----------------------------------------------------------*/
    /* Datum Name Was                                           */
    /* 02.12.16 MaLi Anlegen der Methode                        */
    /*----------------------------------------------------------*/
    /**
     * Diese Methode dient zum Ändern von bestehenden Aufträgen.
     * 
     * @param id die ID des zu änderden Auftrags
     * @param auftrag ein Auftrags-Objekt, dass die Änderungen enthält
     * @throws SQLException
     */
    public void bearbeiteAuftrag(String id, Auftrag auftrag) throws SQLException{
        // Erzeugen eines neuen DBConnection Objekts.
        DBConnection con = new DBConnection();
        // Übergabe der Connection an ein Connection Objekt.
        Connection conn = con.createConection();
        // Geschaeftsparnter - Objekt erzeugen
        Geschaeftspartner gp = new Geschaeftspartner();
        // Geschäftspartner zuweisen zum Auslesen der GP-ID
        gp = auftrag.getGeschaeftspartner();
        // UpdateString zum Ausführen des Updates
        String sql = "update auftrag set Auftragsart=?,Auftragstext=?, "
                + "Erfassungsdatum=?, Auftragswert=?, Lieferdatum=?, AStatus=?, "
                + "Abschlussdatum=? WHERE Auftragskopf_ID=" + id;
        
        // Übergabe des Strings an das PreparedStatement
        PreparedStatement stmt = conn.prepareStatement(sql);
        
        // Zuweisung der zu übergebenden Werte aus dem Auftrags-Objekt.
        stmt.setString(1, auftrag.getAuftragsart());
        stmt.setString(2, auftrag.getAuftragstext());
//        stmt.setDate(3, new Date(Long.parseLong(auftrag.getErfassungsdatum())));
        stmt.setString(3, auftrag.getErfassungsdatum());
        stmt.setInt(4, auftrag.getAuftragswert());
//        stmt.setDate(5, new Date(Long.parseLong(auftrag.getLieferdatum())));
        stmt.setString(5, auftrag.getLieferdatum());
        stmt.setString(6, auftrag.getStatus());
//        stmt.setDate(7, new Date(Long.parseLong(auftrag.getAbschlussdatum())));
        stmt.setString(7, auftrag.getAbschlussdatum());
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
    
    public String findeLetzteID() throws SQLException{
        
        // Erzeugen eines neuen DBConnection Objekts.
        DBConnection con = new DBConnection();
        // Übergabe der Connection an ein Connection Objekt.
        Connection conn = con.createConection();
        // Erzeugen eines SQL ResultSets.
        ResultSet rs = null;
        // Erzeugen eines Statements Objekts über das Objekt der Connection.
        Statement stmt = conn.createStatement();
        // SQL-Anweisung die alle Spalten anhand der Auftragskopf_ID liefert.
        String sql = "select Auftragskopf_ID, LKZ from auftrag order by Erfassungsdatum DESC";
        String erg = "";
        try{
            // Ausführen der Statements
            rs = stmt.executeQuery(sql);

            // Schleife zum Speichern alle Auftragsobjekte

                
                // Prüft ob LKZ gesetzt ist
                if(rs.first() && rs.getString("LKZ") == null){
                    erg = rs.getString("Auftragskopf_ID");
                }
            // Schließt die Verbindung zur DB.
            conn.close();
            
            // Gibt die letzte Artikel_ID aus.
            return erg;  
        // Fehlerbehandlung
        } catch(SQLException e){
            System.out.println(e);
            System.out.println("Fehler beim Auslesen der letzten ID.");
            return null;
        }
    }
    
    public String erhoeheLetzteID() throws SQLException{
        String id = this.findeLetzteID();
        int idInt = Integer.parseInt(id);
        int erg = idInt + 1;
        return String.valueOf(erg);
    }
    
}
