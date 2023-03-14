#include "classes.h"
#include <iostream>
using namespace std;


int main() {
    // initalize input variables
    int day, month, year;
    // create date object with bad name
    Date dateThingy;

    // handle user input
    cout << "Enter Day: ";
    cin >> day;

    cout << "Enter Month: ";
    cin >> month;

    cout << "Enter Year: ";
    cin >> year;

    // pass user input to class method to set the value of attributes
    dateThingy.setDate(day, month, year);
    // display inputted date
    dateThingy.showDate();
    
    return 0;
}
