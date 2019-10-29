// Source: https://practice.geeksforgeeks.org/problems/kth-smallest-element/0
// Using quick select
// average time complexity = O(n)

public class KthSmallestElement2 {
    public static int[] arr;
    public static void main(String args[]) {
        arr = new int[]{2, 1, 6, 4, 5, 3};
        System.out.println(find(3)); // 4th smallest element
    }

    private static int find(int k) {
        int i = -1, start = 0, end = arr.length-1;

        while(k != i) {
            i = part(start, end);
            if(i == k)
                return arr[i];
            else if(i < k)
                start = i + 1;
            else
                end = i - 1;
        }
        return -1;
    }

    private static int part(int start, int end) {
        int tail = start, pivot = arr[start];
        swap(start, end);

        while(start < end) {
            if(arr[start] < pivot) {
                swap(start, tail);
                tail++;
            }
            start++;
        }
        swap(tail, end);
        return tail;
    }

    private static void swap(int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
