#include <iostream>
#include "game.h"
using namespace std;

int main() {
    
    game();

    /*
        Features to add
        1. A boss objective (ask if player wants to fight boss, on defeat they just go back to enemys)
        2. spice up player stats display while in combat
        4. scoreboard
        5. let playername be multiple words
        6. victory screen
        8. create a createEnemy func that will choose an enemy and their stats for the player to pass into combat
        9. format disply to assessment 2
        10. character set up of class system
        11. implement player and enemy class based attacks in combat
        12. add dodge chance (influenced by speed)
        13. make stat increasing ablities only last until enemy defeated (add a function to reset the apropriare stats)
        14. see if I need the srand stuff
        15. format code consistently
        16. implement assessment 3 notes
        17. check if player or enemy is dead after each combat turn
        18. add secret name for god player
        19. add a debuff func to player and enemy
        20. explain string quit variables
        
        Fixed
        1. cleaned up project code which mainly involved adding default to switch case and const to class functions (thanks to new extensions)
        2. adding a default to switch case statements to sort of handle errors and unexpected inputs
        3. added const to class functions where they aren't modifying the values of class variables
        4. stil need to fix player and enemy class constructor (for good code, not cause it causes an error)
        5. accidentally messup up some extensions which required a sort of re-install and now some syntax colors are messed up (temp fixed but not perfect)

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