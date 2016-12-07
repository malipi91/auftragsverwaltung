package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import model.Adresse;
import util.DBConnection;
/**
 *
 * @author marti
 */
public class DAOAdresse {

    private DAODataDictionary dd;

    private final String TAB_ADRESSE = "adresse";
    
  
public DAOAdresse() throws SQLException{
    dd = new DAODataDictionary();
}
   
public void legeNeueAdresseAn(Adresse adresse) throws SQLException{
    String letzteID = dd.bekommeLetzteID(TAB_ADRESSE);
    DBConnection con = new DBConnection();
    Connection conn = con.createConection();
    String sql = "insert into adresse "
            + "(Adress_ID,Strasse,Hausnummer,PLZ,Ort,gueltig_bis) "
            + "values (?,?,?,?,?,?)";
    PreparedStatement stmt = conn.prepareStatement(sql);
    stmt.setString(1, letzteID);
    stmt.setString(2, "Muster Straße");
    stmt.setString(3, "18");
    stmt.setInt(4, 46348);
    stmt.setString(5, "Raesfeld");
    stmt.setDate(6, new Date(Long.parseLong(adresse.gibGueltigkeit())));;
    
    try{
    stmt.executeUpdate();
    dd.erhoeheLetzteID(TAB_ADRESSE);
    conn.close();
    } catch (SQLException e){
        System.out.println(e);
        System.out.println("Objekt wurde nicht hinzugefügt.");
    }    
}

}
