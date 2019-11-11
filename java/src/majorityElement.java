// Source: https://practice.geeksforgeeks.org/problems/majority-element/0
// Using Moore’s Voting Algorithm
// Time complexity: O(n)

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class majorityElement {

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

    public static void main(String[] args) {
        FastReader fr = new FastReader();
        int testCases = fr.next();
        int[] result = new int[testCases];

        for(int i = 0; i < testCases; i++) {
            int arraySize = fr.next();
            int[] array = new int[arraySize];

            for(int j = 0; j < arraySize; j++) array[j] = fr.next();

            result[i] = majority(array);
        }

        for(int value: result) System.out.println(value);
    }

    private static int majority(int[] array) {
        int count = 0, candidate = 0;

        for (int value : array) {
            if (count == 0) {
                candidate = value;
                count++;
            } else {
                if (candidate == value) count++;
                else count--;
            }
        }

        if (count <= 0) return -1;
        else {
            int repeated = 0;
            for (int value: array) {
                if(value == candidate) repeated++;
            }

            if (repeated > (array.length / 2)) return candidate;
            else return -1;
        }
    }
}
