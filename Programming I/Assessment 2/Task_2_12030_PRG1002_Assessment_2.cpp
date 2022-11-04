/**********
PSEUDOCODE

START
    SET milesTravelled, petrolConsumed, milesPerGallon
    OUTPUT "Please enter the number of Litres of Petrol consumed: "
    READ petrolConsumed
    OUTPUT "Please enter the Miles travelled: "
    READ milesTravelled
    
    IF petrolConsumed or milesTravelled is negative
        OUTPUT "You can't enter negative numbers"
    ELSE
        milesPerGallon = (milesTravelled / petrolConsumed) * 3.78541
        OUTPUT "Petrol Consumed: " + petrolConsumed + "L"
        OUTPUT "Miles Travelled: " + milesTravelled
        OUTPUT "Miles per Gallon: " + milesPerGallon
    END IF
END
**********/

#include <iostream>
#include <iomanip>
using namespace std;

int main() {
    
    // set input and output as float for decimals
    float milesTravelled, petrolConsumed, milesPerGallon;
    
    // Request and Read input values from user
    cout << "Please enter the number of Litres of Petrol consumed: ";
    cin >> petrolConsumed;
    cout << "Please enter the Miles travelled: ";
    cin >> milesTravelled;
    
    // check if input isn't positive
    if (petrolConsumed < 0 || milesTravelled < 0) {
        // Tell user that negative values can't be used
        cout << "You can't enter negative numbers" << endl;
    } else {
        // only calculate milesPerGallon here because it's an unnecessary step above if an input is negative
        milesPerGallon = milesTravelled / (petrolConsumed * 0.26417);
        
        // set the number on all values to 3 decimal points
        cout << fixed;
        cout << setprecision(3);
        
        // display Car stats
        cout << "Petrol Consumed: " << petrolConsumed << "L" << endl;
        cout << "Miles Travelled: " << milesTravelled << endl;
        cout << "Miles per Gallon: " << milesPerGallon << " (US mpg)" << endl;
    }
    
    return 0;
}
