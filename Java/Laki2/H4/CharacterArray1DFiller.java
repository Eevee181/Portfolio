/* TIEP5.1 Lausekielinen ohjelmointi II
 * Harjoitus 4, tehtävä 4
 * Eveliina Toivanen (eveliina.toivanen@tuni.fi)
 *
 * Käyttäjältä pyydetään taulun koko ja sen jälkeen taulukon alkiot, jonka
 * jälkeen taulu tulostetaan erillisessä metodisa.
 */
 
import java.util.Scanner;

public class CharacterArray1DFiller {
    
    // Alustetaan syötteen lukija luokkavakiona, sillä sitä tarvitaan useammassa metodissa.
    public static final Scanner LUKIJA = new Scanner(System.in);
    
    /* Metodissa luodaan käyttäjän antaman luvun kokoinen merkkitaulu.
     *
     * koko: käyttäjän pääohjelmassa antama taulun alkioiden määrä.
     */
    public static char [] luo (int koko) {
       
        // Jos taulun koko on positiivinen kokonaisluku, alkiot voidaan lisätä tauluun.
        if (koko > 0){
            
            char[] merkit = new char[koko];
            
            // Muodostetaan apumuuttuja, jolla lasketaan indeksiä ja alkioiden määrää
            // tulosteessa.
            int luku = 1;
            while(koko > 0) {
            
                System.out.println("Please, enter value " + luku + ":");
                char lisattava = LUKIJA.next().charAt(0);
                merkit[luku - 1] = lisattava;
                
                // Vähennetään ja lisätään olemassa olevia laskureita.
                luku = luku + 1;
                koko = koko - 1;
            }
            
            return merkit;
        }
        
        else {
            return null;
        }
    }
    
    /* Metodissa tarkistetaan, onko parametrina oikeasti taulu vai tyhjäarvo. Jos taulu
     * on olemassa, se tulostetaan merkki kerrallaan aaltosulkeiden sisään.
     * taulu: pääohjelmassa muodostettu taulu.
     */
    public static void tulosta (char[] taulu) {
        
        // Tarkastetaan onko taulu tyhjä. 
        if (taulu != null){
            System.out.print("{");
            
            // Käydään läpi jokainen taulun alkio ja tulostetaan tarvittaessa pilkku 
            // erotinmerkkinä
            for (int ind = 0; ind < taulu.length; ind ++){
                System.out.print("'" + taulu[ind] + "'");
                if (ind < taulu.length -1) {
                    System.out.print(", ");
                }
            }
            System.out.print("}");
            System.out.println();
        }
        
        else {
            System.out.println("Error!");
        }
    }
    
    /* Pääohjelmassa tervehditään käyttäjää ja pyydetään tältä syötteenä haluamansa
     * taulukon koko ja lähetetään koko luo-metodille, jonka paluuarvona tuleva 
     * taulu lähetetään tulosta-metodille.
     */
    public static void main(String[] args){
        
        System.out.println("Hello! I am an array filler.");
        System.out.println("Please, enter size:");
        int koko = LUKIJA.nextInt();
        
        char[] merkkiTaulu = luo(koko);
        tulosta(merkkiTaulu);
    }
}