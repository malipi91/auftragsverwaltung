/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import model.Auftrag;
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

    private DAODataDictionary dd;
    private Zusatzfunktionen zf;

    private final String TAB_AUFTRAG = "auftrag";

    public DAOAuftrag() throws SQLException {
        dd = new DAODataDictionary();
        zf = new Zusatzfunktionen();
    }
    
    /*----------------------------------------------------------*/
    /* Datum Name Was                                           */
    /* 14.11.16 Hicran Yörük Anlegen der Methode                */
    /*----------------------------------------------------------*/
    /* 
    * Diese Methode legt durch Eingabe der Werte in die GUI einen neuen Auftrag 
    * in die Datenbank     
    */
    public void legeNeueAuftragAn(Auftrag auftrag) throws SQLException {
        String letzteID = dd.bekommeLetzteID(TAB_AUFTRAG);
        DBConnection con = new DBConnection();
        Connection conn = con.createConection();

    
        String sql = "insert into auftrag "
                + "(Auftragskopf_ID,Auftragsart,Auftragstext,Erfassungsdatum,"
                + "Auftragswert,Lieferdatum,AStatus, Abschlussdatum) "
                + "values (?,?,?,?,?,?,?,?)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, letzteID);
        stmt.setString(2, auftrag.getAuftragsart());
        stmt.setString(3, auftrag.getAuftragstext());
        stmt.setDate(4, new Date(Long.parseLong(auftrag.getLieferdatum())));//java.sql.Timestamp.valueOf(zf.gebeTimestamp()));
        stmt.setInt(5,auftrag.getAuftragswert());
        stmt.setDate(6, new Date(Long.parseLong(auftrag.getLieferdatum())));//java.sql.Date.valueOf(auftrag.getLieferdatum()));
        stmt.setString(7, auftrag.getStatus());
        stmt.setDate(8, new Date(Long.parseLong(auftrag.getLieferdatum())));//java.sql.Date.valueOf(auftrag.getAbschlussdatum()));

        try {
            stmt.executeUpdate();
            dd.erhoeheLetzteID(TAB_AUFTRAG);
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
    
//    public void bearbeiteAuftrag(String id, Auftrag auftrag) throws SQLException{
//        // Erzeugen eines neuen DBConnection Objekts.
//        DBConnection con = new DBConnection();
//        // Übergabe der Connection an ein Connection Objekt.
//        Connection conn = con.createConection();
//        // UpdateString 
//        String sql = "update auftrag set auftragsart=" + auftrag.getAuftragsart() +
//                ", auftragstext= " + auftrag.getAuftragstext() +
//                ", erfassungsdatum= " + auftrag.getErfassungsdatum() +
//                ", auftragswert= " + auftrag.getAuftragswert() +
//                ", lieferdatum= " + auftrag.getLieferdatum() +
//                + "(Auftragskopf_ID,Auftragsart,Auftragstext,Erfassungsdatum,"
//                + "Auftragswert,Lieferdatum,AStatus, Abschlussdatum) "
//                + "values (?,?,?,?,?,?,?,?)";
//        PreparedStatement stmt = conn.prepareStatement(sql);
//        stmt.setString(1, letzteID);
//        stmt.setString(2, auftrag.getAuftragsart());
//        stmt.setString(3, auftrag.getAuftragstext());
//        stmt.setDate(4, new Date(Long.parseLong(auftrag.getLieferdatum())));//java.sql.Timestamp.valueOf(zf.gebeTimestamp()));
//        stmt.setInt(5,auftrag.getAuftragswert());
//        stmt.setDate(6, new Date(Long.parseLong(auftrag.getLieferdatum())));//java.sql.Date.valueOf(auftrag.getLieferdatum()));
//        stmt.setString(7, auftrag.getStatus());
//        stmt.setDate(8, new Date(Long.parseLong(auftrag.getLieferdatum())));//java.sql.Date.valueOf(auftrag.getAbschlussdatum()));
//
//        try {
//            stmt.executeUpdate();
//            dd.erhoeheLetzteID(TAB_AUFTRAG);
//            //Datenbankverbindung wird geschlossen
//            conn.close();
//            // Ausgabe der Fehlermeldung 
//        } catch (SQLException e) {
//            System.out.println(e);
//            System.out.println("Objekt wurde nicht hinzugefügt.");
//        }
//    }
}
