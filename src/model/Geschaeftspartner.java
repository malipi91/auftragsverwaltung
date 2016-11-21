/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author duygu
 */
public class Geschaeftspartner {
    
     private int geschaeftspartnerID;
     private String geschaeftspartnerTyp;
     private int kreditlimit;
     private String name;
     private Adresse anschrift;
     private String telefon;
     private String fax;
     private String email;
     private String erfassungsdatum;
     private String titel;
     
     
     
      public Geschaeftspartner(int geschaeftspartnerID, String geschaeftspartnerTyp, int kreditlimit, String name, Adresse anschrift, String telefon,
      String fax, String email, String erfassungsdatum, String titel) {
        this.geschaeftspartnerID = geschaeftspartnerID;
        this.geschaeftspartnerTyp= geschaeftspartnerTyp;
        this.anschrift = anschrift;
        this.kreditlimit = kreditlimit;
        this.name = name;
        this.telefon = telefon;
        this.fax = fax;
        this.email = email;
        this.erfassungsdatum = erfassungsdatum;
        this.titel= titel;

    }
}
     

