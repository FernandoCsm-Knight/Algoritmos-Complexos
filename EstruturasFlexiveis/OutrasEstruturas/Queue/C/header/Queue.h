
#ifndef QUEUE
#define QUEUE

//=====INCLUDES=====//
#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include "Node.h"

//=====STRUCT=====//
typedef struct queue {
    Node* first;
    Node* last;
    int len;
} Queue;

//=====PROTOTYPES=====//
Queue* construct();
void clear(Queue* const queue);
void destruct(Queue* const queue);

bool isEmptyq(const Queue* const queue);
void enqueue(Queue* const queue, int obj);
int dequeue(Queue* const queue);
int peek(const Queue* const queue);
void invert(Queue* const queue);

void printq(const Queue* const queue);

#endif
