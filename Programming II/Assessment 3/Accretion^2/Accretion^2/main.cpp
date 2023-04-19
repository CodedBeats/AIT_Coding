#include <cstdlib>
#include <ctime>

#include "game.h"
#include <iostream>
using namespace std;

int main() {

    // Seed the random number generator
    srand(time(0));

    game();

    /*
        Features to add
        1. scoreboard
        2. character set up of class system
        3. implement player class based attacks in combat
        6. battle.cpp - line 47 - shouldn't have 3 IFs like that

        Final Features to add
        1. format display to assessment 2
        2. implement assessment 3 notes
        3. give comment for string quit variables
        4. format code consistently
        5. balance game


        Fixed
        1. changed exp display in stats menu option to show how much exp the player needs to reach the next lvl
        2. fixed the issue where combat text would display in the wrong order (turns out I was just dumn and not clearing screen effectivly)


        // to leave in main
        Quality of life improvements:
        1. prompt player to train again after battle so they don't have to go through menu every time


        Notes:
        1. if you get a high enough lvl, your damage may increase the enemy's health (damage becomes negative value)
    */

    return 0;
}
