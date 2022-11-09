/* TIEP5.1 Lausekielinen ohjelmointi II
 * Harjoitus 2, tehtävä 4
 * Eveliina Toivanen (eveliina.toivanen@tuni.fi)
 *
 * Ohjelma kysyy käyttäjältä luvun ja tulostaa sen mukaisen kertotaulun.
*/

import java.util.Scanner;

public class MultiplicationTable{
    public static void main(String[] args) {
        
        Scanner lukija = new Scanner(System.in);
        
        int lkm = 10;
        int i = 1;
        
        System.out.println("Hello! I print a multiplication table.");
        System.out.println("Please, enter an integer:");
        int kerrottava = lukija.nextInt();
        
        while (i <= lkm) {
            
            // Tehdään kertolasku ja tulostetaan se.
            int tulo = i * kerrottava;
            System.out.print(i + " x " + kerrottava + " = " + tulo + '\n');
            
            // Kasvatetaan laskuria
            i = i + 1;
        }
    }
}   