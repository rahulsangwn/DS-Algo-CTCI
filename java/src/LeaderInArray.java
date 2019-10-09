// Source: https://www.geeksforgeeks.org/leaders-in-an-array/
// Time Complexity: O()

public class LeaderInArray {
    public static void main(String[] args) {
        int max=0, arr[] = {16, 17, 4, 3, 5, 2};

        for (int i=arr.length-1; i>=0; i--) {
            if (arr[i] > max) {
                System.out.println(arr[i]);
                max = arr[i];
            }
        }
    }

}
