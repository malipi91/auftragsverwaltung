/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import model.Auftrag;
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
public class DAOAuftragTest {
    
   DAOAuftrag da;
    
    @Before
    public void setUp() throws SQLException {
        Auftrag auftrag = new Auftrag("99999","test", "1480600612165", "1480600612165", "bar", 100,"f", "1480600612165");
        
        da = new DAOAuftrag();
        da.legeNeueAuftragAn(auftrag);
    }
    
    
    @Test
    public void testErhalteAuftragFuerID() throws Exception {
        Auftrag ergebnis =  da.erhalteAuftragFuerID("8");
        assertEquals("8", ergebnis.getAuftrags_ID());
        
    }
    
    @Test 
    public void testLegeNeuenAuftragAn() throws SQLException{
        Auftrag auftrag2 = new Auftrag("99999","test", "1480600612165", "1480600612165", "bar", 100,"f", "1480600612165");
        da.legeNeueAuftragAn(auftrag2);
        assertEquals("9",da.erhalteAuftragFuerID("9").getAuftrags_ID());
    }
    
//    @Test
//    public void testGibAlleAuftraege() throws SQLException{
//        assertEquals(9, da.gibAlleAuftraege(5).get(3));          
//    }
//    
}