#pragma once
#include <string>
using namespace std;

// Base class
class Enemy {
public:
    // Enemy constructor
    Enemy(string name, int health, int lvl, int exp, int str, int def, int spd) {
        m_name = name;
        m_health = health;
        m_lvl = lvl;
        m_exp = exp;
        m_str = str;
        m_def = def;
        m_spd = spd;
    };

    // Enemy functions
    string getName();

    int getHealth();

    int getLvl();

    int getExp();

    int getStr();

    int getDef();

    int getSpd();

    int attack();

    void takeDamage(int damage, int defence);


private:
    // Enemy variables
    string m_name;
    int m_health;
    int m_lvl;
    int m_exp;
    int m_str;
    int m_def;
    int m_spd;
};



// Inheriting classes
// Dragon (Boss)
class Dragon: public Enemy {
public:
    int dragonBreath();
    void dragonRoar();
};

// Slime
class Slime: public Enemy {
public:
    int stickSmash();
};

// Hydra
class Hydra: public Enemy {
public:
    int corrosiveSpray();
};

// Harpy
class Harpy: public Enemy {
public:
    int razorFeather();
};

// Specter
class Specter: public Enemy {
public:
    int shadowStrike();
};

// Orc
class Orc: public Enemy {
public:
    int bonecrushingBlow();
};
