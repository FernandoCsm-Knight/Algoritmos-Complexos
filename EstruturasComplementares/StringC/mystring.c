
#include "header/mystring.h"

//=====STRING_MANIP=====//
//=====VOID=====//
void trim(String* const s);
void replace(String* const s, const char r, const char c);
void cut(String* const s, const char c);
void copy(String* const s, const String str);
void lcopy(String* const s, const char* const str);
void upper(String* const s);
void lower(String* const s);
void title(String* const s);
void captalize(String* const s);
void clear(String* const s);

//=====STRING=====//
String substr(const String s, int start, int end);
String clone(const String s);

//=====STRING*=====/
String* split(const String s, const char c);

//=====BOOL=====//
bool isEmpty(const String s);
bool equals(const String s1, const String s2);
bool lequals(const String s1, const char* const s2);
bool contains(const String s, const String str);
bool lcontains(const String s, const char* const str);
bool startsWith(const String s, const String str);
bool lstartsWith(const String s, const char* const str);
bool endsWith(const String s, const String str);
bool lendsWith(const String s, const char* const str);

//=====INT=====//
int compareTo(const String s, const String str);
int lcompareTo(const String s, const char* const str);
int parseInt(const String s);

//=====DOUBLE=====//
double parseFloat(const String s);

//=====SIZE_T=====//
size_t length(const String s);

//=====CONSTRUCTOR=====//
String createStr(const char* const str) {
    String s;

    s.len = 0;
    s.buf = NULL;

    //=====VOID=====//
    s.trim = trim;
    s.replace = replace;
    s.cut = cut;
    s.copy = copy;
    s.lcopy = lcopy;
    s.upper = upper;
    s.lower = lower;
    s.title = title;
    s.captalize = captalize;
    s.clear = clear;

    //=====STRING=====//
    s.substr = substr;
    s.clone = clone;
    
    //=====STRING*=====//
    s.split = split;

    //=====BOOL=====//
    s.isEmpty = isEmpty;
    s.equals = equals;
    s.lequals = lequals;
    s.contains = contains;
    s.lcontains = lcontains;
    s.startsWith = startsWith;
    s.lstartsWith = lstartsWith;
    s.endsWith = endsWith;
    s.lendsWith = lendsWith;

    //=====INT=====//
    s.compareTo = compareTo;
    s.lcompareTo = lcompareTo;
    s.parseInt = parseInt;

    //=====DOUBLE=====//
    s.parseFloat = parseFloat;

    //=====SIZE_T=====//
    s.length = length;

    if(str != NULL) 
        s.lcopy(&s, str);

    return s;
}

//=====DESTRUCTOR=====//
void destruct(String s) {
    free(s.buf);
}

//=====STRING_MANIP=====//
//=====VOID=====//
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

void copy(String* const s, const String str) {
    str_copy(&s->buf, str.buf);
    s->len = str_length(s->buf);
}

void lcopy(String* const s, const char* const str) {
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

void clear(String* const s) {
    free(s->buf);
    s->buf = (char*)calloc(1, sizeof(char));
    s->buf[0] = '\0';
    s->len = 0;
}

//=====STRING=====//
String substr(const String s, int start, int end) {
    char* aux = str_substr(s.buf, start, end);
    String str = createStr(aux);
    free(aux);
    return str;
}

String clone(const String s) {
    return createStr(s.buf);
}

//=====STRING*=====//
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

//=====BOOL=====//
bool isEmpty(const String s) {
    return s.buf == NULL || s.len == 0;
}

bool equals(const String s1, const String s2) {
    bool value = s1.len == s2.len;
    for(int i = 0; value && i < s1.len; i++) 
        value = s1.buf[i] == s2.buf[i];

    return value;
}

bool lequals(const String s1, const char* const s2) {
    bool value = s1.len == str_length(s2);
    for(int i = 0; value && i < s1.len; i++) 
        value = s1.buf[i] == s2[i];

    return value;
}

bool contains(const String s, const String str) {
    return str_contains(s.buf, str.buf);
}

bool lcontains(const String s, const char* const str) {
    return str_contains(s.buf, str);
}

bool startsWith(const String s, const String str) {
    return str_startsWith(s.buf, str.buf);
}

bool lstartsWith(const String s, const char* const str) {
    return str_startsWith(s.buf, str);
}

bool endsWith(const String s, const String str) {
    return str_endsWith(s.buf, str.buf);
}

bool lendsWith(const String s, const char* const str) {
    return str_endsWith(s.buf, str);
}

//=====INT=====//
int compareTo(const String s, const String str) {
    return str_compareTo(s.buf, str.buf);
}

int lcompareTo(const String s, const char* const str) {
    return str_compareTo(s.buf, str);
}

int parseInt(const String s) {
    int sum = 0;

    for(int i = s.len - 1, j = 1; i >= 0; i--, j *= 10) 
        sum += (s.buf[i] - 48) * j;

    return sum;
}

double parseFloat(const String s) {
    double sum = 0.0;

    int i = s.len - 1;
    double j = 1.0;

    while(i >= 0 && s.buf[i] != '.' && s.buf[i] != ',')  {
        j /= 10;
        i--;
    }
    
    String str = s.clone(s);
    str.cut(&str, '.');
    str.cut(&str, ',');

    for(int k = str.len - 1; k >= 0; k--, j *= 10) 
        sum += (str.buf[k] - 48) * j;

    destruct(str);
    return sum;
}

//=====size_t=====//
size_t length(const String s) {
    return str_length(s.buf);
}

//=====CHAR*_MANIP=====//
//=====VOID=====//
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
    size_t len = str_length(s);

    while(i < len && s[i] == ' ') i++;

    if(str_length(s) != 0 && s[i] >= 97 && s[i] <= 122)
        s[i] -= 32;
}

//=====char*=====//
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

//=====INT=====//
int str_compareTo(const char* const s, const char* const str) {
    int sl = str_length(s),
        strl = str_length(str),
        limit = (sl < strl) ? sl : strl;
    
    for(int i = 0; i < limit; i++)
        if(s[i] != str[i]) 
            return s[i] - str[i];

    return sl - strl;
}

//=====UNS_INT=====//
unsigned int str_count(const char* const s, const char c) {
    unsigned int num = 0;
    size_t len = str_length(s); 

    if(s != NULL)
        for(int i = 0; i < len; i++)
            if(s[i] == c) num++;

    return num;
}

//=====BOOL=====//
bool str_equals(const char* const s1, const char* const s2) {
    size_t len = str_length(s1);
    bool value = len == str_length(s2);
    for(int i = 0; value && i < len; i++) 
        value = s1[i] == s2[i];
    return value;
}

bool str_contains(const char* const s, const char* const str) {
    size_t sl = str_length(s),
           strl = str_length(str);
    bool value = s != NULL && sl >= strl;

    if(value) {
        for(int i = 0, j = 0; i < sl && j < strl && (sl - i >= strl || j != 0); i++) {
            value = s[i] == str[j];
            
            if(value) j++;
            else if(j != 0) {
                i -= j;
                j = 0;
            }
        }
    }

    return value;
}

bool str_startsWith(const char* const s, const char* const str) {
    size_t sl = str_length(s),
           strl = str_length(str);
    bool value = sl >= strl;

    for(int i = 0; value && i < strl; i++) 
        value = s[i] == str[i];

    return value;
}

bool str_endsWith(const char* const s, const char* const str) {
    size_t sl = str_length(s),
           strl = str_length(str);
    bool value = sl >= strl;

    for(int i = sl - 1, j = strl - 1; value && i >= 0 && j >= 0; i--, j--) 
        value = s[i] == str[j];

    return value;
}

//=====SIZE_T=====//
size_t str_length(const char* const s) {
    size_t len = 0;
    if(s != NULL)
        while(s[len] != '\0') len++;
    return len;
}
