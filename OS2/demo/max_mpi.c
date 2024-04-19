#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <mpi.h>

#define ARRAY_SIZE 1000

int main(int argc, char *argv[]) {
    int rank, size;
    int local_array[ARRAY_SIZE];
    int local_max = 0;
    int global_max = 0;
    int i;

    // Initialize MPI environment
    MPI_Init(&argc, &argv);
    MPI_Comm_rank(MPI_COMM_WORLD, &rank);
    MPI_Comm_size(MPI_COMM_WORLD, &size);

    // Seed random number generator based on current time and rank
    srand(time(NULL) + rank);

    // Generate random numbers for local array
    for (i = 0; i < ARRAY_SIZE; i++) {
        local_array[i] = rand() % 1000; // Generate random numbers between 0 and 999
    }

    // Find local max
    for (i = 0; i < ARRAY_SIZE; i++) {
        if (local_array[i] > local_max) {
            local_max = local_array[i];
        }
    }

    // Find global max using MPI_Reduce
    MPI_Reduce(&local_max, &global_max, 1, MPI_INT, MPI_MAX, 0, MPI_COMM_WORLD);

    // Process 0 prints the global max
    if (rank == 0) {
        printf("Global max number: %d\n", global_max);
    }

    // Finalize MPI environment
    MPI_Finalize();

    return 0;
}

/*
mpicc mpi_max.c -o mpi_max
mpiexec -n 4 ./mpi_max
*/