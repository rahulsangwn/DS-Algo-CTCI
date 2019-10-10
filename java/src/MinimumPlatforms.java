//Source: https://www.geeksforgeeks.org/minimum-number-platforms-required-railwaybus-station/
// Time Complexity: O(nlogn)

import java.util.Arrays;
import java.util.HashMap;

public class MinimumPlatforms {
    public static void main(String[] args) {
        int[] arrival = {900, 940, 950, 1100, 1500, 1800}, departure = {910, 1120, 1130, 1200, 1900, 2000};

        System.out.println("Minimum no. of platform needed: " + minimumPlatforms(arrival, departure));
    }

    private static int minimumPlatforms(int arrival[], int departure[]) {
        HashMap<Integer, String> hashMap = new HashMap<>();
        int currentPlatformCount = 0, platformRequired = 0;

        for(int i: arrival) {
            hashMap.put(i, "Arrival");
        }
        for(int i: departure) {
            hashMap.put(i, "Departure");
        }

        int res[] = merge(arrival, departure);

        for (int key: res) {
            if(hashMap.get(key).equals("Arrival")) {
                currentPlatformCount++;
            } else {
                currentPlatformCount--;
            }

            if (currentPlatformCount > platformRequired)
                platformRequired = currentPlatformCount;
        }

        return platformRequired;
    }

    private static int[] merge(int arr1[], int arr2[]) {
        int i = 0, j = 0, start = 0, res[];
        res = new int[arr1.length + arr2.length];
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] > arr2[j]) {
                res[start] = arr2[j];
                j++;
            } else {
                res[start] = arr1[i];
                i++;
            }
            start++;
        }

        while (i < arr1.length) {
            res[start] = arr1[i];
            i++;
            start++;
        }

        while (j < arr2.length) {
            res[start] = arr2[j];
            j++;
            start ++;
        }

        return res;
    }
}
