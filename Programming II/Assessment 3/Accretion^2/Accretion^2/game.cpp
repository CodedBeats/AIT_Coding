//#include "classes.h"
#include "player.h"
#include "enemy.h"

#include <iostream>
using namespace std;

void displayStats(Player player, Enemy enemy) {
	// Player stats
	cout << player.getName() 
		<< " (HP: " << player.getHealth()
		// deftenss basically being block chance just with a nicer name
		<< ", Dft: " << player.getBlockChance() << "%"
		<< ")" << endl;

	// Enemy stats
	cout << enemy.getName() 
		<< " (HP: " << enemy.getHealth()
		<< ")" << endl;
}


void characterCustomisation(string &playerName, string &enemyName) {
	int choice = 0;

	// user choose player name
	cout << "Choose the name of your Hero!! \n> ";
	// getline(cin, playerName);
	cin >> playerName;

	// enemy name choice
	cout << "Would you like to choose your enemy's name? (1 = yes, 0 = no) \n> ";
	cin >> choice;
	if (choice == 1) {
		cout << "Enter the name of your enemy: ";
		cin >> enemyName;

	}
	else {
		// rand(enemyName)
	}

	// clear screen
	cout << "\033[2J\033[1;1H";
}


void game() {
	string playerName = "Hero";
	string enemyName = "Enemy";

	// setup character information
	characterCustomisation(playerName, enemyName);

	Player player(playerName, 100, 20, 10, 10);
	Enemy enemy(enemyName, 100, 20, 10);

	// combat loop
	while (player.getHealth() > 0 && enemy.getHealth() > 0) {
		cout << "\n" << endl;
		displayStats(player, enemy);

		// ============================ Player Turn ============================ //
		// get player combat choice
		int playerCombatChoice;
		cout << "\nWhat's your choice " << player.getName() << "?" << endl;
		cout << "1 -> Attack\n"
			<< "2 -> Defend\n"
			<< "> ";
		cin >> playerCombatChoice;

		// clear screen
		cout << "\033[2J\033[1;1H";

		// calc player attack damage and apply to enemy
		if (playerCombatChoice == 1) {
			int damage = player.attack();
			cout << player.getName() << " attacks" << endl;
			enemy.takeDamage(damage);

			// increase block chance/luck
		}
		else if (playerCombatChoice == 2) {
			player.defend();
			cout << "You increased your block chance to " << player.getBlockChance()
				<< "%" << endl;

		}
		else {
			cout << "Invalid choice!" << endl;
			continue;
		}

		// check if enemy is dead after player turn
		if (enemy.getHealth() == 0) {
			cout << "You have defeated " << enemy.getName() << endl;
			break;
		}


		// ============================ Enemy Turn ============================ //
		// get random number between 0 and 99 for enemy choice
		int enemyChoice = rand() % 100;
		if (enemyChoice > 25) {
			// attack
			int damage = enemy.attack();
			cout << enemy.getName() << " attacks" << endl;
			player.takeDamage(damage);

		}
		else {
			// heavy attack
			int damage = enemy.heavyAttack();
			cout << enemy.getName() << " attacks with ferocity!" << endl;
			player.takeDamage(damage);
		}

		// check if player is dead after enemy turn
		if (player.getHealth() == 0) {
			cout << "You were defeated by " << enemy.getName() << endl;
			break;
		}
	}
}
