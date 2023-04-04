#include "player.h"
#include "enemy.h"

#include <iostream>
using namespace std;

// maybe move this func
// display stats screen for combat
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


// Welcome player to game
string welcomePlayer() {
    string playerName;

    // display game title and welcome player
    // game title
    cout << "                                        _     _                   /\\   ___  \n" <<
        "    /\\                                 | |   (_)                 |/\\| |__ \\ \n" <<
        "   /  \\      ___    ___   _ __    ___  | |_   _    ___    _ __           ) |\n" <<
        "  / /\\ \\    / __|  / __| | '__|  / _ \\ | __| | |  / _ \\  | '_ \\         / / \n" <<
        " / ____ \\  | (__  | (__  | |    |  __/ | |_  | | | (_) | | | | |       / /_ \n" <<
        "/_/    \\_\\  \\___|  \\___| |_|     \\___|  \\__| |_|  \\___/  |_| |_|      |____|" <<
        "\n\n";
    // welcome message
    cout <<
        "Brave hero, a dragon has terrorized our land for far too long.\n" <<
        "You are our only hope to vanquish this fearsome foe and restore peace to our kingdom.\n" <<
        "Tell us your name\n" <<
        "> ";
    cin >> playerName;

    return playerName;
}


// display menu and get input
int menu() {
    // clear screen before out function output
    cout << "\033[2J\033[1;1H";

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
    // clear screen before out function output
    cout << "\033[2J\033[1;1H";

    // declare random variable just to exit this stats screen
    string exit;

    // output player stats
    cout <<
        "=== Stats ===\n" <<
        player.getName() << "\n" <<
        "Class:\t\t\t" << "class" << "\n" <<
        "Health:\t\t\t" << player.getHealth() << "\n" <<
        "Level:\t\t\t" << "lvl" << "\n" <<
        "Exp:\t\t\t" << "exp" << "\n" <<
        "Strength:\t\t" << player.getStr() << "\n" <<
        "Defence:\t\t" << player.getDef() << "\n" <<
        "Speed:\t\t\t" << player.getSpd() << "\n" <<
        "Block Chance:\t\t" << player.getBlockChance() << "\n" <<
        "Magical Might:\t\t" << "xx" << "\n\n";

    // Return to menu
    cout << "Type (0) to return to menu\n" <<
        "> ";
    cin >> exit;

}