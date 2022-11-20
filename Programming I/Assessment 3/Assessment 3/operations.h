#pragma once
using namespace std;

enum mathOperator {
	add,
	subtract,
	multiply,
	divide,
	modulus
};

int calc(int num1, int num2, mathOperator operation);


