#include <stdio.h>
#include <stdlib.h>

struct Max_Min {
    int max;
    int min;
};

struct Max_Min DAC_max_min(int *arr, int start, int end) {
    int mid;
    struct Max_Min numbers, m1, m2;

    if (start == end) {
        numbers.max = numbers.min = arr[start];
        return numbers;
    } else if (start == end - 1) {
        if (arr[start] > arr[end]) {
            numbers.max = arr[start];
            numbers.min = arr[end];
        } else {
            numbers.max = arr[end];
            numbers.min = arr[start];
        }
        return numbers;
    } else {
        mid = (start + end) / 2;

        m1 = DAC_max_min (arr, start, mid);
        m2 = DAC_max_min (arr, mid + 1, end);

        if (m1.max > m2.max) {
            numbers.max = m1.max;
        } else {
            numbers.max = m2.max;
        }

        if (m1.min < m2.min) {
            numbers.min = m1.min;
        } else {
            numbers.min = m2.min;
        }

        return numbers;
    }
}

int main() {
    int num_elmt, *arr, i;
    struct Max_Min result;

    printf ("Enter the size of array: \n");
    scanf ("%d", &num_elmt);

    arr = (int *) malloc (sizeof(int) * num_elmt);

    printf ("Enter the array elements: \n");
    for (i = 0; i < num_elmt; i++) {
        scanf ("%d", arr + i);
    }

    result = DAC_max_min (arr, 0, num_elmt - 1);
    printf ("\nMax: %d\n", result.max);
    printf ("Min: %d\n", result.min);

    free (arr);
}