
#include "header/Node.h"

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

void clearNode(Node* node) {
    node->next = NULL;
    node->obj = 0;
}
