/* TIEP5.1 Lausekielinen ohjelmointi II
Harjoitus 1, tehtävä 4
Eveliina Toivanen (eveliina.toivanen@tuni.fi)
*/

import java.util.Scanner;
public class Arithmetics {
    public static void main(String[] args) {
        
        
        // 
        Scanner lukija = new Scanner(System.in);

        System.out.println("Hello! I do some basic arithmetic."); 
        System.out.println("Please, enter the first integer:"); 
        int ekaLuku = lukija.nextInt();

        System.out.println("Please, enter the second integer:"); 
        int tokaLuku = lukija.nextInt();
        
        // Käytetään Scanner-luokan metodeja syötteiden lukuun.
        // Metodit palauttavat syötteen paluuarvonaan. Parametreja ei ole.
        
        int plus = ekaLuku + tokaLuku;
        
        int minus = ekaLuku - tokaLuku;
        
        int kertaus = ekaLuku * tokaLuku;
        
        double jako = (double)ekaLuku / tokaLuku;
        
        int jaannos = ekaLuku % tokaLuku;
        
        System.out.println(ekaLuku + " + " + tokaLuku + " = " + plus);
        System.out.println(ekaLuku + " - " + tokaLuku + " = " + minus);
        System.out.println(ekaLuku + " * " + tokaLuku + " = " + kertaus);
        System.out.printf("%d / %d = %.2f%n", ekaLuku, tokaLuku, jako);
        System.out.println(ekaLuku + " % " + tokaLuku + " = " + jaannos);
        
    }
}