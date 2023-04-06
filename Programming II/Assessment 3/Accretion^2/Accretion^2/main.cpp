#include <iostream>
#include "game.h"
using namespace std;

int main() {
    
    game();

    /*
        Fixes
        1. put character customisation into setup.cpp

        Features to add
        1. A boss objective (ask if player wants to fight boss, on defeat they just go back to enemys)
        2. spice up player stats display while in combat
        4. scoreboard
        6. victory screen
        7. create the player and pass it to game so it can pass to combat
        8. create a createEnemy func that will choose an enemy and their stats for the player to pass into combat
        9. format disply to assessment 2
        10. character set up of class system
        12. add dodge chance (influenced by speed)
        13. make stat increasing ablities only last until enemy defeated (add a function to reset the apropriare stats)
        14. see if I need the srand stuff
        15. format code consistently
        16. implement assessment 3 notes
        17. check if player or enemy is dead after each combat turn
        18. add secret name for god player
        19. add a debuff func to player and enemy

        Fixed
        1. added header guards to each header file to prevent header file inception

        Changed
        1. 
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