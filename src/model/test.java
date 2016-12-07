/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dao.DAOAdresse;
import dao.DAOArtikel;
import dao.DAOAuftrag;
import dao.DAOZahlungskondition;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author marti
 */
public class test {
    
    
    public static void main(String [ ] args) throws SQLException{
        DAOZahlungskondition dzk = new DAOZahlungskondition();
        Zahlungskondition zk = new Zahlungskondition();
        zk = dzk.erhalteZahlungskonditionFuerID("2");
        System.out.println(zk.getZk_ID());
    }  
}
