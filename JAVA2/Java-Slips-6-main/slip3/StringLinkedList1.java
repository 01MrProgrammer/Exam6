//Q2
//Write a Java program to create LinkedList of String objects and perform the following:
//i. Add element at the end of the list
//ii. Delete first element of the list
//iii. Display the contents of list in reverse order
//Taking input from users to perform all operations.

// package com.slip3;

import java.util.LinkedList;
import java.util.Scanner;

public class StringLinkedList1 {
    public static void main(String[] args) {
        LinkedList<String> stringList = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);
        
        // Add elements at the end of the list
        System.out.println("Enter elements to add to the list (Enter 'done' to finish):");
        String input;
        while (true) {
            input = scanner.nextLine();
            if (input.equals("done")) {
                break;
            }
            stringList.add(input);
        }
        
        // Display the initial contents of the list
        System.out.println("\nInitial contents of the list:");
        System.out.println(stringList);
        
        // Delete the first element of the list
        if (!stringList.isEmpty()) {
            String removedElement = stringList.removeFirst();
            System.out.println("\nRemoved element: " + removedElement);
            System.out.println("Contents of the list after removing first element:");
            System.out.println(stringList);
        } else {
            System.out.println("\nList is empty. No element to remove.");
        }
        
        // Display the contents of the list in reverse order
        System.out.println("\nContents of the list in reverse order:");
        for (int i = stringList.size() - 1; i >= 0; i--) {
            System.out.println(stringList.get(i));
        }
        
        scanner.close();
    }
}
