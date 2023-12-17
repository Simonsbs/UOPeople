import java.util.Scanner;

public class LibrarySystem {
    // Constants and global variables
    private static final int MAX_BOOKS = 100;
    private static String[] titles = new String[MAX_BOOKS];
    private static String[] authors = new String[MAX_BOOKS];
    private static int[] quantities = new int[MAX_BOOKS];
    private static int bookCount = 0;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Main loop to handle user choices
        while (true) {
            // Display the options menu
            System.out.println("\nOptions:\n" +
                    "1. Add Books\n" +
                    "2. Borrow Books\n" +
                    "3. Return Books\n" +
                    "4. List Books\n" +
                    "5. Exit");
            System.out.print("Choose an option: ");
            String choice = scanner.nextLine();

            // Handling user's choice
            switch (choice) {
                case "1":
                    addBooks();
                    break;
                case "2":
                    borrowBooks();
                    break;
                case "3":
                    returnBooks();
                    break;
                case "4":
                    listBooks();
                    break;
                case "5":
                    // Exit the application
                    System.out.println("Exiting...");
                    return;
                default:
                    // Invalid option handling
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    // Method to add books to the library
    private static void addBooks() {
        // Check if the library is full
        if (bookCount >= MAX_BOOKS) {
            System.out.println("The Library is full. Cannot add more books.");
            return;
        }

        // Input book details
        System.out.print("Enter book title: ");
        String title = scanner.nextLine();
        System.out.print("Enter author: ");
        String author = scanner.nextLine();
        System.out.print("Enter quantity: ");
        int quantity = Integer.parseInt(scanner.nextLine());

        // Check if the book already exists and update quantity
        int index = findBookIndex(title);
        if (index != -1) {
            quantities[index] += quantity;
            System.out.println("Quantity updated.");
        } else {
            // Add new book to the library
            titles[bookCount] = title;
            authors[bookCount] = author;
            quantities[bookCount] = quantity;
            bookCount++;
            System.out.println("Book added.");
        }
    }

    // Method to borrow books from the library
    private static void borrowBooks() {
        // Input book title and find it in the library
        System.out.print("Enter book title: ");
        String title = scanner.nextLine();
        int index = findBookIndex(title);

        // If book is not found, return
        if (index == -1) {
            System.out.println("Book not found.");
            return;
        }

        // Input quantity to borrow
        System.out.print("Enter quantity to borrow: ");
        int quantity = Integer.parseInt(scanner.nextLine());

        // Check if enough copies are available
        if (quantities[index] >= quantity) {
            quantities[index] -= quantity;
            System.out.println("Book borrowed.");
        } else {
            System.out.println("Not enough copies available.");
        }
    }

    // Method to return books to the library
    private static void returnBooks() {
        // Input book title and find it in the library
        System.out.print("Enter book title: ");
        String title = scanner.nextLine();
        int index = findBookIndex(title);

        // If book is not found, return
        if (index == -1) {
            System.out.println("Book not found.");
            return;
        }

        // Input quantity to return
        System.out.print("Enter quantity to return: ");
        int quantity = Integer.parseInt(scanner.nextLine());

        // Update library quantities
        quantities[index] += quantity;
        System.out.println("Book returned.");
    }

    // Method to list all books in the library
    private static void listBooks() {
        // Check if the library is empty
        if (bookCount == 0) {
            System.out.println("No books in the library.");
            return;
        }

        // Display all books
        System.out.println("Books in the library:");
        for (int i = 0; i < bookCount; i++) {
            System.out.println("Title: " + titles[i] + ", Author: " + authors[i] + ", Quantity: " + quantities[i]);
        }
    }

    // Helper method to find the index of a book by title
    private static int findBookIndex(String title) {
        for (int i = 0; i < bookCount; i++) {
            if (titles[i].equals(title)) {
                return i;
            }
        }
        return -1;
    }
}

/*
 * Output:
 * --------------------
 * Options:
 * 1. Add Books
 * 2. Borrow Books
 * 3. Return Books
 * 4. List Books
 * 5. Exit
 * Choose an option: 1
 * Enter book title: Book 1
 * Enter author: Simon
 * Enter quantity: 5
 * Book added.
 * 
 * Options:
 * 1. Add Books
 * 2. Borrow Books
 * 3. Return Books
 * 4. List Books
 * 5. Exit
 * Choose an option: 1
 * Enter book title: Book 2
 * Enter author: Bob
 * Enter quantity: 10
 * Book added.
 * 
 * Options:
 * 1. Add Books
 * 2. Borrow Books
 * 3. Return Books
 * 4. List Books
 * 5. Exit
 * Choose an option: 1
 * Enter book title: Book 1
 * Enter author: Simon
 * Enter quantity: 2
 * Quantity updated.
 * 
 * Options:
 * 1. Add Books
 * 2. Borrow Books
 * 3. Return Books
 * 4. List Books
 * 5. Exit
 * Choose an option: 4
 * Books in the library:
 * Title: Book 1, Author: Simon, Quantity: 7
 * Title: Book 2, Author: Bob, Quantity: 10
 * 
 * Options:
 * 1. Add Books
 * 2. Borrow Books
 * 3. Return Books
 * 4. List Books
 * 5. Exit
 * Choose an option: 2
 * Enter book title: Book 1
 * Enter quantity to borrow: 2
 * Book borrowed.
 * 
 * Options:
 * 1. Add Books
 * 2. Borrow Books
 * 3. Return Books
 * 4. List Books
 * 5. Exit
 * Choose an option: 3
 * Enter book title: Book 1
 * Enter quantity to return: 2
 * Book returned.
 * 
 * Options:
 * 1. Add Books
 * 2. Borrow Books
 * 3. Return Books
 * 4. List Books
 * 5. Exit
 * Choose an option: 4
 * Books in the library:
 * Title: Book 1, Author: Simon, Quantity: 7
 * Title: Book 2, Author: Bob, Quantity: 10
 * 
 * Options:
 * 1. Add Books
 * 2. Borrow Books
 * 3. Return Books
 * 4. List Books
 * 5. Exit
 * Choose an option: 5
 * Exiting...
 */