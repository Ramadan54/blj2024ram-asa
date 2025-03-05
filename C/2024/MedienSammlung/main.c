#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef enum {
    BUCH,
    FILM,
    GAME,
    MUSIK
} Medientyp;

typedef struct medium {
    Medientyp type;
    char titel[50 + 1];
    char autor[50 + 1];
    int erscheinungsjahr;
} TMedium;

const char *medientyp(Medientyp typ);

int main(void) {
    TMedium *salmo = malloc(20 * sizeof(TMedium));
    salmo[0].type = BUCH;
    salmo[0].erscheinungsjahr = 2009;
    strcpy(salmo[0].titel, "LOTR");
    strcpy(salmo[0].autor, "Ramadan");

    salmo[1].type = FILM;
    salmo[1].erscheinungsjahr = 1998;
    strcpy(salmo[1].titel, "beayri");
    strcpy(salmo[1].autor, "Ramadan");

    salmo[2].type = GAME;
    salmo[2].erscheinungsjahr = 2011;
    strcpy(salmo[2].titel, "karivogel");
    strcpy(salmo[2].autor, "Ramadan");

    salmo[3].type = MUSIK;
    salmo[3].erscheinungsjahr = 2000;
    strcpy(salmo[3].titel, "LÖLÖ");
    strcpy(salmo[3].autor, "Ramadan");


    printf("Medienbibliothek\n");
    for (int i = 0; i < 4; ++i) {
        printf("--------------------------------------\n");
        printf("Typ: %d\n", salmo[i].type);
        printf("Erscheinungsjahr: %d\n", salmo[i].erscheinungsjahr);
        printf("Titel: %s\n", salmo[i].titel);
        printf("Autor: %s\n", salmo[i].autor);
    }
}

const char *medientyp(Medientyp typ) {
    switch (typ) {
        case BUCH:
            return "BUCH";
        case FILM:
            return "FILM";
        case GAME:
            return "GAME";
        case MUSIK:
            return "MUSIK";
        default:
            return "UNBEKANNT";
    }
}


