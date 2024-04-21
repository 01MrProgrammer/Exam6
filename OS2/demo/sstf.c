#include <stdio.h>
#include <stdlib.h>
#include <limits.h>

// Function to calculate the absolute difference between two numbers
int absDiff(int a, int b) {
    return abs(a - b);
}

// Function to find the index of the nearest track from the current head position
int findNearestTrack(int tracks[], int n, int head, int visited[]) {
    int minDist = INT_MAX;
    int index = -1;

    for (int i = 0; i < n; i++) {
        if (!visited[i]) {
            int dist = absDiff(tracks[i], head);
            if (dist < minDist) {
                minDist = dist;
                index = i;
            }
        }
    }

    return index;
}

int main() {
    int total_blocks, head, seek_count = 0;

    printf("Enter the total number of disk blocks: ");
    scanf("%d", &total_blocks);

    int *req_list = (int *)malloc(total_blocks * sizeof(int));
    int *visited = (int *)calloc(total_blocks, sizeof(int));

    printf("Enter the disk request string (separated by spaces):\n");
    for (int i = 0; i < total_blocks; i++) {
        scanf("%d", &req_list[i]);
    }

    printf("Enter the initial head position: ");
    scanf("%d", &head);

    printf("Request Processing Order:\n");
    printf("%d ", head); // Print initial head position

    int currentTrack = head;
    for (int i = 0; i < total_blocks; i++) {
        int nextTrack = findNearestTrack(req_list, total_blocks, currentTrack, visited);
        visited[nextTrack] = 1;
        seek_count += absDiff(req_list[nextTrack], currentTrack);
        currentTrack = req_list[nextTrack];
        printf("%d ", currentTrack);
    }

    printf("\nTotal head movements: %d\n", seek_count);

    free(req_list);
    free(visited);
    return 0;
}
