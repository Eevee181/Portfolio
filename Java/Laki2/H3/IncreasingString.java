/* TIEP5.1 Lausekielinen ohjelmointi II
 * Harjoitus 3, tehtävä 5
 * Eveliina Toivanen (eveliina.toivanen@tuni.fi)
 *
 * Pyydetään käyttäjältä merkkijono ja katsotaan, onko sen merkit aakkosjärjestyksessä.
 */
 
import java.util.Scanner;
import java.util.Arrays;

public class IncreasingString{
    
    /* Tarkastetaan aputaulujen avulla, onko merkkijonon merkit aakkosjärjestyksessä.
     * merkkiJono: Käyttäjän syöttämä merkkijono.
     */
    public static boolean onkoAakkosjärjestyksessä(String merkkiJono){
        
        // Lasketaan merkkijonon pituus.
        int l = merkkiJono.length();
        
        // Tehdään aputaulu ja lisätään merkkijonon merkit sinne.
        char merkit[] = new char [l];
        for (int i = 0; i < l; i++){
            merkit[i] = merkkiJono.charAt(i);
        }
        
        //Järjestetään aputaulun muuttujat ja tarkastetaan onko aputaulun muuttujat
        // samassa järjestyksessä merkkijonon merkkien kanssa.
        Arrays.sort(merkit);
        for(int i = 0; i < l; i ++) {
            if (merkit[i] != merkkiJono.charAt(i)) {
                return false;
            }
        }
        
        return true;
    }
    
    public static void main(String[] args){
        
        Scanner lukija = new Scanner(System.in);
        System.out.println("Hello! I check whether string characters are in alphabetical order.");
        System.out.println("Please, enter a string:");
        String merkkiJono = lukija.nextLine();
        
        boolean jarjestys = onkoAakkosjärjestyksessä(merkkiJono);
        
        if (! jarjestys){
            System.out.println("Characters are not in alphabetical order.");
        }
        
        else if (jarjestys) {
            System.out.println("Characters are in alphabetical order.");
        }
    }
}