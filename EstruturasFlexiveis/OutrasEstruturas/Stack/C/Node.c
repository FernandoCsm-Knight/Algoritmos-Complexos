
#include "header/Node.h"

//=====CONSTRUCTOR=====//
Node* constructNode() {
    Node* node = (Node*)malloc(sizeof(Node));
    clearNode(node);
    return node;
}

Node* constructNodeObj(int obj) {
    Node* node = (Node*)malloc(sizeof(Node));
    node->next = NULL;
    node->obj = obj;
    return node;
}

//=====INITIALIZER=====//
void clearNode(Node* const node) {
    node->next = NULL;
    node->obj = 0;
}
