/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.SQLException;
import java.util.ArrayList;
import model.Zahlungskondition;
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
public class DAOZahlungskonditionTest {
    
    DAOZahlungskondition da;
    
    public DAOZahlungskonditionTest() {
        
    }
  
    @Before
    public void setUp() throws SQLException {
        da = new DAOZahlungskondition();
    }
    
    

    /**
     * Test of legeNeueZahlungskonditionAn method, of class DAOZahlungskondition.
     */
//    @Test
//    public void testLegeNeueZahlungskonditionAn() throws Exception {
////        Zahlungskondition kondiTest = new Zahlungskondition("225513", "Rech",
////                7, 14, 1, 4, 7, 5, 8, 9, 10);
////        da.legeNeueZahlungskonditionAn(kondiTest);
//        assertEquals("2213", da.erhalteZahlungskonditionFuerID("2213").getZk_ID());
//        
//    }

    /**
     * Test of erhalteZahlungskonditionFuerID method, of class DAOZahlungskondition.
     */
//    @Test
//    public void testErhalteZahlungskonditionFuerID() throws Exception {
//          assertEquals("225513", da.erhalteZahlungskonditionFuerID("225513").getZk_ID());
//    }

//
//    /**
//     * Test of loescheZahlungskondition method, of class DAOZahlungskondition.
//     */
    @Test
    public void testLoescheZahlungskondition() throws Exception {
//                Zahlungskondition kondiTest3 = new Zahlungskondition("222", "Re",
//                7, 14, 1, 4, 7, 5, 8, 9, 10);
//                da.legeNeueZahlungskonditionAn(kondiTest3);
//                da.loescheZahlungskondition("2213");
//                assertEquals("w", da.erhalteLKZZahlungskonditionFuerID("2213").getLKZ());
    }

//    @Test
//    public void findeLetzteZKID() throws SQLException{
//   
//    assertEquals("222",da.findeLetzteZKID());  
//    }
    
//    @Test
//    public void bearbeiteZahlungskondition() throws SQLException{
////        Zahlungskondition kondiTest4 = new Zahlungskondition("32244", "aaa",
////                555, 14, 1, 4, 7, 5, 8, 9, 10);
////        da.legeNeueZahlungskonditionAn(kondiTest4);
//        Zahlungskondition kondiTest5 = new Zahlungskondition("32244", "Rennerrrr",
//                666, 14, 1, 4, 7, 5, 8, 99, 4444);
//        da.bearbeiteZahlungskondition("32244",kondiTest5);
//
//    }
    
    @Test
    public void testgibAlleZahlungskonditionen() throws SQLException{
//        assertEquals("222",da.gibAlleZahlungskonditionen(15).get(3).getZk_ID());
        assertEquals(4,da.gibAlleZahlungskonditionen(15).size());
    }
    
}
