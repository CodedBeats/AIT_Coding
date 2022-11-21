// header guard
#pragma once

// declare enum variables
enum mathOperator {
	add,
	subtract,
	multiply,
	divide,
	modulus
};

// decalre calculator fucntion in header file for use across cpp files
int calc(int num1, int num2, mathOperator operation);


