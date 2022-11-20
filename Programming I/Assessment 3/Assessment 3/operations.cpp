#include <iostream>
#include "operations.h"
using namespace std;


int calc(int num1, int num2, mathOperator operation) {

	switch (operation) {

		case add:
			cout << "Result: " << num1 + num2 << endl;
			break;
		case subtract:
			cout << "Result: " << num1 - num2 << endl;
			break;
		case multiply:
			cout << "Result: " << num1 * num2 << endl;
			break;
		case divide:
			cout << "Result: " << num1 / num2 << endl;
			break;
		case modulus:
			cout << "Result: " << num1 % num2 << endl;
			break;
	}
	return 0;
}