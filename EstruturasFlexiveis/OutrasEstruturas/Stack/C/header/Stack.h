
#ifndef STACK
#define STACK

//=====INCLUDES=====//
#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include "Node.h"

//=====STRUCT=====//
typedef struct stack {
    Node* first;
    Node* last;
    int len;
} Stack;

//=====PROTOTYPES=====//
Stack* construct();
void clear(Stack* const stack);
void destruct(Stack* const stack);

bool isEmptys(const Stack* const stack);
void push(Stack* const stack, int obj);
int pop(Stack* const stack);
int peek(const Stack* const stack);
void invert(Stack* const stack);

void prints(const Stack* const stack);

#endif
