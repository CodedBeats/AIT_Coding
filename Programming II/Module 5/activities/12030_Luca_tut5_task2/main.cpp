#include "classes.h"
#include <iostream>
using namespace std;


int main() {
    // initalize input variables
    int day, month, year;
    // create employee object with bad name
    Employee soonToBeFiredEmployee;

    // call calss methods on soonToBeFiredEmployee
    soonToBeFiredEmployee.setEmpNo();
    soonToBeFiredEmployee.showEmpNo();
    soonToBeFiredEmployee.setEmpSalary();
    soonToBeFiredEmployee.showEmpSalary();
    
    return 0;
}
