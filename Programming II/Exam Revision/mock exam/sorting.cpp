#include <iostream>
#include <algorithm>
using namespace std;

void sortInts(int arr[], int n) {

    // print un-sorted arr
    cout << "\nUn-sorted array: ";
    for (int i = 0; i < n; i++) {
        cout << arr[i] << " ";
    }
    cout << "" << endl;

    // sort the arr
    sort(arr, arr + n);

    // print sorted arr
    cout << "Sorted array: ";
    for (int i = 0; i < n; i++) {
        cout << arr[i] << " ";
    }
}
