// Source: https://practice.geeksforgeeks.org/problems/maximum-sum-rectangle/0
// using Kadane's Algorithm
// Time Complexity: O(n^3)

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MaximumSumRectangleMatrix {
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;
        FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        int next() {
            while(st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return Integer.parseInt(st.nextToken());
        }
    }

    private static int sumRectangle(int[][] array, int m, int n) {
        int maxLeft, maxRight, maxUp, maxBottom, right, left, currentSum, maxSum = Integer.MIN_VALUE;

        for (left = 0; left < n; left++) {
            int[] temp = new int[m];
            for (right = left; right < n; right++) {
                for (int i = 0; i < m; i++) {
                    temp[i] += array[i][right];
                }

                int sum = 0, start = 0, end = 0, max = Integer.MIN_VALUE;
                for (int i = 0; i < m; i++) {
                    sum += temp[i];

                    if (sum < 0) {
                        sum = 0;
                        if (max < sum) start = i + 1;
                    }

                    if (max < sum) {
                        max = sum;
                        end = i;
                    }
                }
                currentSum = max;

                if (currentSum > maxSum) {
                    maxSum = currentSum;
                    maxUp = start;
                    maxBottom = end;
                    maxLeft = left;
                    maxRight = right;
                }
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        FastReader fr = new FastReader();

        int testCases = fr.next();
        for (int i = 0; i < testCases; i++) {
            int m = fr.next();
            int n = fr.next();

            int[][] array = new int[m][n];
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < n; k++) {
                    array[j][k] = fr.next();
                }
            }

            System.out.println(sumRectangle(array, m, n));
        }
    }
}
