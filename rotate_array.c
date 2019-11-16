// Source: https://practice.geeksforgeeks.org/problems/reversal-algorithm/0
// Using juggling algorithm
// Time Complexity: O(n)
// Space Complexity: O(1)

#include <stdio.h>
#include <stdlib.h>

int gcd(int a, int b) {
    if (b == 0) return a;
    else return gcd(b, a % b);
}

int adjust(int a, int b) {
    if (a > b) return gcd(a, b);
    else return gcd(b, a);
}

void rotate(int *array, int length, int distance) {
    int temp, set = adjust(length, distance);
    
    for (int i = 0; i < set; i++) {
        int j = i, offset = -1;
        temp = array[i];
        while(1) {
            offset = (j + distance) % length;

            if (offset == i) break;

            array[j] = array[offset];
            j = offset;
        }
        array[j] = temp;
    }
}

int main() {
    int test_cases, length, distance;
    scanf("%d", &test_cases);
    for (int i = 0; i < test_cases; i++) {
        scanf("%d", &length);
        int *array = (int*) malloc((sizeof(int))*length);
        for (int j = 0; j < length; j++) {
            scanf("%d", &array[j]);
        }
        scanf("%d", &distance);

        rotate(array, length, distance);

        for (int j = 0; j < length; j++) {
            printf("%d ", array[j]);
        }
        free(array);
        printf("\n");
    }

    return 0;
}