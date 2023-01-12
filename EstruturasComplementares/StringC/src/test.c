#include <stdio.h>
#include "header/tests.h"

int main() {
    printf("\n========= String Tests =========\n\n");

    printf("Trim test:        |  %s  |\n", trim_test() ? "true :D" : "false :d");
    printf("Concat test:      |  %s  |\n", concat_test() ? "true :D" : "false :d");
    printf("Replace test:     |  %s  |\n", replace_test() ? "true :D" : "false :d");
    printf("Cut test:         |  %s  |\n", cut_test() ? "true :D" : "false :d");
    printf("Copy test:        |  %s  |\n", copy_test() ? "true :D" : "false :d");
    printf("Upper test:       |  %s  |\n", upper_test() ? "true :D" : "false :d");
    printf("Lower test:       |  %s  |\n", lower_test() ? "true :D" : "false :d");
    printf("Title test:       |  %s  |\n", title_test() ? "true :D" : "false :d");
    printf("Captalize test:   |  %s  |\n", captalize_test() ? "true :D" : "false :d");
    printf("Clear test:       |  %s  |\n", clear_test() ? "true :D" : "false :d");
    printf("Sub-String test:  |  %s  |\n", substr_test() ? "true :D" : "false :d");
    printf("Clone test:       |  %s  |\n", clone_test() ? "true :D" : "false :d");
    printf("Split test:       |  %s  |\n", split_test() ? "true :D" : "false :d");
    printf("Is Empty test:    |  %s  |\n", isEmpty_test() ? "true :D" : "false :d");
    printf("Equals test:      |  %s  |\n", equals_test() ? "true :D" : "false :d");
    printf("Contains test:    |  %s  |\n", contains_test() ? "true :D" : "false :d");
    printf("StartsWith test:  |  %s  |\n", startsWith_test() ? "true :D" : "false :d");
    printf("EndsWith test:    |  %s  |\n", endsWith_test() ? "true :D" : "false :d");
    printf("IoBytes test:     |  %s  |\n", toBytes_test() ? "true :D" : "false :d");
    printf("IndexOf test:     |  %s  |\n", indexOf_test() ? "true :D" : "false :d");
    printf("LastIdxOf test:   |  %s  |\n", lastIdxOf_test() ? "true :D" : "false :d");
    printf("Compare To test:  |  %s  |\n", compareTo_test() ? "true :D" : "false :d");
    printf("HashCode test:    |  %s  |\n", hashCode_test() ? "true :D" : "false :d");
    printf("ParseInt test:    |  %s  |\n", parseInt_test() ? "true :D" : "false :d");
    printf("ParseFloat test:  |  %s  |\n", parseFloat_test() ? "true :D" : "false :d");
    printf("Length test:      |  %s  |\n", length_test() ? "true :D" : "false :d");
    printf("Count test:       |  %s  |\n\n", count_test() ? "true :D" : "false :d");

    return 0;
}
