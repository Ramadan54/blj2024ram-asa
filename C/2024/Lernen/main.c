#include <stdio.h>

int main(void) {
    char* reciver[234];
    int Anhang = 2;
    char* greeting = "Sehr geehrter";
    int gender = 2;

    printf("An wen ist der Brief gerichtet? ");


    scanf ("%[^\n]", &reciver);

    printf("Ich schreibe an (1) Eine Frau (2) einen Mann");
    scanf("%d", &gender);

    if (gender == 1) {
        greeting = "Sehr geehrte";
    }

    printf("%s %s \n\n", greeting, reciver);


    printf("Hiermit übermittle ich Ihnen die notwenigen Papiere\n\n");

    printf("Liebe Grüsse\n\n");

    printf("Anhänge %d", Anhang);


    return 0;
}
