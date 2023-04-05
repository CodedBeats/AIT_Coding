#pragma once
#include "player.h"
#include "enemy.h"

void displayBattleStats(Player player, Enemy enemy);

string welcomePlayer();

int menu();

void displayStats(Player& player);

// put in different header file
// pass class reference so pointers can be passed as params
void handleCombat(Player& player, Enemy& enemy);

bool isFighting(Player& player, Enemy& enemy);
