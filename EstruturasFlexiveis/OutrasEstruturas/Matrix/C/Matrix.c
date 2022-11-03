
#include "header/Matrix.h"

//=====CONSTRUCTOR=====//
Matrix* construct(int lin, int col) {
    Node* getNode(Matrix* const, int, int);
    Matrix* mat = (Matrix*)malloc(sizeof(Matrix));
    mat->start = constructNode();
    mat->line = lin;
    mat->column = col;

    Node* node = mat->start;
    for(int i = 0; i < lin; i++) {

        if(i != 0) {
            node = constructNode();
            node->top = getNode(mat, i - 1, 0);
            node->top->bottom = node;
        }

        for(int j = 1; j < col; j++) {
            node->right = constructNode();
            node->right->left = node;
            node = node->right;

            if(i != 0) {
                node->top = node->left->top->right;
                node->top->bottom = node;
            }
        }
    }

    return mat;
}

//=====DESTRUCTOR=====//
void destruct(Matrix* const mat) {
    Node* getNode(Matrix* const, int, int);
    Node* node = NULL;
    Node* next = NULL;

    for(int i = mat->line - 1; i >= 0; i--) {    
        node = getNode(mat, i, mat->column - 1);

        for(int j = 0; j < mat->column; j++) {
            next = node->left;
            free(node);
            node = next;
        }
    }

    free(mat);
}

//=====METODOS=====//
//-----GETNODE-----//
Node* getNode(Matrix* const mat, int lin, int col) {
    Node* node = mat->start;

    for(int i = 0; i < lin; i++) node = node->bottom;
    for(int i = 0; i < col; i++) node = node->right;
    return node;
}

//-----GET-----//
int get(Matrix* const mat, int i, int j) {
    Node* getNode(Matrix* const, int, int);
    return getNode(mat, i, j)->obj;
}

//-----SET-----//
void setObj(Matrix* const mat, int obj, int lin, int col) {
    Node* getNode(Matrix* const, int, int);
    getNode(mat, lin, col)->obj = obj;
}

//-----SUM-----//
Matrix* sum(Matrix* const mat1, Matrix* const mat2) {
    Matrix* m = NULL; 
    
    if(mat1 != NULL && mat2 != NULL && mat1->line == mat2->line && mat1->column == mat2->column) {
        m = construct(mat1->line, mat1->column);
        for(int i = 0; i < mat1->line; i++) 
            for(int j = 0; j < mat1->column; j++) 
                setObj(m, get(mat1, i, j) + get(mat2, i, j), i, j);
    }

    return m;
}

//=====PRINT=====//
void printm(Matrix* const mat) {
    Node* getNode(Matrix* const, int, int);
    Node* node = NULL;

    for(int i = 0; i < mat->line; i++) {
        printf("[");
        node = getNode(mat, i, 0);
        for(int j = 0; j < mat->column; j++) {
            printf("%i", node->obj);
            if(j != mat->column - 1) printf(", ");
            node = node->right;
        }
        printf("]\n");
    }
}
