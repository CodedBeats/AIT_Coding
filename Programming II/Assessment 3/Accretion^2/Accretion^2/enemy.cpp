#include <iostream>
#include "classes.h"
using namespace std;

// get enemy name
string Enemy::getName() {
    return m_name;
}

// get enemy health
int Enemy::getHealth() {
    return m_health;
}

// get enemy strength
int Enemy::getStr() {
    return m_str;
}

// get enemy defense
int Enemy::getDef() {
    return m_def;
}

// calc enemy attack damage
int Enemy::attack() {
    // damage = str - def
    int damage = m_str - m_def;
    return damage;
}

// calc enemy heavy attack damage
int Enemy::heavyAttack() {
    // damage = str
    int damage = m_str;
    return damage;
}

// calc enemy damage taken from attack
void Enemy::takeDamage(int damage) {
    // reduce enemy health by damage
    m_health -= damage;
    cout << m_name << " takes " << damage << " damage" << endl;
    
    // set enemy health to 0 if it would be negative
    if (m_health < 0) {
        m_health = 0;
    }
}