import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class mapped_strings {
     static List<String> result = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String num = sc.nextLine();  // Input number as string
        sc.close();

        // Start recursive backtracking to generate all possible strings
        generateStrings(num, 0, "");

        // Sort the result lexicographically
        Collections.sort(result);

        // Print all the possible strings
        for (String str : result) {
            System.out.println(str);
        }
    }

    // Function to generate all possible strings recursively
    public static void generateStrings(String num, int index, String current) {
        // Base case: If we have reached the end of the string, add the current result to the list
        if (index == num.length()) {
            result.add(current);
            return;
        }

        // Case 1: Take one digit and map it to a character
        int singleDigit = num.charAt(index) - '0';
        if (singleDigit >= 1 && singleDigit <= 9) {
            char letter = (char) ('A' + singleDigit - 1);
            generateStrings(num, index + 1, current + letter);
        }

        // Case 2: Take two digits and map it to a character (if valid)
        if (index + 1 < num.length()) {
            int doubleDigit = Integer.parseInt(num.substring(index, index + 2));
            if (doubleDigit >= 10 && doubleDigit <= 26) {
                char letter = (char) ('A' + doubleDigit - 1);
                generateStrings(num, index + 2, current + letter);
            }
        }
    }
}
