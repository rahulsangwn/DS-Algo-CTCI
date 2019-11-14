// Source: https://practice.geeksforgeeks.org/problems/gcd-of-array/0
// Time Complexity: O(n*logn)

#include <stdio.h>
int gcd(int a, int b) {
    if (b == 0) return a;
    else return gcd(b, a % b);
}

int adjust(int a, int b) {
    if (a > b) return gcd(a, b);
    else return gcd(b, a);
}

int main() {
    int test_cases;
    scanf("%d", &test_cases);
    for (int j = 0; j < test_cases; j++) {
        int length, a, number;
        scanf("%d %d", &length, &a);

        for (int i = 1; i < length; i++) {
            scanf("%d", &number);
            a = adjust(a, number);
        }

        printf("%d\n", a);
    }

    return 0;
}