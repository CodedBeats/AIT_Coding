/*
=== PSEUDOCODE ===

START
    SET intValList[] = random integer values, charValList[] = random char values, doubleValList[] = random double values
    sort intValList[]

    LOOP (i = 0; i < 10; i++)
        OUPUT intValList[i]
    END LOOP
END
*/

// import header file
#include "sorter.h"
#include <iostream>
#include <algorithm>
using namespace std;

int main() {
    // declare hard coded array types
    // ============= Choose any of these to pass into sorter() =============
    int intValList[10] = { 2, 0, 1, 5, 6, 4, 3, -2, -1, -55 };
    char charValList[10] = { 'a', '&', 'A', 'Z', 'K', 'L', '!', '(', '@', 'h'};
    double doubleValList[10] = { 2.55, 77.9, 1.456456, 5, 6, 4.342, 1.3, -2, -1.88, -34 };

    cout << "Sorted Array" << endl;
    // pass an array into the overloaded function
    sorter(intValList);

    return 0;
}


