package catalog;

import java.util.Scanner;
import java.util.NoSuchElementException;

public class Tools {
    private static Scanner scanner; // Initialize in a static block or method

    static {
        scanner = new Scanner(System.in);
    }

    public static boolean isValidID(int id) {
        return id > 0;
    }

    public static boolean isValidString(String str) {
        return str != null && !str.trim().isEmpty();
    }

    public static boolean isValidDuration(int duration) {
        return duration > 0;
    }

    public static boolean isValidPages(int pages) {
        return pages > 0;
    }

    public static boolean isValidIssueNumber(int issueNumber) {
        return issueNumber > 0;
    }

    public static <T> T getValidatedInput(String prompt, Class<T> type) {
        while (true) {
            System.out.print(prompt);
            String input = null;
            try {
                if (scanner.hasNextLine()) {
                    input = scanner.nextLine().trim();
                } else {
                    System.out.println("No input available. Please try again.");
                    continue;
                }

                if (type == Integer.class) {
                    int intValue = Integer.parseInt(input);
                    if (intValue > 0) {
                        return type.cast(intValue);
                    } else {
                        System.out.println("Input must be a positive number. Please try again.");
                    }
                } else if (type == String.class) {
                    if (isValidString(input)) {
                        return type.cast(input);
                    } else {
                        System.out.println("Input cannot be empty. Please try again.");
                    }
                } else {
                    System.out.println("Unsupported type.");
                    return null;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            } catch (NoSuchElementException e) {
                System.out.println("Input stream closed. Exiting program.");
                System.exit(1);
            } catch (Exception e) {
                System.out.println("Invalid input. Please try again.");
            }
        }
    }

    public static void closeScanner() {
        if (scanner != null) {
            scanner.close(); // Properly close the scanner
        }
    }
}
