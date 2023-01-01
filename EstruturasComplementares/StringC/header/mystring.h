
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
    void (*copy)(struct string* const, const struct string);
    void (*lcopy)(struct string* const, const char* const);
    void (*upper)(struct string* const);
    void (*lower)(struct string* const);
    void (*title)(struct string* const);
    void (*captalize)(struct string* const);
    void (*clear)(struct string* const);
    
    //=====STRING=====//
    struct string (*substr)(const struct string, int, int);
    struct string (*clone)(const struct string);

    //=====STRING*=====//
    struct string* (*split)(const struct string, const char);

    //=====BOOL=====//
    bool (*isEmpty)(const struct string);
    bool (*equals)(const struct string, const struct string);
    bool (*lequals)(const struct string, const char* const);
    bool (*contains)(const struct string, const struct string);
    bool (*lcontains)(const struct string, const char* const);
    bool (*startsWith)(const struct string, const struct string);
    bool (*lstartsWith)(const struct string, const char* const);
    bool (*endsWith)(const struct string, const struct string);
    bool (*lendsWith)(const struct string, const char* const);

    //=====INT=====//
    int (*compareTo)(const struct string, const struct string);
    int (*lcompareTo)(const struct string, const char* const);
    int (*parseInt)(const struct string);

    //=====DOUBLE=====//
    double (*parseFloat)(const struct string);

    //=====SIZE_T=====//
    size_t (*length)(const struct string);
} String;

//=====CONSTRUCTOR=====//
String createStr(const char* const str);

//=====DESTRUCTOR=====//
void destruct(String s);

//=====CHAR*_MANIP=====//
//=====VOID=====//
void str_copy(char** s, const char* const c);
void str_replace(char* const s, const char r, const char c);
void str_cut(char** s, const char c);
void str_upper(char* const s);
void str_lower(char* const s);
void str_title(char* const s);
void str_captalize(char* const s);

//=====CHAR*=====//
char* str_trim(const char* const s);
char* str_substr(const char* const s, int start, int end);

//=====INT=====//
int str_compareTo(const char* const s, const char* const str);

//=====UNS_INT=====//
unsigned int str_count(const char* const s, const char c);

//=====BOOL=====//
bool str_equals(const char* const s1, const char* const s2);
bool str_contains(const char* const s, const char* const str);
bool str_startsWith(const char* const s, const char* const str);
bool str_endsWith(const char* const s, const char* const str);

//=====SIZE_T=====//
size_t str_length(const char* const s);

#endif
