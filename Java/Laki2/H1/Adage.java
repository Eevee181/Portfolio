/* TIEP5.1 Lausekielinen ohjelmointi II
Harjoitus 1, tehtävä 1
Eveliina Toivanen (eveliina.toivanen@tuni.fi)
*/

import java.util.Scanner;
public class Adage {
    public static void main(String[] args) {
        
        System.out.println("Hello! I read and pretty print your thoughts."); 
        System.out.println("Please, say something:"); 
        
        // 
        Scanner lukija = new Scanner(System.in);
        
        // Käytetään Scanner-luokan metodeja syötteiden lukuun.
        // Metodit palauttavat syötteen paluuarvonaan. Parametreja ei ole.
        String rivi = lukija.nextLine();
        
        System.out.println("<< " + rivi + " >>"); 
    }
}