#include "classes.h"
#include <iostream>
using namespace std;


int main() {
    // create an instance of a human
    Person human1;

    // give human1 their attributes with user input
    cout << "Age: ";
    cin >> human1.age;
    cout << "Height: ";
    cin >> human1.height;
    cout << "Name: ";
    cin >> human1.name;

    // output human1's attributes
    cout << "This human is named " << human1.name << "\n"
        << "They are " << human1.age << " years old \n"
        << "They are " << human1.height << "cm tall" << endl;

    // create an instance of a Student inherited from Person
    Student student1;
    // give them a name just for the sake of console display
    student1.name = "Connor";
    // call student specific method to give student1 some subjects
    student1.updateSubjects();
    // output student1's subjects
    cout << student1.name << " is taking:" << endl;
    for (int i = 0; i < 3; i++) {
        cout << student1.subjects[i] << ", ";
    }
    
    return 0;
}
