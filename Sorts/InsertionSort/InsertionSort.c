
//=====INCLUDE=====//
#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include "../Utils/Generator.h"

//=====DEFINE=====//
#define LEN 100

//=====PROTOTYPES=====//
void insertionSorti(int arr[], int first, int last);
void insertionSortd(double arr[], int first, int last);

//=====MAIN=====//
int main(char argc, char *args) {
    double arr[LEN];
    for(int i = 0; i < 100; i++) {
        generated(arr, LEN, 10000);
        insertionSortd(arr, 0, LEN);
        printf("%i\n", verifyd(arr, LEN));
    }
    return 0;
}

//=====METODOS=====//
void insertionSorti(int arr[], int first, int last) {
    for(int i = first + 1; i < last; i++) {
        int aux = arr[i],
            j = i;
        while(j > first && arr[j - 1] > aux) {
            arr[j] = arr[j - 1];
            j--;
        }
        arr[j] = aux;
    }
}

void insertionSortd(double arr[], int first, int last) {
    for(int i = first + 1; i < last; i++) {
        double aux = arr[i];
        int j = i;
        while(j > first && arr[j - 1] > aux) {
            arr[j] = arr[j - 1];
            j--;
        }
        arr[j] = aux;
    }
}
