#include <vector>
#include <math.h>
#include <iostream>
// header files
#include "mathFunk.h"
using namespace std;

int calcAvg(int arrSize) {

    vector<float> arr;
    float input, avg, total = 0;

    cout << "Please enter the values you'd like to get the avg from" << endl;
    for (int i = 0; i < arrSize; i++) {
        cout << "Enter value " << i + 1 << ": ";
        cin >> input;
        arr.push_back(input);
    }
    cout << "Your list of values" << endl;
    for (int i = 0; i < arrSize; i++) {
        cout << arr[i] << " ";
        total += arr[i];
    }

    avg = total / arrSize;
    cout << "\nThat average of those values is: " << floor(avg);

    return 0;
}
