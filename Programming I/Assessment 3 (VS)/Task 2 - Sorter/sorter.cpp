#include <iostream>
#include <algorithm>
using namespace std;


void sorter(int intValArr[]) {

    sort(intValArr, intValArr + 10);

    cout << "Sorted Array" << endl;
    for (int i = 0; i < 10; i++) {
        cout << intValArr[i] << "\n";
    }
}


void sorter(char charValArr[]) {

    sort(charValArr, charValArr + 10);

    cout << "Sorted Array" << endl;
    for (int i = 0; i < 10; i++) {
        cout << charValArr[i] << "\n";
    }
}


void sorter(double doubleValArr[]) {

    sort(doubleValArr, doubleValArr + 10);

    cout << "Sorted Array" << endl;
    for (int i = 0; i < 10; i++) {
        cout << doubleValArr[i] << "\n";
    }
}
