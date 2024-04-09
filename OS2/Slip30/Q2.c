#include <stdio.h>
#include <stdlib.h>

int main() {
  int total_blocks, head, seek_count = 0;

  // Get user input
  printf("Enter total number of disk blocks: ");
  scanf("%d", &total_blocks);

  printf("Enter disk request string (separated by spaces): ");
  int request_list[total_blocks];
  for (int i = 0; i < total_blocks; i++) {
    scanf("%d", &request_list[i]);
  }

  printf("Enter current head position: ");
  scanf("%d", &head);

  printf("Request Processing Order:\n");
  for (int i = 0; i < total_blocks; i++) {
    seek_count += abs(request_list[i] - head);
    head = request_list[i];
    printf("%d ", request_list[i]);
  }

  printf("\nTotal Head Movements: %d\n", seek_count);

  return 0;
}
