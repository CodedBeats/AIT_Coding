#include "player.h"
#include "enemy.h"

#include <iostream>
using namespace std;

/*
Welcome screen

scoreboard
*/

void displayStats(Player player, Enemy enemy) {
	// Player stats
	cout << player.getName()
		<< "\t\t (HP: " << player.getHealth()
		// deftenss basically being block chance just with a nicer name
		<< ", Dfnd: " << player.getBlockChance() << "%"
		<< ")" << endl;

	// Enemy stats
	cout << enemy.getName()
		<< "\t (HP: " << enemy.getHealth()
		<< ")" << endl;
}