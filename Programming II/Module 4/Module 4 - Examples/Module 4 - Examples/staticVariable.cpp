#include "examples.h"
#include <iostream>
using namespace std;

void increment();

void increment() {
    // without static it just prints "1" 7 times
    static int num = 0;

    if (num >= 4) {
        cout << "you've incrememnted your number 4 or more times" << endl;
    }
    else {
        num += 1;
        cout << num << "\n";
    }
}

int staticVariable() {

    for (int i = 0; i < 7; i++) {
        increment();
    }

    return 0;
}

