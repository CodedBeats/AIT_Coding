#include "player.h"
#include "enemy.h"

#include <iostream>
using namespace std;


// display stats screen for combat
void displayBattleStats(Player* player, Enemy* enemy) {
    cout << player->getName()
        << "\t (HP: " << player->getHealth()
        << ", Lvl: " << player->getLevel()
        << ", Str: " << player->getStr()
        << ", Def: " << player->getDef()
        << ", Spd: " << player->getSpd()
        // Dfnd being defend chance
        << ", Dfnd: " << player->getBlockChance() << "%"
        << ")" << endl;

    cout << enemy->getName()
        << "\t (HP: " << enemy->getHealth()
        << ", Lvl: " << enemy->getLvl()
        << ", Str: " << enemy->getStr()
        << ", Def: " << enemy->getDef()
        << ", Spd: " << enemy->getSpd()
        << ")" << endl;
}


// Welcome player to game
string welcomePlayer() {
    string playerName;

    // display game title
    cout << "                                        _     _                   /\\   ___  \n" <<
        "    /\\                                 | |   (_)                 |/\\| |__ \\ \n" <<
        "   /  \\      ___    ___   _ __    ___  | |_   _    ___    _ __           ) |\n" <<
        "  / /\\ \\    / __|  / __| | '__|  / _ \\ | __| | |  / _ \\  | '_ \\         / / \n" <<
        " / ____ \\  | (__  | (__  | |    |  __/ | |_  | | | (_) | | | | |       / /_ \n" <<
        "/_/    \\_\\  \\___|  \\___| |_|     \\___|  \\__| |_|  \\___/  |_| |_|      |____|" <<
        "\n\n";
    // display welcome message
    cout <<
        "Brave hero, a dragon has terrorized our land for far too long.\n" <<
        "You are our only hope to vanquish this fearsome foe and restore peace to our kingdom.\n" <<
        "Tell us your name\n" <<
        "> ";
    // get player name (can be multiple words)
    getline(cin, playerName);

    return playerName;
}


// display menu and get input
int menu() {
    // declare player input
    int playerInput;

    // display player menu choice
    cout <<
        "=== Menu ===\n" <<
        "(1) - Boss Fight\n" <<
        "(2) - Train\n" <<
        "(3) - View Stats\n" <<
        "(4) - Scoreboard\n" <<
        "(5) - Quit\n\n" <<
        "Enter your choice (1 - 5)\n" <<
        "> ";
    // get player choice
    cin >> playerInput;

    return playerInput;
}


// display player stats
void displayStats(Player& player) {
    // declare random variable just to exit the stats screen
    string exit;

    // output player stats
    cout <<
        "=== Stats ===\n" <<
        player.getName() << "\n" <<
        "Class:\t\t\t" << player.getClass() << "\n" <<
        "Health:\t\t\t" << player.getHealth() << "\n" <<
        "Level:\t\t\t" << player.getLevel() << "\n" <<
        // show how much exp player needs to reach the next lvl
        "Exp:\t\t\t" << player.getExp() << "/" << (player.getLevel() * 50) << "\n" <<
        "Strength:\t\t" << player.getStr() << "\n" <<
        "Defence:\t\t" << player.getDef() << "\n" <<
        "Speed:\t\t\t" << player.getSpd() << "\n" <<
        "Block Chance:\t\t" << player.getBlockChance() << "\n" <<
        "Magical Might:\t\t" << player.getMgcMht() << "\n\n";

    // Return to menu
    cout << "Type (0) to return to menu\n" <<
        "> ";
    cin >> exit;

}


// display victory screen
void displayVictory() {
    // declare random variable just to exit the victory screen
    string exit;

    // game title
    cout << "                                        _     _                   /\\   ___  \n" <<
        "    /\\                                 | |   (_)                 |/\\| |__ \\ \n" <<
        "   /  \\      ___    ___   _ __    ___  | |_   _    ___    _ __           ) |\n" <<
        "  / /\\ \\    / __|  / __| | '__|  / _ \\ | __| | |  / _ \\  | '_ \\         / / \n" <<
        " / ____ \\  | (__  | (__  | |    |  __/ | |_  | | | (_) | | | | |       / /_ \n" <<
        "/_/    \\_\\  \\___|  \\___| |_|     \\___|  \\__| |_|  \\___/  |_| |_|      |____|" <<
        "\n\n";

    cout << "You have accomplished what many deemed impossible by defeating the mighty dragon Abyssalix and restoring peace to our land\n"
        << "Your courage and strength have inspired us all, and we are forever grateful for your valliant efforts.\n"
        << "Let the bards sing of your heroism for generations to come, and may your name be forever etched in the annals of our history.\n"
        << "Congradulations brave hero, on your momentous victory!\n"
        << "You may check the scoreboard at any time to see your stats when you defeated the Dragon Abyssalix" << endl;

    // Return to menu
    cout << "\nType (0) to continue\n" <<
        "> ";
    cin >> exit;
}
