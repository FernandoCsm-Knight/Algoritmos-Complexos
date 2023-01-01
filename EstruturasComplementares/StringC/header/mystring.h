
#ifndef MY_STRING
#define MY_STRING

//=====INCLUDE=====//
#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

//=====STRUCT=====//
typedef struct string {
    char* buf;
    size_t len;

    //=====VOID=====//
    void (*trim)(struct string* const);
    void (*replace)(struct string* const, const char, const char);
    void (*cut)(struct string* const, const char);
    void (*copy)(struct string* const, const char* const);
    void (*upper)(struct string* const);
    void (*lower)(struct string* const);
    void (*title)(struct string* const);
    void (*captalize)(struct string* const);
    
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

//=====CHAR*_MANIP=====//
void str_copy(char** s, const char* const c);
void str_replace(char* const s, const char r, const char c);
void str_cut(char** s, const char c);
void str_upper(char* const s);
void str_lower(char* const s);
void str_title(char* const s);
void str_captalize(char* const s);

char* str_trim(const char* const s);
char* str_substr(const char* const s, int start, int end);

unsigned int str_count(const char* const s, const char c);

bool str_equals(const char* const s1, const char* const s2);

size_t str_length(const char* const s);

#endif
