#include <stdio.h>

int main() {
    int arr[] = {1, 3, 4, 5, 6, 8, 9, 10, 12, 14};
    int i=0, j=9;

    while (i < j) {
        if (arr[i] + arr[j] == 10) {
            printf ("%d %d\n", arr[i], arr[j]);
            i++;
        } else if (arr[i] + arr[j] > 10) {
            j--;
        } else {
            i++;
        }
    }

    return 0;
}