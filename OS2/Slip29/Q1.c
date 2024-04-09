#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <mpi.h>

#define ARRAY_SIZE 1000

int main(int argc, char *argv[]) {
    int rank, size;
    int local_data[ARRAY_SIZE];
    int local_sum = 0;
    int global_sum = 0;

    MPI_Init(&argc, &argv);
    MPI_Comm_rank(MPI_COMM_WORLD, &rank);
    MPI_Comm_size(MPI_COMM_WORLD, &size);

    // Seed the random number generator differently for each process
    srand(time(NULL) + rank);

    // Generate random numbers and calculate local sum of even numbers
    for (int i = 0; i < ARRAY_SIZE; i++) {
        local_data[i] = rand() % 1000; // Generate random numbers between 0 and 999
        if (local_data[i] % 2 == 0) {
            local_sum += local_data[i];
        }
    }

    // Reduce to calculate global sum of even numbers
    MPI_Reduce(&local_sum, &global_sum, 1, MPI_INT, MPI_SUM, 0, MPI_COMM_WORLD);

    // Print the result from process 0
    if (rank == 0) {
        printf("Global sum of even numbers: %d\n", global_sum);
    }

    MPI_Finalize();
    return 0;
}
