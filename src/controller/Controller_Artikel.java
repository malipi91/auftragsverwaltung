/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.DAOArtikel;

/**
 *
 * @author Duygu Citak
 */
public class Controller_Artikel {
    
    
    DAOArtikel dao_Artikel; 
        
     /*-----------------------------------------------------------*/
    /*                                                           */
    /* Methode: Konstruktor                                      */
    /* Was: Erzeugt ein Controller_Artikel-Objekt                */
    /* 23.11.2016 Ersterstellung Duygu Citak                     */
    /*----------------------------------------------------------*/
    
    public Controller_Artikel(){
    this.dao_Artikel = new DAOArtikel();
    }
    
}
