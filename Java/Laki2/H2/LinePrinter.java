/* TIEP5.1 Lausekielinen ohjelmointi II
 * Harjoitus 2, tehtävä 5
 * Eveliina Toivanen (eveliina.toivanen@tuni.fi)
 *
 * Ohjelma kysyy käyttäjältä merkin ja kuinka monta kertaa tämä haluaa tulostaa
 * merkin peräjälkeen ja toimii sen mukaan.
*/

import java.util.Scanner;

public class LinePrinter{
    public static void main(String[] args) {
        
        Scanner lukija = new Scanner(System.in);
        boolean jatketaan = true;
        
        System.out.println("Hello! I print lines.");
        
        do {
            System.out.println("Please, enter character:");
            String merkki = lukija.nextLine();
            System.out.println("Please, enter length:");
            int lkm = lukija.nextInt();
        
            if (lkm > 0) {
                int i = 1;
                String merkkiJono = new String();
                
                while (i <= lkm) {
                    // Lisätään yksi merkki lisää merkkijonoon.
                    merkkiJono += merkki;
                
                    // kasvatetaan laskuria
                    i = i + 1;
                }
        
                System.out.println(merkkiJono);
            }
            
            if (lkm <= 0){
                jatketaan = false;
            }
           
        }
        
        while (jatketaan);
    }
}