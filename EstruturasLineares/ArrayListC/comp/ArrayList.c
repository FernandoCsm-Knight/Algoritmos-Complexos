//=====INCLUDE=====//
#include "../header/ArrayList.h" 

//=====METODOS=====//
//-----CONSTRUCTORS-----//
void alocateStrs(Strings* const arr, int i) {
    arr->strs = (char**)calloc(i, sizeof(char*));
    arr->cap = i;
    arr->len = 0;
}

void freeStrs(Strings* arr) {
    free(arr->strs);
}

//-----ISEMPTY-----//
bool isEmpty(Strings* const arr) {
    return arr->len == 0;
}

//-----ISFULL-----//
bool isFull(Strings* const arr) {
    return arr->len == arr->cap;
}

//-----GROW-----//
void grow(Strings* arr) {
    Strings newArr;
    alocateStrs(&newArr, arr->cap * 2);
    
    for(int i = 0; i < arr->len; i++)
        newArr.strs[i] = arr->strs[i];

    free(arr->strs);
    arr->cap = newArr.cap;
    arr->strs = newArr.strs;
}

//-----SHRINK-----//
void shrink(Strings* arr) {
    Strings newArr;
    alocateStrs(&newArr, arr->cap / 2);
    
    for(int i = 0; i < arr->len; i++)
        newArr.strs[i] = arr->strs[i];
    
    free(arr->strs);
    arr->cap = newArr.cap;
    arr->strs = newArr.strs;
}

//-----ADD-----//
void add(Strings* const arr, char* const s) {
    if(isFull(arr)) grow(arr);
    arr->strs[arr->len] = s;
    arr->len++;
}

void addp(Strings* const arr, int p, char* const s) {
    if(isFull(arr)) grow(arr);
    for(int i = arr->len; i > p; i--) 
        arr->strs[i] = arr->strs[i - 1];
    
    arr->strs[p] = s;
    arr->len++;
}

//-----INSERT-----//
void insert(Strings* const arr, char* const s) {
    if(isFull(arr)) grow(arr);
    for(int i = arr->len; i > 0; i--) 
        arr->strs[i] = arr->strs[i - 1];

    arr->strs[0] = s;
    arr->len++;
}

//-----POP-----//
char* pop(Strings* const arr) {
    char* s = NULL;
    if(!isEmpty(arr)) {
        arr->len--;
        s = arr->strs[arr->len];

        if(arr->len <= (arr->cap / DOWNGRADE)) shrink(arr);
    }
    return s;
}

char* popp(Strings* const arr, int p) {
    char* s = NULL;
    if(!isEmpty(arr)) {
        s = arr->strs[p];
        for(int i = p; i < arr->len - 1; i++) 
            arr->strs[i] = arr->strs[i + 1];

        arr->len--;
        if(arr->len <= (arr->cap / DOWNGRADE)) shrink(arr);
    }
    return s;
}

char* popObj(Strings* const arr, char* s) {
    if(!isEmpty(arr)) 
        return popp(arr, search(arr, s));
    return NULL;
}

//-----REMOVE-----//
char* removee(Strings* const arr) {
    char* s = NULL;
    if(!isEmpty(arr)) {
        s = arr->strs[0];
        for(int i = 0; i < arr->len - 1; i++) 
        	arr->strs[i] = arr->strs[i + 1];
        
        arr->len--;
        if(arr->len <= (arr->cap / DOWNGRADE)) shrink(arr);
    }
    return s;
}

//-----SEARCH-----//
int search(Strings* const arr, char* const s) {
    if(s == NULL) {
        for(int i = 0; i < arr->len; i++) 
            if(arr->strs[i] == NULL) return i;
    } else {
        for(int i = 0; i < arr->len; i++)
            if(equals(arr->strs[i], s)) return i;
    }
    return -1;
}

//-----CONTAINS-----//
bool contains(Strings* const arr, char* const s) {
    bool value = false;
    if(s == NULL) {
        for(int i = 0; i < arr->len && !value; i++) 
            value = arr->strs[i] == NULL; 
    } else {
        for(int i = 0; i < arr->len && !value; i++) 
            value = equals(arr->strs[i], s);
    }
    return value;
}

//=====QUICKSORT=====//
void quickSort(Strings* const arr, int first, int last) {
    if(first < last) {
        int p = partition(arr, first, last);

        quickSort(arr, first, p - 1);
        quickSort(arr, p, last);
    }
}

int partition(Strings* const arr, int first, int last) {
    int i = first,
        j = last;

    char* p = arr->strs[(first + last) / 2];

    while(i <= j) {
        while(compareTo(arr->strs[i], p) < 0) i++;
        while(compareTo(arr->strs[j], p) > 0) j--;
        if(i <= j) {
            swap(arr, i, j);
            i++;
            j--;
        }
    }
    
    return i;
}

void swap(Strings* const arr, int a, int b) {
    char* s = arr->strs[a];
    arr->strs[a] = arr->strs[b];
    arr->strs[b] = s;
}

//=====PRINT=====//
void printStrs(Strings* arr) {
    printf("[");
    for(int i = 0; i < arr->len; i++) {
        printf("%s", arr->strs[i]);
        if(i != arr->len - 1) printf(", ");
    } 
    puts("]");
}

//=====ISBOOL=====//
bool isNumber(char c) {
    return (int)c >= 48 && (int)c <= 57;
}

bool isFloat(char* const s) {
    bool value = true;
    for(int i = 0, j = 0; i < length(s) && value; i++) {
        if(s[i] == ',' || s[i] == '.') j++; 
        else value = isNumber(s[i]);
        if(value) value = j <= 1; 
    } 
    return value;
}

bool equals(const char* const s1, const char* const s2) {
    int len1 = length(s1),
        len2 = length(s2);
    bool value = len1 == len2;

    for(int i = 0; i < len1 && value; i++) 
        value = s1[i] == s2[i];
    return value;
}

//=====PARSES=====//
int parseInt(char* const s) {
    int num,
        len = length(s);

    for(int i = len - 1, j = 1; i >= 0; i--, j *= 10)  
        if(isNumber(s[i]))
            num += ((int)s[i] - 48) * j;
    return num;
}

//=====COMPARE=====//
int compareTo(char* const s1, char* const s2) {
    int len1 = length(s1),
        len2 = length(s2),
        min = (len1 < len2) ? len1 : len2;
    
    for(int i = 0; i < min; i++) 
        if(s1[i] != s2[i]) 
            return s1[i] - s2[i];

    return len1 - len2;
}

//=====COUNTERS=====//
size_t length(const char* const s) {
    size_t i = 0;
    if(s != NULL)
        while(s[i] != '\0') i++;
    return i;
}

//=====MATH=====//
double expfloat(double b, int e) {
    double res = 1;
    for(int i = 0; i < e; i++) res *= b;
    return res;
}

int expinteger(int b, int e) {
    int res = 1;
    for(int i = 0; i < e; i++) res *= b;
    return res;
}
