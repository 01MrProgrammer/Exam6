#include <stdio.h>
#include <stdbool.h>

#define MAX_PROCESSES 10
#define MAX_RESOURCES 10

int available[MAX_RESOURCES];
int allocation[MAX_PROCESSES][MAX_RESOURCES];
int max_requirement[MAX_PROCESSES][MAX_RESOURCES];
int need[MAX_PROCESSES][MAX_RESOURCES];
int m, n;

// Function to calculate the need matrix
void calculate_need() {
    for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
            need[i][j] = max_requirement[i][j] - allocation[i][j];
        }
    }
}

// Function to check if the request can be granted immediately
bool is_safe(int process, int request[]) {
    // Check if request is less than or equal to need
    for (int i = 0; i < n; i++) {
        if (request[i] > need[process][i]) {
            return false;
        }
    }

    // Check if request is less than or equal to available
    for (int i = 0; i < n; i++) {
        if (request[i] > available[i]) {
            return false;
        }
    }

    return true;
}

int main() {
    // Accept number of processes and resource types
    printf("Enter the number of processes: ");
    scanf("%d", &m);
    printf("Enter the number of resource types: ");
    scanf("%d", &n);

    // Accept available instances for each resource type
    printf("Enter the number of instances for each resource type:\n");
    for (int i = 0; i < n; i++) {
        printf("Resource type %d: ", i);
        scanf("%d", &available[i]);
    }

    // Accept allocation matrix
    printf("Enter the allocation matrix:\n");
    for (int i = 0; i < m; i++) {
        printf("For process %d: ", i);
        for (int j = 0; j < n; j++) {
            scanf("%d", &allocation[i][j]);
        }
    }

    // Accept maximum requirement matrix
    printf("Enter the maximum requirement matrix:\n");
    for (int i = 0; i < m; i++) {
        printf("For process %d: ", i);
        for (int j = 0; j < n; j++) {
            scanf("%d", &max_requirement[i][j]);
        }
    }

    // Calculate the need matrix
    calculate_need();

    // Display the need matrix
    printf("Need matrix:\n");
    for (int i = 0; i < m; i++) {
        printf("For process %d: ", i);
        for (int j = 0; j < n; j++) {
            printf("%d ", need[i][j]);
        }
        printf("\n");
    }

    // Check if a given request can be granted immediately
    int process;
    printf("Enter the process for which request is made: ");
    scanf("%d", &process);

    int request[MAX_RESOURCES];
    printf("Enter the request for process %d: ", process);
    for (int i = 0; i < n; i++) {
        scanf("%d", &request[i]);
    }

    if (is_safe(process, request)) {
        printf("Request can be granted immediately.\n");
    } else {
        printf("Request cannot be granted immediately.\n");
    }

    return 0;
}
