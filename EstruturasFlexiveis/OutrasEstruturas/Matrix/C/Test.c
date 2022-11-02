
#include "header/Matrix.h"

int main(int argc, char** args) {
    Matrix* mat = construct(3, 3);
    int k = 0;
    
    for(int i = 0; i < mat->line; i++) {
        for(int j = 0; j < mat->column; j++) {
            setObj(mat, k++, i, j);
        }
    }
    
    printm(mat);
    destruct(mat);
    return 0;
}
