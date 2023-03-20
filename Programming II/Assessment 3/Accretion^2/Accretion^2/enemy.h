#pragma once
#include <string>
using namespace std;

// Base class
class Enemy {
public:
    Enemy(string name, int health, int str, int def, int spd) {
        m_name = name;
        m_health = health;
        m_str = str;
        m_def = def;
        m_spd = spd;
    };

    string getName();

    int getHealth();

    int getStr();

    int getDef();

    int getSpd();

    int attack();

    int heavyAttack();

    void takeDamage(int damage, int defence);


private:
    string m_name;
    int m_health;
    int m_str;
    int m_def;
    int m_spd;
};


