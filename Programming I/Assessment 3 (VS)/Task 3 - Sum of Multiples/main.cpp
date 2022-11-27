/*
=== PSEUDOCODE ===

START
    SET input, limit, result, exit = false

    LOOP (while exit = false)
        OUTPUT "Enter 2 numbers"
            "Num1 to times incrementing values by and Num2 for the limit of incrementing nums"
            "Num1: "
        READ input
        OUTPUT "Num2: "
        READ limit

        IF (input > 0 and limit > 0) 
            result = 1 + input
            LOOP (i = 2; i <= n; i++)
                result += (i * input)
            END LOOP
            OUTPUT result
            
            exit = true
        ELSE
            OUTPUT "Please only enter values above 0"
        END IF
    END LOOP
END
*/

// import header file
#include "sumOfMultiples.h"
#include <iostream>
using namespace std;

// handle user input and interaction in main func
int main() {
    // declare input variables and an exit status
    int input, limit;
    bool exit = false;

    // run this once before checking for exit
    do {
        // get user input
        cout << "Enter 2 numbers \nNum1 to times incrementing values by and Num2 for the limit of incrementing nums\n\tNum1: ";
        cin >> input;
        cout << "\tNum2: ";
        cin >> limit;

        if (input > 0 && limit > 0) {
            // pass user input into func
            sumOfMultiples(input, limit);
            // exit program
            exit = true;
        }
        else {
            // prompt user to only enter values more than 0
            cout << "Please only enter values above 0" << endl;
        }   
        // retry if user inputs 0 or negative values
    } while (exit != true);


    return 0;
}


