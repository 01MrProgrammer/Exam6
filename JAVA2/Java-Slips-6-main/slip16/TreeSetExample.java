//Q1
//Write a java program to create a TreeSet, add some colors (String) and print out the
//content of TreeSet in ascending order. 
//Directly putting values in code

// package com.slip16;

import java.util.*;

public class TreeSetExample {
    public static void main(String[] args) {
        // Create a TreeSet to store colors
        TreeSet<String> colorsTreeSet = new TreeSet<>();

        // Add colors to the TreeSet
        colorsTreeSet.add("Red");
        colorsTreeSet.add("Blue");
        colorsTreeSet.add("Green");
        colorsTreeSet.add("Yellow");
        colorsTreeSet.add("Orange");

        // Print the content of the TreeSet in ascending order
        System.out.println("Colors in ascending order:");
        for (String color : colorsTreeSet) {
            System.out.println(color);
        }
    }
}
