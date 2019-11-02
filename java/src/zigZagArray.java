// Source: https://www.geeksforgeeks.org/convert-array-into-zig-zag-fashion/
// using flag
// Time Complexity: O(n)

import java.io.IOException;
import java.util.Scanner;

public class zigZagArray {
    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);
        int numberOfTestCases = Integer.parseInt(scanner.nextLine());

        int[][] array = new int[numberOfTestCases][];

        for(int i = 0; i < numberOfTestCases; i++) {
            int numberOfElements = Integer.parseInt(scanner.nextLine());

            String data[] = scanner.nextLine().split(" ");
            array[i] = new int[numberOfElements];
            for(int j = 0; j < numberOfElements; j++) {
                array[i][j] = Integer.parseInt(data[j]);
            }

            setZigZag(array[i]);
        }

        for(int i = 0; i < numberOfTestCases; i++) {
            for(int j: array[i]) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    private static void setZigZag(int[] array) {
        boolean flag = true;

        for(int i = 0; i < array.length - 1; i++) {
            if(flag == true && array[i] > array[i+1]) swap(array, i);
            if(flag == false && array[i] < array[i+1]) swap(array, i);

            flag = !flag;
        }
    }

    private static void swap(int[] array, int index) {
        int temp = array[index];
        array[index] = array[index+1];
        array[index+1] = temp;
    }
}
