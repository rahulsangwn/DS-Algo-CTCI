#include <stdio.h>
#include <stdlib.h>

void insert (int number);
void find (int number);
void delete (int number);
void print ();


struct Node {
    int data;
    struct Node *link;
} head, *last_node;

int count (struct Node *);

int main () {
    int number, choice = 0;
    
    while (choice != 5) {
        printf ("\nChoose the action: ");
        printf ("\n 1. Insert ");
        printf ("\n 2. Find ");
        printf ("\n 3. Delete ");
        printf ("\n 4. Print List ");
        printf ("\n 5. Exit! ");
        printf ("\n 6. count \n");

        scanf("%d", &choice);
        
        switch (choice) {

            case 1 : printf ("\nEnter number to be inserted: ");
            scanf ("%d", &number);
            insert (number);
            break;

            case 2 : printf ("\nEnter number to be searched for: ");
            scanf ("%d", & number);
            find (number);
            break;

            case 3 : printf ("\nEnter number to be deleted: ");
            scanf ("%d", &number);
            delete (number);
            break;
            
            case 4 : printf ("\nHere is/are linked list element/s: ");
            print();
            break;

            case 6 : printf ("\nTotal no of nodes in the linked list: %d ", count(&head));
            break;
        }
    }
}

void insert (int number) {
    if (head.data == 0) {
        head.data = number;
        head.link = NULL;
        last_node = &head;
    } else {
        struct Node *new_node;
        new_node = (struct Node *) malloc (sizeof(struct Node));
        new_node -> data = number;
        new_node -> link = NULL;
        last_node -> link = new_node;
        last_node = new_node;
    }
}

void print () {
    struct Node *start;
    start = &head;
    do {
        printf ("%d ", start->data);
        start = start->link;
    } while (start != NULL);
    printf ("\n");
    exit(0);
}

int count (struct Node *start) {
    if (start->link == NULL)
        return 1;
    else {
        return (count(start->link) + 1);
    }
    
}

void find (int number) {
    struct Node *start;
    int count = 0;
    start = &head;
    while (start != NULL) {
        if (start->data == number) {
            printf ("Element found at index: %d", count);
            exit(0);
        } else {
            start = start->link;
            count++;
        }
    }
    printf ("Element not found in the list!");
}

void delete (int number) {
    struct Node *start;
    start = &head;
    while (start != NULL) {
        if ((start->link)->data == number) {
            start->link = (start->link)->link;
            print();
            exit(0);
        } else {
            start = start->link;
        }
    }
}