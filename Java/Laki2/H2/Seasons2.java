/* 
 * TIEP5.1 Lausekielinen ohjelmointi II
 * Harjoitus 2, tehtävä 2
 * Eveliina Toivanen (eveliina.toivanen@tuni.fi)
 *
 * Ohjelma kysyy käyttäjältä syötettä ja tutkii sen perusteella,
 * mikä on käyttäjän lempivuodenaika. 
*/

import java.util.Scanner;

public class Seasons2{
    public static void main(String[] args) {
        
        Scanner lukija = new Scanner(System.in);
        
        System.out.println("Hello! I read and tell.");
        System.out.println("Which do you like most: 1) winter, 2) spring, 3) summer, 4) autumn?");
        int arvo = lukija.nextInt();
        
        switch (arvo) {
            case 1:
                System.out.println("Your favourite season of the year is winter.");
                break;
            case 2:
                System.out.println("Your favourite season of the year is spring.");
                break;
            case 3:
                System.out.println("Your favourite season of the year is summer.");
                break;
            case 4:
                System.out.println("Your favourite season of the year is autumn.");
                break;
            default:
                System.out.println("Your favourite season of the year is unknown.");
                break;
        }
        
    }
}