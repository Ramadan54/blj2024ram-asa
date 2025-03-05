#include <stdio.h>
#include <stdlib.h>
#include "linkedlist.h"

TNode *createNode(int data);

int main(void) {
    TNode *head = malloc(sizeof(TNode)); // Speichert Platz
    if (head == NULL) {
        printf("malloc"); // falls speicher nicht reserviert wurde für first
        return 1;
    }
    struct Node *second = malloc(sizeof(struct Node *));
    if (second == NULL) {
        printf("malloc"); // falls speicher nicht reserviert wurde für second
        return 1;
    }
    struct Node *third = malloc(sizeof(struct Node *));
    if (head == NULL) {
        printf("malloc"); // falls speicher nicht reserviert wurde für third
        return 1;
    }

    head->data = 10;
    second->data = 20; // zuweisung von werten an first, second und third
    third->data = 30;

    head->next = second;
    second->next = third; // verlinkung von first zu second, second zu third und third zu null, weil es das ende ist
    third->next = NULL;

    struct Node *current = head;

    current = current->next;
    current = current->next;

    printf("Letzter Node %d\n", current->data);

    free(head);
    free(second); // freigebung vom speicher von first, second und third
    free(third);
    head = NULL;
    second = NULL; // zuweisung von null and first, second und third, alten speicher platz kann nicht mehr gefunden werden
    third = NULL;


    TNode *head2 = createNode(1);
    TNode *second2 = createNode(2);
    TNode *third2 = createNode(3);

    head2->next = second2;
    second2->next = third2;

    nodePrint(head2);




    return 0;
}

