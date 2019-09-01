#include <stdio.h>
#include <limits.h>
#include "linkedlist.h"

void merge (struct Node **list1, struct Node **list2) {
    struct Node *s1 = *list1, *s2 = *list2, *temp, *temp2;

    while (s1->link != NULL && s2->link != NULL) {
        if (s1->data <= s2->data) {
            temp = s1;
            s1 = s1->link;
        } else {
            temp->link = s2;
            temp2 = s2->link;
            s2->link = s1;
            s2 = temp2;
            temp = temp->link;
        }
    }
}

int main() {
    struct Node *list1 = NULL, *list2 = NULL;
    insert_front(&list1, 2);
    insert_front(&list1, 8);
    insert_front(&list1, 10);
    insert_front(&list1, 15);

    insert_front(&list1, INT_MAX);
    insert_front(&list1, INT_MAX);
    
    reverse(&list1);

    insert_front(&list2, 4);
    insert_front(&list2, 7);
    insert_front(&list2, 12);
    insert_front(&list2, 14); 
    
    insert_front(&list2, INT_MAX);

    reverse(&list2);

    merge(&list1, &list2);

    delete(&list1, INT_MAX);

    display(list1);

    return 0;
}