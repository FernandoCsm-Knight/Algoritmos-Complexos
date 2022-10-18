
#include "header/Node.h"

Node* constructNode() {
    Node* node = (Node*)malloc(sizeof(Node));
    clear(node);
    return node;
}

Node* constructNodeObj(int obj) {
    Node* node = (Node*)malloc(sizeof(Node));
    node->obj = obj;
    node->next = NULL;
    node->prev = NULL;
    return node;
}

void clear(Node* node) {
    node->obj = 0;
    node->next = NULL;
    node->prev = NULL;
}
