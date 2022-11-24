/*
=== PSEUDOCODE ===

START
	
END
*/



// import header file
#include "stringManipulation.h"
using namespace std;

// handle user interaction and console output in main function
int main() {
    // declare input and output values
    string input;
    int length, vowels, lowercase, uppercase, numbers, symbols;

    // get user input
    cout << "Please enter a string: ";
    getline(cin, input);
    
    // get string value statistics by passing input into corresponding functions
    length = getLength(input);
    vowels = getVowels(input);
    lowercase = getLowercase(input);
    uppercase = getUppercase(input);
    numbers = getNumbers(input);
    symbols = getSymbols(input);

    // output string statistics
    cout <<
        "Length of string: " << length << "\n" <<
        "Number of Vowels: " << vowels << "\n" <<
        "Number of Lowercase: " << lowercase << "\n" <<
        "Number of Uppercase: " << uppercase << "\n" <<
        "Amount of Numbers: " << numbers << "\n" <<
        "Number of Symbols: " << symbols << endl;

	return 0;
}


