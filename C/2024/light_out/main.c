/*Light_out
 *31.10.2024
 *Dieses Spiel erzeugt ein zufälliges
 Gitter aus an- und ausgeschalteten Lichtern, bei dem der Spieler durch Eingabe von
 Koordinaten Lichter umschalten kann, bis er das Spiel beendet.
 */


#include <stdio.h>
#include <stdlib.h>
#include <time.h>

#define SIZE 5

void generateGrid(int grid[SIZE][SIZE]) {
    srand(time(NULL)); //random zahlen und setz die Zeit auf jetz um
    for (int i = 0; i < SIZE; i++) {
        for (int j = 0; j < SIZE; j++) {
            grid[i][j] = rand() % 2; // zufälliges Licht, teilt durch 2 damit der Restwert nur 0/1 sein kann
        }
    }
}

void printGrid(int grid[SIZE][SIZE]) {
    printf("Versuche es es zu loesen!:\n");
    for (int i = 0; i < SIZE; i++) {
        for (int j = 0; j < SIZE; j++) {
            printf("%d ", grid[i][j]);
        }
        printf("\n");
    }
}

void switchLight(int grid[SIZE][SIZE], int row, int col) {
    if (row >= 0 && row < SIZE && col >= 0 && col < SIZE) {
        grid[row][col] = !grid[row][col]; // Licht umschalten
    }
}

int main() {
    int grid[SIZE][SIZE];
    int row, col;

    generateGrid(grid);
    printGrid(grid);

    while (1) {
        printf("\nGib die Zeile und Spalte ein, die du umschalten moechtest (0 steht fuer licht aus/ 1 steht fuer licht an)\n\n");
        printf("(oder -1 -1 zum Beenden):");
        scanf("%d %d", &row, &col); //für Zeilen/Spalten

            printf("Programm beendet.\n");
        if (row == -1 && col == -1) {
            break;
        }

        switchLight(grid, row, col);
        printGrid(grid);
    }

    return 0;
}
