#include "stack.h"
#include <stdbool.h>
bool isMatchingPair(char op1, char op2) {
    if (op1 == ')' && op2 == '(')
        return 1;
    else if (op1 == ']' && op2 == '[')
        return 1;
    else if (op1 == '}' && op2 == '{')
        return 1;
    else
        return 0;
    
}
bool isParenthesisBalanced (char arr[]) {
    STACK *s = createStack(30);
    int i;

    push(s, '\0');

    for (i=0; arr[i] != '\0'; i++) {
        if (arr[i] == '(' || arr[i] == '[' ||arr[i] == '{') {
            push (s, arr[i]);
        } else if (arr[i] == ')' || arr[i] == ']' || arr[i] == '}') {
            if (!isMatchingPair(arr[i], pop(s)))
                return 0;

        }
    }
    if (pop(s) != '\0') 
        return 0;
    else 
        return 1;
}

int main () {
    char arr[] = "[{{([a+b]*[c-d])+a}}]";

    if(isParenthesisBalanced(arr))
        printf("Balanced\n");
    else
        printf("Not Balanced\n");

    return 0;    
}