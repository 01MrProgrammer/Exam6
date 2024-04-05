//Q1
//Write a java program to accept ‘N’ integers from a user. Store and display integers in
//sorted order having proper collection class. The collection should not accept duplicate
//elements.

// package com.slip17;

import java.util.*;

public class SortedIntegers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create a HashSet to store integers (to avoid duplicates)
        Set<Integer> integersSet = new HashSet<>();

        // Accept 'N' integers from the user
        System.out.print("Enter the number of integers (N): ");
        int N = scanner.nextInt();
        System.out.println("Enter " + N + " integers:");

        for (int i = 0; i < N; i++) {
            int num = scanner.nextInt();
            integersSet.add(num);
        }

        // Convert the HashSet to ArrayList for sorting
        List<Integer> sortedIntegersList = new ArrayList<>(integersSet);
        Collections.sort(sortedIntegersList);

        // Display the integers in sorted order
        System.out.println("\nIntegers in sorted order:");
        for (int num : sortedIntegersList) {
            System.out.println(num);
        }

        // Close the scanner
        scanner.close();
    }
}
