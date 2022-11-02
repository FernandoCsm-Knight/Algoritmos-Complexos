
#include "header/BinaryTree.h"

int main(int argc, char** args) {
    BinaryTree* bst = construct();
    add(bst, 5);
    add(bst, 3);
    add(bst, 4);
    add(bst, 2);
    add(bst, 7);
    add(bst, 6);
    add(bst, 8);
    inOrder(bst);
    preOrder(bst);
    posOrder(bst);
    printf("Altura: %i\n", getHeight(bst));
    destructor(bst);
    return 0;
}
