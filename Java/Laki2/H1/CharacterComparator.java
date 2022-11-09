/* TIEP5.1 Lausekielinen ohjelmointi II
Harjoitus 1, tehtävä 6
Eveliina Toivanen (eveliina.toivanen@tuni.fi)
*/

import java.util.Scanner;
public class CharacterComparator{
    public static void main(String[] args) {
        
        Scanner lukija = new Scanner(System.in);

        System.out.println("Hello! I compare two characters of a string."); 
        System.out.println("Please, enter string:"); 
        String merkkijono = lukija.nextLine();

        System.out.println("Please, enter the first position:"); 
        int ekaIndeksi = lukija.nextInt();
        System.out.println("Please, enter the second position:");
        int tokaIndeksi = lukija.nextInt();
        
        int jonon_pituus = merkkijono.length();
        
        
        if ((0 <= ekaIndeksi && ekaIndeksi <= (jonon_pituus - 1)) 
            && (0 <= tokaIndeksi && tokaIndeksi <= (jonon_pituus - 1))) {
            char ekaMerkki = merkkijono.charAt(ekaIndeksi);
            char tokaMerkki = merkkijono.charAt(tokaIndeksi);
            
            if (ekaMerkki == tokaMerkki){
                System.out.println("'" + ekaMerkki + "' is equal to '" + tokaMerkki + "'.");
            }
            else {
                System.out.println("'" + ekaMerkki + "' is different from '" + tokaMerkki + "'.");
            }
        }
        else{
            System.out.println("Error!");
        }
    }
}