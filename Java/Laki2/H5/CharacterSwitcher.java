/* TIEP5.1 Lausekielinen ohjelmointi II
 * Harjoitus 5, tehtävä 5
 * Eveliina Toivanen (eveliina.toivanen@tuni.fi)
 *
 * Ohjelmassa käännetään kaksiulotteisista tauluista merkkejä toisinpäin.
 */
 
public class CharacterSwitcher{
    
    /* Metodi tarkastaa onko parametrinä saatu 2d-taulu olemassa. Jos on, parametreinä
     * annettujen kahden merkin paikkoja vaihdetaan päittäin. Paluuarvona palautetaan
     * boolean sen perusteella, onko parametrina saatua taulua olemassa.
     *
     * merkkiTaulu: 2d-taulu, josta olisi tarkoitus merkkien paikkoja vaihtaa.
     * merkki1: Ensimmäinen paikkaa vaihtava merkki.
     * merkki2: Toinen paikkaa vaihtava merkki.
     */
    public static boolean vaihdaMerkit(char[][] merkkiTaulu, char merkki1, char merkki2){
        
        // Tarkastetaan onko taulu tyhjä. Jos ei, vaihdetaan merkkien paikkoja.
        if(merkkiTaulu == null || merkkiTaulu[0].length < 1){
            return false;
        }
        else{
            for(int i = 0; i < merkkiTaulu.length; i ++){
                for(int j = 0; j < merkkiTaulu[i].length; j ++){
                    if (merkkiTaulu[i][j] == merkki1){
                        merkkiTaulu[i][j] = merkki2;
                    }
                    
                    else if(merkkiTaulu[i][j] == merkki2){
                        merkkiTaulu[i][j] = merkki1;
                    }
                }
            }
            return true;
            
        }
    }
    
    /* Metodi käy läpi parametrinaan saamansa kaksiulotteisen taulukon läpi ja tulostaa
     * sen alkiot "taulukoittain".
     * merkit: kaksiulotteinen taulukko.
     */
    public static void tulosta2d(char[][] merkkiTaulu){
        if(merkkiTaulu != null){
            for(int i = 0; i < merkkiTaulu.length; i ++){
                for (int j = 0; j < merkkiTaulu[i].length; j ++){
                    System.out.print(merkkiTaulu[i][j]);
                }
                System.out.println();
            }
            
        }
    }
    
    /* Pääohjelmassa on luotuna kolme 2d-taulua, jotka lähetetään vaihdaMerkit-metodille
     * paikkaa vaihtavien merkkien kanssa ja paluuarvon ollessa tosi, lähetetään taulut
     * tulosta2d-metodille.
     */
    public static void main(String[] args){
        char[][] plusMinus = {{'-', '|', '+'},{'+', '|', '-'}};
        char[][] aakkoset = {{'a', 'b', 'c'},{'c', 'b', 'a'}};
        char[][] javaVaja = {{'J', 'A', 'V', 'A'},{'V', 'A', 'J', 'A'}};
        
        // Lähetetään jokainen taulu vaihdettavine merkkeineen vaihdaMerkit-metodille
        // ja paluuarvon ollessa tosi, tulostetaan taulu paikkoja vaihtaneilla merkeillä.
        boolean totuus1 = vaihdaMerkit(plusMinus, '+', '-');
        if (totuus1){
            tulosta2d(plusMinus);
        }
        
        boolean totuus2 = vaihdaMerkit(aakkoset, 'a', 'c');
        if (totuus2){
            tulosta2d(aakkoset);
        }
        
        boolean totuus3 = vaihdaMerkit(javaVaja, 'J', 'V');
        if (totuus3){
            tulosta2d(javaVaja);
        }
        
        boolean totuus4 = vaihdaMerkit(null, '+', '-');
        if (totuus4){
            tulosta2d(null);
        }
    }
}