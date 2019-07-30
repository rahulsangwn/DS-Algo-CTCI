#include <stdio.h>
#include <stdlib.h>
#include <time.h>

int isSquare (double);
int main () {
    clock_t begin = clock();

    int arr1[2][3] = {1, 2, 3, 4, 5, 6};
    int arr2[3][4] = {7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18};
    int res[2][4], i, j, k, max;

    i = sizeof (arr1)/sizeof (arr1[0]);
    j = sizeof (arr1[0])/sizeof (int);
    k = sizeof (arr2[0])/sizeof (int);

    if (i > j) {
        if (i > k) 
            max = i;
        else 
            max = k;
    } else {
        if (j > k)
            max = j;
        else 
            max = k;
    }

    while (!isSquare(max)) max++;

    int * new_array1 = (int *) malloc (sizeof(int)*max*max);
    int l, m, ptr = 0;
    for (l=0; l<max; l++) {
        for (m=0; m<max; m++) {
            if (l<i && m<j)
                new_array1[ptr] = arr1[l][m];
            else 
                new_array1[ptr] = 0;
            ptr++;
        }
    }

    int * new_array2 = (int *) malloc (sizeof(int)*max*max);
    ptr = 0;
    for (l=0; l<max; l++) {
        for (m=0; m<max; m++) {
            if (l<j && m<k)
                new_array2[ptr] = arr2[l][m];
            else 
                new_array2[ptr] = 0;
            ptr++;
        }
    }

    clock_t end = clock();
    double time;
}

int isSquare (double num) {
    if (num == 2)
        return 1;
    else if (num < 2)
        return 0;
    else {
        num /= 2;
        return(isSquare (num));
    }
}
