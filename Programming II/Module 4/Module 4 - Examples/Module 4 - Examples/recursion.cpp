#include "examples.h"
#include <iostream>
using namespace std;

double power(double base, int pow);

double power(double base, int pow) {
    if (pow == 0) {
        return 1;
    }
    else {
        return base * power(base, pow - 1);
        // pow = 4, 2*2 = 4
        // pow = 3, 2*4 = 8
        // pow = 2, 2*8 = 16
        // pow = 1, 2*16 = 32
        // pow = 0, stop 
    }
}

int recursion() {
    // call base * base untill power == 0
    cout << power(2, 5) << endl;

    return 0;
}

