package model;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;


 
public class AuftragModelTest{
  

   @Test
   public void getAuftragsID(){
        Auftrag testerAuftrag = new Auftrag("111", "testerAuftrag1", "28.11.2016", 
            "29.12.2016", "bar", 453, "f", "31.12.2016");
            assertEquals("111", testerAuftrag.getAuftrags_ID());
   }
   
   @Test
   public void setAuftragsID(){
          Auftrag testerAuftrag = new Auftrag("111", "testerAuftrag1", "28.11.2016", 
            "29.12.2016", "bar", 453, "f", "31.12.2016");
          testerAuftrag.setAuftrags_ID("444");
            assertEquals("444", testerAuftrag.getAuftrags_ID());
   }
   @Test
   public void getAuftragsText(){
          Auftrag testerAuftrag = new Auftrag("111", "testerAuftrag1", "28.11.2016", 
            "29.12.2016", "bar", 453, "f", "31.12.2016");
            assertEquals("testerAuftrag1", testerAuftrag.getAuftragstext());
   }
   
   @Test
   public void setAuftragsText(){
          Auftrag testerAuftrag = new Auftrag("111", "testerAuftrag1", "28.11.2016", 
            "29.12.2016", "bar", 453, "f", "31.12.2016");
            testerAuftrag.setAuftragstext("Set Auftragstext.");
            assertEquals("Set Auftragstext.", testerAuftrag.getAuftragstext());
   }
  @Test
   public void getErfassungsdatum(){
          Auftrag testerAuftrag = new Auftrag("111", "testerAuftrag1", "28.11.2016", 
            "29.12.2016", "bar", 453, "f", "31.12.2016");
            assertEquals("28.11.2016", testerAuftrag.getErfassungsdatum());
   }
  
 @Test  
   public void setErfassungsdatum(){
          Auftrag testerAuftrag = new Auftrag("111", "testerAuftrag1", "28.11.2016", 
            "29.12.2016", "bar", 453, "f", "31.12.2016");
            testerAuftrag.setErfassungsdatum("01.01.2016");
            assertEquals("01.01.2016", testerAuftrag.getErfassungsdatum());
   }
   @Test
   public void getLieferdatum(){
          Auftrag testerAuftrag = new Auftrag("111", "testerAuftrag1", "28.11.2016", 
            "29.12.2016", "bar", 453, "f", "31.12.2016");
             assertEquals("29.12.2016",testerAuftrag.getLieferdatum());
   }
   @Test
   public void setLieferdatum(){
          Auftrag testerAuftrag = new Auftrag("111", "testerAuftrag1", "28.11.2016", 
            "29.12.2016", "bar", 453, "f", "31.12.2016");
            testerAuftrag.setLieferdatum("29.12.2016");
            assertEquals("29.12.2016",testerAuftrag.getLieferdatum());
   }
   
  @Test
   public void getAuftragsart(){
          Auftrag testerAuftrag = new Auftrag("111", "testerAuftrag1", "28.11.2016", 
            "29.12.2016", "bar", 453, "f", "31.12.2016");
            assertEquals("bar",testerAuftrag.getAuftragsart());
   }
   
  @Test
   public void setAuftragsart(){
          Auftrag testerAuftrag = new Auftrag("111", "testerAuftrag1", "28.11.2016", 
            "29.12.2016", "bar", 453, "f", "31.12.2016");
            testerAuftrag.setAuftragsart("rechnung");
            assertEquals("rechnung",testerAuftrag.getAuftragsart());
   }
    
   @Test
   public void getStatus(){
          Auftrag testerAuftrag = new Auftrag("111", "testerAuftrag1", "28.11.2016", 
            "29.12.2016", "bar", 453, "f", "31.12.2016");
            assertEquals("f",testerAuftrag.getStatus());
   }
   @Test
   public void setStatus(){
          Auftrag testerAuftrag = new Auftrag("111", "testerAuftrag1", "28.11.2016", 
            "29.12.2016", "bar", 453, "f", "31.12.2016");
             testerAuftrag.setStatus("a");
            assertEquals("a",testerAuftrag.getStatus());
   }
   @Test
   public void getAbschlussdatum(){
          Auftrag testerAuftrag = new Auftrag("111", "testerAuftrag1", "28.11.2016", 
            "29.12.2016", "bar", 453, "f", "31.12.2016");
            assertEquals("31.12.2016",testerAuftrag.getAbschlussdatum());
   }
   @Test
   public void setAbschlussdatum(){
          Auftrag testerAuftrag = new Auftrag("111", "testerAuftrag1", "28.11.2016", 
            "29.12.2016", "bar", 453, "f", "31.12.2016");
            testerAuftrag.setAbschlussdatum("01.01.2017");
            assertEquals("01.01.2017",testerAuftrag.getAbschlussdatum());
   }
//   @Test
//   public void getGeschaeftspartner(){
//          Adresse whsA = new Adresse("45968", "Heringstr", 45968,"24","GLA","DE", "31.12.9999","LIA");
//          Geschaeftspartner whs = new Geschaeftspartner(4343, "Kunde", 500000, "Whs",
//          whsA, "0209", "02091", "whs@whs.de", "01.01.2011", "");
//          Auftrag testerAuftrag = new Auftrag("111", "testerAuftrag1", "28.11.2016", 
//          "29.12.2016", "bar", 453, "f", "31.12.2016");
//          testerAuftrag.setGeschaeftspartner(whs);
//          assertEquals("Whs",whs.getName());
//          assertEquals("Whs",testerAuftrag.sucheKunde());
//       }
   
   
   
}
      











    

