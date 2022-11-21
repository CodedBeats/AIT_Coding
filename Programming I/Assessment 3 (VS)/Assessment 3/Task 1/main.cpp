/*
=== PSEUDOCODE ===

START
	SET num1, num2, optionn exit = 'n', operation

	LOOP until exit = 'y'
		OUTPUT	"MENU"
				"1.  Add"
				"2.  Subtract"
				"3.  Multiply"
				"4.  Divide"
				"5.  Modulus"
				"Enter your choice (1-5): "
		READ option

		IF option isn't valid
			OUPUT "Please enter a choice between 1 and 5"
			skip to next iteration of loop
		END IF

		operation = option

		OUTPUT	"Enter 2 whole numbers"
				"Number 1: "
		READ  num1
		OUTPUT	"Number 2: "
		READ num2

		OUPUT "Result: " + (num1 operation num2)

		OUTPUT "Do you wish to exit? (y/n): "
		READ exit
	END LOOP
END
*/


#include <iostream>
// import header file
#include "operations.h"
using namespace std;

// handle user interaction in main function
int main() {
	// declare regular variables and enum variable
	int num1, num2, option;
	char exit = 'n';
	mathOperator operation{};

	// set loop up so user can use calculator over and over
	do {
		// display calculator menu
		cout <<
			"MENU\n" <<
			"1.  Add\n" <<
			"2.  Subtract\n" <<
			"3.  Multiply\n" <<
			"4.  Divide\n" <<
			"5.  Modulus\n" <<
			"Enter your choice (1-5): ";
		// get user input for calculator operation
		cin >> option;

		// check if user input is invalid
		if (option < 1 || option > 5) {
			cout << "Please enter a choice between 1 and 5" << endl;
			// skip the following code and start next iteration of loop
			continue;
		}

		// check user input to set calculator operator
		switch (option) {
			case 1:
				// if user input = 1 -> set operator to add
				operation = mathOperator::add;
				break;
			case 2:
				// if user input = 2 -> set operator to subtract
				operation = mathOperator::subtract;
				break;
			case 3:
				// if user input = 3 -> set operator to multiply
				operation = mathOperator::multiply;
				break;
			case 4:
				// if user input = 4 -> set operator to divide
				operation = mathOperator::divide;
				break;
			case 5:
				// if user input = 5 -> set operator to modulus
				operation = mathOperator::modulus;
				break;
		}

		// get integer values from user
		cout << "Enter 2 whole numbers\n\tNumber 1: ";
		cin >> num1;
		cout << "\tNumber 2: ";
		cin >> num2;

		// pass user input as parameters into calculate function
		calc(num1, num2, operation);

		// check if user wants to continue or exit program
		cout << "\nDo you wish to exit? (y/n): ";
		cin >> exit;

		// continue or exit based on user input
	} while (exit != 'y');

    return 0;
}


