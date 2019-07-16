#include <stdio.h>
#include <stdlib.h>
int mergesort (int *arr, int i, int j);
void merge (int *, int, int, int);

int main () {
    int arr[] = {35, 70, 26, 45, 15, 95, 5, 28, 18};
    mergesort (arr, 0, 8);
    for (int i = 0; i < 8; i++)
        printf("%d ", arr[i]);
    return 0;
}

int mergesort (int *arr, int i, int j) {
    int m;
    if (i == j)
        return i;
    
    m = (i + j) / 2;
    mergesort (arr, i, m);
    mergesort (arr, m+1, j);

    merge (arr, i, m+1, j);
    
    return m+1;
}

void merge (int *arr, int p, int q, int r) {
    int *ptr, i = 0, j, no_of_elements = r-p+1, old_p = p;
    ptr = (int*) malloc((no_of_elements) * sizeof(int));

    while (p < q && q <= r) {
        if (arr[p] <= arr[q]) {
            ptr[i] = arr[p];
            p++;
        } else {
            ptr[i] = arr[q];
            q++;
        }
        i++;
    }
    if (p >= q) {
        for (;q <= r; q++) {
            ptr[i] = arr[q];
            i++;
        }
    } 
    else if (q > r) {
        for (; p < q-1; p++) {
            ptr[i] = arr[p];
            i++;
        }
    }
    for (j = 0; j < no_of_elements; j++) {
        arr[old_p] = ptr[j];
        old_p++;
    }
    free(ptr);
}