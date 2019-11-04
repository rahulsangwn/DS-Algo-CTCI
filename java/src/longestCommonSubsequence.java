// Source: https://practice.geeksforgeeks.org/problems/longest-common-subsequence/0
// Using Dynamic Programming
// Time Complexity: O(2^n)

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class longestCommonSubsequence {
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;
        FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while(st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
    }

    public static void main(String[] args) {
        FastReader fr = new FastReader();
        int testCases = Integer.parseInt(fr.next());
        int[] result = new int[testCases];
        int m = 0, n = 0;

        for(int i = 0; i < testCases; i++) {
            m = Integer.parseInt(fr.next());
            n = Integer.parseInt(fr.next());

            String str1 = fr.next();
            String str2 = fr.next();
            int[][] dpArray = new int[m+1][n+1];
            for(int[] row: dpArray) Arrays.fill(row, -1);

            result[i] = lcs(dpArray, str1.toCharArray(), str2.toCharArray(), m, n);
        }

        for(int i: result) System.out.println(i);
    }

    private static int lcs(int[][] dpArray, char[] str1, char[] str2, int m, int n) {
        if(m == 0 || n == 0) {
            dpArray[m][n] = 0;
            return 0;
        }
        else if(str1[m-1] == str2[n-1]) {
            dpArray[m][n] = 1;
            return (1 + lcs(dpArray, str1, str2, m-1, n-1));
        }
        else {
            if(dpArray[m][n] != -1) return dpArray[m][n];
            else {
                int lengthOfLCS = Math.max(lcs(dpArray, str1, str2, m, n-1), lcs(dpArray, str1, str2, m-1, n));
                dpArray[m][n] = lengthOfLCS;
                return lengthOfLCS;
            }
        }
    }
}
