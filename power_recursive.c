#include <stdio.h>

int power (int, int);
int main () {
    int result;
    result = power (3, 4);
    printf ("\nThe result is: %d\n", result);

    return 0;
}

int power (int s, int i) {
    if (i == 0)
        return 1;
    else if (i == 1)
        return s;
    else 
        return (power (s, i-1) * s);
}