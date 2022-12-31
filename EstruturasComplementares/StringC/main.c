
#include "header/mystring.h"
#include <string.h>

int main(int argc, char **args) {
    String s = createStr("Fe mwçql dmpcnk ascFFe FFer");
    printf("%s\n", s.buf);
    printf("%s // %li == %li\n", s.contains(s, "Fer")?"true":"false", s.len, strlen(s.buf));
    String* strs = s.split(s, ' ');

    // for(int i = 0; i < 5; i++)
    //     printf("%s\n", strs[i].buf);


    for(int i = 0; i < 5; i++) 
        destruct(strs[i]);
    
    free(strs);
    destruct(s);
    return 0;
}
