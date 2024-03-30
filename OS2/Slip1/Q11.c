#include <stdio.h>

int max[10][10], allocation[10][10], need[10][10];
int avail[10];
int np, nr;

void read_matrix(int matrix[10][10], const char *message) {
    printf("\nEnter %s Matrix:\n", message);
    for (int i = 0; i < np; i++) {
        printf("For Process %d: ", i);
        for (int j = 0; j < nr; j++) {
            scanf("%d", &matrix[i][j]);
        }
    }
}

void display_matrix(int matrix[10][10], const char *message) {
    printf("\n%s Matrix:\n", message);
    for (int i = 0; i < np; i++) {
        printf("P%d: ", i);
        for (int j = 0; j < nr; j++) {
            printf("%d ", matrix[i][j]);
        }
        printf("\n");
    }
}

void calculate_need() {
    for (int i = 0; i < np; i++)
        for (int j = 0; j < nr; j++)
            need[i][j] = max[i][j] - allocation[i][j];
}

void display_available() {
    printf("\nAvailable Resources: ");
    for (int j = 0; j < nr; j++)
        printf("%d ", avail[j]);
    printf("\n");
}

void display_menu() {
    printf("\n***** Menu *****\n");
    printf("a) Accept Available\n");
    printf("b) Display Allocation and Max\n");
    printf("c) Display the contents of Need Matrix\n");
    printf("d) Display Available\n");
    printf("e) Exit\n");
    printf("Enter your choice: ");
}

int main() {
    int choice;
    
    printf("Enter the Number of Processes: ");
    scanf("%d", &np);
    printf("Enter the Number of Resources: ");
    scanf("%d", &nr);
    
    printf("\n");

    read_matrix(allocation, "Allocation");
    read_matrix(max, "Max");

    printf("\nEnter Available Resources:\n");
    for (int j = 0; j < nr; j++)
        scanf("%d", &avail[j]);

    while (1) {
        display_menu();
        scanf(" %c", &choice);

        switch (choice) {
            case 'a':
                printf("\nEnter Available Resources:\n");
                for (int j = 0; j < nr; j++)
                    scanf("%d", &avail[j]);
                break;
            case 'b':
                display_matrix(allocation, "Allocation");
                display_matrix(max, "Max");
                break;
            case 'c':
                calculate_need();
                display_matrix(need, "Need");
                break;
            case 'd':
                display_available();
                break;
            case 'e':
                printf("\nExiting...\n");
                return 0;
            default:
                printf("\nInvalid choice. Please try again.\n");
        }
    }

    return 0;
}
