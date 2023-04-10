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
        13. change debufff so stats can't become negative
        14. change enemy special ability chance to be 27%

        Final Features to add
        1. format display to assessment 2
        2. implement assessment 3 notes
        3. give comment for string quit variables
        4. format code consistently


        Fixed
        1. reduced max blockChance to 50%
        2. seeded RNG in main based of time so it's always different
        3. gave the different class enemies the enemy constructor class
        4. created a random enemy generator that gets called in game func
        5. the random enemy generator takes the playerLvl as a param to set balanced random stats
        6. added dodge chance based off speed stat (chance = 1000 / speed)
        7. added enemy lvl to displayBattleStats()
        8. changed lvlUp func to - 100 from exp so it can handle multiple lvl ups
        9. upgraded battle func to display information better
        10. removed resetStats func from player cause I found a better way to do it
        11. added buff and debuff funcs to player and enemy to increase and reduce their stats during battle
        12. added "virtual" to player and enemy attack func to make them polymorphic classes
        13. implemented the different enemies and their moves into combat func AND IT WORKS (need to do a similar process for player classes)
        14. now exits battle when player or enemy have been defeated (instead of enemy still having a turn even if HP = 0 after player turn)


        Notes:
        1. if you get a high enough lvl, your damage may increase the enemy's health (damage becomes negative value)
    */

    return 0;
}

// cout << "\033[2J\033[1;1H";