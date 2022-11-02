
#ifndef MATRIX_NODE
#define MATRIX_NODE

//=====INCLUDES=====//
#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

//=====STRUCT=====//
typedef struct node {
    struct node* top;
    struct node* bottom;
    struct node* left;
    struct node* right;
    int obj;
} Node;

//=====PROTOTYPES=====//
Node* constructNode();
Node* constructNodeObj(int obj);
void clearNode(Node* const node);

#endif
