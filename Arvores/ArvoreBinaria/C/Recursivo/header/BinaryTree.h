
#ifndef BINARY_TREE
#define BINARY_TREE

//=====INCLUDES=====//
#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include "Node.h"

//=====STRUCT=====//
typedef struct binarytree {
    Node* root;    
    int len;
} BinaryTree;

//=====PROTOTYPES=====//
BinaryTree* construct();
void clear(BinaryTree* const bst);
void destructor(BinaryTree* const bst);

bool isEmpty(BinaryTree* const bst);
int getHeight(BinaryTree* const bst);

bool search(BinaryTree* const bst, int obj);
int min(BinaryTree* const bst);
int max(BinaryTree* const bst);

void add(BinaryTree* const bst, int obj);

void inOrder(BinaryTree* const bst);
void preOrder(BinaryTree* const bst);
void posOrder(BinaryTree* const bst);

#endif
