/* TIEP5.1 Lausekielinen ohjelmointi II
 * Harjoitus 4, tehtävä 2
 * Eveliina Toivanen (eveliina.toivanen@tuni.fi)
 *
 * Ohjelma pyytää käyttäjältä merkkijonon ja luvun, kuinka monta kertaa käyttäjältä
 * haluaa merkkijonon toistaa ja tulostaa merkkijonon sen mukaan.
 */
 
import java.util.Scanner;

public class Replicator {
    
    /* Metodissa tarkastetaan onko käyttäjän antama kertoluku sallituissa rajoissa ja 
     * luotu muuttujana tyhjä stringi, johon tarkastuksen mennessä läpi lisätään kertoman
     * mukainen määrä merkkijonoa.
     * merkit: merkkijono, jonka käyttäjä haluaa monistaa.
     * kertaa: luku kuinka monta kertaa käyttäjä haluaa merkkijonon kertoa.
     */
    public static String monista(String merkit, int kertaa) {
        // Luodaan apumuuttuja, johon lisätään merkkijonoa tarvittava määrä
        String monistettu = "";
        
        // Tarkistetaan onko kertoja yli yhden, jos on lisätään käyttäjän syöttämää
        // merkkijonoa luvun verran apumuuttujaan.
        if (kertaa >= 2){
            monistettu = monistettu + merkit;
            
            while (kertaa - 1 > 0){
                monistettu = monistettu + ", " + merkit;
                kertaa = kertaa - 1;
            }
            
            return monistettu;
        }
        
        else {
            return monistettu;
        }
    }
    
    /* Pääohjelmassa tervehditään käyttäjää, pyydetään syötteenä merkkijono ja kertoja,
     * jotka lähetetään monista-metodille, jonka palautusarvon perusteella ohjelma tulostaa
     * joko virheilmoituksen tai kerrottujen merkkijonojen kombinaation.
     */
    public static void main(String [] args) {
        
        // Alustetaan syötteenlukija.
        Scanner lukija = new Scanner(System.in);
        
        System.out.println("Hello! I replicate strings.");
        
        System.out.println("Please, enter a string:");
        String merkit = lukija.nextLine();
        System.out.println("Please, enter the number of replications:");
        int kertaa = lukija.nextInt();
        
        String kerrottuna = monista(merkit, kertaa);
        
        if (kerrottuna == ""){
            System.out.println("Error!");
        }
        
        else {
            System.out.println(kerrottuna);
        }
    }
}
