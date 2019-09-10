#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>   

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

bool ddelete (doubly **head, int number) {
    doubly *start = *head;
    
    if (start->data == number) {    //first element deletion
        start->next->prev = NULL;
        *head = (*head)->next;
        start = *head;
    } else {
        while (start->data != number && start->next != NULL) {
            start = start->next;
        }
        start->prev->next = start->next;
        if (start->next != NULL) {   // for middle elements deletion
            start->prev->next->prev = start->prev;
        }
    }
    
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