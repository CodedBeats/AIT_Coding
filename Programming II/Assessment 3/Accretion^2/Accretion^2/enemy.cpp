#include <iostream>
#include "enemy.h"
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

// get enemy speed
int Enemy::getSpd() {
    return m_spd;
}

// calc enemy attack damage
int Enemy::attack() {
    return m_str;
}

// calc enemy heavy attack damage
int Enemy::heavyAttack() {
    // damage = str
    int damage = m_str * 2;
    return damage;
}

// calc enemy damage taken from attack
void Enemy::takeDamage(int damage, int defence) {
    // reduce enemy health by (player damage - enemy defense)
    int applyDamage = (damage - defence);
    m_health -= applyDamage;
    cout << m_name << " takes " << applyDamage << " damage" << endl;

    // == DEBUG ==
    // cout << "==\nENEMY DEBUG:"
    //     << "\n Health " << m_health 
    //     << "\n Damage " << damage
    //     << "\n Applied Damage " << applyDamage
    //     << "\n Defence " << defence
    //     << "\n==" << endl;

// set enemy health to 0 if it would be negative
    if (m_health < 0) {
        m_health = 0;
    }
}