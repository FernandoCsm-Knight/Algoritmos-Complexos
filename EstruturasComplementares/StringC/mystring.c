
#include "header/mystring.h"

//=====STRING_MANIP=====//
void trim(String* const s);
void replace(String* const s, const char r, const char c);
void cut(String* const s, const char c);
void copy(String* const s, const char* const str);
void upper(String* const s);
void lower(String* const s);
void title(String* const s);
void captalize(String* const s);

String substr(const String s, int start, int end);

String* split(const String s, const char c);

bool isEmpty(const String s);
bool equals(const String s1, const char* const s2);
bool contains(const String s, const char* const str);

int compareTo(const String s, const char* const str);

size_t length(const String s);

//=====CONSTRUCTOR=====//
String createStr(const char* const str) {
    String s;

    s.len = 0;
    s.buf = NULL;
    s.trim = trim;
    s.replace = replace;
    s.cut = cut;
    s.copy = copy;
    s.upper = upper;
    s.lower = lower;
    s.title = title;
    s.captalize = captalize;
    s.substr = substr;
    s.split = split;
    s.equals = equals;
    s.contains = contains;
    s.compareTo = compareTo;
    s.length = length;

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

void cut(String* const s, const char c) {
    str_cut(&s->buf, c);
    s->len = str_length(s->buf);
}

void copy(String* const s, const char* const str) {
    str_copy(&s->buf, str);
    s->len = str_length(s->buf);
}

void upper(String* const s) {
    str_upper(s->buf);
}

void lower(String* const s) {
    str_lower(s->buf);
}

void title(String* const s) {
    str_title(s->buf);
}

void captalize(String* const s) {
    str_captalize(s->buf);
}

String substr(const String s, int start, int end) {
    char* aux = str_substr(s.buf, start, end);
    String str = createStr(aux);
    free(aux);
    return str;
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

bool isEmpty(const String s) {
    return s.buf == NULL || s.len == 0;
}

bool equals(const String s1, const char* const s2) {
    size_t len = s1.length(s1);
    bool value = len == str_length(s2);
    for(int i = 0; value && i < len; i++) 
        value = s1.buf[i] == s2[i];
    return value;
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
void str_copy(char** s, const char* const c) {
    if(*s != NULL) free(*s);

    size_t len = str_length(c);
    *s = (char*)calloc(len + 1, sizeof(char));

    int i = 0;
    while(i < len) {
        (*s)[i] = c[i];
        i++;
    }
    
    (*s)[i] = '\0';
}

void str_replace(char* const s, const char r, const char c) {
    size_t len = str_length(s);
    
    for(int i = 0; i < len; i++) 
        if(s[i] == r) s[i] = c;
}

void str_cut(char** s, const char c) {
    size_t len = str_length(*s),
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

void str_upper(char* const s) {
    size_t len = str_length(s);

    for(int i = 0; i < len; i++) 
        if(s[i] >= 97 && s[i] <= 122) 
            s[i] -= 32; 
}

void str_lower(char* const s) {
    size_t len = str_length(s);

    for(int i = 0; i < len; i++) 
        if(s[i] >= 65 && s[i] <= 90) 
            s[i] += 32; 
}

void str_title(char* const s) {
    str_captalize(s);
    size_t len = str_length(s);

    for(int i = 0; i < len; i++)
        if(s[i] == ' ' && i < len - 1 && s[i + 1] >= 97 && s[i + 1] <= 122)
            s[i + 1] -= 32;
}

void str_captalize(char* const s) {
    str_lower(s);

    int i = 0;
    int len = str_length(s);

    while(i < len && s[i] == ' ') i++;

    if(str_length(s) != 0 && s[i] >= 97 && s[i] <= 122)
        s[i] -= 32;
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
    size_t len = str_length(s); 

    if(s != NULL)
        for(int i = 0; i < len; i++)
            if(s[i] == c) num++;

    return num;
}

bool str_equals(const char* const s1, const char* const s2) {
    size_t len = str_length(s1);
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
