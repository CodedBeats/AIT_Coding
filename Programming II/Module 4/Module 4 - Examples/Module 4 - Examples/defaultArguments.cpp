#include "examples.h"
#include <iostream>
using namespace std;

string customMessage(string message = "Hello World");

string customMessage(string message) {
    return message;
}

int defaultArguments() {
    string message;

    cout << "Please enter your custom message, or type 'n' to get default message" << endl;
    getline(cin, message);

    if (message == "n") {
        cout << customMessage() << endl;
    }
    else {
        cout << customMessage(message) << endl;
    }

    return 0;
}

