//Q1
//Write a Java Program to create the hash table that will maintain the mobile number and
//student name. Display the details of student using Enumeration interface.
//Program by taking input from user.

// package com.slip5;

import java.util.*;

public class StudentDetails1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Hashtable<String, String> studentHashTable = new Hashtable<>();

        // Take input from user to populate the hash table
        System.out.println("Enter student details (Name and Mobile Number) - Enter 'done' to finish:");
        String name, mobileNumber;
       
        
        while (true) {
            System.out.print("Student Name: ");
            name = scanner.nextLine();
            if (name.equals("done")) {
                break;
            }
            System.out.print("Mobile Number: ");
            mobileNumber = scanner.nextLine();
            studentHashTable.put(mobileNumber, name);
        }

        // Displaying details of students using Enumeration interface
        Enumeration<String> mobileNumbers = studentHashTable.keys();
        System.out.println("\nStudent Details:");
        while (mobileNumbers.hasMoreElements()) {
            String mobile = mobileNumbers.nextElement();
            String studentName = studentHashTable.get(mobile);
            System.out.println("Name: " + studentName + ", Mobile Number: " + mobile);
        }

        scanner.close();
    }
}
