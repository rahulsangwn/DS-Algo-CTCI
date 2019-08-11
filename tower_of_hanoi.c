#include <stdio.h>
#include "stack.h"

typedef struct Stack STACK;

void toi (int, STACK*, STACK*, STACK*);

int main () {
    STACK *stack1 = createStack(20), *stack2 = createStack(20), *stack3 = createStack(20);
    push(stack1, 3);
    push(stack1, 2);
    push(stack1, 1);
    toi (3, stack1, stack2, stack3);
    return 0;
}


void toi (int n, STACK *source, STACK *aux, STACK *destination) {
    if (n == 1) {
        push(destination, pop(source));
    } else {
        toi(n-1, source, destination, aux);
        push(destination, pop (source));
        toi(n-1, aux, source, destination);
    }
}


