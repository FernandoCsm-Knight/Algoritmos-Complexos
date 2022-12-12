
#include "header/Node.h"

//=====CONSTRUCT=====//
Node* constructNode() {
    Node* node = (Node*)malloc(sizeof(Node));
    clearNode(node);
    return node;
}

Node* constructNodeObj(int obj) {
    Node* node = (Node*)malloc(sizeof(Node));
    node->top = NULL;
    node->bottom = NULL;
    node->left = NULL;
    node->right = NULL;
    node->obj = obj;
    return node;
}

//=====INITIALIZER=====//
void clearNode(Node* const node) {
    node->top = NULL;
    node->bottom = NULL;
    node->left = NULL;
    node->right = NULL;
    node->obj = 0;
}
