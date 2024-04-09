#include <stdio.h>
#include <stdlib.h>

// Function to sort the request array
void sort(int *request, int n) {
    for (int i = 0; i < n - 1; i++) {
        for (int j = 0; j < n - i - 1; j++) {
            if (request[j] > request[j + 1]) {
                int temp = request[j];
                request[j] = request[j + 1];
                request[j + 1] = temp;
            }
        }
    }
}

// Function to find total head movements
int calculateHeadMovements(int *request, int n, int head, int right) {
    int totalHeadMovements = 0;

    // Find the index of the smallest element larger than or equal to head
    int startIndex = 0;
    for (int i = 0; i < n; i++) {
        if (request[i] >= head) {
            startIndex = i;
            break;
        }
    }

    // Calculate head movements in the right direction
    if (right) {
        for (int i = startIndex; i < n; i++) {
            totalHeadMovements += abs(head - request[i]);
            head = request[i];
        }
    }
    // Calculate head movements in the left direction
    else {
        for (int i = startIndex - 1; i >= 0; i--) {
            totalHeadMovements += abs(head - request[i]);
            head = request[i];
        }
    }

    return totalHeadMovements;
}

int main() {
    int n, head;
    char direction;
    printf("Enter the total number of disk blocks: ");
    scanf("%d", &n);

    // Dynamically allocate memory for the request array
    int *request = (int *)malloc(n * sizeof(int));

    printf("Enter the disk request string:\n");
    for (int i = 0; i < n; i++) {
        scanf("%d", &request[i]);
    }

    printf("Enter the starting head position: ");
    scanf("%d", &head);

    printf("Enter the direction (R for right, L for left): ");
    scanf(" %c", &direction);

    printf("Starting Head Position: %d\n", head);
    printf("Direction: %c\n", direction);

    // Sort the request array
    sort(request, n);

    // Display the list of requests in the order in which they are served
    printf("Order of requests served:\n");
    if (direction == 'R' || direction == 'r') {
        for (int i = 0; i < n; i++) {
            printf("%d ", request[i]);
        }
    } else if (direction == 'L' || direction == 'l') {
        for (int i = n - 1; i >= 0; i--) {
            printf("%d ", request[i]);
        }
    }
    printf("\n");

    // Calculate total head movements
    int totalHeadMovements = calculateHeadMovements(request, n, head, (direction == 'R' || direction == 'r'));
    printf("Total number of head movements: %d\n", totalHeadMovements);

    // Free dynamically allocated memory
    free(request);

    return 0;
}
