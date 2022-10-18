
#ifndef NODE_LINK
#define NODE_LINK

//=====INCLUDES=====//
#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

//=====STRUCT=====//
typedef struct node {
    int obj;
    struct node* next;
} Node;

//=====PROTOTYPES=====//
Node* constructNode();
Node* constructNodeObj(int obj);
void clearNode(Node* node);

#endif
