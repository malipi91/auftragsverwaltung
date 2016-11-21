/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

/**
 *
 * @author marti
 */
public class DAOKunde extends DAOGeschaeftspartner {
   
    private DAODataDictionary dd;
    private final String TAB_ADRESSE = "adresse";
    private final String LASTID_K = "lastID_K";
    /**
     *
     */
    public DAOKunde(){
        dd = new DAODataDictionary();
    }
    
}
