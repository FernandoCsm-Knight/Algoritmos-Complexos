
#include "header/BinaryTree.h"

//=====CONSTRUCTOR=====//
BinaryTree* construct() {
    BinaryTree* bst = (BinaryTree*)malloc(sizeof(BinaryTree));
    clear(bst);
    return bst;
}

//=====INITIALIZER=====//
void clear(BinaryTree* const bst) {
    bst->root = NULL;
    bst->len = 0;
}

//=====DESTRUCTOR=====//
void destructor(BinaryTree* const bst) {
    void destructorr(Node* const node);
    destructorr(bst->root);
    free(bst);
}

void destructorr(Node* const node) {
    if(node != NULL) {
        destructorr(node->left);
        destructorr(node->right);
        free(node);
    }
}

//=====METODOS=====//
//-----ISEMPTY-----//
bool isEmpty(BinaryTree* const bst) {
    return bst->root == NULL;
}

//-----ADD-----//
void add(BinaryTree* const bst, int obj) {
    void addr(BinaryTree* const, Node* const, int);

    if(bst->root != NULL) addr(bst, bst->root, obj);
    else bst->root = constructNodeObj(obj);
    bst->len++;
}

void addr(BinaryTree* const bst, Node* const node, int obj) {
    if(obj < node->obj) {
        if(node->left == NULL) node->left = constructNodeObj(obj);
        else addr(bst, node->left, obj);
    } else if(obj > node->obj) {
        if(node->right == NULL) node->right = constructNodeObj(obj);
        else addr(bst, node->right, obj);
    } else {
        printf("Insertion Error\n");
        bst->len--;
    }
}

//-----GETHEIGHT-----//
int getHeight(BinaryTree* const bst) {
    int getHeightr(Node* const, int);
    return getHeightr(bst->root, 0);
}

int getHeightr(Node* const node, int h) {
    if(node != NULL) {
        int left = getHeightr(node->left, h + 1);
        int right = getHeightr(node->right, h + 1);
        h = (left > right) ? left : right;
    }

    return h;
}

//-----INORDER-----//
void inOrder(BinaryTree* const bst) {
    int inOrderr(Node* const, int);
    printf("[");
    inOrderr(bst->root, bst->len);
    printf("]\n");
}

int inOrderr(Node* const node, int i) {
    if(node != NULL) {
        i = inOrderr(node->left, i);
        i--;
        printf("%i", node->obj);
        if(i != 0) printf(", ");
        i = inOrderr(node->right, i);
    }
    return i;
}

//-----PREORDER-----//
void preOrder(BinaryTree* const bst) {
    int preOrderr(Node* const, int);
    printf("[");
    preOrderr(bst->root, bst->len);
    printf("]\n");
}

int preOrderr(Node* const node, int i) {
    if(node != NULL) {
        i--;
        printf("%i", node->obj);
        if(i != 0) printf(", ");
        i = preOrderr(node->left, i);
        i = preOrderr(node->right, i);
    }
    return i;
}

//-----POSORDER-----//
void posOrder(BinaryTree* const bst) {
    int posOrderr(Node* const, int);
    printf("[");
    posOrderr(bst->root, bst->len);
    printf("]\n");
}

int posOrderr(Node* const node, int i) {
    if(node != NULL) {
        i = posOrderr(node->left, i);
        i = posOrderr(node->right, i);
        i--;
        printf("%i", node->obj);
        if(i != 0) printf(", ");
    }
    return i;
}

//-----SEARCH-----//
bool search(BinaryTree* const bst, int obj) {
    Node* searchr(Node* node, int obj);
    return searchr(bst->root, obj) == obj;
}

Node* searchr(Node* node, int obj) {
    if(node != NULL && node->obj != obj) {
        if(obj < node->obj) node = searchr(node->left, obj);
        else node = searchr(node->right, obj);
    }

    return node;
}

//-----MIN-----//
int min(BinaryTree* const bst) {
    int minr(Node* const);
    return (bst->root != NULL) ? minr(bst->root) : 0;
}

int minr(Node* const node) {
    int obj = 0;
    if(node->left != NULL) obj = minr(node->left);
    else obj = node->obj;
    return obj;
}

//-----MAX-----//
int max(BinaryTree* const bst) {
    int maxr(Node* const);
    return (bst->root != NULL) ? maxr(bst->root) : 0;
}

int maxr(Node* const node) {
    int obj = 0;
    if(node->left != NULL) obj = maxr(node->right);
    else obj = node->obj;
    return obj;
}
