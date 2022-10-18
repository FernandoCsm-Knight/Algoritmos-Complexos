
//=====INCLUDES=====//
#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include "../Utils/Generator.h"

//=====DEFINE=====//
#define LEN 100

//=====PROTOTYPES=====//
void bubbleSorti(int arr[], int first, int last);
void swapi(int arr[], int a, int b);

void bubbleSortd(double arr[], int first, int last);
void swapd(double arr[], int a, int b);

//=====MAIN=====//
int main(char argc, char *args) {
    double arr[LEN];
    for(int i = 0; i < 100; i++) {
        generated(arr, LEN, 10000);
        bubbleSortd(arr, 0, LEN);
        printf("%i\n", verifyd(arr, LEN));
    }

    return 0;
}

//=====METODOS=====//
void bubbleSorti(int arr[], int first, int last) {
    for(int i = first; i < last - 1; i++) for(int j = first; j < last - i - 1; j++) if(arr[j] > arr[j + 1]) swapi(arr, j, j + 1);
}

void swapi(int arr[], int a, int b) {
    int aux = arr[a];
    arr[a] = arr[b];
    arr[b] = aux;
}

void bubbleSortd(double arr[], int first, int last) {
    for(int i = first; i < last - 1; i++) for(int j = first; j < last - i - 1; j++) if(arr[j] > arr[j + 1]) swapd(arr, j, j + 1);
}

void swapd(double arr[], int a, int b) {
    double aux = arr[a];
    arr[a] = arr[b];
    arr[b] = aux;
} 
