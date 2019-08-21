#include <stdio.h>

void permute (char *, int);
int main() {
    char *string = "ABC";
    permute(string, 0);

    return 0;
}

void permute (char *string, int k) {
    int i = 0;
    static char flag[10], result[10];

    if (string[k] == '\0') {
        result[k] = '\0';
        printf ("%s\n", result);
    }

    for (i=0; string[i] != 0; i++) {
        if (flag[i] == 0) {
            result[k] = string[i];
            flag[i] = 1;

            permute(string, k+1);

            flag[i] = 0;
        }
    }
}