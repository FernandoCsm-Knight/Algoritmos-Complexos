
#include "header/LinkedList.h"

//=====ALOCATION=====//
LinkedList* construct() {
    LinkedList* list = (LinkedList*)malloc(sizeof(LinkedList));
    clear(list);
    return list;
}

void clear(LinkedList* const list) {
    list->first = NULL;
    list->last = NULL;
    list->len = 0;
}

void destruct(LinkedList* const list) {
    for(int i = list->len - 1; i >= 0; i--)     
        free(node(list, i));
    free(list);
}

//=====SEARCH=====//
Node* node(LinkedList* const list, int idx) {
    Node* curr = list->first;
    
    for(int i = 0; i < idx; i++)
        curr = curr->next;

    return curr;
}

//=====ADD=====//
void add(LinkedList* const list, int obj) {
    Node* node = constructNodeObj(obj);

    if(list->len == 0) {
        list->first = node;
        list->last = node;
    } else {
        list->last->next = node;
        list->last = node;
    }

    list->len++;
}

void addp(LinkedList* const list, int obj, int pos) {
    if(pos >= 0 && pos <= list->len) {
        if(pos == 0) insert(list, obj);
        else if(pos == list->len) add(list, obj);
        else {
            Node* cell = constructNodeObj(obj);
            Node* curr = node(list, pos - 1);
            cell->next = curr->next;
            curr->next = cell;
            list->len++;
        }
    }
}

//=====INSERT=====//
void insert(LinkedList* const list, int obj) {
    Node* node = constructNodeObj(obj);
    node->next = list->first;

    if(list->len == 0) {
        list->first = node;
        list->last = node;
    } else list->first = node;

    list->len++;
}

//=====POP=====//
int pop(LinkedList* const list) {
    int i = 0;

    if(list->len != 0) {
        if(list->first == list->last) {
            free(list->first);
            list->first = list->last = NULL;
        } else {
            i = list->last->obj;
            list->last = node(list, list->len - 2);
            free(list->last->next);
            list->last->next = NULL;
            list->len--;
        }
    }

    return i;
}

int popp(LinkedList* const list, int pos) {
    int i = 0;

    if(list->len != 0 && pos >= 0 && pos <= list->len - 1) {
        if(pos == 0) i = del(list);
        else if(pos == list->len - 1) i = pop(list);
        else {
            Node* curr = node(list, pos - 1);
            Node* rem = curr->next;
            i = rem->obj;

            curr->next = rem->next;
            rem->next = NULL;
            free(rem);
            
            list->len--;
        }
    } 

    return i;
}

int popObj(LinkedList* const list, int obj) {
    int pos = search(list, obj);

    int i = 0;
    if(pos >= 0) i = popp(list, pos);
    return i;
}

//=====DEL=====//
int del(LinkedList* const list) {
    int i = 0;

    if(list->len != 0) {
        i = list->first->obj;

        if(list->first == list->last) {
            free(list->first);
            list->first = list->last = NULL;
        } else {
            Node* curr = list->first;
            list->first = curr->next;
            curr->next = NULL;
            free(curr);
        }
    }

    list->len--;
    return i;
}

//=====SEARCH=====//
int search(LinkedList* const list, int obj) {
    Node* curr = list->first;
    int i = 0;

    while(curr != NULL) {
        if(curr->obj == obj) return i;
        curr = curr->next;
        i++;
    }

    return -1;
}

//=====PRINT=====//
void print(LinkedList* list) {
    Node* curr = list->first;
    printf("[");
    while(curr != NULL) {
        printf("%i", curr->obj);
        if(curr->next != NULL) printf(", ");
        curr = curr->next;
    }
    printf("]\n");
}
