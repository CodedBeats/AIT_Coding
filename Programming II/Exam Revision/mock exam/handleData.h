// Header Guard
#ifndef handle_data_HEADER_GUARD
#define handle_data_HEADER_GUARD

#pragma once
#include <fstream>
#include <sstream>
#include <string>
#include <vector>
#include <iostream>
#include "trader.h"
using namespace std;

vector<Trader> readDataFromFile(const string& filename);

#endif // handle_data_HEADER_GUARD