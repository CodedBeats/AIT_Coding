#include "player.h"
#include "enemy.h"

#include <iostream>
using namespace std;


// ============================ Player Turn ============================ //
void playerTurn(Player* player, Enemy* enemy) {
    // get player combat choice
    int playerCombatChoice;
    cout << "\nWhat's your choice " << player->getName() << "?" << endl;
    cout << "1 -> Attack\n"
        << "Spells\n"
        << "2 -> Shielding Aura\n"
        << "> ";
    cin >> playerCombatChoice;

    // clear screen
    cout << "\033[2J\033[1;1H";

    // calc player attack damage and apply to enemy
    if (playerCombatChoice == 1) {
        cout << player->getName() << " attacks" << endl;
        int damage = player->attack();
        enemy->takeDamage(damage, enemy->getDef());
    }
    // increase block chance
    else if (playerCombatChoice == 2) {
        player->shieldingAura();
        cout << player->getName() << " uses Sheilding Aura\n"
            << "Block chance increases to " << player->getBlockChance()
            << "%" << endl;
    }
    else {
        cout << "Invalid choice!" << endl;
    }
}


// ============================ Enemy Turn ============================ //
void enemyTurn(Player* player, Enemy* enemy) {

    // get random number between 1 and 100 for enemy choice
    int enemyChoice = rand() % 100 + 1;

    // <----- all these are returning NULL and therefore aren't running -----> // 
    // handle Slime turn
    if (Slime* slime = dynamic_cast<Slime*>(enemy)) {
        // 50% chance to use special ability
        if (enemyChoice > 50) {
            // apply damage
            int damage = slime->stickySmash();
            cout << "Slime uses Sticky Smash" << endl;
            player->takeDamage(damage, player->getDef());
            // apply debuff
            cout << player->getName() << "'s Speed reduced" << endl;
            player->debuff("spd");
        }
        // 50% chance for normal attack
        else {
            // apply damage
            int damage = slime->attack();
            cout << "Slime attacks" << endl;
            player->takeDamage(damage, player->getDef());
        }
    }
    // handle Hydra turn
    else if (Hydra* hydra = dynamic_cast<Hydra*>(enemy)) {
        // 50% chance to use special ability
        if (enemyChoice > 50) {
            // apply damage
            int damage = hydra->corrosiveSpray();
            cout << "Hydra uses Corrosive Spray" << endl;
            player->takeDamage(damage, player->getDef());
            // apply debuff
            cout << player->getName() << "'s Defence reduced" << endl;
            player->debuff("def");
        }
        // 50% chance for normal attack
        else {
            // apply damage
            int damage = hydra->attack();
            cout << "Hydra attacks" << endl;
            player->takeDamage(damage, player->getDef());
        }
    }
    // handle Harpy turn
    else if (Harpy* harpy = dynamic_cast<Harpy*>(enemy)) {
        // 50% chance to use special ability
        if (enemyChoice > 50) {
            // apply damage
            int damage = harpy->razorFeather();
            cout << "Harpy uses Razor Feather" << endl;
            player->takeDamage(damage, player->getDef());
            // apply harpy buff
            cout << "Harpy's Strength increased" << endl;
            harpy->buff("str");
        }
        // 50% chance for normal attack
        else {
            // apply damage
            int damage = harpy->attack();
            cout << "Harpy attacks" << endl;
            player->takeDamage(damage, player->getDef());
        }
    }
    // handle Specter turn
    else if (Specter* specter = dynamic_cast<Specter*>(enemy)) {
        // 50% chance to use special ability
        if (enemyChoice > 50) {
            // apply damage
            int damage = specter->shadowStrike();
            cout << "Specter uses Shadow Strike" << endl;
            player->takeDamage(damage, player->getDef());
            // apply debuff
            cout << player->getName() << "'s Block Chance reduced" << endl;
            player->debuff("blockChance");
        }
        // 50% chance for normal attack
        else {
            // apply damage
            int damage = specter->attack();
            cout << "Specter attacks" << endl;
            player->takeDamage(damage, player->getDef());
        }
    }
    // handle Orc turn
    else if (Orc* orc = dynamic_cast<Orc*>(enemy)) {
        // 50% chance to use special ability
        if (enemyChoice > 50) {
            // apply damage
            int damage = orc->bonecrushingBlow();
            cout << "Orc uses Bonecrushing Blow" << endl;
            player->takeDamage(damage, player->getDef());
            // apply debuff
            cout << player->getName() << "'s Strength reduced" << endl;
            player->debuff("str");
        }
        // 50% chance for normal attack
        else {
            // apply damage
            int damage = orc->attack();
            cout << "Orc attacks" << endl;
            player->takeDamage(damage, player->getDef());
        }
    }
}


// ============================ Combat ============================ //
void handleCombat(Player* player, Enemy* enemy) {
    // player goes first if speed stat is higher or equal
    if (player->getSpd() >= enemy->getSpd()) {
        playerTurn(player, enemy);
        // xx
        if (enemy->getHealth() <= 0) { return; }
        enemyTurn(player, enemy);
    }
    // else enemy speed stat is higher and goes first
    else {
        enemyTurn(player, enemy);
        // xx
        if (player->getHealth() <= 0) { return; }
        playerTurn(player, enemy);
    }
}

bool isFighting(Player* player, Enemy* enemy) {
    // check if player or enemy are dead
    // return true if battle is still going
    if (player->getHealth() > 0 && enemy->getHealth() > 0) {
        return true;
    }
    else {
        return false;
    }
}