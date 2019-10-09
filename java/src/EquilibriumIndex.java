// Source: https://www.geeksforgeeks.org/equilibrium-index-of-an-array/
// Equilibrium position in an array is a position such that the sum of elements before it is equal to the sum of elements after it.
// Time Complexity: O(n)

import java.sql.SQLOutput;

public class EquilibriumIndex {
    public static void main(String args[]) {
        int[] arr = {-7, 1, 5, 2, -4, 3, 0};
        int index = equilibriumIndex(arr);

        if (index == -1)
            System.out.println("There is no equilibrium point in the array");
        else
            System.out.println("Equilibrium Index is: " + index);
    }

    private static int equilibriumIndex (int[] arr) {
        int sum = 0;

        for (int i: arr) {
            sum += i;
        }
        int i = 0, left_sum = 0;
        while (i < arr.length) {
            sum = sum - arr[i];
            if (left_sum == sum)
                return i;
            left_sum += arr[i];
            i++;
        }

        return -1;
    }
}
