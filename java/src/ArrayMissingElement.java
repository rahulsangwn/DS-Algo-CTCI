public class ArrayMissingElement {

    private static int offset;
    public static void main(String[] args) {
        int arr[] = {3, 4, 5, 6, 8, 9, 10};
        offset = arr[0];
        System.out.println("The missing element is: " + findArrayElement(arr, 0, arr.length - 1));;
    }

    private static int findArrayElement (int[] arr, int start, int end) {
        if (arr[start] + 2 == arr[start+1])
            return arr[start] + 1;
        else {
            int mid = (start + end) / 2;

            if (arr[mid] == mid + offset) {
                int result = findArrayElement(arr, mid, end);
                return result;
            } else {
                int result = findArrayElement(arr, start, mid -1 );
                return result;
            }
        }
    }
}


