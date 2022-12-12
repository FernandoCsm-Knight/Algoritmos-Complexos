
#ifndef STACK_NODE
#define STACK_NODE

//=====INCLUDES=====//
#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

//=====STRUCT=====//
typedef struct node {
    struct node* next;
    int obj;
} Node;

//=====PROTOTYPES=====//
Node* constructNode();
Node* constructNodeObj();
void clearNode(Node* const node);

#endif
