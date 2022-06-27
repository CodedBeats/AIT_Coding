#include <iostream>

int main() {
    // Add your code below  
    double wE;
    double wM;
    
    std::cout << "Enter weight \n";
    std::cin >> wE;
    wM = wE * 0.3783;
    std::cout << "This weight on mars would be " << wM << "\n";



    double m;
    double k;

    std::cout << "Enter miles \n";
    std::cin >> m;
    k = m * 0.621371;
    std::cout << "In kilometers this is " << k << "\n";

//      gcc leap_year -o main.o
//      ./main.o
}