/**********
PSEUDOCODE

START
    SET list = []
    OUTPUT "Please enter 3 numbers"
    OUTPUT "Value 1: "
    READ list[0]
    OUTPUT "Value 2: "
    READ list[1]
    OUTPUT "Value 3: "
    READ list[2]

    SET arrLength = list length

    SORT list[] ascending
    OUTPUT "Ascending order:"
    LOOP through list[i]
        OUTPUT list[i]
    END LOOP

    SORT list[] descending
    OUTPUT "Descending order:"
    LOOP through list[i]
        OUTPUT list[i]
    END LOOP
END
**********/

#include <iostream>
#include<algorithm>
using namespace std;

int main() {
    
    // declare empty array
    int list[3];
    
    // request inputs from user and populate array
    cout << "Please enter 3 numbers" << endl;
    cout << "Value 1: ";
    cin >> list[0];
    cout << "Value 2: ";
    cin >> list[1];
    cout << "Value 3: ";
    cin >> list[2];

    // declare array length
    int arrLength = sizeof(list) / sizeof(list[0]);

    /* 
        ====== could use arrLength to get the length of the array ======
        ====== and then use this type of for loop ======
        for (int i = 0; i < arrLength i++) {
            code
        }

        ====== but the following for loop is cooler ======
    */

    // sort array in ascending order
    std::sort(list, list + arrLength);
    // print out array in ascending order
    cout << "Ascending order:" << endl;
    for (int i : list) {
        cout << i << endl;
    }

    // sort array in descending order
    std::sort(list, list + arrLength, greater<int>());
    // print out array in descending order
    cout << "Descending order:" << endl;
    for (int i : list) {
        cout << i << endl;
    }

    return 0;
}
