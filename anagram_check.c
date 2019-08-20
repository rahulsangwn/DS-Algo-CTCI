#include <stdio.h>

int main() {
    int H = 0, I = 0, aux = 1, i;
    char string1[] = "decimal", string2[] = "medical";

    for (i = 0; string1[i] != '\0'; i++) {
        aux = 1;
        aux = aux << string1[i] - 97;
        H = H | aux;
    }

    for (i = 0; string2[i] != '\0'; i++) {
        aux = 1;
        aux = aux << string2[i] - 97;
        I = I | aux;
    }

    if (H == I)
        printf ("Strings are anagram.\n");
    return 0;
}