/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author User
 */
public class Auftragsstatus {
    
    private final String ERFASST = "e";
    private final String FREIGEGEBEN = "f";
    private final String ABGESCHLOSSEN = "a";
    
    public Auftragsstatus(){
        
    }
    
    public String ueberfuehreAuftragsStatus(String status){
        if(status.equals("Abgeschlossen")){
            return ABGESCHLOSSEN;
        } else if(status.equals("Freigegeben")){
            return FREIGEGEBEN;
        } else if(status.equals("Erfasst")){
            return ERFASST;
        } else{
            return "FAIL";
        }
    }
}
