#include <sys/types.h>
#include <sys/stat.h>
#include <unistd.h>
#include <stdio.h>

int main() {
    struct stat st = {0};
    
    if(stat("./obj", &st) == -1) {
        mkdir("obj", 0700);
        printf("The directory obj has been created\n");
    } else 
        printf("The directory obj already exists\n");

    if(stat("./bin", &st)) {
        mkdir("bin", 0700);
        printf("The directory bin has been created\n");
    } else    
        printf("The directory bin already exists\n");

    if(stat("./lib", &st)) {
        mkdir("lib", 0700);
        printf("The directory lib has been created\n");
    } else    
        printf("The directory lib already exists\n");

    return 0;
}