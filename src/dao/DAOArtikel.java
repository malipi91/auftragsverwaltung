/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.Artikel;
import model.Auftrag;
import util.DBConnection;


/*----------------------------------------------------------*/
/* Datum Name Was                                           */
/* 01.12.16 MaLi Anlegen der Klasse                         */
/*----------------------------------------------------------*/
/**
 * Diese Klasse dient dem Zugriff auf die DB-Tabelle Artikel.
 * @author Martin Lipinski
 */
public class DAOArtikel {
    
    
    
    /*----------------------------------------------------------*/
    /* Datum Name Was                                           */
    /* 14.11.16 MaLi Anlegen der Methode                        */
    /*----------------------------------------------------------*/
    /**
     * Die Methode liest anhand der Artikel-ID einen Datensatz aus der
     * Datenbank und liefert diesen als Artikel-Objekt aus.
     *
     * @param id erhält die ID als String.
     * @return gibt ein Artikel-Objekt aus.
     * @throws SQLException
     */
    public Artikel erhalteEinenArtikel(String id) throws SQLException {
        
        // Erzeugen eines neuen DBConnection Objekts.
        DBConnection con = new DBConnection();
        // Übergabe der Connection an ein Connection Objekt.
        Connection conn = con.createConection();
        // Erzeugen eines SQL ResultSets.
        ResultSet rs;
        // Erzeugen eines Statements Objekts über das Objekt der Connection.
        Statement stmt = conn.createStatement();
        // SQL-Anweisung die alle Spalten anhand der Auftragskopf_ID liefert.
        String sql = "select * from artikel where Artikel_ID= " + id;
        // Erzeugen eines leeren Auftrags-Objekt.
        Artikel artikel = new Artikel();

        try {
            // Ausführen des SQL-Befehls.
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                // Prüft ob LKZ gesetzt ist
                if(rs.getString("LKZ") == null){
                    artikel.setArtikel_ID(rs.getString("Artikel_ID"));
                    artikel.setArtikeltext(rs.getString("Artikeltext"));
                    artikel.setBestelltext(rs.getString("Bestelltext"));
                    artikel.setBestellwert(rs.getInt("Bestellwert"));
                    artikel.setEinzelwert(rs.getInt("Einzelwert"));
                    artikel.setMwst_satz(rs.getInt("Mwst_Satz"));
                    artikel.setLieferantenID(rs.getString("GP_ID"));
                    System.out.println("Ich werde gespeichert!");
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
        return artikel;
    }
    
    
    /*----------------------------------------------------------*/
    /* Datum Name Was                                           */
    /* 01.12.16 MaLi Anlegen der Methode                        */
    /*----------------------------------------------------------*/
    /**
     * Diese Methode zeigt eine bestimmte Anzahl der Artikel aus der 
     * DB-Tabelle an. 
     * 
     * @param anzahl Die Anzahl der anzuzeigender Artikel
     * @return gibt eine ArrayList vom Typ Artikel aus.
     * @throws SQLException
     */
    public ArrayList<Artikel> gibAlleArtikelDetails(int anzahl) 
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
        String sql = "select * from artikel order by Artikel_ID";
        // Erzeugen eines leeren Auftrags-Objekt.
        ArrayList<Artikel> artikelliste = new ArrayList<>();
        
        try{
            // Ausführen der Statements
            rs = stmt.executeQuery(sql);

            // Schleife zum Speichern alle Auftragsobjekte
            while(rs.next() && anzahl != 0){
                
                // Prüft ob LKZ gesetzt ist
                if(rs.getString("LKZ") == null){
                    Artikel artikel = new Artikel();
                    artikel.setArtikel_ID(rs.getString("Artikel_ID"));
                    artikel.setArtikeltext(rs.getString("Artikeltext"));
                    artikel.setBestelltext(rs.getString("Bestelltext"));
                    artikel.setBestellwert(rs.getInt("Bestellwert"));
                    artikel.setEinzelwert(rs.getInt("Einzelwert"));
                    artikel.setMwst_satz(rs.getInt("Mwst_Satz"));
                    artikel.setLieferantenID(rs.getString("GP_ID"));
                    artikelliste.add(artikel);
                    System.out.println("Ich werde gespeichert!");
                } else {
                    return null;
                }
                // Reduziert die Anzahl.
                anzahl = anzahl -1;
        }
            
            // Schließt die Verbindung zur DB.
            conn.close();
            
            // Gibt die Auftrags ArrayList aus.
            return artikelliste;
        
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
     * Methode zum Löschen eines Artikels anhand der ID.
     * @param id Artikel-ID die gelöscht werden soll.
     * @throws SQLException
    */
   public void loescheArtikel(String id) throws SQLException{
        // Erzeugen eines neuen DBConnection Objekts.
        DBConnection con = new DBConnection();
        // Übergabe der Connection an ein Connection Objekt.
        Connection conn = con.createConection();
        // Erzeugen eines Statements Objekts über das Objekt der Connection.
        Statement stmt = conn.createStatement();
        // Lösch-Statement
        String sql = "Update Artikel SET LKZ='w' where Artikel_ID=" + id;
        
        // Ausführen des Statements
        stmt.executeUpdate(sql);
        conn.close();
    }
}
