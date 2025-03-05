#include <stdio.h>
#define REIHE 3
#define SPALTE 3

void ticTacToeAusgabe(char tictactoe[REIHE][SPALTE]);
int validerZug(char tictactoe[REIHE][SPALTE], int reihe, int spalte);
int main(void) {
    char tictactoe[REIHE][SPALTE]= {{0,0,0},{0,0,0},{0,0,0}};
    int spieler = 1;
    int reihe, spalte, zuege = 0;
    while(zuege < REIHE * SPALTE) {
        printf("Gebe dein Move ein Reihe und Spalte");
        scanf("%d %d",&reihe, &spalte);
        if(validerZug(tictactoe, reihe, spalte)) {
            zuege++;
            tictactoe[reihe][spalte] = spieler;
            ticTacToeAusgabe(tictactoe);
            spieler = (1 == spieler) ? 2 : 1;
        }else {
            printf("Ungueltige Eingabe\n");
        }
    }

    return 0;
}

void ticTacToeAusgabe(char tictactoe[REIHE][SPALTE]) {
    for (int i = 0; i < REIHE; ++i) {
        for (int j = 0; j < SPALTE; j++) {
            printf(" %d", tictactoe[i][j]);
        }
        printf("\n");
    }
}

int validerZug(char tictactoe[REIHE][SPALTE], int reihe, int spalte) {
    return reihe >= 0 && reihe < REIHE && spalte >= 0 && spalte < SPALTE && tictactoe[reihe][spalte]==0;

}
