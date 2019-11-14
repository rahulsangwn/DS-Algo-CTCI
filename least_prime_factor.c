// Source: https://practice.geeksforgeeks.org/problems/least-prime-factor/0
// using Sieve of Eratosthenes
// Time Complexity: O(n*n*n)

#include <stdio.h>
#include <stdlib.h>
#include <math.h>

void calculate(int number) {
    if (number == 1) printf("1 ");
    int *array = (int*) malloc(sizeof(int)*(number+1));

    for (int i = 0; i <= number; i++) array[i] = i;
    int flag = 1;
    for (int i = 2; i <= number; i++) {
        if (array[i] == 0) continue;
        if (number%i == 0 && flag == 1) {
            printf("%d ", array[i]);
            flag = 0;
        }
        int j = 2;
    
        while (array[i] * j <= number) {
            array[i*j] = 0;
            j++;
        }
    }
}

int main() {
    int testCases, number;
    scanf("%d", &testCases);

    for (int i = 0; i < testCases; i++) {
        scanf("%d", &number);
        for (int j = 1; j <= number; j++) {
            calculate(j);
        }
        printf("\n");
    }

    return 0;
}