#include "dlinkedlist.h"

void dmerge (doubly **head, doubly **head2) {
    doubly *ptr, *h1 = *head, *h2 = *head2, *tail = (doubly *) malloc (sizeof(doubly));
    ptr = tail;
    tail->prev = NULL; 
    tail->data = '\0';
    while (h1 != NULL && h2 != NULL) {
        if (h1->data <= h2->data) {
            tail->next = h1;
            h1->prev = tail;
            h1 = h1->next;
            tail = tail->next;
            tail->next = NULL;
        } else {
            tail->next = h2;
            h2->prev = tail;
            h2 = h2->next;
            tail = tail->next;
            tail->next = NULL;
        }
    }

    if (h1 == NULL) {
        tail->next = h2;
        h2->prev = tail;
    } else {
        tail->next = h1;
        h1->prev = tail;
    }

    *head = ptr->next;
}

int main() {                                        //program driver
    doubly *head = NULL, *head2 = NULL;

    dinsert_front(&head, 2);
    dinsert_front(&head, 4);
    dinsert_front(&head, 11);
    dinsert_front(&head, 15);
    dreverse(&head);    

    dinsert_front(&head2, 5);
    dinsert_front(&head2, 11);
    dinsert_front(&head2, 14);
    dinsert_front(&head2, 18);
    dreverse(&head2);

    dmerge(&head, &head2);

    ddisplay(head);
    printf ("\n");
}