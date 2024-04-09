#include <stdio.h>
#include <stdlib.h>
#include <mpi.h>

#define ARRAY_SIZE 1000

int main(int argc, char *argv[]) {
    int rank, size;
    int local_array[ARRAY_SIZE];
    int local_sum = 0;
    int global_sum = 0;
    double global_avg = 0.0;
    int i;

    // Initialize MPI
    MPI_Init(&argc, &argv);
    MPI_Comm_rank(MPI_COMM_WORLD, &rank);
    MPI_Comm_size(MPI_COMM_WORLD, &size);

    // Generate random numbers in each process
    srand(rank);
    for (i = 0; i < ARRAY_SIZE; i++) {
        local_array[i] = rand() % 100; // Random numbers between 0 and 99
    }

    // Calculate local sum
    for (i = 0; i < ARRAY_SIZE; i++) {
        local_sum += local_array[i];
    }

    // Reduce local sums to obtain global sum
    MPI_Reduce(&local_sum, &global_sum, 1, MPI_INT, MPI_SUM, 0, MPI_COMM_WORLD);

    // Calculate global average (only on rank 0)
    if (rank == 0) {
        global_avg = (double)global_sum / (size * ARRAY_SIZE);
    }

    // Print results on rank 0
    if (rank == 0) {
        printf("Global sum: %d\n", global_sum);
        printf("Global average: %.2f\n", global_avg);
    }

    // Finalize MPI
    MPI_Finalize();

    return 0;
}
