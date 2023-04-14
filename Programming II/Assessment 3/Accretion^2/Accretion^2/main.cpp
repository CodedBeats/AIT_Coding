#include <cstdlib>
#include <ctime>

#include "game.h"
#include <iostream>
using namespace std;

int main() {

    srand(time(0)); // Seed the random number generator

    game();

    /*
        Features to add
        1. A boss objective (ask if player wants to fight boss, on defeat lock out player for 3 training sessions)
        2. handle lvlUp
        3. scoreboard
        4. let playername be multiple words
        5. victory screen
        6. character set up of class system
        7. implement player class based attacks in combat
        8. make stat increasing ablities only last until enemy defeated (add a function to reset the apropriare stats)
        9. handle battleVictory() to add exp and lvl up if exp >= 100
        10. handle multiple lvl ups
        11. put debuff call in takeDamage func to only call if damage is taken (add bool debuff param)
        12. is isFighting func still needed?
        14. change enemy special ability chance to be 30%
        15. change then lvl*value calc cause it doesn't scale properly
        16. odd problem where enemy turn is displayer after battle stats when player speed gets to 5???
        17. battle.cpp - line 47 - shouldn't have 3 IFs like that

        Final Features to add
        1. format display to assessment 2
        2. implement assessment 3 notes
        3. give comment for string quit variables
        4. format code consistently


        Fixed
        1. updated player and enemy debuff func to not let stats fall below 5 (and refactored code)
        2. added some extra stats to displayBattleStats func for debug purposes
        3. added another player instance that gets passed into battle so original player keeps right stats after battle
        4. changed how applyDamage is calculated so more damage is given and taken each turn
        5. added a gainExp func to player to give them exp from defeating an enemy
        6. implemented the lvlUp func
        7. added display messages for how much stats increase on lvl up


        Notes:
        1. if you get a high enough lvl, your damage may increase the enemy's health (damage becomes negative value)
    */

    return 0;
}

// cout << "\033[2J\033[1;1H";