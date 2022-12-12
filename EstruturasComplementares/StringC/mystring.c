
#include "header/mystring.h"

String createStr(char* str) {
    String s;
    if(str != NULL) {
        if(str_length(str) != 0) {
            s.buf = (char*)calloc(str_length(str) + 1, sizeof(char));
            str_copy(s.buf, str);
        } else {
            s.buf = (char*)calloc(5, sizeof(char));
            str_copy(s.buf, "null");
        }
    }

    s.trim = trim;
    s.equals = equals;
    s.length = length;
    return s;
}

//=====STRING_MANIP=====//
void replace(String* const s, char a, char b) {
    
}

void trim(String* const s) {
    char* aux = str_trim(s->buf);
    free(s->buf);
    s->buf = aux;
}

bool equals(const String s1, const char* const s2) {
    int len = s1.length(s1);
    bool value = len == str_length(s2);
    for(int i = 0; value && i < len; i++) 
        value = s1.buf[i] == s2[i];
    return value;
}

size_t length(const String s) {
    return str_length(s.buf);
}

//=====CHAR*_MANIP=====//
bool str_equals(const char* const s1, const char* const s2) {
    int len = str_length(s1);
    bool value = len == str_length(s2);
    for(int i = 0; value && i < len; i++) 
        value = s1[i] == s2[i];
    return value;
}

size_t str_length(const char* const s) {
    size_t len = 0;
    if(s != NULL)
        while(s[len] != '\0') len++;
    return len;
}

void str_copy(char* const s, const char* const c) {
    int len = str_length(c);

    int i = 0;
    while(i < len) 
        s[i] = c[i++];
    
    s[i] = '\0';
}

char* str_trim(const char* const s) {
    size_t i = 0, j = str_length(s) - 1;
    while(s[i] == ' ' || s[j] == ' ') {
        if(s[i] == ' ') i++;
        else j--;
    }

    size_t len = j - i + 2;
    char* str = (char*)calloc(len, sizeof(char));

    int k = 0;
    for(k = 0; i <= j; k++, i++) str[k] = s[i]; 
    str[k] = '\0';

    return str;
}

char* str_replace(char* const s, char a, char b) {
    int len = str_length(s);
    
}
