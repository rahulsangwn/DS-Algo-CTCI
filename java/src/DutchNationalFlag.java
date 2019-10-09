// Source: https://www.geeksforgeeks.org/3-way-quicksort-dutch-national-flag/
// 3-Way quick sort Algorithm || Dutch National Flag Algorithm
// Time complexity: O(n)

import java.util.Arrays;

public class DutchNationalFlag {
    public static void main(String[] args) {
        int[] arr = {2, 4, 2, 4, 2, 4, 1, 2, 4, 1, 2, 2, 4, 1};
        int index = sort(arr, 1, 0);
        sort(arr, 2, index);

        System.out.println(Arrays.toString(arr));
    }

    private static int sort(int[] arr, int pivot, int start) {
        int replace = start;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == pivot) {
                int temp = arr[replace];
                arr[replace] = arr[i];
                arr[i] = temp;
                replace++;
            }
        }

        return replace;
    }
}
