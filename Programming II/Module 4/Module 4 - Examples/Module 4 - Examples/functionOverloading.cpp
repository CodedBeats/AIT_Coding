#include "examples.h"
#include <iostream>
using namespace std;

void increment(int num);
void increment(float num);

// can also use function types with returns
void increment(int num) {
	num += 1;
	cout << num << endl;
}

void increment(float num) {
	num += 1.5;
	cout << num << endl;
}

int functionOverloading() {
	int num1 = 1;
	float num2 = 1.5;

	increment(num1);
	increment(num2);

	return 0;
}