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
    
    DAOArtikel da;
   
    
    @Before
    public void setUp() {
        da = new DAOArtikel();
    }
    
 

    /**
     * Test of erhalteEinenArtikel method, of class DAOArtikel.
     */ 
    @Test
    public void testErhalteEinenArtikel() throws Exception {
        Artikel artikelTest = new Artikel("2","testt","test",333,4444,555, 5555,100, 
            500, 400, "44343");
        da.legeNeueArtikelAn(artikelTest);
        
        
        
    }

    
//
//    /**
//     * Test of loescheArtikel method, of class DAOArtikel.
//     */
//    @Test
//    public void testLoescheArtikel() throws Exception {
//       
//        da.loescheArtikel("8847");
//        assertEquals(da.erhalteEinenArtikel("8847").getLKZ(),"w");
//
    /**
     * Test of bearbeiteArtikel method, of class DAOArtikel.
     */
//    @Test
//    public void testBearbeiteArtikel() throws Exception {
//        Artikel artikel2 = new Artikel("8847","lss", "sddf", 300, 120, 15, 20, 30, 40, 40, "jdfj");
//        da.bearbeiteArtikel("8847", artikel2);
//        assertEquals(300,da.erhalteEinenArtikel("8847").getEinzelwert());
//    }
//
//    /**
//     * Test of verwalteBestandsmengen method, of class DAOArtikel.
//     */
//    
}

