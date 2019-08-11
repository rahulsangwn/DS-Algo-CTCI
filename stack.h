#include <stdio.h>
#include <stdlib.h>
#include <limits.h>

typedef struct Stack {
    int top;
    int capacity;
    int *array;
} STACK;

int isEmpty (STACK *stack) {
    if (stack->top == -1) {
        printf ("Stack empty!");
        return 1;
    } else {
        return 0;
    }
}

int isFull (STACK *stack) {
    if (stack->top == stack->capacity-1) {
        return 1;
    } else {
        return 0;
    }
}

int peek (STACK* stack) {
    if(isEmpty(stack))
        return INT_MIN;
    return stack->array[stack->top];
}
void push (STACK *stack, int item) {
    if (!isFull(stack)) {
        stack->array[stack->top+1] = item;
        (stack->top)++;
    } else {
        printf ("Stack full");
    }
}

int pop (STACK *stack) {
    if (!isEmpty(stack)) {
        (stack->top)--;
        return stack->array[stack->top+1];
    } else {
        printf (" : operation cannot be performed.");
        return -1;
    }
}

STACK * createStack (unsigned int capacity) {
    STACK *stack = (STACK*) malloc(sizeof(STACK));
    stack->capacity = capacity;
    int *arr = (int *) malloc(sizeof(int) * capacity);
    stack->array = arr;
    stack->top = -1;
    return stack;
}

// int main () {
//     STACK *B;
//     int s;
//     B = createStack(30);
//     push(B, 2);
//     push(B, 3);
//     printf ("Popped item: %d",pop(B));
//     printf ("\nPopped other item: %d\n", pop(B));
//     push(B, 54);
// }