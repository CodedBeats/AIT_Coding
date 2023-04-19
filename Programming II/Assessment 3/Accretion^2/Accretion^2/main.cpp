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
        Player player = gameSetup(gameWon);
        Player* pPlayer = &player;

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

    } while (gameWon && gameContinue);

    

    /*
        Features to add
        1. implement player class based attacks in combat
        2. fix problem where game doesn't get playerName once game has been won (2nd + time playing)

        Final Features to add
        1. format display to assessment 2
        2. implement assessment 3 notes
        3. give comment for string quit variables
        4. format code consistently
        5. balance game


        Fixed
        1. added a setup func to create player by setting up the game
        2. refactored coded so player setup and game call are handled in main
        3. implemented the class setup so player can choose what class they want by reading a brief description fo each class' strengths and weaknesses


        // to leave in main
        Quality of life improvements:
        1. prompt player to train again after battle so they don't have to go through menu every time


        Notes:
        1. if you get a high enough lvl, your damage may increase the enemy's health (damage becomes negative value)
    */

    return 0;
}
