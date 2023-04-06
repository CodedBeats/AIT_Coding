// Header Guard
#ifndef player_HEADER_GUARD
#define player_HEADER_GUARD

#pragma once
#include <string>
using namespace std;

// Base class
class Player {
public:
    // Player constructor
    Player(string name, string playerClass, int health, int lvl, int exp, int str, int def, int spd, int blockChance, int mgcMht) {
        m_name = name;
        m_class = playerClass;
        m_health = health;
        m_lvl = lvl;
        m_exp = exp;
        m_str = str;
        m_def = def;
        m_spd = spd;
        m_blockChance = blockChance;
        m_mgcMht = mgcMht;
    };

    // Player functions
    string getName();

    string getClass();

    int getHealth();

    int getLevel();

    int getExp();

    int getStr();

    int getDef();

    int getSpd();

    int getBlockChance();

    int getMgcMht();

    int attack();

    void shieldingAura();

    void lvlUp(bool isClass);

    void resetStats();

    void takeDamage(int damage, int defence);


private:
    // Player variables
    string m_name;
    string m_class;
    int m_health;
    int m_lvl;
    int m_exp;
    int m_str;
    int m_def;
    int m_spd;
    int m_blockChance;
    int m_mgcMht;
};


// Inheriting classes
// Berserker
class Berserker: public Player {
public:
    int vengefulVortex();
    void battleFury();
};

// Mage 
class Mage: public Player {
public:
    int meteorShower();
    int mindBlast();
    void arcaneSurge();
};

// Paladin 
class Paladin: public Player {
public:
    int holyStrike();
    void shieldOfLight();
};

// Ranger 
class Ranger: public Player {
public:
    int lethalArrow();
    int rainOfPain();
    void camouflage();
};



#endif // player_HEADER_GUARD
