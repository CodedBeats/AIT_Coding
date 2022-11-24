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
    // declare totalLowercase at a starting value of 0
    int totalLowercase = 0;
    // declare c for iteration
    char c;

    for (int i = 0; i < input.length(); i++) {
        // set c = current character possition of string
        c = input[i];
        // if current character is lowercase, increment value of totalLowercase
        if (islower(c)) {
            totalLowercase += 1;
        }
    }
    // return number of lowercase characters so it can be set to an output variable
    return totalLowercase;
}


int getUppercase(string input) {
    // declare totalUppercase at a starting value of 0
    int totalUppercase = 0;
    // declare c for iteration
    char c;

    for (int i = 0; i < input.length(); i++) {
        // set c = current character possition of string
        c = input[i];
        // if current character is uppercase, increment value of totalUppercase
        if (isupper(c)) {
            totalUppercase += 1;
        }
    }
    // return number of uppercase characters so it can be set to an output variable
    return totalUppercase;
}


int getNumbers(string input) {
    // declare totalNumbers at a starting value of 0
    int totalNumbers = 0;
    // declare c for iteration
    char c;

    for (int i = 0; i < input.length(); i++) {
        // set c = current character possition of string
        c = input[i];
        // if current character is between 0 and 9, increment value of totalNumbers
        if (c >= '0' && c <= '9') {
            totalNumbers += 1;
        }
    }
    // return amount of numbers so it can be set to an output variable
    return totalNumbers;
}


/*
    in this function I could input all letters and numbers to check if the currrent character doesn't macth
    but becuase thats messy, I'm going to use regex
*/
int getSymbols(string input) {
    // declare totalSymbols at a starting value of 0
    int totalSymbols = 0;
    // declare c for iteration (and decalre as string for regex search)
    string c;
    // declare a regex pattern to macth symbols against it, currently it matches a character not present in the range
    regex pattern("[^a-zA-Z0-9 ]+");

    for (int i = 0; i < input.length(); i++) {
        // set c = current character possition of string
        c = input[i];
        // check if c matches pattern (meaning it's a symbol) and increment totalSymbols
        if (regex_search(c, pattern)) {
            totalSymbols += 1;
        }
    }
    // return number of symbols so it can be set to an output variable
    return totalSymbols;
}


