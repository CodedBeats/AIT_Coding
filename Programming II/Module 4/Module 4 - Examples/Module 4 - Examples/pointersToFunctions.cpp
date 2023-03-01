#include "examples.h"
#include <iostream>
using namespace std;

int increment(int num);

int increment(int num) {
	num += 1;
	return num;
}

int pointersToFunctions() {
	int num1 = 1, result;

	// create a new pointer and assign it the incrememnt function
	int (*incrementNum)(int num) = increment;
	// call the pointer the same as you would with the original function
	result = incrementNum(num1);
	cout << result << endl;

	return 0;
}

