/* TIEP5.1 Lausekielinen ohjelmointi II
 * Harjoitus 4, tehtävä 7
 * Eveliina Toivanen (eveliina.toivanen@tuni.fi)
 *
 * Käyttäjältä kysytään taulun kokoa, jonka jälkeen luodaan koon perusteella
 * käyttäjän antama taulu, ja sen jälkeen pyydetään käyttäjältä merkki, jonka
 * esiintymiskerrat lasketaan taulusta.
 */
 
import java.util.Scanner;
 
public class CharacterCounter2{
    
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
    
    /* Metodissa lasketaan kuinka monta kertaa käyttäjän syöttämä merkki on käyttäjän
     * antamassa tauludds. Merkkitaulun ollessa tyhjä tai null-arvoinen paluuarvona
     * palautetaan -1.
     * merkki: merkki, jonka esiintymät käyttäjä haluaa laskea.
     * taulu: merkkitaulu, josta käyttäjä haluaa merkin esiintymät laskettavan.
     */
    public static int laskeEsiintymät(char merkki, char[] taulu){
        
        // Muodostetaan apumuuttuja esiintymien laskemiseksi.
        int esiintyminen = 0;
        
        // Tarkastetaan, onko merkkitaulussa merkkejä. Jos ei ole palautetaan -1. Muussa
        // tapauksessa lasketaan kuinka monta kertaa merkki esiintyy taulussa.
        if (taulu == null || taulu.length == 0){
            return -1;
            
        }

        else {
            for (int ind = 0; ind < taulu.length; ind ++){
                if (taulu[ind] == merkki){
                    esiintyminen = esiintyminen + 1;
                }
            }
            return esiintyminen;
        }
    }
    
    /* Pääohjelmassa tervehditään käyttäjää ja pyydetään käyttäjältä taulun kokoa, joka
     * lähetetään luo-metodille, jonka paluuarvosta tarkistetaan, onko se taulu vai nolla.
     * Paluuarvon ollessa taulu, pyydetään käyttäjältä tauluun verrattava merkki, joka lähetetään
     * laskeEsiintymät -metodille, jonka paluuarvo tarkistetaan ja tulostetaan paluuarvon mukaisesti
     * tulostuloste.
     */    
    public static void main(String[] args){
        
        System.out.println("Hello! I count character occurrences.");
        System.out.println("Please, enter size:");
        int koko = LUKIJA.nextInt();
        
        char[] merkkiTaulu = luo(koko);
        
        // Tarkastetaan luo-metodin paluuarvo ja toimitaan arvon mukaisesti.
        if (merkkiTaulu == null){
            System.out.println("Error!");
        }
        else{
            System.out.println("Please, enter a character:");
            char merkki = LUKIJA.next().charAt(0);
            
            int esiintymät = laskeEsiintymät(merkki, merkkiTaulu);
            
            // Tarkastetaan laskeEsiintymät -metodin paluuarvo ja toimitaan sen mukaisesti.
            if (esiintymät < 1 ){
                System.out.println("0 occurrences found.");
            }
            else{
                System.out.println(esiintymät + " occurrences found.");
            }
        }
    }
}