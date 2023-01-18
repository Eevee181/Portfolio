/* Mastermind
 *
 * Ohjelman kuvaus:
 *    Ohjelma toteuttaa Mastermind-pelin, jossa arvuutellaan värejä.Pelin
 * tarkoitus on, että käyttäjä pyrkii arvaamaan tämän salaisen värisarjan. Sen, mitä värejä
 * käytetään ja missä järjestyksessä. Syötteenä käytetään värien englanninkielisten nimien
 * ensimmäisiä alkukirjaimia ja syötteeksi kelpaa sekä isot, että pienet kirjaimet. Ohjelma
 * tarkistaa, että kaikki annetut värit kuuluvat sallittuihin väreihin ja kertoo pelin
 * loputtua voitosta tai häviöstä, mikäli käyttäjä ei keskeytä pelaamista.
 *
 * Pelin alustus:
 *     Käyttäjältä kysytään ensin, haluaako tämä arpoa vai antaa
 * salaisena pidettävän neljän värin suoran. (Jälkimmäisen hyödyt näkyvät
 * lähinnä ohjelman testaamisessa. Sama väri voi esiintyä sarjassa useita kertoja,
 * mutta mikään sarjan positioista ei voi olla tyhjä. Arvottaessa, käyttäjältä
 * pyydetään satunnaislukugeneraattorille annettavaa siemenlukua ja jälkimmäisessä
 * pyydetään antamaan käyttäjän haluama värisarja.
 *
 * Pelin kulku:
 * Käyttäjällä on kymmenen kierrosta käytettävänä, ja jokaisella hänen tulee syöttää
 * uusi arvaus. Ohjelma ilmoittaa, kuinka monta käyttäjän antamista väreistä on täysin
 * oikein (väri on myös oikeassa positiossa) ja kuinka monta annetun arvauksen väreistä
 * on oikein värin kohdalta (oikea väri, väärä paikka). Peli päättyy voittoon, mikäli
 * käyttäjä onnistuu arvaamaan oikean värisuoran tai häviöön, mikäli käyttäjä ehtii
 * käyttämään kaikki arvauskertansa ennen oikean suoran löytymistä. Käyttäjä voi myös
 * keskeyttää pelin syöttämällä ohjelmalle q-kirjaimen.
 *
 * Ohjelman kirjoittaja
 * Nimi: Eveliina Toivanen
 * E-Mail: toivanen.eveliinarai@gmail.com
 *
 * Huomioita ohjelmasta ja sen toteutuksesta:
 *
 * */

#include "colourset.hh"
#include <iostream>
#include <vector>
#include <random>
#include <string>
#include <sstream>

// Arvauksien maksimilukumäärä.
const unsigned int GUESS_MAX = 10; // Ei käytössä, vielä


// Värisarjan värien lukumäärä.
const unsigned int SIZE = 4;


// Suffiksi osan pituus riviä tulostaessa.
// Suffiksi koostuu kolmesta pystyviivasta ('|') ja kahdesta numerosta, joista
// ensimmäinen kertoo myös sijoitukseltaan oikein menneiden värien määrän ja
// jälkimmäinen oikein menneiden värien määrän sijoituksesta riippumatta.
const unsigned int SUFFIX_LENGTH_IN_PRINT = 5;


// Teksti, joka printataan ohjelman alussa.
const std::string INFO_TEXT = "Colors in use: \
B = Blue, R = Red, Y = Yellow, G = Green, O = Orange, V = Violet";


// Merkkijono, joka sisältää sallitut ilmaisut väreille.
const std::string COLOURS_ALPHABET = "BbRrYyGgOoVv";


// Tarkastaa, onko käyttäjän antaman merkkijonon arvot oikeita värejä.
bool is_good_colours(std::string colours){
    unsigned long int good_value = 0;

    if(colours.size() == SIZE){
        for(char colour:colours){
            for(char alphabet : COLOURS_ALPHABET){
                if(colour == alphabet){
                    good_value += 1;
                }
            }
        }

        if(good_value == SIZE){
            return true;
        }

    }else{
        std::cout << "Wrong size" << std::endl;
        return false;
    }

    std::cout << "Unknown color" << std::endl;
    return false;
}


// Muuntaa käyttäjän antaman merkkijonon vektorimuotoon.
std::vector<std::string> set_vector(std::string colours){
    std::vector<std::string> line;
    std::string tmp;

    for(int i = 0; i < 4; i++){
        tmp = toupper(colours.at(i));
        line.push_back(tmp);
    }

    return line;
}


// Arpoo generaattorin avulla satunnaisen salaisen värisuoran.
// Saa parametrina merkkijonon seed, jossa on käyttäjän antama
// siemenluku ja palauttaa satunnaisgeneraattorin avulla luodun
// salaisen värisuoran.
std::vector<std::string> get_random_secret(std::string seed){
    std::string colours = "BRYGOV";
    std::default_random_engine rand_generator;

    //Käsitellään käyttäjän antama siemenluku.
    if( seed == "" ) {
        rand_generator.seed( time(NULL) );
    } else {
        rand_generator.seed( stoi(seed) );
    }

    std::uniform_int_distribution<int> distr(0, 3);
    std::ostringstream oss;

    // Arvotaan satunnaisvärit ja luodaan niistä vektori.
    for (std::size_t i = 0; i <= 4; ++i){
        oss << colours[distr(rand_generator)];
    }

    std::string random_string = oss.str();
    std::vector<std::string> secret = set_vector(random_string);

    return secret;

}


// Lukee käyttäjän syötteen, joko satunnaisesti tai listaamalla,
// ja täyttää salaisen värisarjan käyttäjän haluamalla tavalla.
// Toistaa kysymystä, kunnes käyttäjä kirjoittaa joko R:n tai L:n.
// Palauttaa käyttäjän antamien tietojen perusteella luodun salaisen
// värisarjan.
std::vector<std::string> get_secret_line(){
    std::vector<std::string> secret_line;
    bool ask_input = true;

    while(ask_input){
        std::cout << "Enter an input way (R = random, L = list): ";
        std::string input_str = "";
        std::cin >> input_str;

        // Luodaan satunnaisesti vektori, jos käyttäjä antaa syötteenä R tai r.
        if(input_str == "R" or input_str == "r"){
            std::cout << "Enter a seed value: ";
            std::string seed;
            std::cin >> seed;

            secret_line = get_random_secret(seed);

            ask_input = false;

        }

        // Luodaan käyttäjän antamista väreistä vektori.
        else if(input_str == "L" or input_str == "l"){
            bool accepted = false;

            while(not accepted){
                std::cout << "Enter four colors (four letters without spaces): ";
                std::string colours = "";
                std::cin >> colours;
                if(is_good_colours(colours)){
                    secret_line = set_vector(colours);
                    accepted = true;
                }
            }

            ask_input = false;

        }else{
            std::cout << "Bad input" << std::endl;
        }
    }

    return secret_line;

}


// Tulostaa rivin, joka koostuu annetusta merkistä c.
// Rivin pituus annetaan parametrissä line_length.
void print_line_with_char(char c, unsigned int line_length){
    for(unsigned int i = 0; i < line_length; ++i){
        std::cout << c;
    }

    std::cout << std::endl;
}


// Tulostaa kaikki värisarjat parametrinaan saamastaan taulukosta.
void print_all(Board& board){
    print_line_with_char('=', 2 * (SIZE + SUFFIX_LENGTH_IN_PRINT) + 1);

    // Käydään läpi ensin taulukkoon lisätyt sarjavektorit, sen jälkeen
    // käydään läpi sarjavektoreihin lisätyt väriluokat ja lähetetään tulostuskutsu.
    for(const std::vector< Colourset > &sets : board){
        for(Colourset colours: sets){
            colours.print_status();
        }
    }

    print_line_with_char('=', 2 * (SIZE + SUFFIX_LENGTH_IN_PRINT) + 1);
}


// Sisältää varsinaisen pelisilmukan toteutuksen, jossa käyttäjän antamat
// arvaukset luetaan ja niitä verrataan salaiseen väririviin.
// Jokaisella kierroksella tulostetaan kaikki tähän mennessä annetut rivit.
int main(){
    Board board;
    bool win = false;
    std::vector< Colourset > set_row;

    std::cout << INFO_TEXT << std::endl;
    print_line_with_char('*', INFO_TEXT.size());

    std::vector<std::string> secret_line = get_secret_line();
    Colourset secret_set(secret_line);

    // Pelin pyöritys: otetaan käyttäjän arvaukset syötteenä, tarkastetaan
    // ja lisätään arvaus tulostettavaan taulukkoon.
    for(unsigned int i = 0; i < GUESS_MAX; i++){
        std::cout << "ROW> ";
        std::string guess;
        std::cin >> guess;

        // Tarkistetaan haluaako käyttäjä keskeyttää pelin.
        if(guess == "Q" or guess == "q"){
            win = true; //Käytetään tässä, jotta häviötuloste ei tulostu funktion lopussa.
            break;
        }

        // Arvatun värisuoran tarkastustoimenpiteet.
        else if(is_good_colours(guess)){
            std::vector<std::string> colour_guess = set_vector(guess);
            Colourset new_guess(colour_guess);

            new_guess.right_colour(secret_set);

            set_row.push_back(new_guess);
            board.push_back(set_row);

            print_all(board);

            if(new_guess.has_won()){
                win = true;
                break;
            }

            set_row.clear();
        }
    }

    if(not win){
        std::cout << "You lost: Maximum number of guesses done" << std::endl;
    }

    return 0;
}

