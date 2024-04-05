//Q2
//Write a Java program to create LinkedList of integer objects and perform the following:
//i. Add element at first position
//ii. Delete last element
//iii. Display the size of link list 

// package com.slip29;

import java.util.LinkedList;
import java.util.Scanner;

public class LinkedListOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create a LinkedList of integer objects
        LinkedList<Integer> linkedList = new LinkedList<>();

        // Add elements at the first position
        System.out.print("Enter the number of elements to add at first position: ");
        int numElements = scanner.nextInt();
        System.out.println("Enter " + numElements + " elements:");
        for (int i = 0; i < numElements; i++) {
            int element = scanner.nextInt();
            linkedList.addFirst(element);
        }

        // Display the elements in the linked list
        System.out.println("Linked List after adding elements at first position:");
        System.out.println(linkedList);

        // Delete the last element
        if (!linkedList.isEmpty()) {
            linkedList.removeLast();
            System.out.println("Linked List after deleting the last element:");
            System.out.println(linkedList);
        } else {
            System.out.println("Linked List is empty. Cannot delete last element.");
        }

        // Display the size of the linked list
        System.out.println("Size of the linked list: " + linkedList.size());

        // Close the scanner
        scanner.close();
    }
}
