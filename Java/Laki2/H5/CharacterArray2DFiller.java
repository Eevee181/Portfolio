/* TIEP5.1 Lausekielinen ohjelmointi II
 * Harjoitus 5, tehtävä 3
 * Eveliina Toivanen (toivanen.eveliinarai@gmail.com)
 *
 * Ohjelmassa pyydetään käyttäjältä kaksiulotteisen taulun speksejä ja muodostetaan
 * niiden perusteella ko. taulu ja tulostetaan se.
 */

import java.util.Scanner;
 
public class CharacterArray2DFiller{
    
    /* Metodi muodostaa kaksiulotteisen taulun saamiensa kokoparametrien ja
     * taulukon arvo-parametrien perusteella.
     * riviKoko: Alustettavan kaksiulotteisen taulun rivien lukumäärä.
     * sarakeKoko: Alustettavan kaksiulotteisen taulun sarakeiden lukumäärä.
     * merkki: jokin merkki, joka on taulukon kaikkien alkioiden arvo.
     */
    public static char[][] luo2d(int riviKoko, int sarakeKoko, char merkki){
        
        // Jos taulukon koko parametrit eivät vastaa vaatimuksia, palautetaan
        // tyhjäarvo. Muussa tapauksessa luodaan taulukko ja lisätään alkioiden arvot.
        if (riviKoko > 0 && sarakeKoko > 0){
            char[][] merkinTaulu = new char[riviKoko][sarakeKoko];
            
            for(int i = 0; i < merkinTaulu.length; i ++){
                for(int j = 0; j < merkinTaulu[i].length; j ++){
                    merkinTaulu[i][j] = merkki;
                }
            }
            
            return merkinTaulu;
        }
        else{
            return null;
        }
    }
    
    /* Metodi käy läpi parametrinaan saamansa kaksiulotteisen taulukon läpi ja tulostaa
     * sen alkiot "taulukoittain".
     * merkit: kaksiulotteinen taulukko.
     */
    public static void tulosta2d(char[][] merkit){
        
        // Jos taulukko ei ole tyhjä, se voidaan tulostaa.
        if(merkit != null){
            for(int i = 0; i < merkit.length; i ++){
                for (int j = 0; j < merkit[i].length; j ++){
                    System.out.print(merkit[i][j]);
                }
                System.out.println();
            }
            
        }
    } 
    
    /* Pääohjelmassa pyydetään käyttäjältä syötteet jotka lähetetään luo2d-metodille.
     * Metodin paluuarvo tarkastetaan ja sen ollessa taulu, paluuarvo lähetetään
     * parametrina tulosta2d-metodille, joka tulostaa taulun.
     */
    public static void main(String[] args){
        
       // Alustetaan syötteiden lukija.
        Scanner lukija = new Scanner(System.in);
        
        System.out.println("Hello! I am an array filler.");
        
        // Pyydetään käyttäjältä tarvittavat syötteet.
        System.out.println("Please, enter the number of rows:");
        int riviLkm = lukija.nextInt();
        System.out.println("Please, enter the number of columns:");
        int sarakeLkm = lukija.nextInt();
        System.out.println("Please, enter a character:");
        char merkki = lukija.next().charAt(0);
        
        char[][] merkinTaulu = luo2d(riviLkm, sarakeLkm, merkki);
        
        // Tarkastetaan luo2d-metodin paluuarvoa. Jos se ei ole tyhjä, taulu voidaan tulostaa.
        // Muussa tapauksessa tulosetaan virheilmoitus.
        if (merkinTaulu != null){
            tulosta2d(merkinTaulu);
        }
        else{
            System.out.println("Error!");
        }
        
    }
}