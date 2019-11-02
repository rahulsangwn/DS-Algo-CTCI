//Source: https://practice.geeksforgeeks.org/problems/spirally-traversing-a-matrix/0
// Time Complexity: O(n)


import java.util.Scanner;

public class printSpiralMatrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        int[][] result = new int[testCases][];

        for(int i = 0; i < testCases; i++) {
            int p = sc.nextInt();
            int q = sc.nextInt();

            int array[][] = new int[p][q];
            for(int j = 0, index = 0; j < p; j++) {
                for(int k = 0; k < q; k++, index++) {
                    array[j][k] = sc.nextInt();
                }
            }
            result[i] = new int[p*q];
            setSpiralMatrix(p, q, array, result[i]);
        }

        for(int i = 0; i < testCases; i++) {
            for(int j = 0; j < result[i].length; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }

    }

    private static void setSpiralMatrix(int p, int q, int[][] m, int[] res) {
        int start_col = 0, start_row = 0, last_col = q - 1, last_row = p - 1, index = 0;

        while(start_col <= last_col && start_row <= last_row) {
            for(int i = start_col; i <= last_col; i++) {
                res[index] = m[start_row][i];
                index++;
            }
            start_row++;

            for(int i = start_row; i <= last_row; i++) {
                res[index] = m[i][last_col];
                index++;
            }
            last_col--;

            if(start_row <= last_row) {
                for(int i = last_col; i >= start_col; i--) {
                    res[index] = m[last_row][i];
                    index++;
                }
                last_row--;
            }

            if(start_col <= last_col) {
                for(int i = last_row; i >= start_row; i--) {
                    res[index] = m[i][start_col];
                    index++;
                }
                start_col++;
            }
        }
    }
}
