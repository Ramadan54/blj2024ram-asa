#include <stdio.h>

int compare(const void *a, const void *b) {
    const int *valA = a;
    const int *valB = b;
    return *valA - *valB;
}

void qsort(int * arr, int size, unsigned long long size1, int(* compare)(const void *a, const void *b));

int main() {
    int arr[] = {12, 35, 77, 78, 199, 10000};
    int size = sizeof(arr) / sizeof(arr[0]);


    qsort (arr, size, sizeof(arr[0]), compare);

    for (int i = 0; i < size; i++) {
        printf("%d ", arr[i]);
    }
    return 0;
}

int binarySearch(int arr[], int left, int right, int key) {


    while (left <= right) {

        int mid = left + (right - left) / 2;

        if (arr[mid] == key) {
            return mid;
        }

        if (arr[mid] < key) {
            left = mid + 1;
        }

        else {
            right = mid - 1;
        }
    }

    return -1;
}

int Main() {
    int arr[] = {2, 5, 8, 12, 16, 23, 38, 56, 72, 91};
    int size = sizeof(arr) / sizeof(arr[0]);


    int key = 23;

    int result = binarySearch(arr, 0, size - 1, key);
    if (result == -1) {
        printf("Element ist im Array nicht vorhanden");
    }
    else {
        printf("Element ist im Index vorhanden %d", result);
    }
    return 0;
}