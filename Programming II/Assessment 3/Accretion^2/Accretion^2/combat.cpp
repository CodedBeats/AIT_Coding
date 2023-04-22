#include "enemy.h"
#include "player.h"
#include "exception.h"

#include <iostream>
using namespace std;

// ============================ Player Turn ============================ //
int getPlayerInput(Player* player, bool gameWon, string className) {
    // get player combat choice
    int playerCombatChoice;

    // handle if game has been won
    if (gameWon) {
        // class = Berserker
        if (className == "Berserker") {
            // display choices
            cout << "\n\n-Abilities-\n"
                << "\t(1) Attack\n"
                << "\t(2) Vengeful Vortex\n"
                << "\t(3) Battle Fury\n";

            cout << "\nWhat's your choice " << player->getName() << "?\n"
                << "> ";
        }

        // class = Mage
        else if (className == "Mage") {
            // display choices
            cout << "\n\n-Abilities-\n"
                << "\t(1) Attack\n"
                << "-Spells-\n"
                << "\t(2) Meteor Shower\n"
                << "\t(3) Mind Blast\n"
                << "\t(4) Arcane Surge\n";

            cout << "\nWhat's your choice " << player->getName() << "?\n"
                << "> ";
        }

        // class = Paladin
        else if (className == "Paladin") {
            // display choices
            cout << "\n\n-Abilities-\n"
                << "\t(1) Attack\n"
                << "\t(2) Holy Strike\n"
                << "-Spells-\n"
                << "\t(3) Shield of Light\n";

            cout << "\nWhat's your choice " << player->getName() << "?\n"
                << "> ";
        }

        // class = Ranger
        else if (className == "Ranger") {
            // display choices
            cout << "\n\n-Abilities-\n"
                << "\t(1) Attack\n"
                << "\t(2) Lethal Arrow\n"
                << "\t(3) Rain of Pain\n"
                << "-Spells-\n"
                << "\t(4) Camouflage\n";

            cout << "\nWhat's your choice " << player->getName() << "?\n"
                << "> ";
        }
        // class = none
        else {
            // display choices
            cout << "\n\n-Abilities-\n"
                << "\t(1) Attack\n"
                << "-Spells-\n"
                << "\t(2) Shielding Aura\n";

            cout << "\nWhat's your choice " << player->getName() << "?\n"
                << "> ";
        }
    }
    else {
        // display choices
        cout << "\n\n-Abilities-\n"
            << "\t(1) Attack\n"
            << "-Spells-\n"
            << "\t(2) Shielding Aura\n";

        cout << "\nWhat's your choice " << player->getName() << "?\n"
            << "> ";
    }

    // get player choice
    try {
        cin >> playerCombatChoice;

        // check if input was an int
        if (!cin) {
            // input was not an integer
            throw nonIntException();
        }
    }
    // catch exception
    catch (nonIntException& e) {
        cin.clear();
        cin.ignore(512, '\n');
        // scroll up to see exception message
        cout << "\n___Exception___\n";
        cout << e.what() << endl;
    }

    return playerCombatChoice;
}



void playerTurn(Player* player, Enemy* enemy, int playerCombatChoice, bool gameWon) {
    // class based combat
    if (gameWon) {

        // handle Berserker turn
        if (Berserker* berserker = dynamic_cast<Berserker*>(player)) {
            // Attack
            if (playerCombatChoice == 1) {
                cout << berserker->getName() << " attacks" << endl;
                int damage = berserker->attack();
                enemy->takeDamage(damage, enemy->getDef(), false, "none");
            }
            // Vengeful Vortex
            else if (playerCombatChoice == 2) {
                cout << berserker->getName() << " uses Vengeful Vortex" << endl;
                int damage = berserker->vengefulVortex();
                enemy->takeDamage(damage, enemy->getDef(), false, "none");
            }
            // Battle Fury
            else if (playerCombatChoice == 3) {
                cout << berserker->getName() << " uses Vengeful Vortex" << endl;
                berserker->battleFury();
                // display debuffed stat
                cout << player->getName() << "'s Strength increased" << endl;
            }
            else {
                cout << "Invalid choice!" << endl;
            }
        }

        // handle Mage Turn
        else if (Mage* mage = dynamic_cast<Mage*>(player)) {
            // Attack
            if (playerCombatChoice == 1) {
                cout << mage->getName() << " attacks" << endl;
                int damage = mage->attack();
                enemy->takeDamage(damage, enemy->getDef(), false, "none");
            }
            // Meteor Shower
            else if (playerCombatChoice == 2) {
                cout << mage->getName() << " uses Meteor Shower" << endl;
                int damage = mage->meteorShower();
                enemy->takeDamage(damage, enemy->getDef(), false, "none");
            }
            // Mind Blast
            else if (playerCombatChoice == 3) {
                cout << mage->getName() << " uses Mind Blast" << endl;
                int damage = mage->mindBlast();;
                enemy->takeDamage(damage, enemy->getDef(), true, "def");
            }
            // Arcane Surge
            else if (playerCombatChoice == 4) {
                cout << mage->getName() << " uses Vengeful Vortex" << endl;
                mage->arcaneSurge();
                // display debuffed stat
                cout << player->getName() << "'s Magical Might increased" << endl;
            }
            else {
                cout << "Invalid choice!" << endl;
            }
        }

        // handle Paladin Turn
        else if (Paladin* paladin = dynamic_cast<Paladin*>(player)) {
            // Attack
            if (playerCombatChoice == 1) {
                cout << paladin->getName() << " attacks" << endl;
                int damage = paladin->attack();
                enemy->takeDamage(damage, enemy->getDef(), false, "none");
            }
            // Holy Strike
            else if (playerCombatChoice == 2) {
                cout << paladin->getName() << " uses Holy Strike" << endl;
                int damage = paladin->holyStrike();
                enemy->takeDamage(damage, enemy->getDef(), false, "none");
            }
            // Shield of Light
            else if (playerCombatChoice == 3) {
                cout << paladin->getName() << " uses Shield of Light" << endl;
                paladin->shieldOfLight();
                // display debuffed stat
                cout << player->getName() << "'s Defence and Block Chance increased" << endl;
            }
            else {
                cout << "Invalid choice!" << endl;
            }
        }

        // handle Ranger Turn
        else if (Ranger* ranger = dynamic_cast<Ranger*>(player)) {
            // Attack
            if (playerCombatChoice == 1) {
                cout << ranger->getName() << " attacks" << endl;
                int damage = ranger->attack();
                enemy->takeDamage(damage, enemy->getDef(), false, "none");
            }
            // Lethal Arrow
            else if (playerCombatChoice == 2) {
                cout << ranger->getName() << " uses Lethal Arrow" << endl;
                int damage = ranger->lethalArrow(player->getSpd());
                enemy->takeDamage(damage, enemy->getDef(), false, "none");
            }
            // Rain of Pain
            else if (playerCombatChoice == 3) {
                cout << ranger->getName() << " uses Rain of Pain" << endl;
                int damage = ranger->rainOfPain();
                enemy->takeDamage(damage, enemy->getDef(), false, "def");
            }
            // Camouflage
            else if (playerCombatChoice == 4) {
                cout << ranger->getName() << " uses Camouflage" << endl;
                ranger->camouflage();
                // display debuffed stat
                cout << player->getName() << "'s Speed increased" << endl;
            }
            else {
                cout << "Invalid choice!" << endl;
            }
        }
        // non class based combat
        else {
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
    }

    // non class based combat
    else {
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
void handleCombat(Player* player, int playerChoice, Enemy* enemy, bool gameWon) {
    // clear screen
    cout << "\033[2J\033[1;1H";

    if (player->getSpd() >= enemy->getSpd()) {
        playerTurn(player, enemy, playerChoice, gameWon);
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
        playerTurn(player, enemy, playerChoice, gameWon);
    }
}



void handleBossFight(Player* player, int playerChoice, Dragon* dragon, bool gameWon) {
    // clear screen
    cout << "\033[2J\033[1;1H";

    // ===================== Something Wrong Here ===================== //
    if (player->getSpd() >= dragon->getSpd()) {
        playerTurn(player, dragon, playerChoice, gameWon);
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
        playerTurn(player, dragon, playerChoice, gameWon);
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