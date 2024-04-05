//Q1
//Write a Java program to accept ‘n’ integers from the user and store them in a collection.
//Display them in the sorted order. The collection should not accept duplicate elements.
//(Use a suitable collection). Search for a particular element using predefined search
//method in the Collection framework.

// package com.slip6;

import java.util.*;

public class IntegerCollection {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TreeSet<Integer> numbers = new TreeSet<>();

        // Accept 'n' integers from the user
        System.out.print("Enter the number of integers (n): ");
        int n = scanner.nextInt();

        System.out.println("Enter " + n + " integers:");
        for (int i = 0; i < n; i++) {
            int num = scanner.nextInt();
            numbers.add(num);
        }

        // Display the integers in sorted order
        System.out.println("\nIntegers in sorted order:");
        for (int num : numbers) {
            System.out.print(num + " ");
        }

        // Search for a particular element
        System.out.print("\nEnter the element to search for: ");
        int searchElement = scanner.nextInt();
        if (numbers.contains(searchElement)) {
            System.out.println("Element " + searchElement + " found in the collection.");
        } else {
            System.out.println("Element " + searchElement + " not found in the collection.");
        }

        scanner.close();
    }
}
