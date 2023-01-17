/* TIEP5.1 Lausekielinen ohjelmointi II
 * Harjoitus 6, tehtävä 2
 * Eveliina Toivanen (toivanen.eveliinarai@gmail.com)
 *
 * 
 */

import java.util.Scanner;

public class Calculator{
    // Yhteenlaskun komento luokkavakiona.
    public static final String SUMMAA = "add";
    public static final String EROTA = "diff";
    public static final String KERRO = "multi";
    public static final String JAA = "div";
    public static final String LOPETA = "quit";
    
    public static String[] tarkista(String komento){
        
        if (komento == null){
            return null;
        }
        
        else {
            String[] komentoTaulu = komento.split("[ ]");
            try{
                yksi = Character.parseInt(komentoTaulu[1]);
                kaksi = Integer.parseInt(komentoTaulu[2]);
            }
        
            catch(NumberFormatException e){
                return null;
            }
            
        }
    }
    
    public static void main(String[] args){
        
        // Alustetaan syötteiden lukija.
        Scanner lukija = new Scanner(System.in);
        
        System.out.println("Hello! I am a simple calculator.");
        System.out.println("Please, enter a command:");
        String komento = lukija.nextLine();
        
        String[] komentoTaulu = tarkista(komento);
        
    }
}