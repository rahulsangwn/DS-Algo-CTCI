package mylib;

public class MyHeap {
    public int BuildHeap(int[] array) {
        int length = array.length;

        for(int i = length/2 - 1; i >= 0; i--) {
            minHeapify(array, i);
        }
        return 0;
    }

    private static void minHeapify(int array[], int i) {
        int length = array.length, left;

        while ((left = i*2+1) <= length) {
            int temp;

            if (left+1 <= length-1 && array[left+1] < array[i] && array[left+1] < array[left]) {
                i = left+1;

                temp = array[i/2-1];
                array[i/2-1] = array[i];
                array[i] = temp;
            } else if(array[left] < array[i]) {
                i = left;

                temp = array[i/2];
                array[i/2] = array[i];
                array[i] = temp;
            } else {
                break;
            }
        }
    }
}
