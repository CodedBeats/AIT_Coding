#include <iostream>
#include "game.h"
using namespace std;

int main() {
    
    game();

    /*
        Fixes
        1. put character customisation into setup.cpp

        Features to add
        2. A boss objective (ask if player wants to fight boss, on defeat they just go back to enemys)
        3. spice up player stats display while in combat
        5. lvl up
        6. scoreboard
        7. class system
        8. victory screen
        9. create the player and pass it to game so it can pass to combat
        10. create a createEnemy func that will choose an enemy and their stats for the player to pass into combat
        11. format disply to assessment 2
        12. character set up of class system
        13. add magic might
        14. add dodge chance (influenced by speed)
        15. make stat increasing ablities only last until enemy defeated (add a function to reset the apropriare stats)
        16. see if I need the srand stuff
        17. format code consistently
        18. implement assessment 3 notes

        Fixed
        1. added inheriting enemy classes and implemented their functions (with no content)
        2. added level and exp to player and enemy (with 0 application yet)

        Changed
        1. changed combat heavy attack chance to just be attack again (so it can be changed to unique enemy attacks)
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