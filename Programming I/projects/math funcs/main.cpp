#include <iostream>
#include "mathFunk.h"
using namespace std;

int main() {
    
    int arrSizeAvg;

    // get avg from list
    cout << "How many values would you like to enter?" << endl;
    cin >> arrSizeAvg;
    calcAvg(arrSizeAvg);
    
    cout << "Now this is cool" << endl;
    calcPythag();

    // cout << "xx" << endl;
    
    
    return 0;
}
