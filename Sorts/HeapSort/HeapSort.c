
//=====INCLUDE=====//
#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include "../Utils/Generator.h"

//=====DEFINE=====//
#define LEN 100

//=====PROTOTYPES=====//
void heapSorti(int arr[], int first, int last);
void heapifyi(int arr[], int first, int last);

void heapSortd(double arr[], int first, int last);
void heapifyd(double arr[], int first, int last);

void swapi(int arr[], int a, int b);
void swapd(double arr[], int a, int b);

//=====MAIN=====//
int main(char argc, char *args) {
    double arr[LEN];
    for(int i = 0; i < 100; i++) {
        generated(arr, LEN, 10000);
        heapSortd(arr, 0, LEN);
        printf("%i\n", verifyd(arr, LEN));
    }
    return 0;
}

//=====METODOS=====//
void heapSorti(int arr[], int first, int last) {
    for(int i = (last + 1) / 2; i >= first; i--)
        heapifyi(arr, i, last - 1);

    for(int i = last - 1; i >= first; i--) {
        swapi(arr, first, i);
        heapifyi(arr, first, i - 1);
    }
}

void heapifyi(int arr[], int first, int last) {
    int aux = arr[first],
        son = first * 2 + 1;

    while(son <= last) {
        if(son < last && arr[son] < arr[son + 1]) son++;

        if(arr[son] > aux) {
            arr[first] = arr[son];
            first = son;
            son = first * 2 + 1;
        } else son = last + 1;
    }

    arr[first] = aux;
}

void heapSortd(double arr[], int first, int last) {
    for(int i = (last - 1) / 2; i >= first; i--)
        heapifyd(arr, i, last - 1);

    for(int i = last - 1; i >= first; i--) {
        swapd(arr, first, i);
        heapifyd(arr, first, i - 1);
    }
}

void heapifyd(double arr[], int first, int last) {
    double aux = arr[first];
    int son = first * 2 + 1;

    while(son <= last) {
        if(son < last && arr[son] < arr[son + 1]) son++;

        if(arr[son] > aux) {
            arr[first] = arr[son];
            first = son;
            son = first * 2 + 1;
        } else son = last + 1;
    }

    arr[first] = aux;
}

void swapi(int arr[], int a, int b) {
    int aux = arr[a];
    arr[a] = arr[b];
    arr[b] = aux;
}

void swapd(double arr[], int a, int b) {
    double aux = arr[a];
    arr[a] = arr[b];
    arr[b] = aux;
}
