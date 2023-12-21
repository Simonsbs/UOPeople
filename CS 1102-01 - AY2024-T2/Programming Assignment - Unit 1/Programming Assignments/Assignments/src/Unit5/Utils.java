// Utils.java
package Unit5;

import java.util.Scanner;

public class Utils {
    /**
     * Reads a positive integer from the console.
     *
     * @param scanner The scanner to read input from.
     * @param prompt  The prompt to display to the user.
     * @return A positive integer input by the user.
     */
    public static int readPositiveInt(Scanner scanner, String prompt) {
        int number;
        while (true) {
            System.out.print(prompt);
            if (scanner.hasNextInt()) {
                number = scanner.nextInt();
                if (number > 0)
                    return number;
                else
                    System.out.println("Value must be a positive integer.");
            } else {
                System.out.println("Invalid input. Please enter an integer.");
                scanner.next(); // Clear invalid input
            }
        }
    }

    /**
     * Reads a float value within a specified range from the console.
     *
     * @param scanner The scanner to read input from.
     * @param prompt  The prompt to display to the user.
     * @param min     The minimum acceptable value.
     * @param max     The maximum acceptable value.
     * @return A float value input by the user within the specified range.
     */
    public static float readFloatInRange(Scanner scanner, String prompt, float min, float max) {
        float number;
        while (true) {
            System.out.print(prompt);
            if (scanner.hasNextFloat()) {
                number = scanner.nextFloat();
                if (number >= min && number <= max)
                    return number;
                else
                    System.out.println("Value must be between " + min + " and " + max + ".");
            } else {
                System.out.println("Invalid input. Please enter a numeric value.");
                scanner.next(); // Clear invalid input
            }
        }
    }
}
