// Source: https://practice.geeksforgeeks.org/problems/lcm-and-gcd/0
// Time Complexity: O(n*logn)

#include <stdio.h>
long gcd(long a, long b) {
    if (b == 0) return a;
    else return gcd(b, a % b);
}

long adjust(long a, long b) {
    if (a > b) return gcd(a, b);
    else return gcd(b, a);
}

int main() {
    int test_cases;
    scanf("%d", &test_cases);

    for (int j = 0; j < test_cases; j++) {
        long a, b, hcf;
        scanf("%ld %ld", &a, &b);
        hcf = adjust(a, b);
        printf("%ld %ld\n", (a*b)/hcf, hcf);
    }

    return 0;
}