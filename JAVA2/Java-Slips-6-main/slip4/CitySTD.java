// package com.slip4;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CitySTD {
    private static Map<String, String> citySTDMap = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n1. Add a new city and its code");
            System.out.println("2. Remove a city from the collection");
            System.out.println("3. Search for a city name and display the code");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addCity(scanner);
                    break;
                case 2:
                    removeCity(scanner);
                    break;
                case 3:
                    searchCity(scanner);
                    break;
                case 4:
                    System.exit(0);
                    
                default:
                    System.out.println("Invalid choice! Please enter a valid choice.");
            }
        } while (choice != 4);

        scanner.close();
    }

    private static void addCity(Scanner scanner) {
        System.out.print("Enter city name: ");
        String cityName = scanner.next();
        System.out.print("Enter STD code: ");
        String stdCode = scanner.next();

        if (!citySTDMap.containsKey(cityName)) {
            citySTDMap.put(cityName, stdCode);
            System.out.println("City '" + cityName + "' added successfully.");
        } else {
            System.out.println("City '" + cityName + "' already exists in the collection.");
        }
    }

    private static void removeCity(Scanner scanner) {
        System.out.print("Enter city name to remove: ");
        String cityName = scanner.next();

        if (citySTDMap.containsKey(cityName)) {
            citySTDMap.remove(cityName);
            System.out.println("City '" + cityName + "' removed successfully.");
        } else {
            System.out.println("City '" + cityName + "' does not exist in the collection.");
        }
    }

    private static void searchCity(Scanner scanner) {
        System.out.print("Enter city name to search: ");
        String cityName = scanner.next();

        if (citySTDMap.containsKey(cityName)) {
            String stdCode = citySTDMap.get(cityName);
            System.out.println("STD code for city '" + cityName + "' is: " + stdCode);
        } else {
            System.out.println("City '" + cityName + "' does not exist in the collection.");
        }
    }
}
