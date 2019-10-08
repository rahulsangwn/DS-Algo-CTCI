// Source: https://practice.geeksforgeeks.org/problems/inversion-of-array/0/
// Also sorting the array
// Time Complexity: O(n^2)

import java.util.Arrays;

public class InversionCount {
    public static void main (String[] args) {
        int arr[] = {2, 4, 1, 3, 5};
        System.out.println(inversionCount(arr));
    }

    static int inversionCount (int[] arr) {
        int count=0;
        for (int i=1; i<arr.length; i++) {
            int backup = i;
            while (i > 0 && arr[i] < arr[i-1]) {
                int temp = arr[i];
                arr[i] = arr[i-1];
                arr[i-1] = temp;
                count++;
                i--;
            }
            i = backup;
        }
        System.out.println(Arrays.toString(arr));

        return count;
    }
}
