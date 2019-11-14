// Source: https://practice.geeksforgeeks.org/problems/sieve-of-eratosthenes/0
// using Sieve of Eratosthenes
// Time Complexity: O(n*log(logn))

#include <stdio.h>
#include <stdlib.h>
#include <math.h>

void calculate(int number) {
    int *array = (int*) malloc(sizeof(int)*(number+1));

    for (int i = 0; i <= number; i++) array[i] = i;
    int square_root = sqrt(number);
    for (int i = 2; i <= square_root; i++) {
        if (array[i] == 0) continue;
        int j = 2;
        while (array[i] * j <= number) {
            array[i*j] = 0;
            j++;
        }
        // if (i == 2) i;
    }

    for (int i = 2; i <= number; i++) {
        if (array[i] != 0) printf("%d ", array[i]);
    }
}

int main() {
    int testCases, number;
    scanf("%d", &testCases);

    for (int i = 0; i < testCases; i++) {
        scanf("%d", &number);
        calculate(number);
        printf("\n");
    }

    return 0;
}