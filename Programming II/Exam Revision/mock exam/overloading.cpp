#include <iostream>

#include "overloading.h"
using namespace std;

void add(int num1, int num2) {
	int result;
	result = num1 + num2;
	cout << result << endl;
}

void add(float num1, float num2) {
	float result;
	result = num1 + num2;
	cout << result << endl;
}
