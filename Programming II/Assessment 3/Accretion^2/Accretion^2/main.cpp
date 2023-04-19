#include <cstdlib>
#include <ctime>

#include "game.h"
#include "scoreboard.h"
#include <iostream>
using namespace std;

int main() {

    // Seed the random number generator
    srand(time(0));

    // initialize scoreboard
    Scoreboard gameScoreboard;
    Scoreboard* pScoreboard = &gameScoreboard;
    

    game(pScoreboard);

    /*
        Features to add
        1. character set up of class system
        2. implement player class based attacks in combat

        Final Features to add
        1. format display to assessment 2
        2. implement assessment 3 notes
        3. give comment for string quit variables
        4. format code consistently
        5. balance game


        Fixed
        1. added scoreboard class to hold all game victorys which has a vector to hold all data
        2. scoreboard holds player name, class, lvl and a line break for each iteration of a victory
        3. scoreboard is initialized in main and gets passed as a pointer to game func
        4. scoreboard has a get func to display the vector and an update func to added player stats to the vector on victory


        // to leave in main
        Quality of life improvements:
        1. prompt player to train again after battle so they don't have to go through menu every time


        Notes:
        1. if you get a high enough lvl, your damage may increase the enemy's health (damage becomes negative value)
    */

    return 0;
}
