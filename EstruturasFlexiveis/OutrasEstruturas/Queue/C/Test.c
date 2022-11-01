
#include "header/Queue.h"

int main(int argc, char** args) {   
    Queue* queue = construct();
    enqueue(queue, 1);
    enqueue(queue, 2);
    enqueue(queue, 3);
    enqueue(queue, 4);
    dequeue(queue);
    printq(queue);
    invert(queue);
    printq(queue);
    printf("%i\n", queue->len);
    destruct(queue);
    return 0;
}
