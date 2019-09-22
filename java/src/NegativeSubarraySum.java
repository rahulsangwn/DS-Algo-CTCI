// Find subarray with given sum - Handles Negative Number

import java.util.HashMap;
import java.util.Map;

public class NegativeSubarraySum {
    public static void main (String[] args) {
        int arr[] = {3, 10, 2, -2, -20, 10}, sum = -10, length = arr.length;
        negativeSubarraySum(arr, length, sum);
    }

    private static void negativeSubarraySum (int arr[], int length, int sum) {
        Map<Integer, Integer> map = new HashMap<>();

        int current_sum = 0;
        int index = 0;
        for (int i: arr) {
            current_sum += i;

            if (current_sum == sum) {
                System.out.println("The index start from 0 and end at " + index);
                return;
            } else if (map.containsKey(current_sum - sum)) {
                int start = map.get(current_sum - sum) + 1;

                System.out.println("The index start from " + start + " and end at " + index);
                return;
            } else {
                map.put(current_sum, index);
                index++;
            }
        }

        System.out.println("Sum not found");
    }
}
