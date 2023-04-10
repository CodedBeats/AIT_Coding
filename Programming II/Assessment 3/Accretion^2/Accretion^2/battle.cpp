#include "battle.h"
#include "display.h"

#include <iostream>
using namespace std;


// Training Battle
void train(Player* player, Enemy* enemy) {
    // declare random variable just to continue throught text
    string cont;

    // create clone of player so its stats can be buffed and debuffed

    // combat loop
    bool combatActive = true;
    while (combatActive) {
        cout << "\n" << endl;
        // display player and enemy battle stats
        displayBattleStats(player, enemy);

        // handle player and enemy turn
        handleCombat(player, enemy);

        // just use the class since it should be updated from combat()
        combatActive = isFighting(player, enemy);
    }

    // enemy defeated player
    if (player->getHealth() == 0) {
        cout << player->getName() << " has been defeated by the " << enemy->getName() << endl;
    }
    // player defeated enemy
    else {
        cout << enemy->getName() << " has been defeated by " << player->getName() << endl;

        // handle exp and lvl up
        cout << "\nType (0) to recieve exp\n" <<
            "> ";
        cin >> cont;
        cout << "\033[2J\033[1;1H";
        // apply exp to player
        // if exp > 100, lvlUp()
        // display lvl up message
    }

    // Return to menu
    cout << "\nType (0) to return to menu\n" <<
        "> ";
    cin >> cont;
}



// Boss Fight Battle
