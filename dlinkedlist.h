#include <stdio.h>
#include <stdlib.h>

typedef struct DNode {
    struct DNode *prev;
    int data;
    struct DNode *next;
} doubly;

void dinsert_front (doubly **head, int number) {
    doubly *temp = (doubly *) malloc(sizeof(doubly));

    temp->prev = NULL;
    temp->data = number;
    temp->next = *head;
    if (*head != NULL) {
        (*head)->prev = temp;
    }
    *head = temp;
}

void dreverse (doubly **head) {
    doubly *start, *temp;
    start = *head;
    do {
        temp = start->prev;
        start->prev = start->next;
        start->next = temp;
        temp = start;   // assignement used for line 33
        start = start->prev;
    } while (start != NULL);

    *head = temp;
}
void ddisplay (doubly *head) {
    while (head != NULL) {
        printf("%d -> ", head->data);
        head = head->next;
    }

    printf("NULL");
}