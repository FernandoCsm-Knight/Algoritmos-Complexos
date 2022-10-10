
//=====INCLUDE=====//
#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include "../Utils/Generator.h"

//=====DEFINE=====//
#define LEN 100

//=====PROTOTYPES=====//
void quickSorti(int arr[], int first, int last);
int partitioni(int arr[], int first, int last);
void swapi(int arr[], int a, int b);

void quickSortd(double arr[], int first, int last);
int partitiond(double arr[], int first, int last);
void swapd(double arr[], int a, int b);

//=====MAIN=====//
int main(char argc, char *args) {
    double arr[LEN];
    for(int i = 0; i < 100; i++) {
        generated(arr, LEN, 10000);
        quickSortd(arr, 0, LEN - 1);
        printf("%i\n", verifyd(arr, LEN));
    }
    return 0;
}

//=====METODOS=====//
void quickSorti(int arr[], int first, int last) {
    if(first < last) {
        int p = partitioni(arr, first, last);

        quickSorti(arr, p, last);
        quickSorti(arr, first, p - 1);
    }  
}

int partitioni(int arr[], int first, int last) {
    int p = arr[(first + last) / 2];

    int i = first,
        j = last;

    while(i <= j) {
        while(arr[i] < p) i++;
        while(arr[j] > p) j--;
        if(i <= j) {
            swapi(arr, i, j);
            i++;
            j--;
        }
    }

    return i;
}

void swapi(int arr[], int a, int b) {
    int aux = arr[a];
    arr[a] = arr[b];
    arr[b] = aux;
}

void quickSortd(double arr[], int first, int last) {
    if(first < last) {
        int p = partitiond(arr, first, last);
        
        quickSortd(arr, p, last);
        quickSortd(arr, first, p - 1);
    }
}

int partitiond(double arr[], int first, int last) {
    double p = arr[(first + last) / 2];
    
    int i = first,
        j = last;

    while(i <= j) {
        while(arr[i] < p) i++;
        while(arr[j] > p) j--;
        if(i <= j) {
            swapd(arr, i, j);
            i++;
            j--;
        }
    }

    return i;
}

void swapd(double arr[], int a, int b) {
    double aux = arr[a];
    arr[a] = arr[b];
    arr[b] = aux;    
}
