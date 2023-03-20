#pragma once
#include "player.h"
#include "enemy.h"

void displayStats(Player player, Enemy enemy);


// put in different header file

// pass class reference so pointers can be passed as params
void handleCombat(Player& player, Enemy& enemy);

bool isFighting(Player& player, Enemy& enemy);

