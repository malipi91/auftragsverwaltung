package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import util.DBConnection;

/*----------------------------------------------------------*/
/* Datum Name Was                                           */
/* 17.11.16 MaLi Anlegen der Klasse                         */
/* 19.11.16 HiYö Erweitern der Klasse.                      */
/* 21.11.16 MaLi Erweitern der Klasse                       */
/*----------------------------------------------------------*/
/**
 * Diese Klasse dient dem Zugriff auf die Tabelle DataDictionary aus der Daten-
 * bank.
 * @author Martin Lipinski 
 */
public class DAODataDictionary {
    
    // Speichert die Datensatz ID des Datensatzes LastID_Adr im DD.
    private final String LETZE_ADRESS_ID;
    
    // Speichert die Datensatz ID des Datensatze LastID_Auf im DD.
    private final String LETZTE_AUFTRAG_ID;
    
    // Speichert die Datensatz ID des Datensatzes LastID_ZK im DD.
    private final String LETZTE_ZK_ID;

    // Speichert die Datensatz ID des Datensatzes LastID_Art im DD.
    private final String LETZTE_ARTIKEL_ID;
    
    // Speichert die Datensatz ID des Datensatzes LastID_GP im DD.
    private final String LETZTE_GP_ID;
    
    // Speichert die Datensatz ID des Datensatzes LastID_GP im DD.
    private final String LETZTE_KUNDE_ID;
    
    // Speichert die Datensatz ID des Datensatzes LastID_GP im DD.
    private final String LETZTE_LIEFERANT_ID;
    
   // Speichert die Datensatz ID des Datensatzes LASTID_AP im DD. Citak 30.11.2016
    private final String LETZTE_AUFTRAGSPOSITION_ID;
    
    /*----------------------------------------------------------*/
    /* Datum Name Was                                           */
    /* 17.11.16 MaLi Anlegen des Konstruktors.                  */
    /* 19.11.16 HiYö Erweitern des Konstruktors.                */
    /* 21.11.16 MaLI Erweitern des Konstruktors.                */
    /*----------------------------------------------------------*/
    /**
     * Konstruktor der ein Objekt des DAODataDictionary erzeugt. 
     */
    public DAODataDictionary() {
        // Übergabe der Datensatz ID LastID_Adr.
        this.LETZE_ADRESS_ID = "1";
        // Übergabe der Datensatz ID LastID_Auf. Angelegt durch Fr. Yörük.
        this.LETZTE_AUFTRAG_ID = "2"; 
        // Übergabe der Datensatz ID LastID_ZK.
        this.LETZTE_ZK_ID = "3";
        // Übergabe der Datensatz ID LastID_Art.
        this.LETZTE_ARTIKEL_ID = "4";
        // Übergabe der Datensatz ID LastID_GP.
        this.LETZTE_GP_ID = "5";
        // Übergabe der Datensatz ID LastID_KD.
        this.LETZTE_LIEFERANT_ID = "6";
        // Übergabe der Datensatz ID LastID_LF.
        this.LETZTE_KUNDE_ID = "7";
       // Übergabe der Datensatz ID LASTID_AP.
        this.LETZTE_AUFTRAGSPOSITION_ID = "8";
        
    }
    
    /*----------------------------------------------------------*/
    /* Datum Name Was                                           */
    /* 17.11.16 MaLi Anlegen der Methode                        */
    /* 19.11.16 HiYö Erweitern der Methode bekommeLetzteID.     */
    /* 21.11.16 MaLI Erweitern der Methode bekommeLetzteID.     */
    /*----------------------------------------------------------*/
    /**
     * Das DataDictionary speichert die letzten ID eines Datensatzes zu den 
     * Stamm- und Bewegungsdatentabellen in der DB. Diese Methode greift anhand
     * des Tabellennamens auf die entsprechende ID im Datensatz zu und liefert 
     * die letzte ID des Datensatzes.
     * @param tabelle Der Tabellenname wird zur Unterscheidung übergeben.
     * @return liefert die letzte ID eines Datensatzes.
     * @throws SQLException
     */
    public String bekommeLetzteID(String tabelle) throws SQLException{
        // Erzeugt ein neues Objekt der Klasse DBConnection. 
        DBConnection con = new DBConnection();
        // Übergabe der Connection an ein Objekt der Klasse Connection.
        Connection conn = con.createConection();
        // Erzeugen eines neuen Objekts der Klasse Statement.
        Statement stmt = conn.createStatement();
        // Erzeugen des ResultSets und Zuweisen des Null-Objekts.
        ResultSet rs = null;
        
        // Unvollständige SQL-Abfrage der letzten ID. 
        String sql = "select wert from datadictionary where";
        // Zeichenkette die aktuell leer ist und später die letzte ID enthält.
        String result = "";
        
        // Unterscheidung, ob es sich um die Adresstabelle handelt.
        if(tabelle.equals("adresse")){
            try{
                // Erweiterung der SQL-Abfrage, weil die letzte Adress ID 
                // benötigt wird.
                sql = sql + " dd_id = " + LETZE_ADRESS_ID;
                
                // Ausführen der SQL-Abfrage.
                rs = stmt.executeQuery(sql);
            }catch(SQLException e){
                // Ausgabe der Fehlermeldung.
                System.out.println("Statement nicht ausgeführt!");
            }     
        // Weitere Unterscheidung, ob es sich um die Auftragstabelle handelt.
        // Angelegt von Fr. Yörük.
        } else if(tabelle.equals("auftrag")){
            try{
                // Erweiterung der SQL-Abfrage, weil die letzte Auftrags ID 
                // benötigt wird.
                sql = sql + " dd_id = " + LETZTE_AUFTRAG_ID;
                
                // Ausführen der SQL-Abfrage.
                rs = stmt.executeQuery(sql);
            }catch(SQLException e){
                // Ausgabe der Fehlermeldung. 
                System.out.println("Statement nicht ausgeführt!");
            }
        // Weitere Unterscheidung, ob es sich um die Auftragstabelle handelt.
        // Angelegt von Hr. Lipinski.
        } else if(tabelle.equals("zahlungskondition")){
            try{
                // Erweiterung der SQL-Abfrage, weil die letzte Auftrags ID 
                // benötigt wird.
                sql = sql + " dd_id = " + LETZTE_ZK_ID;
                
                // Ausführen der SQL-Abfrage.
                rs = stmt.executeQuery(sql);
            }catch(SQLException e){
                // Ausgabe der Fehlermeldung. 
                System.out.println("Statement nicht ausgeführt!");
            }
        // Weitere Unterscheidung, ob es sich um die Auftragstabelle handelt.
        // Angelegt von Hr. Lipinski
        } else if(tabelle.equals("artikel")){
            try{
                // Erweiterung der SQL-Abfrage, weil die letzte Auftrags ID 
                // benötigt wird.
                sql = sql + " dd_id = " + LETZTE_ARTIKEL_ID;
                
                // Ausführen der SQL-Abfrage.
                rs = stmt.executeQuery(sql);
            }catch(SQLException e){
                // Ausgabe der Fehlermeldung. 
                System.out.println("Statement nicht ausgeführt!");
            }
        // Weitere Unterscheidung, ob es sich um die Auftragstabelle handelt.
        // Angelegt von Hr. Lipinski
        } else if(tabelle.equals("geschaeftspartner")){
            try{
                // Erweiterung der SQL-Abfrage, weil die letzte Auftrags ID 
                // benötigt wird.
                sql = sql + " dd_id = " + LETZTE_GP_ID;
                
                // Ausführen der SQL-Abfrage.
                rs = stmt.executeQuery(sql);
            }catch(SQLException e){
                // Ausgabe der Fehlermeldung. 
                System.out.println("Statement nicht ausgeführt!");
            }
            //Erweitert am 30.11.2016 Citak
        }else if(tabelle.equals("auftragsposition")){
            try{
                // Erweiterung der SQL-Abfrage, weil die letzte Auftrags ID 
                // benötigt wird.
                sql = sql + " dd_id = " + LETZTE_AUFTRAGSPOSITION_ID;
                // Ausführen der SQL-Abfrage.
                rs = stmt.executeQuery(sql);
            }catch(SQLException e){
                // Ausgabe der Fehlermeldung. 
                System.out.println("Statement nicht ausgeführt!");
            }
        // Weitere Unterscheidung, ob es sich um die Auftragstabelle handelt.
        // Angelegt von Hr. Lipinski
        } 
        // Schleife zur Ausgabe des ResultSets.
        while(rs.next()){
            // Speichern der abgefragten letzten ID.
            result = rs.getString("Wert");
        }
        // Ausgabe der letzten ID.
        return result;
    }
    
    /*----------------------------------------------------------*/
    /* Datum Name Was                                           */
    /* 17.11.16 MaLi Anlegen der Methode                        */
    /* 19.11.16 HiYö Erweitern der Methode bekommeLetzteID.     */
    /* 21.11.16 MaLI Erweitern der Methode bekommeLetzteID.     */
    /*----------------------------------------------------------*/
    /**
     * Erhöht die letzte ID und speichert den neuen Wert im DataDictionary.
     * @param tabelle erhält den Tabellenname zur Unterscheidung.
     * @throws SQLException
     */
    public void erhoeheLetzteID(String tabelle) throws SQLException{
        // Erzeugt ein neues Objekt der Klasse DBConnection. 
        DBConnection con = new DBConnection();
        // Speichert die SQL-Anweisung. Aktuell leer.
        String sql = "";
        // Übergabe der Connection an ein Objekt der Klasse Connection.
        Connection conn = con.createConection();
        // Erzeugen eines neuen Objekts der Klasse Statement.
        PreparedStatement stmt;
        
        if("adresse".equals(tabelle)){
            sql = "UPDATE datadictionary SET wert = ? WHERE dd_id = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, String.valueOf(this.inkrementiereLetzteID(this.bekommeLetzteID(tabelle))));
            stmt.setInt(2, 1);
            try{
                stmt.executeUpdate();
                conn.close();
            } catch (SQLException e){
                System.out.println(e);
                System.out.println("Objekt wurde nicht hinzugefügt.");
            }
            /*
            Hicran
            */
        } else if("auftrag".equals(tabelle)){
            sql = "UPDATE datadictionary SET wert = ? WHERE dd_id = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, String.valueOf(this.inkrementiereLetzteID(this.bekommeLetzteID(tabelle))));
            stmt.setInt(2, 2);
            try{
                stmt.executeUpdate();
                conn.close();
            } catch (SQLException e){
                System.out.println(e);
                System.out.println("Objekt wurde nicht hinzugefügt.");
            }
        } else if("zahlungskondition ".equals(tabelle)){
            sql = "UPDATE datadictionary SET wert = ? WHERE dd_id = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, String.valueOf(this.inkrementiereLetzteID(this.bekommeLetzteID(tabelle))));
            stmt.setInt(2, 3);
            try{
                stmt.executeUpdate();
                conn.close();
            } catch (SQLException e){
                System.out.println(e);
                System.out.println("Objekt wurde nicht hinzugefügt.");
            }
        } else if("artikel".equals(tabelle)){
            sql = "UPDATE datadictionary SET wert = ? WHERE dd_id = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, String.valueOf(this.inkrementiereLetzteID(this.bekommeLetzteID(tabelle))));
            stmt.setInt(2, 4);
            try{
                stmt.executeUpdate();
                conn.close();
            } catch (SQLException e){
                System.out.println(e);
                System.out.println("Objekt wurde nicht hinzugefügt.");
            }
        } else if("geschaeftspartner".equals(tabelle)){
            sql = "UPDATE datadictionary SET wert = ? WHERE dd_id = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, String.valueOf(this.inkrementiereLetzteID(this.bekommeLetzteID(tabelle))));
            stmt.setInt(2, 5);
            try{
                stmt.executeUpdate();
                conn.close();
            } catch (SQLException e){
                System.out.println(e);
                System.out.println("Objekt wurde nicht hinzugefügt.");
            }
            //Erweitert am 30.11.2016 Citak 
         } else if("auftragsposition".equals(tabelle)){
            sql = "UPDATE datadictionary SET wert = ? WHERE dd_id = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, String.valueOf(this.inkrementiereLetzteID(this.bekommeLetzteID(tabelle))));
            stmt.setInt(2, 6);
            try{
                stmt.executeUpdate();
                conn.close();
            } catch (SQLException e){
                System.out.println(e);
                System.out.println("Objekt wurde nicht hinzugefügt.");
            }
        }
    }
    
    
    /*----------------------------------------------------------*/
    /* Datum Name Was                                           */
    /* 17.11.16 MaLi Anlegen der Methode.                       */
    /*----------------------------------------------------------*/
    /**
     * Diese Methode inkrementiert eine übergebene ID. Da die ID als String 
     * übergeben wird, wird diese zunächst in einen INTEGER umgewandelt und 
     * anschließend hochgezählt. Die inkrementierte ID wird letztendlich 
     * ausgegeben.
     * @param id Eine ID als String.
     * @return die erhöhte ID ausgeben als String.
     */
    public int inkrementiereLetzteID(String id){
        // Wandele die String-ID in einen Integer um.
        int lID = Integer.parseInt(id);
        // Erhöhe um 1.
        lID = lID+ 1;
        // Gibt die erhöhte ID aus.
        return lID;
    }
}
