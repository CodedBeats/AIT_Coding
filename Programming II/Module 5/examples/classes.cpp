#include "classes.h"
#include <iostream>
using namespace std;


void Person::greeting() {
    cout << "Hello, my name is " << name << "!" << endl;
}

void Student::updateSubjects() {
    cout << "Please enter your 3 subjects" << endl;
    for(int i = 0; i < 3; i++) {
        cin >> subjects[i];
    }
}