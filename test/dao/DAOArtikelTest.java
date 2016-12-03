/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import model.Artikel;
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
public class DAOArtikelTest {
    
    public DAOArtikelTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of erhalteEinenArtikel method, of class DAOArtikel.
     */
    @Test
    public void testErhalteEinenArtikel() throws Exception {
        System.out.println("erhalteEinenArtikel");
        String id = "";
        DAOArtikel instance = new DAOArtikel();
        Artikel expResult = null;
        Artikel result = instance.erhalteEinenArtikel(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of gibAlleArtikelDetails method, of class DAOArtikel.
     */
    @Test
    public void testGibAlleArtikelDetails() throws Exception {
        System.out.println("gibAlleArtikelDetails");
        int anzahl = 0;
        DAOArtikel instance = new DAOArtikel();
        ArrayList<Artikel> expResult = null;
        ArrayList<Artikel> result = instance.gibAlleArtikelDetails(anzahl);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of loescheArtikel method, of class DAOArtikel.
     */
    @Test
    public void testLoescheArtikel() throws Exception {
        System.out.println("loescheArtikel");
        String id = "";
        DAOArtikel instance = new DAOArtikel();
        instance.loescheArtikel(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of bearbeiteArtikel method, of class DAOArtikel.
     */
    @Test
    public void testBearbeiteArtikel() throws Exception {
        System.out.println("bearbeiteArtikel");
        String id = "";
        Artikel artikel = null;
        DAOArtikel instance = new DAOArtikel();
        instance.bearbeiteArtikel(id, artikel);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of verwalteBestandsmengen method, of class DAOArtikel.
     */
    @Test
    public void testVerwalteBestandsmengen() throws Exception {
        System.out.println("verwalteBestandsmengen");
        String id = "";
        Artikel artikel = null;
        DAOArtikel instance = new DAOArtikel();
        instance.verwalteBestandsmengen(id, artikel);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
