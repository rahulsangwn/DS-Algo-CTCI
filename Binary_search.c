#include <stdio.h>
#include <stdlib.h>

int Binary_Search(int *arr, int start, int end, int element) {
    int mid;
    if (start == end) {
        if (arr[start] == element) {
            return start;
        } else {
            return -1;
        }
    } else {
        mid = (start + end) / 2;
        
        if (arr[mid] == element) {
            return mid;
        } else if (arr[mid] > element) {
            Binary_Search (arr, start, mid - 1, element);
        } else {
            Binary_Search (arr, mid + 1, end, element);
        }
    }
}

int main() {
    int num_elmt, *arr, i, index, element;
    
    printf ("Enter size of the array: \n");
    scanf ("%d", &num_elmt);

    arr = (int *) malloc (sizeof(int) * num_elmt);

    printf ("\nEnter the array elements: \n");
    for (i = 0; i < num_elmt; i++) {
        scanf ("%d", arr + i);
    }

    printf ("\nEnter element to be searched for: \n");
    scanf ("%d", &element);

    index = Binary_Search (arr, 0, num_elmt - 1, element);
    printf ("\nThe element found at index (start from 0): %d\n", index);
    
    free (arr);
}