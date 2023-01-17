package harjoitustyo.dokumentit;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;

/**
 * Dokumentti-luokasta periytyvä Uutinen-luokka, joka käsittelee uutisdokumentille
 * ominaisia tietoja.
 * <p>
 * Olio-ohjelmoinnin perusteet II, harjoitustyö, kevät 2020
 * <p>
 * @author Eveliina Toivanen(toivanen.eveliinarai@gmail.com)
 */
public class Uutinen extends Dokumentti {
    /*
     * Attribuutit
     */
    private LocalDate päivämäärä;

    /*
     * Rakentajat
     */
    
    /**
     * Uutinen-luokan parametrillinen rakentaja attribuuttien alustukseen.
     * 
     * @param n Dokumentin yksilöivä numerotunniste.
     * @param l Uutisdokumentille tyypillinen päivämäärä.
     * @param t Dokumentin sisältämä teksti.
     * @throws IllegalArgumentException , jos parametreissa on jotakin häikkää.
     */
    public Uutinen(int n, LocalDate l, String t) throws IllegalArgumentException {
        super(n, t);
        päivämäärä(l);
    }

    /*
     * Aksessorit
     */

    /**
     * Päivämäärä-attribuutin lukeva aksessori.
     * 
     * @return päivämäärä attribuutin sisältö.
     */
    public LocalDate päivämäärä() {
        return päivämäärä;
    }

    /**
     * Päivämäärä-attribuutin asettava akksessori.
     * 
     * @param p Uutisen päivämäärä
     * @throws IllegalArgumentException , jos päivämäärän parametrin arvo on "null"
     */
    public void päivämäärä(LocalDate p) throws IllegalArgumentException {
        if (p != null) {
            päivämäärä = p;
        } else {
            throw new IllegalArgumentException();
        }
    }

    /*
     * Korvaavat metodit
     */
    
    @Override
    public String toString() {
        return tunniste() + "///" + päivämäärä.format(DateTimeFormatter.ofPattern("d.M.y")) + "///" + teksti();
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