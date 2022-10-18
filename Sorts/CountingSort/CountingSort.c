
//=====INCLUDE=====//
#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include "../Utils/Generator.h"

//=====DEFINE=====//
#define LEN 100

//=====PROTOTYPES=====//
void countingSort(int arr[], int first, int last);
int maxim(int arr[], int first, int last);

//=====MAIN=====//
int main(char argc, char *args) {
    int arr[LEN];
    for(int i = 0; i < 100; i++) {
        generatei(arr, LEN, 10000);
        countingSort(arr, 0, LEN);
        printf("%i\n", verifyi(arr, LEN));
    }
    return 0;
}

//=====METODOS=====//
void countingSort(int arr[], int first, int last) {
    int len = maxim(arr, first, last) + 1;
    int* aux = (int*)calloc(len, sizeof(int));
    int* out = (int*)calloc(last, sizeof(int));

    for(int i = first; i < last; i++) aux[arr[i]]++;

    for(int i = 0; i < len - 1; i++) aux[i + 1] += aux[i];

    for(int i = last - 1; i >= first; i--) {
        out[aux[arr[i]] - 1] = arr[i];
        aux[arr[i]]--;
    }

    for(int i = first; i < last; i++) arr[i] = out[i];
    free(out);
    free(aux); 
}

int maxim(int arr[], int first, int last) {
    int i = arr[first];
    for(int j = first + 1; j < last; j++)
        if(arr[j] > i) i = arr[j];
    return i;
}
