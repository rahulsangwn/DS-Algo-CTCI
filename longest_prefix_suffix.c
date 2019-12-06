// Source https://practice.geeksforgeeks.org/problems/longest-prefix-suffix/0
// using KMP preprocessing
// Time Complexity O(n)

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int find_length(char *arr, int *lps, int len) {
    lps[0] = 0;
    for (int i = 0, j = 1; j < len; ) {
        if (arr[i] == arr[j]) {
            lps[j] = i + 1;
            i++;
            j++;
        } else if (i == 0) {
            lps[j] = 0;
            j++;
        } else {
            i = lps[i - 1];
        }
    }
    return lps[len-1];
}
int main() {
    int test_cases, *lps;
    char str[100000];
    scanf("%d", &test_cases);

    while (test_cases--) {
        scanf("%s", str);
        int *lps = (int*) malloc(strlen(str) * sizeof(int));
        printf("%d", find_length(str, lps, strlen(str)));
    }

    return 0;
}