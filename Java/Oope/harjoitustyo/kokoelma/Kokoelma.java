package harjoitustyo.kokoelma;
import harjoitustyo.omalista.OmaLista;
import harjoitustyo.apulaiset.Kokoava;
import harjoitustyo.dokumentit.*;

/**
 * Kokoelma-luokka
 * <p>
 * Olio-ohjelmoinnin perusteet II, harjoitustyö, kevät 2020
 * <p>
 * @author Eveliina Toivanen(toivanen.eveliinarai@gmail.com)
 */
public class Kokoelma extends Object implements Kokoava<Dokumentti>{
    /*
     * Attribuutit
     */
    private OmaLista<Dokumentti> dokumentit;

    /*
     * Rakentaja
     */

    /**
     * Kokoelma-olion oletus-rakentaja, jossa luodaan uusi Oma lista -alkio.
     * 
     */
    public Kokoelma(){
        dokumentit = new OmaLista<Dokumentti>();
    }

    /*
     * Akksessorit
     */

    /**
     * Oma lista tyyppisen dokumentit-luokan lukeva akksessori.
     * 
     * @return geneerinen oma lista, joka sisältää kaikki tallennetut dokumentit.
     */
    public OmaLista<Dokumentti> dokumentit(){
        return dokumentit;
    }

    /*
     * Korvatut metodit
     */

    @Override
    public void lisää(Dokumentti uusi) throws IllegalArgumentException {
        if(uusi != null && !dokumentit.contains(uusi)){
           dokumentit.lisää(uusi); 
        }
        else{
            throw new IllegalArgumentException();
        }
    }

    @Override
    public Dokumentti hae(int tunniste) {
        for(Dokumentti dokumentti : dokumentit){
            if(tunniste == dokumentti.tunniste()){
                return dokumentti;
            }
        }

        return null;
    }
}