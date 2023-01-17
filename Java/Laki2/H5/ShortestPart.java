/* TIEP5.1 Lausekielinen ohjelmointi II
 * Harjoitus 5, tehtävä 1
 * Eveliina Toivanen (toivanen.eveliinarai@gmail.com)
 *
 * Ohjelmassa pyydetään käyttäjältä merkkijono ja lasketaan, mikä on merkkijonon
 * pienin osa.
 */
 
import java.util.Scanner;
 
public class ShortestPart{
    
    /* Metodissa tarkastetaan onko käyttäjän antama merkkijono olemassa. Jos on, se 
     * paloitellaan osiin ja käydään läpi ja etsitään se osa, joka on kaikista pienin
     * ja palautetaan osan pituus.
     * merkkiJono: käyttäjän antama merkkijono, josta pienin osa etsitään.
     */
    public static int mittaaLyhinOsa(String merkkiJono){
        
        // Muodostetaan apumuuttuja, johon pienimmän osasen pituus tallennetaan.
        int pieninPituus = 0;
        
        // Tarkastetaan merkkijonon olemassa olo ja toimitaan tuloksen mukaan.
        if (merkkiJono == null || merkkiJono == ""){
            return -1;
        }
        else{
            // Merkkijonon osia erottava merkki on annettava hakasulkeissa,
        // koska split-metodin parametri on säännöllinen ilmaus.
        String[] osat = merkkiJono.split("[ ]");
            
            for (int ind = 0; ind < osat.length; ind ++){
                if (ind == 0){
                   pieninPituus = osat[ind].length();
                }
                else {
                    if (pieninPituus > osat[ind].length()){
                        pieninPituus = osat[ind].length();
                    }
                }
            }
            return pieninPituus;
        }
    }
    
    /* Pääohjelmassa tervehditään käyttäjää ja kysytään tältä merkkijono, joka lähetetään
     * mittaaLyhinOsa-metodille. Tulos-tulosteeseen sisällytetään paluuarvona metodista
     * saatu luku.
     */
    public static void main(String[] args){
        
        // Alustetaan syötteiden lukija.
        Scanner lukija = new Scanner(System.in);
        
        System.out.println("Hello! I find the length of the shortest substring.");
        System.out.println("Please, enter a string:");
        String merkkiJono = lukija.nextLine();
        
        int kuinkaLyhyt = mittaaLyhinOsa(merkkiJono);
        
        System.out.println("The length is " + kuinkaLyhyt +".");
    }
}