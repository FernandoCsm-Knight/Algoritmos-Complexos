/**
 * @file mystring.h
 * @author Fernando Campos Silva Dal Maria (fernandocsdm@gmail.com)
 * @brief This lib provides a string struct with several features for manipulating strings with high level instructions in C.
 * @version 1.3.7
 * @date 01-01-2023
 * 
 * @copyright Copyright (c) 2023
 * 
 */


#ifndef MY_STRING
#define MY_STRING

//=====INCLUDE=====//
#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

/*
 * Notice that the subsequent prototypes are orginized by return type 
 */

//=====STRUCT=====//
typedef struct string {
    char* buf;
    size_t len;

    //=====VOID=====//

    /**
     * @brief Removes spaces at the start and the end of a string.
     * 
     * @param s
     *        The reference to specify a string. 
     */
    void (*trim)(struct string* const);

    /**
     * @brief Concatenates the specified string 'str' to the end of another string 's'.
     * 
     * @param s 
     *        The reference to specify a string. 
     * @param str 
     *        The String that is concatenated to the end of this String.
     */
    void (*concat)(struct string* const, const struct string);

    /**
     * @brief Concatenates the specified string 'str' to the end of another string 's'.
     * 
     * @param s 
     *        The reference to specify a string. 
     * @param str 
     *        The character sequence that is concatenated to the end of this String.
     */
    void (*lconcat)(struct string* const, const char* const);

    /**
     * @brief Replaces all occurrences of a given substring by another.
     * 
     * @param s 
     *        The reference to specify a string. 
     * @param reg
     *        Old substring that must be replaced. 
     * @param str
     *        New substring to be reseted.
     */
    void (*replace)(struct string* const, const char* const, const char* const);

    /**
     * @brief Interpolates a given string into another, at a given index.
     * 
     * @param s 
     *        The string object.
     * @param str
     *        The target string to be interpolated.
     */
    void (*add)(struct string* const, const struct string, size_t);

    /**
     * @brief Interpolates a given string into another, at a given index.
     * 
     * @param s 
     *        The string object.
     * @param str
     *        The target character sequence to be interpolated.
     */
    void (*ladd)(struct string* const, const char* const, size_t);

    /**
     * @brief Removes all characters between the start index (inclusive) and the end index (exclusive).
     * 
     * @param s 
     *        The string object.
     * @param start 
     *        The target start index (inclusive).
     * @param end 
     *        The target end index (exclusive).
     */
    void (*del)(struct string* const, size_t, size_t);

    /**
     * @brief Removes all occurrences of a given substring.
     * 
     * @param s 
     *        The reference to specify a string.
     * @param str
     *        The substring that should be removed.
     */
    void (*cut)(struct string* const, const struct string);

    /**
     * @brief Removes all occurrences of a given substring.
     * 
     * @param s 
     *        The reference to specify a string.
     * @param str
     *        The substring that should be removed.
     */
    void (*lcut)(struct string* const, const char* const);

    /**
     * @brief Copies a given string to another.
     * 
     * @param s 
     *        The reference to specify a string.
     * @param str 
     *        The string to be copied.
     */
    void (*copy)(struct string* const, const struct string);

    /**
     * @brief Copies a given character sequence for the string.
     * 
     * @param s 
     *        The reference to specify a string.
     * @param str 
     *        The character sequence to be copied.
     */
    void (*lcopy)(struct string* const, const char* const);

    /**
     * @brief Changes all characters of a string to upper case.
     * 
     * @param s 
     *        The reference to specify a string.
     */
    void (*upper)(struct string* const);

    /**
     * @brief Changes all characters of a string to lower case.
     * 
     * @param s 
     *        The reference to specify a string.
     */
    void (*lower)(struct string* const);

    /**
     * @brief Changes all letters of a string to upper case.
     * 
     * @param s 
     *        The reference to specify a string.
     */
    void (*title)(struct string* const);

    /**
     * @brief Changes the first letter of a string to upper case and the others to lower case.
     * 
     * @param s 
     *        The reference to specify a string.
     */
    void (*captalize)(struct string* const);

    /**
     * @brief Clear all characters from a string.
     * 
     * @param s 
     *        Ther reference to specify a string.
     */
    void (*clear)(struct string* const);
    
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
    struct string (*substr)(const struct string, int, int);

    /**
     * @brief Creates and return a copy of a given string.
     * 
     * @param s 
     *        The string object.
     * @return String 
     */
    struct string (*clone)(const struct string);

    //=====STRING*=====//

    /**
     * @brief Creates and return an array of strings with subsequences from a given string. Uses a character to identify the break point.
     * 
     * @param s 
     *        The string object.
     * @param regex 
     *        The character that specifies the break point.
     * @return String* 
     */
    struct string* (*split)(const struct string, const char* const);

    //=====BOOL=====//

    /**
     * @brief Returns true if the string is NULL or its length is equal to zero.
     * 
     * @param s 
     *        The string object.
     * @return true - for an empty string.
     * @return false - for an non-empty string.
     */
    bool (*isEmpty)(const struct string);

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
    bool (*equals)(const struct string, const struct string);

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
    bool (*lequals)(const struct string, const char* const);

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
    bool (*contains)(const struct string, const struct string);

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
    bool (*lcontains)(const struct string, const char* const);

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
    bool (*startsWith)(const struct string, const struct string);

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
    bool (*lstartsWith)(const struct string, const char* const);

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
    bool (*endsWith)(const struct string, const struct string);

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
    bool (*lendsWith)(const struct string, const char* const);

    //=====INT*=====//
    
    /**
     * @brief Return a byte array with a byto for each character in a string.
     * 
     * @param s
     *        The string object. 
     * @return int* - with a byte for each character in the string.
     */
    int* (*toBytes)(const struct string s);

    //=====INT=====//

    /**
     * @brief Returns the index within this string for the first occurrence of the substring. 
     * 
     * @param s 
     *        The string object.
     * @param str
     *        The target substring.
     * @return int - index of the first occurrence of the substring in the character sequence represented by this object, or -1 if the character does not occur.
     */
    int (*indexOf)(const struct string, const struct string);

    /**
     * @brief Returns the index within this string for the first occurrence of the substring. 
     * 
     * @param s 
     *        The string object.
     * @param str
     *        The target substring.
     * @return int - index of the first occurrence of the substring in the character sequence represented by this object, or -1 if the character does not occur.
     */
    int (*lindexOf)(const struct string, const char* const);

    /**
     * @brief Returns the index within this string for the last occurrence of the substring. 
     * 
     * @param s 
     *        The string object.
     * @param str
     *        The target substring.
     * @return int - index of the last occurrence of the substring in the character sequence represented by this object, or -1 if the character does not occur.
     */
    int (*lastIndexOf)(const struct string, const struct string);

    /**
     * @brief Returns the index within this string for the last occurrence of the substring. 
     * 
     * @param s 
     *        The string object.
     * @param str
     *        The target substring.
     * @return int - index of the last occurrence of the substring in the character sequence represented by this object, or -1 if the character does not occur.
     */
    int (*llastIndexOf)(const struct string, const char* const);


    /**
     * @brief Compares two strings lexicographically. The comparison is based on the Unicode value of each character in the strings. The result is a negative integer if this String object lexicographically precedes the argument string. The result is a positive integer if this String object lexicographically follows the argument string. The result is zero if the strings are equal.
     * 
     * @param s 
     *        The string object.
     * @param str 
     *        The target string object.
     * @return int value, 0 if the strings are equal, a positive integer if the "s" string lexicographically follows the "str" string and a negative integer if the "s" string lexicographically precedes the "str" string.
     */
    int (*compareTo)(const struct string, const struct string);

    /**
     * @brief Compares two strings lexicographically. The comparison is based on the Unicode value of each character in the strings. The result is a negative integer if this String object lexicographically precedes the argument string. The result is a positive integer if this String object lexicographically follows the argument string. The result is zero if the strings are equal.
     * 
     * @param s 
     *        The string object.
     * @param str 
     *        The target character sequence.
     * @return int value, 0 if the strings are equal, a positive integer if the "s" string lexicographically follows the "str" string and a negative integer if the "s" string lexicographically precedes the "str" string.
     */
    int (*lcompareTo)(const struct string, const char* const);

    /**
     * @brief This is a polynomial rolling hash function that returns the string's hash.
     * 
     * @param s 
     *        The string object.
     * @return int 
     */
    int (*hashCode)(const struct string);

    /**
     * @brief Parses the string argument as a signed decimal integer.
     * 
     * @param s 
     *        The string object.
     * @return int 
     */
    int (*parseInt)(const struct string);

    //=====DOUBLE=====//

    /**
     * @brief Parses the string argument as a signed decimal integer.
     * 
     * @param s 
     *        The string object.
     * @return int 
     */
    double (*parseFloat)(const struct string);

    //=====SIZE_T=====//

    /**
     * @brief Calculate and returns the length of a string. 
     * 
     * @param s 
     *        The string object.
     * @return size_t 
     */
    size_t (*length)(const struct string);

    /**
     * @brief Returns the total of occurrences of a given substring in a string.
     * 
     * @param s 
     *        The string object.
     * @param str 
     *        The target substring.
     * @return size_t 
     */
    size_t (*count)(const struct string, const struct string);

    /**
     * @brief Returns the total of occurrences of a given substring in a string.
     * 
     * @param s 
     *        The string object.
     * @param str 
     *        The target substring.
     * @return size_t 
     */
    size_t (*lcount)(const struct string, const char* const);
} String;

//=====CONSTRUCTOR=====//

/**
 * @brief Initialize and return a new String object.
 * 
 * @param str 
 *        The character sequence that should compose the string.
 * @return String 
 */
String newStr(const char* const str);

//=====DESTRUCTOR=====//

/**
 * @brief Delete a specified string object.
 * 
 * @param s 
 *        The string that should be deleted.
 */
void delStr(String s);

//=====CHAR*_MANIP=====//
//=====VOID=====//
void str_concat(char** s, const char* const str);
void str_copy(char** s, const char* const c);
void str_replace(char** const s, const char* const reg, const char* const str);
void str_add(char** s, const char* const str, size_t idx);
void str_del(char** s, size_t start, size_t end);
void str_cut(char** s, const char* const str);
void str_upper(char* const s);
void str_lower(char* const s);
void str_title(char* const s);
void str_captalize(char* const s);

//=====CHAR*=====//
char* str_trim(const char* const s);
char* str_substr(const char* const s, int start, int end);

//=====INT*=====//
int* str_toBytes(const char* const s);

//=====INT=====//
int str_indexOf(const char* const s, const char* const str);
int str_lastIndexOf(const char* const s, const char* const str);
int str_compareTo(const char* const s, const char* const str);
int str_hashCode(const char* const s);

//=====BOOL=====//
bool str_equals(const char* const s1, const char* const s2);
bool str_contains(const char* const s, const char* const str);
bool str_startsWith(const char* const s, const char* const str);
bool str_endsWith(const char* const s, const char* const str);

//=====SIZE_T=====//
size_t str_length(const char* const s);
size_t str_count(const char* const s, const char* const str);

#endif
