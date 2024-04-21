#include <stdio.h>
#include <stdlib.h>

void sort(int arr[], int n) {
    int temp;
    for (int i = 0; i < n; i++) {
        for (int j = i + 1; j < n; j++) {
            if (arr[i] > arr[j]) {
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
    }
}

void SCAN(int arr[], int head, char direction, int total_blocks) {
    int seek_sequence[total_blocks];
    int seek_count = 0;
    int distance = 0;
    int cur_track = head;
    int left[total_blocks], right[total_blocks];
    int left_count = 0, right_count = 0;

    for (int i = 0; i < total_blocks; i++) {
        if (arr[i] < head)
            left[left_count++] = arr[i];
        else if (arr[i] > head)
            right[right_count++] = arr[i];
    }

    sort(left, left_count);
    sort(right, right_count);

    if (direction == 'L') {
        for (int i = left_count - 1; i >= 0; i--) {
            cur_track = left[i];
            seek_sequence[seek_count++] = cur_track;
            distance = abs(cur_track - head);
            head = cur_track;
        }

        seek_count += abs(head - right[0]);
        head = right[0];

        for (int i = 0; i < right_count; i++) {
            cur_track = right[i];
            seek_sequence[seek_count++] = cur_track;
            distance = abs(cur_track - head);
            head = cur_track;
        }
    }
    else if (direction == 'R') {
        for (int i = 0; i < right_count; i++) {
            cur_track = right[i];
            seek_sequence[seek_count++] = cur_track;
            distance = abs(cur_track - head);
            head = cur_track;
        }

        seek_count += abs(head - left[left_count - 1]);
        head = left[left_count - 1];

        for (int i = left_count - 1; i >= 0; i--) {
            cur_track = left[i];
            seek_sequence[seek_count++] = cur_track;
            distance = abs(cur_track - head);
            head = cur_track;
        }
    }

    printf("Seek Sequence: ");
    for (int i = 0; i < seek_count; i++) {
        printf("%d ", seek_sequence[i]);
    }
    printf("\n");
    printf("Total Seek Count: %d\n", seek_count);
}

int main() {
    int total_blocks;
    printf("Enter the total number of disk blocks: ");
    scanf("%d", &total_blocks);

    int arr[total_blocks];
    printf("Enter the disk request string (comma-separated numbers): ");
    for (int i = 0; i < total_blocks; i++) {
        scanf("%d", &arr[i]);
    }

    int starting_head;
    printf("Enter the starting head position: ");
    scanf("%d", &starting_head);

    char direction;
    printf("Enter the direction (L/R): ");
    scanf(" %c", &direction);

    SCAN(arr, starting_head, direction, total_blocks);

    return 0;
}
