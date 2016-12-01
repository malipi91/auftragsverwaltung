package model;

/*----------------------------------------------------------*/
/* Datum Name Was */
/* 14.11.16 MaLi Anlegen der Klasse */
/*----------------------------------------------------------*/
/**
 * Die Klasse spiegelt eine Klasse zur Erfassung einer Adresse wieder.
 * @author Martin Lipinski
 */
public class Adresse {
    
    // Spiegelt die Adress-ID einer Adresse wieder.
    private String adress_ID;
    // Spiegelt die Strasse einer Adresse wieder.
    private String strasse;
    // Spiegelt die PLZ einer Adresse wieder.
    private int plz;
    // Spiegelt die Hausnummer einer Adresse wieder.
    private String hausnummer;
    // Spiegelt die Ort einer Adresse wieder.
    private String ort;
    // Spiegelt die Staat einer Adresse wieder.
    private String staat;
    // Spiegelt die Gültigkeit einer Adresse wieder.
    private String gueltig_bis;
    // Gibt den Typ einer Adresse wieder.
    private String typ;
    
    public Adresse(){
        
    }
    /*----------------------------------------------------------*/
    /* Datum Name Was */
    /* 14.11.16 MaLi anlegen der Methode */
    /*----------------------------------------------------------*/    
    /**
     * Konstruktor zur Erzeugung eines Adress-Objekts.
     *  
     * @param ad_ID Parameter zur Übermittlung der Adress-ID.
     * @param strasse Parameter zur Übermittlung der Strasse der Adresse.
     * @param plz Parameter zur Übermittlung der PLZ der Adresse.
     * @param hausnummer Parameter zur Übermittlung der Hausnr. der Adresse.
     * @param ort Parameter zur Übermittlung des Ortes der Adresse.
     * @param staat Parameter zur Übermittlung des Staats der Adresse.
     * @param gueltig_bis Parameter zur Übermittlung der Gültigkeit der Adresse.
     * @param typ Paramater zur Identifizierung der Stammadresse.
     */
    public Adresse(String ad_ID, String strasse, String hausnummer, int plz, String ort, String staat, String gueltig_bis){
        this.adress_ID = ad_ID;
        this.strasse = strasse;
        this.staat = staat;
        this.plz = plz;
        this.hausnummer = hausnummer;
        this.ort = ort;
        this.gueltig_bis = gueltig_bis;
        this.typ = typ;
    }
    
    /*----------------------------------------------------------*/
    /* Datum Name Was */
    /* 14.11.16 MaLi anlegen der Methode */
    /*----------------------------------------------------------*/    
    /** 
     * Methode zum setzen der Adress-ID.
     * @param adress_ID Übermittelt die Adress-ID.
     */
    public void setzeAdress_ID(String adress_ID){
        this.adress_ID = adress_ID;
    }
    
    /*----------------------------------------------------------*/
    /* Datum Name Was */
    /* 14.11.16 MaLi anlegen der Methode */
    /*----------------------------------------------------------*/    
    /**
     * Methode zum Setzen des Typ-Flags. Das Flag dient der Identifizierung, ob 
     * es sich um eine Stammadresse handelt.
     * @param typ Übergibt den Typ einer Adresse.
     */
    public void setzeTyp(String typ){
        this.typ = typ;
    }
    
    /*----------------------------------------------------------*/
    /* Datum Name Was */
    /* 14.11.16 MaLi anlegen der Methode */
    /*----------------------------------------------------------*/  
    /**
     * Methode zum Setzen der Strasse innerhalb einer Adresse.
     * @param strasse Enthält die Strasse als Parameter.
     */
    public void setzeStrasse(String strasse){
        this.strasse = strasse;
    }
    
    /*----------------------------------------------------------*/
    /* Datum Name Was */
    /* 14.11.16 MaLi anlegen der Methode */
    /*----------------------------------------------------------*/  
    /**
     * Methode zum Setzen der Hausnummer innerhalb einer Adresse.
     * @param hausnummer Die Hausnummer der Adresse.
     */
    public void setzeHausnummer(String hausnummer){
        this.hausnummer = hausnummer;
    }
    
    /*----------------------------------------------------------*/
    /* Datum Name Was */
    /* 14.11.16 MaLi anlegen der Methode */
    /*----------------------------------------------------------*/  
    /**
     * Methode zum Setzen des Ortes innerhalb einer Adresse.
     * @param ort Der Ort der Adresse.
     */
    public void setzeOrt(String ort){
        this.ort = ort;
    }
    
    /*----------------------------------------------------------*/
    /* Datum Name Was */
    /* 14.11.16 MaLi anlegen der Methode */
    /*----------------------------------------------------------*/  
    /**
     * Methode zum Setzen der PLZ innerhalb einer Adresse. Es wird geprüft, ob 
     * der übergebene Wert der PLZ den Konventionen entspricht. Es erfolgt keine
     * Prüfung, ob die PLZ zum Ort passt.
     * @param plz Die PLZ eines Ortes.
     */ 
    public void setzePLZ(int plz){
        // Prüft ob PLZ korrekt ist.
        if(this.istPLZKorrekt(plz)){
            this.plz = plz;
        } else{
            //Gibt einen Fehler aus, wenn die PLZ nicht den Konventionen 
            //entspricht.
            System.out.println("Du hast einen Fehler in der PLZ!");
        }
    }
    
    /*----------------------------------------------------------*/
    /* Datum Name Was */
    /* 14.11.16 MaLi anlegen der Methode */
    /*----------------------------------------------------------*/  
    /**
     * Methode zum Setzen des Staates.
     * @param staat Der Staat innerhalb der Adresse.
     */
    public void setzeStaat(String staat){
        this.staat = staat;
    }
    
    /*----------------------------------------------------------*/
    /* Datum Name Was */
    /* 14.11.16 MaLi anlegen der Methode */
    /*----------------------------------------------------------*/  
    /**
     * Methode zum Setzen der Gültigkeit einer Adresse. Dabei wird vorher geprüft,
     * ob das Gültigkeitsdatum nicht in der Vergangenheit liegt.
     * @param gueltig_bis Übergibt die Gültigkeit einer Adresse.
     */
    public void setzeGueltigkeit(String gueltig_bis){
        
    }
    
    /*----------------------------------------------------------*/
    /* Datum Name Was */
    /* 14.11.16 MaLi anlegen der Methode */
    /*----------------------------------------------------------*/  
    /**
     * Methode zur Ausgabe des Typs einer Adresse.
     * @return Gibt den Typ einer Adresse wieder.
     */
    public String gibTyp(){
        return this.typ;
    }
    
    /*----------------------------------------------------------*/
    /* Datum Name Was */
    /* 14.11.16 MaLi anlegen der Methode */
    /*----------------------------------------------------------*/  
    /**
     * Methode zur Ausgabe der Adress-ID einer Adresse.
     * @return Gibt die Adress-ID wieder.
     */
    public String gibAdress_ID(){
        return this.adress_ID;
    }
    
    /*----------------------------------------------------------*/
    /* Datum Name Was */
    /* 14.11.16 MaLi anlegen der Methode */
    /*----------------------------------------------------------*/  
    /**
     * Methode zur Ausgabe der Strasse einer Adresse.
     * @return Gibt die Strasse einer Adresse wieder.
     */
    public String gibStrasse(){
        return this.strasse;
    }
    
    /*----------------------------------------------------------*/
    /* Datum Name Was */
    /* 14.11.16 MaLi anlegen der Methode */
    /*----------------------------------------------------------*/  
    /**
     * Methode zur Ausgabe der Hausnummer einer Adresse.
     * @return Gibt die Hausnummer einer Adresse wieder.
     */
    public String gibHausnummer(){
        return this.hausnummer;
    }
    
    /*----------------------------------------------------------*/
    /* Datum Name Was */
    /* 14.11.16 MaLi anlegen der Methode */
    /*----------------------------------------------------------*/  
    /**
     * Methode zur Ausgabe des Ortes einer Adresse.
     * @return Gibt den Ort einer Adresse wieder.
     */
    public String gibOrt(){
        return this.ort;
    }
    
    /*----------------------------------------------------------*/
    /* Datum Name Was */
    /* 14.11.16 MaLi anlegen der Methode */
    /*----------------------------------------------------------*/  
    /**
     * Methode zur Ausgabe der PLZ einer Adresse.
     * @return Gibt die PLZ einer Adresse wieder.
     */
    public int gibPLZ(){
        return this.plz;
    }
    
    /*----------------------------------------------------------*/
    /* Datum Name Was */
    /* 14.11.16 MaLi anlegen der Methode */
    /*----------------------------------------------------------*/  
    /**
     * Methode zur Ausgabe des Staates einer Adresse.
     * @return Gibt den Staat einer Adresse wieder.
     */
    public String gibStaat(){
        return this.staat;
    }
    
    /*----------------------------------------------------------*/
    /* Datum Name Was */
    /* 14.11.16 MaLi anlegen der Methode */
    /*----------------------------------------------------------*/  
    /**
     * Methode zur Ausgabe der Gültigkeit einer Adresse.
     * @return Gibt die Gültigkeit einer Adresse wieder.
     */
    public String gibGueltigkeit(){
        return this.gueltig_bis;
    }
    
    /*----------------------------------------------------------*/
    /* Datum Name Was */
    /* 14.11.16 MaLi anlegen der Methode */
    /*----------------------------------------------------------*/  
    /**
     * Methode zur Prüfung, ob eine Adresse den gängigen Konvetionen für eine 
     * PLZ entspricht.
     * @param plz Enthält die zu prüfende PLZ.
     * @return Gibt aus ob die PLZ korrekt ist.
     */
    public boolean istPLZKorrekt(int plz){
        return true;
    }
    
    /*----------------------------------------------------------*/
    /* Datum Name Was */
    /* 14.11.16 MaLi anlegen der Methode */
    /*----------------------------------------------------------*/  
    /**
     * Überprüft, ob die Adresse gültig (zeitlich) ist.
     * @param gueltig_bis Enthält das Enddatum der Gültigkeit.
     * @return Gibt aus, ob die Adresse gültig ist.
     */
    public boolean istAdresseGueltig(String gueltig_bis){
        return true;
    }
    
    /*----------------------------------------------------------*/
    /* Datum Name Was */
    /* 14.11.16 MaLi anlegen der Methode */
    /*----------------------------------------------------------*/  
    /**
     * Methode zur Prüfung, ob es sich um eine Stammadresse oder Lieferadresse
     * handelt.
     * @param typ Gibt an, ob es sich um ein Stammadresse handelt.
     * @return Gibt an, ob es eine Stammadresse ist, oder auch nicht.
     */
    public boolean istStammadresse(String typ){
        return typ == null;
    }
}
