// This program will work only if linked lists have distinct elements; because we are pushing elements onto the stack instead of pointers

#include "linkedlist.h"
#include "stack.h"

int intersect (singly *head1, singly *head2) {
    STACK *s1 = createStack(30), *s2 = createStack(30);
    int r;

    while (head1 != NULL) {
        push(s1, head1->data);
        head1 = head1->link;
    }

    while (head2 != NULL) {
        push(s2, head2->data);
        head2 = head2->link;
    }

    while ((peek(s1) == peek(s2))) {
        pop(s1);
        r = pop(s2);
    }

    return r;
}

int main() {
    singly *head = NULL, *head2 = NULL, *temp;
    
    insert_front(&head, 8);
    insert_front(&head, 2);
    insert_front(&head, 4);
    insert_front(&head, 1);
    temp = head;
    insert_front(&head, 3);
    insert_front(&head, 10);
    insert_front(&head, 7);
    
    head2 = temp;
    insert_front(&head2, 14);
    insert_front(&head2, 5);

    printf("Result : %d\n", intersect(head, head2));

}