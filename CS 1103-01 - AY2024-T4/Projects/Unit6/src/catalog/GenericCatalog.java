package catalog;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a generic catalog for storing library items.
 *
 * @param <T> The type of LibraryItem stored in the catalog.
 */
public class GenericCatalog<T extends LibraryItem> {
    private List<T> catalog;

    public GenericCatalog() {
        this.catalog = new ArrayList<>();
    }

    /**
     * Adds an item to the catalog.
     *
     * @param item The item to add.
     */
    public void addItem(T item) {
        if (catalog.stream().anyMatch(existingItem -> existingItem.getID() == item.getID())) {
            throw new CustomExceptions.ItemAlreadyExistsException(
                    String.format("Item with ID %d already exists in the catalog.", item.getID()));
        }
        catalog.add(item);
        System.out.println(String.format("%s added to the library catalog.", item.getTitle()));
    }

    /**
     * Removes an item from the catalog by its ID.
     *
     * @param itemID The ID of the item to remove.
     */
    public void removeItem(int itemID) {
        T item = catalog.stream()
                .filter(existingItem -> existingItem.getID() == itemID)
                .findFirst()
                .orElseThrow(() -> new CustomExceptions.ItemNotFoundException(
                        String.format("Item with ID %d not found in the catalog.", itemID)));
        catalog.remove(item);
        System.out.println(String.format("%s removed from the library catalog.", item.getTitle()));
    }

    /**
     * Retrieves an item from the catalog by its ID.
     *
     * @param itemID The ID of the item to retrieve.
     * @return The item with the specified ID.
     */
    public T getItem(int itemID) {
        return catalog.stream()
                .filter(item -> item.getID() == itemID)
                .findFirst()
                .orElseThrow(() -> new CustomExceptions.ItemNotFoundException(
                        String.format("Item with ID %d not found in the catalog.", itemID)));
    }

    /**
     * Returns all items in the catalog.
     *
     * @return A list of all items in the catalog.
     */
    public List<T> getItems() {
        return catalog;
    }

    /**
     * Prints the contents of the catalog.
     */
    public void printCatalog() {
        if (catalog.isEmpty()) {
            System.out.println("No items in the catalog.");
        } else {
            System.out.println("Catalog Items:");
            catalog.forEach(item -> System.out.println(String.format("-> %s", item)));
        }
    }
}
