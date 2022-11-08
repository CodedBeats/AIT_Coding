#include <iostream>
#include <iomanip>
#include <string.h>
#include <string>
#include <cctype>
#include <vector>
using namespace std;

// 1. demonstrate assignment operator
int program1() {
    std::cout << "Program 1 - demonstrate assignment operator" << endl;
    int n = 420;
    std::cout << n << endl;
    
    return 0;
}

// 2. read 3 numbers from the user and prints their sum 
int program2() {
    std::cout << "Program 2 - read 3 numbers from the user and prints their sum" << endl;
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
    std::cout << "Program 3 - read 2 double numbers from the user and print the sum of both doubles (scaled to 2 decimal places)" << endl;
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
    std::cout << "Program 4 - read a first and last initial of a name from the user and print it out" << endl;
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
    std::cout << "Program 5 - display a menu with a formatted style" << endl;
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

// 6. read 2 numbers as integers and check if the 1st can be divided by the second (and be a whole number)
int program6() {
    std::cout << "Program 6 - read 2 numbers as integers and check if the 1st can be divided by the second (and be a whole number)" << endl;
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

// 7. read a character and output "You are enrolled" if the input is "y" or "Y"
int program7() {
    std::cout << "Program 7 - read a character and output You are enrolled if the input is y or Y" << endl;
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

// 8. read 3 numbers and display the lowest value (this should be done with a loop, not nested if's)
int program8() {
    std::cout << "Program 8 - read 3 numbers and display the lowest value (this should be done with a loop, not nested if's)" << endl;
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

// 9. read input to pick a color (using switch)
int program9() {
    std::cout << "Program 9 - read input to pick a color (using switch)" << endl;
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

// 10. take input and print it's first 5 multiples
int program10() {
    cout << "Program 10 - take input and print the first 5 multiples" << endl;
    int x;
    int result;
    cout << "Input a number" << endl;
    cin >> x;
    
    for (int i = 1; i <= 5; i++) {
        result = x * i;
        cout << "multiplied by " << i << " is " << result << endl;
    }
    
    return 0;
}

// 11. take float and decrease by 0.25 until result is 0
int program11() {
    cout << "Program 11 - take float and decrease by 0.25 until result is 0" << endl;
    float x;
    float y = 0.25;
    cout << "Input a number" << endl;
    cin >> x;
    
    while (x > 0) {
        x = x - y;
        cout << x << endl;
    }
    
    return 0;
}

// 12. print 100 - 0
int program12() {
    cout << "Program 12 - Print 100 - 0" << endl;
    int x = 100;
    
    for (int i = 100; x >= 0; i--) {
        cout << x << endl;
        x -= 1;
    }
    
    return 0;
}

// 13. print multiplication table with rows * columns taken from input
int program13() {
    cout << "Program 13 - Print multiplication table with rows * columns taken from input" << endl;
    
    string rowString = "|";
    int x, y = 1;
    cout << "Enter a number between 1 and 12" << endl;
    cin >> x;
    
    cout << "\n" << "Here is your times table" << endl;
    for(int i = 0; i < x; i++, y++) {
        for (int i = 0; i <= x; i++) {
            rowString += to_string(i * y) + "\t" + "|";
        }
        cout << rowString << endl;
        rowString = "|";
    }
    
    return 0;
}

// 14. print out name forwards and backwards using array
int program14() {
    cout << "Program 14 - Print out name forwards and backwards" << endl;
    
    vector<char> name;
    char letter;
    char exit;
    cout << "Please enter your name 1 letter at a time" << endl;
    
    while(exit != 'y') {
        cin >> letter;
        name.push_back(letter);
        
        cout << "Currently typed: ";
        for (int i = 0; i < name.size(); i++) {
            cout << name[i];
        }
        
        cout << "\n Done? (y/n)" << endl;
        cin >> exit;
    }
    
    cout << "Your name backwards is: ";
    for (int i = name.size() - 1; i >= 0; i--) {
        cout << name[i];
    }
    cout << "\n";
    return 0;
}

// 15. print out employee data
int program15() {
    cout << "Program 15 - Print out employee salary and tax" << endl;
    
    string names[5] = {"Frodo", "Gandlaf", "Gimly", "Legless", "AraGone"};
    int salary[5] = {1213, 1423, 884, 2531, 1001};
    float tax;
    
    cout << "\nName \t\t Salary \t Tax" << endl;
    for (int i = 0; i < 5; i++) {
        cout << names[i] << "\t\t ";
        cout << salary[i] << "\t\t ";
        tax = salary[i] * 0.19;
        cout << tax << endl;
    }
    
    return 0;
}

// 16. read 2 arrays (including size) from user and print max and min from array (seperately)
int findMin() {
    int input[100], arrSize, i, min;

    cout << "Enter Number of Elements in your Array: ";
    cin >> arrSize;
    cout << "Enter " << arrSize << " numbers" << endl;

    // get input for each position in array
    for (i = 0; i < arrSize; i++)
    {
        cin >> input[i];
    }
    // set initial min to compare
    min = input[0];

    // find min value in array
    for (i = 0; i < arrSize; i++)
    {
        if (input[i] < min)
        {
            min = input[i];
        }
    }
    cout << "Minimum Number: " << min << endl;

    return 0;
}
int findMax() {
    int input[100], arrSize, i, max;

    cout << "Enter Number of Elements in your Array: ";
    cin >> arrSize;
    cout << "Enter " << arrSize << " numbers" << endl;

    // get input for each position in array
    for (i = 0; i < arrSize; i++)
    {
        cin >> input[i];
    }
    // set initial max to compare
    max = input[0];

    // find max value in array
    for (i = 0; i < arrSize; i++)
    {
        if (input[i] > max)
        {
            max = input[i];
        }
    }
    cout << "Maximum Number: " << max << endl;

    return 0;
}
int program16() {
    cout << "FIND THE MIN NUMBER FROM INPUTS" << endl;
    findMin();
    
    cout << "\n\nFIND THE MAX NUMBER FROM INPUTS" << endl;
    findMax();
    
    return 0;
}



int main() {
    // program1();
    // program2();
    // program3();
    // program4();
    // program5();
    // program6();
    // program7();
    // program8();
    // program9();
    // program10();
    // program11();
    // program12();
    // program13();
    // program14();
    // program15();
    program16();

    
    return 0;
}

