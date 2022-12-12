
#ifndef MATRIX
#define MATRIX

//=====INCLUDES=====//
#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include "Node.h"

//=====STRUCT=====//
typedef struct matrix {
    Node* start;
    int line;
    int column;
} Matrix;

//=====PROTOTYPES=====//
Matrix* construct(int lin, int col);
void destruct(Matrix* const mat);

int get(Matrix* const mat, int i, int j);
void setObj(Matrix* const mat, int obj, int lin, int col);

Matrix* sum(Matrix* const mat1, Matrix* const mat2);

void printm(Matrix* const mat);

#endif
