/* TIEP5.1 Lausekielinen ohjelmointi II
Harjoitus 1, tehtävä 8
Eveliina Toivanen (eveliina.toivanen@tuni.fi)
*/

import java.util.Scanner;

public class Glass{
    public static void main(String[] args) {
        
        Scanner lukija = new Scanner(System.in);
        
        System.out.println("Hello! I tell about glasses.");
        System.out.println("Are you an (o)ptimist or a (p)essimist?");
        String piirre = lukija.nextLine();
        
        if (piirre.contains("o")){
            System.out.println("The glass is half full.");
        }
        else {
            System.out.println("The glass is half empty.");
        }
    }
}