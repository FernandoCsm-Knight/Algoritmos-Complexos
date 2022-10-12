
//=====INCLUDE=====//
#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include "../Utils/Generator.h"

//=====DEFINE=====//
#define LEN 100

//=====PROTOTYPES=====//
void selectionSorti(int arr[], int first, int last);
void swapi(int arr[], int a, int b);

void selectionSortd(double arr[], int first, int last);
void swapd(double arr[], int a, int b);

//=====MAIN=====//
int main(char argc, char *args) {
    double arr[LEN];
    for(int i = 0; i < 100; i++) {
        generated(arr, LEN, 10000);
        selectionSortd(arr, 0, LEN);
        printf("%i\n", verifyd(arr, LEN));
    }
    return 0;
}

//=====METODOS=====//
void selectionSorti(int arr[], int first, int last) {
    int min;
    for(int i = first; i < last - 1; i++) {
        min = i;
        for(int j = i + 1; j < last; j++) 
            if(arr[j] < arr[min]) min = j;
        swapi(arr, i, min);
    }
}

void swapi(int arr[], int a, int b) {
    int aux = arr[a];
    arr[a] = arr[b];
    arr[b] = aux;
}

void selectionSortd(double arr[], int first, int last) {
    int min;
    for(int i = first; i < last - 1; i++) {
        min = i;
        for(int j = i + 1; j < last; j++) 
            if(arr[j] < arr[min]) min = j;
        swapd(arr, i, min);
    }
}

void swapd(double arr[], int a, int b) {
    double aux = arr[a];
    arr[a] = arr[b];
    arr[b] = aux;
}
