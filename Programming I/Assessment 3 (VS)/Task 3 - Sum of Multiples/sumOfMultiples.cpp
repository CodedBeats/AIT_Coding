#include "sumOfMultiples.h"
#include <iostream>
using namespace std;

void sumOfMultiples(int x, int n) {
    // declare output and start of function formula that can't be repeated
    int result = 1 + x;

    // increment till set limit
    for (int i = 2; i <= n; i++) {
        // follow formula to get result
        result += (i * x);
    }

    // print result
    cout << result;
    // return so calling function prints result
    return;
}


