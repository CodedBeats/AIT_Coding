#include <iostream>
#include "game.h"
using namespace std;

int main() {
    
    game();

    /*
        Fixes
        1. attack func currently minus the wrong defence
        2. implement tabs

        Features to add
        1. Different enemys
        2. A boss objective (ask if player wants to fight boss, on defeat they just go back to enemys)
        3. An inv display
        5. exp
        6. levels, could differ depending on class
        7. class system? (new classes have different abilities and spells)
        8. make a new function to handle combat and replace game
        9. create the player and pass it to game so it can pass to combat
        10. create an arr of enemies and get rand enemy for player to vs
        11. add speed
        12. change defend to "shieldingAura" which increases block chance (as a spell)
        13. add magic might
        14. add dodge chance (influenced by speed)
        14. make stat increasing ablities only last until enemy defeated (add a function to reset the apropriare stats)
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