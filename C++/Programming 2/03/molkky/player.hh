#ifndef PLAYER_HH
#define PLAYER_HH
#include <iostream>
#include <string>

using namespace std;

class Player
{
public:
    Player(const std::string& player);
    ~Player();

    string get_name() const;
    int get_points() const;
    void add_points(int new_points);
    bool has_won();

private:
    std::string name_;
    int scorepoints_ = 0;
    bool is_winner = false;
};

#endif // PLAYER_HH
