import mylib.MyHeap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class TestHeap {
    public static void main(String[] args) {
        int[] array = {121, 131, 5, 15, 20, 25, 35, 80, 90, 100, 110, 135, 125, 115, 105, 95, 85};

        ArrayList<Integer> arrayList = Arrays.stream(array).boxed().collect(Collectors.toCollection(ArrayList::new));
        System.out.println("Array list: " + arrayList);
        MyHeap myHeap = new MyHeap(arrayList);

        myHeap.buildHeap();
        myHeap.insert(55);
        System.out.println("Minimum Element(removed): " + myHeap.extractMin());

        System.out.println("Heap Array: " + arrayList);

    }
}
