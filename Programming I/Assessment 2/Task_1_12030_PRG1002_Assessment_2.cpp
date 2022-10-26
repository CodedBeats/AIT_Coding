/**********
PSEUDOCODE

START
    SET studentInput, studentScore, gradeLimit = 59.99, grades = ['F', 'D', 'C', 'B', 'A']
    OUTPUT "Please enter your score: "
    READ studentInput
    IF studentInput is invalid
        OUTPUT "This score was either negative or over 50 and therefore is invalid"
    ELSE 
        studentScore = studentInput * 2
        LOOP 5 times
            IF studentScore - gradeLimit <= 0
                IF this is the first iteration of the loop
                    OUTPUT "You have failed with %" + studentScore + ", and received a grade " << grades[iteration number]
                    break
                ELSE
                    OUTPUT "You have passed with %" + studentScore + ", and received a grade " << grades[iteration number]
                    break
                END IF
            END IF
            IF gradeLimit >= 89
                gradeLimit = 100
            ELSE
                gradeLimit += 10
            END IF
        END LOOP
    END IF
END
**********/

#include <iostream>
using namespace std;

int main() {
    
    // set input and score as decimal variables
    float studentInput, studentScore;
    // initialise gradeLimit as a way to check what grade the score is
    float gradeLimit = 59.99;
    // set an array of each grade type
    char grades[5] = {'F', 'D', 'C', 'B', 'A'};
    
    // get student input
    cout << "Please enter your score: ";
    cin >> studentInput;
    
    // check if input isn't a valid number
    if (studentInput < 0 || studentInput > 50) {
        cout << "This score was either negative or over 50 and therefore is invalid";
    } else {
        // calculate score percentage
        studentScore = studentInput * 2;
        // iterate through grade array
        for (int i = 0; i < 5; i++) {
            // check if studentScore - gradeLimit is less than or equal to 0 to associate with grade level
            if (studentScore - gradeLimit <= 0) {
                // check if i is equal to 0 for fail or pass
                if (i == 0) {
                    cout << "You have failed with %" << studentScore << ", and received a grade " << grades[i] << endl;
                    break;      // end program here to stop repeated messages
                } else {
                    cout << "You have passed with %" << studentScore << ", and received a grade " << grades[i] << endl;
                    break;      // end program here to stop repeated messages
                }
            }
            
            // check if this is the 2nd last iteration and correct for that 0.01 extra increase
            if (gradeLimit >= 89) {
                gradeLimit = 100;
            } else {
                // increase gradeLimit by 10 to get to the next tier/level/grade
                gradeLimit += 10;
            }
        }
    }
    
    return 0;
}
