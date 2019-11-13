// Source: https://practice.geeksforgeeks.org/problems/longest-common-substring/0#ExpectOP
// Using Dynamic Programming
// Time Complexity: O(m*n)

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class LongestCommonSubstring {
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

            result[i] = lcs(dpArray, str1.toCharArray(), str2.toCharArray(), m, n);
        }

        for(int i: result) System.out.println(i);
    }

    private static int lcs(int[][] dpArray, char[] str1, char[] str2, int m, int n) {
        int result = 0;
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) {
                    dpArray[i][j] = 0;
                } else if (str1[i-1] == str2[j-1]) {
                    dpArray[i][j] = 1 + dpArray[i-1][j-1];
                    result = Math.max(result, dpArray[i][j]);
                } else {
                    dpArray[i][j] = 0;
                }
            }
        }
        return result;
    }
}
