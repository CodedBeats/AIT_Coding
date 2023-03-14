#include "classes.h"
#include <iostream>
using namespace std;


void Employee::setEmpNo() {
    cout << "Please set your Employee Number: ";
    cin >> empNo;
}

void Employee::showEmpNo() {
    cout << "Your Employee Number is: " << empNo << endl;
}


void Employee::setEmpSalary() {
    cout << "\nPlease enter your Salary: $";
    cin >> empSalary;
}

void Employee::showEmpSalary() {
    cout << "Your Salary is: $" << empSalary << endl;
}

