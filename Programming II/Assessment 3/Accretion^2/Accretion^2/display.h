// Header Guard
#ifndef display_HEADER_GUARD
#define display_HEADER_GUARD

#pragma once
#include "player.h"
#include "enemy.h"

void displayBattleStats(Player* player, Enemy* enemy);

string welcomePlayer();

int menu();

void displayStats(Player& player);




#endif // display_HEADER_GUARD