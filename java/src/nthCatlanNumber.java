// Source: https://practice.geeksforgeeks.org/problems/nth-catalan-number/0
// using DP
// Time Complexity: O(n^2)

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class nthCatlanNumber {
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

    private static BigInteger[] dpArray;
    public static void main(String[] args) {
        FastReader fr = new FastReader();
        int testCases = fr.next();
        BigInteger[] result = new BigInteger[testCases];

        for(int i = 0; i < testCases; i++) {
            int number = fr.next();
            dpArray = new BigInteger[number+1];
            dpArray[0] = BigInteger.ONE;
            dpArray[1] = BigInteger.ONE;
            result[i] = catlanNumber(number);
        }

        for(BigInteger i: result) System.out.println(i);
    }

    private static BigInteger catlanNumber(int number) {
        if(dpArray[number] != null)
            return dpArray[number];
        else {
            BigInteger sum = BigInteger.ZERO;
            for(int i = 0; i < number; i++) {
                sum = sum.add(catlanNumber(i).multiply(catlanNumber(number-i-1)));
            }

            dpArray[number] = sum;
            return sum;
        }
    }
}
