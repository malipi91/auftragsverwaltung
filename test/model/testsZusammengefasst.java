/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;


/**
 *
 * @author samet
 */

    
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;;

@RunWith(Suite.class)
@SuiteClasses({AuftragModelTest.class,AuftragspositionTest.class, 
AuftragsstatusTest.class, ZahlungskonditionTest.class, dao.DAOAuftragTest.class })
public class testsZusammengefasst {
// hier stehen keine Tests !
}
  

