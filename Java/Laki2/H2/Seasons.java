/*
 * TIEP5.1 Lausekielinen ohjelmointi II
 * Harjoitus 2, tehtävä 1
 * Eveliina Toivanen (eveliina.toivanen@tuni.fi)
 * Ohjelma kysyy käyttäjältä syötteen ja katsoo sen mukaan, mikä on käyttäjän
 * lempivuodenaika.
*/

import java.util.Scanner;

public class Seasons{
    public static void main(String[] args) {
        
        Scanner lukija = new Scanner(System.in);
        
        System.out.println("Hello! I read and tell.");
        System.out.println("Which do you like most: 1) winter, 2) spring, 3) summer, 4) autumn?");
        int luku = lukija.nextInt();
        
        if (luku == 1) {
            System.out.println("Your favourite season of the year is winter.");
        }
        
        if (luku == 2) {
            System.out.println("Your favourite season of the year is spring.");
        }
        
        if (luku == 3) {
            System.out.println("Your favourite season of the year is summer.");
        }
        
        if (luku == 4) {
            System.out.println("Your favourite season of the year is autumn.");
        }
        
        else if (luku < 1 || luku > 4) {
            System.out.println("Your favourite season of the year is unknown.");
        }
    }
}