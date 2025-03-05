#ifndef LINKEDLIST_H
#define LINKEDLIST_H

typedef struct Node {
    int data;                // 2 Felder
    struct Node *next;      // Zeiger auf den nächsten Knoten
}TNode;

TNode *createNode(int data);
void nodePrint(TNode *node);
#endif //LINKEDLIST_H
