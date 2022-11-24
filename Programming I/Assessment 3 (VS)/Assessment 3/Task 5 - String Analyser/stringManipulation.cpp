#include "stringManipulation.h"
using namespace std;

int getLength(string input) {
    // declare string length
    int strLen;
    // set string length = input length
    strLen = input.length();
    // return string length so it can be set to an output variable
    return strLen;
}

int getVowels(string input) {
    // declare totalVowels at a starting value of 0
    int totalVowels = 0;
    // declare c for iteration and a vowels array
    char c, vowels[5] = { 'a', 'e', 'i', 'o', 'u' };

    // loop through string
    for (int i = 0; i < input.length(); i++) {
        // set c = current character possition of string and convert that character to lowercase
        c = input[i];
        c = tolower(c);
        // loop through vowels
        for (int j = 0; j < 5; j++) {
            // if currect character is = to a vowel, increment the value of totalVowels
            if (c == vowels[j]) {
                totalVowels += 1;
            }
        }
    }
    // return number of vowels so it can be set to an output variable
    return totalVowels;
}

int getLowercase(string input) {

}

/*
    lowercase,
    uppercase,
    numbers,
    symbols
*/

