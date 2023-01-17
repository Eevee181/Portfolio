/* TIEP5.1 Lausekielinen ohjelmointi II
 * Harjoitus 4, tehtävä 1
 * Eveliina Toivanen (toivanen.eveliinarai@gmail.com)
 *
 * Luetaan käyttäjältä järjestysluku ja tulostetaan sen mukainen kuukausi.
 * Tein tämän näin jo alunperin tällä tavalla.
 */
 
import java.util.Scanner;

public class Month {
    
    /* Metodissa tulostetaan käyttäjän antaman järjestysluvun mukainen kuukausi.
     * kuukaudenNumero: Käyttäjän antama kuukauden järjestysluku.
     */
    public static void lausuKuukaudenNimi(int kuukaudenNumero){
         
         String[] kuukaudet = {"January", "February", "March", "April", "May", "June", 
                               "July", "August", "September", "October", "November", "December"};
                               
         // Vähennetään annetusta numerosta yksi, jotta luku täsmää taulukon indeksin kanssa.
         System.out.println("It is " + kuukaudet[kuukaudenNumero - 1] + ".");
     }
    
    /* Pääohjelmassa tervehditään käyttäjää, pyydetään tältä syötteenä kuukauden järjestysluku
     * ja lähetetään syöte lausuKuukaudenNimi metodille.
     */
    public static void main(String[] args) {
        
        // Alustetaan syötteenlukija.
        Scanner lukija = new Scanner(System.in);
         
         System.out.println("Hello! I verbalise your input.");
         System.out.println("Please, enter a number:");
         int kuukaudenNumero = lukija.nextInt();
         
         lausuKuukaudenNimi(kuukaudenNumero);
    }
}