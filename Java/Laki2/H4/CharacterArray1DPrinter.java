/* TIEP5.1 Lausekielinen ohjelmointi II
 * Harjoitus 4, tehtävä 3
 * Eveliina Toivanen (toivanen.eveliinarai@gmail.com)
 *
 * Tulostetaan erillisessä metodissa pääohjelmassa laaditut taulut.
 */

public class CharacterArray1DPrinter {
    
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
    }
    
    /* Pääohjelmassa muodostetaan taulut, jotka lähetetään tulosta-metodille 
     * null-arvon lisäksi.
     */
    public static void main(String[] args) {
        char[] taulu1 = {'J', 'a', 'v', 'a'};
        char[] taulu2 = {'L', 'e', 'x', 'u', 's'};
        
        // Lähetetään muodostetut taulut ja tyhjäarvo tulosta-metodille.
        tulosta(taulu1);
        tulosta(taulu2);
        tulosta(null);
        
    }
}