/* TIEP5.1 Lausekielinen ohjelmointi II
 * Harjoitus 2, tehtävä 3
 * Eveliina Toivanen (eveliina.toivanen@tuni.fi)
 *
 * Ohjelma kysyy käyttäjältä kolme lukua ja kertoo, mikä niistä on keskimmäinen.
*/

import java.util.Scanner;

public class MiddleNumber{
    public static void main(String[] args) {
        
        Scanner lukija = new Scanner(System.in);
        
        System.out.println("Hello! I determine the number in the middle.");
        
        System.out.println("Please, enter the first number:");
        int eka = lukija.nextInt();
        System.out.println("Please, enter the second number:");
        int toka = lukija.nextInt();
        System.out.println("Please, enter the third number:");
        int kolmas = lukija.nextInt();
        
        if (eka == toka){
            System.out.println("The number in middle is " + toka + ".");
        }
        
        else if (eka == kolmas){
            System.out.println("The number in middle is " + kolmas + ".");
        }
        
        else if (toka == kolmas) {
            System.out.println("The number in middle is " + kolmas + ".");
        }
        
        else if (toka > eka && eka > kolmas || kolmas > eka && eka > toka) {
            System.out.println("The number in middle is " + eka + ".");
        }
        
        else if (eka > toka && toka > kolmas || kolmas > toka && toka > eka) {
            System.out.println("The number in middle is " + toka + ".");
        }
        
        else if (eka > kolmas && kolmas > toka || toka > kolmas && kolmas > eka) {
            System.out.println("The number in middle is " + kolmas + ".");
        }
        
        
    }
}