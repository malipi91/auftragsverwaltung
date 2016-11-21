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
import util.DBConnection;

/**
 *
 * @author marti
 */
public class DAODataDictionary {
    
    private final String LETZE_ADRESS_ID;
    /*
    * Hicran
    */
        private final String LETZTE_AUFTRAG_ID;


    public DAODataDictionary() {
        this.LETZE_ADRESS_ID = "1";
        /*
        Hicran
        */
        this.LETZTE_AUFTRAG_ID = "2";
    }
    
    public String bekommeLetzteID(String tabelle) throws SQLException{
        DBConnection con = new DBConnection();
        Connection conn = con.createConection();
        Statement stmt = conn.createStatement();
        ResultSet rs = null;
        String sql = "select wert from datadictionary where";
        String result = "";
        if(tabelle == "adresse"){
            try{
                sql = sql + " dd_id = " + LETZE_ADRESS_ID;
            rs = stmt.executeQuery(sql);
            }catch(SQLException e){
                System.out.println("Statement nicht ausgeführt!");
                    }
            /*
            Hicran
            */
        } else if(tabelle.equals("auftrag")){
            try{
                sql = sql + " dd_id = " + LETZTE_AUFTRAG_ID;
            rs = stmt.executeQuery(sql);
            }catch(SQLException e){
                System.out.println("Statement nicht ausgeführt!");
                    }
        }
        
        while(rs.next()){
            result = rs.getString("Wert");
        }
        
        return result;
    }
    
    public void erhoeheLetzteID(String tabelle) throws SQLException{
        DBConnection con = new DBConnection();
        String sql = "";
        Connection conn = con.createConection();
        PreparedStatement stmt;
        if("adresse".equals(tabelle)){
            sql = "UPDATE datadictionary SET wert = ? WHERE dd_id = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, String.valueOf(this.inkrementiereLetzteID(this.bekommeLetzteID(tabelle))));
            stmt.setInt(2, 1);
            try{
                stmt.executeUpdate();
                conn.close();
            } catch (SQLException e){
                System.out.println(e);
                System.out.println("Objekt wurde nicht hinzugefügt.");
            }
            /*
            Hicran
            */
        } else if("auftrag".equals(tabelle)){
            sql = "UPDATE datadictionary SET wert = ? WHERE dd_id = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, String.valueOf(this.inkrementiereLetzteID(this.bekommeLetzteID(tabelle))));
            stmt.setInt(2, 2);
            try{
                stmt.executeUpdate();
                conn.close();
            } catch (SQLException e){
                System.out.println(e);
                System.out.println("Objekt wurde nicht hinzugefügt.");
            }
        }
    }
    
    public int inkrementiereLetzteID(String id){
        int lID = Integer.parseInt(id);
        lID = lID+ 1;
        return lID;
    }
}
