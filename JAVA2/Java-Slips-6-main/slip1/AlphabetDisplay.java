//Q1
//Write a Java program to display all the alphabets between ‘A’ to ‘Z’ after every 2
//seconds.

//package com.slip1;

public class AlphabetDisplay {
    public static void main(String[] args) {
        // Starting alphabet
        char currentAlphabet = 'A';
        
        // Loop to display alphabets from 'A' to 'Z'
        while (currentAlphabet <= 'Z') {
            // Display current alphabet
            System.out.print(currentAlphabet + " ");
            
            // Move to the next alphabet
            currentAlphabet++;
            
            // Pause for 2 seconds
            try {
                Thread.sleep(2000); // Sleep for 2000 milliseconds (2 seconds)
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

