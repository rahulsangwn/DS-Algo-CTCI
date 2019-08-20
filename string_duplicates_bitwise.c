#include <stdio.h>

int main() {
    char string[] = "google";
    int H = 0, aux = 0, i;

    for (i = 0; string[i] != '\0'; i++) {
        aux = 1;
        aux = aux << string[i] - 97;
        if ((H & aux) > 0) {
            printf ("The letter %c is duplicated.\n", string[i]);
        } else {
            H = H | aux;
        }
    }
    return 0;
}