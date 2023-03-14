#pragma once
#include <string>
using namespace std;

// Base class
class Player {
public:
    Player(string name, int health, int str, int def, int blockChance) {
        m_name = name;
        m_health = health;
        m_str = str;
        m_def = def;
        m_blockChance = blockChance;
    };

    string getName();

    int getHealth();

    int getStr();

    int getDef();

    int getBlockChance();

    int attack();

    void defend();

    void takeDamage(int damage);


private:
    string m_name;
    int m_health;
    int m_str;
    int m_def;
    int m_blockChance;
};
