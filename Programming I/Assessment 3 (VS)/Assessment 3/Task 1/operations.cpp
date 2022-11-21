#include <iostream>
// import header file
#include "operations.h"
using namespace std;

// declare function with 3 parameters: 2 numbers and an operator
int calc(int num1, int num2, mathOperator operation) {

	// take passed input for operation
	switch (operation) {
		case add:
			// if operation = add -> add numbers
			cout << "Result: " << num1 + num2 << endl;
			break;
		case subtract:
			// if operation = add -> subtract numbers
			cout << "Result: " << num1 - num2 << endl;
			break;
		case multiply:
			// if operation = add -> multiply numbers
			cout << "Result: " << num1 * num2 << endl;
			break;
		case divide:
			// if operation = add -> divide numbers
			cout << "Result: " << num1 / num2 << endl;
			break;
		case modulus:
			// if operation = add -> get modulus of numbers
			cout << "Result: " << num1 % num2 << endl;
			break;
	}
	return 0;
}