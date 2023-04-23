#include <iostream>
#include "trader.h"
using namespace std;

// default constructor
Trader::Trader() {}


// get functions
string Trader::getTrader() const {
	return trader;
}

string Trader::getType() const {
	return type;
}

string Trader::getBaseCurrency() const {
	return base_currency;
}

string Trader::getAssert() const {
	return assert;
}

float Trader::getUnitPrice() const {
	return unit_price;
}

int Trader::getAmount() const {
	return amount;
}

float Trader::getTotal() const {
	return total;
}


// set functions
void Trader::setTrader(string input) {
	trader = input;
}

void Trader::setType(string input) {
	type = input;
}

void Trader::setBaseCurrency(string input) {
	base_currency = input;
}

void Trader::setAssert(string input) {
	assert = input;
}

void Trader::setUnitPrice(float input) {
	unit_price = input;
}

void Trader::setAmount(int input) {
	amount = input;
}

void Trader::setTotal(float input) {
	total = input;
}


// destructor
Trader::~Trader() {
	// trader instance successfully destroyed
}




