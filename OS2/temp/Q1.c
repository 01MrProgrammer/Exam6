#include<stdio.h>

int alloc[10][10],max[10][10],need[10][10];
int avail[10];
int np,nr;

void accept_matrix(int matrix[10][10], const char *sms)
{
    printf("\n Enter %s Matrix\n",sms);
    for(int i=0;i<np;i++)
    {
        printf("\nfor Process %d:",i);
        for(int j=0;j<nr;j++)
        {
            scanf("%d ",&matrix[i][j]);
        }
    }
}

void display_matrix(int matrix[10][10], const char *sms)
{
    printf("\n %s Matrix\n",sms);
    for(int i=0;i<np;i++)
    {
        printf("P%d",i);
        for(int j=0;j<nr;j++)
        {
            printf("%d ",matrix[i][j]);
        }
        printf("\n");
    }
}

void cal_need()
{
    for(int i=0;i<np;i++)
        for(int j=0;j<nr;j++)
            need[i][j]=max[i][j]-alloc[i][j];
}

void dis_avail()
{
    printf("Available are:");
    for(int j=0;j<nr;j++)
    printf("%d",avail[j]);
    printf("\n");
}

void doMenu()
{
    printf("\n*****Menu*****");
    printf("\na) Accept Available: ");
    printf("\nb) Display Allocation, Max:");
    printf("\nc) Display the contents of need matrix:");
    printf("\nd) Display Available:");
    printf("\ne) Exit:");
    printf("\n Enter Your Choice:");
}

int main()
{
    int ch;

    printf("\nEnter Number of Processes:\n");
    scanf("%d ",&np);
    printf("\nEnter Number of Resorces:\n");
    scanf("%d ",&nr);

    printf("\n");

    accept_matrix(alloc, "Allocation");
    accept_matrix(max, "Max");

    printf("\n Enter Available Matrix:");
    for(int j=0;j<nr;j++)
    scanf("%d",&avail[j]);

    while(1){
        doMenu();
        scanf("%c",&ch);

        switch(ch)
        {
            case 'a':
            printf("\n Enter Available reso:");
            for(int j=0;j<nr;j++)
            scanf("%d",&avail[j]);
            break;

            case 'b':
            display_matrix(alloc, "Allocation");
            display_matrix(max, "Max");
            break;

            case 'c':
            cal_need();
            display_matrix(need, "Need");
            break;

            case 'd':
            dis_avail();
            break;

            case 'e':
            printf("Exiting......");
            return 0;

            default:
            printf("\nInvalid choice.");
        }
    }
    return 0;
}