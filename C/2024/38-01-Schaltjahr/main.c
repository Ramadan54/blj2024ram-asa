#include <stdio.h>

int isLeapYear(int year);
int daysInMonth(int month, int year);
void printDateInfo(int month, int year);

int main() {
    int month = 2;
    int year = 2000;
    // todo get user input for month and year
    // todo third
    scanf ("%d", &month);
    scanf ("%d", &year);
    printDateInfo(month, year);
    return 0;
}

int isLeapYear(int year) {
    // todo first
    // returns 1 if isLeapYear
    // returns 0 if is no LeapYear
        if (year % 4 == 0) {
        // jahr ist durch vier teilbar
        if (year % 100 == 0) {
        if (year % 400 == 0) {
                return 1;
            }
        }

    }
    else {
        //ist kein schaltjahr
        return 0;
    }
}

int daysInMonth(int month, int year) {
    // to do second
    // returns 30, 31, 28 or 29
    if (month == 2 && isLeapYear(year)) {
        return 29;
    }
    if (month == 2) {
        return 28;
    }
    if (month == 4 || month == 6 || month == 9 || month == 11) {
        return 30;
    }
    return 31;

}


void printDateInfo(int month, int year){
    int days = daysInMonth(month, year);

    printf("Der Monat %d hat im Jahr %d %d Tage. \n", month, year, days);

    printf("Das Jahr %d ist ", year);
    if(!isLeapYear(year)){
        printf("kein ");
    }else{
        printf("ein ");
    }
    printf("Schaltjahr. \n");
}