// Header Guard
#ifndef trader_HEADER_GUARD
#define trader_HEADER_GUARD

#pragma once
#include <string>
using namespace std;

class Trader {
public:
    // default constructor
    Trader();

    // get functions
    string getTrader() const;

    string getType() const;

    string getBaseCurrency() const;

    string getAssert() const;

    float getUnitPrice() const;

    int getAmount() const;

    float getTotal() const;

    // set functions
    void setTrader(string input);

    void setType(string input);

    void setBaseCurrency(string input);

    void setAssert(string input);

    void setUnitPrice(float input);

    void setAmount(int input);

    void setTotal(float input);

    // destructor
    ~Trader();

private:
    string trader;
    string type;
    string base_currency;
    string assert;
    double unit_price;
    int amount;
    double total;
};


#endif // trader_HEADER_GUARD
