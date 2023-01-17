#include "player.hh"
#include <iostream>
#include <string>

using namespace std;

Player :: Player(const std::string& player):
name_(player){
}
Player :: ~Player()
{
}

string Player :: get_name() const {
    return name_;
}

int Player :: get_points() const{
    return scorepoints_;
}

void Player :: add_points(int new_points){
    if(scorepoints_ + new_points > 50){
        cout<< name_ << " gets penalty points!" <<endl;
        scorepoints_ = 25;
    }else{
        scorepoints_ += new_points;
    }

}

bool Player :: has_won(){
    if(scorepoints_ == 50){
        is_winner = true;
    }else{
        is_winner = false;
    }

    return is_winner;
}
