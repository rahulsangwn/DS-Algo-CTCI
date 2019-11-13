#include <iostream>
#include <string.h>

using namespace std;

void palindrome(string str, int length) {
    int **dp_array = new int*[length];
    for (int i = 0; i < length; i++)
        dp_array[i] = new int[length];

    for (int i = length - 1; i >= 0; i--) {
        for (int j = i; j < length; j++) {
            if (i == j) dp_array[i][j] = 1;
            else if (str[i] != str[j]) dp_array[i][j] = 0;
            else {
                int subset = 0, subset2 = 2;
                if (i != j - 1) {
                    subset = dp_array[i+1][j-1]; 
                    if (dp_array[i+1][j-1] == 0) subset2 = 0;
                } 
                dp_array[i][j] = subset + subset2;
            }
        }
    }

    int max = 0, start = 0, last = 0;
    for (int i = 0; i < length; i++) {
        for (int j = 0; j < length; j++) {
            if (dp_array[i][j] > max) {
                max = dp_array[i][j];
                start = i;
                last = j;
            }
        }
    }
    cout << str.substr(start, last-start+1) << endl;
    for (int i = 0; i < length; i++)
        delete [] dp_array[i];
    delete [] dp_array;
    
}

int main() {
    string input;
    string str;
    int test_cases;

    cin >> input;
    // if (cin.fail()) cout << test_cases;
    if (isdigit(input[0]) == false) {
        palindrome(input, input.size());
        return 0;
    } else {
        test_cases = stoi(input);
    }
    for(int i = 0; i < test_cases; i++) {
        cin >> str;
        palindrome(str, str.size());
    }

    return 0;
}

