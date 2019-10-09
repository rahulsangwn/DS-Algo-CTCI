//Time Complexity: O(nlogn)

import java.util.Arrays;

public class InversionCount2 {
    private static int count = 0;
    public static void main(String[] args) {
        int[] arr = {2, 4, 1, 3, 5};

        msort(arr, 0, arr.length-1);
        System.out.println(count);
        System.out.println(Arrays.toString(arr));
    }

    private static void msort(int arr[], int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;

            msort(arr, start, mid);
            msort(arr, mid+1, end);

            merge (arr, start, mid+1, end);
        }
    }

    private static void merge(int[] arr, int start, int mid, int end) {
        int i = 0, j = 0, begin = start, L[] = new int[mid-start], R[] = new int[end-mid+1];

        for (int l=start, index=0; l<mid; l++, index++)
            L[index] = arr[l];
        for (int r=mid, index=0; r<=end; r++, index++)
            R[index] = arr[r];

        while ((i < mid-start) && (j < end-mid+1)) {
            if (L[i] > R[j]) {
                count += (mid - i - begin);
                arr[begin] = R[j];
                j++;
                begin++;
            } else {
                arr[begin] = L[i];
                i++;
                begin++;
            }
        }

        if (i < mid - start) {
            System.arraycopy(L, i, arr, begin, mid-i-start);
            count += mid-i;
        } else {
            System.arraycopy(R, j, arr, begin, end-j+1-mid);
        }
    }
}
