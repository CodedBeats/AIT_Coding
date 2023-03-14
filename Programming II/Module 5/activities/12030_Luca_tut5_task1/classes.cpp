#include "classes.h"
#include <iostream>
using namespace std;


void Date::setDate(int d, int m, int y) {
    if (d > 31 || d < 1) {
        cout << "This is an invalid date, feel satan's wrath" << endl;
        // set date equal to 666 for satan's wrath
        date = 666;
    } else {
        date = d;
    }

    if (m > 12 || d < 1) {
        cout << "This is an invalid month, feel satan's wrath" << endl;
        // set month equal to 666 for satan's wrath
        month = 666;
    } else {
        month = m;
    }
    year = y;
}

void Date::showDate() {
    if (month < 10) {
    cout << date << "/0" << month << "/" << year << endl; 
    } else {
        cout << date << "/" << month << "/" << year << endl;
    }
}