import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Q2 {
    private static Map<String, Integer> cityCodes = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nSelect an operation:");
            System.out.println("1. Add a new city and its code");
            System.out.println("2. Remove a city");
            System.out.println("3. Search for a city and display its code");
            System.out.println("4. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

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
                    System.out.println("Exiting program.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 4.");
            }
        }
    }

    private static void addCity(Scanner scanner) {
        System.out.print("Enter city name: ");
        String cityName = scanner.nextLine();

        if (cityCodes.containsKey(cityName)) {
            System.out.println("City already exists in the collection.");
        } else {
            System.out.print("Enter STD code for " + cityName + ": ");
            int stdCode = scanner.nextInt();
            cityCodes.put(cityName, stdCode);
            System.out.println("City added successfully.");
        }
    }

    private static void removeCity(Scanner scanner) {
        System.out.print("Enter city name to remove: ");
        String cityName = scanner.nextLine();

        if (cityCodes.containsKey(cityName)) {
            cityCodes.remove(cityName);
            System.out.println(cityName + " removed successfully.");
        } else {
            System.out.println("City not found in the collection.");
        }
    }

    private static void searchCity(Scanner scanner) {
        System.out.print("Enter city name to search: ");
        String cityName = scanner.nextLine();

        if (cityCodes.containsKey(cityName)) {
            int stdCode = cityCodes.get(cityName);
            System.out.println("STD code for " + cityName + ": " + stdCode);
        } else {
            System.out.println("City not found in the collection.");
        }
    }
}
