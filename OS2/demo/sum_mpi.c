#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <mpi.h>

#define ARRAY_SIZE 1000

int main(int argc, char *argv[]) {
    int rank, size;
    int local_array[ARRAY_SIZE];
    int global_sum = 0;
    int local_sum = 0;
    int i;

    // Initialize MPI environment
    MPI_Init(&argc, &argv);
    MPI_Comm_rank(MPI_COMM_WORLD, &rank);
    MPI_Comm_size(MPI_COMM_WORLD, &size);

    // Seed random number generator based on current time
    srand(time(NULL) + rank);

    // Generate random numbers for local array
    for (i = 0; i < ARRAY_SIZE; i++) {
        local_array[i] = rand() % 100; // Generate random numbers between 0 and 99
    }

    // Calculate local sum
    for (i = 0; i < ARRAY_SIZE; i++) {
        local_sum += local_array[i];
    }

    // Sum up local sums to get global sum
    MPI_Reduce(&local_sum, &global_sum, 1, MPI_INT, MPI_SUM, 0, MPI_COMM_WORLD);

    // Process 0 prints the global sum
    if (rank == 0) {
        printf("Global sum: %d\n", global_sum);
    }

    // Finalize MPI environment
    MPI_Finalize();

    return 0;
}

/*
mpicc mpi_sum.c -o mpi_sum
mpiexec -n 4 ./mpi_sum
*/