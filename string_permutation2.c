#include <stdio.h>

void swap (char *item1, char *item2) {
    char temp;
    temp = *item1;
    *item1 = *item2;
    *item2 = temp;
}
void permute (char *string, int low, int high) {
    int i;
    if (low == high) {
        printf ("%s\n", string);
    } else {
        for (i=low; i<=high; i++) {
            swap((string + i), (string + low));
            permute(string, low+1, high);
            swap((string + i), (string + low));
        }
    }
}

int main() {
    char string[] = "abcef";
    permute(string, 0, 4);

    return 0;
}