#include "battle.h"
#include "display.h"

#include <iostream>
using namespace std;


// Training Battle
void train(Player* player, Player* combatPlayer, Enemy* enemy, bool gameWon) {
    int playerChoice;
    // declare random variable just to continue throught text
    string cont;

    // combat loop
    bool combatActive = true;
    while (combatActive) {
        cout << "\n";
        // display player and enemy battle stats
        displayBattleStats(combatPlayer, enemy);

        // handle if game has been won
        if (gameWon) {
            // get player combat choice
            playerChoice = getPlayerInput(player, true, player->getClass());

            // handle player and enemy turn
            handleCombat(combatPlayer, playerChoice, enemy, true);
        }
        else {
            // get player combat choice
            playerChoice = getPlayerInput(player, false, "none");

            // handle player and enemy turn
            handleCombat(combatPlayer, playerChoice, enemy, false);
        }

        // check to see if battle is still active
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
bool bossFight(Player* player, Dragon* dragon, bool gameWon) {
    int playerChoice;
    // declare random variable just to continue throught text
    string cont;

    // combat loop
    bool combatActive = true;
    while (combatActive) {
        cout << "\n";
        // display player and dragon battle stats
        displayBattleStats(player, dragon);

        // handle if game has been won
        if (gameWon) {
            // get player combat choice
            playerChoice = getPlayerInput(player, true, player->getClass());

            // handle player and dragon turn
            handleBossFight(player, playerChoice, dragon, true);
        }
        else {
            // get player combat choice
            playerChoice = getPlayerInput(player, false, "none");

            // handle player and dragon turn
            handleBossFight(player, playerChoice, dragon, false);
        }

        // just use the class since it should be updated from combat()
        combatActive = isFighting(player, dragon);
    }

    // boss defeated player
    if (player->getHealth() == 0) {
        cout << player->getName() << " has been defeated by Abyssalix" << endl;

        // Return to menu
        cout << "\nType (0) to return to menu\n" <<
            "> ";
        cin >> cont;
    }
    // player defeated boss
    else {
        cout << "Abyssalix has been defeated by " << player->getName() << endl;

        // Continue to victory
        cout << "\nType (0) to continue\n" <<
            "> ";
        cin >> cont;
    }


    // boss has been defeated
    if (dragon->getHealth() <= 0) {
        return true;
    }
    // player has been defeated
    else {
        return false;
    }
}
