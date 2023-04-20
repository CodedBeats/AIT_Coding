#include "battle.h"
#include "display.h"
#include "setup.h"
#include "scoreboard.h"

#include <iostream>
using namespace std;


// func to handle game flow
bool game(Scoreboard* scoreboard, Player* player, bool gameWon) {

    // define game variables
    bool gameIsActive = true;
    int menuChoice;
    int bossLock = 0;

    // game loop based off menu display
    while (gameIsActive) {
        // display menu and handle player choice
        cout << "\033[2J\033[1;1H";
        menuChoice = menu();

        switch (menuChoice) {
        // === Boss Fight === //
        case 1: {
            cout << "\033[2J\033[1;1H";

            // check if bossLock is active (> 0)
            if (bossLock > 0) { 
                string cont;

                // display to player that they are locked out of challenging the boss
                cout << "You have been locked out of fighting the boss for " << bossLock << " turns.\n"
                    << "Go train so you can get strong enough to defeat the boss" << endl;

                // Return to menu
                cout << "\nType (0) to return to menu\n" <<
                    "> ";
                cin >> cont;
            }
            else {
                // boss fight
                bool victory;

                // create copy of player instance to use for combat where stats are altered
                // ========== DEBUG: changing inheriting class back to player class...rip ========== //
                Player* pCombatPlayer = new Player(*player);
                // create pointer for boss instance
                Dragon* pDragon = bossSetup(player->getLevel());
                
                // handle class or non calss based combat
                if (gameWon) {
                    // handle boss fight
                    victory = bossFight(pCombatPlayer, pDragon, true);
                }
                else {
                    // handle boss fight
                    victory = bossFight(pCombatPlayer, pDragon, false);
                }

                // handle boss fight results
                if (victory) {
                    cout << "\033[2J\033[1;1H";
                    
                    // display victory
                    displayVictory();
                    
                    // update scoreboard
                    scoreboard->updateScoreboard(player->getName(), player->getClass(), player->getLevel());

                    // update variables to end game loop
                    gameWon = true;
                    return gameWon;
                }
                else {
                    bossLock = 3;
                }

                // delete combat player and enemy
                delete pCombatPlayer;
                delete pDragon;
            }
            break;
        }

        // === Train === //
        case 2: {
            cout << "\033[2J\033[1;1H";

            // create copy of player instance to use for combat where stats are altered
            // ========== DEBUG: changing inheriting class back to player class...rip ========== //
            Player* pCombatPlayer = new Player(*player);
            // create pointer for enemy instance
            Enemy* pEnemy = enemySetup(player->getLevel());

            // handle class or non calss based combat
            if (gameWon) {
                train(player, pCombatPlayer, pEnemy, true);
            } 
            else {
                train(player, pCombatPlayer, pEnemy, false);
            }

            // delete combat player and enemy
            delete pCombatPlayer;
            delete pEnemy;

            // decrement bossLock
            bossLock -= 1;
            break;
        }

        // === View Stats === //
        case 3: {
            cout << "\033[2J\033[1;1H";
            displayStats(player);
            break;
        }

        // === Scoreboard === //
        case 4: {
            cout << "\033[2J\033[1;1H";
            scoreboard->getScoreboard();
            break;
        }

        // === Quit === //
        case 5: {
            cout << "\033[2J\033[1;1H";
            char quit;
            // warn player they will loose all progress
            cout << "Are you sure you wish to exit? All progress will be lost\n" <<
                "(y) - yes, (n) - no\n"
                "> ";
            cin >> quit;

            // if 'y' stop program, else do nothing
            if (quit == 'y') {
                bool continueGame = false;
                return continueGame;
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