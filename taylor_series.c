#include <stdio.h>

double ts (int, int);
int main () {
    double res;
    res = ts (4, 10);
    printf ("The result is: %lf", res);

    return 0;
}

double ts (int x, int n) {
    static double p = 1, f = 1;
    double r;
    if (n == 0) 
        return 1;
    r = ts (x, n-1);
    p = x * p;
    f = f * n;

    return (r + (p / f));
}