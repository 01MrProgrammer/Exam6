#include <stdio.h>

#define MAX_PROCESSES 10
#define MAX_RESOURCES 10

int allocation[MAX_PROCESSES][MAX_RESOURCES];
int max[MAX_PROCESSES][MAX_RESOURCES];
int need[MAX_PROCESSES][MAX_RESOURCES];
int available[MAX_RESOURCES];
int num_processes, num_resources;

void acceptAvailable() {
    printf("Enter the number of resources: ");
    scanf("%d", &num_resources);

    printf("Enter the available resources: ");
    for (int i = 0; i < num_resources; i++) {
        scanf("%d", &available[i]);
    }
}

void displayAllocationMax() {
    printf("\nAllocation Matrix:\n");
    for (int i = 0; i < num_processes; i++) {
        for (int j = 0; j < num_resources; j++) {
            printf("%d ", allocation[i][j]);
        }
        printf("\n");
    }

    printf("\nMax Matrix:\n");
    for (int i = 0; i < num_processes; i++) {
        for (int j = 0; j < num_resources; j++) {
            printf("%d ", max[i][j]);
        }
        printf("\n");
    }
}

void displayNeedMatrix() {
    printf("\nNeed Matrix:\n");
    for (int i = 0; i < num_processes; i++) {
        for (int j = 0; j < num_resources; j++) {
            printf("%d ", need[i][j]);
        }
        printf("\n");
    }
}

void displayAvailable() {
    printf("\nAvailable Resources:\n");
    for (int i = 0; i < num_resources; i++) {
        printf("%d ", available[i]);
    }
    printf("\n");
}

int main() {
    printf("Enter the number of processes: ");
    scanf("%d", &num_processes);

    printf("Enter Allocation Matrix:\n");
    for (int i = 0; i < num_processes; i++) {
        for (int j = 0; j < num_resources; j++) {
            scanf("%d", &allocation[i][j]);
        }
    }

    printf("Enter Max Matrix:\n");
    for (int i = 0; i < num_processes; i++) {
        for (int j = 0; j < num_resources; j++) {
            scanf("%d", &max[i][j]);
            need[i][j] = max[i][j] - allocation[i][j];
        }
    }

    int choice;
    do {
        printf("\nMenu:\n");
        printf("1. Accept Available\n");
        printf("2. Display Allocation, Max\n");
        printf("3. Display the contents of need matrix\n");
        printf("4. Display Available\n");
        printf("5. Exit\n");
        printf("Enter your choice: ");
        scanf("%d", &choice);

        switch (choice) {
            case 1:
                acceptAvailable();
                break;
            case 2:
                displayAllocationMax();
                break;
            case 3:
                displayNeedMatrix();
                break;
            case 4:
                displayAvailable();
                break;
            case 5:
                printf("Exiting...\n");
                break;
            default:
                printf("Invalid choice! Please try again.\n");
        }
    } while (choice != 5);

    return 0;
}
