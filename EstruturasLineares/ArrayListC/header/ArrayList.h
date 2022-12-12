#ifndef ARRAY_LIST_C
#define ARRAY_LIST_C
//=====INCLUDE=====//
#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

//=====DEFINE=====//
#define DOWNGRADE 4

//=====STRUCTS=====//
typedef struct {
    char** strs;
    int len, 
        cap;
} Strings;

//=====PROTOTYPES=====//
//-----PRINCIPAL-----//
void alocateStrs(Strings* const arr, int i);
void freeStrs(Strings* arr);
bool isEmpty(Strings* const arr);
bool isFull(Strings* const arr);

void grow(Strings* arr);
void shrink(Strings* arr);

void add(Strings* const arr, char* const s);
void addp(Strings* const arr, int p, char* const s);
void insert(Strings* const arr, char* const s);

char* pop(Strings* const arr);
char* popp(Strings* const arr, int p);
char* popObj(Strings* const arr, char* s);
char* removee(Strings* const arr);

int search(Strings* const arr, char* const s);
bool contains(Strings* const arr, char* const s);

void quickSort(Strings* const arr, int first, int last);
int partition(Strings* const arr, int first, int last);
void swap(Strings* const arr, int a, int b);

void printStrs(Strings* arr);

//-----SECUNDARY-----//
bool isNumber(char c);
bool isFloat(char* const s);
int parseInt(char* const s);
size_t length(const char* const s);
double expfloat(double b, int e);
int expinteger(int b, int e);
bool equals(const char* const s1, const char* const s2);
int compareTo(char* const s1, char* const s2);

#endif
