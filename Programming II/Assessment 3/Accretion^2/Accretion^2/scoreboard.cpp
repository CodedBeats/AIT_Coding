#include <iostream>
#include "scoreboard.h"
using namespace std;

// === Base Class === //
// constructor
Scoreboard::Scoreboard() {}


// destructor 
Scoreboard::~Scoreboard() {
    // un-comment this line when debugging and scroll up
    // cout << "Scoreboard instance destructed successfully" << endl;
}


// use const for get() func since it doesn't modify class variables
// display scoreboard
void Scoreboard::getScoreboard() const {
    string exit;
    
    // display message if player hasn't won yet
    if (scoreboardArr.size() == 0) {
        cout << "No stats recorded\n"
            << "Defeat the boss to have your stats etched in history" << endl;
    }

    // show all instances of when the player beat the game
    for (int i = 0; i < scoreboardArr.size(); i++) {
        cout << scoreboardArr[i] << endl;
    }

    // Return to menu
    cout << "\nType (0) to return to menu\n" <<
        "> ";
    cin >> exit;
}

// update scoreboard with player's name, class and lvl + a line seperator
void Scoreboard::updateScoreboard(string name, string className, int lvl) {
    // declare variables that will be added to scoreboard arr
    string playerName = "Name: \t\t" + name;
    string playerClassName = "Class: \t\t" + className;
    string playerLvl = "Level: \t\t" + to_string(lvl);
    string lineBreak = "------------------------------";

    // add player stats + line break to arr
    scoreboardArr.push_back(playerName);
    scoreboardArr.push_back(playerClassName);
    scoreboardArr.push_back(playerLvl);
    scoreboardArr.push_back(lineBreak);
}

