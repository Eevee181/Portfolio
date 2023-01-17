package harjoitustyo.dokumentit;

import harjoitustyo.apulaiset.Tietoinen;

import java.time.Year;
import java.util.LinkedList;

/**
 * Abstrakti Dokumentti-luokka, johon on sisällytetty eri dokumenttien yhteiset
 * piirteet.
 * <p>
 * Olio-ohjelmoinnin perusteet II, harjoitustyö, kevät 2020
 * <p>
 * @author Eveliina Toivanen(toivanen.eveliinarai@gmail.com)
 */
public abstract class Dokumentti implements Tietoinen<Dokumentti>, Comparable<Dokumentti>{
    /*
     * Attribuutit
     */
    private int tunniste;
    private String teksti;

    /*
     * Rakentajat
     */

    /**
     * Alustetaan Dokumentti-olion attribuutit parametrillisessa rakentajassa.
     * 
     * @param n Tietyn dokumentin yksilöivä numerotunniste.
     * @param t Dokumentin sisältämä teksti.
     * @throws IllegalArgumentException jos parametreissa on jokin virhe, eikä 
     * tietojen lisäys akksessoreissa onnistu.
     */
    public Dokumentti(int n, String t) throws IllegalArgumentException{
        try{
            tunniste(n);
            teksti(t);
        }
        catch(Exception e){
            throw new IllegalArgumentException();
        }
    }

    /*
     * Akksessorit
     */

    /**
     * Tunniste attribuutin lukeva akksessori.
     * 
     * @return tunniste attribuutin sisällön.
     */
    public int tunniste(){
        return tunniste;
    }

    /**
     * Tunniste attribuutin asettava akksessori.
     * 
     * @param n parametrina annettu dokumentin yksilöivä numerotunniste.
     * @throws IllegalArgumentException , jos n-parametri on pienempi kuin 1.
     */
    public void tunniste(int n) throws IllegalArgumentException{
        if(n > 0){
            tunniste = n;
        }
        else{
            throw new IllegalArgumentException();
        }
    }

    /**
     * Teksti attribuutin lukeva akksessori.
     * 
     * @return attribuutin teksti sisällön.
     */
    public String teksti(){
        return teksti;
    }

    /**
     * Teksti attribuutin asettava akksessori. 
     * 
     * @param t Dokumentin sisältämä teksti.
     * @throws IllegalArgumentException , jos teksti on tyjä merkkijono tai 
     * arvoltaan "null"
     */
    public void teksti(String t) throws IllegalArgumentException{
        if(t != null  && t != ""){
            teksti = t;
        }
        else{
            throw new IllegalArgumentException();
        }
    }

    /*
     * Korvaavat metodit
     */

    @Override
    public String toString(){
        return tunniste + "///" + teksti;
    }

    @Override
    public boolean equals(Object toinen){
        try{
            Dokumentti kaveriDok = (Dokumentti) toinen;

            return tunniste == kaveriDok.tunniste() && teksti.equals(kaveriDok.teksti());
        }

        catch(Exception e){
            return false;
        }
    }

    @Override
    public int compareTo(Dokumentti kaveriDok){
        // Dokumentin tunniste on pienempi kuin toisen dokumentin tunniste.
        if (tunniste < kaveriDok.tunniste()) {
            return -1;
        }
        // Dokumenteilla on saman suuruinen tunnistenumero.
        else if (tunniste == kaveriDok.tunniste()) {
            return 0;
        }
        // Dokumentilla on suurempi tunniste kuin toisella dokumentilla.
        else {
           return 1;
        }
    }

    @Override
    public boolean sanatTäsmäävät(LinkedList<String> hakusanat) throws IllegalArgumentException{
        if (hakusanat == null || hakusanat.size() == 0){
            throw new IllegalArgumentException();
        }
        
        String[] hakusanaLista = hakusanat.toArray(new String[0]);
        String[] tekstiKatkottu = teksti.split(" ");
        int sanatOlemassa = 0;

        for(String hakusana : hakusanaLista){
            for(String sana : tekstiKatkottu){
                if(hakusana.equals(sana)){
                    sanatOlemassa++;
                    break;
                }  
            }
            if(sanatOlemassa == hakusanaLista.length){
                return true;
            }
        }
       return false;
    }

    @Override
    public void siivoa(LinkedList<String> sulkusanat, String välimerkit) throws IllegalArgumentException{
        if(sulkusanat == null || sulkusanat.size() == 0){
            throw new IllegalArgumentException();
        }
        if(välimerkit == null || välimerkit == ""){
            throw new IllegalArgumentException();
        }
        
        String[] poistaMerkit = välimerkit.split("");
        for(int i = 0; i < poistaMerkit.length; i++){
            teksti = teksti.replace(poistaMerkit[i], "");
        }
        
        teksti = teksti.toLowerCase();
        String[] pätkitty = teksti.split(" ");
        for(int x = 0; x < pätkitty.length; x++){
            for(int y = 0; y < sulkusanat.size(); y++){
                if(pätkitty[x].equals(sulkusanat.get(y))){
                    pätkitty[x] = "";
                }
            }
        }

        String koonti = "";
        for(int x = 0; x < pätkitty.length; x++){
            koonti = koonti + pätkitty[x] + " ";
        }
        teksti = koonti;
        teksti = teksti.replaceAll("\\s+"," ").trim();
    }

    


}