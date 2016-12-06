/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JTable;
import model.Auftragsposition;
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
public class DAOAuftragspositionTest {
    
    DAOAuftragsposition Dap;

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
        Dap = new DAOAuftragsposition();
    }

   
    
    

    /**
     * Test of legeNeueAuftragspositionAn method, of class DAOAuftragsposition.
     */
    @Test
    public void testLegeNeueAuftragspositionAn() throws Exception {
        Auftragsposition ap = new Auftragsposition("345", 4, 6, 6, "66");
       
        Dap.legeNeueAuftragspositionAn(ap);
        assertEquals("345", ap.getAuftragskopfId());
    }

    /**
     * Test of position_aus_Tabelle method, of class DAOAuftragsposition.
     */
//    @Test
//    public void testPosition_aus_Tabelle_ArrayList_Auftragsposition() {
//        System.out.println("position_aus_Tabelle");
//        ArrayList<Auftragsposition> auftragsPositionen = null;
//        Auftragsposition auftragsposition = null;
//        Auftragsposition expResult = null;
//        Auftragsposition result = DAOAuftragsposition.position_aus_Tabelle(auftragsPositionen, auftragsposition);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of position_aus_Tabelle method, of class DAOAuftragsposition.
//     */
//    @Test
//    public void testPosition_aus_Tabelle_JTable() {
//        System.out.println("position_aus_Tabelle");
//        JTable jTAuftragsposition = null;
//        Auftragsposition expResult = null;
//        Auftragsposition result = DAOAuftragsposition.position_aus_Tabelle(jTAuftragsposition);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of loescheNeueAuftragsposition method, of class DAOAuftragsposition.
//     */
//    @Test
//    public void testLoescheNeueAuftragsposition() throws Exception {
//        System.out.println("loescheNeueAuftragsposition");
//        String auftragskopf_id = "";
//        int positionsnummer = 0;
//        DAOAuftragsposition instance = new DAOAuftragsposition();
//        instance.loescheNeueAuftragsposition(auftragskopf_id, positionsnummer);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of gibAllePositionen method, of class DAOAuftragsposition.
//     */
//    @Test
//    public void testGibAllePositionen() throws Exception {
//        System.out.println("gibAllePositionen");
//        String auftragskopf_id = "";
//        DAOAuftragsposition instance = new DAOAuftragsposition();
//        ArrayList<Auftragsposition> expResult = null;
//        ArrayList<Auftragsposition> result = instance.gibAllePositionen(auftragskopf_id);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of gibEineAuftragsposition method, of class DAOAuftragsposition.
//     */
//    @Test
//    public void testGibEineAuftragsposition() throws Exception {
//        System.out.println("gibEineAuftragsposition");
//        String id = "";
//        String positionsnummer = "";
//        DAOAuftragsposition instance = new DAOAuftragsposition();
//        Auftragsposition expResult = null;
//        Auftragsposition result = instance.gibEineAuftragsposition(id, positionsnummer);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of bearbeiteAuftrag method, of class DAOAuftragsposition.
//     */
    @Test
    public void testBearbeiteAuftrag() throws Exception {
        Auftragsposition ap = new Auftragsposition("345", 4, 6, 6, "66");
        
        Dap.bearbeiteAuftrag("1",3, ap);
        assertEquals("1", ap.getAuftragskopfId());
    }
    
}
