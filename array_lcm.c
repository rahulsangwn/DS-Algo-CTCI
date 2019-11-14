// Source: https://practice.geeksforgeeks.org/problems/number-game/0
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

long lcm(int number) {
    if (number < 2) return 1;
    else {
        long answer = 1;
        for (int i = 2; i <= number; i++) {
            answer = (answer * i) / adjust(answer, i);
        }

        return answer;
    }
}

int main() {
    int test_cases;
    scanf("%d", &test_cases);

    for (int j = 0; j < test_cases; j++) {
        int number;
        scanf("%d", &number);
        printf("%ld\n", lcm(number));
    }

    return 0;
}