
#include "header/Matrix.h"

int main(int argc, char** args) {
    Matrix* mat1 = construct(3, 3);
    Matrix* mat2 = construct(3, 3);
    int k = 0;
    
    for(int i = 0; i < mat1->line; i++) {
        for(int j = 0; j < mat1->column; j++) {
            setObj(mat1, k, i, j);
            setObj(mat2, k++, i, j);
        }
    }
    
    printm(mat1);
    printf("\n\t+\n\n");
    printm(mat2);
    printf("\n\t+\n\n");
    
    Matrix* msum = sum(mat1, mat2);
    printm(msum);

    destruct(mat1);
    destruct(mat2);
    destruct(msum);
    return 0;
}
