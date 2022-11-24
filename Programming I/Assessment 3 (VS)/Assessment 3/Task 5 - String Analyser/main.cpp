/*
=== PSEUDOCODE ===

START
	SET input, length, vowels, lowercase, uppercase, numbers, symbols

    OUTPUT "Please enter a string: "
    READ input

    length = length of input
    vowels = number of vowels in input
    lowercase = number of lowercase letters in input
    uppercase = number of uppercase letters in input
    numbers = amount of numbers in input
    symbols =  number of symbols in input

    OUTPUT
        "Length of string: " + length
        "Number of Vowels: " + vowels
        "Number of Lowercase: " + lowercase
        "Number of Uppercase: " + uppercase
        "Amount of Numbers: " + numbers
        "Number of Symbols: " + symbols
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


