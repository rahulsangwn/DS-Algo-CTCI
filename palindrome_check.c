#include <stdio.h>

int palindrome (char *string, size_t sz) {
    int i, range;
    sz--;
    range = sz / 2;
    for (i=0; i<range; i++, sz--) {
        if(string[i] != string[sz-1]) {
            printf("\nString is not palindrome.\n");
            return 0;
        }
    }
    printf("\nString is palindrome.\n");
    return 0;
}

int main() {
    char string[] = "abcdcba";
    size_t sz;
    sz = sizeof(string) / sizeof(char);
    palindrome(string, sz);
    
    return 0;
}

