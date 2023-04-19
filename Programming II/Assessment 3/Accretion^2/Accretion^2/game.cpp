#include "battle.h"
#include "display.h"
#include "setup.h"
#include "scoreboard.h"

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
bool game(Scoreboard* scoreboard) {
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
    // create player pointer
    Player* pPlayer = &player;


    // define game variables
    bool gameIsActive = true;
    bool gameWon = false;
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
                Player combatPlayer = *pPlayer;
                Player* pCombatPlayer = &combatPlayer;
                // create pointer for boss instance
                Dragon* pDragon = bossSetup(player.getLevel());
                
                // handle boss fight
                victory = bossFight(pCombatPlayer, pDragon);

                // handle boss fight results
                if (victory) {
                    cout << "\033[2J\033[1;1H";
                    
                    // display victory
                    displayVictory();
                    
                    // update scoreboard
                    scoreboard->updateScoreboard(player.getName(), player.getClass(), player.getLevel());

                    // update variables to end game loop
                    gameWon = true;
                    gameIsActive = false;
                }
                else {
                    bossLock = 3;
                }
            }
            break;
        }

        // === Train === //
        case 2: {
            cout << "\033[2J\033[1;1H";

            // create pointer for enemy instance
            Enemy* pEnemy = enemySetup(player.getLevel());
            // create copy of player instance to use for combat where stats are altered
            Player combatPlayer = *pPlayer;
            Player* pCombatPlayer = &combatPlayer;
            // handle class or non calss based combat
            if (gameWon) {
                train(pPlayer, pCombatPlayer, pEnemy, true);
            } 
            else {
                train(pPlayer, pCombatPlayer, pEnemy, false);
            }
            // delete combat player

            // decrement bossLock
            bossLock -= 1;
            break;
        }

        // === View Stats === //
        case 3: {
            cout << "\033[2J\033[1;1H";
            displayStats(*pPlayer);
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

    // return gameWon when game has been won
    return gameWon;
}