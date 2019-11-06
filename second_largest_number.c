// Source: https://practice.geeksforgeeks.org/problems/find-second-largest-element/0
// using two iteration of bubble sort
// Time Complexity: O(n)

#include <stdio.h>
#include <stdlib.h>

void swap(int array[], int i, int j) {
    int temp = array[i];
    array[i] = array[j];
    array[j] = temp;
}

int second_largest(int array[], int size) {
    int i = 0, j = 1;
    for(int k = 0; k < 2; k++, size--) {
        for(i = 0, j = 1; j < size; i++, j++) {
            if(array[i] > array[j]) {
                swap(array ,i, j);
            }
        }
    }
    
    size++;
    if(array[i] == array[j]) {
        if(size == 2) {
            if(array[0] < array[1]) return array[0];
            else return -1;
        } else {
            return second_largest(array, size);
        }
    } else {
        return array[i];
    }
}

void main() {
    int test_cases, array_size;

    scanf("%d", &test_cases);
    int *result = (int*) malloc(sizeof(int) * test_cases);
    for(int i = 0; i < test_cases; i++) {
        scanf("%d", &array_size);
        int *array = (int*) malloc(sizeof(int) * array_size);
        for(int j = 0; j < array_size; j++) {
            scanf("%d", &array[j]);
        }
        result[i] = second_largest(array, array_size);
    }

    for(int i = 0; i < test_cases; i++) {
        printf("%d\n", result[i]);
    }
}
