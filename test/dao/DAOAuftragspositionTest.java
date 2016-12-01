/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.SQLException;
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
    
    

    /**
     * Test of legeNeueAuftragspositionAn method, of class DAOAuftragsposition.
     */
    @Test
    public void testLegeNeueAuftragspositionAn() throws Exception {
         Auftragsposition ap = new Auftragsposition("345", 4, 6, 6, "66");
        Dap = new DAOAuftragsposition();
       
        Dap.legeNeueAuftragspositionAn(ap);
        assertEquals(66,77);
    }
    
}
