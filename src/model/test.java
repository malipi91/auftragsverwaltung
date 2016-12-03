/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dao.DAOAdresse;
import dao.DAOArtikel;
import dao.DAOAuftrag;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author marti
 */
public class test {
    
    
    public static void main(String [ ] args) throws SQLException{
        DAOAuftrag auftrag = new DAOAuftrag();
        System.out.println(auftrag.findeLetzteID());
        Auftrag auf = new Auftrag();
        auf.setAuftragstext("test12345");
        auf.setAbschlussdatum("2016-01-01");
        auf.setLieferdatum("2017-03-01");
        auftrag.legeNeueAuftragAn(auf);
    }
    
}
