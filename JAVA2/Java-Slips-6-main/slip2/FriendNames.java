//Q1
//Write a java program to read ‘N’ names of your friends, store it into HashSet and
//display them in ascending order.

// package com.slip2;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class FriendNames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Create a HashSet to store names
        Set<String> friendsSet = new HashSet<>();
        
        // Read the value of N
        System.out.print("Enter the number of friends (N): ");
        int n = scanner.nextInt();
        
        // Read N names and add them to the HashSet
        System.out.println("Enter the names of your friends:");
        for (int i = 0; i < n; i++) {
            String name = scanner.next();
            friendsSet.add(name);
        }
        
        // Close the scanner
        scanner.close();
        
        // Create a TreeSet to store names in ascending order
        Set<String> sortedFriends = new TreeSet<>(friendsSet);
        
        // Display names in ascending order
        System.out.println("\nFriends in ascending order:");
        for (String friend : sortedFriends) {
            System.out.println(friend);
        }
    }
}
