#include <stdio.h>
#include <stdlib.h>

// Function to simulate FCFS disk scheduling
void FCFS(int arr[], int size, int head) {
    int seek_count = 0;
    int distance, cur_track;

    for (int i = 0; i < size; i++) {
        cur_track = arr[i];
        distance = abs(cur_track - head);
        seek_count += distance;
        head = cur_track;
    }

    printf("Total number of seek operations = %d\n", seek_count);
    printf("Seek Sequence is:\n");
    for (int i = 0; i < size; i++) {
        printf("%d ", arr[i]);
    }
    printf("\n");
}

int main() {
    int arr[] = {55, 58, 39, 18, 90, 160, 150, 38, 284};
    int size = sizeof(arr) / sizeof(arr[0]);
    int head = 50;

    FCFS(arr, size, head);

    return 0;
}
