#include <iostream>

int main() {
  int year;
  bool leapYear;

  std::cout << "Please enter a year \n";
  std::cin >> year;

  if(year % 4 == 0) {
    leapYear = true;
  }
  else if(year % 100 == 0 && year % 400 != 0) {
    leapYear = false;
  }
  else if(year % 400 == 0) {
    leapYear = true;
  } else {
    leapYear = false;
  }

  if(leapYear == true) {
    std::cout << "This was a leap year \n";
  } else {
    std::cout << "This was not a leap year \n";
  } 
}

//      gcc leap_year -lstdc++ -o main.o
//      ./main.o