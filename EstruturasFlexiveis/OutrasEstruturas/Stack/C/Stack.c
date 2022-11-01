
#include "header/Stack.h"

//=====CONSTRUCTOR=====//
Stack* construct() {
    Stack* stack = (Stack*)malloc(sizeof(Stack));
    clear(stack);
    return stack;
}

//=====INITIALIZER=====//
void clear(Stack* const stack) {
    stack->first = NULL;
    stack->last = NULL;
    stack->len = 0;
}

//=====DESTRUCTOR=====//
void destruct(Stack* const stack) {
    Node* node = stack->first;
    Node* prev = NULL;

    while(node != NULL) {
        prev = node;
        node = node->next;
        free(prev);
    }

    free(stack);
}

//=====METODOS=====//
//-----ISEMPTY-----//
bool isEmptys(const Stack* const stack) {
    return stack->len == 0;
}

//-----PUSH-----//
void push(Stack* const stack, int obj) {
    Node* node = constructNodeObj(obj);
    

    if(isEmptys(stack)) stack->first = stack->last = node;
    else {
        node->next = stack->first;
        stack->first = node;
    }
    stack->len++;
}

//-----POP-----//
int pop(Stack* const stack) {
    int obj = 0;

    if(!isEmptys(stack)) {
        obj = stack->first->obj;

        if(stack->first == stack->last) {
            free(stack->first);
            stack->first = stack->last = NULL;
        } else {
            Node* curr = stack->first;
            stack->first = stack->first->next;
            free(curr);
        }
        
        stack->len--;
    }

    return obj;
}

//-----PEEK-----//
int peek(const Stack* const stack) {
    return (!isEmptys(stack)) ? stack->first->obj : 0;
}

//-----PRINT-----//
void prints(const Stack* const stack) {
    printf("[");

    Node* node = stack->first;
    while(node != NULL) {
        printf("%i", node->obj);
        if(node->next != NULL) printf(", ");
        node = node->next;
    }

    printf("]\n");
}