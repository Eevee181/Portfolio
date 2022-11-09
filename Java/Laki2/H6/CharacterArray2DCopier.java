/* TIEP5.1 Lausekielinen ohjelmointi II
 * Harjoitus 6, tehtävä 1
 * Eveliina Toivanen (eveliina.toivanen@tuni.fi)
 *
 * Ohjelma tekee kopioita taulukoista.
 */
 
public class CharacterArray2DCopier{
    
    /* Metodi tarkistaa onko sen parametri oikean kokoinen ja jos on, kopioi taulukon
     * uuteen muuttujaan, jonka se palauttaa.
     * kopioitava: taulukko, joka metodin tulisi kopioida.
     */
    public static char[][] kopioi2dTaulukko(char[][] kopioitava){
        
        // Tarkistetaan onko taulukko isompi kuin 1 x 1 ja ettei se ole tyhjä.
        if (kopioitava != null && kopioitava.length > 0) {
            if (kopioitava[0].length > 0) {
                
                // Tehdään apumuuttuja, johon taulukko kopioidaan.
                char[][] uusiTaulukko = new char[kopioitava.length][kopioitava[0].length];
        
                for(int i = 0; i < kopioitava.length; i ++){
                    for(int j = 0; j < kopioitava[i].length; j ++){
                        uusiTaulukko[i][j] = kopioitava[i][j];
                    }
                }
                
                return uusiTaulukko;
            }
        }
        
        return null;
        
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
    
    /* Pääohjelmaan on muodostettu erilaisia taulukoita, jotka lähetetään kopioi2dTaulukko-
     * metodille ja sen tuomat paluuarvot lähetetään tulosta2d.
     */
    public static void main(String[] args){
        char[][] plusMinus = {{'-', '|', '+'},{'+', '|', '-'}};
        char[][] aakkoset = {{'a', 'b', 'c'},{'c', 'b', 'a'}};
        char[][] javaVaja = {{'J', 'A', 'V', 'A'},{'V', 'A', 'J', 'A'}};
        char[][] uwuOwo = {{'u', 'w', 'u'},{'o', 'w', 'o'}};
        
        char[][] kopio1 = kopioi2dTaulukko(plusMinus);
        char[][] kopio2 = kopioi2dTaulukko(aakkoset);
        char[][] kopio3 = kopioi2dTaulukko(javaVaja);
        char[][] kopio4 = kopioi2dTaulukko(uwuOwo);
        char[][] kopio5 = kopioi2dTaulukko(null);
        
        tulosta2d(kopio1);
        tulosta2d(kopio2);
        tulosta2d(kopio3);
        tulosta2d(kopio4);
        tulosta2d(kopio5);
    }
}