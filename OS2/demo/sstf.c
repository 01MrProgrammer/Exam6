#include <stdio.h>
#include <stdlib.h>

// Function to calculate absolute difference
int abs_diff(int a, int b) {
    return abs(a - b);
}

int main() {
    int total_blocks, head_position, current_head, min_index, min_distance, seek_count = 0;
    int *requests;

    printf("Enter the total number of disk blocks: ");
    scanf("%d", &total_blocks);

    requests = (int *)malloc(total_blocks * sizeof(int));

    printf("Enter the disk request string (separated by spaces):\n");
    for (int i = 0; i < total_blocks; i++) {
        scanf("%d", &requests[i]);
    }

    printf("Enter the start head position: ");
    scanf("%d", &head_position);

    current_head = head_position;

    printf("Request Processing Order:\n");
    printf("%d ", current_head); // Print initial head position

    for (int i = 0; i < total_blocks; i++) {
        min_distance = abs_diff(requests[0], current_head);
        min_index = 0;

        // Find the closest request
        for (int j = 1; j < total_blocks; j++) {
            if (abs_diff(requests[j], current_head) < min_distance) {
                min_distance = abs_diff(requests[j], current_head);
                min_index = j;
            }
        }

        // Print the request being served
        printf("%d ", requests[min_index]);

        // Update total head movements
        seek_count += min_distance;

        // Update current head position
        current_head = requests[min_index];

        // Mark the request as served
        requests[min_index] = -1;
    }

    printf("\nTotal head movements: %d\n", seek_count);

    free(requests);
    return 0;
}
