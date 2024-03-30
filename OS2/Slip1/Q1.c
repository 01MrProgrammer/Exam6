#include<stdio.h>
int max[10][10],allocation[10][10],need[10][10];
int avail[10];
int np,nr;
void readmatrix(int matrix[10][10])
{
    int i,j;
    for(i=0;i<np;i++)
    for(j=0;j<nr;j++)
    scanf("%d",&matrix[i][j]);
}
void dispalay_matrix(int matrix[10][10])
{
    int i,j;
    for(i=0;i<np;i++)
    {
        printf("\n P%d",i);
        for(j=0;j<nr;j++){
            printf(" %d",matrix[i][j]);
        }
    }
}
void calculate_need()
{
    int i,j;
    for(i=0;i<np;i++)
    for(j=0;j<nr;j++)
    need[i][j]=max[i][j]-allocation[i][j];
}
void banker()
{
    int i,j,k=0,flag;
    int finish[10],safe_seq[10];
    for(i=0;i<np;i++)
    {
        finish[i]=0;
    }
    for(i=0;i<np;i++)
    {
        flag=0;
        if(finish[i]==0)
        {
           for(j=0;j<nr;j++)
           {
            if(need[i][j]>avail[j])
            {
                flag=1;
                break;
            }
           }
           if(flag==0)
           {
            finish[i]=1;
            safe_seq[k]=i;
            k++;
            for(j=0;j<nr;j++)
            avail[j]+=allocation[i][j];
            i=-1;
           }
        }
    }
    flag=0;
    for(i=0;i<np;i++)
    {
        if(finish[i]==0)
        {
            printf("\n The System is in deadlock");
            flag=1;
            break;
        }
    }
    if(flag==0)
    {
        printf("\n The system is in safe state! \n safe sequence is ==>");
        for(i=0;i<np;i++)
        printf(" P%d",safe_seq[i]);
    }
}
int main()
{
    int j;

    
        printf("\n Enter the Number of Processes:");
        scanf("%d",&np);
        printf("\n Enter the Number of Resources:");
        scanf("%d",&nr);
        printf("\nEnter initial allocation matrix:");
        readmatrix(allocation);
        printf("\n Enter more requirement Matrix:");
        readmatrix(max);
        printf("\n Enter the available resources:");
        for(j=0;j<nr;j++)
        scanf("%d",&avail[j]);
    

    
        printf("\n*****Entered Data is *****\n\n");
        printf("\n Initial allocation:\n");
        dispalay_matrix(allocation);
        printf("\n\n\n Maximum Resources\n");
        dispalay_matrix(max);
        printf("\n Available Resources\n");
        for(j=0;j<nr;j++)
        printf(" %d",avail[j]);
    

    
        calculate_need();
        printf("\n\n\n Need is \n");
        dispalay_matrix(need);
    

    
        banker();
        printf("\n\n\n\n");
        return 0;
    
}