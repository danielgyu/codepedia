#include <stdio.h>  //  types, macros, functions for IO

int main() {
    int i = 3;
    printf("Address of i = %p\n", &i);
    printf("Value of i = %d\n", i);
    printf("Value of i = %d\n", *(&i));
    return 0;
}
