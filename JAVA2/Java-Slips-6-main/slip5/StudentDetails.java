//Q1
//Write a Java Program to create the hash table that will maintain the mobile number and
//student name. Display the details of student using Enumeration interface.
//Program by directly inputing values in code.

// package com.slip5;

import java.util.Enumeration;
import java.util.Hashtable;

public class StudentDetails {
    public static void main(String[] args) {
        // Create a hash table to maintain mobile numbers and student names
        Hashtable<String, String> studentTable = new Hashtable<>();

        // Add student details to the hash table
        studentTable.put("9876543210", "John");
        studentTable.put("9876543211", "Alice");
        studentTable.put("9876543212", "Bob");
        studentTable.put("9876543213", "Emily");
        studentTable.put("9876543214", "David");

        // Display details of students using Enumeration interface
        Enumeration<String> mobileNumbers = studentTable.keys();
        Enumeration<String> studentNames = studentTable.elements();

        System.out.println("Student Details:");
        while (mobileNumbers.hasMoreElements() && studentNames.hasMoreElements()) {
            String mobileNumber = mobileNumbers.nextElement();
            String studentName = studentNames.nextElement();
            System.out.println("Mobile Number: " + mobileNumber + ", Student Name: " + studentName);
        }
    }
}
