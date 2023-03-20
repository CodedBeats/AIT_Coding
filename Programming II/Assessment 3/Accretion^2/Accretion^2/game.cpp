// #include "player.h"
// #include "enemy.h"
#include "display.h"

#include <iostream>
using namespace std;





void characterCustomisation(string& playerName) {
	int choice = 0;

	// user choose player name
	cout << "Choose the name of your Hero!! \n> ";
	// getline(cin, playerName);
	cin >> playerName;

	// clear screen
	cout << "\033[2J\033[1;1H";
}


void game() {
	string playerName = "Hero";
	string enemyName = "Enemy";

	// setup character information
	characterCustomisation(playerName);

	Player player(playerName, 100, 20, 10, 15, 10);
	Enemy enemy(enemyName, 100, 18, 12, 10);

	// define pointers to class so it can be accessed and updated in the fucntion
	Player* pPlayer = &player;
	Enemy* pEnemy = &enemy;

	// combat loop
	bool combatActive = true;
	while (combatActive) {
		cout << "\n" << endl;
		// just use the class since it should be updated from combat()
		displayStats(player, enemy);

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
}