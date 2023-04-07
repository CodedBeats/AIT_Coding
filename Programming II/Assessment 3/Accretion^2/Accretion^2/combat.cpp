#include "player.h"
#include "enemy.h"

#include <iostream>
using namespace std;


// ============================ Player Turn ============================ //
void playerTurn(Player& player, Enemy& enemy) {
    // get player combat choice
    int playerCombatChoice;
    cout << "\nWhat's your choice " << player.getName() << "?" << endl;
    cout << "1 -> Attack\n"
        << "Spells\n"
        << "2 -> Shielding Aura\n"
        << "> ";
    cin >> playerCombatChoice;

    // clear screen
    cout << "\033[2J\033[1;1H";

    // wrap another if statement for game won to implement class abilities

    // calc player attack damage and apply to enemy
    if (playerCombatChoice == 1) {
        int damage = player.attack();
        cout << player.getName() << " attacks" << endl;
        enemy.takeDamage(damage, enemy.getDef());
    }
    // increase block chance
    else if (playerCombatChoice == 2) {
        player.shieldingAura();
        cout << player.getName() << " uses Sheilding Aura\n"
            << "Block chance increases to " << player.getBlockChance()
            << "%" << endl;
    }
    else {
        cout << "Invalid choice!" << endl;
    }
}


// ============================ Enemy Turn ============================ //
void enemyTurn(Player& player, Enemy& enemy) {
    // get random number between 0 and 99 for enemy choice
    int enemyChoice = rand() % 100;
    if (enemyChoice > 25) {
        // attack
        int damage = enemy.attack();
        cout << enemy.getName() << " attacks" << endl;
        player.takeDamage(damage, enemy.getDef());

    }
    else {
        // heavy attack
        int damage = enemy.attack();
        cout << enemy.getName() << " attacks with ferocity!" << endl;
        // heavy attack ignores defence
        player.takeDamage(damage, 0);
    }
}


// ============================ Combat ============================ //
void handleCombat(Player& player, Enemy& enemy) {
    // wrap another if statement for game won

    // player goes first if speed stat is higher or equal
    if (player.getSpd() >= enemy.getSpd()) {
        // <- player health goes back to full here because we pass the original class again ->
        playerTurn(player, enemy);
        // <- enemy health goes back to full here because we pass the original class again ->
        enemyTurn(player, enemy);
    }
    // else enemy speed stat is higher and goes first
    else {
        enemyTurn(player, enemy);
        playerTurn(player, enemy);
    }
}

bool isFighting(Player& player, Enemy& enemy) {
    // check if player or enemy are dead
    // return true if battle is still going
    if (player.getHealth() > 0 && enemy.getHealth() > 0) {
        return true;
    }
    else {
        return false;
    }
}
