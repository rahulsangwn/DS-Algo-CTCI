#include <iostream>
#include <string.h>

using namespace std;

void palindrome(string str, int length) {
    int count = 0, i, j, k;
    for (i = 0; i < length; i++) {
        for (j = i-1, k = i+1; j >= 0 && k < length; j--, k++) {
            if (str[j] == str[k])
                count++;
            else 
                break;            
        }

        for (j = i, k = i+1; j >= 0 && k < length; j--, k++) {
            if (str[j] == str[k])
                count++;
            else 
                break;            
        }
    }

    cout << count << endl;
}

int main() {
    string str;
    int test_cases, length;

    cin >> test_cases;
   
    for(int i = 0; i < test_cases; i++) {
        cin >> length;
        cin >> str;

        palindrome(str, length);
    }

    return 0;
}

