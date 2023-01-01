#include "header/mystring.h"
#include <string.h>

int main(int argc, char **args) {
    String s = createStr("Fer Cam Sil Dal Mar");
    printf("%s\n", s.buf);
    printf("%li == %li\n", s.len, strlen(s.buf));

    s.upper(s.this);

    printf("%s\n", s.buf);
    printf("%li == %li\n", s.len, strlen(s.buf));

    s.lower(s.this);
    
    printf("%s\n", s.buf);
    printf("%li == %li\n", s.len, strlen(s.buf));
    
    s.title(s.this);

    printf("%s\n", s.buf);
    printf("%li == %li\n", s.len, strlen(s.buf));

    destruct(s);
    return 0;
}
