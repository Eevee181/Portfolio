/* TIEP5.1 Lausekielinen ohjelmointi II
 * Harjoitus 3, tehtävä 4
 * Eveliina Toivanen (eveliina.toivanen@tuni.fi)
 *
 * Päätellään käyttäjän syöttämistä kolmesta luvusta keskimmäinen.
 */
 
import java.util.Scanner;
 
public class MiddleNumber{
    
    /* Vertaillaan, mikä kolmesta parametristä on keskimmäinen.
     * luku1: ensimmäinen käyttäjän syöttämä luku.
     * luku2: toinen käyttäjän syöttämä luku.
     * luku3: kolmas käyttäjän syöttämä luku.
     */
    public static int annaKeskimmäinen(int luku1, int luku2, int luku3){
        // Alustetaan apumuuttuja ensimmäisen parametrin arvolla.
        int keskimmäinen = luku1;
        
        if (luku1 == luku2){
           keskimmäinen = luku1;
        }
        
        else if (luku1 == luku3){
            keskimmäinen = luku1;
        }
        
        else if (luku2 == luku3) {
            keskimmäinen = luku2;
        }
        
        else if (luku2 > luku1 && luku1 > luku3 || luku3 > luku1 && luku1 > luku2) {
            keskimmäinen = luku1;
        }
        
        else if (luku1 > luku2 && luku2 > luku3 || luku3 > luku2 && luku2 > luku1) {
            keskimmäinen = luku2;
        }
        
        else if (luku1 > luku3 && luku3 > luku2 || luku2 > luku3 && luku3 > luku1) {
            keskimmäinen = luku3;
        }
        
        // Palautetaan apumuuttujan arvo.
        return keskimmäinen;
    }
     
    public static void main(String[] args){
         
        Scanner lukija = new Scanner(System.in);
        
        System.out.println("Hello! I determine the number in the middle.");
        
        System.out.println("Please, enter the first number:");
        int eka = lukija.nextInt();
        System.out.println("Please, enter the second number:");
        int toka = lukija.nextInt();
        System.out.println("Please, enter the third number:");
        int kolmas = lukija.nextInt();
        
        int keskimmäinen = annaKeskimmäinen(eka, toka, kolmas);
        
        System.out.println("The number in middle is " + keskimmäinen + ".");
    }
}