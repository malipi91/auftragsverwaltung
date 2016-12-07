/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

<<<<<<< HEAD
import model.Artikel;

=======
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.Artikel;
import model.Auftrag;
import model.Geschaeftspartner;
import util.DBConnection;


/*----------------------------------------------------------*/
/* Datum Name Was                                           */
/* 01.12.16 MaLi Anlegen der Klasse                         */
/*----------------------------------------------------------*/
>>>>>>> 89806cc862e2033d0b3cc242f9fc6a7422d9ef87
/**
 * Diese Klasse dient dem Zugriff auf die DB-Tabelle Artikel.
 * @author Martin Lipinski
 */
public class DAOArtikel {
<<<<<<< HEAD

    public void legeNeueArtikelAn(Artikel artikel) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
=======
   
    
    
    
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
        String sql = "select * from artikel order by Erfassungsdatum";
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
    
>>>>>>> 89806cc862e2033d0b3cc242f9fc6a7422d9ef87
    
    /*----------------------------------------------------------*/
    /* Datum Name Was                                           */
    /* 01.12.16 MaLi Anlegen der Methode                        */
    /*----------------------------------------------------------*/
    /**
     * Methode zum Löschen eines Artikels anhand der ID.
     * @param id Artikel-ID die gelöscht werden soll.
     * @throws SQLException
    */
   public void loescheArtikelMitID(String id) throws SQLException{
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
   
   
    /*----------------------------------------------------------*/
    /* Datum Name Was                                           */
    /* 02.12.16 MaLi Anlegen der Methode                        */
    /*----------------------------------------------------------*/
    /**
     * Diese Methode dient zum dem Ändern eines bestehenden Artikels. Es werden
     * lediglich die Stammdaten geändert. Bestandsmengen werden nicht verwaltet.
     * 
     * @param id die ID des zu änderden Artikels
     * @param artikel ein Artikel-Objekt 
     * @throws SQLException
     */
    public void bearbeiteArtikel(String id, Artikel artikel) throws SQLException{
        // Erzeugen eines neuen DBConnection Objekts.
        DBConnection con = new DBConnection();
        // Übergabe der Connection an ein Connection Objekt.
        Connection conn = con.createConection();
        // UpdateString zum Ausführen des Updates
        String sql = "update artikel set Artikeltext=?,Bestelltext=?, "
                + "Einzelwert=?, MwST_Satz=?, Bestellwert=? WHERE Artikel_ID=" 
                + id;
        
        // Übergabe des Strings an das PreparedStatement
        PreparedStatement stmt = conn.prepareStatement(sql);
        
        // Zuweisung der zu übergebenden Werte aus dem Artikel-Objekt.
        stmt.setString(1, artikel.getArtikeltext());
        stmt.setString(2, artikel.getBestelltext());
        stmt.setInt(3, artikel.getEinzelwert());
        stmt.setInt(4, artikel.getMwst_satz());
        stmt.setInt(5, artikel.getBestellwert());
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
    
    /*----------------------------------------------------------*/
    /* Datum Name Was                                           */
    /* 02.12.16 MaLi Anlegen der Methode                        */
    /*----------------------------------------------------------*/
    /**
     * Diese Methode dient zum verwalten der Bestandsmengen eines Artikels. 
     * Es werden lediglich die Bewegungsdaten für die Bestandsmenge geändert.
     * @param id Die ID des Artikels das geändert werden soll
     * @param artikel Artikel-Objekts das die Bestandsmengen enthält
     * @throws SQLException
     */
    public void verwalteBestandsmengen(String id, Artikel artikel) throws SQLException{
        // Erzeugen eines neuen DBConnection Objekts.
        DBConnection con = new DBConnection();
        // Übergabe der Connection an ein Connection Objekt.
        Connection conn = con.createConection();
        // UpdateString zum Ausführen des Updates
        String sql = "update artikel set BESTANDSMENGE_RESERVIERT=?,"
                + "BESTANDSMENGE_ZULAUF=?, BESTANDSMENGE_VERKAUFT=?, "
                + "BESTANDSMENGE_FREI=? WHERE Artikel_ID=" + id;
        
        // Übergabe des Strings an das PreparedStatement
        PreparedStatement stmt = conn.prepareStatement(sql);
        
        // Zuweisung der zu übergebenden Werte aus dem Artikel-Objekt.
        stmt.setInt(1, artikel.getBestandsmenge_reserviert());
        stmt.setInt(2, artikel.getBestandsmenge_zulauf());
        stmt.setInt(3, artikel.getBestandsmenge_verkauft());
        stmt.setInt(4, artikel.getBestandsmenge_frei());
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
    
    
    /*----------------------------------------------------------*/
    /* Datum Name Was                                           */
    /* 02.12.16 MaLi Anlegen der Methode                        */
    /*----------------------------------------------------------*/
    /**
     * Sucht die letzte Artikel-ID in der Tabelle Artikel.
     * @return gibt die letzte Artikel-ID aus.
     * @throws SQLException
     */
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
        String sql = "select Artikel_ID, LKZ from artikel order by Erfassungsdatum ASC";
        String erg = "";
        try{
            // Ausführen der Statements
            rs = stmt.executeQuery(sql);

            // Schleife zum Speichern alle Auftragsobjekte
            while(rs.next()){
                
                // Prüft ob LKZ gesetzt ist
                if(rs.getString("LKZ") == null){
                    erg = rs.getString("Artikel_ID");
                } else {
                    return null;
                }
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
    
    /*----------------------------------------------------------*/
    /* Datum Name Was                                           */
    /* 02.12.16 MaLi Anlegen der Methode                        */
    /*----------------------------------------------------------*/
    /**
     * Erhöhte die letzte Artikel-ID anhand der Methode findeLetzteID.
     * @return erhöhte letzte ID wird ausgegeben.
     * @throws SQLException
     */
    public String erhoeheLetzteID() throws SQLException{
        String id = this.findeLetzteID();
        int idInt = Integer.parseInt(id);
        idInt = idInt + 1;
        return String.valueOf(idInt);
    }
    
    /*----------------------------------------------------------*/
    /* Datum Name Was                                           */
    /* 02.12.16 MaLi Anlegen der Methode                        */
    /*----------------------------------------------------------*/
    /**
     * Legt einen neuen Artikel Datensatz in der DB an. 
     * @param artikel Erhält ein Objekt der Klasse Artikel.  
     * @throws SQLException
     */
    public void legeNeueArtikelAn(Artikel artikel) throws SQLException{
        DBConnection con = new DBConnection();
        Connection conn = con.createConection();

    
        String sql = "insert into artikel "
                + "(Artikel_ID,Artikeltext,Bestelltext,Einzelwert,"
                + "MwSt_Satz,Bestellwert,Bestandsmenge_RESERVIERT, "
                + "Bestandsmenge_ZULAUF, Bestandsmenge_FREI, "
                + "Bestandsmenge_VERKAUFT) "
                + "values (?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, this.erhoeheLetzteID());
        stmt.setString(2, artikel.getArtikeltext());
        stmt.setString(3, artikel.getBestelltext());
        stmt.setInt(4, artikel.getEinzelwert());
        stmt.setInt(5,artikel.getMwst_satz());
        stmt.setInt(6, artikel.getBestellwert());
        stmt.setInt(7, artikel.getBestandsmenge_reserviert());
        stmt.setInt(8, artikel.getBestandsmenge_zulauf());
        stmt.setInt(9, artikel.getBestandsmenge_frei());
        stmt.setInt(10, artikel.getBestandsmenge_verkauft());

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
    
    
     public Artikel sucheArtikelFuerID(String artikelID) throws SQLException{
        Artikel artikel = new Artikel();
        return artikel;
    }
}
