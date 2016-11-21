/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author hicran
 */
public class Auftragsposition {
    
    private String positionsnummer;
    private Artikel artikelname;
    private Artikel artikelID;
    private int menge;
    private int einzelwert;
    
    
  public Auftragsposition(String positionsnummer, Artikel artikelID, int menge, int einzelwert, Artikel artikelname) {

        this.positionsnummer = positionsnummer;
        this.artikelID = artikelID;
        this.artikelname= artikelname;
        this.menge = menge;
        this.einzelwert = einzelwert;

    }
  
   public String getPositionsnummer() {
        return positionsnummer;
    }

    public void setPositionsnummer(String positionsnummer) {
        this.positionsnummer = positionsnummer;
    }
  
    public Artikel getArtikelID() {
        return artikelID;
    }

    public void setArtikelID(int ArtikelID) {
        this.artikelID = artikelID;
    }
    
  public Artikel getArtikelname() {
        return artikelname;
    }

public void setArtikelname(Artikel artikelname) {
        this.artikelname = artikelname;
    }
    
}
