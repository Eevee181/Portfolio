package harjoitustyo.dokumentit;

import java.util.LinkedList;

/**
 * Dokumentti-luokasta peritty Vitsi-luokka, joka käsittelee vitsidokumenteille
 * tyypillisiä tietoja.
 * <p>
 * Olio-ohjelmoinnin perusteet II, harjoitustyö, kevät 2020
 * <p>
 * @author Eveliina Toivanen(toivanen.eveliinarai@gmail.com)
 */
public class Vitsi extends Dokumentti{
    /*
     * Attribuutit
     */
    private String laji;

    /*
     * Rakentajat
     */

    /**
     * Vitsi-luokan parametrillinen rakentaja, jossa alustetaan luokan
     * attribuutit.
     * 
     * @param n Dokumentin yksilöivä numerotunniste.
     * @param l Vitsidokumentille tyypillinen lajitieto.
     * @param t Dokumentin sisältämä teksti.
     * @throws IllegalArgumentException , jos parametreissa on jotakin häikkää.
     */
    public Vitsi(int n, String l, String t) throws IllegalArgumentException{
        super(n, t);
        laji(l);
    }

    /*
     * Aksessorit
     */

    /**
     * Laji-attribuutin lukeva akksessori.
     * 
     * @return laji-attribuutin sisältö.
     */
    public String laji(){
        return laji;
    }

    /**
     * Laji-attribuutin asettava akksessori.
     * 
     * @param l Vitsidokumentin lajitieto.
     * @throws IllegalArgumentException , jos lajitieto on tyhjä merkkijono tai
     * arvoltaan "null".
     */
    public void laji(String l) throws IllegalArgumentException{
        if(l != null && l != ""){
            laji = l;
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
        return tunniste() + "///" + laji + "///" + teksti();
    }

    @Override
    public boolean sanatTäsmäävät(LinkedList<String> hakusanat) throws IllegalArgumentException {
        return super.sanatTäsmäävät(hakusanat);
    }

    @Override
    public void siivoa(LinkedList<String> sulkusanat, String välimerkit) throws IllegalArgumentException {
        super.siivoa(sulkusanat, välimerkit);

    }

    @Override
    public int compareTo(Dokumentti kaveriDok) {
        return super.compareTo(kaveriDok);
    }

    
}