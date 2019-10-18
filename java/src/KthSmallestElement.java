// Source: https://www.geeksforgeeks.org/kth-smallestlargest-element-unsorted-array/
// Time Complexity: O(k.logn)

import mylib.MyHeap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class KthSmallestElement {
    public static void main(String args[]) {
        int arr[] = {7, 10, 4, 3, 20, 15};
        int k = 3;

        System.out.println(findKth(arr, k));
    }

    private static int findKth(int arr[], int k) {
        int result = -1;
        ArrayList<Integer> arrayList = Arrays.stream(arr).boxed().collect(Collectors.toCollection(ArrayList::new));

        MyHeap myHeap = new MyHeap(arrayList);
        myHeap.buildHeap();

        for(int i = 0; i < k; i++)
            result = myHeap.extractMin();

        return result;
    }
}
