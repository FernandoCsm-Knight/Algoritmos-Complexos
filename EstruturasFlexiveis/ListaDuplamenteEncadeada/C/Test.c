
#include "header/LinkedList.h"

int main(int argc, char** args) {
    LinkedList* list = construct();
    add(list, 1);
    add(list, 2);
    add(list, 3);
    add(list, 4);
    addp(list, 5, 2);
    addp(list, 6, 0);
    addp(list, 7, list->len);
    popObj(list, 2);
    print(list);
    printf("%i\n", list->len);
    destruct(list);
    return 0;
}
