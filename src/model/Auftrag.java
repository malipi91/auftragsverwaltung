/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author marti
 */
public class Auftrag {
    
    private String auftrags_ID;
    private String auftragstext;
    private Adresse standardAnschrift;
    private String Erfassungsdatum;
    private String Lieferdatum; 
    private String auftragsart;
    private int auftragswert;
    private String Status;
    private String abschlussdatum; 
    private ArrayList<Auftragsposition> auftragspositionen ;
    private Geschaeftspartner geschaeftspartner;
    private String geschaeftspartnerID;
    
    public Auftrag(){
        
    }
    public Auftrag(String id, String text, String erfassungsdatum, 
            String lieferdatum, String auftragsart, int auftragswert, 
            String status, String abschlussdatum){
        this.auftrags_ID = id;
        this.auftragstext = text;
        this.Erfassungsdatum = erfassungsdatum;
        this.Lieferdatum = lieferdatum;
        this.auftragsart = auftragsart;
        this.auftragswert = auftragswert;
        this.Status = status;
        this.abschlussdatum = abschlussdatum;
        
    }
    
    public void setzeGeschaeftspartnerID(String id){
        this.geschaeftspartnerID = id;
    }
    
    /**
     * Erzeugt ein Instanz von Auftrag, mit eingegangene Daten
     * Hicran
     * @param auftragstext
     * @param Erfassungsdatum
     * @param Lieferdatum
     * @param auftragsart
     * @param auftragswert
     * @param Status
     * @param abschlussdatum 
     */
//    
////    Hicran, erzeuge einen Konstruktor um in die Datenbank einzuschreiben
//    public Auftrag(String auftragstext,String Erfassungsdatum,String Lieferdatum,
//            String auftragsart, String Status,
//            String abschlussdatum
//            ){
//        this.standardAnschrift =standardAnschrift;
//        this.auftragstext = auftragstext;
//        this.Erfassungsdatum = Erfassungsdatum;
//        this.Lieferdatum = Lieferdatum;
//        this.Status = Status;
//        this.auftragswert = 0;
//        this.abschlussdatum = abschlussdatum;
//        this.auftragspositionen = auftragspositionen;
//        this.auftragsart = auftragsart;
//        this.geschaeftspartner = geschaeftspartner;
//        
//    }

    public String getAuftrags_ID() {
        return auftrags_ID;
    }

    public void setAuftrags_ID(String auftrags_ID) {
        this.auftrags_ID = auftrags_ID;
    }

    public String getAuftragstext() {
        return auftragstext;
    }

    public void setAuftragstext(String auftragstext) {
        this.auftragstext = auftragstext;
    }

    public Adresse getStandardAnschrift() {
        return standardAnschrift;
    }
    
    public int getAuftragswert(){
        return this.auftragswert;
    }

    public void setStandardAnschrift(Adresse standardAnschrift) {
        this.standardAnschrift = standardAnschrift;
    }

    public String getErfassungsdatum() {
        return Erfassungsdatum;
    }

    public void setErfassungsdatum(String Erfassungsdatum) {
        this.Erfassungsdatum = Erfassungsdatum;
    }

    public String getLieferdatum() {
        return Lieferdatum;
    }

    public void setLieferdatum(String Lieferdatum) {
        this.Lieferdatum = Lieferdatum;
    }

    public String getAuftragsart() {
        return auftragsart;
    }

    public void setAuftragsart(String auftragsart) {
        this.auftragsart = auftragsart;
    }

    public void setAuftragswert(int auftragswert) {
        this.auftragswert = auftragswert;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

    public String getAbschlussdatum() {
        return abschlussdatum;
    }

    public void setAbschlussdatum(String abschlussdatum) {
        this.abschlussdatum = abschlussdatum;
    }

    public ArrayList<Auftragsposition> getAuftragspositionen() {
        return auftragspositionen;
    }

    public void setAuftragspositionen(ArrayList<Auftragsposition> auftragspositionen) {
        this.auftragspositionen = auftragspositionen;
    }

    public Geschaeftspartner getGeschaeftspartner() {
        return geschaeftspartner;
    }

    public void setGeschaeftspartner(Geschaeftspartner geschaeftspartner) {
        this.geschaeftspartner = geschaeftspartner;
    }
    
    
    public int berechneAuftragswertNetto(){
        return 0;
    }
    
    public int berechneAuftragswertBrutto(){
        return 0;
    }
    
    public Geschaeftspartner sucheKunde(){
        return geschaeftspartner;
    }
    
    public void storniereAuftrag(){
        
    }
    
    public void loescheAuftragsposition(Auftragsposition pos){
        
    }
    
    
}