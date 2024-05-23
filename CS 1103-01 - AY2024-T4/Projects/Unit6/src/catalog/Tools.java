package catalog;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.NoSuchElementException;

/**
 * Utility class for validation and input operations.
 */
public class Tools {
    private static Scanner scanner;

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

    public static boolean isValidYear(int year) {
        return year > 1000 && year <= java.time.Year.now().getValue();
    }

    /**
     * Validates and retrieves input from the user.
     *
     * @param prompt The prompt to display to the user.
     * @param type   The type of input expected.
     * @param <T>    The type parameter.
     * @return The validated input.
     */
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

    /**
     * Closes the scanner.
     */
    public static void closeScanner() {
        if (scanner != null) {
            scanner.close();
        }
    }

    /**
     * Loads test data from a file into the catalog.
     *
     * @param catalog  The catalog to load data into.
     * @param filename The name of the file containing test data.
     */
    public static void loadTestData(GenericCatalog<LibraryItem> catalog, String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                String type = parts[0].trim();
                int id = Integer.parseInt(parts[1].trim());
                String title = parts[2].trim();
                String author = parts[3].trim();
                int publishedYear = Integer.parseInt(parts[4].trim());
                String genre = parts[5].trim();

                switch (type) {
                    case "Book":
                        int pages = Integer.parseInt(parts[6].trim());
                        catalog.addItem(new Book(id, title, author, publishedYear, genre, pages));
                        break;
                    case "DVD":
                        int duration = Integer.parseInt(parts[6].trim());
                        catalog.addItem(new DVD(id, title, author, publishedYear, genre, duration));
                        break;
                    case "Magazine":
                        int issueNumber = Integer.parseInt(parts[6].trim());
                        catalog.addItem(new Magazine(id, title, author, publishedYear, genre, issueNumber));
                        break;
                    default:
                        System.out.println("Unknown item type: " + type);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading test data: " + e.getMessage());
        }
    }
}
