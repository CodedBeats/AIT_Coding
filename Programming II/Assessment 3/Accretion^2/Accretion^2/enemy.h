// Header Guard
#ifndef enemy_HEADER_GUARD
#define enemy_HEADER_GUARD

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
    string getName() const;

    int getHealth() const;

    int getLvl() const;

    int getExp() const;

    int getStr() const;

    int getDef() const;

    int getSpd() const;

    int attack() const;

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
    int dragonBreath() const;
    void dragonRoar();
};

// Slime
class Slime: public Enemy {
public:
    int stickySmash() const;
};

// Hydra
class Hydra: public Enemy {
public:
    int corrosiveSpray() const;
};

// Harpy
class Harpy: public Enemy {
public:
    int razorFeather();
};

// Specter
class Specter: public Enemy {
public:
    int shadowStrike() const;
};

// Orc
class Orc: public Enemy {
public:
    int bonecrushingBlow() const;
};


#endif // enemy_HEADER_GUARD
