#include <iostream>
#include "handleData.h"
using namespace std;

vector<Trader> readDataFromFile(const string& filename) {
    ifstream file(filename);
    if (!file.is_open()) {
        cerr << "Failed to open file: " << filename << endl;
        return {};
    }

    // Skip the first line of the CSV file
    string line;
    getline(file, line);

    vector<Trader> traders;

    while (getline(file, line)) {
        Trader trader;
        istringstream iss(line);
        string field;

        // Parse each field separated by commas
        getline(iss, field, ',');
        trader.setTrader(field);

        getline(iss, field, ',');
        trader.setType(field);

        getline(iss, field, ',');
        trader.setBaseCurrency(field);

        getline(iss, field, ',');
        trader.setAssert(field);

        iss >> field;
        trader.setUnitPrice(stod(field));
        iss.ignore(); // Ignore the comma after unit_price

        iss >> field;
        trader.setAmount(stod(field));
        iss.ignore(); // Ignore the comma after unit_price

        iss >> field;
        trader.setTotal(stod(field));

        // add trader to arr
        traders.push_back(trader);
    }

    cout << "Read " << traders.size() << " trades from file." << endl;

    return traders;
}