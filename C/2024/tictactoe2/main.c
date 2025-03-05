#include <stdio.h>

#define SIZE 3


void spielfeldAnzeigen(int feld[SIZE][SIZE]) {
    for (int i = 0; i < SIZE; i++) {
        for (int j = 0; j < SIZE; j++) {
            printf("%d ", feld[i][j]);
        }
        printf("\n");
    }
}
int main() {
    int feld[SIZE][SIZE] = {0};
    int x, y, value;

    while (1) {

        spielfeldAnzeigen(feld);


        printf("Gib die Koordinaten x ein! (0 bis 2): ");
        scanf("%d", &x);
        printf("Gib die Koordinate y ein! (0 bis 2): ");
        scanf("%d", &y);
        printf("Gib die Zahl ein 1 oder 2: ");
        scanf("%d", &value);

        if (feld[x][y] != 0) {
            printf("Wähle bitte eine verfuegbare Position.\n");

        } else {
            feld[x][y] = value;
        }
    }

    return 0;
}
