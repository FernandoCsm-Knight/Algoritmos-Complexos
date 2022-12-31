
#ifndef MY_STRING
#define MY_STRING

//=====INCLUDE=====//
#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

typedef struct string {
    struct string* this;
    char* buf;
    size_t len;

    //=====VOID=====//
    void (*trim)(struct string* const);
    void (*replace)(struct string* const, const char, const char);
    void (*remove)(struct string* const, const char);
    void (*copy)(struct string* const, const char* const);
    
    //=====STRING=====//
    struct string (*substr)(const struct string, int, int);

    //=====STRING*=====//
    struct string* (*split)(const struct string, const char);

    //=====BOOL=====//
    bool (*equals)(const struct string, const char* const);
    bool (*contains)(const struct string, const char* const);

    //=====INT=====//
    int (*compareTo)(const struct string, const char* const);

    //=====SIZE_T=====//
    size_t (*length)(const struct string);
} String;

//=====CONSTRUCTOR=====//
String createStr(const char* const str);

//=====DESTRUCTOR=====//
void destruct(String s);

//=====STRING_MANIP=====//
void trim(String* const s);
void replace(String* const s, const char r, const char c);
void remove(String* const s, const char c);
void copy(String* const s, const char* const str);

String substr(const String s, int start, int end);

String* split(const String s, const char c);

bool equals(const String s1, const char* const s2);
bool contains(const String s, const char* const str);

int compareTo(const String s, const char* const str);

size_t length(const String s);

#endif
