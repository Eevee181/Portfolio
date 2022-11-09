/* TIEP5.1 Lausekielinen ohjelmointi II
 * Harjoitus 5, tehtävä 4
 * Eveliina Toivanen (eveliina.toivanen@tuni.fi)
 *
 * Ohjelman tarkoituksena on kuormittaa luo2d-metodia.
 */
 
public class CharacterArray2DFiller2{
    
    /* Metodi lähettää alkuperäiselle luo2d-metodille oletusarvoisen taulukon
     * tiedot ja palauttaa metodin paluuarvon.
     */
    public static char[][] luo2d(){
        
        char[][] merkinTaulu = luo2d( 3, 4, '#');
            
        return merkinTaulu;
       
    }
    
    /* Metodi lähettää parametreinaan saamansa taulukon kokospeksit alkuperäiselle
     * luo2d-metodille oletusmerkin kanssa ja palauttaa paluuarvona saamansa taulun.
     * riviLkm: Parametrina saatu haluttujen rivien lukumäärä.
     * sarakeLkm: Parametrina saatu haluttujen rivien lukumäärä.
     */
    public static char[][] luo2d(int riviLkm, int sarakeLkm){
        
        char [][] merkinTaulu = luo2d(riviLkm, sarakeLkm, '#');
        
        return merkinTaulu;
    }
    
    /* Metodi muodostaa kaksiulotteisen taulun saamiensa kokoparametrien ja
     * taulukon arvo-parametrien perusteella.
     * riviKoko: Alustettavan kaksiulotteisen taulun rivien lukumäärä.
     * sarakeKoko: Alustettavan kaksiulotteisen taulun sarakeiden lukumäärä.
     * merkki: Jokin merkki, joka on taulukon kaikkien alkioiden arvo.
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
            
            System.out.println();
            
        }
    } 
    
    /* Pääohjelma lähettää ainoastaan funktiokutsuja luo2d- ja tulosta2d-metodeille.
     */
    public static void main(String[] args){
        char[][] oletus = luo2d();
        tulosta2d(oletus);
        
        char[][] pikkuTaulu = luo2d(2,2);
        tulosta2d(pikkuTaulu);
        char[][] isoTaulu = luo2d(6,4);
        tulosta2d(isoTaulu);
    }
}