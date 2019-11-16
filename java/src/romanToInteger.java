// Source: https://practice.geeksforgeeks.org/problems/roman-number-to-integer/0
// Time Complexity: O(letter in roman number)

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;

public class romanToInteger {
    private static final Map<Character, Integer> MAP;

    static {

        MAP = Map.of('I', 1, 'V', 5, 'X', 10, 'L', 50, 'C', 100, 'D', 500, 'M', 1000);
    }

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

        for (int i = 0; i < testCases; i++) {
            String roman = fr.next();

            romanToInt(roman);
        }
    }

    private static int valueOf(char roman) {
        return MAP.get(roman);
    }

    private static void romanToInt(String roman) {
        char[] array = roman.toCharArray();
        int answer = 0;
        int j = 1;
        if (array.length == 1) j = 0;
        for (int i = 0; i < array.length; ) {
            if (valueOf(array[i]) < valueOf(array[j])) {
                answer += valueOf(array[j]) - valueOf(array[i]);
                i = i + 2;
                j = j + 2;
            } else {
                answer += valueOf(array[i]);
                i++;
                j++;
            }
            if (j == array.length) j = i;
        }

        System.out.println(answer);
    }
}
