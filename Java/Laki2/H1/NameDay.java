/* TIEP5.1 Lausekielinen ohjelmointi II
Harjoitus 1, tehtävä 3
Eveliina Toivanen (eveliina.toivanen@tuni.fi)
*/

import java.util.Scanner;
public class NameDay {
    public static void main(String[] args) {


        // 
        Scanner lukija = new Scanner(System.in);

        System.out.println("Hello! I read and print date information."); 
        System.out.println("Name of day:"); 
        String paivaNimi = lukija.nextLine();


        // Käytetään Scanner-luokan metodeja syötteiden lukuun.
        // Metodit palauttavat syötteen paluuarvonaan. Parametreja ei ole.


        System.out.println("Day:");
        int paivaNumero = lukija.nextInt();
        
        System.out.println("Month:");
        int kuukausi = lukija.nextInt();
        
        System.out.println("Year:");
        int vuosi = lukija.nextInt();
        
        System.out.println("Given names of day:");
        lukija.nextLine();
        String nimet = lukija.nextLine();
        
        System.out.println(paivaNimi + " " + paivaNumero + "." + kuukausi + "." + vuosi + " " + nimet);
    }
}