#include <stdio.h>
#include <stdlib.h>
#include <mpi.h>

#define ARRAY_SIZE 1000

int main(int argc, char *argv[]) {
    int rank, size;
    int local_data[ARRAY_SIZE];
    int global_min, local_min;
    
    MPI_Init(&argc, &argv);
    MPI_Comm_rank(MPI_COMM_WORLD, &rank);
    MPI_Comm_size(MPI_COMM_WORLD, &size);

    // Generate random numbers
    srand(rank); // Seed the random number generator with rank
    for (int i = 0; i < ARRAY_SIZE; i++) {
        local_data[i] = rand() % 1000; // Generate random numbers between 0 and 999
    }

    // Find local minimum
    local_min = local_data[0];
    for (int i = 1; i < ARRAY_SIZE; i++) {
        if (local_data[i] < local_min) {
            local_min = local_data[i];
        }
    }

    // Reduce to find global minimum
    MPI_Reduce(&local_min, &global_min, 1, MPI_INT, MPI_MIN, 0, MPI_COMM_WORLD);

    // Print the result
    if (rank == 0) {
        printf("Global minimum: %d\n", global_min);
    }

    MPI_Finalize();
    return 0;
}
