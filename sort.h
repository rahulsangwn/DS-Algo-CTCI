#include <stdio.h>

void quicksort (int[], int, int);
void sort (int arr[], int length) {
    quicksort (arr, 0, length-1);
}
// int main () {
//     int i, arr[] = {45, 62, 91, 18, 88, 72, 11, 10, 29, 54};
    
//     sort (arr, 10);

//     for (i = 0; i < 10; i++) {
//         printf ("%d ", arr[i]);
//     }

//     return 0;
// }

void quicksort (int arr[], int start, int end) {
    int num = start + 1, ptr = start + 1, temp;
    for (; num <= end; num++) {
        if (arr[start] >= arr[num]) {
            temp = arr[num];
            arr[num] = arr[ptr];
            arr[ptr] = temp;
            ptr++; 
        } 
    }
    temp = arr[ptr-1];
    arr[ptr-1] = arr[start];
    arr[start] = temp;

    if (ptr-1 != end) {
        quicksort (arr, ptr, end);
    }
    if (start != ptr-1) {
        quicksort (arr, start, ptr-2);
    }
}