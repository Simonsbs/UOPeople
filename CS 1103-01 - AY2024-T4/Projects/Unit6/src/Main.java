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
                        LibraryItem book = createItem(ItemType.BOOK);
                        catalog.addItem(book);
                        break;
                    case 2:
                        LibraryItem dvd = createItem(ItemType.DVD);
                        catalog.addItem(dvd);
                        break;
                    case 3:
                        LibraryItem magazine = createItem(ItemType.MAGAZINE);
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
                        Tools.loadTestData(catalog, "testdata.txt");
                        break;
                    case 8:
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
        System.out.println("------------------------------");
        System.out.println("Sci-Fi Library Catalog Menu:");
        System.out.println("1. Add Book");
        System.out.println("2. Add DVD");
        System.out.println("3. Add Magazine");
        System.out.println("4. Remove Item");
        System.out.println("5. View Catalog");
        System.out.println("6. Search by Title");
        System.out.println("7. Load Test Data");
        System.out.println("8. Exit");
        System.out.println("------------------------------");
    }

    /**
     * Creates a library item based on the specified type.
     *
     * @param itemType The type of item to create (BOOK, DVD, MAGAZINE).
     * @return The created library item.
     */
    private static LibraryItem createItem(ItemType itemType) {
        int id = Tools.getValidatedInput(String.format("Enter %s ID: ", itemType.name()), Integer.class);
        String title = Tools.getValidatedInput(String.format("Enter %s title: ", itemType.name()), String.class);
        String author = Tools.getValidatedInput(String.format("Enter %s author: ", itemType.name()), String.class);
        int publishedYear = Tools.getValidatedInput(String.format("Enter %s published year: ", itemType.name()),
                Integer.class);
        String genre = Tools.getValidatedInput(String.format("Enter %s genre: ", itemType.name()), String.class);

        switch (itemType) {
            case BOOK:
                int pages = Tools.getValidatedInput("Enter number of pages: ", Integer.class);
                return new Book(id, title, author, publishedYear, genre, pages);
            case DVD:
                int duration = Tools.getValidatedInput("Enter duration in minutes: ", Integer.class);
                return new DVD(id, title, author, publishedYear, genre, duration);
            case MAGAZINE:
                int issueNumber = Tools.getValidatedInput("Enter issue number: ", Integer.class);
                return new Magazine(id, title, author, publishedYear, genre, issueNumber);
            default:
                throw new IllegalArgumentException("Unsupported item type.");
        }
    }

    /**
     * Searches the catalog for an item by its title.
     *
     * @param catalog The catalog to search.
     * @param title   The title of the item to search for.
     */
    private static void searchByTitle(GenericCatalog<LibraryItem> catalog, String title) {
        LibraryItem foundItem = catalog.getItems().stream()
                .filter(item -> item.getTitle().equalsIgnoreCase(title))
                .findFirst()
                .orElse(null);
        if (foundItem != null) {
            System.out.println(String.format("Item found: \n%s", foundItem));
        } else {
            System.out.println(String.format("Item with title \"%s\" not found.", title));
        }
    }
}
