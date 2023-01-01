#include <stdio.h>
#include "header/tests.h"

int main(int argc, char** args) {
    printf("\n========= String Tests =========\n\n");

    printf("Trim test:        |  %s  |\n", trim_test() ? "true :D" : "false :d");
    printf("Replace test:     |  %s  |\n", replace_test() ? "true :D" : "false :d");
    printf("Cut test:         |  %s  |\n", cut_test() ? "true :D" : "false :d");
    printf("Copy test:        |  %s  |\n", copy_test() ? "true :D" : "false :d");
    printf("Upper test:       |  %s  |\n", upper_test() ? "true :D" : "false :d");
    printf("Lower test:       |  %s  |\n", lower_test() ? "true :D" : "false :d");
    printf("Title test:       |  %s  |\n", title_test() ? "true :D" : "false :d");
    printf("Captalize test:   |  %s  |\n", captalize_test() ? "true :D" : "false :d");
    printf("Sub-String test:  |  %s  |\n", substr_test() ? "true :D" : "false :d");
    printf("Split test:       |  %s  |\n", split_test() ? "true :D" : "false :d");
    printf("Equals test:      |  %s  |\n", equals_test() ? "true :D" : "false :d");
    printf("Contains test:    |  %s  |\n", contains_test() ? "true :D" : "false :d");
    printf("Compare To test:  |  %s  |\n", compareTo_test() ? "true :D" : "false :d");
    printf("Length test:      |  %s  |\n\n", length_test() ? "true :D" : "false :d");

    return 0;
}
