
#include "header/LinkedList.h"

int main(int argc, char** args) {
    LinkedList* list = construct();
    add(list, 1);
    add(list, 2);
    add(list, 3);
    add(list, 4);
    add(list, 5);
    add(list, 6);
    popObj(list, 6);
    printf("%i\n", search(list, 6));
    print(list);
    destruct(list);
    return 0;
}
