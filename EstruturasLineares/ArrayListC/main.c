#include <stdio.h>
#include "header/ArrayList.h"

int main() {
    Strings s;
    alocateStrs(&s, 2);

    add(&s, "Abc");
    add(&s, "Acb");
    add(&s, "Ccc");
    addp(&s, 2, "Csla");
    add(&s, "Aqwemo");
    add(&s, "Aewmk");
    add(&s, "Aqmd");
    printStrs(&s);
    printf("%i\n", s.len);
    printf("%i\n", s.cap);

    printStrs(&s);
    printf("%i\n", s.len);
    printf("%i\n", s.cap);

    quickSort(&s, 0, s.len - 1);

    printStrs(&s);

    freeStrs(&s);
}
