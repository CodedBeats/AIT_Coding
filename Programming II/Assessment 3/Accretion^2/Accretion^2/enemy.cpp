#include <iostream>
#include "enemy.h"
using namespace std;

// === Base Class === //
// use const for get() funcs since they don't modify class variables
// get enemy name
string Enemy::getName() const {
    return m_name;
}

// get enemy health
int Enemy::getHealth() const {
    return m_health;
}

// get enemy level
int Enemy::getLvl() const {
    return m_lvl;
}

// get enemy exp
int Enemy::getExp() const {
    return m_exp;
}

// get enemy strength
int Enemy::getStr() const {
    return m_str;
}

// get enemy defense
int Enemy::getDef() const {
    return m_def;
}

// get enemy speed
int Enemy::getSpd() const {
    return m_spd;
}

// calc enemy attack damage
int Enemy::attack() const {
    return m_str;
}

// buff enemy stats while in battle
void Enemy::buff(string stat) {
    // increase strength by lvl * 5
    if (stat == "str") {
        m_str += (m_lvl * 5);
    }
    // increase defence by lvl * 5
    else if (stat == "def") {
        m_def += (m_lvl * 5);
    }
    // increase speed by lvl * 5
    else if (stat == "spd") {
        m_spd += (m_lvl * 5);
    }
}

// debuff enemy stats while in battle
void Enemy::debuff(string stat) {
    // decrease strength by lvl * 5
    if (stat == "str") {
        m_str -= (m_lvl * 5);
    }
    // decrease defence by lvl * 5
    else if (stat == "def") {
        m_def -= (m_lvl * 5);
    }
    // decrease speed by lvl * 5
    else if (stat == "spd") {
        m_spd -= (m_lvl * 5);
    }
}

// calc enemy damage taken from attack
void Enemy::takeDamage(int damage, int defence) {
    // reduce enemy health by (player damage - enemy defense)
    int applyDamage = (damage - defence);
    m_health -= applyDamage;
    cout << m_name << " takes " << applyDamage << " damage" << endl;

    // set enemy health to 0 incase it would be negative
    if (m_health < 0) {
        m_health = 0;
    }
}



// === Inheriting Classes === //
// Dragon (Boss)
int Dragon::dragonBreath() const {
    // high damage attack
    return 0;
}
void Dragon::dragonRoar() {
    // raises dragon attack
}

// Slime
int Slime::stickySmash() const {
    // attack and reduce player speed
    int enemyStrength = getStr();
    return enemyStrength;
}

// Hydra
int Hydra::corrosiveSpray() const {
    // attack and reduce player defence
    int enemyStrength = getStr();
    return enemyStrength;
}

// Harpy
int Harpy::razorFeather() {
    // attack and increase attack
    int enemyStrength = getStr();
    return enemyStrength;
}

// Specter
int Specter::shadowStrike() const {
    // attack and reduce player block chance
    int enemyStrength = getStr();
    return enemyStrength;
}

// Orc
int Orc::bonecrushingBlow() const {
    // attack and reduce player attack
    int enemyStrength = getStr();
    return enemyStrength;
}

