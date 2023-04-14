#include "battle.h"
#include "display.h"
#include "setup.h"

#include <iostream>
using namespace std;


/*
    === Game Flow ===
    intro() -> calls -> characterCustomisation()

    menu() -> contains -> bossFight(), train(), viewStats(), scoreboard(), exit()

    bossFight() -> calls -> enemySetup(), combat()
    train() -> calls -> enemySetup(), combat()
    viewStats()
    scoreboard()
    exit()
*/

// func to handle game flow
void game() {
    // welcome player and get player name
    string playerName;
    playerName = welcomePlayer();


    // init variable for player class
    int classVal = 0;
    // secret name for god powers
    if (playerName == "Laura") {
        classVal = 69;
    }
    // set classVal = classSetup() if gameWon == true
    Player player = playerSetup(playerName, false, classVal);


    // define game variables
    bool gameIsActive = true;
    bool gameWon = false;
    int menuChoice;

    // game loop based off menu display
    while (gameIsActive) {
        // display menu and handle player choice
        cout << "\033[2J\033[1;1H";
        menuChoice = menu();
        switch (menuChoice) {
        case 1: {
            // === Boss Fight === //
            cout << "\033[2J\033[1;1H";
            cout << "This is the boss fight" << endl;

            // return bool and check value to see if gameWon should be true
            break;
        }
        case 2: {
            // === Train === //
            cout << "\033[2J\033[1;1H";
            // create pointer for enemy instance
            Enemy* eEnemy = enemySetup(player.getLevel());
            // create player pointer to pass for exp and lvls
            Player* pPlayer = &player;
            // create copy of player instance to use for combat where stats are altered
            Player combatPlayer = *pPlayer;
            Player* pCombatPlayer = &combatPlayer;
            // handle class or non calss based combat
            if (gameWon) {
                train(pPlayer, pCombatPlayer, eEnemy, true);
            } 
            else {
                train(pPlayer, pCombatPlayer, eEnemy, false);
            }
            // delete combat player
            break;
        }
        case 3: {
            // === View Stats === //
            cout << "\033[2J\033[1;1H";
            // temp
            Player* pPlayer = &player;
            displayStats(*pPlayer);
            break;
        }
        case 4: {
            // === Scoreboard === //
            cout << "\033[2J\033[1;1H";
            cout << "This is the scoreboard" << endl;
            break;
        }
        case 5: {
            // === Quit === //
            cout << "\033[2J\033[1;1H";
            char quit;
            // warn player they will loose all progress
            cout << "Are you sure you wish to exit? All progress will be lost\n" <<
                "(y) - yes, (n) - no\n"
                "> ";
            cin >> quit;

            // if 'y' stop program, else do nothing
            if (quit == 'y') {
                gameIsActive = false;
            }
            break;
        }
        default: {
            // if incorrect menuChoice then just display menu again
            break;
        }
        }
    }
}