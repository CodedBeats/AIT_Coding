#include <iostream>
#include "game.h"
using namespace std;

int main() {
    
    game();

    /*
        Fixes
        1.
        2. implement tabs

        Features to add
        1. Different enemys
        2. A boss objective (ask if player wants to fight boss, on defeat they just go back to enemys)
        3. An player stats display
        5. exp and lvl up
        6. scoreboard
        7. class system? (new classes have different abilities and spells)
        8. menu (with: Boss Fight, Train, View Stats, Scoreboard, Exit)
        9. create the player and pass it to game so it can pass to combat
        10. create a createEnemy func that will choose an enemy and their stats for the player to pass into combat
        11. format disply to assessment 2
        12. character set up
        13. add magic might
        14. add dodge chance (influenced by speed)
        15. make stat increasing ablities only last until enemy defeated (add a function to reset the apropriare stats)

        Fixed
        1. changed defend to shieldingAura
        2. fixed the take damage calc
        3. added speed
        4. created seperate player and enemy turn funcs
        5. added a combat function that has player or enemy go first depending on speed
        6. combat function takes pointer params to properly update class values
        7. added a battleContinue function that returns bool for the game loop

        Changed
        1. added some console messages purely for debug purposes (currently commented out)
    */



    /*
        === Game Flow ===
        intro() -> calls -> characterCustomisation()

        menu() -> calls -> bossFight(), train(), viewStats(), scoreboard(), exit()

        bossFight() -> calls -> enemySetup(), combat()
        train() -> calls -> enemySetup(), combat()
        viewStats()
        scoreboard()
        exit()
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