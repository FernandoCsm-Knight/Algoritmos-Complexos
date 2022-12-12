
#include "header/Stack.h"

int main(int argc, char** args) {
    Stack* stack = construct();
    push(stack, 1);
    push(stack, 2);
    push(stack, 3);
    push(stack, 4);
    push(stack, 5);
    pop(stack);
    prints(stack);
    invert(stack);
    prints(stack);
    destruct(stack);
    return 0;
}
