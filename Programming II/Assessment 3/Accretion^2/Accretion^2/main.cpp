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

    // initialize game loop variables
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

        // call game func and return true if/when game is won
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
        Potential Future Improvements:
        1. Prompt player to train again after battle so they don't have to go through menu every time
        2. Add information about what moves do specifically in player's view stats screen
        3. Add party system (recruit up to 3 bot players) with distributed exp
        4. Add increase chance for multiple enemies to apear the higher lvl you are


        Game Notes:
        1. Use "Laura" as your player name for god-level stats so you can instantly beat the boss and unlock the class system
        2. The game has an exponential curve for progression thanks to how much exp is required for increasing lvls and the lvl of enemy you run into
        3. The enemies you run into while training are randomised each with their own special attacks (which can temporarily debuff the players stats, level (up to the players) and stats (based on level)
        4. Check out the 4 available classes after beating the game to experience different moves and player progression
        5. Git history for code: https://github.com/CodedBeats/AIT_Coding/commits/master/Programming%20II/Assessment%203/Accretion%5E2
            I really did a massive amount of work on this :3
    */

    return 0;
}
