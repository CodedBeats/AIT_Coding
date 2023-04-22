// Header Guard
#ifndef scoreboard_HEADER_GUARD
#define scoreboard_HEADER_GUARD

#pragma once
#include <vector>
#include <string>
using namespace std;

class Scoreboard {
public:
    // constructor
    Scoreboard();

    // Scoreboard functions
    void getScoreboard() const;

    void updateScoreboard(string name, string className, int lvl);

    // destructor
    ~Scoreboard();


private:
    // Scoreboard variables
    vector<string> scoreboardArr;
};



#endif // scoreboard_HEADER_GUARD