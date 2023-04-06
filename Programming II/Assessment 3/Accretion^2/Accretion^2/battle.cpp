#include "battle.h"
#include "display.h"

#include <iostream>
using namespace std;


// Training Battle
void train(Player& player, Enemy& enemy) {

    // combat loop
    bool combatActive = true;
    while (combatActive) {
        cout << "\n" << endl;
        // just use the class since it should be updated from combat()
        displayBattleStats(player, enemy);

        // pass pointers so it can update the original classes
        handleCombat(player, enemy);

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



// Boss Fight Battle

