// Source: https://practice.geeksforgeeks.org/problems/convert-to-roman-no/1
// Time Complexity: 

#include <iostream>
using namespace std;
string roman(int *number) {
    int num = *number;
    if (num <= 3) {
        *number = num - 1;
        return "I";
    } else if (num == 4) {
        *number = num - 4;
        return "IV";
    } else if (num <= 8) {
        *number = num - 5;
        return "V";
    } else if (num == 9) {
        *number = num - 9;
        return "IX";
    } else if (num <= 39) {
        *number = num - 10;
        return "X";
    } else if (num <= 49) {
        *number = num - 40;
        return "XL";
    } else if (num <= 89) {
        *number = num - 50;
        return "L";
    } else if (num <= 99) {
        *number = num - 90;
        return "XC";
    } else if (num <= 399) {
        *number = num - 100;
        return "C";
    } else if (num <= 499) {
        *number = num - 400;
        return "CD";
    } else if (num <= 899) {
        *number = num - 500;
        return "D";
    } else if (num <= 999) {
        *number = num - 900;
        return "CM";
    } else {
        *number = num - 1000;
        return "M";
    }
}

int main() {
    int test_cases, number;
    cin >> test_cases;
    for (int i = 0; i < test_cases; i++) {
        cin >> number;
        
        while (number != 0) {
            cout << roman(&number);
        }
        cout << endl;
    }

    return 0;
}