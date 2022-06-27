#include <iostream>
// different weight on planet

int main() {
  int planet;
  int earthWeight;
  int planetWeight = 0;
  std::cout << "Enter your weight on earth \n";
  std::cin >> earthWeight;
  std::cout << "Enter a number for the planet you want \n";
  std::cin >> planet;

  switch (planet) {
  case 1:
    planetWeight = earthWeight * 0.38;
    std::cout << "Your weight on Mercury is \n" << planetWeight << "\n";
    break;
  case 2:
    planetWeight = earthWeight * 0.91;
    std::cout << "Your weight on Venus is \n" << planetWeight << "\n";
    break;
  case 3:
    planetWeight = earthWeight * 0.38;
    std::cout << "Your weight on Mars is \n" << planetWeight << "\n";
    break;
  case 4:
    planetWeight = earthWeight * 2.34;
    std::cout << "Your weight on Jupiter is \n" << planetWeight << "\n";
    break;
  case 5:
    planetWeight = earthWeight * 10.6;
    std::cout << "Your weight on Saturn is \n" << planetWeight << "\n";
    break;
  case 6:
    planetWeight = earthWeight * 0.92;
    std::cout << "Your weight on Uranus is \n" << planetWeight << "\n";
    break;
  case 7:
    planetWeight = earthWeight * 1.19;
    std::cout << "Your weight on Nepturne is \n" << planetWeight << "\n";
    break;
  }
}

//      gcc leap_year -o main.o
//      ./main.o