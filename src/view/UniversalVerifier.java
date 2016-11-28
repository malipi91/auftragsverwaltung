/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/*----------------------------------------------------------*/
/* Datum Name Was */
/* 25.11.16 Yoeruek angelegt */
/*----------------------------------------------------------*/
public class UniversalVerifier extends InputVerifier {

        private String regEx;
        private String titel;
        private String text;

        //Mechmet Impram
        public UniversalVerifier(String regEx, String Titel, String text) {
            this.regEx = regEx;
            this.text = text;
            this.titel = titel;
        }
//Mechmet Impram
        public boolean verify(JComponent input) {
            boolean istGueltig = false;
            if (((JTextField) (input)).getText().matches(regEx)
                    || ((JTextField) input).getText().equals("")) {
                istGueltig = true;
            }
            return istGueltig;
        }

        // Mechmet Impram
        public boolean shouldYieldFocus(JComponent input) {
            boolean yieldFocus = false;
            if (verify(input)) {
                yieldFocus = true;
            } else {
                JOptionPane.showMessageDialog(null, text, titel, JOptionPane.WARNING_MESSAGE);
                ((JTextField) (input)).selectAll();
            }
            return yieldFocus;
        }

    }
