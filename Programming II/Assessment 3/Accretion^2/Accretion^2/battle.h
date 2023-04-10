// Header Guard
#ifndef battle_HEADER_GUARD
#define battle_HEADER_GUARD

#pragma once
#include "player.h"
#include "enemy.h"


// pass class reference so pointers can be passed as params
void handleCombat(Player* player, Enemy* enemy);

bool isFighting(Player* player, Enemy* enemy);

void train(Player* player, Enemy* enemy);




#endif // battle_HEADER_GUARD