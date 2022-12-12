
#ifndef MY_STRING
#define MY_STRING

//=====INCLUDE=====//
#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

typedef struct string {
    char* buf;
    int len; 

    void (*replace)(char* const, char, char);
    void (*trim)(struct string* const);
    size_t (*length)(const struct string);
    bool (*equals)(const struct string, const char* const);
} String;

//=====CONSTRUCTOR=====//
String createStr(char* str);

//=====STRING_MANIP=====//
void trim(String* const s);

bool equals(const String s1, const char* const s2);
size_t length(const String s);

//=====CHAR*_MANIP=====//
bool str_equals(const char* const s1, const char* const s2);
size_t str_length(const char* const s);
void str_copy(char* const s, const char* const c);
char* str_trim(const char* const s);

#endif
