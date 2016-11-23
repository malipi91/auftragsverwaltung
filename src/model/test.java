/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dao.DAOAdresse;
import dao.DAOAuftrag;
import java.sql.SQLException;

/**
 *
 * @author marti
 */
public class test {
    
    
    public static void main(String [ ] args) throws SQLException{
        Auftrag adr = new Auftrag();
        DAOAuftrag adresse = new DAOAuftrag();
        adr = adresse.erhalteAuftragFuerID("2");
        System.out.println(adr.getAuftragsart());
    }
    
}
