#include "sort.h"

int triplets (int arr[], int length) {
    int i = 0, j = i+1, count = 0, k = j+1;

    for (i=0; i<length-2; i++) {
        for (j=i+1, k=i+2; k<length && j<k; ){
            if (arr[i] + arr[j] == arr[k]) {
                count++;
                j++;
                k++;
            } else if (arr[i] + arr[j] > arr[k]) {
                k++;
            } else {
                j++;
            }
        }
    }

    return count;
}

int main () {
    // int i, arr[] = {1, 2, 3, 4, 5, 7};
    // sort(arr, 10);
    int arr[30], res[10], i, j, T, N;
    scanf("%d\n", &T);
    for (i=0; i<T; i++) {
        scanf("%d\n", &N);
        for (j=0; j<N; j++) {
            scanf("%d", &arr[j]);
        }
        sort(arr, N);
        res[i] = triplets(arr, N);
    }

    for (i=0; i<T; i++) {
        printf("%d\n", res[i]);
    }

    return 0;

}