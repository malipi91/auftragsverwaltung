/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.DAOArtikel;
import dao.DAOAuftrag;
import dao.DAOAuftragsposition;
import dao.DAOGeschaeftspartner;
import dao.DAOKunde;
import dao.DAOLieferant;

/**
 *
 * @author Duygu Citak
 */
public class Controller_Auftrag {
    
    /* Variablendekleration */
    
    private DAOAuftrag dao_auftrag;
    private DAOArtikel dao_artikel;
    private DAOAuftragsposition dao_auftragsposition;
    private DAOGeschaeftspartner dao_gp;
    private DAOKunde dao_kunde;
    private DAOLieferant dao_Lieferant; 
    
    
    
     /*-----------------------------------------------------------*/
    /*                                                           */
    /* Methode: Konstruktor                                      */
    /* Was: Erzeugt ein Controller_Auftrag-Objekt                */
    /* 23.11.2016 Ersterstellung Duygu Citak                     */
    /*----------------------------------------------------------*/
    
    public Controller_Auftrag(){
    
//      this.dao_auftrag = new DAOAuftrag();
        this.dao_artikel = new DAOArtikel();
        this.dao_auftragsposition = new DAOAuftragsposition(); 
        this.dao_gp = new DAOGeschaeftspartner();
        this.dao_kunde = new DAOKunde(); 
        this.dao_Lieferant = new DAOLieferant(); 
    
    
    }
    
}
