// Source: https://practice.geeksforgeeks.org/problems/check-if-string-is-rotated-by-two-places/0
// using reversal rotation and jugling algo
// Time Complexity: O(n)

#include <bits/stdc++.h>

using namespace std;

bool check(string str1, string str2) {
    string temp = str1;
    reverse(temp.begin(), temp.end());
    reverse(temp.begin(), temp.end() - 2);
    reverse(temp.end() - 2, temp.end());

    if (temp == str2) return 1;

    temp = str1;
    reverse(temp.begin(), temp.end() - 2);
    reverse(temp.end() - 2, temp.end());
    reverse(temp.begin(), temp.end());

    if (temp == str2) return 1;

    return 0;
}
int main() {
    int test_cases;
    cin >> test_cases;
    for (int i = 0; i < test_cases; i++) {
        string str1, str2;
        cin >> str1 >> str2;

        cout << check(str1, str2) << endl;
    }
}