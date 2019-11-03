// Source: https://practice.geeksforgeeks.org/problems/largest-number-formed-from-an-array/0
// time complexity: O(n^2)

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class largestNumberFormed {

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new
                    InputStreamReader(System.in));
        }

        int next() {
            while (st == null || !st.hasMoreElements())
            {
                try
                {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException  e)
                {
                    e.printStackTrace();
                }
            }
            return Integer.parseInt(st.nextToken());
        }
    }

    public static void main(String[] args) throws IOException {
        List<Integer> list = new ArrayList<>();
        FastReader fr = new FastReader();
        int testCases = fr.next();
        String[] result = new String[testCases];
        for(int i = 0; i < testCases; i++) {
            int arrayLength = fr.next();
            int[] array = new int[arrayLength];

            for(int j = 0; j < arrayLength; j++) {
                list.add(fr.next());
            }

            result[i] = largestNumber(list);
        }

        for(String i: result) System.out.println(i);

    }

    private static String largestNumber(List<Integer> list) {
        String answer = "";
        while(list.size() != 0) {
            int newMax = 0, max = list.get(0);

            for(int i = 0; i < list.size() - 1; i++) {
                newMax = compare(list.get(i), list.get(i+1));

                max = compare(max, newMax);
            }
            answer = answer.concat(Integer.toString(max));
            list.remove(Integer.valueOf(max));
        }

        return answer;
    }

    private static int compare(int x, int y) {
        String a = Integer.toString(x);
        String b = Integer.toString(y);

        int number1 = Integer.parseInt(a + b);
        int number2 = Integer.parseInt(b + a);

        if (number1 > number2) return x;
        else return y;
    }

}
