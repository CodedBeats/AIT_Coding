#include <iostream>
#include "funcs.h"
using namespace std;

// I like to handle user input in the main function, makes other functions feel more flexible and reusable
// (just personal preference)

int main() {
  // initialize arr size
  int size;
  // get arr size from user
  cout << "How many names do you want to store? ";
  cin >> size;

  // pass num to give dynamicNames() func it's arr size
  dynamicNames(size);

  return 0;
}