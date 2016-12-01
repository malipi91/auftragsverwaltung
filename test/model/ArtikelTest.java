/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import junit.framework.TestSuite;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author samet
 */
public class ArtikeTest {
    
    
    
    @Test
    public void testGetArtikel_ID() {
    
        Artikel testArtikel = new Artikel("3333","text artikel","text bestellung",5,555,7,6,
        6,23,23, "445838");
        assertEquals("3333", testArtikel.getArtikel_ID());
    }

    /**
     * Test of setArtikel_ID method, of class Artikel.
     */
    @Test
    public void testSetArtikel_ID() {
        Artikel testArtikel = new Artikel("3333","text artikel","text bestellung",5,555,7,6,
        6,23,23, "445838");
        testArtikel.setArtikel_ID("555");
        assertEquals("555",testArtikel.getArtikel_ID());     
    }

    /**
     * Test of getArtikeltext method, of class Artikel.
     */
    @Test
    public void testGetArtikeltext() {Artikel testArtikel = new Artikel("3333","text artikel","text bestellung",5,555,7,6,
        6,23,23, "445838");
       assertEquals("text artikel",testArtikel.getArtikeltext());
    }

    /**
     * Test of setArtikeltext method, of class Artikel.
     */
    @Test
    public void testSetArtikeltext() {
        Artikel testArtikel = new Artikel("3333","text artikel","text bestellung",5,555,7,6,
        6,23,23, "445838");
        String artikelText = "geändert";
        testArtikel.setArtikeltext(artikelText);
        assertEquals(artikelText, testArtikel.getArtikeltext());
    }

    /**
     * Test of getBestelltext method, of class Artikel.
     */
    @Test
    public void testGetBestelltext() {Artikel testArtikel = new Artikel("3333","text artikel","text bestellung",5,555,7,6,
        6,23,23, "445838");
       assertEquals("text bestellung", testArtikel.getBestelltext());
    }
    /**
     * Test of setBestelltext method, of class Artikel.
     */
    @Test
    public void testSetBestelltext() {
        Artikel testArtikel = new Artikel("3333","text artikel","text bestellung",5,555,7,6,
        6,23,23, "445838");
        String bestellText = "geändert";
        testArtikel.setBestelltext(bestellText);
        assertEquals(bestellText, testArtikel.getBestelltext());
    }

    /**
     * Test of getEinzelwert method, of class Artikel.
     */
    @Test
    public void testGetEinzelwert() {
        Artikel testArtikel = new Artikel("3333","text artikel","text bestellung",5,555,7,6,
        6,23,23, "445838");
        assertEquals(5, testArtikel.getEinzelwert());
    }

    /**
     * Test of setEinzelwert method, of class Artikel.
     */
    @Test
    public void testSetEinzelwert() {
        Artikel testArtikel = new Artikel("3333","text artikel","text bestellung",5,555,7,6,
        6,23,23, "445838");
        int einzelwert = 46;
        testArtikel.setEinzelwert(einzelwert);
        assertEquals(einzelwert, testArtikel.getEinzelwert());
    }

    /**
     * Test of getBestellwert method, of class Artikel.
     */
    @Test
    public void testGetBestellwert() {
        Artikel testArtikel = new Artikel("3333","text artikel","text bestellung",5,555,7,6,
        6,23,23, "445838");
        assertEquals(555,testArtikel.getBestellwert());
    }

    /**
     * Test of setBestellwert method, of class Artikel.
     */
    @Test
    public void testSetBestellwert() {
        Artikel testArtikel = new Artikel("3333","text artikel","text bestellung",5,555,7,6,
        6,23,23, "445838");
        int bestellwert = 556;
        testArtikel.setBestellwert(bestellwert);
        assertEquals(bestellwert,testArtikel.getBestellwert());
    }

    /**
     * Test of getMwst_satz method, of class Artikel.
     */
    @Test
    public void testGetMwst_satz() {
        Artikel testArtikel = new Artikel("3333","text artikel","text bestellung",5,555,7,6,
        6,23,23, "445838");
        assertEquals(7, testArtikel.getMwst_satz());
    }

    /**
     * Test of setMwst_satz method, of class Artikel.
     */
    @Test
    public void testSetMwst_satz() {
        Artikel testArtikel = new Artikel("3333","text artikel","text bestellung",5,555,7,6,
        6,23,23, "445838");
        int mwst_satz = 99;
        testArtikel.setMwst_satz(mwst_satz);
        assertEquals(mwst_satz, testArtikel.getMwst_satz());
    }

    /**
     * Test of getBestandsmenge_frei method, of class Artikel.
     */
    @Test
    public void testGetBestandsmenge_frei() {
        Artikel testArtikel = new Artikel("3333","text artikel","text bestellung",5,555,7,6,
        6,23,23, "445838");
        assertEquals(6, testArtikel.getBestandsmenge_frei());
    }

    /**
     * Test of setBestandsmenge_frei method, of class Artikel.
     */
    @Test
    public void testSetBestandsmenge_frei() {
        Artikel testArtikel = new Artikel("3333","text artikel","text bestellung",5,555,7,6,
        6,23,23, "445838");
        int Bestandsmenge_frei = 15;
        testArtikel.setBestandsmenge_frei(Bestandsmenge_frei);
        assertEquals(Bestandsmenge_frei, testArtikel.getBestandsmenge_frei());
    }

    /**
     * Test of getBestandsmenge_reserviert method, of class Artikel.
     */
    @Test
    public void testGetBestandsmenge_reserviert() {
        Artikel testArtikel = new Artikel("3333","text artikel","text bestellung",5,555,7,6,
        6,23,23, "445838");
        assertEquals(6, testArtikel.getBestandsmenge_reserviert());
    }

    /**
     * Test of setBestandsmenge_reserviert method, of class Artikel.
     */
    @Test
    public void testSetBestandsmenge_reserviert() {
        Artikel testArtikel = new Artikel("3333","text artikel","text bestellung",5,555,7,6,
        6,23,23, "445838");
        int Bestandsmenge_reserviert = 144;
        testArtikel.setBestandsmenge_reserviert(Bestandsmenge_reserviert);
        assertEquals(Bestandsmenge_reserviert, testArtikel.getBestandsmenge_reserviert());
    }

    /**
     * Test of getBestandsmenge_zulauf method, of class Artikel.
     */
    @Test
    public void testGetBestandsmenge_zulauf() {
        Artikel testArtikel = new Artikel("3333","text artikel","text bestellung",5,555,7,6,
        6,23,23, "445838");
        assertEquals(23, testArtikel.getBestandsmenge_zulauf());
    }

    /**
     * Test of setBestandsmenge_zulauf method, of class Artikel.
     */
    @Test
    public void testSetBestandsmenge_zulauf() {
        Artikel testArtikel = new Artikel("3333","text artikel","text bestellung",5,555,7,6,
        6,23,23, "445838");
        int Bestandsmenge_zulauf = 1444;
        testArtikel.setBestandsmenge_zulauf(Bestandsmenge_zulauf);
        assertEquals(Bestandsmenge_zulauf, testArtikel.getBestandsmenge_zulauf());
    }

    /**
     * Test of getBestandsmenge_verkauft method, of class Artikel.
     */
    @Test
    public void testGetBestandsmenge_verkauft() {
        Artikel testArtikel = new Artikel("3333","text artikel","text bestellung",5,555,7,6,
        6,23,23, "445838");
        assertEquals(23, testArtikel.getBestandsmenge_verkauft());
    }

    /**
     * Test of setBestandsmenge_verkauft method, of class Artikel.
     */
    @Test
    public void testSetBestandsmenge_verkauft() {
        Artikel testArtikel = new Artikel("3333","text artikel","text bestellung",5,555,7,6,
        6,23,23, "445838");
        int Bestandsmenge_verkauft = 670;
        testArtikel.setBestandsmenge_verkauft(Bestandsmenge_verkauft);
        assertEquals(Bestandsmenge_verkauft, testArtikel.getBestandsmenge_verkauft());
    }

    /**
     * Test of getLieferantenID method, of class Artikel.
     */
    @Test
    public void testGetLieferantenID() {
        Artikel testArtikel = new Artikel("3333","text artikel","text bestellung",5,555,7,6,
        6,23,23, "445838");
        assertEquals("445838", testArtikel.getLieferantenID());
    }

    /**
     * Test of setLieferantenID method, of class Artikel.
     */
    @Test
    public void testSetLieferantenID() {
        Artikel testArtikel = new Artikel("3333","text artikel","text bestellung",5,555,7,6,
        6,23,23, "445838");
        String LieferantenID = "3323232323";
        testArtikel.setLieferantenID(LieferantenID);
        assertEquals(LieferantenID, testArtikel.getLieferantenID());
    }

    
    public static junit.framework.Test suite() {
        return new TestSuite(ArtikelModelTest.class);
        
    }
}