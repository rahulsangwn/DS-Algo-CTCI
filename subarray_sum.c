#include <stdio.h>

void subarray (int A[], int length, int S) {
    int sum = 0, i = 0, k = 0;

    while (sum != S && i < length-1) {
        sum = 0;
        while (sum < S && k < length) {
            sum = sum + A[k];
            k++;
        }

        if (sum != S) {
            i++;
            k = i;
        }
    }

    if (sum == S) {
        printf("%d %d\n", i, k-1);
    } else {
        printf("Sorry\n");
    }
}

int main() {
    int A[] = {7, 9, 4, 3, 22};

    subarray (A, 5, 25);

    return 0;
}