#include "player.h"
#include "enemy.h"
#include "setup.h"
#include "display.h"

#include <iostream>
using namespace std;


// setup game instance
Player* gameSetup(bool gameWon) {
    // welcome player and get player name
    string playerName;
    playerName = welcomePlayer();

    // init variable for player class
    int classVal = 0;
    // secret name for god powers
    if (playerName == "Laura") {
        classVal = 69;
    }

    // check if game has been won yet
    if (gameWon) {
        cout << "\033[2J\033[1;1H";

        classVal = getPlayerClass();
        Player* player = playerSetup(playerName, true, classVal);

        // return player instance
        return player;
    }
    else {
        Player* player = playerSetup(playerName, false, classVal);

        // return player instance
        return player;
    }
}



// setup player instance
Player* playerSetup(string playerName, bool gameWon, int classVal) {
    // create player object
    if (gameWon) {
        // create player with class and different stats
        switch (classVal) {
        case 1: {
            // === Berserker === //
            Berserker* player = new (nothrow) Berserker(playerName, "Berserker", 115, 1, 0, 60, 15, 30, 10, 0);
            return player;
        }
        case 2: {
            // === Mage === //
            Mage* player = new (nothrow) Mage(playerName, "Mage", 110, 1, 0, 25, 20, 25, 10, 60);
            return player;
        }
        case 3: {
            // === Paladin === //
            Paladin* player = new (nothrow) Paladin(playerName, "Paladin", 130, 1, 0, 45, 60, 20, 10, 20);
            return player;
        }
        case 4: {
            // === Ranger === //
            Ranger* player = new (nothrow) Ranger(playerName, "Ranger", 115, 1, 0, 35, 25, 60, 10, 15);
            return player;
        }
        default: {
            // something went wrong, classVal should only be 1-4, create default player
            Player* player = new (nothrow) Player(playerName, "none", 100, 1, 0, 20, 10, 15, 10, 5);
            return player;
        }
        }
    }
    else {
        // create god player
        if (classVal == 69) {
            // use absurdly high stats
            Player* player = new (nothrow) Player(playerName, "none", 1000, 1, 0, 1000, 1000, 1000, 1000, 1000);
            return player;
        }
        // create player with no class
        else {
            Player* player = new (nothrow) Player(playerName, "none", 100, 1, 0, 20, 10, 15, 10, 5);
            return player;
        }
    }
}



// setup combat player for training and boss fight
Player* combatPlayerSetup(Player* player, string className) {

    if (className == "Berserker") {
        Berserker* combatPlayer = new (nothrow) Berserker(player->getName(), player->getClass(), player->getHealth(), player->getLevel(), player->getExp(), player->getStr(), player->getDef(), player->getSpd(), player->getBlockChance(), player->getMgcMht());
        return combatPlayer;
    }
    else if (className == "Mage") {
        Mage* combatPlayer = new (nothrow) Mage(player->getName(), player->getClass(), player->getHealth(), player->getLevel(), player->getExp(), player->getStr(), player->getDef(), player->getSpd(), player->getBlockChance(), player->getMgcMht());
        return combatPlayer;
    }
    else if (className == "Paladin") {
        Paladin* combatPlayer = new (nothrow) Paladin(player->getName(), player->getClass(), player->getHealth(), player->getLevel(), player->getExp(), player->getStr(), player->getDef(), player->getSpd(), player->getBlockChance(), player->getMgcMht());
        return combatPlayer;
    }
    else if (className == "Ranger") {
        Ranger* combatPlayer = new (nothrow) Ranger(player->getName(), player->getClass(), player->getHealth(), player->getLevel(), player->getExp(), player->getStr(), player->getDef(), player->getSpd(), player->getBlockChance(), player->getMgcMht());
        return combatPlayer;
    }
    else {
        Player* combatPlayer = new (nothrow) Player(*player);
        return combatPlayer;
    }
}



// setup class choice if game has been won
int getPlayerClass() {
    int classVal;

    cout << "Classes:\n\n"
        << "---Berserker---\n"
        << "Unleash your fury with lightning-fast strikes. Just be careful not to get hit!\n\n"
        << "---Mage---\n"
        << "Harness the power of magic to decimate your foes. But beware, your frail body may not withstand many blows.\n\n"
        << "---Paladin---\n"
        << "Stand tall as a bulwark against the enemy. With strong defense and mighty strength, you can take on anything. Just don't expect to outrun it.\n\n"
        << "---Ranger---\n"
        << "Quick on your feet, and even quicker with a bow. You might not be the strongest or the toughest, but your agility is unmatched.\n\n"
        << "1 = Berserker, 2 = Mage, 3 = Paladin, 4 = Ranger, (Any other number = no class)\n"
        << "Please enter your choice (1 - 4)\n"
        << "> ";
    
    
    // get player class choice
    try {
        cin >> classVal;

        // check if input was an int
        if (!cin) {
            // input was not an integer
            throw 1;
        }
    }
    // catch exception
    catch (int n) {
        cin.clear();
        cin.ignore(512, '\n');
        // scroll up to see exception message
        cout << "Player class choice was not an integer";
        classVal = 5;
    }

    return classVal;
}



// setup enemy instance for training
Enemy* enemySetup(int playerLvl) {
    // set random enemy stats based off player lvl
    // formula: value = lvl1Value + (rand(1-playerLvl) * 10)
    // generate random enemy level from 1 to playerLvl
    int randomEnemyLvl = rand() % playerLvl + 1;
    // multiply randomEnemyLvl by the general increase of lvl for each stat
    int randHealth = 90 + (randomEnemyLvl * 10);
    int randLvl = randomEnemyLvl;
    int randExp = randomEnemyLvl * 15;
    int randStr = 5 + (randomEnemyLvl * 10);
    int randDef = randomEnemyLvl * 10;
    int randSpd = randomEnemyLvl * 10;

    // set array of enemy name options
    string enemyNames[5] = { "Slime", "Hydra", "Harpy", "Specter", "Orc" };

    // Randomly select an enemy name from the array
    int i = rand() % 5;
    string randEnemyName = enemyNames[i];

    // Create an instance of the selected enemy class based on its name
    // Slime enemy
    if (randEnemyName == "Slime") {
        Slime* enemy = new (nothrow) Slime("Slime", randHealth, randLvl, randExp, randStr, randDef, randSpd);
        return enemy;
    }
    // Hydra enemy
    else if (randEnemyName == "Hydra") {
        Hydra* enemy = new (nothrow) Hydra("Hydra", randHealth, randLvl, randExp, randStr, randDef, randSpd);
        return enemy;
    }
    // Harpy enemy
    else if (randEnemyName == "Harpy") {
        Harpy* enemy = new (nothrow) Harpy("Harpy", randHealth, randLvl, randExp, randStr, randDef, randSpd);
        return enemy;
    }
    // Specter enemy
    else if (randEnemyName == "Specter") {
        Specter* enemy = new (nothrow) Specter("Specter", randHealth, randLvl, randExp, randStr, randDef, randSpd);
        return enemy;
    }
    // Orc enemy
    else if (randEnemyName == "Orc") {
        Orc* enemy = new (nothrow) Orc("Orc", randHealth, randLvl, randExp, randStr, randDef, randSpd);
        return enemy;
    }
}



// setup dragon for boss fight
Dragon* bossSetup(int playerLvl) {
    // set boss stats based off player lvl
    int bossHealth = 200 + (playerLvl * 10);
    int bossLvl = 10;
    int bossStr = 100;
    int bossDef = 100;
    int bossSpd = 100;

    Dragon* boss = new (nothrow) Dragon("Abyssalix", bossHealth, bossLvl, 0, bossStr, bossDef, bossSpd);
    return boss;
}
