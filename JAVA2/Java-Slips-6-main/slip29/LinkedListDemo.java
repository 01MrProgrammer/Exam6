//Q2
// Write a Java program to create LinkedList of integer objects and perform the following:
// i. Add element at first position
// ii. Delete last element
// iii. Display the size of link list

import java.util.*;

public class LinkedListDemo
{
    public static void main(String args[])
    {
        LinkedList<Integer> L1 = new LinkedList<>();
        L1.add(10);
        L1.add(15);
        L1.add(20);
        System.out.println("Linked List Elements are: \n"+L1);

        //Add element at first position
        L1.addFirst(5);
        System.out.println("\nAfter Adding Element at first position: \n"+L1);

        //Delete last element
        L1.removeLast();
        System.out.println("\nAfter Deleting Last Element: \n"+L1);

        //Display the size of link list
        
        System.out.println("\nSize of Linked List: "+L1.size());

    }
}