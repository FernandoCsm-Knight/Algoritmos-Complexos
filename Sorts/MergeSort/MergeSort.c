
//=====INCLUDE=====//
#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include "../Utils/Generator.h"

//=====DEFINE=====//
#define LEN 100

//=====PROTOTYPES=====//
void mergeSorti(int arr[], int first, int last);
void mergeSortiRec(int aux[], int arr[], int first, int last);
void mergei(int aux[], int arr[], int first, int center, int last);

void mergeSortd(double arr[], int first, int last);
void mergeSortdRec(double aux[], double arr[], int first, int last);
void merged(double aux[], double arr[], int first, int center, int last);

//=====MAIN=====//
int main(char argc, char *args) {
    double arr[LEN];
    for(int i = 0; i < 100; i++) {
        generated(arr, LEN, 10000);
        mergeSortd(arr, 0, LEN);
        printf("%i\n", verifyd(arr, LEN));
    }
    return 0;
}

//=====METODOS=====//
void mergeSorti(int arr[], int first, int last) {
    int* aux = (int*)calloc(last, sizeof(int));
    mergeSortiRec(aux, arr, first, last - 1);
    free(aux);
}

void mergeSortiRec(int aux[], int arr[], int first, int last) {
    if(first < last) {
        int center = (first + last) / 2;

        mergeSortiRec(aux, arr, center + 1, last);
        mergeSortiRec(aux, arr, first, center);
        mergei(aux, arr, first, center, last);
    }
}

void mergei(int aux[], int arr[], int first, int center, int last) {
    for(int i = first; i <= last; i++) aux[i] = arr[i];

    int i = first,
        j = center + 1;

    for(int k = first; k <= last; k++) {
        if(i > center) arr[k] = aux[j++];
        else if(j > last) arr[k] = aux[i++];
        else if(aux[i] < aux[j]) arr[k] = aux[i++];
        else arr[k] = aux[j++];
    }
}

void mergeSortd(double arr[], int first, int last) {
    double* aux = (double*)calloc(last, sizeof(double));
    mergeSortdRec(aux, arr, first, last - 1);
    free(aux);
}

void mergeSortdRec(double aux[], double arr[], int first, int last) {
    if(first < last) {
        int center = (first + last) / 2;

        mergeSortdRec(aux, arr, center + 1, last);
        mergeSortdRec(aux, arr, first, center);
        merged(aux, arr, first, center, last);
    }
}

void merged(double aux[], double arr[], int first, int center, int last) {
    for(int i = first; i <= last; i++) aux[i] = arr[i];

    int i = first,
        j = center + 1;

    for(int k = first; k <= last; k++) {
        if(i > center) arr[k] = aux[j++];
        else if(j > last) arr[k] = aux[i++];
        else if(aux[i] < aux[j]) arr[k] = aux[i++];  
        else arr[k] = aux[j++];
    }
}
