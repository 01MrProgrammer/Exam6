#include<stdio.h>
#include<stdlib.h>



int main()
{   
    int total_blocks,i,head,temp,seek=0;
    int *list;
    printf("Enter the Total Number of Blocks:");
    scanf("%d",&total_blocks);

    list = (int *)malloc(total_blocks * sizeof(int));

    printf("Enter disk req string:\n");
    for(i=0;i<total_blocks;i++)
    {
        scanf("%d",&list[i]);
    }

    printf("Enter head:");
    scanf("%d",&head);

    printf("req processing order:\n");
    printf("%d ",head);

    for(i=0;i<total_blocks;i++)
    {
        seek += abs(list[i]-head);
        head=list[i];
        printf("%d ",head);
    }

    printf("\ntotal head Mov:%d\n",seek);

    free(list);
    return 0;

}