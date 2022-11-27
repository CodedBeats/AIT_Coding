/*
=== PSEUDOCODE ===

START
    SET temp, minTemp, maxTemp, avgTemp, temps[], days = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"}

    OUTPUT "Please enter this week's temperatures"
    LOOP (7 times)
        OUTPUT "    Max: "
        READ temp
        temps[] += temp
        OUTPUT "    Min: "
        READ temp
        temps[] += temp
    END LOOP

    minTemp = min temp in temps[]
    maxTemp = max temp in temps[]
    avgTemp = (total of values in temps[] / 14)

    OUTPUT  "Minimum Temperature: " += minTemp
            "Maximum Temperature: " += maxTemp
            "Average Temperature: " += avgTemp
END
*/


// import header file
#include "temperature.h"
#include <iostream>
using namespace std;

// handle input and user interaction in main func
int main() {
    // declare temp, minTemp, maxTemp, avgTemp, temps[], days = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"}
    float temp, minTemp, maxTemp, avgTemp;
    vector <float>temps = {};
    string days[7] = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};

    // request user temperature input
    cout << "Please enter this week's temperatures" << endl;
    // loop through days
    for (int i = 0; i < 7; i++) {
        cout << days[i] << "\n\tMax: ";
        // get max temp
        cin >> temp;
        // add temp to temps array
        temps.push_back(temp);
        cout << "\tMin: ";
        // get min temp
        cin >> temp;
        // add temp to temps array
        temps.push_back(temp);
    }

    // pass temps array into functions to get min, max and avg temperatures
    minTemp = calcMin(temps);
    maxTemp = calcMax(temps);
    avgTemp = calcAvg(temps);

    // output temperature statistics
    cout << "Minimum Temperature: " << minTemp << "\n" <<
        "Maximum Temperature: " << maxTemp << "\n" <<
        "Average Temperature: " << avgTemp << endl;
   
    return 0;
}


