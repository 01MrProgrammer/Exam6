#include<stdio.h>
#include<stdlib.h>

int main()
{
    int head,temp,total,i,seek=0;
    int *list;

    printf("Enter total Number of disk bloks:");
    scanf("%d",&total);

    list = (int *)malloc(total * sizeof(int));

    printf("Enter request String Seperated by space:\n");
    for(i=0;i<total;i++){
        scanf("%d",&list[i]);
    }

    printf("Enter head position: ");
    scanf("%d ",&head);

    printf("Request Processing Order:\n");
    printf("%d ", head);

    for(i=0;i<total;i++){
        seek+= abs(list[i]-head);
        head=list[i];
        printf("%d ",head);
    }

    printf("total no of head mov:%d\n",seek);

    free(list);
    return 0;
}