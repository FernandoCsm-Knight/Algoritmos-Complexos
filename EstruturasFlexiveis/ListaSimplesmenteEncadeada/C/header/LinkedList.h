
#ifndef LINKED_LIST
#define LINKED_LIST

//=====INCLUDES=====//
#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include "Node.h"

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
int search(LinkedList* const list, int obj);

void add(LinkedList* const list, int obj);
void addp(LinkedList* const list, int obj, int pos);
void insert(LinkedList* const list, int obj);

int pop(LinkedList* const list);
int popp(LinkedList* const list, int pos);
int popObj(LinkedList* const list, int obj);
int del(LinkedList* const list);

void print(LinkedList* list);

#endif
