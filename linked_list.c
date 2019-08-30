#include <stdio.h>
#include <stdlib.h>

struct Node {
    int data;
    struct Node *link;
};

int count (struct Node *);
void reverse (struct Node **);
int insert_front (struct Node **, int number);
void display (struct Node *);
int find (struct Node *, int number);
void delete (struct Node **, int number);



int main () {
    int number, choice = 0;
    struct Node *head = NULL;
    
    while (choice != 5) {
        printf ("\nChoose the action: ");
        printf ("\n 1. Insert ");
        printf ("\n 2. Find ");
        printf ("\n 3. Delete ");
        printf ("\n 4. Print List ");
        printf ("\n 5. Exit! ");
        printf ("\n 6. count ");
        printf ("\n 7. Reverse \n");

        scanf("%d", &choice);
        
        switch (choice) {

            case 1 : printf ("\nEnter number to be inserted: ");
            scanf ("%d", &number);
            insert_front (&head, number);
            break;

            case 2 : printf ("\nEnter number to be searched for: ");
            scanf ("%d", & number);
            find (head, number);
            break;

            case 3 : printf ("\nEnter number to be deleted: ");
            scanf ("%d", &number);
            delete (&head, number);
            break;
            
            case 4 : printf ("\nHere is/are linked list element/s: ");
            display(head);
            break;

            case 6 : printf ("\nTotal no of nodes in the linked list: %d ", count(head));
            break;

            case 7 : printf ("\nLinked List Reversed ");
            reverse(&head);
            break;
        }
    }
}

int insert_front (struct Node **head, int item) {
    struct Node *new = (struct Node *) malloc(sizeof(struct Node));
    int status = new != NULL;

    if (status) {
        new->data = item;
        new->link = *head;
        *head = new;
    }

    return status;
}

void display (struct Node *head) {
    while (head != NULL) {
        printf ("%d -> ", head->data);
        head = head->link;
    }
    puts("NULL");
}

int count (struct Node *head) {
    if (head->link == NULL)
        return 1;
    else {
        return (count(head->link) + 1);
    }
    
}
void reverse (struct Node **head) {
    struct Node *temp1 = NULL, *temp2;

    while ((*head) != NULL) {
        temp2 = (*head)->link;
        (*head)->link = temp1;
        temp1 = (*head);
        (*head) = temp2;
    } 

    *head = temp1;
}

int find (struct Node *head, int number) {
    int count = 0;
    
    while (head != NULL) {
        if (head->data == number) {
            printf ("Element found at index: %d", count);
            return 1;
        } else {
            head = head->link;
            count++;
        }
    }
    printf ("Element not found in the list!");
    return -1;
}

void delete (struct Node **head, int number) {
    struct Node *start = *head, *temp = *head;
    while (start != NULL) {
        if (start->data == number) {
            if (*head == start) {       //When first element is deleted
                *head = start->link;
            }
            temp->link = start->link;
        } else {
            temp = start;
        }

        start = start->link;
    }

}