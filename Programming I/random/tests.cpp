#include <iostream>
#include <iomanip>
#include <string.h>
#include <string>
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
    std::cout << "This is the 5th program" << endl;
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

// read 2 numbers as integers and check if the 1st can be divided by the second (and be a whole number)
int program6() {
    std::cout << "This is the 6th program" << endl;
    int x, y;
    cout << "Enter 2 numbers" << endl;
    cin >> x;
    cin >> y;
    if (x % y == 0) {
        cout << "It IS divisible" << endl;
    } else {
        cout << "It's NOT divisible" << endl;
    }
    return 0;
}

// read a character and output "You are enrolled" if the input is "y" or "Y"
int program7() {
    std::cout << "This is the 7th program" << endl;
    string x;
    cout << "Enter a letter if the user deserves to be enrolled" << endl;
    cin >> x;
    if (x == "y" || x == "Y") {
        cout << "You are enrolled" << endl;
    } else {
        cout << "You are not enrolled" << endl;
    }
    return 0;
}

// read 3 numbers and display the lowest value (this should be done with a loop, not nested if's)
int program8() {
    std::cout << "This is the 8th program" << endl;
    int x, y, z, lowestValue;
    cout << "input 3 numbers" << endl;
    cin >> x;
    cin >> y;
    cin >> z;
    lowestValue = x;
    if (lowestValue > y) {
        lowestValue = y;
        if (lowestValue > z) {
            lowestValue = z;
        } 
    }
    cout << "The lowest value of these 3 numbers is " << lowestValue << endl;
    return 0;
}

// read input to pick a color (using switch)
int program9() {
    std::cout << "This is the 9th program" << endl;
    int x;
    cout << "Enter a number to sellect your color" << "\n"
        << "1 for Red" << "\n"
        << "2 for Green" << "\n"
        << "3 for Yellow" << "\n"
        << "4 for Blue" << "\n"
        << "5 for pink" << endl;
    cin >> x;
    switch (x) {
        case 1:
            cout << "The color picked by you is Red" << endl;
            break;
        case 2:
            cout << "The color picked by you is Green" << endl;
            break;
        case 3:
            cout << "The color picked by you is Yellow" << endl;
            break;
        case 4:
            cout << "The color picked by you is Blue" << endl;
            break;
        case 5:
            cout << "The color picked by you is Pink" << endl;
            break;
        default:
            cout << "You didn't enter a number asociated to a color" << endl;
            break;
    }
    return 0;
}


int main() {
    program1();
    program2();
    program3();
    program4();
    program5();
    program6();
    program7();
    program8();
    program9();
    
    return 0;
}

