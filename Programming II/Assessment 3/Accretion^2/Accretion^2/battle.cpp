#include "battle.h"
#include "display.h"

#include <iostream>
using namespace std;


// Training Battle
void train(Player* player, Player* combatPlayer, Enemy* enemy, bool gameWon) {
    // declare random variable just to continue throught text
    string cont;

    // combat loop
    bool combatActive = true;
    while (combatActive) {
        cout << "\n" << endl;
        // display player and enemy battle stats
        displayBattleStats(combatPlayer, enemy);

        // handle player and enemy turn
        handleCombat(combatPlayer, enemy);

        // just use the class since it should be updated from combat()
        combatActive = isFighting(combatPlayer, enemy);
    }

    // enemy defeated player
    if (combatPlayer->getHealth() == 0) {
        cout << combatPlayer->getName() << " has been defeated by the " << enemy->getName() << endl;
    }
    // player defeated enemy
    else {
        cout << enemy->getName() << " has been defeated by " << combatPlayer->getName() << endl;

        // apply exp to player
        player->gainExp(enemy->getExp());
        cout << "\nYou recieved " << enemy->getExp() << " exp points" << endl;

        // handle lvl up
        // lvl up if exp >= playerLvl * 50
        if (player->getExp() >= (player->getLevel() * 50)) {
            if (gameWon) {
                // lvl up player
                cout << "You leveled up" << endl;
                player->lvlUp(true);

                // click to see how stats change
                cout << "\nType (0) to continue\n" <<
                    "> ";
                cin >> cont;

                // display upgraded stats
                cout << "\033[2J\033[1;1H \n"
                    << "Health:\t\t" << player->getHealth() << "\n"
                    << "Strength:\t" << player->getStr() << "\n"
                    << "Defence:\t\t" << player->getDef() << "\n"
                    << "Speed:\t\t" << player->getSpd() << "\n"
                    << "Magical Might:\t" << player->getMgcMht() << "\n"
                    << endl;
            }
            else {
                cout << "You leveled up" << endl;
                player->lvlUp(false);
                cout << "All stats increased by 10" << endl;
            }
        }
    }

    // Return to menu
    cout << "\nType (0) to return to menu\n" <<
        "> ";
    cin >> cont;
}



// Boss Fight Battle