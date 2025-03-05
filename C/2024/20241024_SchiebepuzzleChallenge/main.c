#include <stdio.h>
#include "utils.h"

#define FIELD_SIZE 4


int main(void) {
    int field[FIELD_SIZE][FIELD_SIZE] = {
        { 0, 15,  1, 13},
        { 8,  5,  2,  3},
        {14,  7,  4,  9},
        {10, 11,  6, 12},
    };
    int input = 0;
    int x = 0, y = 0;

    do {
        printField(FIELD_SIZE, field);
        scanf("%d", &input);


        switch (input) {
            case 1:
                if (y < FIELD_SIZE - 1) {
                    swapValues(&field[x][y], &field[x][y + 1]);
                    y++;
                } else {
                    printf("Dein Zug ist nicht möglich Brudi");
                }
            break;
            case 2:
                if (x < FIELD_SIZE - 1) {
                    swapValues(&field[x][y], &field[x + 1][y]);
                    x++;
                } else {
                    printf("Dein Zug ist nicht möglich Brudi");
                }
            break;
            case 3:
                if (x > 0) {
                    swapValues(&field[x][y], &field[x - 1][y]);
                    x--;
                } else {
                    printf("Dein Zug ist nicht möglich Brudi");
                }
            break;
            case 4:
                if (y > 0) {
                    swapValues(&field[x][y], &field[x][y - 1]);
                    y--;
                } else {
                    printf("Dein Zug ist nicht möglich Brudi");
                }
            default: ;
        }

    } while (input != 0);
    return 0;
}