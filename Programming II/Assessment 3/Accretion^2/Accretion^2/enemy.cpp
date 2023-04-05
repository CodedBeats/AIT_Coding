#include <iostream>
#include "enemy.h"
using namespace std;

// === Base Class ===

// get enemy name
string Enemy::getName() {
    return m_name;
}

// get enemy health
int Enemy::getHealth() {
    return m_health;
}

// get enemy level
int Enemy::getLvl() {
    return m_lvl;
}

// get enemy exp
int Enemy::getExp() {
    return m_exp;
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

    // set enemy health to 0 incase it would be negative
    if (m_health < 0) {
        m_health = 0;
    }
}



// === Inheriting Classes ===
// Dragon (Boss)
int Dragon::dragonBreath() {
    // high damage attack
    return 0;
}
void Dragon::dragonRoar() {
    // raises dragon attack
}

// Slime
int Slime::stickSmash() {
    // attack and reduce player speed
    return 0;
}

// Hydra
int Hydra::corrosiveSpray() {
    // attack and reduce player def
    return 0;
}

// Harpy
int Harpy::razorFeather() {
    // attack and increase attack
    return 0;
}

// Specter
int Specter::shadowStrike() {
    // attack and enemy go first
    return 0;
}

// Orc
int Orc::bonecrushingBlow() {
    // attack and reduce player defence
    return 0;
}


