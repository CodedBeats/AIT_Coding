#include <iostream>
#include "player.h"
using namespace std;

// === Base Class === //
// get player name
string Player::getName() {
    return m_name;
}

// get plyaer class
string Player::getClass() {
    return m_class;
}

// get player health
int Player::getHealth() {
    return m_health;
}

// get player level
int Player::getLevel() {
    return m_lvl;
}

// get player exp
int Player::getExp() {
    return m_exp;
}

// get player strength
int Player::getStr() {
    return m_str;
}

// get player defense
int Player::getDef() {
    return m_def;
}

// get player speed
int Player::getSpd() {
    return m_spd;
}

// get player block chance
int Player::getBlockChance() {
    return m_blockChance;
}

// get player magical might
int Player::getMgcMht() {
    return m_mgcMht;
}

// calc player attack damage
int Player::attack() {
    return m_str;
}

// increase player block chance
void Player::shieldingAura() {
    // cap block chance at 75%
    if (m_blockChance == 75) {
        cout << "Your block chance is already at it's max" << endl;
    }
    else {
        m_blockChance += 5;
    }
}

// increase player's levl
// linear lvl up system cause I can't be assed making an exponential curved system
void Player::lvlUp(bool isClass) {
    // increase lvl
    m_lvl += 1;
    // reset exp
    m_exp = 0;

    // if player has a class then give class specific leveling
    if (isClass) {
        // Berserker
        if (m_class == "Berserker") {
            m_health += 15;
            m_str += 40;
            m_def += 5;
            m_spd += 15;
            // redundant line here to show difference between classes
            m_mgcMht += 0;
        }
        // Mage
        if (m_class == "Mage") {
            m_health += 10;
            m_str += 5;
            m_def += 10;
            m_spd += 10;
            m_mgcMht += 40;
        }
        // Paladin
        if (m_class == "Mage") {
            m_health += 30;
            m_str += 25;
            m_def += 40;
            m_spd += 5;
            m_mgcMht += 15;
        }
        // Ranger
        if (m_class == "Mage") {
            m_health += 15;
            m_str += 15;
            m_def += 15;
            m_spd += 40;
            m_mgcMht += 10;
        }
    }
    // if no class
    else {
        // increase all stats evenly by 10
        m_health += 10;
        m_str += 10;
        m_def += 10;
        m_spd += 10;
        m_mgcMht += 10;
    }
}

// reset changed stats after combat ends
void Player::resetStats() {
    // idk how to do this yet
}

// calc player damage taken from attack
void Player::takeDamage(int damage, int defence) {
    // check for random block first
    int chance = rand() % 100 + 1;
    if (chance <= m_blockChance) {
        cout << m_name << " blocked the attack" << endl;
    }
    else {
        // reduce enemy health by (enemy damage - player defense)
        int applyDamage = (damage - defence);
        m_health -= applyDamage;
        cout << m_name << " takes " << applyDamage << " damage" << endl;

        // == DEBUG ==
        // cout << "==\nPLAYER DEBUG:"
        //     << "\n Health " << m_health 
        //     << "\n Damage " << damage
        //     << "\n Applied Damage " << applyDamage
        //     << "\n Defence " << defence
        //     << "\n==" << endl;

        // set player health to 0 if it would be negative
        if (m_health < 0) {
            m_health = 0;
        }
    }
}




// === Inheriting Classes === //
// Berserker
int Berserker::vengefulVortex() {
    // high damage attack
    return 0;
}
void Berserker::battleFury() {
    // raises attack
}

// Mage
int Mage::meteorShower() {
    // high damage attack
    return 0;
}
int Mage::mindBlast() {
    // reduce enemy defence
    return 0;
}
void Mage::arcaneSurge() {
    // increase magical might
}

// Paladin
int Paladin::holyStrike() {
    // high damage attack
    return 0;
}
void Paladin::shieldOfLight() {
    // increase defence and block chance
}

// Ranger
int Ranger::lethalArrow() {
    // chance based off speed to 1 shot enemy
    return 0;
}
int Ranger::rainOfPain() {
    // attack that hits 5 times with rand below and above a threshold
    return 0;
}
void Ranger::camouflage() {
    // increase speed
}