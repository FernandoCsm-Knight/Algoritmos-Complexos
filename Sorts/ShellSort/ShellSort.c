
//=====INCLUDE=====//
#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include "../Utils/Generator.h"

//=====DEFINE=====//
#define LEN 100

//=====PROTOTYPES=====//
void shellSorti(int arr[], int last);
void shellSortd(double arr[], int last);

//=====MAIN=====//
int main(char argc, char *args) {
    int arr[LEN];
    for(int i = 0; i < 100; i++) {
        generatei(arr, LEN, 10000);
        shellSorti(arr, LEN);
        printf("%i\n", verifyi(arr, LEN));
    }
    return 0;
}

//=====METODOS=====//
void shellSorti(int arr[], int last) {
    int h = 1;
    while(h < last / 3) 
        h = 3 * h + 1;

    while(h > 0) {
        for(int i = h; i < last; i++) {
            int aux = arr[i];
            int j = i;
            while(j >= h && aux < arr[j - h]) {
                arr[j] = arr[j - h];
                j -= h;
            }
            arr[j] = aux;
        }
        h = (h - 1) / 3;
    }
}

void shellSortd(double arr[], int last) {
    int h = 1;
    while(h < last / 3) 
        h = 3 * h + 1;
    
    while(h > 0) {
        for(int i = h; i < last; i++) {
            double aux = arr[i];
            int j = i;
            while(j >= h && aux < arr[j - h]) {
                arr[j] = arr[j - h];
                j -= h;
            } 
            arr[j] = aux;
        }
        h = (h - 1) / 3;
    }
}
