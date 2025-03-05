#include "linkedlist.h"

#include <stdio.h>
#include <stdlib.h>

TNode *createNode(int data) {
    TNode *node = malloc(sizeof(TNode));
    if (node == NULL) {
        printf("malloc");
        return 1;
    }

    node->data = data;
    node->next = NULL;
    return node;
}

void nodePrint(TNode *node) {
    TNode *temp = node;
    while (temp != NULL) {
        printf("%d ", temp->data);
        temp = temp->next;
    }
    printf("NULL\n");



}