#include <iostream>

#include "stringManipulation.h"
using namespace std;

void stringSearch(string passPhrase, string phrase) {
    // Search for the substring in the string
    size_t pos = phrase.find(passPhrase);

    // Check if the substring was found
    if (pos != std::string::npos) {
        cout << "Substring found at position " << pos << endl;
    }
    else {
        cout << "Substring not found" << endl;
    }
}
