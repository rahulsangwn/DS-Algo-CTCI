package mylib;

import java.util.Arrays;

public class MyHeap {
    private static int[] array;
    private static int position;
    private static int maxSize;

    public MyHeap(int[] array) {
        this.array = array;
        maxSize  = array.length;
        position = array.length;
    }

    public int buildHeap() {
        int position = array.length;

        for(int i = parent(position); i >= 0; i--) {
            minHeapify(i);
        }
        return 0;
    }

    public int insert(int item) {
        if(position >= maxSize && allocateBigArray()) {
            maxSize = array.length;
        }
        array[position] = item;
//        swap(0, position);
        position++;
        minHeapifyBottom(0);
        System.out.println(Arrays.toString(array));
        return 0;
    }

    private static void minHeapifyBottom(int index) {
        while(parent(index) >= 0) {
            if(array[index] < array[parent(index)]) {
                swap(index, parent(index));
                index = parent(index);
            }
        }
    }

    private boolean allocateBigArray() {
        int[] bigAarray = new int[(array.length)*2];
        System.arraycopy(array, 0, bigAarray, 0, array.length);

        array = bigAarray;

        return true;
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

    private static void swap(int i, int j) {
        int temp;

        temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    private static void minHeapify(int i) {

        while (leftChild(i) <= position) {

            if (rightChild(i) <= position-1 && array[rightChild(i)] < array[i] && array[rightChild(i)] < array[leftChild(i)]) {
                i = rightChild(i);

                swap(parent(i), i);
            } else if(array[leftChild(i)] < array[i]) {
                i = leftChild(i);

                swap(i/2, i);
            } else {
                break;
            }
        }
    }
}
