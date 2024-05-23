import catalog.*;

public class Main {
    public static void main(String[] args) {
        GenericCatalog<LibraryItem> catalog = new GenericCatalog<>();
        boolean running = true;

        while (running) {
            displayMenu();
            int choice = Tools.getValidatedInput("Choose an option: ", Integer.class);

            try {
                switch (choice) {
                    case 1:
                        LibraryItem book = createItem("Book");
                        catalog.addItem(book);
                        break;
                    case 2:
                        LibraryItem dvd = createItem("DVD");
                        catalog.addItem(dvd);
                        break;
                    case 3:
                        LibraryItem magazine = createItem("Magazine");
                        catalog.addItem(magazine);
                        break;
                    case 4:
                        int idToRemove = Tools.getValidatedInput("Enter item ID to remove: ", Integer.class);
                        catalog.removeItem(idToRemove);
                        break;
                    case 5:
                        catalog.printCatalog();
                        break;
                    case 6:
                        String titleToSearch = Tools.getValidatedInput("Enter title to search: ", String.class);
                        searchByTitle(catalog, titleToSearch);
                        break;
                    case 7:
                        running = false;
                        break;
                    default:
                        System.out.println("Invalid option. Please try again.");
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        Tools.closeScanner();
    }

    private static void displayMenu() {
        System.out.println("Library Catalog Menu:");
        System.out.println("1. Add Book");
        System.out.println("2. Add DVD");
        System.out.println("3. Add Magazine");
        System.out.println("4. Remove Item");
        System.out.println("5. View Catalog");
        System.out.println("6. Search by Title");
        System.out.println("7. Exit");
    }

    private static LibraryItem createItem(String itemType) {
        int id = Tools.getValidatedInput("Enter " + itemType + " ID: ", Integer.class);
        String title = Tools.getValidatedInput("Enter " + itemType + " title: ", String.class);
        String author = Tools.getValidatedInput("Enter " + itemType + " author: ", String.class);
        int publishedYear = Tools.getValidatedInput("Enter " + itemType + " published year: ", Integer.class);
        String genre = Tools.getValidatedInput("Enter " + itemType + " genre: ", String.class);

        switch (itemType) {
            case "Book":
                int pages = Tools.getValidatedInput("Enter number of pages: ", Integer.class);
                return new Book(id, title, author, publishedYear, genre, pages);
            case "DVD":
                int duration = Tools.getValidatedInput("Enter duration in minutes: ", Integer.class);
                return new DVD(id, title, author, publishedYear, genre, duration);
            case "Magazine":
                int issueNumber = Tools.getValidatedInput("Enter issue number: ", Integer.class);
                return new Magazine(id, title, author, publishedYear, genre, issueNumber);
            default:
                throw new IllegalArgumentException("Unsupported item type.");
        }
    }

    private static void searchByTitle(GenericCatalog<LibraryItem> catalog, String title) {
        LibraryItem foundItem = catalog.getItems().stream()
                .filter(item -> item.getTitle().equalsIgnoreCase(title))
                .findFirst()
                .orElse(null);
        if (foundItem != null) {
            System.out.println("Item found: " + foundItem);
        } else {
            System.out.println("Item with title \"" + title + "\" not found.");
        }
    }
}
