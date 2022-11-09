/* TIEP5.1 Lausekielinen ohjelmointi II
Harjoitus 1, tehtävä 7
Eveliina Toivanen (eveliina.toivanen@tuni.fi)
*/

import java.util.Scanner;

public class Congratulator{
    public static void main(String[] args) {
        
        Scanner lukija = new Scanner(System.in);
        
        System.out.println("Hello! I may congratulate you.");
        System.out.println("Please, enter your target:");
        int tavoite = lukija.nextInt();
        
        System.out.println("Please, enter your achievement:");
        int tulos = lukija.nextInt();
        
        if (tavoite <= tulos) {
            System.out.println("You made it! Congratulations!");
        }
    }
}
