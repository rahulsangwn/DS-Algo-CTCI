// Source: https://practice.geeksforgeeks.org/problems/ncr/0
// Using simple calculation with for loop
// Time Complexity: O(n)


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class nCrCalculation {
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

    private static int[][] dpArray;
    public static void main(String[] args) {
        FastReader fr = new FastReader();

        int testCases = fr.next();
        int[] result = new int[testCases];
        for(int i = 0; i < testCases; i++) {
            int n = fr.next();
            int r = fr.next();

            dpArray = new int[n+1][r+1];
            for(int j = 0; j <= n; j++) dpArray[j][0] = 1;

            if(n < r) result[i] = 0;
            else result[i] = nCr(n, r);
        }

        for(int i: result) {
            System.out.println(i);
        }
    }

    private static final int M_NUMBER = 1000000007;
    private static int nCr(int n, int r) {
        if(n > r) {
            if(dpArray[n][r] != 0)
                return dpArray[n][r];
            else {
                int result = ((nCr(n-1, r-1) % M_NUMBER) + (nCr(n-1, r) % M_NUMBER)) % M_NUMBER;

                dpArray[n][r] = result;
                return result;
            }
        } else if(n == r) {
            return 1;
        } else {
            return 0;
        }
    }
}
