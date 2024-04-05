//Q2
//Write a Java program to create LinkedList of String objects and perform the following:
//i. Add element at the end of the list
//ii. Delete first element of the list
//iii. Display the contents of list in reverse order
//directly accessing all operations

// package com.slip3;

import java.util.LinkedList;

public class StringLinkedList {
    public static void main(String[] args) {
        // Create a LinkedList of String objects
        LinkedList<String> stringList = new LinkedList<>();
        
        // Add elements at the end of the list
        stringList.add("Apple");
        stringList.add("Banana");
        stringList.add("Orange");
        stringList.add("Mango");
        
        // Display the initial contents of the list
        System.out.println("Initial contents of the list:");
        System.out.println(stringList);
        System.out.println();
        
        // Delete the first element of the list
        String removedElement = stringList.removeFirst();
        System.out.println("Removed element: " + removedElement);
        System.out.println("Contents of the list after removing first element:");
        System.out.println(stringList);
        System.out.println();
        
        // Display the contents of the list in reverse order
        System.out.println("Contents of the list in reverse order:");
        for (int i = stringList.size() - 1; i >= 0; i--) {
            System.out.println(stringList.get(i));
        }
    }
}

