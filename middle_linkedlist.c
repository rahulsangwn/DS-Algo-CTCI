#include "linkedlist.h"

void middle_ll(singly *head) {
    singly *ptr = head;

    while (ptr->link != NULL && ptr->link->link) {
        head = head->link;
        ptr = ptr->link->link;
    }

    if (ptr->link == NULL) 
        printf("%d\n", head->data);
    else {
        printf("%d  %d\n", head->data, head->link->data);
    }
}

int main() {
    singly *head = NULL;
    insert_front(&head, 1);
    insert_front(&head, 2);
    insert_front(&head, 3);
    insert_front(&head, 4);
    insert_front(&head, 5);
    insert_front(&head, 6);
    insert_front(&head, 7);
    insert_front(&head, 8);
    insert_front(&head, 9);
    insert_front(&head, 10);

    middle_ll(head);
}