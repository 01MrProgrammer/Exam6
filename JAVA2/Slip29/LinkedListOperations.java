import java.util.LinkedList;
import java.util.Scanner;

public class LinkedListOperations {
    public static void main(String[] args) {
        // Create a LinkedList of integer objects
        LinkedList<Integer> linkedList = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);

        // Get user input for adding elements at first position
        System.out.println("Enter integers to add at the beginning of the list (enter -1 to stop):");
        int num;
        while ((num = scanner.nextInt()) != -1) {
            linkedList.addFirst(num);
        }

        // Print the LinkedList
        System.out.println("LinkedList after adding elements at first position: " + linkedList);

        // Delete last element
        if (!linkedList.isEmpty()) {
            linkedList.removeLast();
            System.out.println("LinkedList after deleting last element: " + linkedList);
        } else {
            System.out.println("LinkedList is empty. Cannot delete last element.");
        }

        // Display the size of the LinkedList
        System.out.println("Size of LinkedList: " + linkedList.size());

        scanner.close();
    }
}
