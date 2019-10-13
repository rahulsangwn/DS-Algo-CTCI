package mylib;

public class MyHeap {
    public int BuildHeap(int[] array) {
        int length = array.length;

        for(int i = parent(length); i >= 0; i--) {
            minHeapify(array, i);
        }
        return 0;
    }

    private static int parent(int i) {
        return i/2 - 1;
    }

    private static int leftChild(int i) {
        return i*2 + 1;
    }

    private static int rightChild(int i) {
        return i*2 + 2;
    }

    private static void swap(int array[], int i, int j) {
        int temp;

        temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    private static void minHeapify(int array[], int i) {
        int length = array.length;

        while (leftChild(i) <= length) {

            if (rightChild(i) <= length-1 && array[rightChild(i)] < array[i] && array[rightChild(i)] < array[leftChild(i)]) {
                i = rightChild(i);

                swap(array, parent(i), i);
            } else if(array[leftChild(i)] < array[i]) {
                i = leftChild(i);

                swap(array,i/2, i);
            } else {
                break;
            }
        }
    }
}
