/* TIEP5.1 Lausekielinen ohjelmointi II
Harjoitus 1, tehtävä 5
Eveliina Toivanen (eveliina.toivanen@tuni.fi)
*/

import java.util.Scanner;
public class StringLengthComparator {
    public static void main(String[] args) {
        
        
        // 
        Scanner lukija = new Scanner(System.in);
        
        System.out.println("Hello! I compare the lengths of two strings."); 
        System.out.println("Please, enter the first string:"); 
        String ekaRivi = lukija.nextLine();
        
        System.out.println("Please, enter the second string:"); 
        String tokaRivi = lukija.nextLine();
        
        int ekaRiviPituus = ekaRivi.length();
        int tokaRiviPituus = tokaRivi.length();
        
        if (ekaRiviPituus > tokaRiviPituus) {
            System.out.println("\"" + ekaRivi + "\"" + " is longer than " 
                               + "\"" + tokaRivi + "\"" + ".");
        }

        if (ekaRiviPituus == tokaRiviPituus) {
            System.out.println("\"" + ekaRivi + "\"" + " is as long as " 
                               + "\"" + tokaRivi + "\"" + ".");
        }

        if (ekaRiviPituus < tokaRiviPituus) {
            System.out.println("\"" + ekaRivi + "\"" + " is shorter than " 
                               + "\"" + tokaRivi + "\"" + ".");
        
        }
    }
}