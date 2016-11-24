/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

/**
 *
 * @author Martin Lipinski 
 */
public class Zusatzfunktionen {

    public Zusatzfunktionen(){
        
    }
    
    public String gebeTimestamp(){
        java.util.Date date = new java.util.Date();
        java.text.SimpleDateFormat dateformat = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String currentTime = dateformat.format(date);
        return currentTime;
    }
}
