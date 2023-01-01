#include "header/mystring.h"
#include "string.h"

//=====TRIM=====//
bool trim_test() {
    String s = createStr("   Fernando Campos Silva Dal Maria     ");
    s.trim(&s);

    bool value = s.len == strlen(s.buf);
    value &= strcmp(s.buf, "Fernando Campos Silva Dal Maria") == 0;

    destruct(s);
    return value;
}

//=====REPLACE=====//
bool replace_test() {
    String s = createStr(" aaaabbbbababababakdbdqwyahhvcjasowebcj");
    s.replace(&s, 'a', 'P');

    bool value = s.len == strlen(s.buf);
    value &= strcmp(s.buf, " PPPPbbbbPbPbPbPbPkdbdqwyPhhvcjPsowebcj") == 0;

    destruct(s);
    return value; 
}

//=====CUT=====//
bool cut_test() {
    String s = createStr(" aaaabbbbababababakdbdqwyahhvcjasowebcj");
    s.cut(&s, 'a');

    bool value = s.len == strlen(s.buf);
    value &= strcmp(s.buf, " bbbbbbbbkdbdqwyhhvcjsowebcj") == 0;

    destruct(s);
    return value; 
}

//=====COPY=====//
bool copy_test() {
    String s = createStr("Fernando");
    s.lcopy(&s, "Fernando Campos Silva Dal Maria");

    bool value = s.len == strlen(s.buf);
    value &= strcmp(s.buf, "Fernando Campos Silva Dal Maria") == 0;

    destruct(s);
    return value; 
}

//=====UPPER=====//
bool upper_test() {
    String s = createStr(" Fernando Campos Silva Dal Maria 0123456789! ");
    s.upper(&s);

    bool value = s.len == strlen(s.buf);
    value &= strcmp(s.buf, " FERNANDO CAMPOS SILVA DAL MARIA 0123456789! ") == 0;

    destruct(s);
    return value; 
}

//=====LOWER=====//
bool lower_test() {
    String s = createStr(" Fernando Campos Silva Dal Maria 0123456789! ");
    s.lower(&s);

    bool value = s.len == strlen(s.buf);
    value &= strcmp(s.buf, " fernando campos silva dal maria 0123456789! ") == 0;

    destruct(s);
    return value; 
}

//=====TITLE=====//
bool title_test() {
    String s = createStr(" fernando campos silva dal maria 0123456789! ");
    s.title(&s);

    bool value = s.len == strlen(s.buf);
    value &= strcmp(s.buf, " Fernando Campos Silva Dal Maria 0123456789! ") == 0;

    destruct(s);
    return value; 
}

//=====CAPTALIZE=====//
bool captalize_test() {
    String s = createStr(" fernando CAMPOS Silva dal MaRiA 0123456789! ");
    s.captalize(&s);

    bool value = s.len == strlen(s.buf);
    value &= strcmp(s.buf, " Fernando campos silva dal maria 0123456789! ") == 0;

    destruct(s);
    return value; 
}

//=====CLEAR=====//
bool clear_test() {
    String s = createStr("Fernando Campos Silva Dal Maria");
    s.clear(&s);

    bool value = s.len == strlen(s.buf);
    value &= strcmp(s.buf, "") == 0; 

    destruct(s);
    return value;
}

//=====SUBSTR=====//
bool substr_test() {
    String s = createStr(" Fernando Campos Silva Dal Maria 0123456789! ");
    String str = s.substr(s, 0, 33);

    bool value = str.len == strlen(str.buf) && s.len == strlen(s.buf);
    value &= strcmp(s.buf, " Fernando Campos Silva Dal Maria 0123456789! ") == 0;
    value &= strcmp(str.buf, " Fernando Campos Silva Dal Maria ") == 0;

    destruct(s);
    destruct(str);
    return value; 
}

//=====CLONE=====//
bool clone_test() {
    String s = createStr(" Fernando Campos Silva Dal Maria 0123456789! ");
    String str = s.clone(s);

    bool value = str.len == strlen(str.buf) && s.len == strlen(s.buf) && str.len == s.len;
    value &= strcmp(s.buf, str.buf) == 0;
    value &= s.buf != str.buf;

    destruct(s);
    destruct(str);
    return value;
}

//=====SPLIT=====//
bool split_test() {
    String s = createStr(" Fernando Campos Silva Dal Maria 0123456789! ");
    String* strs = s.split(s, ' ');
    char* arr[] = {"", "Fernando", "Campos", "Silva", "Dal", "Maria", "0123456789!", ""};

    bool value = s.len == strlen(s.buf);
    for(int i = 0; value && i < 8; i++)
        value = strcmp(arr[i], strs[i].buf) == 0;

    destruct(s);
    for(int i = 0; i < 8; i++)
        destruct(strs[i]);

    free(strs);
    return value; 
}

//=====ISEMPTY=====//
bool isEmpty_test() {
    String s = createStr("");
    bool value = s.isEmpty(s);
    destruct(s);

    s = createStr(NULL);
    value &= s.isEmpty(s);
    destruct(s);

    return value; 
}

//=====EQUALS=====//
bool equals_test() {
    String s = createStr(" fernando CAMPOS Silva dal MaRiA 0123456789! ");
    
    bool value = s.lequals(s, " fernando CAMPOS Silva dal MaRiA 0123456789! ");
    value &= s.len == strlen(s.buf);

    destruct(s);
    return value; 
}

//=====CONTAINS=====//
bool contains_test() {
    String s = createStr(" fernando CAMPOS Silva dal MaRiA 0123456789!FFFEFeFer");
    
    bool value = s.lcontains(s, "fer");
    value &= s.lcontains(s, "A");
    value &= s.lcontains(s, "Fer");
    value &= !s.lcontains(s, "abacaxi");
    value &= s.len == strlen(s.buf);

    destruct(s);
    return value; 
}

//=====STARTS_WITH=====//
bool startsWith_test() {
    String s = createStr("Fernando Campos Silva Dal Maria");

    bool value = s.lstartsWith(s, "Fer");
    value &= s.lstartsWith(s, "Fernando Campos Silva Dal Maria");
    value &= !s.lstartsWith(s, "Campos");
    value &= s.lstartsWith(s, "");
    value &= s.len == strlen(s.buf);

    destruct(s);
    return value;
}

//=====ENDS_WITH=====//
bool endsWith_test() {
    String s = createStr("Fernando Campos Silva Dal Maria");

    bool value = s.lendsWith(s, "ria");
    value &= s.lendsWith(s, "Fernando Campos Silva Dal Maria");
    value &= !s.lendsWith(s, "Campos");
    value &= s.lendsWith(s, "");
    value &= s.len == strlen(s.buf);

    destruct(s);
    return value;
}

//=====COMPARE_TO=====//
bool compareTo_test() {
    String s = createStr("Fernando");
    
    bool value = s.lcompareTo(s, "Fernanda") > 0;
    value &= s.lcompareTo(s, "Fernando") == 0;
    value &= s.lcompareTo(s, "Freire") < 0;
    value &= s.len == strlen(s.buf);

    destruct(s);
    return value; 
}

//=====PARSE_INT=====//
bool parseInt_test() {
    String s = createStr("95721672");
    
    bool value = s.parseInt(s) == atoi(s.buf);
    value &= strcmp(s.buf, "95721672") == 0;
    value &= s.len == strlen(s.buf);

    destruct(s);
    return value; 
}

//=====PARSE_FLOAT=====//
bool parseFloat_test() {
    String s = createStr("48102.24691");

    bool value = s.parseFloat(s) == atof(s.buf); 
    value &= strcmp(s.buf, "48102.24691") == 0;
    value &= s.len == strlen(s.buf);

    destruct(s);
    return value; 
}

//=====LENGTH=====//
bool length_test() {
    String s = createStr("Fernando Campos Silva Dal Maria");
    
    bool value = s.length(s) == strlen(s.buf);
    value &= s.len == strlen(s.buf);

    destruct(s);
    return value; 
}
