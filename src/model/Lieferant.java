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
public class Lieferant extends Geschaeftspartner{

    public Lieferant(String geschaeftspartnerID, String geschaeftspartnerTyp, int kreditlimit, String name, Adresse anschrift, String telefon, String fax, String email, String erfassungsdatum, String titel) {
        super(geschaeftspartnerID, geschaeftspartnerTyp, kreditlimit, name, anschrift, telefon, fax, email, erfassungsdatum, titel);
    }

}
