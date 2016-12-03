/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dao.DAOAdresse;
import dao.DAOAuftrag;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author marti
 */
public class test {
    
    
    public static void main(String [ ] args) throws SQLException{
        ArrayList<Auftrag> auftraege = new ArrayList<>();
        DAOAuftrag auftrag = new DAOAuftrag();
        Auftrag auf = new Auftrag();
        auf = auftrag.erhalteAuftragFuerID("1");
        auf.setAuftragswert(10020);
        auftrag.bearbeiteAuftrag("1", auf);
    }
    
}
