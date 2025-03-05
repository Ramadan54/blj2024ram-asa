#include <stdio.h>
#include <ctype.h>

void makeUppercase(char *p_1) {
    *p_1 = toupper(*p_1);
}

int main(void) {
    char c1 = 'a';
    char c2 = '!';

    makeUppercase(&c1);
    makeUppercase(&c2);

    printf("%c%c", c1, c2);
    return 0;
}
