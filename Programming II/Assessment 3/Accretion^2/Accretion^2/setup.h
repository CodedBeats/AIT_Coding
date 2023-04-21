// Header Guard
#ifndef setup_HEADER_GUARD
#define setup_HEADER_GUARD

#include "player.h"
#include "enemy.h"

#pragma once
#include <string>
using namespace std;


Player* gameSetup(bool gameWon);

Player* playerSetup(string playerName, bool gameWon, int classVal);

Player* combatPlayerSetup(Player* player, string className);

int getPlayerClass();

Enemy* enemySetup(int playerLvl);

Dragon* bossSetup(int playerLvl);



#endif // setup_HEADER_GUARD