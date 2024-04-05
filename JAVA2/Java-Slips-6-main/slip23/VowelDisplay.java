//Q1
//Write a java program to accept a String from a user and display each vowel from a
//String after every 3 seconds.

// package com.slip23;

import java.util.Scanner;

public class VowelDisplay {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Accept a string from the user
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        // Create a thread to display vowels
        Thread vowelThread = new Thread(new VowelRunnable(input));
        vowelThread.start();

        // Close the scanner
        scanner.close();
    }

    static class VowelRunnable implements Runnable {
        private String input;

        public VowelRunnable(String input) {
            this.input = input;
        }

        @Override
        public void run() {
            try {
                for (int i = 0; i < input.length(); i++) {
                    char ch = input.charAt(i);
                    if (isVowel(ch)) {
                        System.out.println("Vowel: " + ch);
                        Thread.sleep(3000); // Sleep for 3 seconds
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Method to check if a character is a vowel
        private boolean isVowel(char ch) {
            ch = Character.toLowerCase(ch);
            return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
        }
    }
}
