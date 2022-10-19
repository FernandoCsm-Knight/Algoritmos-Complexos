
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
    Node* curr = list->first;
    Node* rem;
    for(int i = 0; i < list->len; i++) {
        rem = curr->next;
        free(curr);
        curr = rem;
    }
    free(list);
}

//=====SEARCH_NODE=====//
Node* node(LinkedList* const list, int idx) {
    Node* cell = NULL;

    if(idx >= 0 && idx < list->len) {
        if(idx < list->len / 2) {
            cell = list->first;
            for(int i = 0; i < idx; i++) cell = cell->next;
        } else {
            cell = list->last;
            for(int i = list->len - 1; i > idx; i--) cell = cell->prev;
        }
    }

    return cell;
}

int get(LinkedList* const list, int idx) {
    return node(list, idx)->obj;
}

//=====ADD=====//
void add(LinkedList* const list, int obj) {
    Node* cell = constructNodeObj(obj);

    if(list->len == 0) {
        list->first = cell;
        list->last = cell; 
    } else {
        cell->prev = list->last;
        list->last->next = cell;
        list->last = cell;
    }

    list->len++;
}

void addp(LinkedList* const list, int obj, int idx) {
    if(idx >= 0 && idx <= list->len) {
        if(idx == 0) insert(list, obj);
        else if(idx == list->len) add(list, obj);
        else {
            Node* cell = constructNodeObj(obj);
            Node* curr = node(list, idx);
            cell->next = curr;
            cell->prev = curr->prev;
            curr->prev = cell;
            cell->prev->next = cell;
            list->len++;
        }
    }
}

//=====INSERT=====//
void insert(LinkedList* const list, int obj) {
    Node* cell = constructNodeObj(obj);

    if(list->len == 0) {
        list->first = cell;
        list->last = cell;
    } else {
        cell->next = list->first;
        list->first->prev = cell;
        list->first = cell;
    }

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
            list->last = list->last->prev;
            free(list->last->next);
            list->last->next = NULL;
        }
    }

    list->len--;
    return i;
}

int popp(LinkedList* const list, int idx) {
    int i = 0;

    if(list->len != 0 && idx >= 0 && idx < list->len) {
        if(idx == 0) i = del(list);
        else if(idx == list->len - 1) i = pop(list);
        else {
            Node* curr = node(list, idx);
            i = curr->obj;
            curr->prev->next = curr->next;
            curr->next->prev = curr->prev;
            curr->next = NULL;
            curr->prev = NULL;
            free(curr);
            list->len--;
        }
    }

    return i;
}

int popObj(LinkedList* const list, int obj) {
    int idx = search(list, obj);

    if(idx >= 0) popp(list, idx); 
    return (idx >= 0) ? obj : idx; 
}

//=====DEL=====//
int del(LinkedList* const list) {
    int i = 0;
    
    if(list->len != 0) {
        if(list->first == list->last) {
            free(list->first);
            list->first = list->last = NULL;
        } else {
            list->first = list->first->next;
            list->first->prev->next = NULL;
            free(list->first->prev);
            list->first->prev = NULL;
        }
    }

    list->len--;
    return i;
}

//=====SEARCH=====//
int search(LinkedList* const list, int obj) {
    Node* curr = list->first;
    
    for(int i = 0; curr != NULL; i++) {
        if(curr->obj == obj) return i;
        curr = curr->next;
    }

    return -1;
}

//=====PRINT=====//
void print(LinkedList* const list) {
    Node* curr = list->first;
    printf("[");
    while(curr != NULL) {
        printf("%i", curr->obj);
        if(curr->next != NULL) printf(", ");
        curr = curr->next;
    }
    printf("]\n");
}
