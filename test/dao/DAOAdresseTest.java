/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

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
        Adresse whs = new Adresse("1","Neidenburer",45899,"43","GE","DE","31.12.9999","Kunde");
        Adresse adresse = null;
        DAOAdresse instance = new DAOAdresse();
        instance.legeNeueAdresseAn(adresse);
        
        
        
        
    }
    
}
