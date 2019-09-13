// Not work with negative values

public class subarraySum {
    static int findSubarraySum(int[] arr, int length, int sum) {
        int current_sum = arr[0], ptr = 0;

        for (int i=1; i<length; i++) {
            while (current_sum > sum) {
                current_sum = current_sum - arr[ptr];
                ptr++;
            }

            if (current_sum == sum) {
                i--;
                System.out.println(ptr + " " + i);
                return 1;
            }

            current_sum += arr[i];
        }

        return 0;
    }

    public static void main (String[] args) {
        int[] arr = {15, 2, 4, 8, 9, 5, 10, 23};
//        int[] arr = {-15, 2, 4, 8, -9, 5, 10, 23};  Not work

        if (findSubarraySum(arr, arr.length, 26) == 0)
            System.out.println("No subarray Found");
    }
}
