/*
 * Ohjelman kirjoittaja
 * Nimi: Eveliina Toivanen
 * E-Mail: toivanen.eveliinarai@gmail.com
 *
 */

#include <iostream>
#include <fstream>
#include <string>
#include <vector>
#include <unordered_map>

const std::string HELP_TEXT = "S = store id1 i2\nP = print id\n"
                              "C = count id\nD = depth id\n";

using NETWORK = std::unordered_map<std::string, std::vector<std::string>>;

// Funktio katkoo syötteeseen annetun komennon ja
// tekee niistä string-muotoisen vektorin.
std::vector<std::string> split(const std::string& s,
                               const char delimiter,
                               bool ignore_empty = false)
{
    std::vector<std::string> result;
    std::string tmp = s;

    while(tmp.find(delimiter) != std::string::npos)
    {
        std::string new_part = tmp.substr(0, tmp.find(delimiter));
        tmp = tmp.substr(tmp.find(delimiter) + 1, tmp.size());
        if(not (ignore_empty and new_part.empty()))
        {
            result.push_back(new_part);
        }
    }
    if(not (ignore_empty and tmp.empty()))
    {
        result.push_back(tmp);
    }
    return result;
}

// Funktio tallentaa käyttäjän antamat tunnisteet verkostoon oikeassa järjestyksessä.
void store(std::string const &id1, std::string const &id2, NETWORK &net){
    if(net.find(id1) == net.end()){
        net.insert({id1, {}});
    }

    net.at(id1).push_back(id2);

    if(net.find(id2) == net.end()){
        net.insert({id2, {}});
    }
}


// Funktio tulostaa annetun tunnisteen verkoston kokonaisuudessaan.
void printing(std::string const &id, std::string const &dots, NETWORK const &net){
    std::vector<std::string> net_humans = net.at(id);

    std::cout << dots << id <<std::endl;

    for(std::string const &human : net_humans){
        printing(human, dots + "..", net);
    }
}


// Funktio laskee, kuinka monta henkeä kuuluu tietyn tunnisteen alaiseen verkostoon.
int network_counter(std::string const &id, NETWORK const &net){
    int n = 0;
    std::vector<std::string> net_humans = net.at(id);

    for(std::string const &human : net_humans){
        n += 1;
        n += network_counter(human, net);
    }

    return n;
}


// Funktio laskee kuinka syvälle verkosto ulottuu; kuinka pitkälle haarautuu.
int network_depth(std::string const &id, NETWORK const &net){
    int depth;
    int maximum = 0;
    std::vector<std::string> net_humans = net.at(id);

    for(std::string const &human : net_humans){
        depth = network_depth(human, net);
        if(depth > maximum){
            maximum = depth;
        }
    }

    return maximum + 1;
}

int main()
{

    NETWORK net;

    while(true)
    {
        std::string line;
        std::cout << "> ";
        getline(std::cin, line);
        std::vector<std::string> parts = split(line, ' ', true);

        // Sallii tyhjät syötteet käyttäjältä.
        if(parts.size() == 0)
        {
            continue;
        }

        std::string command = parts.at(0);

        if(command == "S" or command == "s") // K
        {
            if(parts.size() != 3)
            {
                std::cout << "Erroneous parameters!" << std::endl << HELP_TEXT;
                continue;
            }
            std::string id1 = parts.at(1);
            std::string id2 = parts.at(2);

            store(id1, id2, net);

        }
        else if(command == "P" or command == "p")
        {
            if(parts.size() != 2)
            {
                std::cout << "Erroneous parameters!" << std::endl << HELP_TEXT;
                continue;
            }
            std::string id = parts.at(1);

            printing(id, "", net);

        }
        else if(command == "C" or command == "c")
        {
            if(parts.size() != 2)
            {
                std::cout << "Erroneous parameters!" << std::endl << HELP_TEXT;
                continue;
            }
            std::string id = parts.at(1);

            std::cout << network_counter(id, net) << std::endl;

        }
        else if(command == "D" or command == "d")
        {
            if(parts.size() != 2)
            {
                std::cout << "Erroneous parameters!" << std::endl << HELP_TEXT;
                continue;
            }
            std::string id = parts.at(1);

            std::cout << network_depth(id, net) << std::endl;

        }
        else if(command == "Q" or command == "q")
        {
           return EXIT_SUCCESS;
        }
        else
        {
            std::cout << "Erroneous command!" << std::endl << HELP_TEXT;
        }
    }
}
