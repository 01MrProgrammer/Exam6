//import java.util.LinkedList;
//import java.util.ListIterator;
//import java.util.Scanner;
import java.util.*;
public class Q2 {
    public static void main(String[] args) {
        // Create a LinkedList of String objects
        LinkedList<String> linkedList = new LinkedList<>();

        // Scanner for user input
        Scanner scanner = new Scanner(System.in);

        // Add elements at the end of the list
        System.out.print("Enter elements to add to the list (press Enter after each element, type 'done' to finish): ");
        String input;
        while (!(input = scanner.nextLine()).equals("done")) {
            linkedList.add(input);
        }

        // Close scanner
        scanner.close();

        // Display the original contents of the list
        System.out.println("Original List:");
        System.out.println(linkedList);

        // Delete the first element of the list
        if (!linkedList.isEmpty()) {
            linkedList.removeFirst();
            System.out.println("\nAfter deleting first element:");
            System.out.println(linkedList);
        } else {
            System.out.println("\nThe list is empty.");
        }

        // Display the contents of the list in reverse order
        System.out.println("\nReversed List:");
        ListIterator<String> listIterator = linkedList.listIterator(linkedList.size());
        while (listIterator.hasPrevious()) {
            System.out.println(listIterator.previous());
        }
    }
}




