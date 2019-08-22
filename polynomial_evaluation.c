#include <stdio.h>
#include <stdlib.h>
#include <math.h>

int main() {
    struct term {
        int coef;
        int exp;
    };

    struct poly {
        int n;
        struct term *t;
    };

    struct poly p;
    int i, sum = 0, x = 3;

    printf("Enter no. of terms in polynomial equation: \n");
    scanf("%d", &p.n);

    struct term *tr = (struct term *) malloc(sizeof(struct term) * p.n);
    p.t = tr;

    printf("Enter terms (coef and exp): \n");
    for (i=0; i<p.n; i++) 
        scanf("%d%d", &p.t[i].coef, &p.t[i].exp);

    for (i=0; i<p.n; i++) {
        sum += p.t[i].coef * pow(x, p.t[i].exp);
    }

    printf("The sum is: %d\n", sum);

    return 0;
}