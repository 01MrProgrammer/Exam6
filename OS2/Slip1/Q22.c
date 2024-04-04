#include <stdio.h>
#include <stdlib.h>

int main() {
    int total_blocks, i, head, temp, seek_count = 0;
    int *req_list;

    printf("Enter the total number of disk blocks: ");
    scanf("%d", &total_blocks);

    req_list = (int *)malloc(total_blocks * sizeof(int));

    printf("Enter the disk request string (separated by spaces):\n");
    for (i = 0; i < total_blocks; i++) {
        scanf("%d", &req_list[i]);
    }

    printf("Enter the initial head position: ");
    scanf("%d", &head);

    printf("Request Processing Order:\n");
    printf("%d ", head); // Print initial head position

    for (i = 0; i < total_blocks; i++) {
        seek_count += abs(req_list[i] - head);
        head = req_list[i];
        printf("%d ", head);
    }

    printf("\nTotal head movements: %d\n", seek_count);

    free(req_list);
    return 0;
}