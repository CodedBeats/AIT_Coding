#include <iostream>
#include <string>

#include "trader.h"
#include "handleData.h"
using namespace std;


int main() {
    string filename = "data.csv";
    
    vector<Trader> traders = readDataFromFile(filename);

    // read object data
    cout << traders[0].getTrader() << endl;

    // Do something with the traders...

    return 0;
}

// exceptions
// custom exception
// function overloading
// operator overloading
// string search
// array sort
