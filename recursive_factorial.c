#include <stdio.h>

int fact(int);
int main() {
    int result;
    result = fact(5);
    printf("The result is: %d", result);
    return 0;
}

int fact (int n) {
    if (n == 0 || n == 1)
        return 1;
    else
        return(fact(n-1) * n);
}