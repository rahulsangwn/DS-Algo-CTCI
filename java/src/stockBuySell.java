// Source: https://practice.geeksforgeeks.org/problems/stock-buy-and-sell/0
// Time Complexity: O(n)

public class stockBuySell {
    public static void main(String[] args) {
        int[] array = {100, 180, 260, 310, 40, 535, 695, 50, 20};
        int i = 0, j = 0;

        while(j < array.length) {
            while(j+1 < array.length && array[j] <= array[j+1]) {
                j++;
            }

            if(i != j) System.out.println("(" + i + ", " + j + ")");

            j++;
            i = j;
        }
    }
}
