/*
=== PSEUDOCODE ===

START
	
END
*/



// import header file
#include "stringManipulation.h"
using namespace std;

// handle user interaction in main function
int main() {
    // declare input and output values
    string input;
    int length, vowels, lowercase, uppercase, numbers, symbols;

    // get user input
    cout << "Please enter a string: ";
    getline(cin, input);
    
    // get string values by passing input into corresponding functions
    length = getLength(input);
    vowels = getVowels(input);

    // output string statistics
    cout <<
        "Length of string: " << length << "\n" <<
        "Number of Vowels: " << vowels << "\n";
    

	return 0;
}


