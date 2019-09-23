// For all negative numbers case we have to modify the algorithm such that, it will pick the largest number
// only one number needs to be picked in case of all negative numbers

public class KadanesAlgorithm {
    public static void main (String[] args) {
        int arr[] = {-2, -3, 4, -1, -2, 1, 5, -3};

        largestSum(arr);
    }

    private static void largestSum (int arr[]) {
        int globalMaximum = 0, localMaximum = 0;

        for (int i: arr) {
            localMaximum += i;

            if (localMaximum < 0)
                localMaximum = 0;
            if (globalMaximum < localMaximum)
                globalMaximum = localMaximum;
        }

        System.out.println(globalMaximum);
    }
}
