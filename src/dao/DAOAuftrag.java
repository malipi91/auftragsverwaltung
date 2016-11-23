/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import model.Auftrag;
import util.DBConnection;
import util.Zusatzfunktionen;

/**
 *
 * @author marti
 */
public class DAOAuftrag{
   
    private DAODataDictionary dd;
    private Zusatzfunktionen zf;

    private final String TAB_AUFTRAG = "auftrag";
    
    public DAOAuftrag() throws SQLException{
    dd = new DAODataDictionary();
    zf = new Zusatzfunktionen();
}
    public void legeNeueAuftragAn(Auftrag auftrag) throws SQLException{
    String letzteID = dd.bekommeLetzteID(TAB_AUFTRAG);
    DBConnection con = new DBConnection();
    Connection conn = con.createConection();
    /*Hicran 18.11.2016
    *hier werden die Daten von der GUI gelesen und in die DB reingeschrieben.
    */
    
    String sql = "insert into auftrag "
            + "(Auftragskopf_ID,Auftragsart,Auftragstext,Erfassungsdatum,"
            + "Lieferdatum,AStatus, Abschlussdatum) "
            + "values (?,?,?,?,?,?,?)";
    PreparedStatement stmt = conn.prepareStatement(sql);
    stmt.setString(1, letzteID);
    stmt.setString(2, auftrag.getAuftragsart());
    stmt.setString(3, auftrag.getAuftragstext());
    stmt.setTimestamp(4, java.sql.Timestamp.valueOf(zf.gebeTimestamp()));
    stmt.setDate(5, java.sql.Date.valueOf(auftrag.getLieferdatum()));
    stmt.setString(6, auftrag.getStatus());
    stmt.setDate(7, java.sql.Date.valueOf(auftrag.getAbschlussdatum()));
    
    
    try{
    stmt.executeUpdate();
    dd.erhoeheLetzteID(TAB_AUFTRAG);
    conn.close();
    } catch (SQLException e){
        System.out.println(e);
        System.out.println("Objekt wurde nicht hinzugefügt.");
    }    
}
    
   
}
