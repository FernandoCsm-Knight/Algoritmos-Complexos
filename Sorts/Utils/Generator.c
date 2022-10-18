
//=====INCLUDES=====//
#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <time.h>

//=====GENERATE=====//
void generatei(int arr[], int len, int range) {
    srand(time(NULL));
    for(int i = 0; i < len; i++)
        arr[i] = rand() % range;
}

void generated(double arr[], int len, int range) {
    srand(time(NULL));
    for(int i = 0; i < len; i++)
        arr[i] = ((double)rand()/(double)RAND_MAX) * range;
}

//=====VERIFY=====//
bool verifyi(int arr[], int len) {
    bool value = true;
    for(int i = 0; value && i < len - 1; i++) 
        value = arr[i] <= arr[i + 1];

    return value;
}

bool verifyd(double arr[], int len) {
    bool value = true;
    for(int i = 0; value && i < len - 1; i++) 
        value = arr[i] <= arr[i + 1];

    return value;
}

//=====PRINT=====//
void printArri(int arr[], int len) {
    printf("[");
    for(int i = 0; i < len; i++) {
        printf("%i", arr[i]);
        if(i != len - 1) printf(", ");
    } 
    printf("]\n");
}

void printArrd(double arr[], int len) {
    printf("[");
    for(int i = 0; i < len; i++) {
        printf("%lf", arr[i]);
        if(i != len - 1) printf(", ");
    } 
    printf("]\n");
}
