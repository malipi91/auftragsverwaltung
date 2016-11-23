/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.DAOZahlungskondition;

/**
 *
 * @author Duygu Citak
 */
public class Controller_zahlungskonditionen {
    
    //Variablendeklaration
    
    DAOZahlungskondition dao_zahlungskonditionen;
    
    
    public Controller_zahlungskonditionen (){
    this.dao_zahlungskonditionen = new DAOZahlungskondition();
    
    }
}
