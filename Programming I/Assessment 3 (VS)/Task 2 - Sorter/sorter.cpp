#include <iostream>
#include <algorithm>
using namespace std;


void sorter(int intValArr[]) {

    int len = sizeof(intValArr) / sizeof(intValArr[0]);

    sort(intValArr, intValArr + len);

    cout << "Sorted Array" << endl;
    for (int i = 0; i < len; i++) {
        cout << intValArr[i] << "\n";
    }
}


void sorter(char charValArr[]) {

    int len = sizeof(charValArr) / sizeof(charValArr[0]);
    
    sort(charValArr, charValArr + len);

    for (int i = 0; i < len; i++) {
        cout << charValArr[i] << "\n";
    }
}


void sorter(double doubleValArr[]) {

    int len = sizeof(doubleValArr) / sizeof(doubleValArr[0]);

    sort(doubleValArr, doubleValArr + len);

    cout << "Sorted Array" << endl;
    for (int i = 0; i < len; i++) {
        cout << doubleValArr[i] << "\n";
    }
    cout << endl;
}
