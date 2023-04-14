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
    string getName() const;

    string getClass() const;

    int getHealth() const;

    int getLevel() const;

    int getExp() const;

    int getStr() const;

    int getDef() const;

    int getSpd() const;

    int getBlockChance() const;

    int getMgcMht() const;

    virtual int attack() const;

    void shieldingAura();

    void buff(string stat);

    void debuff(string stat);

    void gainExp(int exp);

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
class Berserker : public Player {
public:
    // give Berserker the Player constructor
    using Player::Player;
    // Berserker spells and abilities
    int vengefulVortex() const;
    void battleFury();
};

// Mage 
class Mage : public Player {
public:
    // give Mage the Player constructor
    using Player::Player;
    // Mage spells and abilities
    int meteorShower() const;
    int mindBlast() const;
    void arcaneSurge();
};

// Paladin 
class Paladin : public Player {
public:
    // give Paladin the Player constructor
    using Player::Player;
    // Paladin spells and abilities
    int holyStrike() const;
    void shieldOfLight();
};

// Ranger 
class Ranger : public Player {
public:
    // give Ranger the Player constructor
    using Player::Player;
    // Ranger spells and abilities
    int lethalArrow() const;
    int rainOfPain() const;
    void camouflage();
};



#endif // player_HEADER_GUARD