/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import model.Auftrag;
import util.DBConnection;
import util.Zusatzfunktionen;

/**
 *
 * @author marti
 * Änderungen zum Testen
 * 2 Einträge zum Testen
 * 3 Eitnröge Testen
 */
public class DAOAuftrag {

    private DAODataDictionary dd;
    private Zusatzfunktionen zf;

    private final String TAB_AUFTRAG = "auftrag";

    public DAOAuftrag() throws SQLException {
        dd = new DAODataDictionary();
        zf = new Zusatzfunktionen();
    }

    public void legeNeueAuftragAn(Auftrag auftrag) throws SQLException {
        String letzteID = dd.bekommeLetzteID(TAB_AUFTRAG);
        DBConnection con = new DBConnection();
        Connection conn = con.createConection();

        /*----------------------------------------------------------*/
 /* Datum Name Was                                           */
 /* 14.11.16 Hicran Yörük Anlegen der Methode                 */
 /*----------------------------------------------------------*/
 /* 
    *Diese Methode legt durch Eingabe der Werte in die GUI einen neuen Auftrag 
    * in die Datenbank     
    */
        String sql = "insert into auftrag "
                + "(Auftragskopf_ID,Auftragsart,Auftragstext,Erfassungsdatum,"
                + "Auftragswert,Lieferdatum,AStatus, Abschlussdatum) "
                + "values (?,?,?,?,?,?,?,?)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, letzteID);
        stmt.setString(2, auftrag.getAuftragsart());
        stmt.setString(3, auftrag.getAuftragstext());
        stmt.setTimestamp(4, java.sql.Timestamp.valueOf(zf.gebeTimestamp()));
        stmt.setInt(5,auftrag.getAuftragswert());
        stmt.setDate(6, java.sql.Date.valueOf(auftrag.getLieferdatum()));
        stmt.setString(7, auftrag.getStatus());
        stmt.setDate(8, java.sql.Date.valueOf(auftrag.getAbschlussdatum()));

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
    /* 14.11.16 MaLi Anlegen der Klasse                         */
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
                // Die Informationen aus der DB werden an das Auftrags-Objekt übergeben.
                auftrag.setAuftrags_ID(rs.getString("Auftragskopf_ID"));
                auftrag.setAuftragstext(rs.getString("Auftragstext"));
                auftrag.setAuftragsart(rs.getString("Auftragsart"));
                auftrag.setErfassungsdatum("Erfassungsdatum");
                auftrag.setAbschlussdatum("Abschlussdatum");
                auftrag.setLieferdatum(rs.getString("Lieferdatum"));
                auftrag.setAuftragswert(rs.getInt("Auftragswert"));
                auftrag.setzeGeschaeftspartnerID(rs.getString("GP_ID"));
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
        String sql = "select * from auftrag";
        // Erzeugen eines leeren Auftrags-Objekt.
        ArrayList<Auftrag> auftraege = new ArrayList<>();
        try{
        rs = stmt.executeQuery(sql);
        rs.first();
        while(rs.next() && anzahl != 0){
            if(!rs.getString("LKZ").equals("w"));
            Auftrag auftrag = new Auftrag();
            auftrag.setAuftrags_ID(rs.getString("Auftragskopf_ID"));
            auftrag.setAuftragsart(rs.getString("Auftragsart"));
            auftrag.setErfassungsdatum(rs.getString("Erfassungsdatum"));
            auftrag.setAuftragswert(rs.getInt("Auftragswert"));
            auftrag.setLieferdatum(rs.getString("Lieferdatum"));
            auftrag.setStatus(rs.getString("Auftragsstatus"));
            auftrag.setAbschlussdatum(rs.getString("Abschlussdatum"));
            auftrag.setzeGeschaeftspartnerID(rs.getString("GP_ID"));
            auftraege.add(auftrag);
            anzahl = anzahl -1;
        }
        return auftraege;
        } catch(SQLException e){
            System.out.println(e);
            System.out.println("Fehler in der Speicherung von Aufträgen.");
            return null;
        }
    }
}
