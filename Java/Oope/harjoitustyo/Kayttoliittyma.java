package harjoitustyo;

import java.util.LinkedList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import harjoitustyo.dokumentit.Dokumentti;
import harjoitustyo.dokumentit.Uutinen;
import harjoitustyo.dokumentit.Vitsi;
import harjoitustyo.kokoelma.Kokoelma;
import harjoitustyo.omalista.OmaLista;

/**
 * Käyttöliittymä-luokka, jossa pyöritetään käyttäjälle näkyvää osaa ohjelmasta.
 * <p>
 * Olio-ohjelmoinnin perusteet II, harjoitustyö, kevät 2020
 * <p>
 * @author Eveliina Toivanen(toivanen.eveliinarai@gmail.com)
 */
public class Kayttoliittyma {
    // Luodaan tehtävän komennoista yksityiset luokkavakiot.
    private static final String ADD = "add";
    private static final String FIND = "find";
    private static final String KAIKU = "echo";
    private static final String POLISH = "polish";
    private static final String PRINT = "print";
    private static final String REMOVE = "remove";
    private static final String RESET = "reset";
    private static final String QUIT = "quit";

    // Luodaan kokoelmalle ja sulkusanoille, sekä apumuuttujille, omat muuttujat tässä kohtaa, jotta
    // niitä voidaan onnistuneesti käyttää missä tahansa kohtaa ohjelmaa.
    Kokoelma kokoelma = new Kokoelma();
    LinkedList<String> poistoSanat = new LinkedList<>();

    boolean kaikuuko = false;
    boolean onkoEkaLisays = true;
    String[] komentoRiviKopio = null;

    /**
     * Käyttöliittymä-olion rakentaja, jossa saatetaan käyttöliittymän toiminta
     * alkuun.Tulostaa virheilmoituksen, jos käyttäjä ei ole antanut tarpeeksi tiedostoja.
     * <p>
     * @param komentoRivi tuo käyttöliittymään käyttäjän antaman
     *                    komentorivisyötteen.
     */
    public Kayttoliittyma(String[] komentoRivi) {
        alku();

        // Tarkastetaan, onko komentorivin pituus oikea. Jos on, voidaan siitä luoda varmuuskopio talteen ja käsitellä
        // ensimmäinen syötteessä annetuista tiedostoista. Jos ei, tulostetaan virheilmoitus.
        if(komentoRivi.length == 2){
            komentoRiviKopio = komentoRivi;
            boolean dokumentitOnnistui = luoDokKokoelma(komentoRivi);
            onkoEkaLisays = false;

            // Jos dokumenttikokoelman luominen onnistuu, voidaan siirtyä toisen tiedoston käsittelemiseen.
            // Jos ei onnistu, tulostetaan ohjelman päättymisestä kertova tuloste.
            if(dokumentitOnnistui){
                boolean poistoListaOnnistui = luoPoistoKokoelma(komentoRivi);

                // Jos kumpikin tiedostonluku onnistuu, voidaan siirtyä komentoluuppiin. Jos ei onnistu, tulostetaan
                // ohjelman päätösviesti, joka tulostetaan myös siinä tapauksessa, kun ohjelma palaa rakentajaan
                // luupin loputtua.
                if (dokumentitOnnistui && poistoListaOnnistui) {
                    luuppi();
                    System.out.println("Program terminated.");
                } else{
                    System.out.println("Program terminated.");
                }
            } else{
                System.out.println("Program terminated.");
            }  
        } else {
            System.out.println("Wrong number of command-line arguments!");
            System.out.println("Program terminated.");
        }
    }

    /**
     * Alku-metodi, jossa tulostetaan käyttäjälle alkutervehdys. 
     * Metodi ei tarvitse parametreja eikä se palauta mitään.
     */
    public static void alku() {
        System.out.println("Welcome to L.O.T.");
    }

    /***
     * Metodissa luodaan käyttäjän antamasta tiedostosta dokumenttikokoelma. Tiedostosta luetusta rivistä lähetetään 
     * dokumentteja lisäävälle ynnää-metodille string-muotoinen taulu, josta kyseinen metodi tekee lisäyksen. Metodi
     * tulostaa virheilmoituksen, jos tiedoston luku ei onnistu. 
     * <p>
     * @param komentoRivi on käyttäjän antama syöte, josta tarvittavat asiat luetaan.
     * @return true, jos syötteen luku onnistuu moitteetta. False, jos se epäonnistuu.
     */
    public boolean luoDokKokoelma(String[] komentoRivi) {
        Scanner tiedostoSkanneri = null;
        boolean lukuOnnistui = true;

        try {
            File kokoelmaTiedosto = new File(komentoRivi[0]);
            tiedostoSkanneri = new Scanner(kokoelmaTiedosto);

            while (tiedostoSkanneri.hasNextLine()) {
                String[] rivi = tiedostoSkanneri.nextLine().split("///");
                ynnää(rivi);
            }

            tiedostoSkanneri.close();
            return lukuOnnistui;

        } catch (FileNotFoundException e) {
            System.out.println("Missing file!");
            lukuOnnistui = false;
            return lukuOnnistui;
        }
    }

    /**
     * Metodissa luodaan käyttäjän antamista poistettavia sanoja sisältävästä
     * tiedostosta linkitetty lista, joka tallennetaan myöhempää käyttöä varten.
     * <p>
     * @param komentoRivi käyttäjän käynnistyksen yhteydessä antama syöte.
     * @return true, jos luku onnistui ja false, jos se epäonnistui.
     */
    public boolean luoPoistoKokoelma(String[] komentoRivi) {
        Scanner avainSanaSkanneri = null;
        boolean lukuOnnistui = true;

        try {
            File avainSanat = new File(komentoRivi[1]);
            avainSanaSkanneri = new Scanner(avainSanat);

            while (avainSanaSkanneri.hasNextLine()) {
                String apuSana = avainSanaSkanneri.nextLine();
                poistoSanat.add(apuSana);
            }

            avainSanaSkanneri.close();
            return lukuOnnistui;

        } catch (FileNotFoundException e) {
            System.out.println("Missing file!");
            lukuOnnistui = false;
            return lukuOnnistui;
        }

    }

    /**
     * Ensimmäinen komennontarkistus, jota käytetään pääasiassa komentosyötteitä
     * luettaessa. Metodi hajoittaa komennon aina välilyöntien kohdalta.
     * <p>
     * @param k on käyttäjän antama komento.
     * @return komennosta luodun string-tyyppisen taulun, jos komento ei ole tyhjä.
     *         Muuten se palauttaa tyhjäarvon.
     */
    public String[] kommennonTarkistusI(String k) {
        if (k != null) {
            String[] komentoTaulu = k.split(" ");
            return komentoTaulu;
        } else {
            return null;
        }
    }

    /**
     * Toista komentotarkistusta käytetään, kun halutaan lisätä uusi dokumentti
     * kokoelmaan. Komento katkotaan tässä kolmen kauttaviivan kohdalta ja jos siitä
     * syntyneen taulun pituus on oikea, erotellaan vielä ensimmäisessä
     * taulupaikassa olevat komento ja dokumentin tunniste toisistaan.
     * <p>
     * @param k käyttäjän antama komentosyöte.
     * @return lisättävän dokumentin tiedot, jos kaikki on kunnossa, muuten
     *         tyhjäarvo.
     */
    public String[] komennonTarkistusII(String k) {
        String[] splitti = k.split("///");

        if (splitti.length == 3) {
            String[] kt = splitti[0].split(" ");
            if(kt.length == 2){
                String[] lisättävät = { kt[1], splitti[1], splitti[2] };
                return lisättävät;
            } 
        }
        return null;
    }

    /**
     * Metodissa muodostetaan LocalDate-muotoinen päivämäärä string-muotoisesta
     * merkkijonosta.
     * <p>
     * @param p on syötteenä saatu päiväys string-muodossa.
     * @return LocalDate-muotoinen päivämäärä.
     */
    public LocalDate muodostaPvm(String p) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d.M.y");
        LocalDate pvm = LocalDate.parse(p, formatter);
        return pvm;
    }

    /***
     * Metodi tarkistaa, onko lisättävä dokumentti samaa tyyppiä kokoelman muiden dokumenttien kanssa.
     * Jos dokumentti on samaa tyyppiä tai kokoelma on tyhjä, palautetaan true. Muussa tapauksessa palautetaan
     * false.
     * <p>
     * @param tarkistettava on lisättävänä oleva dokumentti.
     * @return true, jos kokoelma ja tarkistettava dokumentti täsmäävät tai kokoelma on tyhjä, muuten false.
     */
    public boolean tyyppiTarkistus(Dokumentti tarkistettava){

        if(kokoelma.dokumentit().size() == 0){
            return true;
        } 
        if (kokoelma.dokumentit().get(0) instanceof Uutinen && tarkistettava instanceof Uutinen){
            return true;
        }
        if (kokoelma.dokumentit().get(0) instanceof Vitsi && tarkistettava instanceof Vitsi){
            return true;
        }
        return false;
    }

    /**
     * Metodi printtaa kokoelmassa olevat dokumentit käyttäjän syötteen mukaisesti
     * joko tunnisteen perusteella tai kaikki kerralla. Metodi tarkistaa komennon pituudesta, kumpaa
     * tapaa käyttäjä toivoo, ja jos pituus on 2, se tarkastaa, että haluttava dokumentti todella löytyy
     * kokoelmasta. Jos jokin menee pieleen, metodi heittää virheilmoituksen kutsujalleen.
     * <p>
     * @param k sisältää komennosta tehddyn yksinkertaisen komentotaulun.
     */
    public void printtaa(String[] k) {
        if (k.length == 1) {
            for (Dokumentti dokumentti : kokoelma.dokumentit()) {
                System.out.println(dokumentti.toString());
            }
        } else if (k.length == 2) {
            if (kokoelma.hae(Integer.parseInt(k[1])) != null) {
                System.out.println(kokoelma.hae(Integer.parseInt(k[1])));
            } else{
                throw new IllegalArgumentException();
            }
        } 
        else{
            throw new IllegalArgumentException();
        }
    }

    /**
     * Metodissa lisätään tiedosto kokoelmaan. Metodi hakee lisättävän dokumentin tunnistetta kokoelman dokumenteista.
     * Jos dokumenttia ei löydy tai se on ensimmäinen koko kokoelmassa, metodi tarkistaa 
     * millainen dokumentti on tyypiltään ja jos tyyppitarkistus menee läpi, metodi lisää dokumentin kokoelmaan. 
     * Muissa tapauksissa metodi lähettää virheilmoituksen takaisin metodia kutsuvalle, 
     * josta tulostetaan virheilmoitus. Metodi ei palauta mitään. 
     * <p>
     * @param tiedot sisältää lisättävän dokumentin tarpeelliset tiedot.
     */
    public void ynnää(String[] tiedot) {
        try{
            int tunniste = Integer.parseInt(tiedot[0]);

            // Tarkistetaan löytyykö lisättävän dokumentin tunniste kokoelmasta tai onko dokumentti ensimmäinen lisäys.
            // Jos kumpikaan ei pidä paikkaansa, heitetään virheilmoitus eteenpäin.
            if(kokoelma.hae(tunniste) == null || onkoEkaLisays) {

                // Tarkistetaan minkä tyyppinen lisättävänä oleva dokumentti on ja tehdään tyyppitarkistus.
                // Jos jokin menee pieleen, heitetään virheilmoitus eteenpäin. 
                if (tiedot[1].contains(".")){
                    LocalDate päiväys = muodostaPvm(tiedot[1]);
                    Uutinen uutinen = new Uutinen(tunniste, päiväys, tiedot[2]);
                    if (tyyppiTarkistus(uutinen)){
                        kokoelma.lisää(uutinen); 
                    } else {
                        throw new Exception();
                    }   
                } else {
                    Vitsi vitsi = new Vitsi(tunniste, tiedot[1], tiedot[2]);
                    if (tyyppiTarkistus(vitsi)){
                        kokoelma.lisää(vitsi);
                    }
                    else {
                        throw new Exception();
                    }
                }
            } else {
                throw new Exception();
            }

        // Jonkin mennessä pieleen heitetään IllegalArgumentException metodin kutsujalle, 
        // joka tulostaa virheilmoituksen.
        } catch(Exception e){
            throw new IllegalArgumentException();
        }
    }

    /**
     * Metodissa etsitään, onko käyttäjän syöttämää avainta kokoelmassa vai ei. Parametreinä
     * annetut avainsanoista jokainen esiintyy dokumentissa vähintään kerran ja niiden pitää esintyä
     * dokumentissa sellaisenaan. Ennen etsintää käyttäjän syötteestä muodostetaan lista,
     * josta poistetaan ensimmäisenä oleva komento, jotta sanoja voidaan helposti etsiä. Jos
     * jokin ei onnistu, tulostetaan virheilmoitus.
     * <p>
     * @param k on käyttäjän antamasta komennosta tehty merkkijonotaulu.
     */
    public void löytäjä(String[] k) {
        try{
            LinkedList<String> etsittävät = new LinkedList<String>();
            for (String sana : k) {
                etsittävät.add(sana);   
            }
            etsittävät.removeFirst();

            for (Dokumentti dokumentti : kokoelma.dokumentit()) {
                if(dokumentti.sanatTäsmäävät(etsittävät)){
                    System.out.println(dokumentti.tunniste());
                }
            }
        } catch(Exception e){
            System.out.println("Error!");
        }
    }

    /**
     * Poistometodissa etsitään käyttäjän parametrina antamaa dokumentin tunnistetta
     * kokoelman dokumenteista ja jos vastaava tunniste löytyy ja komento on oikean pituinen, dokumentti poistetaan.
     * Muussa tapauksessa tulostetaan virheilmoitus.
     * <p>
     * @param k on käyttäjän syötteenä antamasta komennosta tehty taulu.
     */
    public void poista(String[] k){
        try{
            int poisto = Integer.parseInt(k[1]);
            Dokumentti poistettava = kokoelma.hae(poisto);
            OmaLista<Dokumentti> apulainen = kokoelma.dokumentit();

            if(poistettava != null && k.length == 2){
                apulainen.remove(poistettava);
            } else {
                throw new Exception();
            }
        }
        catch(Exception e){
            System.out.println("Error!");
        }
    }

    /**
     * Metodissa tarkistaa ensin, että käyttäjän antama komentokehoite on oikean pituinen.
     * Jos näin on, se käy yksitellen läpi kokoelman jokaisen dokumentin ja lähettää sen dokumentti-luokassa
     * yliajetulle siivoa-metodille muokattavaksi komentosyötteessä saamiensa välimerkkien ja ohjelman alussa
     * muodostetun sulkusanalistan kanssa. Jos jokin ei onnistu, metodi tulostaa virheilmoituksen.
     * <p>
     * @param k on käyttäjän antamasta komentosyötteestä tehty taulu.
     */
    public void puunaus(String[] k){
        try{
            if(k.length == 2){
                String välimerkit = k[1];
                for(Dokumentti dokumentti: kokoelma.dokumentit()){
                    dokumentti.siivoa(poistoSanat, välimerkit);
                }
            }
            else{
                throw new Exception();
            }  
        }
        catch(Exception e){
            System.out.println("Error!");
        }
    }

    /**
     * Metodissa pyöritetään käyttöliittymän perustoiminnallisuutta, eli komentosyötettä ja
     * komentojen toiminnallisuuksia. Jos komento on väärä, syötetään virheilmoitus. Metodi ei
     * palauta mitään eikä sillä ole parametreja.
     */
    public void luuppi(){
        // Luodaan apumuuttuja luupin pyöritystä varten.
        boolean jatko = true;
        Scanner skanneri = new Scanner(System.in);

        // Niin kauan, kuin apumuuttuja on tosi, luuppi pyörii kysyen käyttäjältä syötteitä.
        while(jatko){
            System.out.println("Please, enter a command:");
            String komento = skanneri.nextLine();
            // Tarkastetaan, onko kommennon kaiuttaminen tarpeellista.
            if(kaikuuko){
                System.out.println(komento);
            }

            // Käsitellään syöte tauluksi, jonka sisältöä tarkastellaan omissa if-kohdissa. Jos komento ei sisälly 
            // mihinkään if-kohdista, tulostetaan virheilmoitus.
            String[] komentoTaulu = kommennonTarkistusI(komento);
            if(komentoTaulu[0].equals(KAIKU)){
                kaikuuko = true;
                System.out.println("echo");
            }
            // Yritetään printata komennon mukaisesti. Jos komentokutsu saa bumerangina takaisin 
            // IllegalArgumentExceptionin, tulostetaan virheilmoitus.
            else if(komentoTaulu[0].equals(PRINT)){
                try{
                    printtaa(komentoTaulu);
                } catch(IllegalArgumentException e){
                    System.out.println("Error!");
                }   
            } 
            // Muodostetaan komennosta toinen versio, joka lähetetään ynnää-metodille jos sen paluuarvo ei ole null.
            // Jos jokin epäonnistuu, tulostetaan virheilmoitus.
            else if(komentoTaulu[0].equals(ADD)){
                try{
                    String[] komentoTiedot = komennonTarkistusII(komento);
                    if (komentoTiedot != null){
                        ynnää(komentoTiedot); 
                    } else {
                        throw new IllegalArgumentException();
                    }
                } catch(IllegalArgumentException e){
                    System.out.println("Error!");
                }   
            } 
            else if(komentoTaulu[0].equals(FIND)){
                löytäjä(komentoTaulu);
            } 
            else if(komentoTaulu[0].equals(REMOVE)){
                poista(komentoTaulu);
            } 
            else if(komentoTaulu[0].equals(POLISH)){
                puunaus(komentoTaulu);
            } 
            else if(komentoTaulu[0].equals(RESET)){
                kokoelma = new Kokoelma();
                luoDokKokoelma(komentoRiviKopio);
            } 
            else if(komentoTaulu[0].equals(QUIT)){
                skanneri.close();
                jatko = false;
            } 
            else{
                System.out.println("Error!");
            }
        }
    }   
}