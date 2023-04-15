// Header Guard
#ifndef battle_HEADER_GUARD
#define battle_HEADER_GUARD

#pragma once
#include "player.h"
#include "enemy.h"


// pass class reference so pointers can be passed as params
void handleCombat(Player* player, Enemy* enemy);

void handleBossFight(Player* player, Dragon* dragon);

bool isFighting(Player* player, Enemy* enemy);

void train(Player* player, Player* combatPlayer, Enemy* enemy, bool gameWon);

bool bossFight(Player* player, Dragon* dragon);




#endif // battle_HEADER_GUARD