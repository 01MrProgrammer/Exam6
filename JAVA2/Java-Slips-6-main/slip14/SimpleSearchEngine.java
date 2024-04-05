//Q1
//Write a Java program for a simple search engine. Accept a string to be searched. Search
//the string in all text files in the current folder. Use a separate thread for each file. The
//result should display the filename and line number where the string is found. 

// package com.slip14;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SimpleSearchEngine {
    
    public static void main(String[] args) {
        String searchString = "yash"; // Change this to the string you want to search

        File currentDirectory = new File(System.getProperty("user.dir"));
        File[] files = currentDirectory.listFiles();

        ExecutorService executor = Executors.newFixedThreadPool(files.length);

        for (File file : files) {
            if (file.isFile() && file.getName().endsWith(".txt")) {
                executor.execute(new SearchTask(file, searchString));
            }
        }

        executor.shutdown();
    }

    static class SearchTask implements Runnable {
        private File file;
        private String searchString;

        public SearchTask(File file, String searchString) {
            this.file = file;
            this.searchString = searchString;
        }

        @Override
        public void run() {
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;
                int lineNumber = 0;
                while ((line = reader.readLine()) != null) {
                    lineNumber++;
                    if (line.contains(searchString)) {
                        System.out.println("Found in file: " + file.getName() + " at line " + lineNumber);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
