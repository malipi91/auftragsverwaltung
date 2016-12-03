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
   String letzteID = "143";
    @Before
    public void setUp() throws SQLException {
        
        
        da = new DAOAuftrag();
        String datumm = "2016-11-20";
    }
    
    
    @Test
    public void testErhalteAuftragFuerID() throws Exception {
        Auftrag ergebnis =  da.erhalteAuftragFuerID("98");
        assertEquals("98", ergebnis.getAuftrags_ID());
        
    }
    
    @Test 
    public void testLegeNeuenAuftragAn() throws SQLException{
        Auftrag auftrag = new Auftrag(letzteID,"test", "2016.12.16", "2016.12.16", "bar", 435544,"f", "2016.12.16");     
        da.legeNeueAuftragAn(auftrag);
        assertEquals(letzteID,da.erhalteAuftragFuerID(letzteID).getAuftrags_ID());
    }
    
    
    @Test
    public void testLöscheAuftrag() throws SQLException{
        
        da.loescheAuftrag(letzteID);
        assertEquals(da.erhalteLKZAuftragFuerID(letzteID).getLKZ(),"w");
        
    }
    
    @Test
    public void testBearbeiteAuftrag() throws SQLException{
      
      Auftrag auftrag2 = new Auftrag("140","test", "2016.12.16", "2016.12.16", "bar", 1,"f","2016.12.16");     
      da.bearbeiteAuftrag("140", auftrag2);
      assertEquals(1, da.erhalteAuftragFuerID("140").getAuftragswert());
    }
    
}