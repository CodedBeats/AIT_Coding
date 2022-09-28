#include <iostream>
#include <iomanip>
#include <string.h>
#include <cctype>
using namespace std;

// 1. demonstrate assignment operator
int program1() {
    std::cout << "This is the 1st program" << endl;
    int n = 420;
    std::cout << n << endl;
    
    return 0;
}

// 2. read 3 numbers from the user and prints their sum 
int program2() {
    std::cout << "This is the 2nd program" << endl;
    int sum = 0;
    int x, y, z;
    
    std::cout << "Enter 3 numbers" << endl;
    std::cin >> x;
    std::cin >> y;
    std::cin >> z;
    
    sum += (x + y + z);
    std::cout << "The sum of these 3 numbers is " << sum << endl;
    
    return 0;
}

// 3. read 2 double numbers from the user and print the sum of both doubles (scaled to 2 decimal places)
int program3() {
    std::cout << "This is the 3rd program" << endl;
    double sum = 0.00;
    double x, y;
    
    std::cout << "Enter 2 numbers" << endl;
    std::cin >> x;
    std::cin >> y;
    
    sum += (x + y);
    std::cout << "The sum of these 2 numbers is " << sum << endl;
    
    return 0;
}

// 4. read a first and last initial of a name from the user and print it out
int program4() {
    std::cout << "This is the 4th program" << endl;
    string firstName;
    string lastName;
    string output;
    
    std::cout << "Enter your first name" << endl;
    std::cin >> firstName;
    std::cout << "Enter your last name" << endl;
    std::cin >> lastName;
    
    char firstNameInitial = firstName.at(0);
    char lastNameInitial = lastName.at(0);
    std::cout << "Hello " << (char) toupper(firstNameInitial) << "." << (char) toupper(lastNameInitial) << "." << endl;
    
    return 0;
}

// 5. display a menu with a formatted style
int program5() {
    float coffePrice = 3.50;
    float teaPrice = 3.00;
    
    cout << fixed << showpoint;
    cout << setprecision(2);
    
    std::cout << "Menu" << endl;
    std::cout << "---------------" << endl;
    
    std::cout << std::setw(10) << std::left << "Item";
    std::cout << std::right << "Price" << endl;
    
    std::cout << std::setw(10) << std::left << "Coffee";
    std::cout << std::right << coffePrice << endl;
    
    std::cout << std::setw(10) << std::left << "Tea";
    std::cout << std::right << teaPrice << endl;
    
    return 0;
}

int main() {
    program1();
    program2();
    program3();
    program4();
    program5();
    
    return 0;
}

