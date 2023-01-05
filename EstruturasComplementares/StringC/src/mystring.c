/**
 * @file mystring.c
 * @author Fernando Campos Silva Dal Maria (fernandocsdm@gmail.com)
 * @brief This source code provides a set of features for manipulating strings with high level instructions in C promgraming language.
 * @version 1.1.5
 * @date 01-01-2023
 * 
 * @copyright Copyright (c) 2023
 * 
 */

#include "header/mystring.h"

/*
 * Notice that the subsequent prototypes are orginized by return type 
 */

//=====STRING_MANIP=====//
//=====VOID=====//

/**
 * @brief Removes spaces at the start and the end of a string.
 * 
 * @param s
 *        The reference to specify a string. 
 */
void trim(String* const s);

/**
 * @brief Concatenates the specified string 'str' to the end of another string 's'.
 * 
 * @param s 
 *        The reference to specify a string. 
 * @param str 
 *        The String that is concatenated to the end of this String.
 */
void concat(String* const s, const String str);

/**
 * @brief Concatenates the specified string 'str' to the end of another string 's'.
 * 
 * @param s 
 *        The reference to specify a string. 
 * @param str 
 *        The character sequence that is concatenated to the end of this String.
 */
void lconcat(String* const s, const char* const str);

/**
 * @brief Replaces all occurrences of a given char by another.
 * 
 * @param s 
 *        The reference to specify a string. 
 * @param r
 *        Character to be replaced. 
 * @param c 
 *        Character to be reseted.
 */
void replace(String* const s, const char r, const char c);

/**
 * @brief Removes all occurrences of a given char.
 * 
 * @param s 
 *        The reference to specify a string.
 * @param c 
 *        The character that should be removed.
 */
void cut(String* const s, const char c);

/**
 * @brief Copies a given string to another.
 * 
 * @param s 
 *        The reference to specify a string.
 * @param str 
 *        The string to be copied.
 */
void copy(String* const s, const String str);

/**
 * @brief Copies a given character sequence for the string.
 * 
 * @param s 
 *        The reference to specify a string.
 * @param str 
 *        The character sequence to be copied.
 */
void lcopy(String* const s, const char* const str);

/**
 * @brief Changes all characters of a string to upper case.
 * 
 * @param s 
 *        The reference to specify a string.
 */
void upper(String* const s);

/**
 * @brief Changes all characters of a string to lower case.
 * 
 * @param s 
 *        The reference to specify a string.
 */
void lower(String* const s);

/**
 * @brief Changes all letters of a string to upper case.
 * 
 * @param s 
 *        The reference to specify a string.
 */
void title(String* const s);

/**
 * @brief Changes the first letter of a string to upper case and the others to lower case.
 * 
 * @param s 
 *        The reference to specify a string.
 */
void captalize(String* const s);

/**
 * @brief Clear all characters from a string.
 * 
 * @param s 
 *        Ther reference to specify a string.
 */
void clear(String* const s);

//=====STRING=====//

/**
 * @brief Gets a substring beggining at the starting position and ending at the end index - 1.
 * 
 * @param s 
 *        The string object.
 * @param start 
 *        The start index, inclusive.
 * @param end 
 *        The end index, exclusive.
 * @return String 
 */
String substr(const String s, int start, int end);

/**
 * @brief Creates and return a copy of a given string.
 * 
 * @param s 
 *        The string object.
 * @return String 
 */
String clone(const String s);

//=====STRING*=====//
/**
 * @brief Creates and return an array of strings with subsequences from a given string. Uses a character to identify the break point.
 * 
 * @param s 
 *        The string object.
 * @param c 
 *        The character that specifies the break point.
 * @return String* 
 */
String* split(const String s, const char c);

//=====BOOL=====//

/**
 * @brief Returns true if the string is NULL or its length is equal to zero.
 * 
 * @param s 
 *        The string object.
 * @return true - for an empty string.
 * @return false - for an non-empty string.
 */
bool isEmpty(const String s);

/**
 * @brief Returns true if both given strings are equals.
 * 
 * @param s1 
 *        The string object to be the template.
 * @param s2 
 *        The string object to be compared.
 * @return true - for matching strings.
 * @return false - for different strings.
 */
bool equals(const String s1, const String s2);

/**
 * @brief Returns true if both given strings are equals.
 * 
 * @param s1 
 *        The string object to be the template.
 * @param s2 
 *        The character sequence to be compared.
 * @return true - for matching strings.
 * @return false - for different strings.
 */
bool lequals(const String s1, const char* const s2);

/**
 * @brief Returns true if a character sequense is a subsequence of a given string.
 * 
 * @param s 
 *        The string object.
 * @param str 
 *        The string object with the target sequence.
 * @return true - if the subsequence is a part of the string.
 * @return false -  if the subsequence is not a part of the string.
 */
bool contains(const String s, const String str);

/**
 * @brief Returns true if a character sequense is a subsequence of a given string.
 * 
 * @param s 
 *        The string object.
 * @param str 
 *        The  character subsequence.
 * @return true - if the subsequence is a part of the string.
 * @return false -  if the subsequence is not a part of the string.
 */
bool lcontains(const String s, const char* const str);

/**
 * @brief Tests if a string starts with the specified prefix.
 * 
 * @param s
 *        The string object. 
 * @param str 
 *        The string prefix.
 * @return true - if the string starts with the prefix.
 * @return false - if the prefix is not in the start of the string.
 */
bool startsWith(const String s, const String str);

/**
 * @brief Tests if a string starts with the specified prefix.
 * 
 * @param s
 *        The string object. 
 * @param str 
 *        The character sequence prefix.
 * @return true - if the string starts with the prefix.
 * @return false - if the prefix is not in the start of the string.
 */
bool lstartsWith(const String s, const char* const str);

/**
 * @brief Tests if a string ends with the specified suffix.
 * 
 * @param s
 *        The string object. 
 * @param str 
 *        The string suffix.
 * @return true - if the string ends with the suffix.
 * @return false - if the suffix is not in the end of the string.
 */
bool endsWith(const String s, const String str);

/**
 * @brief Tests if a string ends with the specified suffix.
 * 
 * @param s
 *        The string object. 
 * @param str 
 *        The character sequence suffix.
 * @return true - if the string ends with the suffix.
 * @return false - if the suffix is not in the end of the string.
 */
bool lendsWith(const String s, const char* const str);

//=====INT*=====//

/**
 * @brief Return a byte array with a byto for each character in a string.
 * 
 * @param s
 *        The string object. 
 * @return int* - with a byte for each character in the string.
 */
int* toBytes(const String s);

//=====INT=====//

/**
 * @brief Returns the index within this string of the first occurrence of the specified character. 
 * 
 * @param s 
 *        The string object.
 * @param c 
 *        The target character.
 * @return int - index of the first occurrence of the character in the character sequence represented by this object, or -1 if the character does not occur.
 */
int indexOf(const String s, const char c);

/**
 * @brief Returns the index within this string of the last occurrence of the specified character. 
 * 
 * @param s 
 *        The string object.
 * @param c 
 *        The target character.
 * @return int - index of the last occurrence of the character in the character sequence represented by this object, or -1 if the character does not occur.
 */
int lastIndexOf(const String s, const char c);

/**
 * @brief Compares two strings lexicographically. The comparison is based on the Unicode value of each character in the strings. The result is a negative integer if this String object lexicographically precedes the argument string. The result is a positive integer if this String object lexicographically follows the argument string. The result is zero if the strings are equal.
 * 
 * @param s 
 *        The string object.
 * @param str 
 *        The target string object.
 * @return int value, 0 if the strings are equal, a positive integer if the "s" string lexicographically follows the "str" string and a negative integer if the "s" string lexicographically precedes the "str" string.
 */
int compareTo(const String s, const String str);

/**
 * @brief Compares two strings lexicographically. The comparison is based on the Unicode value of each character in the strings. The result is a negative integer if this String object lexicographically precedes the argument string. The result is a positive integer if this String object lexicographically follows the argument string. The result is zero if the strings are equal.
 * 
 * @param s 
 *        The string object.
 * @param str 
 *        The target character sequence.
 * @return int value, 0 if the strings are equal, a positive integer if the "s" string lexicographically follows the "str" string and a negative integer if the "s" string lexicographically precedes the "str" string.
 */
int lcompareTo(const String s, const char* const str);

/**
 * @brief This is a polynomial rolling hash function that returns the string's hash.
 * 
 * @param s 
 *        The string object.
 * @return int 
 */
int hashCode(const String s);

/**
 * @brief Parses the string argument as a signed decimal integer.
 * 
 * @param s 
 *        The string object.
 * @return int 
 */
int parseInt(const String s);

//=====DOUBLE=====//

/**
 * @brief Parses the string argument as a signed decimal integer.
 * 
 * @param s 
 *        The string object.
 * @return int 
 */
double parseFloat(const String s);

//=====SIZE_T=====//

/**
 * @brief Calculate and returns the length of a string. 
 * 
 * @param s 
 *        The string object.
 * @return size_t 
 */
size_t length(const String s);

//=====CONSTRUCTOR=====//
String newStr(const char* const str) {
    String s;

    s.len = 0;
    s.buf = NULL;

    //=====VOID=====//
    s.trim = trim;
    s.concat = concat;
    s.lconcat = lconcat;
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

    //=====INT*=====//
    s.toBytes = toBytes;

    //=====INT=====//
    s.indexOf = indexOf;
    s.lastIndexOf = lastIndexOf;
    s.compareTo = compareTo;
    s.lcompareTo = lcompareTo;
    s.hashCode = hashCode;
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
void delStr(String s) {
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

void concat(String* const s, const String str) {
    str_concat(&s->buf, str.buf);
    s->len = str_length(s->buf);
}

void lconcat(String* const s, const char* const str) {
    str_concat(&s->buf, str);
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
    String str = newStr(aux);
    free(aux);
    return str;
}

String clone(const String s) {
    return newStr(s.buf);
}

//=====STRING*=====//
String* split(const String s, const char c) {
    String* strs = (String*)calloc(str_count(s.buf, c) + 1, sizeof(String));

    int start = 0,
        end = 0;

    char* new_str;

    int j = 0;
    for(size_t i = 0; i < s.len; i++, end++) {
        if(s.buf[i] == c) {
            new_str = str_substr(s.buf, start, end);
            strs[j++] = newStr(new_str);
            start = end + 1;
            free(new_str);
        }
    }

    new_str = str_substr(s.buf, start, end);
    strs[j] = newStr(new_str);
    free(new_str);
    return strs;
}

//=====BOOL=====//
bool isEmpty(const String s) {
    return s.buf == NULL || s.len == 0;
}

bool equals(const String s1, const String s2) {
    bool value = s1.len == s2.len;
    for(size_t i = 0; value && i < s1.len; i++) 
        value = s1.buf[i] == s2.buf[i];

    return value;
}

bool lequals(const String s1, const char* const s2) {
    bool value = s1.len == str_length(s2);
    for(size_t i = 0; value && i < s1.len; i++) 
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

//=====INT*=====//
int* toBytes(const String s) {
    return str_toBytes(s.buf);
}

//=====INT=====//
int indexOf(const String s, const char c) {
    return str_indexOf(s.buf, c);
}

int lastIndexOf(const String s, const char c) {
    return str_lastIndexOf(s.buf, c);
}

int compareTo(const String s, const String str) {
    return str_compareTo(s.buf, str.buf);
}

int lcompareTo(const String s, const char* const str) {
    return str_compareTo(s.buf, str);
}

int hashCode(const String s) {
    return str_hashCode(s.buf);
}

int parseInt(const String s) {
    int sig = 0;
    
    bool pos = true;
    if(s.buf != NULL && (s.buf[0] == '+' || s.buf[0] == '-')) {
        sig = 1;
        if(s.buf[0] == '-') pos = false;
    } 
    
    int sum = 0;
    for(int i = s.len - 1, j = 1; i >= sig; i--, j *= 10) 
        sum += (s.buf[i] - 48) * j;

    return (pos) ? sum : -sum;
}

//=====DOUBLE=====//
double parseFloat(const String s) {
    int sig = 0;
    
    bool pos = true;
    if(s.buf != NULL && (s.buf[0] == '+' || s.buf[0] == '-')) {
        sig = 1;
        if(s.buf[0] == '-') pos = false;
    } 
    
    double sum = 0.0;

    int i = s.len - 1;
    double j = 1.0;

    while(i >= sig && s.buf[i] != '.' && s.buf[i] != ',')  {
        j /= 10;
        i--;
    }
    
    String str = s.clone(s);
    str.cut(&str, '.');
    str.cut(&str, ',');

    for(int k = str.len - 1; k >= sig; k--, j *= 10) 
        sum += (str.buf[k] - 48) * j;

    delStr(str);
    return (pos) ? sum : -sum;
}

//=====size_t=====//
size_t length(const String s) {
    return str_length(s.buf);
}

//=====CHAR*_MANIP=====//
//=====VOID=====//
void str_concat(char** s, const char* const str) {
    int sl = str_length(*s),
        strl = str_length(str);
    
    char* news = (char*)calloc(sl + strl + 1, sizeof(char));

    int i = 0;
    for(i = 0; i < sl; i++) news[i] = (*s)[i];
    for(int j = 0; j < strl; i++, j++) news[i] = str[j];
    
    news[i] = '\0';
    free(*s);
    *s = news;
}

void str_copy(char** s, const char* const c) {
    if(*s != NULL) free(*s);

    size_t len = str_length(c);
    *s = (char*)calloc(len + 1, sizeof(char));

    size_t i = 0;
    while(i < len) {
        (*s)[i] = c[i];
        i++;
    }
    
    (*s)[i] = '\0';
}

void str_replace(char* const s, const char r, const char c) {
    size_t len = str_length(s);
    
    for(size_t i = 0; i < len; i++) 
        if(s[i] == r) s[i] = c;
}

void str_cut(char** s, const char c) {
    size_t len = str_length(*s),
        strl = len - str_count(*s, c);

    char* str = (char*)calloc(strl + 1, sizeof(char));

    int j = 0;
    for(size_t i = 0; i < len; i++) 
        if((*s)[i] != c) 
            str[j++] = (*s)[i];

    str[j] = '\0';

    free(*s);
    *s = str;
}

void str_upper(char* const s) {
    size_t len = str_length(s);

    for(size_t i = 0; i < len; i++) 
        if(s[i] >= 97 && s[i] <= 122) 
            s[i] -= 32; 
}

void str_lower(char* const s) {
    size_t len = str_length(s);

    for(size_t i = 0; i < len; i++) 
        if(s[i] >= 65 && s[i] <= 90) 
            s[i] += 32; 
}

void str_title(char* const s) {
    str_captalize(s);
    size_t len = str_length(s);

    for(size_t i = 0; i < len; i++)
        if(s[i] == ' ' && i < len - 1 && s[i + 1] >= 97 && s[i + 1] <= 122)
            s[i + 1] -= 32;
}

void str_captalize(char* const s) {
    str_lower(s);

    size_t i = 0,
           len = str_length(s);

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

//=====INT*=====//
int* str_toBytes(const char* const s) {
    int len = str_length(s);
    
    int* bytes = (int*)calloc(len, sizeof(int));

    for(int i = 0; i < len; i++) 
        bytes[i] = (int)s[i];

    return bytes;
}

//=====INT=====//
int str_indexOf(const char* const s, const char c) {
    int i = -1,
        len = str_length(s);
    
    for(int k = 0; i == -1 && k < len; k++)
        if(s[k] == c) i = k;

    return i;
}

int str_lastIndexOf(const char* const s, const char c) {
    int i = -1,
        len = str_length(s);
    
    for(int k = len - 1; i == -1 && k >= 0; k--)
        if(s[k] == c) i = k;

    return i;
}

int str_compareTo(const char* const s, const char* const str) {
    int sl = str_length(s),
        strl = str_length(str),
        limit = (sl < strl) ? sl : strl;
    
    for(int i = 0; i < limit; i++)
        if(s[i] != str[i]) 
            return s[i] - str[i];

    return sl - strl;
}

int str_hashCode(const char* const s) {
    const int p = 31, m = 1e9 + 7;
    int sum = 0,
        len = str_length(s);

    long p_pow = 1;
    for(int i = 0; i < len; i++) {
        sum = (sum + (s[i] - 'a' + 1) * p_pow) % m;
        p_pow = (p_pow * p) % m;
    }

    return sum;
}

//=====UNS_INT=====//
unsigned int str_count(const char* const s, const char c) {
    unsigned int num = 0;
    size_t len = str_length(s); 

    if(s != NULL)
        for(size_t i = 0; i < len; i++)
            if(s[i] == c) num++;

    return num;
}

//=====BOOL=====//
bool str_equals(const char* const s1, const char* const s2) {
    size_t len = str_length(s1);
    bool value = len == str_length(s2);
    for(size_t i = 0; value && i < len; i++) 
        value = s1[i] == s2[i];
    return value;
}

bool str_contains(const char* const s, const char* const str) {
    size_t sl = str_length(s),
           strl = str_length(str);
    bool value = s != NULL && sl >= strl;

    if(value) {
        for(size_t i = 0, j = 0; i < sl && j < strl && (sl - i >= strl || j != 0); i++) {
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

    for(size_t i = 0; value && i < strl; i++) 
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
