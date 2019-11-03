// Source: https://practice.geeksforgeeks.org/problems/permutations-of-a-given-string/0
// using backtracking and swap
// Time Complexity: O(n*n!): (time taken to solve one permutation * no. of permutation)


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.StringTokenizer;
import java.util.Vector;

public class stringPermutation {

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
        String[] string = new String[testCases];
        for(int i = 0; i < testCases; i++) string[i] = fr.next();

        for(int i = 0; i < testCases; i++) {
            permute(string[i].toCharArray(), 0, string[i].length());
            Collections.sort(vector);
            for(String str: vector) {
                System.out.print(str + " ");
            }
            vector.clear();
            System.out.println();
        }
    }

    static Vector<String> vector = new Vector<>();
    private static void permute(char[] array, int start, int length) {
        if(start == length - 1) {
            String str = "";
            for(char i: array) {
                str = str.concat(String.valueOf(i));
            }
            vector.add(str);
        } else {
            for(int left = start; left < length; left++) {
                swap(array, start, left);
                permute(array, start+1, length);
                swap(array, start, left);
            }
        }
    }

    private static void swap(char[] array, int first, int second) {
        char temp = array[first];
        array[first] = array[second];
        array[second] = temp;
    }
}
