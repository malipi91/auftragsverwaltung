/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author marti
 */
public class Artikel {
    
    private String artikel_ID;
    private String artikeltext;
    private String bestelltext;
    private int einzelwert;
    private int mwst_satz;
    private int bestellwert;
    private int bestandsmenge_reserviert;
    private int bestandsmenge_zulauf;
    private int bestandsmenge_verkauft;
    private int bestandsmenge_frei;
    private String lieferantenID;
    
    
    public Artikel(){
        
    }

    Artikel(String artikel_ID, String artikeltext, String bestelltext, 
            int einzelwert, int mwst_satz, int bestellwert, int bestandsmenge_reserviert,
            int bestandsmenge_zulauf, int bestandsmenge_verkauft, 
            int bestandsmenge_frei) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    Artikel(String string, String text_artikel, String text_bestellung, int i, int i0, int i1, int i2, int i3, int i4, int i5, String string0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  

    public String getArtikel_ID() {
        return artikel_ID;
    }

    public void setArtikel_ID(String artikel_ID) {
        this.artikel_ID = artikel_ID;
    }

    public String getArtikeltext() {
        return artikeltext;
    }

    public void setArtikeltext(String artikeltext) {
        this.artikeltext = artikeltext;
    }

    public String getBestelltext() {
        return bestelltext;
    }

    public void setBestelltext(String bestelltext) {
        this.bestelltext = bestelltext;
    }

    public int getEinzelwert() {
        return einzelwert;
    }

    public void setEinzelwert(int einzelwert) {
        this.einzelwert = einzelwert;
    }

    public int getBestellwert() {
        return bestellwert;
    }

    public void setBestellwert(int bestellwert) {
        this.bestellwert = bestellwert;
    }

    public int getMwst_satz() {
        return mwst_satz;
    }

    public void setMwst_satz(int mwst_satz) {
        this.mwst_satz = mwst_satz;
    }

    public int getBestandsmenge_frei() {
        return bestandsmenge_frei;
    }

    public void setBestandsmenge_frei(int bestandsmenge_frei) {
        this.bestandsmenge_frei = bestandsmenge_frei;
    }

    public int getBestandsmenge_reserviert() {
        return bestandsmenge_reserviert;
    }

    public void setBestandsmenge_reserviert(int bestandsmenge_reserviert) {
        this.bestandsmenge_reserviert = bestandsmenge_reserviert;
    }

    public int getBestandsmenge_zulauf() {
        return bestandsmenge_zulauf;
    }

    public void setBestandsmenge_zulauf(int bestandsmenge_zulauf) {
        this.bestandsmenge_zulauf = bestandsmenge_zulauf;
    }

    public int getBestandsmenge_verkauft() {
        return bestandsmenge_verkauft;
    }

    public void setBestandsmenge_verkauft(int bestandsmenge_verkauft) {
        this.bestandsmenge_verkauft = bestandsmenge_verkauft;
    }

    public String getLieferantenID() {
        return lieferantenID;
    }

    public void setLieferantenID(String lieferantenID) {
        this.lieferantenID = lieferantenID;
    }
    
    
    public int pruefeBestand(){
        return 0;
    }
    
    public void erhoeheZulauf(){
        
    }
    
    public int gibAnzahlReservierterArtikel(){
        return 0;
    }
    
    public void erhoeheVerkauft(){
        
    }
    
    public void loescheReservierung(){
        
    }
    
    public String gibLieferantenID(){
        return lieferantenID;
    }
}
