#include "colourset.hh"
#include<vector>
#include <algorithm>



Colourset::Colourset(const std::vector<std::string> line):
    colourline_(line) {
}


Colourset :: ~Colourset(){
}


std::vector<std::string> Colourset :: get_colourline() const{
    return colourline_;
}


void Colourset::right_colour(Colourset secret){
    std::vector<std::string> secret_line = secret.get_colourline();    // Haetaan salainen värisuora.
    std::vector<std::string> tmp_secret;                               // Apumuuttuja salaiselle värisuoralle.
    std::vector<std::string> tmp_helper;                               // Apumuuttuja arvatulle värisuoralle.

    // Tarkistaa ensin kuinka monta väriä on tismalleen oikealla paikalla ja lisää
    // ne värit apuvektoreihin, jotka eivät täsmää salaisen värisarjan kanssa.
    for(size_t i = 0; i < colourline_.size() ; i++){
        if(secret_line.at(i) == colourline_.at(i)){
            right_colour_and_position_ ++;
        }else{
            tmp_secret.push_back(secret_line.at(i));
            tmp_helper.push_back(colourline_.at(i));
        }
    }

    // Jos apuvektori ei ole tyhjä, käydään se läpi. Värin osuessa kohdalle, etsitään
    // värin indeksi ja poistetaan se salaisen värisarjan apuvektorista, jotta se ei tule lasketuksi uudestaan.
    if(not tmp_helper.empty()){
        for(const auto& colour : tmp_helper){
            if(std::find(tmp_secret.begin(), tmp_secret.end(), colour) != tmp_secret.end()){
                right_colour_ ++;

                auto it = find(tmp_secret.begin(), tmp_secret.end(), colour);
                tmp_secret.erase(it);
            }
        }
    }
}


void Colourset::print_status(){
    std::cout<<"|";

    for(const auto &i : colourline_){
        std::cout << " "<< i;
    }

    std::cout<<" | " << right_colour_and_position_ << " | " << right_colour_ << " |" << std::endl;
}



bool Colourset :: has_won(){
    if(right_colour_and_position_ == 4){
        std::cout << "You won: Congratulations!"<< std::endl;
        return true;
    }

    return false;
}




