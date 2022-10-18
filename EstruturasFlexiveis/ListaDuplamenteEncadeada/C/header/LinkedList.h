
#ifndef LINKED_LIST
#define LINKED_LIST

//=====INCLUDES=====//
#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include "Node.h"

//=====STRUCT=====//
typedef struct {
    Node* first;
    Node* last;
    int len;
} LinkedList;

//=====PROTOTYPES=====//
LinkedList* construct();
void destruct(LinkedList* const list);
void clear(LinkedList* const list);

Node* node(LinkedList* const list, int idx);


#endif
