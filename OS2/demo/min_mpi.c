#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <mpi.h>

#define ARRAY_SIZE 1000

int main(int argc, char *argv[]) {
    int rank, size;
    int local_min, global_min;
    int numbers[ARRAY_SIZE];

    MPI_Init(&argc, &argv);
    MPI_Comm_rank(MPI_COMM_WORLD, &rank);
    MPI_Comm_size(MPI_COMM_WORLD, &size);

    // Initialize random seed
    srand(time(NULL) + rank);

    // Generate random numbers
    for (int i = 0; i < ARRAY_SIZE; i++) {
        numbers[i] = rand() % 1000; // generating numbers between 0 to 999
    }

    // Find local minimum
    local_min = numbers[0];
    for (int i = 1; i < ARRAY_SIZE; i++) {
        if (numbers[i] < local_min) {
            local_min = numbers[i];
        }
    }

    // Reduce to find global minimum
    MPI_Reduce(&local_min, &global_min, 1, MPI_INT, MPI_MIN, 0, MPI_COMM_WORLD);

    // Print the result
    if (rank == 0) {
        printf("The minimum number is: %d\n", global_min);
    }

    MPI_Finalize();

    return 0;
}

/*
mpicc -o min_mpi min_mpi.c
mpiexec -n 4 ./min_mpi
*/