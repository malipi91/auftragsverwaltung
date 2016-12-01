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
public class ZahlungskonditionTest {
    
   

    /**
     * Test of getZk_ID method, of class Zahlungskondition.
     */
    @Test
    public void testGetZk_ID() {
        Zahlungskondition testKondi = new Zahlungskondition("2213", "bar", 
                7, 14,2,5,3,4, 7, 12, 13);
        assertEquals("2213", testKondi.getZk_ID());
    }

    /**
     * Test of setZk_ID method, of class Zahlungskondition.
     */
    @Test
    public void testSetZk_ID() {
        Zahlungskondition testKondi = new Zahlungskondition("2213", "bar", 
                7, 14,2,5,3,4, 7, 12, 13);
        String zk_ID = "4342";
        testKondi.setZk_ID(zk_ID);
        assertEquals(zk_ID, testKondi.getZk_ID());
    }

    /**
     * Test of getAuftragsart method, of class Zahlungskondition.
     */
    @Test
    public void testGetAuftragsart() {
        Zahlungskondition testKondi = new Zahlungskondition("2213", "bar", 
                7, 14,2,5,3,4, 7, 12, 13);
        testKondi.getAuftragsart();
        
    }

    /**
     * Test of setAuftragsart method, of class Zahlungskondition.
     */
    @Test
    public void testSetAuftragsart() {
        Zahlungskondition testKondi = new Zahlungskondition("2213", "bar", 
                7, 14,2,5,3,4, 7, 12, 13);
        String auftragsArt = "rech";
        testKondi.setAuftragsart(auftragsArt);
        assertEquals(auftragsArt, testKondi.getAuftragsart());
    }

    /**
     * Test of getSkontozeit_1 method, of class Zahlungskondition.
     */
    @Test
    public void testGetSkontozeit_1() {
         Zahlungskondition testKondi = new Zahlungskondition("2213", "bar", 
                7, 14,2,5,3,4, 7, 12, 13);
         testKondi.getSkontozeit_1();
    }

    /**
     * Test of setSkontozeit_1 method, of class Zahlungskondition.
     */
    @Test
    public void testSetSkontozeit_1() {
        Zahlungskondition testKondi = new Zahlungskondition("2213", "bar", 
                7, 14,2,5,3,4, 7, 12, 13);
        int Skontozeit_1 = 4;
        testKondi.setSkonto_1(Skontozeit_1);
        assertEquals(Skontozeit_1, testKondi.getSkonto_1());
    }

    /**
     * Test of getSkontozeit_2 method, of class Zahlungskondition.
     */
    @Test
    public void testGetSkontozeit_2() {
        Zahlungskondition testKondi = new Zahlungskondition("2213", "bar", 
                7, 14,2,5,3,4, 7, 12, 13);
        testKondi.getSkontozeit_2();
        
    }

    /**
     * Test of setSkontozeit_2 method, of class Zahlungskondition.
     */
    @Test
    public void testSetSkontozeit_2() {
        Zahlungskondition testKondi = new Zahlungskondition("2213", "bar", 
                7, 14,2,5,3,4, 7, 12, 13);
        int skontozeit_2 = 23;
        testKondi.setSkontozeit_2(skontozeit_2);
        assertEquals(skontozeit_2, testKondi.getSkontozeit_2());
    }

    /**
     * Test of getLieferzeit_sofort method, of class Zahlungskondition.
     */
    @Test
    public void testGetLieferzeit_sofort() {
        Zahlungskondition testKondi = new Zahlungskondition("2213", "bar", 
                7, 14,2,5,3,4, 7, 12, 13);
        testKondi.getLieferzeit_sofort();
    }

    /**
     * Test of setLieferzeit_sofort method, of class Zahlungskondition.
     */
    @Test
    public void testSetLieferzeit_sofort() {
        Zahlungskondition testKondi = new Zahlungskondition("2213", "bar", 
                7, 14,2,5,3,4, 7, 12, 13);
        int lieferzeit_sofort = 3;
        testKondi.setLieferzeit_sofort(lieferzeit_sofort);
        assertEquals(lieferzeit_sofort, testKondi.getLieferzeit_sofort());
    }

    /**
     * Test of getLieferzeit_wunsch method, of class Zahlungskondition.
     */
    @Test
    public void testGetLieferzeit_wunsch() {
        Zahlungskondition testKondi = new Zahlungskondition("2213", "bar", 
                7, 14,2,5,3,4, 7, 12, 13);
        assertEquals(5, testKondi.getLieferzeit_wunsch());
    }

    /**
     * Test of setLieferzeit_wunsch method, of class Zahlungskondition.
     */
    @Test
    public void testSetLieferzeit_wunsch() {
        Zahlungskondition testKondi = new Zahlungskondition("2213", "bar", 
                7, 14,2,5,3,4, 7, 12, 13);
        int lieferzeit_wunsch = 18;
        testKondi.setLieferzeit_wunsch(lieferzeit_wunsch);
        assertEquals(lieferzeit_wunsch, testKondi.getLieferzeit_wunsch());
    }

    /**
     * Test of getSkonto_1 method, of class Zahlungskondition.
     */
    @Test
    public void testGetSkonto_1() {
        Zahlungskondition testKondi = new Zahlungskondition("2213", "bar", 
                7, 14,2,5,3,4, 7, 12, 13);
        assertEquals(3, testKondi.getSkonto_1());
    }

    /**
     * Test of setSkonto_1 method, of class Zahlungskondition.
     */
    @Test
    public void testSetSkonto_1() {
        Zahlungskondition testKondi = new Zahlungskondition("2213", "bar", 
                7, 14,2,5,3,4, 7, 12, 13);
        int skonto_1= 14;
        testKondi.setSkonto_1(skonto_1);
        assertEquals(skonto_1, testKondi.getSkonto_1());
    }

    /**
     * Test of getSkonto_2 method, of class Zahlungskondition.
     */
    @Test
    public void testGetSkonto_2() {
        Zahlungskondition testKondi = new Zahlungskondition("2213", "bar", 
                7, 14,2,5,3,4, 7, 12, 13);
        assertEquals(4,testKondi.getSkonto_2());
    }

    /**
     * Test of setSkonto_2 method, of class Zahlungskondition.
     */
    @Test
    public void testSetSkonto_2() {
        Zahlungskondition testKondi = new Zahlungskondition("2213", "bar", 
                7, 14,2,5,3,4, 7, 12, 13);
        int skonto_2 = 22;
        testKondi.setSkonto_2(skonto_2);
        assertEquals(skonto_2, testKondi.getSkonto_2());
    }

    /**
     * Test of getMahnzeit_1 method, of class Zahlungskondition.
     */
    @Test
    public void testGetMahnzeit_1() {
        Zahlungskondition testKondi = new Zahlungskondition("2213", "bar", 
                7, 14,2,5,3,4, 7, 12, 13);
        assertEquals(7, testKondi.getMahnzeit_1());
    }

    /**
     * Test of setMahnzeit_1 method, of class Zahlungskondition.
     */
    @Test
    public void testSetMahnzeit_1() {
        Zahlungskondition testKondi = new Zahlungskondition("2213", "bar", 
                7, 14,2,5,3,4, 7, 12, 13);
        int mahnzeit_1 = 13;
        testKondi.setMahnzeit_1(mahnzeit_1);
        assertEquals(mahnzeit_1, testKondi.getMahnzeit_1());
    }

    /**
     * Test of getMahnzeit_2 method, of class Zahlungskondition.
     */
    @Test
    public void testGetMahnzeit_2() {
        Zahlungskondition testKondi = new Zahlungskondition("2213", "bar", 
                7, 14,2,5,3,4, 7, 12, 13);
        assertEquals(12, testKondi.getMahnzeit_2());
    }

    /**
     * Test of setMahnzeit_2 method, of class Zahlungskondition.
     */
    @Test
    public void testSetMahnzeit_2() {
        Zahlungskondition testKondi = new Zahlungskondition("2213", "bar", 
                7, 14,2,5,3,4, 7, 12, 13);
        int mahnzeit_2 = 115;
        testKondi.setMahnzeit_2(mahnzeit_2);
        assertEquals(mahnzeit_2, testKondi.getMahnzeit_2());
    }

    /**
     * Test of getMahnzeit_3 method, of class Zahlungskondition.
     */
    @Test
    public void testGetMahnzeit_3() {
        Zahlungskondition testKondi = new Zahlungskondition("2213", "bar", 
                7, 14,2,5,3,4, 7, 12, 13);
        assertEquals(13, testKondi.getMahnzeit_3());
    }

    /**
     * Test of setMahnzeit_3 method, of class Zahlungskondition.
     */
    @Test
    public void testSetMahnzeit_3() {
        Zahlungskondition testKondi = new Zahlungskondition("2213", "bar", 
                7, 14,2,5,3,4, 7, 12, 13);
        int mahnzeit_3 = 15;
        testKondi.setMahnzeit_3(mahnzeit_3);
        assertEquals(mahnzeit_3, testKondi.getMahnzeit_3());
    }
    
}
