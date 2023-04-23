#include <iostream>
#include <string>

#include "trader.h"
#include "handleData.h"
#include "exception.h"
#include "overloading.h"
#include "stringManipulation.h"
#include "sorting.h"
using namespace std;


int main() {

    // remember to use "new (nothrow) Trader()" when declaring new object
    // 
    // ========== FILE IO ==========//
    string filename = "data.csv";
    
    vector<Trader> traders = readDataFromFile(filename);

    // read object data
    cout << traders[0].getTrader() << endl;
    // Do something with the traders...



    // ========== EXCEPTION ==========//
    float x;
    try {
        cout << "\n\nenter a float input: ";
        cin >> x;

        // check if input wasn't an int
        if (!cin) {
            // input was not an integer
            throw 1;
        }
    }
    // catch exception
    catch (...) {
        cout << "A non-int value was entered";
    }



    // ========== CUSTOM EXCEPTION ==========//
    int y;
    try {
        cout << "\n\nenter an int input: ";
        cin >> y;

        // check if input wasn't an int
        if (!cin) {
            // input was not an integer
            throw nonIntException();
        }
    }
    // catch exception
    catch (nonIntException& e) {
        // scroll up to see exception message
        cout << "___Exception___\n";
        cout << e.what() << endl;
    }



    // ========== OVERLOADING ==========//
    float m = 5;
    float n = 1.9;
    add(m, n);



    // ========== STRING SEARCH ==========//
    string phrase = "This girl is melting and doesn't want to give me a phrase";
    string passPhrase = "melting";

    stringSearch(passPhrase, phrase);



    // ========== ARRAY SORT ==========//
    int arr[] = {10, 7, 3, 8, 4, 1, 9, 6, 5, 2};
    int v = sizeof(arr) / sizeof(arr[0]);
    sortInts(arr, v);


    return 0;
}



// operator overloading
