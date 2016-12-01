/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 * Erweiterung der setter und getter Methoden 24.11.2016
 * @author Duygu
 */
public class Auftragsposition {
    
    // Deklaration der Variablen

    private String auftragskopfId;
    private int positionsnummer;
    private String artikelID;
    private int menge;
    private int einzelwert;

    public Auftragsposition(String auftragskopfId, int positionsnummer, int menge, int einzelwert, String artikelID) {

        this.auftragskopfId = auftragskopfId;
        this.positionsnummer = positionsnummer;
        this.menge = menge;
        this.artikelID = artikelID;
        this.einzelwert = einzelwert;

    }
    
    public String getAuftragskopfId() {
        return this.auftragskopfId;
    }

    public void setAuftragskopfId(String auftragskopfId) {
        this.auftragskopfId = auftragskopfId;
    }

    public int getPositionsnummer() {
        return positionsnummer;
    }

    public void setPositionsnummer(int positionsnummer) {
        this.positionsnummer = positionsnummer;
    }

    public String getArtikelID() {
        return artikelID;
    }

    public void setArtikelID(String ArtikelID) {
        this.artikelID = artikelID;
    }

    public int getMenge() {
        return this.menge;
    }

    public void setMenge(int menge) {
        this.menge = menge;
    }

    public int getEinzelwert() {
        return this.einzelwert;
    }

    public void setEinzelwert(int einzelwert) {
        this.einzelwert = einzelwert;
    }

}