#pragma once
#include <string>
using namespace std;

// Base class
class Person {
    public:
        int age;
        int height;
        string name;

        void greeting();
};

// Derived/Inheriting class
class Student: public Person {
    public:
        int studentID;
        string subjects[3];

        void updateSubjects();
};
