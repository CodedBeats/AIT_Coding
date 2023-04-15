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
        4. handle multiple lvl ups
        5. when player health falls below enemy health, some weird shenanigans happen with the order of turns
        6. battle.cpp - line 47 - shouldn't have 3 IFs like that

        Final Features to add
        1. format display to assessment 2
        2. implement assessment 3 notes
        3. give comment for string quit variables
        4. format code consistently
        5. balance game


        Fixed
        1. changed chance of special attack from enemy to be 30% instead of 50%
        2. put debuff call in takeDamage func to only call if damage is taken
        3. player name can now be multiple words
        4. added a victory screen to be triggered after defeating the boss
        5. changed game func to return bool so we can handle the transition to class combat
        6. created a func to setup the boss enemy
        7. gave the boss a name of "Abyssalix"
        8. added a function to handle the boss fight
        9. added a lockout variable so the player gets locked out of fighting the boss for 3 turns if they loose to it
        10. put everything together for the player to fight the boss and get locked out or get victory screen if they loose or win respectively


        Notes:
        1. if you get a high enough lvl, your damage may increase the enemy's health (damage becomes negative value)
    */

    return 0;
}

// cout << "\033[2J\033[1;1H";