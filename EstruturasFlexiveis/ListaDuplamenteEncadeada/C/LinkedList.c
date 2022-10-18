
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
    for(int i = list->len - 1; i >= 0; i++) 
        free(node(list, i));
    free(list);
}

//=====SEARCH=====//
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