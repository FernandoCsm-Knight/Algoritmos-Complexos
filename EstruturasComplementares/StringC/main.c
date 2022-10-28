
#include "header/mystring.h"

int main(int argc, char **args) {
    String s = createStr("                                                                                      aldknaskldnaslkndasn  askdl nkal nalsnd asndlkansdlk nsaln alsnl asnlkd asnkl dnaslkdn lkandlas n                        ");
    printf("%s\n", s.buf);
    printf("%i, %i\n", s.equals(s, "Ola"), s.length(s));
    s.trim(&s);
    printf("%s\n", s.buf);
    return 0;
}
