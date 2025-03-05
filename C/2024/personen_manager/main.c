#include <stdio.h>
#include <string.h>

struct person {
    char name[50];
    int geb;
    float kg;
    float cm;
} Person;

struct TClub {
    char topic[20];
    char favteam[30];
} TClub;

void initFamily(struct person family[]);

void printfamily();

void printPerson();

void initTeam();

void printTeam();

void findOldestFamilyMember(struct person family[]);

struct person family[4];
struct TClub member[4];

int main(void) {
    int a = 0;
    initFamily(family);
    initTeam(member);
    printf("1 = ganze familie || 2 = eine Person || 3 = aelteste Person\n");
    scanf("%d", &a);
    switch (a) {
        case 1:
            printfamily();
            break;
        case 2:
            printPerson();
            break;
        case 3:
            findOldestFamilyMember(family);
            break;
        case 4:
            printTeam();
            break;
        default:
            break;
    }

    return 0;
}

void initFamily(struct person family[]) {
    strcpy(family[0].name, "John Doe");
    family[0].geb = 1981;
    family[0].kg = 91.00;
    family[0].cm = 196.00;

    strcpy(family[1].name, "Jane Doe");
    family[1].geb = 1980;
    family[1].kg = 64.00;
    family[1].cm = 178.00;

    strcpy(family[2].name, "Jack Doe");
    family[2].geb = 2008;
    family[2].kg = 40.00;
    family[2].cm = 163.00;

    strcpy(family[3].name, "Judy Doe");
    family[3].geb = 2015;
    family[3].kg = 30.00;
    family[3].cm = 124.00;
}

void initTeam(struct TClub member[]) {
    strcpy(member[0].topic, "Fussball");
    strcpy(member[0].favteam, "Chelsea");

    strcpy(member[1].topic, "Basketball");
    strcpy(member[1].favteam, "Lakers");

    strcpy(member[2].topic, "American Football");
    strcpy(member[2].favteam, "Miami Dolphins");

    strcpy(member[3].topic, "Baseball");
    strcpy(member[3].favteam, "NY Yankees");
}

void printfamily() {
    for (int x = 0; x < 4; x++) {
        printf("%s\n", family[x].name);
        printf("%d\n", family[x].geb);
        printf("%.2f kg\n", family[x].kg);
        printf("%.2f cm\n", family[x].cm);
        printf("\n");
    }
}

void printTeam() {
    for (int x = 0; x < 4; x++) {
        printf("%s seine Lieblings %s Mannschaft ist: %s\n", family[x].name, member[x].topic, member[x].favteam);
    }
}


void printPerson() {
    int x = 0;
    printf("gib eine Zahl zwischen 0-3 ein:");
    scanf("%d", &x);
    if (x > 3 || x < 0) {
        printf("ERROR");
        return;
    }
    printf("%s\n", family[x].name);
    printf("%d\n", family[x].geb);
    printf("%.2f kg\n", family[x].kg);
    printf("%.2f cm\n", family[x].cm);
    printf("\n");
}

void findOldestFamilyMember(struct person family[4]) {
    struct person sort_family[4];
    for (int i = 0; i < 4; i++) {
        sort_family[i] = family[i];
    }

    for (int i = 0; i < 3; i++) {
        for (int j = 0; j < 3 - i; j++) {
            if (sort_family[j].geb > sort_family[j + 1].geb) {
                struct person temp = sort_family[j];
                sort_family[j] = sort_family[j + 1];
                sort_family[j + 1] = temp;
            }
        }
    }

    printf("Die aeltesten Personen nach Reihenfolge:\n");
    for (int i = 0; i < 4; i++) {
        printf("%s ist im Jahr %d geboren\n", sort_family[i].name, sort_family[i].geb);
    }
}
