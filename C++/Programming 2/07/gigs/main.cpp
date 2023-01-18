/* COMP.CS.110 Projekti 2: Keikkakalenteri
 * ===========================
 *
 * Ohjelman tarkoituksena on toimia yksinkertaisena keikkakalenterina,
 * johon käyttäjä voi lisätä artisteja ja keikkoja tekstitiedoston
 * perusteella koottuun tietokantaan. Sen lisäksi se listaa itse
 * keikkapaikat ja kertoo paikan esiintyjät. Keikkoja voi myös poistaa
 * päivämäärän perusteella.
 *
 * Artisteilla ei voi olla kahta keikkaa samana päivänä ja lavalla ei voi
 * olla samaan aikaan useampaa keikkaa. Sen lisäksi ohjelma tarkistaa käyttäjän
 * antaman syötteen oikeellisuuden.
 *
 * Ohjelma käyttää seuraavia komentoja:
 * ARTISTS : Tulostaa kaikki ohjelman tietämät artistit listauksena.
 * ARTIST <artistin nimi> : Tulostaa kaikki artistin keikat nähtäville;
 * niiden päivämäärän, kaupungin ja esiintymislavan.
 * STAGES : Tulostaa kaikki tiedetyt keikkapaikat.
 * STAGE <lavan nimi> : Tulostaa kaikki ne artistit, joilla on keikka
 * annetussa paikassa.
 * ADD_ARTIST <artistin nimi> : Lisää syötteessä annetun artistin tietokantaan.
 * ADD_GIG <artistin nimi> <päivämäärä> <kaupungin nimi> <lavan nimi> :
 * Lisää artistille uuden keikan kalenteriin annetulla päivämäärällä, kaupungilla,
 * ja lavalla.
 * CANCEL <artistin nimi> <päivämäärä> : Peruu kaikki artistin keikat annetun
 * päivämäärän jälkeen.
 *
 * Huom! Käyttäjän syöttämän datan tulee olla muodossa
 * artistin_nimi;päivämäärä;kaupungin_nimi;lavan_nimi. Jos nimissä on useampi
 * osa ne tulee laittaa "-merkkien väliin (esimerkiksi "Kaija Koo").
 * Muussa tapauksessa ohjelma lopettaa suorituksensa virheellisen syötemuodon takia.
 *
 * Ohjelman kirjoittaja
 * Nimi: Eveliina Toivanen
 * E-Mail: toivanen.eveliinarai@gmail.com
 *
 *
 * */


#include <iostream>
#include <fstream>
#include <string>
#include <vector>
#include <map>
#include<bits/stdc++.h>
#include <set>


struct Gig{
    std::string date,
                city,
                stage;
};

using Gig_info = std::map<std::string, std::vector<Gig>>;
using Stage_info = std::map<std::string, std::vector<std::string>>;

// Kaukaisin vuosi, jonne keikkoja voi tallentaa.
const std::string FARTHEST_POSSIBLE_YEAR = "2030";


// Kasuaali split-funktio. Jos erotin on merkkien " välissä, jättää erottimen huomioimatta.
std::vector<std::string> split(const std::string& str, char delim = ';')
{
    std::vector<std::string> result = {""};
    bool inside_quotation = false;
    for ( char current_char : str )
    {
        if ( current_char == '"' )
        {
            inside_quotation = not inside_quotation;
        }
        else if ( current_char == delim and not inside_quotation )
        {
            result.push_back("");
        }
        else
        {
            result.back().push_back(current_char);
        }
    }
    if ( result.back() == "" )
    {
        result.pop_back();
    }
    return result;
}


// Tarkastaa, onko annettu päivämäärä validi, eli se on formaatissa
// pp-kk-vvvv (dd-mm-yyyy) ja että se on muulla tavoin myös mahdollinen päivämäärä
bool is_valid_date(const std::string& date_str)
{
    std::vector<std::string> date_vec = split(date_str, '-');
    if ( date_vec.size() != 3 )
    {
        return false;
    }

    std::string year = date_vec.at(0);
    std::string month = date_vec.at(1);
    std::string day = date_vec.at(2);
    std::vector<std::string> month_sizes
            = { "31", "28", "31", "30", "31", "30",
                "31", "31", "30", "31", "30", "31" };

    if ( month < "01" or month > "12" )
    {
        return false;
    }
    if ( year < "0001" or year > FARTHEST_POSSIBLE_YEAR )
    {
        return false;
    }
    unsigned int year_int = stoi(year);
    bool is_leap_year = (year_int % 400 == 0) or
                        (year_int % 100 != 0 and year_int % 4 == 0);
    if ( day >= "01" and
        (day <= month_sizes.at(stoi(month) - 1) or
        (month == "02" and is_leap_year and day <= "29")) )
    {
        return true;
    }
    else
    {
        return false;
    }
}


// Funktion tarkoitus on tarkistaa, että parametrina annettu vektori
// ei ole tyhjä. Jos vektorissa on tyhjä kohta, funktio palauttaa falsen,
// muuten se palauttaa true.
bool is_not_empty(std::vector<std::string> parts)
{
    for(unsigned long int i=0; i< parts.size(); i++)
    {
        if(parts[i] == "\0")
        {
            return false;
        }
    }

    return true;
}


// Funktio tarkastaa, sisältyykö parametrinaan saamaansa vektoriin toisena
//parametrinaan saama elementti. Palauttaa kutsujalleen totuusarvon.
bool contains(std::vector<std::string> vector, const std::string & element)
{
    bool result = false;
    for (auto & vec_elem : vector)
    {
        if (vec_elem == element)
        {
            result = true;
            break;
        }
    }
    return result;
}


// Tarkistaa, onko keikkapaikka käytettävissä, vai onko siellä jo sovittu keikka samalle päivälle.
// Jos keikkapaikka on vapaa, palauttaa true, ja jos keikkapaikka on varattu, palauttaa false.
bool is_venue_available(std::string date, std::string venue, Gig_info &gigs)
{
    for(auto  it = gigs.begin(); it != gigs.end(); ++it)
    {
        std::vector<Gig> gig_list = gigs.at(it->first);
        for(auto &gig : gig_list)
        {
            if(gig.stage == venue && gig.date == date)
            {
                return false;
            }
        }
    }

    return true;

}


// Tarkistaa, onko artistille sovittu jo keikka samalle päivälle, vai onko hän käytettävissä.
// Jos artisti on vapaa, palauttaa true, ja artisti on varattu, palauttaa false.
bool is_artist_available(std::string date, std::string artist, Gig_info &gigs)
{
    std::vector<Gig> gig_list = gigs.at(artist);
    for(auto &gig : gig_list)
    {
        if(gig.date == date)
        {
            return false;
        }
    }

    return true;
}

// Tarkistaa löytyykö keikkapaikkaa tallennetuista paikoista.
// Palauttaa true, jos keikkapaikka on listassa ja false, kun se ei ole.
bool is_stage_real(std::string stage, Stage_info &stages)
{
    std::vector<std::string> stage_list;

    for(auto  it = stages.begin(); it != stages.end(); ++it)
    {
        stage_list = stages.at(it->first);
        if(contains(stage_list, stage))
        {
            return true;
        }
    }

    return false;
}


// Tarkistaa, löytyykö parametrina saatu artisti tallennettuna tietorakenteeseen
// vai ei.
bool is_artist_listed(std::string artist, Gig_info &gigs)
{
    if(gigs.find(artist) == gigs.end())
    {
        return false;
    }
    else{
        return true;
    }

}


// Lisää parametrinaan saaman artistin keikkakalenteriin, jos artistia ei vielä ole olemassa.
void add_artist(std::string new_artist, Gig_info &gigs, bool added_in_the_program = false)
{
    if(!is_artist_listed(new_artist, gigs))
    {
        gigs.insert({new_artist, {}});

        // Jos artisti lisätään ohjelman sisällä, tulostetaan siitä ilmoitus.
        if(added_in_the_program)
        {
            std::cout << "Artist added." << std::endl;
        }
    }
    else
    {
        std::cout << "Error: Already exists." << std::endl;
    }
}


// Funktio luo pyydetysti mapin, johon avaimena talletetaan kaupunki ja arvoihin vektori
// kaupungin keikkapaikoista.
void make_stage_list(std::string city, std::string stage, Stage_info &stages)
{
    if(stages.find(city) == stages.end())
    {
        stages.insert({city, {}});
        stages.at(city).push_back(stage);
    }
    else{
        std::vector<std::string> gigs = stages.at(city);
        if(not contains(gigs, stage)){
            stages.at(city).push_back(stage);
        }
    }
}

// Lisää parametrinaan saaman keikan tiedot keikkakalenteriin, jos artisti on lisättynä.
// Tulostaa virheilmoituksen, jos päivämäärä on väärää laatua, artistia ei löydy, tai keikkapaikka
// tai artisti on jo buukattu annetulle päivälle.
void add_gig(std::vector<std::string> info_parts, Gig_info &gigs, Stage_info &stages, bool added_in_the_program = false)
{
    std::string artist = info_parts.at(0);
    std::string date = info_parts.at(1);
    std::string city = info_parts.at(2);
    std::string stage = info_parts.at(3);

    Gig gig = {date,
               city,
               stage};

    if(is_artist_listed(artist, gigs))
    {
        if(is_valid_date(date))
        {
            if(is_artist_available(date, artist, gigs) && is_venue_available(date, stage, gigs))
            {
                gigs.at(artist).push_back(gig);
                make_stage_list(city, stage, stages);

                // Jos keikka lisätään ohjelman sisällä, tulostetaan siitä ilmoitus.
                if(added_in_the_program)
                {
                    std::cout << "Gig added." << std::endl;
                }
            }
            else
            {
                std::cout << "Error: Already exists." << std::endl;
            }
        }
        else{
            std::cout << "Error: Invalid date." << std::endl;
        }
    }
    else{
        std::cout << "Error: Not found." << std::endl;
    }
}




// Funktio tulostaa kaikki tietorakenteeseen tallennetut artistit aakkosjärjestyksessä listana.
void print_artist_list(Gig_info &gigs)
{
    std::cout << "All artists in alphabetical order:" << std::endl;
    for(auto &artist : gigs)
    {
        std::cout << artist.first << std::endl;
    }
}


// Funktio järjestää artistin tietokantaan tallennetut keikat aikajärjestykseen
// apumuuttujien avulla.
std::vector<Gig> put_gigs_in_order(std::vector<Gig> artists_gigs)
{
    std::vector<Gig> gigs_in_order;
    std::vector<std::string> dates;
    std::string date_order_helper;

    for(auto &gig : artists_gigs)
    {
        date_order_helper = gig.date;
        dates.push_back(date_order_helper);
    }

    std::sort(dates.begin(), dates.end());

    for(auto &date : dates)
    {
        for(auto &gig : artists_gigs)
        {
            if(date == gig.date)
            {
                gigs_in_order.push_back(gig);
            }
        }
    }
    return gigs_in_order;
}


// Tarkistaa parametrina annetun artistin keikkakalenterin ja tulostaa sen aikajärjestyksessä.
void check_artists_calendar(std::string artist, Gig_info &gigs)
{
    if(is_artist_listed(artist, gigs))
    {
        std::cout << "Artist " << artist <<
                     " has the following gigs in the order they are listed:" << std::endl;

        std::vector<Gig> gig_list = put_gigs_in_order(gigs.at(artist));
        for(auto &gig : gig_list)
        {
            std::cout << " - " << gig.date << " : " <<
                         gig.city << ", " << gig.stage << std::endl;
        }
    }
    else
    {
        std::cout << "Error: Not found." << std::endl;
    }
}


// Funktio tulostaa kaikki tietorakenteeseen tallennetut keikkapaikat listamuodossa.
void print_stage_list(Stage_info &stages)
{
    std::cout << "All gig places in alphabetical order:" << std::endl;
    for(auto  it = stages.begin(); it != stages.end(); ++it)
    {
        std::sort(it->second.begin(), it->second.end());
        for(auto &venue : it->second)
        {
            std::cout << it->first << ", " << venue << std::endl;
        }
    }
}


// Funktio tulostaa keikkapaikan artistikattauksen listaksi käyttäjän nähtäville.
void check_stage_calendar(std::string stage, Gig_info &gigs, Stage_info &stages)
{
    if(is_stage_real(stage, stages)){
        std::cout << "Stage " << stage <<" has gigs of the following artists:" << std::endl;
        std::set<std::string> stage_artists; // Apumuuttuja keikkapaikan artisteista tulostusta varten.

        for(auto  it = gigs.begin(); it != gigs.end(); ++it)
        {
            std::vector<Gig> gig_list = gigs.at(it->first);
            for(auto &gig : gig_list)
            {
                if(gig.stage == stage)
                {
                    stage_artists.insert(it->first);
                }
            }
        }

        for(auto &artist : stage_artists)
        {
            std::cout << " - " << artist << std::endl;
        }
    }
    else{
        std::cout << "Error: Not found." << std::endl;
    }

}


// Poistaa keikkapaikan, jos sillä ei ole enää osoitettavissa
// keikkoja. Funktio luo ensin apusetin artistien käyttämistä
// keikkapaikoista, joka käydään toisessa for-luupissa läpi
// verraten tietoja olemassa olevaan paikkalistaan. Jos
// paikkalistan paikkaa ei löydy, se poistetaan listalta.
void stage_remover(Gig_info &gigs, Stage_info &stages)
{
    std::set<std::string> used_stages;

    for(auto  it = gigs.begin(); it != gigs.end(); ++it)
    {
        std::vector<Gig> gig_list = gigs.at(it->first);
        for(auto &gig : gig_list)
        {
            used_stages.insert(gig.stage);
        }

    }

    for(auto  it = stages.begin(); it != stages.end(); ++it)
    {
        std::vector<std::string> venue_list = stages.at(it->first);
        for(auto &stage : venue_list)
        {
            if(used_stages.find(stage) == used_stages.end())
            {
                auto it = find(venue_list.begin(), venue_list.end(), stage);
                venue_list.erase(it);
            }
        }

        stages.at(it->first) = venue_list;
    }

}


// Funktio poistaa annetun päivämäärän jälkeiset keikat parametrinaan saaman artistin
// kalenterista. Se tarkistaa ensin päivämäärän oikeeellisuuden ja etsii sitten
// löytyykö artsitin keikkakattauksesta poistettavia päivämääriä. Ne keikat, jotka
// eivät ole poistettavien listalla tallennetaan apuvektoriin, joka kopioidaan
// alkuperäisen vektorin paikalle.
void cancel_after_given_date(std::string artist, std::string date, Gig_info &gigs)
{
    if(is_artist_listed(artist, gigs))
    {
        if(!is_valid_date(date))
        {
            std::cout << "Error: Invalid date." << std::endl;
        }
        else
        {
            std::vector<Gig> gig_list = put_gigs_in_order(gigs.at(artist));
            std::vector<Gig> gig_list_helper;

            for(auto &gig : gig_list)
            {
                if(gig.date <= date)
                {
                    gig_list_helper.push_back(gig);
                }
            }

            if(gig_list_helper.size() < gig_list.size())
            {
                gigs.at(artist) = gig_list_helper;
                std::cout << "Artist's gigs after the given date cancelled." << std::endl;
            }
            else{
                std::cout << "Error: No gigs after the given date." << std::endl;
            }
        }

    }
    else{
        std::cout << "Error: Not found." << std::endl;
    }

}


// Funktion tehtävänä on tarkistaa parametrina annetun keikkainfon oikeellisuus,
// kun se ajetaan tiedostosta tietorakenteeseen. Funktio tarkistaa järjestyksessä
// parametreinaan saaman päivämäärän oikeellisuuden, keikkapaikan saatavuuden ja
// artistin saatavuuden. Tulostaa virheilmoitukset, jos nämä eivät käyt toteen.
bool gig_list_checkpoint(std::vector<std::string> parts, Gig_info &gigs, Stage_info &stages)
{
    std::string artist = parts.at(0);
    std::string date = parts.at(1);
    std::string city = parts.at(2);
    std::string stage = parts.at(3);

    if(is_valid_date(date))
    {
        if(is_venue_available(date, stage, gigs))
        {
            if(gigs.find(artist) == gigs.end())
            {
                add_artist(artist, gigs);
            }
            if(is_artist_available(date, artist, gigs))
            {
                add_gig(parts, gigs, stages);
            }
            else{
                std::cout << "Error: Already exists." << std::endl;
                return false;
            }

        }
        else{
            std::cout << "Error: Already exists." << std::endl;
            return false;
        }
    }
    else{
        std::cout << "Error: Invalid date." << std::endl;
        return false;
    }

    return true;
}


// Funktio lukee ja käsittelee käyttäjän syöttämän tekstitiedoston. Jos lukemisessa
// tulee esteitä, tulostaa virheilmoituksen.
bool check_data_from_file(std::ifstream &input_file, Gig_info &gigs, Stage_info &stages)
{
    if(!input_file)
    {
        std::cout << "Error: File could not be read." << std::endl;
        return false;
    }
    else
    {
        std::string line;
        std::vector<std::string> line_parts;

        while(std::getline(input_file, line))
        {
            line_parts = split(line);

            if(line_parts.size() == 4 && is_not_empty(line_parts))
            {
                if(!gig_list_checkpoint(line_parts, gigs, stages))
                {
                    return false;
                }
            }
            else
            {
                std::cout << "Error: Invalid format in file." << std::endl;
                return false;
            }
        }

        input_file.close();
        return true;
    }

}

// Pääohjelma. Pitää sisällään päätietorakenteet, joita
// käytetään ohjelmassa, sekä käyttäjän syötteen luvun.
int main()
{
    Gig_info gigs = {};      // Artistien keikkatietojen tallennuspaikka.
    Stage_info stages = {};  // Keikkapaikkojen listauksen tallennuspaikka.

    std::string file_name;
    std::cout << "Give a name for input file: ";
    std::getline(std::cin, file_name);

    // Jos jokin menee tiedoston luvussa pieleen, ohjelma lopettaa toiminnan.
    std::ifstream input_file(file_name);
    if(!check_data_from_file(input_file, gigs, stages))
    {
        return EXIT_FAILURE;
    }

    while(true)
    {
        std::string command_line;
        std::string command;
        std::vector<std::string> command_parts;
        std::cout << "gigs> ";
        getline(std::cin, command_line);
        command_parts = split(command_line, ' ');

        // Otetaan komento erilleen ja muutetaan se isoiksi kirjaimiksi.
        command = command_parts.at(0);
        transform(command.begin(), command.end(),
                  command.begin(), ::toupper);

        if(command == "ARTISTS")
        {
            print_artist_list(gigs);
        }
        else if(command == "ARTIST" && command_parts.size() >= 2)
        {
            std::string artist = command_parts.at(1);
            check_artists_calendar(artist, gigs);
        }
        else if(command == "ADD_ARTIST" && command_parts.size() >= 2)
        {
            std::string artist = command_parts.at(1);
            add_artist(artist, gigs, true);
        }
        else if(command == "ADD_GIG" && command_parts.size() >= 5)
        {
            command_parts.erase(command_parts.begin());
            add_gig(command_parts, gigs, stages, true);
        }
        else if(command == "STAGES")
        {
            print_stage_list(stages);
        }
        else if(command == "STAGE" && command_parts.size() >= 2)
        {
            std::string stage = command_parts.at(1);
            check_stage_calendar(stage, gigs, stages);
        }
        else if(command == "CANCEL" && command_parts.size() >= 3)
        {
            std::string artist = command_parts.at(1);
            std::string date = command_parts.at(2);
            cancel_after_given_date(artist, date, gigs);
            stage_remover(gigs, stages);

        }
        else if(command == "QUIT")
        {
            return EXIT_SUCCESS;
        }
        else
        {
            std::cout << "Error: Invalid input." << std::endl;
        }
    }

    return EXIT_SUCCESS;
}
