#include <stdio.h>

double ts_hr (double, int);
int main () {
    printf("The value is: %lf", ts_hr(4, 10));
    return 0;
}

double ts_hr (double x, int n) {
    static double sum = 1;
    if (n == 0) {
        return sum;
    } else {
        sum = 1 + x/n * sum;
        ts_hr (x, n-1);
    }
}