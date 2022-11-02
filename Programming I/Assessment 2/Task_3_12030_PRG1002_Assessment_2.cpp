/**********
PSEUDOCODE

START
    SET initialValue, endValue, i
    OUTPUT "Please enter the number you wish to start at: "
    READ initialValue
    OUTPUT "Please enter the number you wish to end at: "
    READ endValue
    i = initialValue

    IF initialValue is more than or equal to endValue
        OUTPUT "Your initial value cannot be more than or equal to your end value."
    ELSE 
        WHILE i is less than or equal to endValue
            IF i divided by 3 has no remainder and i divided by 5 has no remainder
                OUTPUT "ticktock"
            ELSE IF i divided by 3 has no remainder
                OUTPUT "tick"
            ELSE IF i divided by 5 has no remainder
                OUTPUT "tock"
            ELSE 
                OUTPUT i
            END IF
            i += 1
        END WHILE
    END IF
END
**********/

#include <iostream>
#include <iomanip>
using namespace std;

int main() {
    
    // Declare the starting and ending values as well as a variable to hold iteration values
    int initialValue, endValue, i;
    
    // Request and Read input values from user
    cout << "Please enter the number you wish to start at: ";
    cin >> initialValue;
    cout << "Please enter the number you wish to end at: ";
    cin >> endValue;
    
    // set our starting iteration value to the initial value
    i = initialValue;

    // check if initial value is more than or equal to endvalue, causing the program to be useless
    if ( initialValue >= endValue ) {
        cout << "Your initial value cannot be more than or equal to your end value." << endl;
    } else {
        // loop through initial to end values
        while (i <= endValue) {
            if (i % 3 == 0 && i % 5 == 0) {
                cout << "ticktock" << endl;
            }
            else if (i % 3 == 0) {
                cout << "tick" << endl;
            }
            else if (i % 5 == 0) {
                cout << "tock" << endl;
            }
            else {
                cout << i << endl;
            }
            i += 1;
        }
    }
    
    return 0;
}
