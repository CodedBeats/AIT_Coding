#include <cstdlib>
#include <ctime>

#include "game.h"
#include "scoreboard.h"
#include "setup.h"
#include <iostream>
using namespace std;

int main() {

    // Seed the random number generator
    srand(time(0));

    // xxx
    bool gameWon = false;
    bool gameContinue = true;

    // initialize scoreboard
    Scoreboard gameScoreboard;
    Scoreboard* pScoreboard = &gameScoreboard;

    // execute once and then repeat if game is won
    do {
        cout << "\033[2J\033[1;1H";

        // initialize player
        Player* pPlayer = gameSetup(gameWon);
        // Player* pPlayer = &player;

        // call game func and
        gameWon = game(pScoreboard, pPlayer, gameWon);

        // check if player wants to continue
        if (gameWon) {
            cout << "\033[2J\033[1;1H";
            char cont;
            cout << "Do you wish to play again? (y = yes, n = no)\n"
                << "> ";
            cin >> cont;

            // exit if player doesn't want to play again
            if (cont == 'n') {
                gameContinue = false;
            }
        }

        // delete player
        delete pPlayer;

    } while (gameWon && gameContinue);

    

    /*
        Features to add
        1. implement player class based attacks in combat
        2. amount stats increase or decrease chnage too much? on buff and debuff
        3. creating pCombatPlayer is creating a player class rather than an inheriting player class when game has been won and therefore doesn't handle class system combat
        3. ^^^ HELP ^^^

        Final Features to add
        1. format display to assessment 2
        2. implement assessment 3 notes
        3. give comment for string quit variables
        4. format code consistently
        5. balance game

        Fixed
        1. fixed the odd issue of getline() not waiting for user input
        2. added some comments to be left in main to give Game notes to user
        3. added a comment humbly bragging about project
        4. deallocate memory for dynamically allocated objects by delete them when they are no longer needed (at end of scope they are declared in)
        5. added classes for player input in combat
        6. started implementing the class attacks (copying the enemy turn style) but something isn't working (it is mapped out) and so combat doesn't work in the class system


        // ==============   to leave in main
        Future Potential Improvements:
        1. prompt player to train again after battle so they don't have to go through menu every time
        2. refactor IFs nested 3 times


        Game Notes:
        1. Use "Laura" as your player name for god-level stats so you can instantly beat the boss and unlock the class system
        2. Git history for code: https://github.com/CodedBeats/AIT_Coding/commits/master/Programming%20II/Assessment%203/Accretion%5E2
            I really did a massive amount of work on this :3
    */

    return 0;
}
