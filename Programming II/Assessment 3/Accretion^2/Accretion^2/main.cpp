#include <iostream>
#include "game.h"
using namespace std;

int main() {
    
    game();

    /*
        Fixes
        1. put character customisation into setup.cpp

        Features to add
        1. Different enemys
        2. A boss objective (ask if player wants to fight boss, on defeat they just go back to enemys)
        3. spice up player stats display while in combat
        5. exp and lvl up
        6. scoreboard
        7. class system
        8. victory screen
        9. create the player and pass it to game so it can pass to combat
        10. create a createEnemy func that will choose an enemy and their stats for the player to pass into combat
        11. format disply to assessment 2
        12. character set up
        13. add magic might
        14. add dodge chance (influenced by speed)
        15. make stat increasing ablities only last until enemy defeated (add a function to reset the apropriare stats)
        16. see if I need the srand stuff
        17. format code consistently
        18. implement assessment 3 notes

        Fixed
        1. created a setup .cpp and .h file to hold player class setup and random enemy and their stats for train setup
        2. added an intro message with the game title that returns the player's name
        4. created a menu display func to to show options and get user int input
        5. created a display stats func that takes player object ref to display the stats of the current player
        6. created a game func that handles the game flow with a switch case statement inside a while loop
        7. added a warning for the quit option in the game func
        8. lots of functions need a revamp with proper pointer params and better file structure (and header guards)

        Changed
        1. changed applyDamage variable name to not sound like a function (calcDamage)
        2. changed game func to be called "train" indicating that it handles the combat of train (not boss fight)
    */
    

    return 0;
}
    


/*
cout << "                                        _     _                   /\\   ___  \n" <<
    "    /\\                                 | |   (_)                 |/\\| |__ \\ \n" <<
    "   /  \\      ___    ___   _ __    ___  | |_   _    ___    _ __           ) |\n" <<
    "  / /\\ \\    / __|  / __| | '__|  / _ \\ | __| | |  / _ \\  | '_ \\         / / \n" <<
    " / ____ \\  | (__  | (__  | |    |  __/ | |_  | | | (_) | | | | |       / /_ \n" <<
    "/_/    \\_\\  \\___|  \\___| |_|     \\___|  \\__| |_|  \\___/  |_| |_|      |____|";
*/
// cout << "\033[2J\033[1;1H";