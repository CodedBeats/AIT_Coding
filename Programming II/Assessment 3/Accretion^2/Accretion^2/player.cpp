#include <iostream>
#include "classes.h"
using namespace std;

// get player name
string Player::getName() {
    return m_name;
}

// get player health
int Player::getHealth() {
    return m_health;
}

// get player strength
int Player::getStr() {
    return m_str;
}

// get player defense
int Player::getDef() {
    return m_def;
}

// get player block chance
int Player::getBlockChance() {
    return m_blockChance;
}

// calc player attack damage
int Player::attack() {
    // damage = str - def
    int damage = m_str - m_def;
    return damage;
}

// increase player block chance
void Player::defend() {
    // cap block chance at 75%
    if (m_blockChance == 75) {
        cout << "Your block chance is already at it's max" << endl;
    } else {
        m_blockChance += 5;
    }
}

// calc player damage taken from attack
void Player::takeDamage(int damage) {
    // check for random block first
    int chance = rand() % 100 + 1;
    if (chance <= m_blockChance) {
        cout << m_name << " blocked the attack" << endl;
        
    } else {
        // reduce player health by damage
        m_health -= damage;
        cout << m_name << " takes " << damage << " damage" << endl;
        
        // set player health to 0 if it would be negative
        if (m_health < 0) {
            m_health = 0;
        }
    }
}