#include "battle.h"
#include "display.h"

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

    // player object setup

    // define game variables
    bool gameIsActive = true;
    bool gameWon = false;
    int menuChoice;

    // game loop based off menu display
    while (gameIsActive) {
    // display menu and handle
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
            // enemySetup()
            // temp
            Player player(playerName, "vanilla", 100, 1, 1, 20, 10, 15, 10, 5);
            Player* pPlayer = &player;
            Enemy enemy("enemy1", 100, 1, 50, 18, 12, 10);
            Enemy* eEnemy = &enemy;
            train(*pPlayer, *eEnemy);
            break;
        }
        case 3: {
            // === View Stats === //
            cout << "\033[2J\033[1;1H";
            // temp
            Player player(playerName, "vanilla", 100, 1, 1, 20, 10, 15, 10, 5);
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
        }
    }
}