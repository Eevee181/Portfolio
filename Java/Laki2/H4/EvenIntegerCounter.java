/* TIEP5.1 Lausekielinen ohjelmointi II
 * Harjoitus 4, tehtävä 5
 * Eveliina Toivanen (eveliina.toivanen@tuni.fi)
 *
 * Lasketaan numerotauluista, kuinka monta parillista numeroa ne sisältävät.
 */
 
public class EvenIntegerCounter {
    
    /* Metodissa käydään läpi parametriarvona saatu taulu alkio kerrallaan
     * ja lasketaan kuinka monta parillista lukua lista sisältää.
     * lukuLista: pääohjelmassa määritelty lukujen taulu.
     */
    public static int laskeParilliset(int[] lukuLista){
        
        // Luodaan apumuuttuja, johon lisätään parillisten lukujen esiintymisen määrä.
        int parillisetLkm = 0;
        
        // Jos lukutaulu ei ole tyhjä, voidaan se käydä läpi ja tarkistaa jakojäännöksen
        // avulla, kuinka monta parillista lukua siitä löytyy.
        if (lukuLista != null) {
            for (int ind = 0; ind < lukuLista.length; ind ++){
                
                int jakojaannos = lukuLista[ind] % 2;
                
                if (jakojaannos == 0){
                    parillisetLkm = parillisetLkm + 1;
                }
            }
            
            return parillisetLkm;
        }
        
        // Lukujen listan ollessa tyhjä, apumuuttuja saa arvon -1 ja se palautetaan takaisin
        // pääohjelmaan sellaisenaan.
        else{
            parillisetLkm = -1;
            return parillisetLkm;
        }
    }
    
    /* Pääohjelmassa alustetaan lukulistaukset ja sen jälkeen kutsutaan laskeParilliset-metodia,
     * jossa lukulistat käydään läpi.
     */
    public static void main(String[] args){
        int[] luvut1 = {8, 16, 12, 31, 22, 10, 7, 11};
        int[] luvut2 = {11, 13, 14, 16, 27, 3};
        
        // Lähetetään numerotaulut ja tyhjäarvo laskeParilliset-metodille.
        int kuinkaMonta = laskeParilliset(luvut1);
        int kuinkaMonta2 = laskeParilliset(luvut2);
        int kuinkaMonta3 = laskeParilliset(null);
    }
}