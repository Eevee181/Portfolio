/* TIEP5.1 Lausekielinen ohjelmointi II
 * Harjoitus 5, tehtävä 2
 * Eveliina Toivanen (eveliina.toivanen@tuni.fi)
 *
 * Ohjelmassa tulostetaan kaksiulotteisia taulukoita.
 */
 
public class CharacterArray2DPrinter{
    
    /* Metodi käy läpi parametrinaan saamansa kaksiulotteisen taulukon läpi ja tulostaa
     * sen alkiot "taulukoittain".
     * merkit: kaksiulotteinen taulukko.
     */
    public static void tulosta2d(char[][] merkit){
        if(merkit != null){
            for(int i = 0; i < merkit.length; i ++){
                for (int j = 0; j < merkit[i].length; j ++){
                    System.out.print(merkit[i][j]);
                }
                System.out.println();
            }
            
        }
    }
    
    /* Pääohjelma lähettää tulosta2d-metodille parametreina kaksi kaksiulotteista 
     * taulukkoa, sekä tyhjäarvon.
     */
    public static void main(String[] args){
        char[][] merkit = {{'a', 'b', 'c'},{'d', 'e', 'f'}};
        char[][] merkit2 = {{'a'},{'b'},{'c'}};
        
        // Kutsutaan taulukoita ja kerran tyhjäarvoa.
        tulosta2d(merkit);
        tulosta2d(merkit2);
        tulosta2d(null);
    }
}