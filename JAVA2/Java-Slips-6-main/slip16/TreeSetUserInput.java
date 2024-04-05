//Q1
//Write a java program to create a TreeSet, add some colors (String) and print out the
//content of TreeSet in ascending order.
//Taking input from user

// package com.slip16;

import java.util.*;

public class TreeSetUserInput {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Create a TreeSet to store colors
        TreeSet<String> colorsTreeSet = new TreeSet<>();
        
        int n;
        String color;
        
        System.out.println("Enter how many colors: ");
        n=sc.nextInt();
        sc.nextLine();
        System.out.println("Enter " +n+ " Colors :");
        for(int i=1; i<=n; i++)
        {
        	
            color=sc.nextLine();
            
            colorsTreeSet.add(color);

        }
        
        
        // Print the content of the TreeSet in ascending order
        System.out.println("\nColors in ascending order:");
        for (String colors : colorsTreeSet) {
            System.out.println(colors);
        }

        // Close the scanner
        sc.close();
    }
}
