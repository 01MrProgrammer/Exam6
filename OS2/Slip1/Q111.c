#include <stdio.h>

#define MAX_PROCESSES 5
#define MAX_RESOURCES 3

int available[MAX_RESOURCES];
int allocation[MAX_PROCESSES][MAX_RESOURCES];
int max[MAX_PROCESSES][MAX_RESOURCES];

void accept_available() {
    printf("Enter the available resources:\n");
    for (int i = 0; i < MAX_RESOURCES; i++) {
        printf("Resource %d: ", i);
        scanf("%d", &available[i]);
    }
}

void display_allocation_max() {
    printf("Process\tAllocation\tMax\n");
    for (int i = 0; i < MAX_PROCESSES; i++) {
        printf("P%d\t", i);
        for (int j = 0; j < MAX_RESOURCES; j++) {
            printf("%d ", allocation[i][j]);
        }
        printf("\t\t");
        for (int j = 0; j < MAX_RESOURCES; j++) {
            printf("%d ", max[i][j]);
        }
        printf("\n");
    }
}

void display_need_matrix() {
    printf("Need Matrix:\n");
    printf("Process\tNeed\n");
    for (int i = 0; i < MAX_PROCESSES; i++) {
        printf("P%d\t", i);
        for (int j = 0; j < MAX_RESOURCES; j++) {
            printf("%d ", max[i][j] - allocation[i][j]);
        }
        printf("\n");
    }
}

void display_available() {
    printf("Available Resources: ");
    for (int i = 0; i < MAX_RESOURCES; i++) {
        printf("%d ", available[i]);
    }
    printf("\n");
}

int main() {
    int choice;
    
    // Initialize allocation and max matrices
    int allocation_data[MAX_PROCESSES][MAX_RESOURCES] = {
        {2, 3, 2},
        {4, 0, 0},
        {5, 0, 4},
        {4, 3, 3},
        {2, 2, 4}
    };
    int max_data[MAX_PROCESSES][MAX_RESOURCES] = {
        {9, 7, 5},
        {5, 2, 2},
        {1, 0, 4},
        {4, 4, 4},
        {6, 5, 5}
    };
    
    // Copy data to the allocation and max matrices
    for (int i = 0; i < MAX_PROCESSES; i++) {
        for (int j = 0; j < MAX_RESOURCES; j++) {
            allocation[i][j] = allocation_data[i][j];
            max[i][j] = max_data[i][j];
        }
    }
    
    do {
        printf("\nMenu:\n");
        printf("1. Accept Available Resources\n");
        printf("2. Display Allocation and Max\n");
        printf("3. Display Need Matrix\n");
        printf("4. Display Available Resources\n");
        printf("5. Exit\n");
        printf("Enter your choice: ");
        scanf("%d", &choice);
        
        switch(choice) {
            case 1:
                accept_available();
                break;
            case 2:
                display_allocation_max();
                break;
            case 3:
                display_need_matrix();
                break;
            case 4:
                display_available();
                break;
            case 5:
                printf("Exiting...\n");
                break;
            default:
                printf("Invalid choice. Please enter a valid option.\n");
        }
    } while(choice != 5);
    
    return 0;
}
