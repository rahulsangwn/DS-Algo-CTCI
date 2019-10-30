// Source: https://practice.geeksforgeeks.org/problems/trapping-rain-water/0
// Using Dynamic Programming
// Time Complexity: O(n)

public class trappingRainWater {
    public static void main(String[] args) {
        int[] array = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(getTrappingRainWater(array));
    }

    private static int getTrappingRainWater(int[] array) {
        int[] leftMaxArray, rightMaxArray;
        leftMaxArray = new int[array.length];
        rightMaxArray = new int[array.length];

        setLeftMax(leftMaxArray, array);
        setRightMax(rightMaxArray, array);

        return getTrappingUnits(leftMaxArray, rightMaxArray, array);
    }

    private static void setLeftMax(int[] leftMax, int[] array) {
        int max = Integer.MIN_VALUE;

        for(int i = 0; i < array.length; i++) {
            if(array[i] > max) {
                max = array[i];
            }
            leftMax[i] = max;
        }
    }

    private static void setRightMax(int[] rightMax, int[] array) {
        int max = Integer.MIN_VALUE;

        for(int i = array.length - 1; i >= 0; i--) {
            if(array[i] > max) {
                max = array[i];
            }
            rightMax[i] = max;
        }
    }

    private static int getTrappingUnits(int[] leftMaxArray, int[] rightMaxArray, int[] array) {
        int sum = 0;

        for(int i = 0; i < array.length; i++) {
            int lowerWall = Math.min(leftMaxArray[i], rightMaxArray[i]);
            sum += lowerWall - array[i];
        }

        return sum;
    }
}
