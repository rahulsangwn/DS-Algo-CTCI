#include "dlinkedlist.h"

int main() {
    doubly *head = NULL;

    dinsert_front(&head, 2);
    dinsert_front(&head, 4);
    dinsert_front(&head, 11);
    dinsert_front(&head, 15);

    dreverse(&head);

    ddisplay(head);
}