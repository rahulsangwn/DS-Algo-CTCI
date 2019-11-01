// Source: https://www.geeksforgeeks.org/maximum-difference-between-two-elements/
// using finding maximum subarray concept
// Time Complexity: O(n)

public class maximumDifference {
    public static void main(String[] args) {
        int[] array = {2, 3, 10, 6, 4, 8, 2};
        System.out.println(maxDiff(array));
    }

    private static int maxDiff(int[] array) {
        int diff = 0, maxSoFar = 0, maxEndingHere = 0;

        for(int i = 0; i < array.length - 1; i++) {
            diff = array[i+1] - array[i];

            maxEndingHere += diff;

            if(maxEndingHere < 0) maxEndingHere = 0;
            if(maxSoFar < maxEndingHere) maxSoFar = maxEndingHere;
        }

        return maxSoFar;
    }
}
