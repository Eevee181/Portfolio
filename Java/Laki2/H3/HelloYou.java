/* TIEP5.1 Lausekielinen ohjelmointi II
 * Harjoitus 3, tehtävä 1
 * Eveliina Toivanen (eveliina.toivanen@tuni.fi)
 *
 * Pyydetään käyttäjältä nimi ja tulostetaan tervehdys, jossa nimi on sisällytettynä.
 */
 
import java.util.Scanner;

public class HelloYou {
    
    /* Tulostetaan tervehdys käyttäjän syöttämän nimen kanssa.
     * nimi: Käyttäjän antama nimi
     */
    public static void moikkaa(String nimi) {
        System.out.println("Hello, " + nimi + "!");
    }
    
    public static void main(String[] args){
        Scanner lukija = new Scanner(System.in);
        
        System.out.println("Hello! I shall say hello to you.");
        System.out.println("Please, enter your name:");
        String nimi = lukija.nextLine();
        
        moikkaa(nimi);
    }
}

