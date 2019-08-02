#include <stdio.h>

int fib (int);
int main () {
    printf ("The value is: %d", fib(7));
    return 0;
}

int fib (int num) {
    if (num <= 1) {
        return num;
    } else {
        return (fib(num-1) + fib(num-2));
    }
}