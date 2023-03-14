#pragma once
#include <string>
using namespace std;


// ================================== Player Classes ================================== // 
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



// ================================== Enemy Classes ================================== // 
// Base class
class Enemy {
    public:
        Enemy(string name, int health, int str, int def) {
            m_name = name;
            m_health = health;
            m_str = str;
            m_def = def;
        };

        string getName();

        int getHealth();

        int getStr();

        int getDef();

        int attack();

        int heavyAttack();

        void takeDamage(int damage);


    private:
        string m_name;
        int m_health;
        int m_str;
        int m_def;
};



// ================================== Other functions that require class params ================================== // 

void displayStats(Player player, Enemy enemy);



