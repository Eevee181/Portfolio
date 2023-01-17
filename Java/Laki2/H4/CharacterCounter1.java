/* TIEP5.1 Lausekielinen ohjelmointi II
 * Harjoitus 4, tehtävä 6
 * Eveliina Toivanen (toivanen.eveliinarai@gmail.com)
 *
 * Ohjelmassa pyydetään käyttäjältä merkki ja merkkijono ja lasketaan merkin esiintymät
 * merkkijonossa.
 */
 
import java.util.Scanner;

public class CharacterCounter1{
    
    /* Metodissa lasketaan kuinka monta kertaa käyttäjän syöttämä merkki on käyttäjän
     * antamassa merkkijonossa. Merkkijonon ollessa tyhjä tai null-arvoinen paluuarvona
     * palautetaan -1.
     * merkki: merkki, jonka esiintymät käyttäjä haluaa laskea.
     * jono: merkkijono, josta käyttäjä haluaa merkin esiintymät laskettavan.
     */
    public static int laskeEsiintymät(char merkki, String jono){
        
        // Muodostetaan apumuuttuja esiintymien laskemiseksi.
        int esiintyminen = 0;
        
        // Tarkastetaan, onko merkkijonossa merkkejä. Jos on, lasketaan mahdolliset
        // merkin esiintymät merkkijonosta.
        if (jono == null || jono == ""){
            return -1;
            
        }

        
        else {
            for (int ind = 0; ind < jono.length(); ind ++){
                if (jono.charAt(ind) == merkki){
                    esiintyminen = esiintyminen + 1;
                }
            }
            return esiintyminen;
        }
    }
    
    /* Pääohjelmassa tervehditään käyttäjää ja kysytään tältä syötteet, jotka lähetetään
     * laskeEsiintymät -metodille. Metodin paluuarvon mukaan tulostetaan tulosilmoitus.
     */
    public static void main(String[] args){
        
        // Alustetaan syötteen lukija.
        Scanner lukija = new Scanner(System.in);
        
        System.out.println("Hello! I count character occurrences.");
        System.out.println("Please, enter a string:");
        String jono = lukija.nextLine();
        System.out.println("Please, enter a character:");
        char merkki = lukija.next().charAt(0);
        
        int esiintyyko = laskeEsiintymät(merkki, jono);
        
        
        // Tarkastetaan, mikä on funktion antama paluuarvo ja tulostetaan sen mukainen
        // tuloste.
        if (esiintyyko < 1 ){
            System.out.println("0 occurrences found.");
        }
        else{
            System.out.println(esiintyyko + " occurrences found.");
        }
    }
    
}