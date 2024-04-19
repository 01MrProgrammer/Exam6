#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <time.h>

#define MAX_BLOCKS 100

bool bit_vector[MAX_BLOCKS] = {false};
int disk_size;

// Function to initialize bit vector with random allocation
void initialize_disk() {
    for (int i = 0; i < disk_size; i++) {
        bit_vector[i] = rand() % 2; // Randomly mark some blocks as allocated
    }
}

// Function to display bit vector
void show_bit_vector() {
    printf("Bit Vector (0 for free, 1 for allocated):\n");
    for (int i = 0; i < disk_size; i++) {
        printf("%d ", bit_vector[i]);
    }
    printf("\n");
}

// Function to delete already created file
void delete_file() {
    int start_block, size;
    printf("Enter starting block of the file to delete: ");
    scanf("%d", &start_block);
    printf("Enter size of the file: ");
    scanf("%d", &size);

    // Check if the file can be deleted (if it's already allocated)
    for (int i = start_block; i < start_block + size; i++) {
        if (!bit_vector[i]) {
            printf("Error: Block %d is not allocated. Cannot delete file.\n", i);
            return;
        }
    }

    // Free the blocks allocated to the file
    for (int i = start_block; i < start_block + size; i++) {
        bit_vector[i] = false;
    }
    printf("File deleted successfully.\n");
}

int main() {
    int choice;

    // Seed random number generator based on current time
    srand(time(NULL));

    printf("Enter the number of blocks in the disk: ");
    scanf("%d", &disk_size);

    initialize_disk();

    do {
        printf("\nMenu:\n");
        printf("1. Show Bit Vector\n");
        printf("2. Delete already created file\n");
        printf("3. Exit\n");
        printf("Enter your choice: ");
        scanf("%d", &choice);

        switch (choice) {
            case 1:
                show_bit_vector();
                break;
            case 2:
                delete_file();
                break;
            case 3:
                printf("Exiting...\n");
                break;
            default:
                printf("Invalid choice! Please enter a valid option.\n");
        }
    } while (choice != 3);

    return 0;
}
