// import header file
#include "temperature.h"
#include <iostream>
using namespace std;

// pass temps array and get min temp
float calcMin(vector<float> temps) {
    // declare min as first value in temps array
    float min = temps[0];

    // loop 14 times since there is a min and max for each day (2 * 7)
    for (int i = 0; i < 14; i++) {
        // if min is more than temps[i] -> set min = temps[i]
        if (min > temps[i]) {
            min = temps[i];
        }
    }

    // return min so it can be stored in a variable
    return min;
}

// pass temps array and get max temp
float calcMax(vector<float> temps) {
    // declare max as first value in temps array
    float max = temps[0];

    // loop 14 times since there is a min and max for each day (2 * 7)
    for (int i = 0; i < 14; i++) {
        // if max is less than temps[i] -> set max = temps[i]
        if (max < temps[i]) {
            max = temps[i];
        }
    }

    // return max so it can be stored in a variable
    return max;
}

// pass temps array and get avg temp
float calcAvg(vector<float> temps) {
    // declare avg as first value in temps array
    float total = 0, avg = 0;

    // loop 14 times since there is a min and max for each day (2 * 7) to get total of all values in temps array
    for (int i = 0; i < 14; i++) {
        total += temps[i];
    }
    avg = total / 14;

    // return avg so it can be stored in a variable
    return avg;
}

