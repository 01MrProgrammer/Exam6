#include <stdio.h>

#define MAX_PROCESSES 10
#define MAX_RESOURCES 10

int max[MAX_PROCESSES][MAX_RESOURCES], allocation[MAX_PROCESSES][MAX_RESOURCES], need[MAX_PROCESSES][MAX_RESOURCES];
int available[MAX_RESOURCES];
int np, nr;

void readMatrix(int matrix[10][10], int np, int nr) {
    printf("\nEnter the matrix:\n");
    for (int i = 0; i < np; i++) {
        printf("P%d: ", i);
        for (int j = 0; j < nr; j++) {
            scanf("%d", &matrix[i][j]);
        }
    }
}

void displayMatrix(int matrix[10][10], int np, int nr) {
    for (int i = 0; i < np; i++) {
        printf("\nP%d: ", i);
        for (int j = 0; j < nr; j++) {
            printf("%d ", matrix[i][j]);
        }
    }
}

void calculateNeed() {
    for (int i = 0; i < np; i++) {
        for (int j = 0; j < nr; j++) {
            need[i][j] = max[i][j] - allocation[i][j];
        }
    }
}

void banker() {
    int finish[MAX_PROCESSES] = {0};
    int safeSeq[MAX_PROCESSES], k = 0;

    int work[MAX_RESOURCES];
    for (int i = 0; i < nr; i++) {
        work[i] = available[i];
    }

    for (int i = 0; i < np; i++) {
        if (finish[i] == 0) {
            int flag = 0;
            for (int j = 0; j < nr; j++) {
                if (need[i][j] > work[j]) {
                    flag = 1;
                    break;
                }
            }
            if (flag == 0) {
                safeSeq[k++] = i;
                finish[i] = 1;
                for (int j = 0; j < nr; j++) {
                    work[j] += allocation[i][j];
                }
                i = -1;
            }
        }
    }

    int isSafe = 1;
    for (int i = 0; i < np; i++) {
        if (finish[i] == 0) {
            isSafe = 0;
            break;
        }
    }

    if (isSafe) {
        printf("\nThe system is in a safe state.\nSafe sequence is: ");
        for (int i = 0; i < np; i++) {
            printf("P%d ", safeSeq[i]);
        }
    } else {
        printf("\nThe system is in a deadlock.");
    }
}

void displayAvailable() {
    printf("\nAvailable Resources: ");
    for (int i = 0; i < nr; i++) {
        printf("%d ", available[i]);
    }
    printf("\n");
}

int main() {
    int choice;

    printf("Enter the Number of Processes: ");
    scanf("%d", &np);
    printf("Enter the Number of Resources: ");
    scanf("%d", &nr);

    printf("\nEnter initial allocation matrix:\n");
    readMatrix(allocation, np, nr);

    printf("\nEnter maximum requirement matrix:\n");
    readMatrix(max, np, nr);

    printf("\nEnter the available resources:\n");
    for (int i = 0; i < nr; i++) {
        scanf("%d", &available[i]);
    }

    calculateNeed();

    do {
        printf("\n\nMenu:\n");
        printf("1. Display Allocation and Maximum Matrices\n");
        printf("2. Display Need Matrix\n");
        printf("3. Display Available Matrix\n");
        printf("4. Run Banker's Algorithm\n");
        printf("5. Exit\n");
        printf("Enter your choice: ");
        scanf("%d", &choice);

        switch (choice) {
            case 1:
                printf("\nInitial Allocation Matrix:\n");
                displayMatrix(allocation, np, nr);
                printf("\n\nMaximum Requirement Matrix:\n");
                displayMatrix(max, np, nr);
                break;
            case 2:
                printf("\nNeed Matrix:\n");
                displayMatrix(need, np, nr);
                break;
            case 3:
                displayAvailable();
                break;
            case 4:
                banker();
                break;
            case 5:
                printf("\nExiting...\n");
                break;
            default:
                printf("\nInvalid choice! Please try again.\n");
        }
    } while (choice != 5);

    return 0;
}
