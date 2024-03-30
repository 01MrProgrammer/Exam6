import java.util.*;

public class Q1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the number of friends (N): ");
        int N = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        
        HashSet<String> friendsSet = new HashSet<>();
        
        System.out.println("Enter the names of your friends:");
        for (int i = 0; i < N; i++) {
            String name = scanner.nextLine();
            friendsSet.add(name);
        }
        
        // Convert HashSet to ArrayList to sort
        ArrayList<String> sortedFriends = new ArrayList<>(friendsSet);
        Collections.sort(sortedFriends);
        
        System.out.println("\nYour friends in ascending order:");
        for (String friend : sortedFriends) {
            System.out.println(friend);
        }
        
        scanner.close();
    }
}
