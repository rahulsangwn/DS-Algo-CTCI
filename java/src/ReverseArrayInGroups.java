// Source: https://www.geeksforgeeks.org/reverse-an-array-in-groups-of-given-size/
// Time Complexity: O(n)

import java.util.Arrays;

public class ReverseArrayInGroups {
    public static void main(String[] args) {
        int arr[] = {10, 20, 30, 40, 50, 60, 70, 80};
        int slot = 3;

        reverseIng(arr, slot);
        System.out.println(Arrays.toString(arr));
    }

    private static void reverseIng(int[] arr, int slot) {
        int i, rem = arr.length % slot;                  // For last elements, which will not fit in slot
        for(i = 0; i < arr.length - rem; i += slot) {
            reverse(arr, i, slot);
        }

        reverse(arr, i, rem);
    }

    private static void reverse(int[] arr, int start, int slot) {
        int temp[] = new int[slot];

        System.arraycopy(arr, start, temp, 0, slot);

        for(int i = start, j = slot-1; i < slot + start; i++, j--) {
            arr[i] = temp[j];
        }
    }
}
