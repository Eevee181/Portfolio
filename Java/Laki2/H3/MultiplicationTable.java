/* TIEP5.1 Lausekielinen ohjelmointi II
 * Harjoitus 3, tehtävä 3
 * Eveliina Toivanen (eveliina.toivanen@tuni.fi)
 *
 * Kysytään käyttäjältä luku ja lasketaan luvun kymmenen kertotaulu.
 */
 
import java.util.Scanner;
 
public class MultiplicationTable {
    
    /* Lasketaan kymmenen kertotaulu parametrin luvusta.
     * kertoja: Luku, jonka kertotaulu tulostetaan.
     */
    public static void tulostaKertotaulu(int kertoja){
        int lkm = 10;
        int i = 1;
         
        while (i <= lkm) {
            
            // Tehdään kertolasku ja tulostetaan se.
            int tulo = i * kertoja;
            System.out.print(i + " x " + kertoja + " = " + tulo + '\n');
            
            // Kasvatetaan laskuria
            i = i + 1;
        }
    }
     
    public static void main(String[] args){
         
        Scanner lukija = new Scanner(System.in);
         
        System.out.println("Hello! I print a multiplication table.");
        System.out.println("Please, enter an integer:");
        int kertoja = lukija.nextInt();
         
        tulostaKertotaulu(kertoja);
    }
}
 