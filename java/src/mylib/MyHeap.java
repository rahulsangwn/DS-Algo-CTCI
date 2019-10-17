/*----TestHeap.java Program to run this----*/
/*----Implemented heap abstract data types using ArrayList----*/

package mylib;

import java.util.ArrayList;
import java.util.Collections;

public class MyHeap {
    private static ArrayList<Integer> arrayList;
    private static int position;
    private static int maxSize;

    public MyHeap(ArrayList<Integer> arrayList) {
        this.arrayList = arrayList;
        this.maxSize  = arrayList.size();
        this.position = arrayList.size() - 1;
    }

    public int buildHeap() {

        for(int i = parent(position); i >= 0; i--) {
            minHeapify(i);
        }
        return 0;
    }

    public int insert(int item) {
        position++;
        arrayList.add(item);

        minHeapifyBottom(position);

        return position;
    }

    private static void minHeapifyBottom(int index) {
        while(parent(index) >= 0) {
            if(arrayList.get(index) < arrayList.get(parent(index))) {
                Collections.swap(arrayList, index, parent(index));
            }
            index = parent(index);
        }
    }

    private static int parent(int i) {
        if (i%2 == 0)
            return i/2 - 1;
        else
            return i/2;
    }

    private static int leftChild(int i) {
        return i*2 + 1;
    }

    private static int rightChild(int i) {
        return i*2 + 2;
    }

    private static void minHeapify(int i) {

        while (leftChild(i) <= position) {

            if (rightChild(i) <= position &&
                    arrayList.get(rightChild(i)) < arrayList.get(i) &&
                    arrayList.get(rightChild(i)) < arrayList.get(leftChild(i))) {
                i = rightChild(i);

                Collections.swap(arrayList, parent(i), i);
            } else if(arrayList.get(leftChild(i)) < arrayList.get(i)) {
                i = leftChild(i);

                Collections.swap(arrayList, parent(i), i);
            } else {
                break;
            }
        }
    }
}
