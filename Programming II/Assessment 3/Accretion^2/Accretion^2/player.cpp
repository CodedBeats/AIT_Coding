#include <iostream>
#include "player.h"
using namespace std;

// === Base Class === //
// destructor 
Player::~Player() {
    // un-comment this line when debugging and scroll up
    // cout << "Player instance destructed successfully" << endl;
}

// use const for get() funcs since they don't modify class variables
// get player name
string Player::getName() const {
    return m_name;
}

// get plyaer class
string Player::getClass() const {
    return m_class;
}

// get player health
int Player::getHealth() const {
    return m_health;
}

// get player level
int Player::getLevel() const {
    return m_lvl;
}

// get player exp
int Player::getExp() const {
    return m_exp;
}

// get player strength
int Player::getStr() const {
    return m_str;
}

// get player defense
int Player::getDef() const {
    return m_def;
}

// get player speed
int Player::getSpd() const {
    return m_spd;
}

// get player block chance
int Player::getBlockChance() const {
    return m_blockChance;
}

// get player magical might
int Player::getMgcMht() const {
    return m_mgcMht;
}

// calc player attack damage
int Player::attack() const {
    return m_str;
}

// increase player block chance
void Player::shieldingAura() {
    // cap block chance at 50%
    if (m_blockChance >= 50) {
        cout << "Your block chance is already at it's max" << endl;
    }
    else {
        m_blockChance += 5;
    }
}

// buff player stats while in battle
void Player::buff(string stat) {
    // increase strength by (lvl + 4)
    if (stat == "str") {
        m_str += (m_lvl + 4);
    }
    // increase defence by (lvl + 4)
    else if (stat == "def") {
        m_def += (m_lvl + 4);
    }
    // increase speed by (lvl + 4)
    else if (stat == "spd") {
        m_spd += (m_lvl + 4);
    }
    // increase block chance by (lvl + 4)
    else if (stat == "blockChance") {
        m_blockChance += (m_lvl + 4);
    }
    // increase magical might by (lvl + 4)
    else if (stat == "mgcMht") {
        m_mgcMht += (m_lvl + 4);
    }
}

// debuff player stats while in battle
void Player::debuff(string stat) {
    // set currentStat as stat to be reduced 
    int* currentStat = nullptr;

    // strength
    if (stat == "str") {
        currentStat = &m_str;
    }
    // defence
    else if (stat == "def") {
        currentStat = &m_def;
    }
    // speed
    else if (stat == "spd") {
        currentStat = &m_spd;
    }
    // block chance
    else if (stat == "blockChance") {
        currentStat = &m_blockChance;
    }

    // stats can't drop below 5
    if (*currentStat <= 5) {
        return;
    }
    // decrease stat by (lvl + 4)
    else {
        *currentStat -= (m_lvl + 4);
    }
}

// give player exp from enemy after victorious battle
void Player::gainExp(int exp) {
    m_exp += exp;
}

// increase player's levl
// linear lvl up system cause I can't be assed making an exponential curved system
void Player::lvlUp(bool isClass) {
    // -1 lvl worth of exp (so it can handle multiple calls)
    m_exp -= (m_lvl * 50);
    // increase lvl
    m_lvl += 1;

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

            // display how much stats are increased by
            cout << "Health\t\t+15\n"
                << "Strength\t+40\n"
                << "Defence\t\t+5\n"
                << "Speed\t\t+15\n"
                << "Magical Might\t+0\n"
                << endl;
        }
        // Mage
        if (m_class == "Mage") {
            m_health += 10;
            // redundant line here to show difference between classes
            m_str += 0;
            m_def += 10;
            m_spd += 10;
            m_mgcMht += 40;

            // display how much stats are increased by
            cout << "Health\t\t+10\n"
                << "Strength\t+0\n"
                << "Defence\t\t+10\n"
                << "Speed\t\t+10\n"
                << "Magical Might\t+40\n"
                << endl;
        }
        // Paladin
        if (m_class == "Paladin") {
            m_health += 30;
            m_str += 25;
            m_def += 40;
            m_spd += 5;
            m_mgcMht += 15;

            // display how much stats are increased by
            cout << "Health\t\t+30\n"
                << "Strength\t+25\n"
                << "Defence\t\t+40\n"
                << "Speed\t\t+5\n"
                << "Magical Might\t+15\n"
                << endl;
        }
        // Ranger
        if (m_class == "Ranger") {
            m_health += 15;
            m_str += 15;
            m_def += 15;
            m_spd += 40;
            m_mgcMht += 10;

            // display how much stats are increased by
            cout << "Health\t\t+15\n"
                << "Strength\t+15\n"
                << "Defence\t\t+15\n"
                << "Speed\t\t+40\n"
                << "Magical Might\t+10\n"
                << endl;
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

// calc player damage taken from attack
void Player::takeDamage(int damage, int defence, bool isDebuff, string debuffStat) {
    // set random variables that stop damage
    int blockChance = rand() % 100 + 1;
    int dodgeChance = rand() % 1000 + 1;

    // check for random block chance based on blockChance stat
    if (blockChance <= m_blockChance) {
        cout << m_name << " blocked the attack" << endl;
    }
    // check for random dodge chance based on speed stat
    else if (dodgeChance <= m_spd) {
        cout << m_name << " swiftly dodged the attack" << endl;
    }

    // take damage
    else {
        // reduce enemy health by (enemy damage - (player defense / 2))
        int applyDamage = (damage - (defence / 2));
        // stop damage being less than 0 and increasing player health, also set damage to always be at least 1
        if (applyDamage <= 0) {
            applyDamage = 1;
        }
        m_health -= applyDamage;
        cout << m_name << " takes " << applyDamage << " damage" << endl;

        // handle potential debuff
        if (isDebuff) {
            debuff(debuffStat);
            cout << m_name << "'s " << debuffStat << " reduced" << endl;
        }

        // set player health to 0 if it would be negative
        if (m_health < 0) {
            m_health = 0;
        }
    }
}




// === Inheriting Classes === //
// Berserker
int Berserker::vengefulVortex() const {
    // high damage attack
    int playerDamage = getStr() * 1.5;
    return playerDamage;
}
void Berserker::battleFury() {
    // raises attack
    buff("str");
}

// Mage
int Mage::meteorShower() const {
    // high damage attack
    int playerDamage = getMgcMht() * 1.5;
    return playerDamage;
}
int Mage::mindBlast() const {
    // attack and reduce enemy defence
    int playerDamage = getMgcMht();
    return playerDamage;
}
void Mage::arcaneSurge() {
    // increase magical might
    buff("mgcMht");
}

// Paladin
int Paladin::holyStrike() const {
    // high damage attack
    int playerDamage = getStr() * 1.5;
    return playerDamage;
}
void Paladin::shieldOfLight() {
    // increase defence
    buff("def");
    // increase block chance
    // cap block chance at 75%
    if (getBlockChance() >= 50) {
        cout << "Your block chance is already at it's max" << endl;
    }
    else {
        buff("blockChance");
    }
}

// Ranger
int Ranger::lethalArrow(int speed) const {
    int playerDamage;
    // get rand number between 0 and 1000
    int chance = rand() % 2000;
    // chance based off speed to 1 shot enemy
    if (speed >= chance) {
        playerDamage = 1000000;
        return playerDamage;
    }
    // else do 1 damage
    else {
        playerDamage = 1000000;
        return playerDamage;
    }
}
int Ranger::rainOfPain() const {
    int playerDamage;
    // get rand number between 2 and 5
    int chance = 2 + rand() % 5;
    // attack hits chance times
    playerDamage = getStr() * chance;
    return playerDamage;
}
void Ranger::camouflage() {
    // increase speed
    buff("spd");
}