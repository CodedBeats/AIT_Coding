#include <iostream>
#include <cmath>
// header files
#include "mathFunk.h"
using namespace std;

void calcPythag() {

    int choice;
    float aValue, bValue, cValue;

    cout << "Given the following right-angle triangle: " << endl;
    cout << "\n       /| \n    c / | a \n     /  | \n     ----\n      b\n" << endl;
    cout << "Choose the side you want to calculate where - a=1 , b=2 , c=3" << endl;
    cout << "Choose 1, 2 or 3: ";
    cin >> choice;

    switch (choice) {
    case 1:
        cout << "You have chosen side a \nPlease input values for sides b and c" << endl;
        cout << "b value: ";
        cin >> bValue;
        cout << "c value: ";
        cin >> cValue;

        cout << "\nYour Triangle looks like this:\n" << endl;
        cout << "\n       /| \n    " << cValue << " / | a \n     /  | \n     ----\n      " << bValue << "\n" << endl;

        aValue = (cValue * cValue) - (bValue * bValue);
        cout << "The value of side a is: " << sqrt(aValue) << endl;

        break;
    case 2:
        cout << "You have chosen side b \nPlease input values for sides a and c" << endl;
        cout << "a value: ";
        cin >> aValue;
        cout << "c value: ";
        cin >> cValue;

        cout << "\nYour Triangle looks like this:\n" << endl;
        cout << "\n       /| \n    " << cValue << " / | " << aValue << " \n     /  | \n     ----\n      b\n" << endl;

        bValue = (cValue * cValue) - (aValue * aValue);
        cout << "The value of side b is: " << sqrt(bValue) << endl;

        break;
    case 3:
        cout << "You have chosen side c \nPlease input values for sides a and b" << endl;
        cout << "a value: ";
        cin >> aValue;
        cout << "b value: ";
        cin >> bValue;

        cout << "\nYour Triangle looks like this:\n" << endl;
        cout << "\n       /| \n    c / | " << aValue << " \n     /  | \n     ----\n      " << bValue << "\n" << endl;

        cValue = (aValue * aValue) + (bValue * bValue);
        cout << "The value of side c is: " << sqrt(cValue) << endl;

        break;
    }
}
