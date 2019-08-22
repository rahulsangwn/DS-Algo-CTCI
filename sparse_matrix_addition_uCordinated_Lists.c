#include <stdio.h>
#include <stdlib.h>

int main() {
    int matrix1[7][3] = {{5, 4, 6}, {1, 2, 2}, {2, 1, 3}, {2, 4, 1}, {4, 2, 1}, {4, 3, 3}, {5, 1, 8}},
        matrix2[6][3] = {{5, 4, 5}, {1, 3, 8}, {2, 1, 4}, {2, 2, 1}, {3, 1, 7}, {5, 2, 3}};

    int r1 = matrix1[0][2] + 1, r2 = matrix2[0][2] + 1, c = 3, r3 = r1+r2+1, i, j, k;
    int **arr = (int **) malloc (r3* sizeof(int *));
    for (i=0; i<r3; i++) {
        arr[i] = (int *) malloc (c * sizeof(int));
    }

    for (i=1, j=1, k=1; (i<r1 || j<r2); ) {
        if (i > r1 || j > r2) {
            if (i > r1) {
                for (j; j<r2; j++, k++) {
                    arr[k][0] = matrix2[j][0];
                    arr[k][1] = matrix2[j][1];
                    arr[k][2] = matrix2[j][12];
                } 
            } else {
                for (i; i<r1; i++, k++) {
                    arr[k][0] = matrix1[i][0];
                    arr[k][1] = matrix1[i][1];
                    arr[k][2] = matrix1[i][12];
                } 
            }

            k--;

        } else if (matrix1[i][0] == matrix2[j][0]) {
            if (matrix1[i][1] == matrix2[j][1]) {
                arr[k][0] = matrix1[i][0];
                arr[k][1] = matrix1[i][1];
                arr[k][2] = matrix1[i][2] + matrix2[j][2];
                i++;
                j++;

            } else if (matrix1[i][1] < matrix2[j][1]) {
                arr[k][0] = matrix1[i][0];
                arr[k][1] = matrix1[i][1];
                arr[k][2] = matrix1[i][2];
                i++;
            } else {
                arr[k][0] = matrix1[i][0];
                arr[k][1] = matrix2[j][1];
                arr[k][2] = matrix2[j][2];
                j++;
            }
        } else if (matrix1[i][0] < matrix2[j][0]) {
            arr[k][0] = matrix1[i][0];
            arr[k][1] = matrix1[i][1];
            arr[k][2] = matrix1[i][2];
            i++;

        } else {
            arr[k][0] = matrix2[j][0];
            arr[k][1] = matrix2[j][1];
            arr[k][2] = matrix2[j][2];
            j++;
        }

        k++;
    }

    arr[0][0] = matrix1[0][0];    
    arr[0][1] = matrix1[0][1];    
    arr[0][2] = k-1;    

    for (i=0; i<r3; i++) {
        printf("%d ", arr[i][0]);
        printf("%d ", arr[i][1]);
        printf("%d \n", arr[i][2]);
    }

    return 0;
}