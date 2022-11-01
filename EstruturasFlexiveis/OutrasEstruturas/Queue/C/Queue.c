
#include "header/Queue.h"

//=====CONSTRUCT======//
Queue* construct() {
    Queue* queue = (Queue*)malloc(sizeof(Queue));
    clear(queue);
    return queue;
}

//=====INITIALIZER=====//
void clear(Queue* const queue) {
    queue->first = NULL;
    queue->last = NULL;
    queue->len = 0;
}

//=====DESTRUCTOR=====//
void destruct(Queue* const queue) {
    Node* prev = NULL;
    Node* curr = queue->first;

    while(curr != NULL) {
        prev = curr;
        curr = curr->next;
        free(prev);
    }

    free(queue);
}

//=====METODOS=====//
//-----ISEMPTY-----//
bool isEmptyq(const Queue* const queue) {
    return queue->len == 0;
}

//-----ENQUEUE-----//
void enqueue(Queue* const queue, int obj) {
    Node* node = constructNodeObj(obj);

    if(isEmptyq(queue)) queue->first = queue->last = node;
    else {
        queue->last->next = node;
        queue->last = node;
    }

    queue->len++;
}

//-----DEQUEUE-----//
int dequeue(Queue* const queue) {
    Node* node = NULL;
    
    if(!isEmptyq(queue)) {
        node = queue->first;
        if(queue->first == queue->last) {
            free(queue->first);
            queue->first = queue->last = NULL;
        } else {
            Node* rem = queue->first;
            queue->first = queue->first->next;
            rem->next = NULL;
            free(rem);
            rem = NULL;
        }
    }

    queue->len--;
    return node->obj;
}

//-----PEEK-----//
int peek(const Queue* const queue) {
    return (!isEmptyq(queue)) ? queue->first->obj : 0;
}

//=====PRINT=====//
void printq(const Queue* const queue) {
    printf("[");

    Node* curr = queue->first;
    while(curr != NULL) {
        printf("%i", curr->obj);
        if(curr->next != NULL) printf(", ");
        curr = curr->next;
    }

    printf("]\n");
}   
