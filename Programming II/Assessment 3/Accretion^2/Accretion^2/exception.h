// Header Guard
#ifndef game_HEADER_GUARD
#define game_HEADER_GUARD

#include <iostream>
#include <exception>
using namespace std;

class nonIntException : public exception {
public:
	virtual const char* what() const throw() {
		return "A non integer was entered";
	}
};


#endif // game_HEADER_GUARD