
#include "header/mystring.h"

//=====PROTOTYPES=====//
bool str_equals(const char* const s1, const char* const s2);
size_t str_length(const char* const s);
void str_copy(char** s, const char* const c);
char* str_trim(const char* const s);
void str_replace(char* const s, const char r, const char c);
void str_remove(char** s, const char c);
char* str_substr(const char* const s, int start, int end);
unsigned int str_count(const char* const s, const char c);

//=====CONSTRUCTOR=====//
String createStr(const char* const str) {
    String s;
    s.len = 0;
    s.buf = NULL;
    s.trim = trim;
    s.replace = replace;
    s.remove = remove;
    s.copy = copy;
    s.substr = substr;
    s.split = split; 
    s.equals = equals;
    s.contains = contains;
    s.compareTo = compareTo;
    s.length = length;
    s.this = &s;

    if(str != NULL) 
        s.copy(&s, str);

    return s;
}

//=====DESTRUCTOR=====//
void destruct(String s) {
    free(s.buf);
}

//=====STRING_MANIP=====//
void trim(String* const s) {
    char* aux = str_trim(s->buf);
    free(s->buf);
    s->buf = aux;
    s->len = str_length(s->buf);
}

void replace(String* const s, const char r, const char c) {
    str_replace(s->buf, r, c);
}

void remove(String* const s, const char c) {
    str_remove(&s->buf, c);
}

void copy(String* const s, const char* const str) {
    if(s->buf != NULL) free(s->buf);
    str_copy(&s->buf, str);
    s->len = str_length(s->buf);
}

String* split(const String s, const char c) {
    String* strs = (String*)calloc(str_count(s.buf, c) + 1, sizeof(String));

    int start = 0,
        end = 0;

    char* new_str;

    int j = 0;
    for(int i = 0; i < s.len; i++, end++) {
        if(s.buf[i] == c) {
            new_str = str_substr(s.buf, start, end);
            strs[j++] = createStr(new_str);
            start = end + 1;
            free(new_str);
        }
    }

    new_str = str_substr(s.buf, start, end);
    strs[j] = createStr(new_str);
    free(new_str);
    return strs;
}

String substr(const String s, int start, int end) {
    return createStr(str_substr(s.buf, start, end));
}

bool contains(const String s, const char* const str) {
    size_t strl = str_length(str);
    bool value = s.buf != NULL && s.len >= strl;

    if(value) {
        for(int i = 0, j = 0; i < s.len && j < strl && (s.len - i >= strl || j != 0); i++) {
            value = s.buf[i] == str[j];
            
            if(value) j++;
            else if(j != 0) {
                i -= j;
                j = 0;
            }
        }
    }

    return value;
}

bool equals(const String s1, const char* const s2) {
    int len = s1.length(s1);
    bool value = len == str_length(s2);
    for(int i = 0; value && i < len; i++) 
        value = s1.buf[i] == s2[i];
    return value;
}

int compareTo(const String s, const char* const str) {
    int strl = str_length(str),
        limit = (s.len < strl) ? s.len : strl;
    
    for(int i = 0; i < limit; i++)
        if(s.buf[i] != str[i]) 
            return s.buf[i] - str[i];

    return s.len - strl;
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

void str_copy(char** s, const char* const c) {
    size_t len = str_length(c);
    if(*s == NULL) 
        *s = (char*)calloc(len + 1, sizeof(char));

    int i = 0;
    while(i < len) {
        (*s)[i] = c[i];
        i++;
    }
    
    (*s)[i] = '\0';
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

void str_replace(char* const s, const char r, const char c) {
    int len = str_length(s);
    
    for(int i = 0; i < len; i++) 
        if(s[i] == r) s[i] = c;
}

void str_remove(char** s, const char c) {
    int len = str_length(*s),
        strl = len - str_count(*s, c);

    char* str = (char*)calloc(strl + 1, sizeof(char));

    int j = 0;
    for(int i = 0; i < len; i++) 
        if((*s)[i] != c) 
            str[j++] = (*s)[i];

    str[j] = '\0';

    free(*s);
    *s = str;
}

char* str_substr(const char* const s, int start, int end) {
    char* str = (char*)calloc(end - start + 1, sizeof(char));

    int j = 0;
    for(int i = start; i < end; i++, j++)
        str[j] = s[i];

    str[j] = '\0';
    return str;
}

unsigned int str_count(const char* const s, const char c) {
    unsigned int num = 0;
    int len = str_length(s); 

    if(s != NULL)
        for(int i = 0; i < len; i++)
            if(s[i] == c) num++;

    return num;
}
