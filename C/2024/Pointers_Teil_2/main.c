#include <stdio.h>
#include <stdlib.h>
#include <time.h>

int *getRandomNums(unsigned int n) {
    int *array = malloc(n * sizeof(int));
    if (array == NULL) {
        printf("Speicher konnte nicht reserviert werden.\n");
        return NULL;
    }

    srand(time(NULL));


    for (int i = 0; i < n; i++) {
        array[i] = (rand() % 101);
    }

    return array;
}

int main() {
    unsigned int n = 10;
    int *randomNumbers = getRandomNums(n);

    if (randomNumbers != NULL) {
        printf("Random Zahlen:\n");
        for (int i = 0; i < n; i++) {
            printf("%d ", randomNumbers[i]);
        }
        printf("\n");
        free(randomNumbers);
    }

    return 0;
}
