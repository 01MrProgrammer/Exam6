//Q1
//Write a java program to accept ‘N’ Subject Names from a user store them into
//LinkedList Collection and Display them by using Iterator interface

// package com.slip21;

import java.util.*;

public class SubjectLinkedList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create a LinkedList to store subject names
        LinkedList<String> subjectList = new LinkedList<>();

        // Accept 'N' subject names from the user
        System.out.print("Enter the number of subjects (N): ");
        int N = scanner.nextInt();
        System.out.println("Enter " + N + " subject names:");

        for (int i = 0; i < N; i++) {
            String subject = scanner.next();
            subjectList.add(subject);
        }

        // Display subject names using Iterator
        System.out.println("\nSubject names using Iterator:");
        Iterator<String> iterator = subjectList.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        // Close the scanner
        scanner.close();
    }
}
