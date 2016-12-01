/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.SQLException;
import model.Adresse;
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
public class DAOAdresseTest {
    
    public DAOAdresseTest() {
    }
    
    DAOAdresse Ad;
    
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
     * Test of legeNeueAdresseAn method, of class DAOAdresse.
     */
    @Test
    public void testLegeNeueAdresseAn() throws Exception {
        Adresse adresseTest = new Adresse("332", "Hering", "25", 45968, "Gladbeck", "DE", "1480600612165");       
        Ad = new DAOAdresse();
        Ad.legeNeueAdresseAn(adresseTest);
        assertEquals(45968, adresseTest.gibPLZ());
        
    }
    
}
