#include "enemy.h"
#include "player.h"

#include <iostream>
using namespace std;

// ============================ Player Turn ============================ //
int getPlayerInput(Player* player) {
    // get player combat choice
    int playerCombatChoice;
    cout << "\nWhat's your choice " << player->getName() << "?" << endl;
    cout << "1 -> Attack\n"
        << "Spells\n"
        << "2 -> Shielding Aura\n"
        << "> ";
    cin >> playerCombatChoice;

    return playerCombatChoice;
}

void playerTurn(Player* player, Enemy* enemy, int playerCombatChoice) {
    // calc player attack damage and apply to enemy
    if (playerCombatChoice == 1) {
        cout << player->getName() << " attacks" << endl;
        int damage = player->attack();
        enemy->takeDamage(damage, enemy->getDef(), false, "none");
    }
    // increase block chance
    else if (playerCombatChoice == 2) {
        player->shieldingAura();
        cout << player->getName() << " uses Sheilding Aura\n"
            << "Block chance increases to " << player->getBlockChance() << "%"
            << endl;
    }
    else {
        cout << "Invalid choice!" << endl;
    }
}

// ============================ Enemy Turn ============================ //
void enemyTurn(Player* player, Enemy* enemy) {

    // get random number between 1 and 100 for enemy choice
    int enemyChoice = rand() % 100 + 1;

    // handle Slime turn
    if (Slime* slime = dynamic_cast<Slime*>(enemy)) {
        // 30% chance to use special ability
        if (enemyChoice <= 30) {
            // apply damage and debuff
            int damage = slime->stickySmash();
            cout << "Slime uses Sticky Smash" << endl;
            player->takeDamage(damage, player->getDef(), true, "spd");
        }
        // 70% chance for normal attack
        else {
            // apply damage
            int damage = slime->attack();
            cout << "Slime attacks" << endl;
            player->takeDamage(damage, player->getDef(), false, "none");
        }
    }
    // handle Hydra turn
    else if (Hydra* hydra = dynamic_cast<Hydra*>(enemy)) {
        // 30% chance to use special ability
        if (enemyChoice <= 30) {
            // apply damage and debuff
            int damage = hydra->corrosiveSpray();
            cout << "Hydra uses Corrosive Spray" << endl;
            player->takeDamage(damage, player->getDef(), true, "def");
        }
        // 70% chance for normal attack
        else {
            // apply damage
            int damage = hydra->attack();
            cout << "Hydra attacks" << endl;
            player->takeDamage(damage, player->getDef(), false, "none");
        }
    }
    // handle Harpy turn
    else if (Harpy* harpy = dynamic_cast<Harpy*>(enemy)) {
        // 30% chance to use special ability
        if (enemyChoice <= 30) {
            // apply damage and debuff
            int damage = harpy->razorFeather();
            cout << "Harpy uses Razor Feather" << endl;
            player->takeDamage(damage, player->getDef(), false, "none");
            // display debuffed stat
            cout << "Harpy's Strength increased" << endl;
            harpy->buff("str");
        }
        // 70% chance for normal attack
        else {
            // apply damage
            int damage = harpy->attack();
            cout << "Harpy attacks" << endl;
            player->takeDamage(damage, player->getDef(), false, "none");
        }
    }
    // handle Specter turn
    else if (Specter* specter = dynamic_cast<Specter*>(enemy)) {
        // 30% chance to use special ability
        if (enemyChoice <= 30) {
            // apply damage and debuff
            int damage = specter->shadowStrike();
            cout << "Specter uses Shadow Strike" << endl;
            player->takeDamage(damage, player->getDef(), true, "blockChance");
        }
        // 70% chance for normal attack
        else {
            // apply damage
            int damage = specter->attack();
            cout << "Specter attacks" << endl;
            player->takeDamage(damage, player->getDef(), false, "none");
        }
    }
    // handle Orc turn
    else if (Orc* orc = dynamic_cast<Orc*>(enemy)) {
        // 30% chance to use special ability
        if (enemyChoice <= 30) {
            // apply damage and debuff
            int damage = orc->bonecrushingBlow();
            cout << "Orc uses Bonecrushing Blow" << endl;
            player->takeDamage(damage, player->getDef(), true, "str");
        }
        // 70% chance for normal attack
        else {
            // apply damage
            int damage = orc->attack();
            cout << "Orc attacks" << endl;
            player->takeDamage(damage, player->getDef(), false, "none");
        }
    }
}

// ============================ Boss Turn ============================ //
void bossTurn(Player* player, Dragon* dragon) {
    // get random number between 1 and 100 for enemy choice
    int enemyChoice = rand() % 100 + 1;

    // 30% chance to use dragon roar
    if (enemyChoice <= 30) {
        // buff dragon and debuff player
        dragon->dragonRoar();
        cout << "Abyssalix uses Dragon Roar" << endl;
        player->debuff("spd");
        cout << "Abyssalix's strength increased and " << player->getName()
            << "'s speed reduced" << endl;
    }
    // 30% chance to use dragon breath
    else if (enemyChoice > 30 && enemyChoice <= 60) {
        // apply damage
        int damage = dragon->dragonBreath();
        cout << "Abyssalix uses Dragon Breath" << endl;
        player->takeDamage(damage, player->getDef(), false, "none");
    }
    // 40% chance to just attack
    else {
        // apply damage
        int damage = dragon->attack();
        cout << "Abyssalix attacks" << endl;
        player->takeDamage(damage, player->getDef(), false, "none");
    }
}

// ============================ Handle Combat ============================ //
void handleCombat(Player* player, int playerChoice, Enemy* enemy) {
    // clear screen
    cout << "\033[2J\033[1;1H";

    if (player->getSpd() >= enemy->getSpd()) {
        playerTurn(player, enemy, playerChoice);
        // exit combat loop if enemy is dead
        if (enemy->getHealth() <= 0) {
            return;
        }
        enemyTurn(player, enemy);
    }
    // else enemy speed stat is higher and goes first
    else if (player->getSpd() < enemy->getSpd()) {
        enemyTurn(player, enemy);
        // exit combat loop if player is dead
        if (player->getHealth() <= 0) {
            return;
        }
        playerTurn(player, enemy, playerChoice);
    }
}

void handleBossFight(Player* player, int playerChoice, Dragon* dragon) {
    // clear screen
    cout << "\033[2J\033[1;1H";

    // ===================== Something Wrong Here ===================== //
    if (player->getSpd() >= dragon->getSpd()) {
        playerTurn(player, dragon, playerChoice);
        // exit combat loop if dragon is dead
        if (dragon->getHealth() <= 0) {
            return;
        }
        bossTurn(player, dragon);
    }
    // else dragon speed stat is higher and goes first
    else {
        bossTurn(player, dragon);
        // exit combat loop if player is dead
        if (player->getHealth() <= 0) {
            return;
        }
        playerTurn(player, dragon, playerChoice);
    }
}

bool isFighting(Player* player, Enemy* enemy) {
    // check if player or enemy are dead
    if (player->getHealth() > 0 && enemy->getHealth() > 0) {
        // return true if battle is still going
        return true;
    }
    else {
        return false;
    }
}