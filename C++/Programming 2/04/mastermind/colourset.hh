/*
 * Ohjelman kirjoittaja
 * Nimi: Eveliina Toivanen
 * E-Mail: toivanen.eveliinarai@gmail.com
 *
 */

#ifndef COLOURSET_HH
#define COLOURSET_HH

#include <string>
#include <iostream>
#include <vector>

// Esitellään luokka ja viitataan käytössä olevaan Board-luokkaan.
class Colourset;
using Board = std::vector< std::vector< Colourset > >;


class Colourset
{
public:
    // Värisarjavektori ja se, onko se salainen, rakentajan parametreina.
    Colourset(const std::vector<std::string> line);
    ~Colourset();

    std::vector<std::string> get_colourline() const;

    // Tarkistaa oikeilla paikoilla olevat värit ja värit, jotka ovat väärässä paikassa.
    void right_colour(Colourset secret);

    // Tulostaa värisuoran ja sen tulokset väreistä ja niiden sijainneista.
    void print_status();

    // Tarkistaa, onko värisuora voittaja, eli onko oikeita värejä oikeissa paikoissa neljä.
    bool has_won();

private:

    std::vector<std::string> colourline_;     // Värisarjavektori
    //Board* board_;                            // Taulukko, johon värisarja on lisätty.
    int right_colour_ = 0;                    // Oikeiden värien määrä, väärissä sijainneissa
    int right_colour_and_position_ = 0;       // Oikeiden värien määrä väärissä sijainneissa



};

#endif // COLOURSET_HH
