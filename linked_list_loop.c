#include <stdio.h>
#include "linkedlist.h"

int main () {
    struct Node *head = NULL, *p1 = NULL, *p2 = NULL;
    int a, b;
    insert_front(&head, 9);
    p1 = head;
    insert_front(&head, 3);
    insert_front(&head, 7);
    insert_front(&head, 4);

    p1->link = head;    // To make list circular

    insert_front(&head, 5);
    insert_front(&head, 8);

    p1 = head;
    p2 = head->link;

    while ((a = p1 != p2) && (b = (p2->link != NULL && p2->link->link != NULL))) {
        p1 = p1->link;
        p2 = p2->link->link;
    }

    if (a == 0)
        printf ("List is circular\n");
    else 
        printf ("List is linear\n");

    return 0;
}