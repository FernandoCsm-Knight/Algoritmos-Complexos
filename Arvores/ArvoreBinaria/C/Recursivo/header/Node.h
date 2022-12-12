
#ifndef TREE_NODE
#define TREE_NODE

//=====INCLUDES=====//
#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

//=====STRUCT=====//
typedef struct node {
    struct node* left;
    struct node* right;
    int obj;
} Node;

//=====PROTOTYPES=====//
Node* constructNode();
Node* constructNodeObj(int obj);
void clearNode(Node* const node);

#endif
