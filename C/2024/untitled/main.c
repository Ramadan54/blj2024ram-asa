#include <stdio.h>

void Rechnung();

int main(void) {
    Rechnung();
}

void exit(int i);

void Rechnung() {
    int anzahlPrufungen = 0;
    float maxPunkte, erreichtePunkte, notensumme = 0.0;

    printf("Willkommen zum Notenrechner \n");
    printf("Gib deine Anzahl Test ein: \n");
    scanf("%d", &anzahlPrufungen);

    for (int i = 0; i < anzahlPrufungen; i++) {
        printf("\nPruefung %d: \n", i + 1);

        printf("Maximal Punkte: \n");
        scanf("%f", &maxPunkte);

        printf("Erreichte Punkte: \n");
        scanf("%f", &erreichtePunkte);

        if (erreichtePunkte > maxPunkte) {
            printf("Es ist nicht moeglich mehr Punkte zu erreichen, als die maximale Anzahl von Punkten!");
            exit(1);
        }

        float note = 5 / maxPunkte * erreichtePunkte + 1;
        float prozent = 100 / maxPunkte * erreichtePunkte;

        printf("Die Noten für diese Prüfung ist : %.1f\n", note);
        printf("Die Prozentzahl: %.1f\n", prozent);

        notensumme += note;
    }

    float durchschnitt = notensumme / anzahlPrufungen;
    printf("Der Durchschnitt aller Noten ist: %.2f\n", durchschnitt);

    exit(1);

}