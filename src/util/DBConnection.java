/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*----------------------------------------------------------*/
/* Datum Name Was */
/* 13.11.16 MaLi Anlegen der Klasse */
/*----------------------------------------------------------*/
/** Dies Klasse stellt Methoden zur Verwaltung der Datenbankverbindung bereit.
 *
 * @author Martin Lipinski
 */
public class DBConnection {
    
    // Initialisieren der Variablen
    private Connection con;
    // Port über den die Datenbank erreichbar ist
    private final String dbPort;
    // Datenbank auf dem MySQL-Server
    private final String database;
    // User der Datenbank 
    private final String dbUser;
    // Passwort des Users
    private final String dbPassword;
    // Host-Url der Datenbank
    private final String dbHost;
    
    /*----------------------------------------------------------*/
    /* Datum Name Was */
    /* 10.11.16 MaLi anlegen der Methode */
    /*----------------------------------------------------------*/    
    /**
     * Konstruktor zur Erzeugung eines DBConnection - Objekts. Der Konstruktor
     * initialisiert eine Datenbankverbindung.
     */
    public DBConnection(){
        this.con = null;
        this.dbPort = "3306";
        this.dbHost = "127.0.0.1";
        this.dbUser = "auftragsuser";
        this.dbPassword = "be54am";
        this.database = "auftragsverwaltung";
    }
    
    /*----------------------------------------------------------*/
    /* Datum Name Was */
    /* 10.11.16 MaLi anlegen der Methode */
    /*----------------------------------------------------------*/
    /**
    * Diese Methode dient dem Aufbau der Connection der Java-Anwendung zu der 
    * Datenbank. Aktuell befindet sich die Datenbank lokal.
    * @return Rückgabewerte ist eine bestehende Connection vom Typ Connection.
    * @throws SQLException wirft eine Fehlermeldung, wenn kein Connection auf
    * gebaut werden kann.
    */
    public Connection createConection() throws SQLException{
        
        try{
            
            // Anweisung läd den hinterlegten MySQL-DB Treiber
            Class.forName("com.mysql.jdbc.Driver");
            
            // Stellt die Verbindung zur DB über den URL-String her.
            con = DriverManager.getConnection("jdbc:mysql://"+ this.dbHost + ":" 
                    + this.dbPort +"/" + this.database +"?useSSL=false", 
                    this.dbUser, this.dbPassword);     
            
        } catch (ClassNotFoundException e) {
            
            // Wirft eine Fehlermeldung, wenn Treiber nicht gefunden wird.
            System.out.println("Treiber nicht gefunden");
        } catch (SQLException e){
            
            // Wirft eine Fehlermeldung, wenn die Verbindung nicht möglich ist.
            System.out.println("Verbindungsaufbau nicht möglich");
        }
        
        // Gibt die Connection zurück.
        return con;
    }
    
    
}