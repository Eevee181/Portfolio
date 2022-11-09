/* TIEP5.1 Lausekielinen ohjelmointi II
 * Harjoitus 3, tehtävä 2
 * Eveliina Toivanen (eveliina.toivanen@tuni.fi)
 *
 * Pyydetään käyttäjältä numero ja tulostetaan sitä vastaava kuukausi.
 */
 
 import java.util.Scanner;
 
 public class Month{
     
     /* Tulostetaan käyttäjän antaman numeron mukainen kuukausi.
      * kuukaudenNumero: Käyttäjän antama numero, joka vastaa kuukautta.
      */
     public static void lausuKuukaudenNimi(int kuukaudenNumero){
         
         String[] kuukaudet = {"January", "February", "March", "April", "May", "June", 
                               "July", "August", "September", "October", "November", "December"};
                               
         // Vähennetään annetusta numerosta yksi, jotta luku täsmää taulukon indeksin kanssa.
         System.out.println("It is " + kuukaudet[kuukaudenNumero - 1] + ".");
     }
     
     public static void main(String[] args){
         
         Scanner lukija = new Scanner(System.in);
         
         System.out.println("Hello! I verbalise your input.");
         System.out.println("Please, enter a number:");
         int kuukaudenNumero = lukija.nextInt();
         
         lausuKuukaudenNimi(kuukaudenNumero);
     }
 }