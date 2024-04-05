//Q1
//Write a java program to accept ‘N’ Integers from a user store them into LinkedList
//Collection and display only negative integers. 

// package com.slip19;

import java.util.*;

public class NegativeLinkedList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create a LinkedList to store integers
        LinkedList<Integer> integersList = new LinkedList<>();

        // Accept 'N' integers from the user
        System.out.print("Enter the number of integers (N): ");
        int N = scanner.nextInt();
        System.out.println("Enter " + N + " integers:");

        for (int i = 0; i < N; i++) {
            int num = scanner.nextInt();
            integersList.add(num);
        }

        // Display only negative integers
        System.out.println("\nNegative integers:");
        for (int num : integersList) {
            if (num < 0) {
                System.out.println(num);
            }
        }

        // Close the scanner
        scanner.close();
    }
}
