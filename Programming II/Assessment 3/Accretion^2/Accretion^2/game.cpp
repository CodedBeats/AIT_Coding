// #include "player.h"
// #include "enemy.h"
#include "display.h"

#include <iostream>
using namespace std;


// needs a name change
void train(string playerName) {
    string enemyName = "Enemy";
    cout << "\033[2J\033[1;1H";

    Player player(playerName, 100, 1, 1, 20, 10, 15, 10);
    Enemy enemy(enemyName, 100, 1, 50, 18, 12, 10);

    // define pointers to class so it can be accessed and updated in the fucntion
    Player* pPlayer = &player;
    Enemy* pEnemy = &enemy;

    // combat loop
    bool combatActive = true;
    while (combatActive) {
        cout << "\n" << endl;
        // just use the class since it should be updated from combat()
        displayBattleStats(*pPlayer, *pEnemy);

        // pass pointers so it can update the original classes
        handleCombat(*pPlayer, *pEnemy);

        // just use the class since it should be updated from combat()
        combatActive = isFighting(player, enemy);
    }

    if (player.getHealth() == 0) {
        cout << player.getName() << " has been defeated by the " << enemy.getName() << endl;
    }
    // only other possibility (should be) enemy health is 0
    else {
        cout << enemy.getName() << " has been defeated by " << player.getName() << endl;
    }

    // declare random variable just to exit this stats screen
    string exit;
    // Return to menu
    cout << "\nType (0) to return to menu\n" <<
        "> ";
    cin >> exit;
}


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

    // create player class
    // call playerSetup to update playerName

    // display menu and handle
    bool gameIsActive = true;
    int menuChoice;
    while (gameIsActive) {
        menuChoice = menu();
        switch (menuChoice) {
        case 1: {
            // Boss Fight
            cout << "This is the boss fight" << endl;
            break;
        }
        case 2: {
            // Train
            // enemySetup()
            train(playerName);
            break;
        }
        case 3: {
            // View Stats
            // temp
            Player player(playerName, 100, 1, 1, 20, 10, 15, 10);
            Player* pPlayer = &player;
            displayStats(*pPlayer);
            break;
        }
        case 4: {
            // Scoreboard
            cout << "This is the scoreboard" << endl;
            break;
        }
        case 5: {
            // Quit
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

    // check to see if game has been won and return that
}