// Source: https://practice.geeksforgeeks.org/problems/number-of-pairs/0/

import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

public class NumberOfPairs {
    public static void main (String args[]) {
        Integer[] X = {2, 1, 6}, Y = {1, 5};
        int count = 0;

//        for (int i: X) {                              // Time Complexity O(m*n)
//            for (int j: Y) {
//                if (Math.pow(i, j) > Math.pow(j, i))
//                    count++;
//            }
//        }

        Arrays.sort(X);                                 // Time Complexity O(nlogn + mlogn)
        Arrays.sort(Y);

        List<Integer> list = Arrays.asList(Y);
        TreeSet<Integer> set = new TreeSet<>(list);

        for (int i: X) {
            if (i == 0);
            else if (i == 1) {
                int j=0;
                while (Y[j] == 0) {
                    count++;
                    j++;
                }
            }
            else {
                int number=0;
                try {
                    number = set.higher(i);
                } catch (Exception e) {
                    break;
                }
                int index = Arrays.binarySearch(Y, number);
                count += Y.length - index;
            }
        }
        if (Arrays.binarySearch(Y, 1) != -1) {          // For handling y=1 cases
            for (int i: X) {
                if (i != 1)
                    count++;
            }
        }

        System.out.println("No of pairs: " + count);
    }
}
