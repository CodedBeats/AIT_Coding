#include <iostream>
#include <algorithm>
using namespace std;

// integer version of the overloaded func
void sorter(int intValArr[]) {
    // sort array in ascending order
    sort(intValArr, intValArr + 10);
    // print out array
    for (int i = 0; i < 10; i++) {
        cout << intValArr[i] << "\n";
    }
}

// char version of the overloaded func
void sorter(char charValArr[]) {
    // sort array in ascending order
    sort(charValArr, charValArr + 10);
    // print out array
    for (int i = 0; i < 10; i++) {
        cout << charValArr[i] << "\n";
    }
}

// double version of the overloaded func
void sorter(double doubleValArr[]) {
    // sort array in ascending order
    sort(doubleValArr, doubleValArr + 10);
    // print out array
    for (int i = 0; i < 10; i++) {
        cout << doubleValArr[i] << "\n";
    }
}
