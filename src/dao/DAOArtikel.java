/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.SQLException;
import model.Artikel;

/**
 *
 * @author marti
 */
public class DAOArtikel {
    public void legeNeueArtikelAn(Artikel artikel) throws SQLException{
    }
    public boolean loescheArtikelMitID(String artikelID)throws SQLException{
        return true;
    }
    public Artikel sucheArtikelFuerID(String artikelID) throws SQLException{
        Artikel artikel = new Artikel();
        return artikel;
    }
    
   
}
