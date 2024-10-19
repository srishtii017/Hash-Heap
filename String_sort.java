import java.util.Arrays;
import java.util.Scanner;

public class String_sort {
   public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // Number of strings
        sc.nextLine(); // Consume the newline after integer input

        String[] strings = new String[n];
        for (int i = 0; i < n; i++) {
            strings[i] = sc.nextLine();
        }

        // Custom sorting logic
        Arrays.sort(strings, (a, b) -> {
            // Check if one string is a prefix of the other
            if (a.startsWith(b)) {
                return -1; // If b is a prefix of a, a should come first (because a is longer)
            } else if (b.startsWith(a)) {
                return 1; // If a is a prefix of b, b should come first (because b is longer)
            } else {
                return a.compareTo(b); // Otherwise, sort lexicographically
            }
        });

        // Output the sorted strings
        for (String str : strings) {
            System.out.println(str);
        }
        
        sc.close();
    }  
}
