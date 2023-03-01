// Ask user for number of name
// Prompt to get input for each name
// Print out your array address
// Print out first character of each name
// Print out name

#include "funcs.h"
#include <iostream>
using namespace std;

// Task 3
void dynamicNames(int size) {
  // declare pointer
  string *ptr;
    
  // dynamically allocate pointer as arr with size
  ptr = new string[size];

  // loop over arr size and get each name
  for (int i = 0; i < size; ++i) {
    cout << "Please enter name " << i + 1 << ": ";
    cin >> *(ptr + i);
  }

  // output the memoy address of the array
  cout << "\nThe address of the array is:\n" << ptr << endl;

  // loop over each name and output the first character
  cout << "\nThe first character of each name is:" << endl;
  for (int i = 0; i < size; ++i) {
    cout << "Name " << i + 1 << ": " << ptr[0 + i][0] << endl;
  }
  
  // output each name in the arr
  cout << "\nYour stored names are:" << endl;
  for (int i = 0; i < size; ++i) {
    cout << *(ptr + i) << endl;
  }

  // ptr memory is released to the heap
  delete[] ptr;
}
