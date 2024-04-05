//Q2
//Write a java program to accept ‘N’ student names through command line, store them
//into the appropriate Collection and display them by using Iterator and ListIterator
//interface. 

// package com.slip23;

import java.util.*;

public class StudentNames {
    public static void main(String[] args) {
        List<String> studentList = new ArrayList<>();

        // Accept 'N' student names from command line arguments
        for (String arg : args) {
            studentList.add(arg);
        }

        // Display student names using Iterator
        System.out.println("Student names using Iterator:");
        Iterator<String> iterator = studentList.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        // Display student names using ListIterator in reverse order
        System.out.println("\nStudent names using ListIterator (reverse order):");
        ListIterator<String> listIterator = studentList.listIterator(studentList.size());
        while (listIterator.hasPrevious()) {
            System.out.println(listIterator.previous());
        }
    }
}
