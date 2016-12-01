/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

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
public class AuftragspositionTest {
    
    
    
    @Test
    public void testGetAuftragskopfId() {
        
        Auftragsposition testPos = new Auftragsposition("55495", 3, 55, 10, "443");
        assertEquals("55495",testPos.getAuftragskopfId());
        
    }

    /**
     * Test of setAuftragskopfId method, of class Auftragsposition.
     */
    @Test
    public void testSetAuftragskopfId() {
        Auftragsposition testPos = new Auftragsposition("55495", 3, 55, 10, "443");
        String auftragskopfID = "33323232";
        testPos.setAuftragskopfId(auftragskopfID);
        assertEquals(auftragskopfID,testPos.getAuftragskopfId());
        
    }

    /**
     * Test of getPositionsnummer method, of class Auftragsposition.
     */
    @Test
    public void testGetPositionsnummer() {
        Auftragsposition testPos = new Auftragsposition("55495", 3, 55, 10, "443");
        assertEquals(3, testPos.getPositionsnummer());
    }

    /**
     * Test of setPositionsnummer method, of class Auftragsposition.
     */
    @Test
    public void testSetPositionsnummer() {
        Auftragsposition testPos = new Auftragsposition("55495", 3, 55, 10, "443");
        int positionsnummer = 7;
        testPos.setPositionsnummer(positionsnummer);
        assertEquals(positionsnummer, testPos.getPositionsnummer());
    }

    /**
//     * Test of getArtikelID method, of class Auftragsposition.
//     */
//    @Test
//    public void testGetArtikelID() {
//        Auftragsposition testPos = new Auftragsposition("55495", 3, 55, 10, 443);
//        assertEquals(443, testPos.getArtikelID());
//    }
//
//    /**
//     * Test of setArtikelID method, of class Auftragsposition.
//     */
//    @Test
//    public void testSetArtikelID() {
//        Auftragsposition testPose = new Auftragsposition("55495", 3, 55, 10, 443);
//        int artikelID = 33242466;
//        testPose.setArtikelID(artikelID);
//        assertEquals(artikelID, testPose.getArtikelID());
//    }

    /**
     * Test of getMenge method, of class Auftragsposition.
     */
    @Test
    public void testGetMenge() {
        Auftragsposition testPos = new Auftragsposition("55495", 3, 55, 10, "443");
        testPos.getMenge();
    }

    /**
     * Test of setMenge method, of class Auftragsposition.
     */
    @Test
    public void testSetMenge() {
        Auftragsposition testPos = new Auftragsposition("55495", 3, 55, 10, "443");
        int menge = 555;
        testPos.setMenge(menge);
        assertEquals(menge,testPos.getMenge());
    }

    /**
     * Test of getEinzelwert method, of class Auftragsposition.
     */
    @Test
    public void testGetEinzelwert() {
        Auftragsposition testPos = new Auftragsposition("55495", 3, 55, 10, "443");
        testPos.getEinzelwert();
    }

    /**
     * Test of setEinzelwert method, of class Auftragsposition.
     */
    @Test
    public void testSetEinzelwert() {
        Auftragsposition testPos = new Auftragsposition("55495", 3, 55, 10, "443");
        int einzelwert = 658;
        testPos.setEinzelwert(einzelwert);
        assertEquals(einzelwert, testPos.getEinzelwert());
    }
    
}
