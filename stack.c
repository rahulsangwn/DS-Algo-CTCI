#include <stdio.h>
#include <stdlib.h>

struct Stack {
    int top;
    int capacity;
    int *array;
};

int isEmpty (struct Stack *stack) {
    if (stack->top == 0) {
        printf ("Stack empty!");
        return 1;
    } else {
        return 0;
    }
}

int isFull (struct Stack *stack) {
    if (stack->top == stack->capacity-1) {
        return 1;
    } else {
        return 0;
    }
}

void push (struct Stack *stack, int item) {
    if (!isFull(stack)) {
        stack->array[stack->top+1] = item;
        (stack->top)++;
    } else {
        printf ("Stack full");
    }
}

int pop (struct Stack *stack) {
    if (!isEmpty(stack)) {
        (stack->top)--;
        return stack->array[stack->top+1];
    } else {
        printf (" : operation cannot be performed.");
        return -1;
    }
}

struct Stack * createStack (unsigned int capacity) {
    struct Stack *stack = (struct Stack*) malloc(sizeof(struct Stack));
    stack->capacity = capacity;
    int *arr = (int *) malloc(sizeof(int) * capacity);
    stack->array = arr;
    stack->top = 0;
    return stack;
}

int main () {
    struct Stack *B;
    int s;
    B = createStack(30);
    push(B, 2);
    push(B, 3);
    printf ("Popped item: %d",pop(B));
    printf ("\nPopped other item: %d\n", pop(B));
    push(B, 54);
}