#include <stdio.h>
#include <time.h>

int main () {
    clock_t begin = clock ();

    int arr1[][3] = {{1, 2, 3}, {4, 5, 6}};
    int arr2[][4] = {{7, 8, 9, 10}, {11, 12, 13, 14}, {15, 16, 17, 18}};
    int i, j, k, res[2][4];

    for (i=0; i<2; i++) {
        for (j=0; j<4; j++) {
            res[i][j] = 0;
        }
    }

    for (i=0; i<2; i++) {
        for (j=0; j<4; j++) {
            for (k=0; k<3; k++) {
                res[i][j] += (arr1[i][k] * arr2[k][j]);
            }
        }
    }

    for (i=0; i<2; i++) {
        for (j=0; j<4; j++) {
            printf ("%8d ", res[i][j]);
        }
        printf ("\n");
    }

    clock_t end = clock ();
    double time_spent = (double) (end - begin) / CLOCKS_PER_SEC;

    printf("\n Time take by the Program (in sec): %lf\n", time_spent);
}