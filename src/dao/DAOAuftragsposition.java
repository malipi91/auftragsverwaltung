/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JTable;
import model.Auftragsposition;
import util.DBConnection;
import util.Zusatzfunktionen;

/**
 *
 * @author marti
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

    /*
     * Konstruktor der ein Objekt des DAOAuftragsposition erzeugt. 
     */
    public DAOAuftragsposition(){
        dd = new DAODataDictionary();
    zf = new Zusatzfunktionen();
    }
    
    /*
     * Es wird eine neue Auftragsposition angelegt. 
     */
     public void legeNeueAuftragspositionAn(Auftragsposition auftragsposition) throws SQLException{
        String letzteID = dd.bekommeLetzteID(TAB_AUFTRAGSPOSITION);
        DBConnection con = new DBConnection();
        Connection conn = con.createConection();
        
     /*----------------------------------------------------------*/
    /* Datum Name Was                                           */
    /* 24.11.16 Duygu Citak Anlegen der Methode                 */
    /*----------------------------------------------------------*/
    
    /* 
    *Diese Methode legt durch Eingabe der einzelnen Werte in die GUI einen neuen Auftrag 
    * in die Datenbank     
    */
    
        String sql = "insert into auftragsposition "
            + "(Auftragskopf_ID,Positionsnummer,Menge,Einzelwert,"
            + "Materialnummer "
            + "values (?,?,?,?,?)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, letzteID);
        stmt.setInt(2, auftragsposition.getPositionsnummer());
        stmt.setInt(3, auftragsposition.getMenge());
        stmt.setInt(4, auftragsposition.getEinzelwert());
        stmt.setString(6, auftragsposition.getArtikelID());

           
        try{
            stmt.executeUpdate();
            dd.erhoeheLetzteID(TAB_AUFTRAGSPOSITION);
            //Datenbankverbindung wird geschlossen
            conn.close();
            // Hier wird die Fehlermeldung ausgegeben
        } catch (SQLException e){
            System.out.println(e);
            System.out.println("Objekt wurde nicht hinzugefügt.");
        }    
    }
     
     
      /*
     * Es wird eine Auftragsposition gelöscht. Citak 30.11.2016 
     */
     public void loescheNeueAuftragsposition(int position) throws SQLException{
        DBConnection con = new DBConnection();
        Connection conn = con.createConection();
    }
    
}