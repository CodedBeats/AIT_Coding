#pragma once
#include <string>
using namespace std;

class Date {
    public:
        void setDate(int day, int month, int year);
        void showDate();

    private: 
        int date;
        int month;
        int year;
};
