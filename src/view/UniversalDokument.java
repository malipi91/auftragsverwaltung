/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Toolkit;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

/*----------------------------------------------------------*/
/* Datum Name Was */
/* 25.11.16 Yoeruek angelegt */
/*----------------------------------------------------------*/
public class UniversalDokument extends PlainDocument {

        private int laenge;
        private String erlaubteZeichen;

        // Mechmet Impram
        public UniversalDokument(boolean sindBErlaubt, boolean sindZErlaubt, String zeichen, int laenge) {
            this.laenge = laenge;
            this.erlaubteZeichen = zeichen;
            if (sindBErlaubt) {
                this.erlaubteZeichen = this.erlaubteZeichen + "qwertzuiopÃ¼asdfghjklÃ¶Ã¤yxcvbnm" + "QWERTZUIOPÃœASDFGHJKLÃ–Ã„YXCVBNM";

            }
            if (sindZErlaubt) {
                this.erlaubteZeichen = this.erlaubteZeichen + "1234567890";
            }
        }

        // Mechmet Impram
        public void insertString(int off, String str, AttributeSet a)
                throws BadLocationException {
            boolean insertString;
            boolean founded = true;
            for (int i = 0; i < str.length() && founded; i++) {
                if (this.erlaubteZeichen.indexOf(str.charAt(i)) == -1) {
                    Toolkit.getDefaultToolkit().beep();
                    founded = false;
                }
            }
            insertString = founded;
            if (this.laenge != -1 && insertString && this.getLength() <= this.laenge) {
                super.insertString(off, str, a);
            } else if (insertString && laenge == -1) {
                super.insertString(off, str, a);
            } else {
                Toolkit.getDefaultToolkit().beep();
            }

        }
    }
