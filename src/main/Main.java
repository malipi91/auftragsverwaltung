/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import controller.Controller;

/**
 *
 * @author Duygu Citak
 */
public class Main {
    
    static Controller controller;

    /**
     * Diese Klasse wird nur dazu benutzt alle nötigen
     * Komponenten zu Initialisieren und die erste
     * View anzuzeigen
     */
    public static void main(String [] args){
        controller = new Controller();

}
}
