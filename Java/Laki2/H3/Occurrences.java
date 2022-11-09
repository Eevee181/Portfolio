/* TIEP5.1 Lausekielinen ohjelmointi II
 * Harjoitus 3, tehtävä 6
 * Eveliina Toivanen (eveliina.toivanen@tuni.fi)
 *
 * Ohjelma kysyy käyttäjältä kaksi merkkijonoa ja tarkastaa, löytyykö ensimmäisen
 * merkkijonon merkeistä löytyy toisesta merkkijonosta.
 */

import java.util.Scanner;
import java.util.Arrays;

public class Occurrences{
    
    /* Metodi tarkastaa aputaulujen avulla, montako ensimmäisen merkkijonon merkkiä
     * löytyy toisesta merkkijonosta.
     * jono1: Ensimmäinen käyttäjän antama merkkijono
     * jono2: Toinen käyttäjän antama merkkijono
     */
    public static int laskeEsiintymät(String jono1,String jono2){
        int loytynyt = 0;
        
        int l = jono1.length();
        int k = jono2.length();
        
        // Muunnetaan merkkijonot tauluiksi.
        char merkit1[] = new char[l];
        char merkit2[] = new char[k];
        
        for (int i = 0; i < l; i++){
            merkit1[i] = jono1.charAt(i);
        }
        for (int i = 0; i < k; i++){
            merkit2[i] = jono2.charAt(i);
        }
        
        // Tarkastetaan luupeilla, löytyykö merkkipareja.
        for (int i = 0; i < l; i++){
           for (int j = 0; j < k; j++) {
               if (merkit1[i] == merkit2[j]){
                   loytynyt = loytynyt + 1;
                   break;
               }
           }
        }
        
        return loytynyt;
        
    }
    
    public static void main(String[] args){
        Scanner lukija = new Scanner(System.in);
        
        System.out.println("Hello! I count character occurrences between strings.");
        System.out.println("Enter the first string:");
        String jono1 = lukija.nextLine();
        System.out.println("Enter the second string:");
        String jono2 = lukija.nextLine();
        
        int esiintyminen = laskeEsiintymät(jono1, jono2);
        
        System.out.println("The number of occurrences is " + esiintyminen + ".");
    }
}

